package org.dawnoftime.armoroftheages.networking;

import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;
import org.dawnoftime.armoroftheages.Constants;
import org.dawnoftime.armoroftheages.config.AOTAConfig;
import org.dawnoftime.armoroftheages.config.PreferredModel;
import org.dawnoftime.armoroftheages.config.SkinSyncState;

import java.util.HashMap;
import java.util.UUID;
import java.util.function.Consumer;

public class ForgeConfigSyncNetworkHandler implements ConfigSyncNetworkHandler {
    public final HashMap<UUID, PreferredModel> CURRENT_SERVER_STATE = new HashMap<>();
    public Consumer<HashMap<UUID, PreferredModel>> mapHandler = null;

    public final HashMap<UUID, SkinSyncState> CURRENT_SKIN_STATE = new HashMap<>();
    public Consumer<HashMap<UUID, SkinSyncState>> skinMapHandler = null;

    private static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
            ResourceLocation.tryBuild(Constants.MOD_ID, "config_sync"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals
    );

    private int id = 0;

    @Override
    public void syncConfig() {
        if (Minecraft.getInstance().getConnection() != null) {
            if (!AOTAConfig.get().usePreferredModel) {
                INSTANCE.sendToServer(new DisabledPreferencesPacketHandler(this));
            } else {
                INSTANCE.sendToServer(new PreferenceSyncPacketHandler(this, AOTAConfig.get().preferredModel));
            }
            if (!AOTAConfig.get().shareSkins) {
                INSTANCE.sendToServer(new DisabledSkinSyncPacketHandler(this));
            } else {
                INSTANCE.sendToServer(new SkinSyncPacketHandler(this,
                    new SkinSyncState(AOTAConfig.get().oYoroiSkin, AOTAConfig.get().ironPlateSkin, AOTAConfig.get().centurionSkin, AOTAConfig.get().raijinSkin, AOTAConfig.get().pharaohSkin)));
            }
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
        INSTANCE.messageBuilder(DisabledPreferencesPacketHandler.class, id++)
                .encoder(DisabledPreferencesPacketHandler::encoder)
                .decoder(friendlyByteBuf -> DisabledPreferencesPacketHandler.decoder(this, friendlyByteBuf))
                .consumerMainThread(DisabledPreferencesPacketHandler::messageConsumer)
                .add();

        INSTANCE.messageBuilder(PreferenceSyncPacketHandler.class, id++)
                .encoder(PreferenceSyncPacketHandler::encoder)
                .decoder(friendlyByteBuf -> PreferenceSyncPacketHandler.decoder(this, friendlyByteBuf))
                .consumerMainThread(PreferenceSyncPacketHandler::messageConsumer)
                .add();

        INSTANCE.messageBuilder(GlobalPreferenceSyncPacketHandler.class, id++)
                .encoder(GlobalPreferenceSyncPacketHandler::encoder)
                .decoder(friendlyByteBuf -> GlobalPreferenceSyncPacketHandler.decoder(this, friendlyByteBuf))
                .consumerMainThread(GlobalPreferenceSyncPacketHandler::messageConsumer)
                .add();

        INSTANCE.messageBuilder(SkinSyncPacketHandler.class, id++)
                .encoder(SkinSyncPacketHandler::encoder)
                .decoder(friendlyByteBuf -> SkinSyncPacketHandler.decoder(this, friendlyByteBuf))
                .consumerMainThread(SkinSyncPacketHandler::messageConsumer)
                .add();

        INSTANCE.messageBuilder(DisabledSkinSyncPacketHandler.class, id++)
                .encoder(DisabledSkinSyncPacketHandler::encoder)
                .decoder(friendlyByteBuf -> DisabledSkinSyncPacketHandler.decoder(this, friendlyByteBuf))
                .consumerMainThread(DisabledSkinSyncPacketHandler::messageConsumer)
                .add();

        INSTANCE.messageBuilder(GlobalSkinSyncPacketHandler.class, id++)
                .encoder(GlobalSkinSyncPacketHandler::encoder)
                .decoder(friendlyByteBuf -> GlobalSkinSyncPacketHandler.decoder(this, friendlyByteBuf))
                .consumerMainThread(GlobalSkinSyncPacketHandler::messageConsumer)
                .add();
    }

    void globalSync(MinecraftServer server) {
        for (ServerPlayer serverPlayer : server.getPlayerList().getPlayers()) {
            INSTANCE.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new GlobalPreferenceSyncPacketHandler(this, CURRENT_SERVER_STATE));
        }
    }

    void globalSkinSync(MinecraftServer server) {
        for (ServerPlayer serverPlayer : server.getPlayerList().getPlayers()) {
            INSTANCE.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new GlobalSkinSyncPacketHandler(this, CURRENT_SKIN_STATE));
        }
    }
}