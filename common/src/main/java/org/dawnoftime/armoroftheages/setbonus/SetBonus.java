package org.dawnoftime.armoroftheages.setbonus;

import net.minecraft.ChatFormatting;
import org.jetbrains.annotations.Nullable;

/**
 * Describes the set bonus for a complete armor set.
 *
 * @param nameTranslationKey         The translation key for the bonus display name (e.g. "set_bonus.armoroftheages.japanese_light_armor")
 * @param nameColor                  The color used to display the bonus name in the tooltip
 * @param descriptionTranslationKey  Optional translation key for a short description shown below the name. Null = no description.
 */
public record SetBonus(String nameTranslationKey, ChatFormatting nameColor, @Nullable String descriptionTranslationKey) {

    /** Convenience constructor for sets without a description. */
    public SetBonus(String nameTranslationKey, ChatFormatting nameColor) {
        this(nameTranslationKey, nameColor, null);
    }
}
