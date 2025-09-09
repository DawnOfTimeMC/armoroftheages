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
import org.dawnoftime.armoroftheages.config.PreferredModel;

import java.util.HashMap;
import java.util.UUID;
import java.util.function.Consumer;

public class FabricConfigSyncNetworkHandler implements ConfigSyncNetworkHandler {
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
            // Send remove from map packet.
            ClientPlayNetworking.send(ResourceLocation.tryBuild(Constants.MOD_ID, "disable_preferences"), PacketByteBufs.empty());
        }

        var buf = PacketByteBufs.create();
        buf.writeEnum(AOTAConfig.get().preferredModel);
        ClientPlayNetworking.send(ResourceLocation.tryBuild(Constants.MOD_ID, "preference_sync"), buf);
    }

    @Override
    public void registerHandler(Consumer<HashMap<UUID, PreferredModel>> handler) {
        mapHandler = handler;
    }

    @Override
    public void setup() {
        if (FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT) {
            ClientPlayNetworking.registerGlobalReceiver(ResourceLocation.tryBuild(Constants.MOD_ID, "global_preference_sync"), (client, handler, buf, responseSender) -> {
                // Load map from buf.
                var map = new HashMap<UUID, PreferredModel>();
                int size = buf.readInt();
                for (int i = 0; i < size; i++) {
                    map.put(buf.readUUID(), buf.readEnum(PreferredModel.class));
                }
                mapHandler.accept(map);
            });
        }

        ServerPlayNetworking.registerGlobalReceiver(ResourceLocation.tryBuild(Constants.MOD_ID, "preference_sync"), (server, player, handler, buf, responseSender) -> {
            // Load preferred model from buf.
            PreferredModel preferredModel = buf.readEnum(PreferredModel.class);
            CURRENT_SERVER_STATE.put(player.getUUID(), preferredModel);

            // Send the map to all players.
            globalSync(server);
        });

        ServerPlayNetworking.registerGlobalReceiver(ResourceLocation.tryBuild(Constants.MOD_ID, "disable_preferences"), (server, player, handler, buf, responseSender) -> {
            CURRENT_SERVER_STATE.remove(player.getUUID());

            // Send updated map to all players.
            globalSync(server);
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
}
