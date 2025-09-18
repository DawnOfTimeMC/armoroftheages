package org.dawnoftime.armoroftheages.networking;

import net.fabricmc.api.EnvType;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.Minecraft;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import org.dawnoftime.armoroftheages.config.AOTAConfig;
import org.dawnoftime.armoroftheages.config.PreferredModel;
import org.dawnoftime.armoroftheages.networking.packets.DisablePreferencesPayload;
import org.dawnoftime.armoroftheages.networking.packets.GlobalPreferenceSyncPayload;
import org.dawnoftime.armoroftheages.networking.packets.PreferenceSyncPayload;

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
            return;
        }

        if (!AOTAConfig.get().usePreferredModel) {
            ClientPlayNetworking.send(new DisablePreferencesPayload());
        } else {
            ClientPlayNetworking.send(new PreferenceSyncPayload(AOTAConfig.get().preferredModel));
        }
    }

    @Override
    public void registerHandler(Consumer<HashMap<UUID, PreferredModel>> handler) {
        mapHandler = handler;
    }

    @Override
    public void setup() {
        PayloadTypeRegistry.playS2C().register(GlobalPreferenceSyncPayload.TYPE, GlobalPreferenceSyncPayload.STREAM_CODEC);
        PayloadTypeRegistry.playC2S().register(PreferenceSyncPayload.TYPE, PreferenceSyncPayload.STREAM_CODEC);
        PayloadTypeRegistry.playC2S().register(DisablePreferencesPayload.TYPE, DisablePreferencesPayload.STREAM_CODEC);
        
        if (FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT) {
            ClientPlayNetworking.registerGlobalReceiver(GlobalPreferenceSyncPayload.TYPE, (payload, context) -> {
                if (mapHandler != null) {
                    mapHandler.accept(new HashMap<>(payload.preferences()));
                }
            });
        }

        ServerPlayNetworking.registerGlobalReceiver(PreferenceSyncPayload.TYPE, (payload, context) -> {
            CURRENT_SERVER_STATE.put(context.player().getUUID(), payload.preferredModel());
            globalSync(context.player().getServer());
        });

        ServerPlayNetworking.registerGlobalReceiver(DisablePreferencesPayload.TYPE, (payload, context) -> {
            CURRENT_SERVER_STATE.remove(context.player().getUUID());
            globalSync(context.player().getServer());
        });
    }

    private void globalSync(MinecraftServer server) {
        if (server == null) return;
        
        GlobalPreferenceSyncPayload payload = new GlobalPreferenceSyncPayload(new HashMap<>(CURRENT_SERVER_STATE));
        
        for (ServerPlayer serverPlayer : server.getPlayerList().getPlayers()) {
            if (ServerPlayNetworking.canSend(serverPlayer, GlobalPreferenceSyncPayload.TYPE)) {
                ServerPlayNetworking.send(serverPlayer, payload);
            }
        }
    }
}
