package org.dawnoftime.armoroftheages.networking;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

class DisabledSkinSyncPacketHandler {
    private final ForgeConfigSyncNetworkHandler handler;

    public DisabledSkinSyncPacketHandler(ForgeConfigSyncNetworkHandler handler) {
        this.handler = handler;
    }

    public void encoder(FriendlyByteBuf buffer) {}

    public static DisabledSkinSyncPacketHandler decoder(ForgeConfigSyncNetworkHandler handler, FriendlyByteBuf buffer) {
        return new DisabledSkinSyncPacketHandler(handler);
    }

    public void messageConsumer(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            handler.CURRENT_SKIN_STATE.remove(ctx.get().getSender().getUUID());
            handler.globalSkinSync(ctx.get().getSender().getServer());
        });
        ctx.get().setPacketHandled(true);
    }
}
