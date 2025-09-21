package org.dawnoftime.armoroftheages.networking.packets;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import org.dawnoftime.armoroftheages.config.PreferredModel;

import static org.dawnoftime.armoroftheages.Constants.MOD_ID;

public record PreferenceSyncPayload(PreferredModel preferredModel) implements CustomPacketPayload {
    public static final Type<PreferenceSyncPayload> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MOD_ID, "preference_sync"));
    
    public static final StreamCodec<FriendlyByteBuf, PreferenceSyncPayload> STREAM_CODEC = StreamCodec.composite(
        StreamCodec.of(
                FriendlyByteBuf::writeEnum,
            buf -> buf.readEnum(PreferredModel.class)
        ),
        PreferenceSyncPayload::preferredModel,
        PreferenceSyncPayload::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}