package org.dawnoftime.armoroftheages.config;

import org.dawnoftime.armoroftheages.client.ArmorModelProvider;

public enum IronPlateSkin implements ArmorModelProvider.SkinVariant {
    DEFAULT(""),
    ASHES("ashes_");

    private final String texturePrefix;

    IronPlateSkin(String texturePrefix) {
        this.texturePrefix = texturePrefix;
    }

    @Override
    public String getTexturePrefix() {
        return texturePrefix;
    }

    @Override
    public String toString() {
        return switch (this) {
            case DEFAULT -> "Default";
            case ASHES -> "Ashes";
        };
    }
}
