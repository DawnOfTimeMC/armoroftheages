package org.armoroftheages.item;

import net.minecraft.item.Item;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ITagCollection;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import org.armoroftheages.AotAConfig;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public class AotAMaterials {

	private static final ResourceLocation IRON_BLOCK_RL = new ResourceLocation("forge:storage_blocks/iron");
	private static final ResourceLocation GOLD_BLOCK_RL = new ResourceLocation("forge:storage_blocks/gold");
	private static final ResourceLocation LAPIS_BLOCK_RL = new ResourceLocation("forge:storage_blocks/lapis");
	private static final ResourceLocation REDSTONE_BLOCK_RL = new ResourceLocation("forge:storage_blocks/redstone");
	private static final ResourceLocation LEATHER_RL = new ResourceLocation("forge:leather");
	private static final ResourceLocation FEATHERS_RL = new ResourceLocation("forge:feathers");

	public enum ArmorMaterial implements IArmorMaterial {
		IRON_PLATE("iron_plate", AotAConfig.IRON_PLATE_ARMOR_CONFIG, SoundEvents.ARMOR_EQUIP_IRON, IRON_BLOCK_RL),
		HOLY("holy", AotAConfig.HOLY_ARMOR_CONFIG, SoundEvents.ARMOR_EQUIP_DIAMOND, GOLD_BLOCK_RL),
		JAPANESE_LIGHT("japanese_light", AotAConfig.JAPANESE_LIGHT_ARMOR_CONFIG, SoundEvents.ARMOR_EQUIP_LEATHER, LEATHER_RL),
		O_YOROI("o_yoroi", AotAConfig.O_YOROI_ARMOR_CONFIG, SoundEvents.ARMOR_EQUIP_IRON, REDSTONE_BLOCK_RL),
		RAIJIN("raijin", AotAConfig.RAIJIN_ARMOR_CONFIG, SoundEvents.ARMOR_EQUIP_LEATHER, GOLD_BLOCK_RL),
		PHARAOH("pharaoh", AotAConfig.PHARAOH_ARMOR_CONFIG, SoundEvents.ARMOR_EQUIP_GOLD, GOLD_BLOCK_RL),
		ANUBIS("anubis", AotAConfig.ANUBIS_ARMOR_CONFIG, SoundEvents.ARMOR_EQUIP_GOLD, LAPIS_BLOCK_RL),
		CENTURION("centurion", AotAConfig.CENTURION_ARMOR_CONFIG, SoundEvents.ARMOR_EQUIP_CHAIN, GOLD_BLOCK_RL),
		QUETZALCOATL("quetzalcoatl", AotAConfig.QUETZALCOATL_ARMOR_CONFIG, SoundEvents.ARMOR_EQUIP_TURTLE, FEATHERS_RL);
		private static final int[] MAX_DAMAGE_ARRAY = {13, 15, 16, 11 };
		private final String name;
		private final AotAConfig.ArmorConfig armorConfig;
		private final SoundEvent soundEvent;
		private final Supplier<Ingredient> repairMaterial;

		/**
		 * @param nameIn                   Material name.
		 * @param config			       Armor config that contains all the parameters of the armor
		 *                                    (durability, armor, enchantability, toughness)
		 * @param equipSoundIn             Sound when equipped.
		 * @param repairRL   Ingredient used to repair the armor.
		 */
		ArmorMaterial(final String nameIn, AotAConfig.ArmorConfig config, final SoundEvent equipSoundIn, final ResourceLocation repairRL) {
			this.name = nameIn;
			this.armorConfig = config;
			this.soundEvent = equipSoundIn;
			this.repairMaterial = () -> getIngredient(repairRL);
		}

		private static Ingredient getIngredient(ResourceLocation repairRL){
			ITagCollection<Item> temp = ItemTags.getAllTags();
			ITag<Item> tag = ItemTags.getAllTags().getTag(repairRL);
			return tag != null && !tag.getValues().isEmpty() ? Ingredient.of(tag) : Ingredient.EMPTY;
		}

		@Override
		public int getDefenseForSlot(final EquipmentSlotType slotIn) {
			switch (slotIn) {
			case FEET:
				return this.armorConfig.feetDefSupplier().get();

			case LEGS:
				return this.armorConfig.legsDefSupplier().get();

			case CHEST:
				return this.armorConfig.chestDefSupplier().get();

			case HEAD:
				return this.armorConfig.helmetDefSupplier().get();

			default:
				return 0;
			}
		}

		@Override
		public int getEnchantmentValue() {
			return this.armorConfig.enchantabilitySupplier().get();
		}

		@Override
		public SoundEvent getEquipSound() {
			return this.soundEvent;
		}

		@Override
		public Ingredient getRepairIngredient() {
			return this.repairMaterial.get();
		}

		@Override
		public int getDurabilityForSlot(final EquipmentSlotType slotIn) {
			return ArmorMaterial.MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.armorConfig.durabilitySupplier().get();
		}

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