package org.dawnoftime.armoroftheages.setbonus;

import net.minecraft.ChatFormatting;
import org.jetbrains.annotations.Nullable;

public record SetBonus(String nameTranslationKey, ChatFormatting nameColor, @Nullable String descriptionTranslationKey) {

    public SetBonus(String nameTranslationKey, ChatFormatting nameColor) {
        this(nameTranslationKey, nameColor, null);
    }
}
