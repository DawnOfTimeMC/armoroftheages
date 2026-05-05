package org.dawnoftime.armoroftheages.config;

public enum OYoroiSkin implements org.dawnoftime.armoroftheages.client.ArmorModelProvider.SkinVariant {
    DEFAULT("", 0),
    NIGHTBLUE("nightblue_", 0),
    AMBER("amber_", 0),
    JADE("jade_", 0),
    PINKY("pinky_", 0),
    DUSK("dusk_", 0),
    INK("ink_", 0),

    AMETHYST_PATREON("amethist_", 4);

    private final String texturePrefix;
    private final int requiredTier;

    OYoroiSkin(String texturePrefix, int requiredTier) {
        this.texturePrefix = texturePrefix;
        this.requiredTier = requiredTier;
    }

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
            case NIGHTBLUE -> "Nightblue";
            case AMBER -> "Amber";
            case JADE -> "Jade";
            case PINKY -> "Pinky";
            case DUSK -> "Dusk";
            case INK -> "Ink";
            case AMETHYST_PATREON -> "Amethyst (Patreon)";
        };
    }
}
