package org.dawnoftime.armoroftheages.networking.packets;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import org.dawnoftime.armoroftheages.config.CenturionSkin;
import org.dawnoftime.armoroftheages.config.IronPlateSkin;
import org.dawnoftime.armoroftheages.config.OYoroiSkin;
import org.dawnoftime.armoroftheages.config.PharaohSkin;
import org.dawnoftime.armoroftheages.config.RaijinSkin;
import org.dawnoftime.armoroftheages.config.SkinSyncState;

import static org.dawnoftime.armoroftheages.Constants.MOD_ID;

public record SkinSyncPayload(SkinSyncState state) implements CustomPacketPayload {
    public static final Type<SkinSyncPayload> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MOD_ID, "skin_sync"));

    public static final StreamCodec<FriendlyByteBuf, SkinSyncPayload> STREAM_CODEC = StreamCodec.of(
        SkinSyncPayload::encode,
        SkinSyncPayload::decode
    );

    private static void encode(FriendlyByteBuf buf, SkinSyncPayload payload) {
        buf.writeEnum(payload.state().oYoroiSkin());
        buf.writeEnum(payload.state().ironPlateSkin());
        buf.writeEnum(payload.state().centurionSkin());
        buf.writeEnum(payload.state().raijinSkin());
        buf.writeEnum(payload.state().pharaohSkin());
    }

    private static SkinSyncPayload decode(FriendlyByteBuf buf) {
        return new SkinSyncPayload(new SkinSyncState(
            buf.readEnum(OYoroiSkin.class),
            buf.readEnum(IronPlateSkin.class),
            buf.readEnum(CenturionSkin.class),
            buf.readEnum(RaijinSkin.class),
            buf.readEnum(PharaohSkin.class)
        ));
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
