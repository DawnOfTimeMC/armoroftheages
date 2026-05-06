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

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.dawnoftime.armoroftheages.Constants.MOD_ID;

public record GlobalSkinSyncPayload(Map<UUID, SkinSyncState> skins) implements CustomPacketPayload {
    public static final Type<GlobalSkinSyncPayload> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MOD_ID, "global_skin_sync"));

    public static final StreamCodec<FriendlyByteBuf, GlobalSkinSyncPayload> STREAM_CODEC = StreamCodec.of(
        GlobalSkinSyncPayload::encode,
        GlobalSkinSyncPayload::decode
    );

    private static void encode(FriendlyByteBuf buf, GlobalSkinSyncPayload payload) {
        buf.writeInt(payload.skins().size());
        payload.skins().forEach((uuid, state) -> {
            buf.writeUUID(uuid);
            buf.writeEnum(state.oYoroiSkin());
            buf.writeEnum(state.ironPlateSkin());
            buf.writeEnum(state.centurionSkin());
            buf.writeEnum(state.raijinSkin());
            buf.writeEnum(state.pharaohSkin());
        });
    }

    private static GlobalSkinSyncPayload decode(FriendlyByteBuf buf) {
        int size = buf.readInt();
        Map<UUID, SkinSyncState> skins = new HashMap<>();
        for (int i = 0; i < size; i++) {
            skins.put(buf.readUUID(), new SkinSyncState(
                buf.readEnum(OYoroiSkin.class),
                buf.readEnum(IronPlateSkin.class),
                buf.readEnum(CenturionSkin.class),
                buf.readEnum(RaijinSkin.class),
                buf.readEnum(PharaohSkin.class)
            ));
        }
        return new GlobalSkinSyncPayload(skins);
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
