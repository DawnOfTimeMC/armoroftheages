package org.dawnoftime.armoroftheages.loot;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemDamageFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import org.dawnoftime.armoroftheages.ArmorOfTheAgesFabric;
import org.dawnoftime.armoroftheages.Constants;
import org.dawnoftime.armoroftheages.config.AOTAConfig;

import java.util.List;

public class AmorOfTheAgesLootModifiersFabric {

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            switch (key.location().toString()) {
                case LootTablesToModify.ABANDONED_MINESHAFT,
                     LootTablesToModify.SHIPWRECK_SUPPLY,
                     LootTablesToModify.VILLAGE_TAIGA_HOUSE -> buildLootTable(Constants.BAMBOO_HAT_NAME, 1.0f, 0.35f, tableBuilder);

                case LootTablesToModify.SIMPLE_DUNGEON -> {
                    buildLootTable(Constants.JAPANESE_LIGHT_ARMOR_NAME, 0.5f, 0.5f, tableBuilder);
                    buildLootTable(Constants.IRON_PLATE_ARMOR_NAME, 0.25f, 0.35f, tableBuilder);
                }
                case LootTablesToModify.VILLAGE_WEAPONSMITH -> buildLootTable(Constants.JAPANESE_LIGHT_ARMOR_NAME, 0.7f, 1.0f, tableBuilder);
                case LootTablesToModify.RUINED_PORTAL -> buildLootTable(Constants.CENTURION_ARMOR_NAME, 0.15f, 1.0f, tableBuilder);
                case LootTablesToModify.VILLAGE_ARMORER -> buildLootTable(Constants.IRON_PLATE_ARMOR_NAME, 0.15f, 0.5f, tableBuilder);
                case LootTablesToModify.SHIPWRECK_TREASURE -> buildLootTable(Constants.O_YOROI_ARMOR_NAME, 0.15f, 1.0f, tableBuilder);
                case LootTablesToModify.DESERT_PYRAMID -> buildLootTable(Constants.PHARAOH_ARMOR_NAME, 0.15f, 0.7f, tableBuilder);
                case LootTablesToModify.ANCIENT_CITY -> buildLootTable(Constants.EXALTED_AURUM_ARMOR_NAME, 0.7f, 0.35f, tableBuilder);
                case LootTablesToModify.VILLAGE_TEMPLE -> buildLootTable(Constants.HOLY_ARMOR_NAME, 0.15f, 0.5f, tableBuilder);
                case LootTablesToModify.JUNGLE_TEMPLE -> buildLootTable(Constants.QUETZALCOATL_ARMOR_NAME, 0.15f, 1.0f, tableBuilder);
                case LootTablesToModify.BASTION_TREASURE -> buildLootTable(Constants.RAIJIN_ARMOR_NAME, 0.7f, 1.0f, tableBuilder);
            }
        });
    }

    private static void buildLootTable(String armorSetName, float damage, float probability, LootTable.Builder tableBuilder) {
        boolean shouldGenerate = LootTablesToModify.ARMOR_GENERATION_MAP.getOrDefault(armorSetName, false);

        if (AOTAConfig.get().generateArmorLoot && shouldGenerate) {
            List<ResourceLocation> armorPieceLocations = ArmorOfTheAgesFabric.ItemRegistryImpl
                    .ARMORS_LOCATION_FROM_NAME
                    .get(armorSetName);

            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ConstantValue.exactly(1f))
                    .conditionally(LootItemRandomChanceCondition.randomChance(probability).build());

            for (var armorPieceLocation : armorPieceLocations) {
                Item armorPieceItem = BuiltInRegistries.ITEM.get(armorPieceLocation);

                poolBuilder.with(LootItem.lootTableItem(armorPieceItem)
                                .setWeight(1)
                                .build())
                        .apply(SetItemDamageFunction.setDamage(ConstantValue.exactly(damage)))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1f)));
            }

            tableBuilder.pool(poolBuilder.build());
        }
    }
}
