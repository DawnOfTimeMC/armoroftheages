package org.dawnoftime.armoroftheages.item;

import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import org.dawnoftime.armoroftheages.config.AOTAConfig;
import org.dawnoftime.armoroftheages.registry.ArmorMaterialRegistry;

import java.util.List;
import java.util.Map;

public class AotAMaterials {

	private static Map<ArmorItem.Type, Integer> createDefenseMap(int helmet, int chestplate, int leggings, int boots) {
		return Map.of(
			ArmorItem.Type.HELMET, helmet,
			ArmorItem.Type.CHESTPLATE, chestplate,
			ArmorItem.Type.LEGGINGS, leggings,
			ArmorItem.Type.BOOTS, boots
		);
	}

	private static List<ArmorMaterial.Layer> createLayers(String name) {
		ResourceLocation assetName = ResourceLocation.fromNamespaceAndPath("armoroftheages", name);
		return List.of(new ArmorMaterial.Layer(assetName));
	}

	public static final Holder<ArmorMaterial> IRON_PLATE = ArmorMaterialRegistry.REGISTRY.register("iron_plate", new ArmorMaterial(
		createDefenseMap(
			AOTAConfig.get().ironPlateHelmetDef,
			AOTAConfig.get().ironPlateChestDef,
			AOTAConfig.get().ironPlateLegsDef,
			AOTAConfig.get().ironPlateFeetDef
		),
		AOTAConfig.get().ironPlateEnchantability,
		SoundEvents.ARMOR_EQUIP_IRON,
		() -> Ingredient.of(Items.IRON_INGOT),
		createLayers("iron_plate"),
		AOTAConfig.get().ironPlateToughness,
		0.0F
	));

	public static final Holder<ArmorMaterial> HOLY = ArmorMaterialRegistry.REGISTRY.register("holy", new ArmorMaterial(
		createDefenseMap(
			AOTAConfig.get().holyHelmetDef,
			AOTAConfig.get().holyChestDef,
			AOTAConfig.get().holyLegsDef,
			AOTAConfig.get().holyFeetDef
		),
		AOTAConfig.get().holyEnchantability,
		SoundEvents.ARMOR_EQUIP_DIAMOND,
		() -> Ingredient.of(Items.NETHERITE_INGOT),
		createLayers("holy"),
		AOTAConfig.get().holyToughness,
		AOTAConfig.get().holyKnockbackResistance
	));

	public static final Holder<ArmorMaterial> EXALTED_AURUM = ArmorMaterialRegistry.REGISTRY.register("exalted_aurum", new ArmorMaterial(
		createDefenseMap(
			AOTAConfig.get().exaltedAurumHelmetDef,
			AOTAConfig.get().exaltedAurumChestDef,
			AOTAConfig.get().exaltedAurumLegsDef,
			AOTAConfig.get().exaltedAurumFeetDef
		),
		AOTAConfig.get().exaltedAurumEnchantability,
		SoundEvents.ARMOR_EQUIP_IRON,
		() -> Ingredient.of(Items.NETHERITE_INGOT),
		createLayers("exalted_aurum"),
		AOTAConfig.get().exaltedAurumToughness,
		AOTAConfig.get().exaltedAurumKnockbackResistance
	));

	public static final Holder<ArmorMaterial> JAPANESE_LIGHT = ArmorMaterialRegistry.REGISTRY.register("japanese_light", new ArmorMaterial(
		createDefenseMap(
			AOTAConfig.get().japaneseLightHelmetDef,
			AOTAConfig.get().japaneseLightChestDef,
			AOTAConfig.get().japaneseLightLegsDef,
			AOTAConfig.get().japaneseLightFeetDef
		),
		AOTAConfig.get().japaneseLightEnchantability,
		SoundEvents.ARMOR_EQUIP_LEATHER,
		() -> Ingredient.of(Items.LEATHER),
		createLayers("japanese_light"),
		AOTAConfig.get().japaneseLightToughness,
		0.0F
	));

	public static final Holder<ArmorMaterial> O_YOROI = ArmorMaterialRegistry.REGISTRY.register("o_yoroi", new ArmorMaterial(
		createDefenseMap(
			AOTAConfig.get().oYoroiHelmetDef,
			AOTAConfig.get().oYoroiChestDef,
			AOTAConfig.get().oYoroiLegsDef,
			AOTAConfig.get().oYoroiFeetDef
		),
		AOTAConfig.get().oYoroiEnchantability,
		SoundEvents.ARMOR_EQUIP_IRON,
		() -> Ingredient.of(Items.IRON_INGOT),
		createLayers("o_yoroi"),
		AOTAConfig.get().oYoroiToughness,
		0.0F
	));

	public static final Holder<ArmorMaterial> RAIJIN = ArmorMaterialRegistry.REGISTRY.register("raijin", new ArmorMaterial(
		createDefenseMap(
			AOTAConfig.get().raijinHelmetDef,
			AOTAConfig.get().raijinChestDef,
			AOTAConfig.get().raijinLegsDef,
			AOTAConfig.get().raijinFeetDef
		),
		AOTAConfig.get().raijinEnchantability,
		SoundEvents.ARMOR_EQUIP_LEATHER,
		() -> Ingredient.of(Items.NETHERITE_INGOT),
		createLayers("raijin"),
		AOTAConfig.get().raijinToughness,
		AOTAConfig.get().raijinKnockbackResistance
	));

	public static final Holder<ArmorMaterial> PHARAOH = ArmorMaterialRegistry.REGISTRY.register("pharaoh", new ArmorMaterial(
		createDefenseMap(
			AOTAConfig.get().pharaohHelmetDef,
			AOTAConfig.get().pharaohChestDef,
			AOTAConfig.get().pharaohLegsDef,
			AOTAConfig.get().pharaohFeetDef
		),
		AOTAConfig.get().pharaohEnchantability,
		SoundEvents.ARMOR_EQUIP_GOLD,
		() -> Ingredient.of(Blocks.LAPIS_BLOCK),
		createLayers("pharaoh"),
		AOTAConfig.get().pharaohToughness,
		0.0F
	));

	public static final Holder<ArmorMaterial> ANUBIS = ArmorMaterialRegistry.REGISTRY.register("anubis", new ArmorMaterial(
		createDefenseMap(
			AOTAConfig.get().anubisHelmetDef,
			AOTAConfig.get().anubisChestDef,
			AOTAConfig.get().anubisLegsDef,
			AOTAConfig.get().anubisFeetDef
		),
		AOTAConfig.get().anubisEnchantability,
		SoundEvents.ARMOR_EQUIP_GOLD,
		() -> Ingredient.of(Items.NETHERITE_INGOT),
		createLayers("anubis"),
		AOTAConfig.get().anubisToughness,
		AOTAConfig.get().anubisKnockbackResistance
	));

	public static final Holder<ArmorMaterial> CENTURION = ArmorMaterialRegistry.REGISTRY.register("centurion", new ArmorMaterial(
		createDefenseMap(
			AOTAConfig.get().centurionHelmetDef,
			AOTAConfig.get().centurionChestDef,
			AOTAConfig.get().centurionLegsDef,
			AOTAConfig.get().centurionFeetDef
		),
		AOTAConfig.get().centurionEnchantability,
		SoundEvents.ARMOR_EQUIP_CHAIN,
		() -> Ingredient.of(Items.GOLD_INGOT),
		createLayers("centurion"),
		AOTAConfig.get().centurionToughness,
		0.0F
	));

	public static final Holder<ArmorMaterial> QUETZALCOATL = ArmorMaterialRegistry.REGISTRY.register("quetzalcoatl", new ArmorMaterial(
		createDefenseMap(
			AOTAConfig.get().quetzalcoatlHelmetDef,
			AOTAConfig.get().quetzalcoatlChestDef,
			AOTAConfig.get().quetzalcoatlLegsDef,
			AOTAConfig.get().quetzalcoatlFeetDef
		),
		AOTAConfig.get().quetzalcoatlEnchantability,
		SoundEvents.ARMOR_EQUIP_TURTLE,
		() -> Ingredient.of(Items.NETHERITE_INGOT),
		createLayers("quetzalcoatl"),
		AOTAConfig.get().quetzalcoatlToughness,
		AOTAConfig.get().quetzalcoatlKnockbackResistance
	));
}