package org.armoroftheages;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.apache.commons.lang3.tuple.Pair;
import org.armoroftheages.item.CustomArmorItem;

import net.minecraftforge.common.ForgeConfigSpec;

public class DoTBConfig {
    public final static List<CustomArmorItem> ARMORS_TO_SYNC = new ArrayList<>();
    public final static String ARMOR_MATERIAL_CATEGORY = "armor_properties";
    public final static Config COMMON_CONFIG;
    final static ForgeConfigSpec COMMON_SPEC;

    // Armors
    public static ArmorConfig IRON_PLATE_ARMOR_CONFIG;
    public static ArmorConfig HOLY_ARMOR_CONFIG;
    public static ArmorConfig JAPANESE_LIGHT_ARMOR_CONFIG;
    public static ArmorConfig O_YOROI_ARMOR_CONFIG;
    public static ArmorConfig RAIJIN_ARMOR_CONFIG;
    public static ArmorConfig PHARAOH_ARMOR_CONFIG;
    public static ArmorConfig ANUBIS_ARMOR_CONFIG;
    public static ArmorConfig CENTURION_ARMOR_CONFIG;
    public static ArmorConfig QUETZALCOATL_ARMOR_CONFIG;


    static {
        final Pair<Config, ForgeConfigSpec> pair = new ForgeConfigSpec.Builder().configure(Config::new);
        COMMON_SPEC = pair.getRight();
        COMMON_CONFIG = pair.getLeft();
    }

    public final static class Config {
        Config(final ForgeConfigSpec.Builder builderIn) {

            builderIn.comment("----------------------------------------|| Armor settings ||---------------------------------------").push(ARMOR_MATERIAL_CATEGORY);
            // IRON :      durability: 15, helmetDef: 2, chestDef: 6, legsDef: 5, feetDef: 2, enchantability: 9, toughness: 0.0D
            // DIAMOND :   durability: 33, helmetDef: 3, chestDef: 8, legsDef: 6, feetDef: 3, enchantability: 10, toughness: 2.0D
            // NETHERITE : durability: 37, helmetDef: 3, chestDef: 8, legsDef: 6, feetDef: 3, enchantability: 15, toughness: 3.0D
            IRON_PLATE_ARMOR_CONFIG = new ArmorConfig(builderIn, "iron_plate", 25, 3, 9, 7, 3, 6, 0.0D); // DIAMOND
            HOLY_ARMOR_CONFIG = new ArmorConfig(builderIn, "holy", 40, 4, 10, 8, 4, 4, 2.0D); // NETHERITE
            JAPANESE_LIGHT_ARMOR_CONFIG = new ArmorConfig(builderIn, "japanese_light", 12, 2, 7, 6, 2, 10, 0.0D); // IRON
            O_YOROI_ARMOR_CONFIG = new ArmorConfig(builderIn, "o_yoroi", 20, 3, 8, 6, 3, 16, 2.0D); // DIAMOND
            RAIJIN_ARMOR_CONFIG = new ArmorConfig(builderIn, "raijin", 35, 3, 9, 7, 3, 26, 2.0D); // NETHERITE
            CENTURION_ARMOR_CONFIG = new ArmorConfig(builderIn, "centurion", 22, 3, 7, 5, 3, 10, 3.0D); // DIAMOND
            PHARAOH_ARMOR_CONFIG = new ArmorConfig(builderIn, "pharaoh", 10, 3, 8, 6, 3, 37, 2.0D); // DIAMOND
            ANUBIS_ARMOR_CONFIG = new ArmorConfig(builderIn, "anubis", 25, 3, 8, 6, 3, 52, 3.0D); // NETHERITE
            QUETZALCOATL_ARMOR_CONFIG = new ArmorConfig(builderIn, "quetzalcoatl", 25, 2, 6, 5, 2, 20, 6.0D); // NETHERITE
            builderIn.pop();
        }
    }
    
    public static class ArmorConfig{
        private final ForgeConfigSpec.IntValue durability;
        private final ForgeConfigSpec.IntValue helmetDef;
        private final ForgeConfigSpec.IntValue chestDef;
        private final ForgeConfigSpec.IntValue legsDef;
        private final ForgeConfigSpec.IntValue feetDef;
        private final ForgeConfigSpec.IntValue enchantability;
        private final ForgeConfigSpec.DoubleValue toughness;
        
        private ArmorConfig(final ForgeConfigSpec.Builder builderIn, String armorSet, int durability, int helmetDef, int chestDef,int legsDef, int feetDef, int enchantability, double toughness) {
            builderIn.push(armorSet);
            this.durability = builderIn.comment("DurabilityFactor is multiplied with a value that depends on the armor part (between 11 and 16) to get the total durability :").defineInRange(armorSet + "_durability_factor", durability, 1, 1000);
            this.helmetDef = builderIn.comment("Helmet damage reduction :").defineInRange(armorSet + "_defense_helmet", helmetDef, 1, 100);
            this.chestDef = builderIn.comment("Chest damage reduction :").defineInRange(armorSet + "_defense_chest", chestDef, 1, 100);
            this.legsDef = builderIn.comment("Legs damage reduction :").defineInRange(armorSet + "_defense_legs", legsDef, 1, 100);
            this.feetDef = builderIn.comment("Feet damage reduction :").defineInRange(armorSet + "_defense_feet", feetDef, 1, 100);
            this.enchantability = builderIn.comment("This armor's enchantability :").defineInRange(armorSet + "_enchantability", enchantability, 1, 100);
            this.toughness = builderIn.comment("This armor's toughness :").defineInRange(armorSet + "_toughness", toughness, 0.0D, 100.0D);
            builderIn.pop();
        }

        public Supplier<Integer> durabilitySupplier(){
            return this.durability::get;
        }

        public Supplier<Integer> helmetDefSupplier(){
            return this.helmetDef::get;
        }

        public Supplier<Integer> chestDefSupplier(){
            return this.chestDef::get;
        }

        public Supplier<Integer> legsDefSupplier(){
            return this.legsDef::get;
        }

        public Supplier<Integer> feetDefSupplier(){
            return this.feetDef::get;
        }

        public Supplier<Integer> enchantabilitySupplier(){
            return this.enchantability::get;
        }

        public Supplier<Float> toughnessSupplier(){
            return () -> this.toughness.get().floatValue();
        }
    }
}
