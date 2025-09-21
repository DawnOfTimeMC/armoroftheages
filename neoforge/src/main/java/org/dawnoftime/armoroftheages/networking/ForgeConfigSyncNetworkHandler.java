package org.dawnoftime.armoroftheages.networking;

import net.minecraft.client.Minecraft;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.PacketDistributor;
import org.dawnoftime.armoroftheages.config.AOTAConfig;
import org.dawnoftime.armoroftheages.config.PreferredModel;
import org.dawnoftime.armoroftheages.networking.packets.DisablePreferencesPayload;
import org.dawnoftime.armoroftheages.networking.packets.GlobalPreferenceSyncPayload;
import org.dawnoftime.armoroftheages.networking.packets.PreferenceSyncPayload;

import java.util.HashMap;
import java.util.UUID;
import java.util.function.Consumer;

public class ForgeConfigSyncNetworkHandler implements ConfigSyncNetworkHandler {
    public final HashMap<UUID, PreferredModel> CURRENT_SERVER_STATE = new HashMap<>();
    public Consumer<HashMap<UUID, PreferredModel>> mapHandler = null;

    @Override
    public void syncConfig() {
        if (Minecraft.getInstance().getConnection() != null) {
            if (!AOTAConfig.get().usePreferredModel) {
                PacketDistributor.sendToServer(new DisablePreferencesPayload());
            } else {
                PacketDistributor.sendToServer(new PreferenceSyncPayload(AOTAConfig.get().preferredModel));
            }
        }
    }

    @Override
    public void registerHandler(Consumer<HashMap<UUID, PreferredModel>> handler) {
        this.mapHandler = handler;
    }

    @Override
    public void setup() {
    }

    public void globalSync(MinecraftServer server) {
        if (server == null) return;
        
        GlobalPreferenceSyncPayload payload = new GlobalPreferenceSyncPayload(new HashMap<>(CURRENT_SERVER_STATE));
        
        for (ServerPlayer serverPlayer : server.getPlayerList().getPlayers()) {
            try {
                PacketDistributor.sendToPlayer(serverPlayer, payload);
            } catch (Exception ignored) {

            }
        }
    }
}
