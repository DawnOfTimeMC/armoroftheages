package org.dawnoftime.armoroftheages.networking.packets;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import org.dawnoftime.armoroftheages.config.PreferredModel;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.dawnoftime.armoroftheages.Constants.MOD_ID;

public record GlobalPreferenceSyncPayload(Map<UUID, PreferredModel> preferences) implements CustomPacketPayload {
    public static final Type<GlobalPreferenceSyncPayload> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MOD_ID, "global_preference_sync"));
    
    public static final StreamCodec<FriendlyByteBuf, GlobalPreferenceSyncPayload> STREAM_CODEC = StreamCodec.of(
        GlobalPreferenceSyncPayload::encode,
        GlobalPreferenceSyncPayload::decode
    );

    private static void encode(FriendlyByteBuf buf, GlobalPreferenceSyncPayload payload) {
        buf.writeInt(payload.preferences.size());
        payload.preferences.forEach((uuid, model) -> {
            buf.writeUUID(uuid);
            buf.writeEnum(model);
        });
    }

    private static GlobalPreferenceSyncPayload decode(FriendlyByteBuf buf) {
        int size = buf.readInt();
        Map<UUID, PreferredModel> preferences = new HashMap<>();
        for (int i = 0; i < size; i++) {
            preferences.put(buf.readUUID(), buf.readEnum(PreferredModel.class));
        }
        return new GlobalPreferenceSyncPayload(preferences);
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}