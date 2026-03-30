package org.dawnoftime.armoroftheages.setbonus;

import net.minecraft.ChatFormatting;
import org.dawnoftime.armoroftheages.Constants;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Central registry mapping armor set names to their set bonus.
 *
 * To add a bonus to a new set, call register() here with the set name constant,
 * a translation key, and the desired color for the effect name in the tooltip.
 */
public class SetBonusRegistry {

    private static final Map<String, SetBonus> REGISTRY = new HashMap<>();

    public static void init() {
        // Dō-maru: Speed I (day) / Speed II (night) — "Night Butterfly"
        register(
                Constants.JAPANESE_LIGHT_ARMOR_NAME,
                new SetBonus("set_bonus.armoroftheages.japanese_light_armor", ChatFormatting.YELLOW,
                        "set_bonus.armoroftheages.japanese_light_armor.description")
        );

        // Pharaoh: Fire Resistance (always) + Haste I (desert only) — "Son of the Dunes"
        register(
                Constants.PHARAOH_ARMOR_NAME,
                new SetBonus("set_bonus.armoroftheages.pharaoh_armor", ChatFormatting.GOLD,
                        "set_bonus.armoroftheages.pharaoh_armor.description")
        );

        // Quetzalcoatl: Hunger I + Poison I + Strength I/II/III (based on HP) — "Curse of the Undead"
        register(
                Constants.QUETZALCOATL_ARMOR_NAME,
                new SetBonus("set_bonus.armoroftheages.quetzalcoatl_armor", ChatFormatting.LIGHT_PURPLE,
                        "set_bonus.armoroftheages.quetzalcoatl_armor.description")
        );

        // Holy: Resistance I (always) + Resistance II + Regen I (when monster nearby) — "Protector of the Weak"
        register(
                Constants.HOLY_ARMOR_NAME,
                new SetBonus("set_bonus.armoroftheages.holy_armor", ChatFormatting.LIGHT_PURPLE,
                        "set_bonus.armoroftheages.holy_armor.description")
        );

        // Raijin: Speed I always; clear → Jump Boost II + Slow Falling; rain → Speed II + Strength I; thunder → Speed II + Strength II — "Calm as Thunder"
        register(
                Constants.RAIJIN_ARMOR_NAME,
                new SetBonus("set_bonus.armoroftheages.raijin_armor", ChatFormatting.LIGHT_PURPLE,
                        "set_bonus.armoroftheages.raijin_armor.description")
        );

        // Iron Plate: Resistance I — "Man of Steel"
        register(
                Constants.IRON_PLATE_ARMOR_NAME,
                new SetBonus("set_bonus.armoroftheages.iron_plate_armor", ChatFormatting.YELLOW,
                        "set_bonus.armoroftheages.iron_plate_armor.description")
        );

        // O-Yoroi: Strength I — "Force Ancestrale"
        register(
                Constants.O_YOROI_ARMOR_NAME,
                new SetBonus("set_bonus.armoroftheages.o_yoroi_armor", ChatFormatting.YELLOW,
                        "set_bonus.armoroftheages.o_yoroi_armor.description")
        );

        // Centurion: Saturation I — "Spartan Stamina"
        register(
                Constants.CENTURION_ARMOR_NAME,
                new SetBonus("set_bonus.armoroftheages.centurion_armor", ChatFormatting.YELLOW,
                        "set_bonus.armoroftheages.centurion_armor.description")
        );

        // Anubis: Health Boost I + Wither + Resistance I/II + Strength I (HP-based) — "Father of the Undead"
        register(
                Constants.ANUBIS_ARMOR_NAME,
                new SetBonus("set_bonus.armoroftheages.anubis_armor", ChatFormatting.LIGHT_PURPLE,
                        "set_bonus.armoroftheages.anubis_armor.description")
        );

        // Exalted Aurum: depth and dimension-based effects — "Creature of the Abyss"
        register(
                Constants.EXALTED_AURUM_ARMOR_NAME,
                new SetBonus("set_bonus.armoroftheages.exalted_aurum_armor", ChatFormatting.LIGHT_PURPLE,
                        "set_bonus.armoroftheages.exalted_aurum_armor.description")
        );

        // Bamboo Hat + O-Yoroi body combo: Haste I — "Spirit of the Forest"
        register(
                Constants.BAMBOO_HAT_NAME,
                new SetBonus("set_bonus.armoroftheages.bamboo_hat", ChatFormatting.GREEN,
                        "set_bonus.armoroftheages.bamboo_hat.description")
        );
    }

    public static void register(String setName, SetBonus bonus) {
        REGISTRY.put(setName, bonus);
    }

    /** Returns the set bonus for the given set name, or empty if none is defined. */
    public static Optional<SetBonus> get(String setName) {
        return Optional.ofNullable(REGISTRY.get(setName));
    }
}
