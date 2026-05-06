package org.dawnoftime.armoroftheages.networking;

import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import org.dawnoftime.armoroftheages.networking.packets.DisablePreferencesPayload;
import org.dawnoftime.armoroftheages.networking.packets.DisableSkinSyncPayload;
import org.dawnoftime.armoroftheages.networking.packets.GlobalPreferenceSyncPayload;
import org.dawnoftime.armoroftheages.networking.packets.GlobalSkinSyncPayload;
import org.dawnoftime.armoroftheages.networking.packets.PatronTierPayload;
import org.dawnoftime.armoroftheages.networking.packets.PreferenceSyncPayload;
import org.dawnoftime.armoroftheages.networking.packets.SkinSyncPayload;

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

        registrar.playToServer(
            SkinSyncPayload.TYPE,
            SkinSyncPayload.STREAM_CODEC,
            NeoForgePacketHandlers::handleSkinSync
        );

        registrar.playToServer(
            DisableSkinSyncPayload.TYPE,
            DisableSkinSyncPayload.STREAM_CODEC,
            NeoForgePacketHandlers::handleDisableSkinSync
        );

        // Server to Client packets
        registrar.playToClient(
            GlobalPreferenceSyncPayload.TYPE,
            GlobalPreferenceSyncPayload.STREAM_CODEC,
            NeoForgePacketHandlers::handleGlobalPreferenceSync
        );

        registrar.playToClient(
            GlobalSkinSyncPayload.TYPE,
            GlobalSkinSyncPayload.STREAM_CODEC,
            NeoForgePacketHandlers::handleGlobalSkinSync
        );

        registrar.playToClient(
            PatronTierPayload.TYPE,
            PatronTierPayload.STREAM_CODEC,
            NeoForgePacketHandlers::handlePatronTierSync
        );
    }
}