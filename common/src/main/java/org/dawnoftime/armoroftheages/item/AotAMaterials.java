package org.dawnoftime.armoroftheages.item;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import org.dawnoftime.armoroftheages.config.AOTAConfig;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class AotAMaterials {

	public enum DoTArmorMaterial implements ArmorMaterial {
		IRON_PLATE("iron_plate",
				AOTAConfig.get().ironPlateDurability,
				AOTAConfig.get().ironPlateHelmetDef,
				AOTAConfig.get().ironPlateChestDef,
				AOTAConfig.get().ironPlateLegsDef,
				AOTAConfig.get().ironPlateFeetDef,
				AOTAConfig.get().ironPlateEnchantability,
				AOTAConfig.get().ironPlateToughness,
				SoundEvents.ARMOR_EQUIP_IRON,
				() -> Ingredient.of(Items.IRON_BLOCK)),

		HOLY("holy",
				AOTAConfig.get().holyDurability,
				AOTAConfig.get().holyHelmetDef,
				AOTAConfig.get().holyChestDef,
				AOTAConfig.get().holyLegsDef,
				AOTAConfig.get().holyFeetDef,
				AOTAConfig.get().holyEnchantability,
				AOTAConfig.get().holyToughness,
				SoundEvents.ARMOR_EQUIP_DIAMOND,
				() -> Ingredient.of(Blocks.GOLD_BLOCK)),

		EXALTED_AURUM("exalted_aurum",
				AOTAConfig.get().exaltedAurumDurability,
				AOTAConfig.get().exaltedAurumHelmetDef,
				AOTAConfig.get().exaltedAurumChestDef,
				AOTAConfig.get().exaltedAurumLegsDef,
				AOTAConfig.get().exaltedAurumFeetDef,
				AOTAConfig.get().exaltedAurumEnchantability,
				AOTAConfig.get().exaltedAurumToughness,
				SoundEvents.ARMOR_EQUIP_IRON,
				() -> Ingredient.of(Items.GOLD_BLOCK)),

		JAPANESE_LIGHT("japanese_light",
				AOTAConfig.get().japaneseLightDurability,
				AOTAConfig.get().japaneseLightHelmetDef,
				AOTAConfig.get().japaneseLightChestDef,
				AOTAConfig.get().japaneseLightLegsDef,
				AOTAConfig.get().japaneseLightFeetDef,
				AOTAConfig.get().japaneseLightEnchantability,
				AOTAConfig.get().japaneseLightToughness,
				SoundEvents.ARMOR_EQUIP_LEATHER,
				() -> Ingredient.of(Items.LEATHER)),

		O_YOROI("o_yoroi",
				AOTAConfig.get().oYoroiDurability,
				AOTAConfig.get().oYoroiHelmetDef,
				AOTAConfig.get().oYoroiChestDef,
				AOTAConfig.get().oYoroiLegsDef,
				AOTAConfig.get().oYoroiFeetDef,
				AOTAConfig.get().oYoroiEnchantability,
				AOTAConfig.get().oYoroiToughness,
				SoundEvents.ARMOR_EQUIP_IRON,
				() -> Ingredient.of(Items.REDSTONE_BLOCK)),

		RAIJIN("raijin",
				AOTAConfig.get().raijinDurability,
				AOTAConfig.get().raijinHelmetDef,
				AOTAConfig.get().raijinChestDef,
				AOTAConfig.get().raijinLegsDef,
				AOTAConfig.get().raijinFeetDef,
				AOTAConfig.get().raijinEnchantability,
				AOTAConfig.get().raijinToughness,
				SoundEvents.ARMOR_EQUIP_LEATHER,
				() -> Ingredient.of(Blocks.GOLD_BLOCK)),

		PHARAOH("pharaoh",
				AOTAConfig.get().pharaohDurability,
				AOTAConfig.get().pharaohHelmetDef,
				AOTAConfig.get().pharaohChestDef,
				AOTAConfig.get().pharaohLegsDef,
				AOTAConfig.get().pharaohFeetDef,
				AOTAConfig.get().pharaohEnchantability,
				AOTAConfig.get().pharaohToughness,
				SoundEvents.ARMOR_EQUIP_GOLD,
				() -> Ingredient.of(Items.GOLD_BLOCK)),

		ANUBIS("anubis",
				AOTAConfig.get().anubisDurability,
				AOTAConfig.get().anubisHelmetDef,
				AOTAConfig.get().anubisChestDef,
				AOTAConfig.get().anubisLegsDef,
				AOTAConfig.get().anubisFeetDef,
				AOTAConfig.get().anubisEnchantability,
				AOTAConfig.get().anubisToughness,
				SoundEvents.ARMOR_EQUIP_GOLD,
				() -> Ingredient.of(Blocks.LAPIS_BLOCK)),

		CENTURION("centurion",
				AOTAConfig.get().centurionDurability,
				AOTAConfig.get().centurionHelmetDef,
				AOTAConfig.get().centurionChestDef,
				AOTAConfig.get().centurionLegsDef,
				AOTAConfig.get().centurionFeetDef,
				AOTAConfig.get().centurionEnchantability,
				AOTAConfig.get().centurionToughness,
				SoundEvents.ARMOR_EQUIP_CHAIN,
				() -> Ingredient.of(Blocks.GOLD_BLOCK)),

		QUETZALCOATL("quetzalcoatl",
				AOTAConfig.get().quetzalcoatlDurability,
				AOTAConfig.get().quetzalcoatlHelmetDef,
				AOTAConfig.get().quetzalcoatlChestDef,
				AOTAConfig.get().quetzalcoatlLegsDef,
				AOTAConfig.get().quetzalcoatlFeetDef,
				AOTAConfig.get().quetzalcoatlEnchantability,
				AOTAConfig.get().quetzalcoatlToughness,
				SoundEvents.ARMOR_EQUIP_TURTLE,
				() -> Ingredient.of(Items.FEATHER));

		private static final int[] MAX_DAMAGE_ARRAY = {13, 15, 16, 11};
		private final String name;
		private final int durability;
		private final int helmetDef;
		private final int chestDef;
		private final int legsDef;
		private final int feetDef;
		private final int enchantability;
		private final float toughness;
		private final SoundEvent soundEvent;
		private final Supplier<Ingredient> repairMaterial;

		DoTArmorMaterial(final String nameIn, int durability, int helmetDef, int chestDef,int legsDef, int feetDef, int enchantability, float toughness, final SoundEvent equipSoundIn, final Supplier<Ingredient> repairMaterialSupplier) {
			this.name = nameIn;
			this.durability = durability;
			this.helmetDef = helmetDef;
			this.chestDef = chestDef;
			this.legsDef = legsDef;
			this.feetDef = feetDef;
			this.enchantability = enchantability;
			this.toughness = toughness;
			this.soundEvent = equipSoundIn;
			this.repairMaterial = repairMaterialSupplier;
		}

		@Override
		public int getDurabilityForType(ArmorItem.Type slot) {
			return DoTArmorMaterial.MAX_DAMAGE_ARRAY[slot.getSlot().getIndex()] * this.durability;
		}

		@Override
		public int getDefenseForType(ArmorItem.Type slot) {
			return switch (slot) {
				case BOOTS -> this.feetDef;
				case LEGGINGS -> this.legsDef;
				case CHESTPLATE -> this.chestDef;
				case HELMET -> this.helmetDef;
			};
		}

		@Override
		public int getEnchantmentValue() {
			return this.enchantability;
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
		public String getName() {
			return this.name;
		}

		@Override
		public float getToughness() {
			return this.toughness;
		}

		@Override
		public float getKnockbackResistance() {
			return 0;
		}
	}
}