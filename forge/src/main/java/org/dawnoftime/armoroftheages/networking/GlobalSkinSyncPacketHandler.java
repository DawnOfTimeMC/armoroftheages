package org.dawnoftime.armoroftheages.networking;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;
import org.dawnoftime.armoroftheages.config.CenturionSkin;
import org.dawnoftime.armoroftheages.config.IronPlateSkin;
import org.dawnoftime.armoroftheages.config.OYoroiSkin;
import org.dawnoftime.armoroftheages.config.PharaohSkin;
import org.dawnoftime.armoroftheages.config.RaijinSkin;
import org.dawnoftime.armoroftheages.config.SkinSyncState;

import java.util.HashMap;
import java.util.UUID;
import java.util.function.Supplier;

class GlobalSkinSyncPacketHandler {
    private final ForgeConfigSyncNetworkHandler forgeConfigSyncNetworkHandler;
    private final HashMap<UUID, SkinSyncState> map;

    public GlobalSkinSyncPacketHandler(ForgeConfigSyncNetworkHandler handler, HashMap<UUID, SkinSyncState> map) {
        this.forgeConfigSyncNetworkHandler = handler;
        this.map = new HashMap<>(map);
    }

    public void encoder(FriendlyByteBuf buffer) {
        buffer.writeInt(map.size());
        map.forEach((uuid, state) -> {
            buffer.writeUUID(uuid);
            buffer.writeEnum(state.oYoroiSkin());
            buffer.writeEnum(state.ironPlateSkin());
            buffer.writeEnum(state.centurionSkin());
            buffer.writeEnum(state.raijinSkin());
            buffer.writeEnum(state.pharaohSkin());
        });
    }

    public static GlobalSkinSyncPacketHandler decoder(ForgeConfigSyncNetworkHandler handler, FriendlyByteBuf buffer) {
        var decoded = new HashMap<UUID, SkinSyncState>();
        int size = buffer.readInt();
        for (int i = 0; i < size; i++) {
            decoded.put(buffer.readUUID(),
                new SkinSyncState(buffer.readEnum(OYoroiSkin.class), buffer.readEnum(IronPlateSkin.class), buffer.readEnum(CenturionSkin.class), buffer.readEnum(RaijinSkin.class), buffer.readEnum(PharaohSkin.class)));
        }
        return new GlobalSkinSyncPacketHandler(handler, decoded);
    }

    public void messageConsumer(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            forgeConfigSyncNetworkHandler.skinMapHandler.accept(map);
        });
        ctx.get().setPacketHandled(true);
    }
}
