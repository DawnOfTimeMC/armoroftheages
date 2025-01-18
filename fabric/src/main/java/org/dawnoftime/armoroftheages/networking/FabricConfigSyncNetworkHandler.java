package org.dawnoftime.armoroftheages.networking;

import net.fabricmc.api.EnvType;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.Minecraft;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import org.dawnoftime.armoroftheages.config.AOTAConfig;
import org.dawnoftime.armoroftheages.config.PreferredModel;
import org.dawnoftime.armoroftheages.networking.packets.C2SDisablePreferencesPacket;
import org.dawnoftime.armoroftheages.networking.packets.C2SPreferenceSyncPacket;
import org.dawnoftime.armoroftheages.networking.packets.S2CPreferenceSyncPacket;

import java.util.HashMap;
import java.util.UUID;
import java.util.function.Consumer;

public class FabricConfigSyncNetworkHandler implements ConfigSyncNetworkHandler {
    private final HashMap<UUID, PreferredModel> CURRENT_SERVER_STATE = new HashMap<>();
    private Consumer<HashMap<UUID, PreferredModel>> mapHandler = null;

    @Override
    public void syncConfig() {
        try {
            if (Minecraft.getInstance().level == null) return;
        } catch (Exception ignored) {
            // Fail silently on server-side.
            return;
        }

        if (!AOTAConfig.get().usePreferredModel) {
            // Send remove from map packet.
            ClientPlayNetworking.send(new C2SDisablePreferencesPacket());
        } else {
            ClientPlayNetworking.send(new C2SPreferenceSyncPacket(AOTAConfig.get().preferredModel));
        }
    }

    @Override
    public void registerHandler(Consumer<HashMap<UUID, PreferredModel>> handler) {
        mapHandler = handler;
    }

    @Override
    public void setup() {
        PayloadTypeRegistry.playC2S().register(C2SPreferenceSyncPacket.TYPE, C2SPreferenceSyncPacket.STREAM_CODEC);
        PayloadTypeRegistry.playC2S().register(C2SDisablePreferencesPacket.TYPE, StreamCodec.unit(new C2SDisablePreferencesPacket()));
        PayloadTypeRegistry.playS2C().register(S2CPreferenceSyncPacket.TYPE, S2CPreferenceSyncPacket.STREAM_CODEC);

        if (FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT) {
            ClientPlayNetworking.registerGlobalReceiver(S2CPreferenceSyncPacket.TYPE, (packet, context) -> {
                // Load map from buf.
                mapHandler.accept(new HashMap<>(packet.modelHashMap()));
            });
        }

        ServerPlayNetworking.registerGlobalReceiver(C2SPreferenceSyncPacket.TYPE, (packet, context) -> {
            // Load preferred model from buf.
            CURRENT_SERVER_STATE.put(context.player().getUUID(), packet.preferredModel());

            // Send the map to all players.
            globalSync(context.server());
        });

        ServerPlayNetworking.registerGlobalReceiver(C2SDisablePreferencesPacket.TYPE, (packet, context) -> {
            CURRENT_SERVER_STATE.remove(context.player().getUUID());

            // Send updated map to all players.
            globalSync(context.server());
        });
    }

    private void globalSync(MinecraftServer server) {
        for (ServerPlayer serverPlayer : PlayerLookup.all(server)) {
            ServerPlayNetworking.send(serverPlayer, new S2CPreferenceSyncPacket(CURRENT_SERVER_STATE));
        }
    }
}