package org.dawnoftime.armoroftheages.networking.packets;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

import static org.dawnoftime.armoroftheages.Constants.MOD_ID;

public record DisableSkinSyncPayload() implements CustomPacketPayload {
    public static final Type<DisableSkinSyncPayload> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MOD_ID, "disable_skin_sync"));

    public static final StreamCodec<FriendlyByteBuf, DisableSkinSyncPayload> STREAM_CODEC = StreamCodec.unit(new DisableSkinSyncPayload());

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
