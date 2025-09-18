package org.dawnoftime.armoroftheages.networking;

import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import org.dawnoftime.armoroftheages.networking.packets.DisablePreferencesPayload;
import org.dawnoftime.armoroftheages.networking.packets.GlobalPreferenceSyncPayload;
import org.dawnoftime.armoroftheages.networking.packets.PreferenceSyncPayload;

public class NeoForgePayloadRegistry {
    
    public static void register(final RegisterPayloadHandlersEvent event) {
        final PayloadRegistrar registrar = event.registrar("1");
        
        // Client to Server packets
        registrar.playToServer(
            PreferenceSyncPayload.TYPE,
            PreferenceSyncPayload.STREAM_CODEC,
            NeoForgePacketHandlers::handlePreferenceSync
        );
        
        registrar.playToServer(
            DisablePreferencesPayload.TYPE,
            DisablePreferencesPayload.STREAM_CODEC,
            NeoForgePacketHandlers::handleDisablePreferences
        );
        
        // Server to Client packets
        registrar.playToClient(
            GlobalPreferenceSyncPayload.TYPE,
            GlobalPreferenceSyncPayload.STREAM_CODEC,
            NeoForgePacketHandlers::handleGlobalPreferenceSync
        );
    }
}