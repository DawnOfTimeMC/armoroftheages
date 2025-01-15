package org.dawnoftime.armoroftheages.networking.packets;

import com.mojang.serialization.Codec;
import io.netty.buffer.ByteBuf;
import net.minecraft.core.UUIDUtil;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import org.dawnoftime.armoroftheages.Constants;
import org.dawnoftime.armoroftheages.config.PreferredModel;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.UUID;

public record S2CPreferenceSyncPacket(HashMap<UUID, PreferredModel> modelHashMap) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<S2CPreferenceSyncPacket> TYPE = new Type<>(ResourceLocation.tryBuild(Constants.MOD_ID, "global_preference_sync"));
    public static final StreamCodec<FriendlyByteBuf, S2CPreferenceSyncPacket> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.map(HashMap::new, UUIDUtil.STREAM_CODEC, ByteBufCodecs.fromCodec(PreferredModel.CODEC)),
            S2CPreferenceSyncPacket::modelHashMap,
            S2CPreferenceSyncPacket::new
    );

    @Override
    public @NotNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
