package org.dawnoftime.armoroftheages.networking.packets;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

import static org.dawnoftime.armoroftheages.Constants.MOD_ID;

public record PatronTierPayload(int tier) implements CustomPacketPayload {
    public static final Type<PatronTierPayload> TYPE = new Type<>(
        ResourceLocation.fromNamespaceAndPath(MOD_ID, "patron_tier_sync"));

    public static final StreamCodec<FriendlyByteBuf, PatronTierPayload> STREAM_CODEC = StreamCodec.composite(
        StreamCodec.of(FriendlyByteBuf::writeVarInt, FriendlyByteBuf::readVarInt),
        PatronTierPayload::tier,
        PatronTierPayload::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
