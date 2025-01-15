package org.dawnoftime.armoroftheages.networking.packets;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import org.dawnoftime.armoroftheages.Constants;
import org.dawnoftime.armoroftheages.config.PreferredModel;
import org.jetbrains.annotations.NotNull;

public record C2SPreferenceSyncPacket(PreferredModel preferredModel) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<C2SPreferenceSyncPacket> TYPE = new Type<>(ResourceLocation.tryBuild(Constants.MOD_ID, "preference_sync"));
    public static final StreamCodec<FriendlyByteBuf, C2SPreferenceSyncPacket> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.fromCodec(PreferredModel.CODEC), C2SPreferenceSyncPacket::preferredModel,
            C2SPreferenceSyncPacket::new
    );

    @Override
    public @NotNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}