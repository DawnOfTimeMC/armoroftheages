package org.dawnoftime.armoroftheages.config;

import com.mojang.serialization.Codec;

public enum PreferredModel {
    MALE,
    FEMALE;

    public static final Codec<PreferredModel> CODEC = Codec.STRING.xmap(PreferredModel::valueOf, Enum::name);
}
