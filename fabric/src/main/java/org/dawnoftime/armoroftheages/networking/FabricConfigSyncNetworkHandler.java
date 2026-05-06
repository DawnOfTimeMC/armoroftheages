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
import org.dawnoftime.armoroftheages.config.SkinSyncState;
import org.dawnoftime.armoroftheages.client.patreon.ClientPatronState;
import org.dawnoftime.armoroftheages.networking.packets.DisablePreferencesPayload;
import org.dawnoftime.armoroftheages.networking.packets.DisableSkinSyncPayload;
import org.dawnoftime.armoroftheages.networking.packets.GlobalPreferenceSyncPayload;
import org.dawnoftime.armoroftheages.networking.packets.GlobalSkinSyncPayload;
import org.dawnoftime.armoroftheages.networking.packets.PatronTierPayload;
import org.dawnoftime.armoroftheages.networking.packets.PreferenceSyncPayload;
import org.dawnoftime.armoroftheages.networking.packets.SkinSyncPayload;

import java.util.HashMap;
import java.util.UUID;
import java.util.function.Consumer;

public class FabricConfigSyncNetworkHandler implements ConfigSyncNetworkHandler {
    private final HashMap<UUID, PreferredModel> CURRENT_SERVER_STATE = new HashMap<>();
    private Consumer<HashMap<UUID, PreferredModel>> mapHandler = null;
    private final HashMap<UUID, SkinSyncState> CURRENT_SKIN_STATE = new HashMap<>();
    private Consumer<HashMap<UUID, SkinSyncState>> skinMapHandler = null;

    @Override
    public void syncConfig() {
        try {
            if (Minecraft.getInstance().level == null) return;
        } catch (Exception ignored) {
            return;
        }

        ClientPlayNetworking.send(new PreferenceSyncPayload(AOTAConfig.get().preferredModel));
        ClientPlayNetworking.send(new SkinSyncPayload(
            new SkinSyncState(AOTAConfig.get().oYoroiSkin, AOTAConfig.get().ironPlateSkin,
                AOTAConfig.get().centurionSkin, AOTAConfig.get().raijinSkin, AOTAConfig.get().pharaohSkin)));
    }

    @Override
    public void registerHandler(Consumer<HashMap<UUID, PreferredModel>> handler) {
        mapHandler = handler;
    }

    @Override
    public void registerSkinHandler(Consumer<HashMap<UUID, SkinSyncState>> handler) {
        skinMapHandler = handler;
    }

    @Override
    public void setup() {
        PayloadTypeRegistry.playS2C().register(GlobalPreferenceSyncPayload.TYPE, GlobalPreferenceSyncPayload.STREAM_CODEC);
        PayloadTypeRegistry.playC2S().register(PreferenceSyncPayload.TYPE, PreferenceSyncPayload.STREAM_CODEC);
        PayloadTypeRegistry.playC2S().register(DisablePreferencesPayload.TYPE, DisablePreferencesPayload.STREAM_CODEC);
        PayloadTypeRegistry.playS2C().register(GlobalSkinSyncPayload.TYPE, GlobalSkinSyncPayload.STREAM_CODEC);
        PayloadTypeRegistry.playC2S().register(SkinSyncPayload.TYPE, SkinSyncPayload.STREAM_CODEC);
        PayloadTypeRegistry.playC2S().register(DisableSkinSyncPayload.TYPE, DisableSkinSyncPayload.STREAM_CODEC);
        PayloadTypeRegistry.playS2C().register(PatronTierPayload.TYPE, PatronTierPayload.STREAM_CODEC);

        if (FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT) {
            ClientPlayNetworking.registerGlobalReceiver(GlobalPreferenceSyncPayload.TYPE, (payload, context) -> {
                if (mapHandler != null) {
                    mapHandler.accept(new HashMap<>(payload.preferences()));
                }
            });

            ClientPlayNetworking.registerGlobalReceiver(GlobalSkinSyncPayload.TYPE, (payload, context) -> {
                if (skinMapHandler != null) {
                    skinMapHandler.accept(new HashMap<>(payload.skins()));
                }
            });

            ClientPlayNetworking.registerGlobalReceiver(PatronTierPayload.TYPE, (payload, context) ->
                ClientPatronState.playerTier = payload.tier()
            );
        }

        ServerPlayNetworking.registerGlobalReceiver(PreferenceSyncPayload.TYPE, (payload, context) -> {
            CURRENT_SERVER_STATE.put(context.player().getUUID(), payload.preferredModel());
            globalSync(context.player().getServer());
        });

        ServerPlayNetworking.registerGlobalReceiver(DisablePreferencesPayload.TYPE, (payload, context) -> {
            CURRENT_SERVER_STATE.remove(context.player().getUUID());
            globalSync(context.player().getServer());
        });

        ServerPlayNetworking.registerGlobalReceiver(SkinSyncPayload.TYPE, (payload, context) -> {
            CURRENT_SKIN_STATE.put(context.player().getUUID(), payload.state());
            globalSkinSync(context.player().getServer());
        });

        ServerPlayNetworking.registerGlobalReceiver(DisableSkinSyncPayload.TYPE, (payload, context) -> {
            CURRENT_SKIN_STATE.remove(context.player().getUUID());
            globalSkinSync(context.player().getServer());
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

    @Override
    public void sendPatronTierToPlayer(ServerPlayer player, int tier) {
        if (ServerPlayNetworking.canSend(player, PatronTierPayload.TYPE)) {
            ServerPlayNetworking.send(player, new PatronTierPayload(tier));
        }
    }

    private void globalSkinSync(MinecraftServer server) {
        if (server == null) return;

        GlobalSkinSyncPayload payload = new GlobalSkinSyncPayload(new HashMap<>(CURRENT_SKIN_STATE));

        for (ServerPlayer serverPlayer : server.getPlayerList().getPlayers()) {
            if (ServerPlayNetworking.canSend(serverPlayer, GlobalSkinSyncPayload.TYPE)) {
                ServerPlayNetworking.send(serverPlayer, payload);
            }
        }
    }
}
