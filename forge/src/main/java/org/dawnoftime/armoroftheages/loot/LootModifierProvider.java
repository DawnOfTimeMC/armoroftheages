package org.dawnoftime.armoroftheages.loot;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;
import org.dawnoftime.armoroftheages.Constants;

public class LootModifierProvider extends GlobalLootModifierProvider {

    public LootModifierProvider(PackOutput output) {
        super(output, Constants.MOD_ID);
    }

    @Override
    protected void start() {
        add("bamboo_hat_in_mineshaft", buildLootTable(Constants.BAMBOO_HAT_NAME, 1.0f, 0.35f, LootTablesToModify.ABANDONED_MINESHAFT));
        add("bamboo_hat_in_shipwreck_supply", buildLootTable(Constants.BAMBOO_HAT_NAME, 1.0f, 0.35f, LootTablesToModify.SHIPWRECK_SUPPLY));
        add("bamboo_hat_in_village_taiga_house", buildLootTable(Constants.BAMBOO_HAT_NAME, 1.0f, 0.35f, LootTablesToModify.VILLAGE_TAIGA_HOUSE));
        add("japanese_light_in_simple_dungeon", buildLootTable(Constants.JAPANESE_LIGHT_ARMOR_NAME, 0.5f, 0.5f, LootTablesToModify.SIMPLE_DUNGEON));
        add("iron_plate_in_simple_dungeon", buildLootTable(Constants.IRON_PLATE_ARMOR_NAME, 0.25f, 0.35f, LootTablesToModify.SIMPLE_DUNGEON));
        add("japanese_light_in_village_weapnsmith", buildLootTable(Constants.JAPANESE_LIGHT_ARMOR_NAME, 0.7f, 1.0f, LootTablesToModify.VILLAGE_WEAPONSMITH));
        add("centurion_in_ruined_portal", buildLootTable(Constants.CENTURION_ARMOR_NAME, 0.15f, 1.0f, LootTablesToModify.RUINED_PORTAL));
        add("iron_plate_in_village_armorer", buildLootTable(Constants.IRON_PLATE_ARMOR_NAME, 0.15f, 0.5f, LootTablesToModify.VILLAGE_ARMORER));
        add("o_yoroi_in_shipwreck_treasure", buildLootTable(Constants.O_YOROI_ARMOR_NAME, 0.15f, 1.0f, LootTablesToModify.SHIPWRECK_TREASURE));
        add("pharaoh_in_desert_pyramid", buildLootTable(Constants.PHARAOH_ARMOR_NAME, 0.15f, 0.7f, LootTablesToModify.DESERT_PYRAMID));
        add("exalted_aurum_in_ancient_city", buildLootTable(Constants.EXALTED_AURUM_ARMOR_NAME, 0.7f, 0.35f, LootTablesToModify.ANCIENT_CITY));
        add("holy_in_village_temple", buildLootTable(Constants.HOLY_ARMOR_NAME, 0.15f, 0.5f, LootTablesToModify.VILLAGE_TEMPLE));
        add("quetzalcoatl_in_jungle_temple", buildLootTable(Constants.QUETZALCOATL_ARMOR_NAME, 0.15f, 1.0f, LootTablesToModify.JUNGLE_TEMPLE));
        add("raijin_in_bastion_treasure", buildLootTable(Constants.RAIJIN_ARMOR_NAME, 0.7f, 1.0f, LootTablesToModify.BASTION_TREASURE));
    }

    private AmorOfTheAgesLootModifiersForge buildLootTable(String armorSetName, float damage, float probability, String lootTableName) {
        return new AmorOfTheAgesLootModifiersForge(
                new LootItemCondition[] {
                        LootTableIdCondition.builder(new ResourceLocation(lootTableName)).build(),
                        LootItemRandomChanceCondition.randomChance(probability).build()
                },
                armorSetName,
                damage
        );
    }
}
