package org.dawnoftime.armoroftheages.networking;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;
import org.dawnoftime.armoroftheages.config.CenturionSkin;
import org.dawnoftime.armoroftheages.config.IronPlateSkin;
import org.dawnoftime.armoroftheages.config.OYoroiSkin;
import org.dawnoftime.armoroftheages.config.PharaohSkin;
import org.dawnoftime.armoroftheages.config.RaijinSkin;
import org.dawnoftime.armoroftheages.config.SkinSyncState;

import java.util.function.Supplier;

class SkinSyncPacketHandler {
    private final ForgeConfigSyncNetworkHandler handler;
    private final SkinSyncState state;

    public SkinSyncPacketHandler(ForgeConfigSyncNetworkHandler handler, SkinSyncState state) {
        this.handler = handler;
        this.state = state;
    }

    public void encoder(FriendlyByteBuf buffer) {
        buffer.writeEnum(state.oYoroiSkin());
        buffer.writeEnum(state.ironPlateSkin());
        buffer.writeEnum(state.centurionSkin());
        buffer.writeEnum(state.raijinSkin());
        buffer.writeEnum(state.pharaohSkin());
    }

    public static SkinSyncPacketHandler decoder(ForgeConfigSyncNetworkHandler handler, FriendlyByteBuf buffer) {
        return new SkinSyncPacketHandler(handler,
            new SkinSyncState(buffer.readEnum(OYoroiSkin.class), buffer.readEnum(IronPlateSkin.class), buffer.readEnum(CenturionSkin.class), buffer.readEnum(RaijinSkin.class), buffer.readEnum(PharaohSkin.class)));
    }

    public void messageConsumer(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            handler.CURRENT_SKIN_STATE.put(ctx.get().getSender().getUUID(), state);
            handler.globalSkinSync(ctx.get().getSender().getServer());
        });
        ctx.get().setPacketHandled(true);
    }
}
