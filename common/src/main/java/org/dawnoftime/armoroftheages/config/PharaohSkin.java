package org.dawnoftime.armoroftheages.config;

import org.dawnoftime.armoroftheages.client.ArmorModelProvider;

public enum PharaohSkin implements ArmorModelProvider.SkinVariant {
    DEFAULT("", 0),
    SILVER_PATREON("silver_", 1);

    private final String texturePrefix;
    private final int requiredTier;

    PharaohSkin(String texturePrefix, int requiredTier) {
        this.texturePrefix = texturePrefix;
        this.requiredTier = requiredTier;
    }

    @Override
    public String getTexturePrefix() {
        return texturePrefix;
    }

    public int getRequiredTier() {
        return requiredTier;
    }

    @Override
    public String toString() {
        return switch (this) {
            case DEFAULT -> "Default";
            case SILVER_PATREON -> "Silver (Patreon)";
        };
    }
}
