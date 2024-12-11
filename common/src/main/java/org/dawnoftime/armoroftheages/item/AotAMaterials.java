package org.dawnoftime.armoroftheages.item;

import java.util.function.Supplier;
import org.jetbrains.annotations.NotNull;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;

public class AotAMaterials {

	public enum DoTArmorMaterial implements ArmorMaterial {
		IRON_PLATE("iron_plate",				25, 3, 9, 7, 3,  6, 0.0F, SoundEvents.ARMOR_EQUIP_IRON, () -> Ingredient.of(Items.IRON_BLOCK.asItem())),
		HOLY("holy",							40, 4,10, 8, 4,  4, 2.0F, SoundEvents.ARMOR_EQUIP_DIAMOND, () -> Ingredient.of(Blocks.GOLD_BLOCK.asItem())),
		EXALTED_AURUM("exalted_aurum",		35, 3, 9, 7, 3,  12, 3.0F, SoundEvents.ARMOR_EQUIP_IRON, () -> Ingredient.of(Items.GOLD_BLOCK.asItem())),
		JAPANESE_LIGHT("japanese_light",		12, 2, 7, 6, 2, 10, 0.0F, SoundEvents.ARMOR_EQUIP_LEATHER, () -> Ingredient.of(Items.LEATHER)),
		O_YOROI("o_yoroi",					20, 3, 8, 6, 3, 16, 2.0F, SoundEvents.ARMOR_EQUIP_IRON, () -> Ingredient.of(Items.REDSTONE_BLOCK.asItem())),
		RAIJIN("raijin",						35, 3, 9, 7, 3, 26, 2.0F, SoundEvents.ARMOR_EQUIP_LEATHER, () -> Ingredient.of(Blocks.GOLD_BLOCK.asItem())),
		PHARAOH("pharaoh",					10, 3, 8, 6, 3, 37, 2.0F, SoundEvents.ARMOR_EQUIP_GOLD, () -> Ingredient.of(Items.GOLD_BLOCK.asItem())),
		ANUBIS("anubis",						25, 3, 8, 6, 3, 52, 3.0F, SoundEvents.ARMOR_EQUIP_GOLD, () -> Ingredient.of(Blocks.LAPIS_BLOCK.asItem())),
		CENTURION("centurion",				22, 3, 7, 5, 3, 10, 3.0F, SoundEvents.ARMOR_EQUIP_CHAIN, () -> Ingredient.of(Blocks.GOLD_BLOCK.asItem())),
		QUETZALCOATL("quetzalcoatl",			25, 2, 6, 5, 2, 20, 6.0F, SoundEvents.ARMOR_EQUIP_TURTLE, () -> Ingredient.of(Items.FEATHER));

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