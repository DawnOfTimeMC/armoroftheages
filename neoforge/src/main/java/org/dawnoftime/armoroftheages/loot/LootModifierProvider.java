package org.dawnoftime.armoroftheages.loot;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;
import org.dawnoftime.armoroftheages.Constants;

import java.util.concurrent.CompletableFuture;

public class LootModifierProvider extends GlobalLootModifierProvider {

    public LootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, Constants.MOD_ID);
    }

    @Override
    protected void start() {
        add("bamboo_hat_in_mineshaft",
                new ArmorOfTheAgesLootModifier(
                        new LootItemCondition[] {
                                LootTableIdCondition.builder(ResourceLocation.parse(LootTablesToModify.ABANDONED_MINESHAFT)).build(),
                                LootItemRandomChanceCondition.randomChance(0.35f).build()
                        },
                        Constants.BAMBOO_HAT_NAME,
                        1.0f
                )
        );

        add("bamboo_hat_in_shipwreck_supply",
                new ArmorOfTheAgesLootModifier(
                        new LootItemCondition[] {
                                LootTableIdCondition.builder(ResourceLocation.parse(LootTablesToModify.SHIPWRECK_SUPPLY)).build(),
                                LootItemRandomChanceCondition.randomChance(0.35f).build()
                        },
                        Constants.BAMBOO_HAT_NAME,
                        1.0f
                )
        );

        add("bamboo_hat_in_village_taiga_house",
                new ArmorOfTheAgesLootModifier(
                        new LootItemCondition[] {
                                LootTableIdCondition.builder(ResourceLocation.parse(LootTablesToModify.VILLAGE_TAIGA_HOUSE)).build(),
                                LootItemRandomChanceCondition.randomChance(0.35f).build()
                        },
                        Constants.BAMBOO_HAT_NAME,
                        1.0f
                )
        );

        add("japanese_light_in_simple_dungeon",
                new ArmorOfTheAgesLootModifier(
                        new LootItemCondition[] {
                                LootTableIdCondition.builder(ResourceLocation.parse(LootTablesToModify.SIMPLE_DUNGEON)).build(),
                                LootItemRandomChanceCondition.randomChance(0.5f).build()
                        },
                        Constants.JAPANESE_LIGHT_ARMOR_NAME,
                        0.5f
                )
        );

        add("iron_plate_in_simple_dungeon",
                new ArmorOfTheAgesLootModifier(
                        new LootItemCondition[] {
                                LootTableIdCondition.builder(ResourceLocation.parse(LootTablesToModify.SIMPLE_DUNGEON)).build(),
                                LootItemRandomChanceCondition.randomChance(0.35f).build()
                        },
                        Constants.IRON_PLATE_ARMOR_NAME,
                        0.25f
                )
        );

        add("japanese_light_in_village_weaponsmith",
                new ArmorOfTheAgesLootModifier(
                        new LootItemCondition[] {
                                LootTableIdCondition.builder(ResourceLocation.parse(LootTablesToModify.VILLAGE_WEAPONSMITH)).build(),
                                LootItemRandomChanceCondition.randomChance(1.0f).build()
                        },
                        Constants.JAPANESE_LIGHT_ARMOR_NAME,
                        0.7f
                )
        );

        add("centurion_in_ruined_portal",
                new ArmorOfTheAgesLootModifier(
                        new LootItemCondition[] {
                                LootTableIdCondition.builder(ResourceLocation.parse(LootTablesToModify.RUINED_PORTAL)).build(),
                                LootItemRandomChanceCondition.randomChance(1.0f).build()
                        },
                        Constants.CENTURION_ARMOR_NAME,
                        0.15f
                )
        );

        add("iron_plate_in_village_armorer",
                new ArmorOfTheAgesLootModifier(
                        new LootItemCondition[] {
                                LootTableIdCondition.builder(ResourceLocation.parse(LootTablesToModify.VILLAGE_ARMORER)).build(),
                                LootItemRandomChanceCondition.randomChance(0.5f).build()
                        },
                        Constants.IRON_PLATE_ARMOR_NAME,
                        0.15f
                )
        );

        add("o_yoroi_in_shipwreck_treasure",
                new ArmorOfTheAgesLootModifier(
                        new LootItemCondition[] {
                                LootTableIdCondition.builder(ResourceLocation.parse(LootTablesToModify.SHIPWRECK_TREASURE)).build(),
                                LootItemRandomChanceCondition.randomChance(1.0f).build()
                        },
                        Constants.O_YOROI_ARMOR_NAME,
                        0.15f
                )
        );

        add("pharaoh_in_desert_pyramid",
                new ArmorOfTheAgesLootModifier(
                        new LootItemCondition[] {
                                LootTableIdCondition.builder(ResourceLocation.parse(LootTablesToModify.DESERT_PYRAMID)).build(),
                                LootItemRandomChanceCondition.randomChance(0.7f).build()
                        },
                        Constants.PHARAOH_ARMOR_NAME,
                        0.15f
                )
        );

        add("exalted_aurum_in_ancient_city",
                new ArmorOfTheAgesLootModifier(
                        new LootItemCondition[] {
                                LootTableIdCondition.builder(ResourceLocation.parse(LootTablesToModify.ANCIENT_CITY)).build(),
                                LootItemRandomChanceCondition.randomChance(0.35f).build()
                        },
                        Constants.EXALTED_AURUM_ARMOR_NAME,
                        0.7f
                )
        );

        add("holy_in_village_temple",
                new ArmorOfTheAgesLootModifier(
                        new LootItemCondition[] {
                                LootTableIdCondition.builder(ResourceLocation.parse(LootTablesToModify.VILLAGE_TEMPLE)).build(),
                                LootItemRandomChanceCondition.randomChance(0.5f).build()
                        },
                        Constants.HOLY_ARMOR_NAME,
                        0.15f
                )
        );

        add("quetzalcoatl_in_jungle_temple",
                new ArmorOfTheAgesLootModifier(
                        new LootItemCondition[] {
                                LootTableIdCondition.builder(ResourceLocation.parse(LootTablesToModify.JUNGLE_TEMPLE)).build(),
                                LootItemRandomChanceCondition.randomChance(1.0f).build()
                        },
                        Constants.QUETZALCOATL_ARMOR_NAME,
                        0.15f
                )
        );

        add("raijin_in_bastion_treasure",
                new ArmorOfTheAgesLootModifier(
                        new LootItemCondition[] {
                                LootTableIdCondition.builder(ResourceLocation.parse(LootTablesToModify.BASTION_TREASURE)).build(),
                                LootItemRandomChanceCondition.randomChance(1.0f).build()
                        },
                        Constants.RAIJIN_ARMOR_NAME,
                        0.7f
                )
        );
    }
}