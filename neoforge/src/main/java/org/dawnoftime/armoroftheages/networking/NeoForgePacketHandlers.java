package org.dawnoftime.armoroftheages.networking;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.dawnoftime.armoroftheages.CommonClass;
import org.dawnoftime.armoroftheages.networking.packets.DisablePreferencesPayload;
import org.dawnoftime.armoroftheages.networking.packets.GlobalPreferenceSyncPayload;
import org.dawnoftime.armoroftheages.networking.packets.PreferenceSyncPayload;

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
}