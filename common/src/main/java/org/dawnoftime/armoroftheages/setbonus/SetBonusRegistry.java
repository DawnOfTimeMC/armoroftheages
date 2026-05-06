package org.dawnoftime.armoroftheages.setbonus;

import net.minecraft.ChatFormatting;
import org.dawnoftime.armoroftheages.Constants;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class SetBonusRegistry {

    private static final Map<String, SetBonus> REGISTRY = new HashMap<>();

    public static void init() {
        register(Constants.JAPANESE_LIGHT_ARMOR_NAME,
                new SetBonus("set_bonus.armoroftheages.japanese_light_armor", ChatFormatting.YELLOW,
                        "set_bonus.armoroftheages.japanese_light_armor.description"));

        register(Constants.PHARAOH_ARMOR_NAME,
                new SetBonus("set_bonus.armoroftheages.pharaoh_armor", ChatFormatting.GOLD,
                        "set_bonus.armoroftheages.pharaoh_armor.description"));

        register(Constants.QUETZALCOATL_ARMOR_NAME,
                new SetBonus("set_bonus.armoroftheages.quetzalcoatl_armor", ChatFormatting.LIGHT_PURPLE,
                        "set_bonus.armoroftheages.quetzalcoatl_armor.description"));

        register(Constants.HOLY_ARMOR_NAME,
                new SetBonus("set_bonus.armoroftheages.holy_armor", ChatFormatting.LIGHT_PURPLE,
                        "set_bonus.armoroftheages.holy_armor.description"));

        register(Constants.RAIJIN_ARMOR_NAME,
                new SetBonus("set_bonus.armoroftheages.raijin_armor", ChatFormatting.LIGHT_PURPLE,
                        "set_bonus.armoroftheages.raijin_armor.description"));

        register(Constants.IRON_PLATE_ARMOR_NAME,
                new SetBonus("set_bonus.armoroftheages.iron_plate_armor", ChatFormatting.YELLOW,
                        "set_bonus.armoroftheages.iron_plate_armor.description"));

        register(Constants.O_YOROI_ARMOR_NAME,
                new SetBonus("set_bonus.armoroftheages.o_yoroi_armor", ChatFormatting.YELLOW,
                        "set_bonus.armoroftheages.o_yoroi_armor.description"));

        register(Constants.CENTURION_ARMOR_NAME,
                new SetBonus("set_bonus.armoroftheages.centurion_armor", ChatFormatting.YELLOW,
                        "set_bonus.armoroftheages.centurion_armor.description"));

        register(Constants.ANUBIS_ARMOR_NAME,
                new SetBonus("set_bonus.armoroftheages.anubis_armor", ChatFormatting.LIGHT_PURPLE,
                        "set_bonus.armoroftheages.anubis_armor.description"));

        register(Constants.EXALTED_AURUM_ARMOR_NAME,
                new SetBonus("set_bonus.armoroftheages.exalted_aurum_armor", ChatFormatting.LIGHT_PURPLE,
                        "set_bonus.armoroftheages.exalted_aurum_armor.description"));

        register(Constants.BAMBOO_HAT_NAME,
                new SetBonus("set_bonus.armoroftheages.bamboo_hat", ChatFormatting.GREEN,
                        "set_bonus.armoroftheages.bamboo_hat.description"));
    }

    public static void register(String setName, SetBonus bonus) {
        REGISTRY.put(setName, bonus);
    }

    public static Optional<SetBonus> get(String setName) {
        return Optional.ofNullable(REGISTRY.get(setName));
    }
}
