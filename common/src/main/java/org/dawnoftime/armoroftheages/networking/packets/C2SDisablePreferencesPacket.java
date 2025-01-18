package org.dawnoftime.armoroftheages.networking.packets;

import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import org.dawnoftime.armoroftheages.Constants;
import org.jetbrains.annotations.NotNull;

public record C2SDisablePreferencesPacket() implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<C2SDisablePreferencesPacket> TYPE = new Type<>(ResourceLocation.tryBuild(Constants.MOD_ID, "disable_preferences"));

    @Override
    public @NotNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}