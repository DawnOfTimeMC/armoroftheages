package org.dawnoftime.armoroftheages.networking;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.dawnoftime.armoroftheages.CommonClass;
import org.dawnoftime.armoroftheages.client.patreon.ClientPatronState;
import org.dawnoftime.armoroftheages.networking.packets.DisablePreferencesPayload;
import org.dawnoftime.armoroftheages.networking.packets.DisableSkinSyncPayload;
import org.dawnoftime.armoroftheages.networking.packets.GlobalPreferenceSyncPayload;
import org.dawnoftime.armoroftheages.networking.packets.GlobalSkinSyncPayload;
import org.dawnoftime.armoroftheages.networking.packets.PatronTierPayload;
import org.dawnoftime.armoroftheages.networking.packets.PreferenceSyncPayload;
import org.dawnoftime.armoroftheages.networking.packets.SkinSyncPayload;

import java.util.HashMap;

public class NeoForgePacketHandlers {
    
    public static void handlePreferenceSync(final PreferenceSyncPayload payload, final IPayloadContext context) {
        context.enqueueWork(() -> {
            if (CommonClass.CONFIG_SYNC_HANDLER instanceof ForgeConfigSyncNetworkHandler handler) {
                handler.CURRENT_SERVER_STATE.put(context.player().getUUID(), payload.preferredModel());
                handler.globalSync(context.player().getServer());
            }
        });
    }
    
    public static void handleDisablePreferences(final DisablePreferencesPayload payload, final IPayloadContext context) {
        context.enqueueWork(() -> {
            if (CommonClass.CONFIG_SYNC_HANDLER instanceof ForgeConfigSyncNetworkHandler handler) {
                handler.CURRENT_SERVER_STATE.remove(context.player().getUUID());
                handler.globalSync(context.player().getServer());
            }
        });
    }
    
    public static void handleGlobalPreferenceSync(final GlobalPreferenceSyncPayload payload, final IPayloadContext context) {
        context.enqueueWork(() -> {
            if (CommonClass.CONFIG_SYNC_HANDLER instanceof ForgeConfigSyncNetworkHandler handler && handler.mapHandler != null) {
                handler.mapHandler.accept(new HashMap<>(payload.preferences()));
            }
        });
    }

    public static void handleSkinSync(final SkinSyncPayload payload, final IPayloadContext context) {
        context.enqueueWork(() -> {
            if (CommonClass.CONFIG_SYNC_HANDLER instanceof ForgeConfigSyncNetworkHandler handler) {
                handler.CURRENT_SKIN_STATE.put(context.player().getUUID(), payload.state());
                handler.globalSkinSync(context.player().getServer());
            }
        });
    }

    public static void handleDisableSkinSync(final DisableSkinSyncPayload payload, final IPayloadContext context) {
        context.enqueueWork(() -> {
            if (CommonClass.CONFIG_SYNC_HANDLER instanceof ForgeConfigSyncNetworkHandler handler) {
                handler.CURRENT_SKIN_STATE.remove(context.player().getUUID());
                handler.globalSkinSync(context.player().getServer());
            }
        });
    }

    public static void handleGlobalSkinSync(final GlobalSkinSyncPayload payload, final IPayloadContext context) {
        context.enqueueWork(() -> {
            if (CommonClass.CONFIG_SYNC_HANDLER instanceof ForgeConfigSyncNetworkHandler handler && handler.skinMapHandler != null) {
                handler.skinMapHandler.accept(new HashMap<>(payload.skins()));
            }
        });
    }

    public static void handlePatronTierSync(final PatronTierPayload payload, final IPayloadContext context) {
        context.enqueueWork(() -> ClientPatronState.playerTier = payload.tier());
    }
}