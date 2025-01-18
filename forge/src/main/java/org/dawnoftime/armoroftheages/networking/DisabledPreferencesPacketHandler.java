package org.dawnoftime.armoroftheages.networking;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

class DisabledPreferencesPacketHandler {
    private final ForgeConfigSyncNetworkHandler handler;

    public DisabledPreferencesPacketHandler(ForgeConfigSyncNetworkHandler handler) {
        this.handler = handler;
    }

    public void encoder(FriendlyByteBuf buffer) {
        // Empty packet.
    }

    public static DisabledPreferencesPacketHandler decoder(ForgeConfigSyncNetworkHandler handler, FriendlyByteBuf buffer) {
        return new DisabledPreferencesPacketHandler(handler);
    }

    public void messageConsumer(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            handler.CURRENT_SERVER_STATE.remove(ctx.get().getSender().getUUID());
            handler.globalSync(ctx.get().getSender().getServer());
        });
        ctx.get().setPacketHandled(true);
    }
}
