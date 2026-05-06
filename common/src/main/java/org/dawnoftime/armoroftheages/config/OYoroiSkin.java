package org.dawnoftime.armoroftheages.config;

import org.dawnoftime.armoroftheages.client.ArmorModelProvider;

public enum OYoroiSkin implements ArmorModelProvider.SkinVariant {
    DEFAULT("", 0),
    AMBER("amber_", 0),
    NIGHTBLUE("nightblue_", 0),
    DUSK("dusk_", 0),
    INK("ink_", 0),
    JADE("jade_", 0),
    PINKY("pinky_", 0),

    SILVER_PATREON("silver_", 1),
    AMETHYST_PATREON("amethist_", 4);

    private final String texturePrefix;
    private final int requiredTier;

    OYoroiSkin(String texturePrefix, int requiredTier) {
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
            case AMBER -> "Amber";
            case NIGHTBLUE -> "Nightblue";
            case DUSK -> "Dusk";
            case INK -> "Ink";
            case JADE -> "Jade";
            case PINKY -> "Pinky";
            case SILVER_PATREON -> "Silver (Patreon)";
            case AMETHYST_PATREON -> "Amethyst (Patreon)";
        };
    }
}
