package org.dawnoftime.armoroftheages.loot;

import com.google.common.collect.ImmutableMap;
import org.dawnoftime.armoroftheages.Constants;
import org.dawnoftime.armoroftheages.config.AOTAConfig;

import java.util.Map;

public final class LootTablesToModify {
    public static final String ABANDONED_MINESHAFT = "minecraft:chests/abandoned_mineshaft";
    public static final String VILLAGE_TAIGA_HOUSE = "minecraft:chests/village/village_taiga_house";
    public static final String SHIPWRECK_SUPPLY = "minecraft:chests/shipwreck_supply";
    public static final String VILLAGE_WEAPONSMITH = "minecraft:chests/village/village_weaponsmith";
    public static final String SIMPLE_DUNGEON = "minecraft:chests/simple_dungeon";
    public static final String RUINED_PORTAL = "minecraft:chests/ruined_portal";
    public static final String VILLAGE_ARMORER = "minecraft:chests/village/village_armorer";
    public static final String SHIPWRECK_TREASURE = "minecraft:chests/shipwreck_treasure";
    public static final String DESERT_PYRAMID = "minecraft:chests/desert_pyramid";
    public static final String ANCIENT_CITY = "minecraft:chests/ancient_city";
    public static final String VILLAGE_TEMPLE = "minecraft:chests/village/village_temple";
    public static final String JUNGLE_TEMPLE = "minecraft:chests/jungle_temple";
    public static final String BASTION_TREASURE = "minecraft:chests/bastion_treasure";

    public static final Map<String, Boolean> ARMOR_GENERATION_MAP = ImmutableMap.<String, Boolean>builder()
            .put(Constants.BAMBOO_HAT_NAME,          AOTAConfig.get().generateBambooHat)
            .put(Constants.ANUBIS_ARMOR_NAME,        AOTAConfig.get().generateAnubisArmor)
            .put(Constants.CENTURION_ARMOR_NAME,     AOTAConfig.get().generateCenturionArmor)
            .put(Constants.EXALTED_AURUM_ARMOR_NAME, AOTAConfig.get().generateExaltedAurumArmor)
            .put(Constants.HOLY_ARMOR_NAME,           AOTAConfig.get().generateHolyArmor)
            .put(Constants.IRON_PLATE_ARMOR_NAME,    AOTAConfig.get().generateIronPlateArmor)
            .put(Constants.JAPANESE_LIGHT_ARMOR_NAME,AOTAConfig.get().generateJapaneseLightArmor)
            .put(Constants.O_YOROI_ARMOR_NAME,       AOTAConfig.get().generateOYoroiArmor)
            .put(Constants.PHARAOH_ARMOR_NAME,       AOTAConfig.get().generatePharaohArmor)
            .put(Constants.QUETZALCOATL_ARMOR_NAME,  AOTAConfig.get().generateQuetzalcoatlArmor)
            .put(Constants.RAIJIN_ARMOR_NAME,        AOTAConfig.get().generateRaijinArmor)
            .build();
}
