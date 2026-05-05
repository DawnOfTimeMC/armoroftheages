package org.dawnoftime.armoroftheages.networking;

import net.fabricmc.api.EnvType;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import org.dawnoftime.armoroftheages.Constants;
import org.dawnoftime.armoroftheages.config.AOTAConfig;
import org.dawnoftime.armoroftheages.config.CenturionSkin;
import org.dawnoftime.armoroftheages.config.IronPlateSkin;
import org.dawnoftime.armoroftheages.config.OYoroiSkin;
import org.dawnoftime.armoroftheages.config.PharaohSkin;
import org.dawnoftime.armoroftheages.config.PreferredModel;
import org.dawnoftime.armoroftheages.config.RaijinSkin;
import org.dawnoftime.armoroftheages.config.SkinSyncState;

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
            // Fail silently on server-side.
            return;
        }

        if (!AOTAConfig.get().usePreferredModel) {
            // Send remove from map packet.
            ClientPlayNetworking.send(ResourceLocation.tryBuild(Constants.MOD_ID, "disable_preferences"), PacketByteBufs.empty());
        }

        var buf = PacketByteBufs.create();
        buf.writeEnum(AOTAConfig.get().preferredModel);
        ClientPlayNetworking.send(ResourceLocation.tryBuild(Constants.MOD_ID, "preference_sync"), buf);

        if (!AOTAConfig.get().shareSkins) {
            ClientPlayNetworking.send(ResourceLocation.tryBuild(Constants.MOD_ID, "disable_skin_sync"), PacketByteBufs.empty());
        } else {
            var skinBuf = PacketByteBufs.create();
            skinBuf.writeEnum(AOTAConfig.get().oYoroiSkin);
            skinBuf.writeEnum(AOTAConfig.get().ironPlateSkin);
            skinBuf.writeEnum(AOTAConfig.get().centurionSkin);
            skinBuf.writeEnum(AOTAConfig.get().raijinSkin);
            skinBuf.writeEnum(AOTAConfig.get().pharaohSkin);
            ClientPlayNetworking.send(ResourceLocation.tryBuild(Constants.MOD_ID, "skin_sync"), skinBuf);
        }
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
        if (FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT) {
            ClientPlayNetworking.registerGlobalReceiver(ResourceLocation.tryBuild(Constants.MOD_ID, "global_preference_sync"), (client, handler, buf, responseSender) -> {
                var map = new HashMap<UUID, PreferredModel>();
                int size = buf.readInt();
                for (int i = 0; i < size; i++) {
                    map.put(buf.readUUID(), buf.readEnum(PreferredModel.class));
                }
                mapHandler.accept(map);
            });

            ClientPlayNetworking.registerGlobalReceiver(ResourceLocation.tryBuild(Constants.MOD_ID, "global_skin_sync"), (client, handler, buf, responseSender) -> {
                var map = new HashMap<UUID, SkinSyncState>();
                int size = buf.readInt();
                for (int i = 0; i < size; i++) {
                    map.put(buf.readUUID(),
                        new SkinSyncState(buf.readEnum(OYoroiSkin.class), buf.readEnum(IronPlateSkin.class), buf.readEnum(CenturionSkin.class), buf.readEnum(RaijinSkin.class), buf.readEnum(PharaohSkin.class)));
                }
                skinMapHandler.accept(map);
            });
        }

        ServerPlayNetworking.registerGlobalReceiver(ResourceLocation.tryBuild(Constants.MOD_ID, "preference_sync"), (server, player, handler, buf, responseSender) -> {
            PreferredModel preferredModel = buf.readEnum(PreferredModel.class);
            CURRENT_SERVER_STATE.put(player.getUUID(), preferredModel);
            globalSync(server);
        });

        ServerPlayNetworking.registerGlobalReceiver(ResourceLocation.tryBuild(Constants.MOD_ID, "disable_preferences"), (server, player, handler, buf, responseSender) -> {
            CURRENT_SERVER_STATE.remove(player.getUUID());
            globalSync(server);
        });

        ServerPlayNetworking.registerGlobalReceiver(ResourceLocation.tryBuild(Constants.MOD_ID, "skin_sync"), (server, player, handler, buf, responseSender) -> {
            SkinSyncState state = new SkinSyncState(buf.readEnum(OYoroiSkin.class), buf.readEnum(IronPlateSkin.class), buf.readEnum(CenturionSkin.class), buf.readEnum(RaijinSkin.class), buf.readEnum(PharaohSkin.class));
            CURRENT_SKIN_STATE.put(player.getUUID(), state);
            globalSkinSync(server);
        });

        ServerPlayNetworking.registerGlobalReceiver(ResourceLocation.tryBuild(Constants.MOD_ID, "disable_skin_sync"), (server, player, handler, buf, responseSender) -> {
            CURRENT_SKIN_STATE.remove(player.getUUID());
            globalSkinSync(server);
        });
    }

    private void globalSync(MinecraftServer server) {
        var responseBuf = PacketByteBufs.create();
        responseBuf.writeInt(CURRENT_SERVER_STATE.size());
        CURRENT_SERVER_STATE.forEach((uuid, model) -> {
            responseBuf.writeUUID(uuid);
            responseBuf.writeEnum(model);
        });

        for (ServerPlayer serverPlayer : server.overworld().players()) {
            ServerPlayNetworking.send(serverPlayer, ResourceLocation.tryBuild(Constants.MOD_ID, "global_preference_sync"), responseBuf);
        }
    }

    private void globalSkinSync(MinecraftServer server) {
        var responseBuf = PacketByteBufs.create();
        responseBuf.writeInt(CURRENT_SKIN_STATE.size());
        CURRENT_SKIN_STATE.forEach((uuid, state) -> {
            responseBuf.writeUUID(uuid);
            responseBuf.writeEnum(state.oYoroiSkin());
            responseBuf.writeEnum(state.ironPlateSkin());
            responseBuf.writeEnum(state.centurionSkin());
            responseBuf.writeEnum(state.raijinSkin());
            responseBuf.writeEnum(state.pharaohSkin());
        });

        for (ServerPlayer serverPlayer : server.overworld().players()) {
            ServerPlayNetworking.send(serverPlayer, ResourceLocation.tryBuild(Constants.MOD_ID, "global_skin_sync"), responseBuf);
        }
    }
}
