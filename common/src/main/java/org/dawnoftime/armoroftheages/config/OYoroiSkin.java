package org.dawnoftime.armoroftheages.config;

public enum OYoroiSkin implements org.dawnoftime.armoroftheages.client.ArmorModelProvider.SkinVariant {
    DEFAULT(""),
    NIGHTBLUE("nightblue_"),
    AMBER("amber_"),
    JADE("jade_"),
    PINKY("pinky_"),
    DUSK("dusk_"),
    INK("ink_");

    private final String texturePrefix;

    OYoroiSkin(String texturePrefix) {
        this.texturePrefix = texturePrefix;
    }

    public String getTexturePrefix() {
        return texturePrefix;
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
        };
    }
}
