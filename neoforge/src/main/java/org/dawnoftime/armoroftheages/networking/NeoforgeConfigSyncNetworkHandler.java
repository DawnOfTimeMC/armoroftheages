package org.dawnoftime.armoroftheages.networking;

import net.minecraft.client.Minecraft;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.dawnoftime.armoroftheages.config.AOTAConfig;
import org.dawnoftime.armoroftheages.config.PreferredModel;
import org.dawnoftime.armoroftheages.networking.packets.C2SDisablePreferencesPacket;
import org.dawnoftime.armoroftheages.networking.packets.C2SPreferenceSyncPacket;
import org.dawnoftime.armoroftheages.networking.packets.S2CPreferenceSyncPacket;

import java.util.HashMap;
import java.util.UUID;
import java.util.function.Consumer;

public class NeoforgeConfigSyncNetworkHandler implements ConfigSyncNetworkHandler {
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
            PacketDistributor.sendToServer(new C2SDisablePreferencesPacket());
        } else {
            PacketDistributor.sendToServer(new C2SPreferenceSyncPacket(AOTAConfig.get().preferredModel));
        }
    }

    @Override
    public void registerHandler(Consumer<HashMap<UUID, PreferredModel>> handler) {
        this.mapHandler = handler;
    }

    @Override
    public void setup() {
        // Ignored. Nothing needs to be done here since it's done in the main neoforge networking register event.
    }

    public void handle(S2CPreferenceSyncPacket packet, IPayloadContext context) {
        context.enqueueWork(() -> {
            mapHandler.accept(new HashMap<>(packet.modelHashMap()));
        });
    }

    public void handle(C2SPreferenceSyncPacket packet, IPayloadContext context) {
        context.enqueueWork(() -> {
            CURRENT_SERVER_STATE.put(context.player().getUUID(), packet.preferredModel());
            globalSync();
        });
    }

    public void handle(C2SDisablePreferencesPacket packet, IPayloadContext context) {
        context.enqueueWork(() -> {
            CURRENT_SERVER_STATE.remove(context.player().getUUID());
            globalSync();
        });
    }

    private void globalSync() {
        PacketDistributor.sendToAllPlayers(new S2CPreferenceSyncPacket(CURRENT_SERVER_STATE));
    }
}