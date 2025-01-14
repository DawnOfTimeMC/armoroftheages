package org.dawnoftime.armoroftheages.networking;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;
import org.dawnoftime.armoroftheages.config.PreferredModel;

import java.util.HashMap;
import java.util.UUID;
import java.util.function.Supplier;

class GlobalPreferenceSyncPacketHandler {
    private final ForgeConfigSyncNetworkHandler forgeConfigSyncNetworkHandler;
    private HashMap<UUID, PreferredModel> map;

    public GlobalPreferenceSyncPacketHandler(ForgeConfigSyncNetworkHandler forgeConfigSyncNetworkHandler, HashMap<UUID, PreferredModel> map) {
        this.forgeConfigSyncNetworkHandler = forgeConfigSyncNetworkHandler;
        this.map = map;
    }

    public void encoder(FriendlyByteBuf buffer) {
        buffer.writeInt(map.size());
        map.forEach((uuid, model) -> {
            buffer.writeUUID(uuid);
            buffer.writeEnum(model);
        });
    }

    public static GlobalPreferenceSyncPacketHandler decoder(ForgeConfigSyncNetworkHandler handler, FriendlyByteBuf buffer) {
        var map = new HashMap<UUID, PreferredModel>();
        int size = buffer.readInt();
        for (int i = 0; i < size; i++) {
            map.put(buffer.readUUID(), buffer.readEnum(PreferredModel.class));
        }
        return new GlobalPreferenceSyncPacketHandler(handler, map);
    }

    public void messageConsumer(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            forgeConfigSyncNetworkHandler.mapHandler.accept(map);
        });
        ctx.get().setPacketHandled(true);
    }
}
