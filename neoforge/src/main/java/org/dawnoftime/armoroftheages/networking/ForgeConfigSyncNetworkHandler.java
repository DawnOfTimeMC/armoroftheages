package org.dawnoftime.armoroftheages.networking;

import net.minecraft.client.Minecraft;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.PacketDistributor;
import org.dawnoftime.armoroftheages.config.AOTAConfig;
import org.dawnoftime.armoroftheages.config.PreferredModel;
import org.dawnoftime.armoroftheages.config.SkinSyncState;
import org.dawnoftime.armoroftheages.networking.packets.GlobalPreferenceSyncPayload;
import org.dawnoftime.armoroftheages.networking.packets.GlobalSkinSyncPayload;
import org.dawnoftime.armoroftheages.networking.packets.PatronTierPayload;
import org.dawnoftime.armoroftheages.networking.packets.PreferenceSyncPayload;
import org.dawnoftime.armoroftheages.networking.packets.SkinSyncPayload;

import java.util.HashMap;
import java.util.UUID;
import java.util.function.Consumer;

public class ForgeConfigSyncNetworkHandler implements ConfigSyncNetworkHandler {
    public final HashMap<UUID, PreferredModel> CURRENT_SERVER_STATE = new HashMap<>();
    public Consumer<HashMap<UUID, PreferredModel>> mapHandler = null;
    public final HashMap<UUID, SkinSyncState> CURRENT_SKIN_STATE = new HashMap<>();
    public Consumer<HashMap<UUID, SkinSyncState>> skinMapHandler = null;

    @Override
    public void syncConfig() {
        if (Minecraft.getInstance().getConnection() != null) {
            PacketDistributor.sendToServer(new PreferenceSyncPayload(AOTAConfig.get().preferredModel));
            PacketDistributor.sendToServer(new SkinSyncPayload(
                new SkinSyncState(AOTAConfig.get().oYoroiSkin, AOTAConfig.get().ironPlateSkin,
                    AOTAConfig.get().centurionSkin, AOTAConfig.get().raijinSkin, AOTAConfig.get().pharaohSkin)));
        }
    }

    @Override
    public void registerHandler(Consumer<HashMap<UUID, PreferredModel>> handler) {
        this.mapHandler = handler;
    }

    @Override
    public void registerSkinHandler(Consumer<HashMap<UUID, SkinSyncState>> handler) {
        this.skinMapHandler = handler;
    }

    @Override
    public void setup() {
    }

    @Override
    public void sendPatronTierToPlayer(ServerPlayer player, int tier) {
        try {
            PacketDistributor.sendToPlayer(player, new PatronTierPayload(tier));
        } catch (Exception ignored) {
        }
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

    public void globalSkinSync(MinecraftServer server) {
        if (server == null) return;

        GlobalSkinSyncPayload payload = new GlobalSkinSyncPayload(new HashMap<>(CURRENT_SKIN_STATE));

        for (ServerPlayer serverPlayer : server.getPlayerList().getPlayers()) {
            try {
                PacketDistributor.sendToPlayer(serverPlayer, payload);
            } catch (Exception ignored) {
            }
        }
    }
}
