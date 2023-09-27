package com.dotteam.armorweapons.util;

import com.dotteam.armorweapons.DoTAWConfig;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class DoTBMaterials {

	public enum DoTArmorMaterial implements ArmorMaterial {
		IRON_PLATE("iron_plate",
				DoTAWConfig.IRON_PLATE_ARMOR_CONFIG,
				SoundEvents.ARMOR_EQUIP_IRON,
				() -> Ingredient.of(Items.IRON_BLOCK.asItem())),
		HOLY("holy",
				DoTAWConfig.HOLY_ARMOR_CONFIG,
				SoundEvents.ARMOR_EQUIP_DIAMOND,
				() -> Ingredient.of(Blocks.GOLD_BLOCK.asItem())),
		JAPANESE_LIGHT(
				"japanese_light",
				DoTAWConfig.JAPANESE_LIGHT_ARMOR_CONFIG,
				SoundEvents.ARMOR_EQUIP_LEATHER,
				() -> Ingredient.of(Items.LEATHER)),
		O_YOROI("o_yoroi",
				DoTAWConfig.O_YOROI_ARMOR_CONFIG,
				SoundEvents.ARMOR_EQUIP_IRON,
				() -> Ingredient.of(Items.REDSTONE_BLOCK.asItem())),
		RAIJIN("raijin",
				DoTAWConfig.RAIJIN_ARMOR_CONFIG,
				SoundEvents.ARMOR_EQUIP_LEATHER,
				() -> Ingredient.of(Blocks.GOLD_BLOCK.asItem())),
		PHARAOH("pharaoh",
				DoTAWConfig.PHARAOH_ARMOR_CONFIG,
				SoundEvents.ARMOR_EQUIP_GOLD,
				() -> Ingredient.of(Items.GOLD_BLOCK.asItem())),
		ANUBIS("anubis",
				DoTAWConfig.ANUBIS_ARMOR_CONFIG,
				SoundEvents.ARMOR_EQUIP_GOLD,
				() -> Ingredient.of(Blocks.LAPIS_BLOCK.asItem())),
		CENTURION("centurion",
			   DoTAWConfig.CENTURION_ARMOR_CONFIG,
				SoundEvents.ARMOR_EQUIP_CHAIN,
				() -> Ingredient.of(Blocks.GOLD_BLOCK.asItem())),
		QUETZALCOATL("quetzalcoatl",
				DoTAWConfig.QUETZALCOATL_ARMOR_CONFIG,
				SoundEvents.ARMOR_EQUIP_TURTLE,
				() -> Ingredient.of(Items.FEATHER));

		private static final int[] MAX_DAMAGE_ARRAY = {13, 15, 16, 11 };
		private final String name;
		private final DoTAWConfig.ArmorConfig armorConfig;
		private final SoundEvent soundEvent;
		private final Supplier<Ingredient> repairMaterial;

		/**
		 * @param nameIn                   Material name.
		 * @param config			       Armor config that contains all the parameters of the armor (durability, armor, enchantability, toughness)
		 * @param equipSoundIn             Sound when equipped.
		 * @param repairMaterialSupplier   Ingredient used to repair the armor.
		 */
		DoTArmorMaterial(final String nameIn, DoTAWConfig.ArmorConfig config, final SoundEvent equipSoundIn, final Supplier<Ingredient> repairMaterialSupplier) {
			this.name = nameIn;
			this.armorConfig = config;
			this.soundEvent = equipSoundIn;
			this.repairMaterial = repairMaterialSupplier;
		}

		@Override
		public int getDurabilityForType(ArmorItem.Type slot) {
			return DoTArmorMaterial.MAX_DAMAGE_ARRAY[slot.getSlot().getIndex()] * this.armorConfig.durabilitySupplier().get();
		}

		@Override
		public int getDefenseForType(ArmorItem.Type slot) {
			return switch (slot) {
				case BOOTS -> this.armorConfig.feetDefSupplier().get();
				case LEGGINGS -> this.armorConfig.legsDefSupplier().get();
				case CHESTPLATE -> this.armorConfig.chestDefSupplier().get();
				case HELMET -> this.armorConfig.helmetDefSupplier().get();
			};
		}

		@Override
		public int getEnchantmentValue() {
			return this.armorConfig.enchantabilitySupplier().get();
		}

		@Override
		public @NotNull SoundEvent getEquipSound() {
			return this.soundEvent;
		}

		@Override
		public @NotNull Ingredient getRepairIngredient() {
			return this.repairMaterial.get();
		}

		@NotNull
		@Override
		@OnlyIn(Dist.CLIENT)
		public String getName() {
			return this.name;
		}

		@Override
		public float getToughness() {
			return this.armorConfig.toughnessSupplier().get();
		}

		@Override
		public float getKnockbackResistance() {
			return 0;
		}
	}

	/*
	 * I keep this here in case we want to add some tools public enum ItemMaterial
	 * implements IItemTier { WOOD(0, 59, 2.0F, 0.0F, 15, () -> { return
	 * Ingredient.fromTag(ItemTags.PLANKS); }), STONE(1, 131, 4.0F, 1.0F, 5, () -> {
	 * return Ingredient.of(Blocks.COBBLESTONE); }), IRON(2, 250, 6.0F, 2.0F, 14, ()
	 * -> { return Ingredient.of(Items.IRON_INGOT); }), DIAMOND(3, 1561, 8.0F, 3.0F,
	 * 10, () -> { return Ingredient.of(Items.DIAMOND); }), GOLD(0, 32, 12.0F, 0.0F,
	 * 22, () -> { return Ingredient.of(Items.GOLD_INGOT); });
	 *
	 * private final int harvestLevel; private final int maxUses; private final
	 * float efficiency; private final float attackDamage; private final int
	 * enchantability; private final LazyLoadBase<Ingredient> repairMaterial;
	 *
	 * ItemMaterial(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float
	 * attackDamageIn, int enchantabilityIn, Supplier<Ingredient> repairMaterialIn)
	 * { this.harvestLevel = harvestLevelIn; this.maxUses = maxUsesIn;
	 * this.efficiency = efficiencyIn; this.attackDamage = attackDamageIn;
	 * this.enchantability = enchantabilityIn; this.repairMaterial = new
	 * LazyLoadBase<>(repairMaterialIn); }
	 *
	 * public int getMaxUses() { return this.maxUses; }
	 *
	 * public float getEfficiency() { return this.efficiency; }
	 *
	 * public float getAttackDamage() { return this.attackDamage; }
	 *
	 * public int getHarvestLevel() { return this.harvestLevel; }
	 *
	 * public int getEnchantability() { return this.enchantability; }
	 *
	 * public Ingredient getRepairMaterial() { return
	 * this.repairMaterial.getValue(); } }
	 *
	 */
}