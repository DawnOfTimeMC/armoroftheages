package org.dawnoftime.armoroftheages.networking;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;
import org.dawnoftime.armoroftheages.config.PreferredModel;

import java.util.function.Supplier;

class PreferenceSyncPacketHandler {
    private final ForgeConfigSyncNetworkHandler handler;
    private final PreferredModel preferredModel;

    public PreferenceSyncPacketHandler(ForgeConfigSyncNetworkHandler handler, PreferredModel preferredModel) {
        this.preferredModel = preferredModel;
        this.handler = handler;
    }

    public void encoder(FriendlyByteBuf buffer) {
        buffer.writeEnum(preferredModel);
    }

    public static PreferenceSyncPacketHandler decoder(ForgeConfigSyncNetworkHandler handler, FriendlyByteBuf buffer) {
        return new PreferenceSyncPacketHandler(handler, buffer.readEnum(PreferredModel.class));
    }

    public void messageConsumer(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            handler.CURRENT_SERVER_STATE.put(ctx.get().getSender().getUUID(), preferredModel);
            handler.globalSync(ctx.get().getSender().getServer());
        });
        ctx.get().setPacketHandled(true);
    }
}
