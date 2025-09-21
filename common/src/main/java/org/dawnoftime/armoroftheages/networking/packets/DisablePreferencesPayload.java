package org.dawnoftime.armoroftheages.networking.packets;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

import static org.dawnoftime.armoroftheages.Constants.MOD_ID;

public record DisablePreferencesPayload() implements CustomPacketPayload {
    public static final Type<DisablePreferencesPayload> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MOD_ID, "disable_preferences"));
    
    public static final StreamCodec<FriendlyByteBuf, DisablePreferencesPayload> STREAM_CODEC = StreamCodec.unit(new DisablePreferencesPayload());

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}