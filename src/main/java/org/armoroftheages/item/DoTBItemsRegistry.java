package org.armoroftheages.item;

import static net.minecraft.inventory.EquipmentSlotType.CHEST;
import static net.minecraft.inventory.EquipmentSlotType.FEET;
import static net.minecraft.inventory.EquipmentSlotType.HEAD;
import static net.minecraft.inventory.EquipmentSlotType.LEGS;
import static org.armoroftheages.item.DoTBMaterials.ArmorMaterial.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.armoroftheages.armor_models.*;
import org.armoroftheages.ArmorOfTheAges;
import org.armoroftheages.DoTBConfig;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DoTBItemsRegistry {

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ArmorOfTheAges.MOD_ID);

	// Armors
	// TODO optimize, avoid to create several instance of armor model
	public static final ArmorSetRegistryObject ANUBIS_ARMOR_SET = new ArmorSetRegistryObject("anubis_armor", ANUBIS, () -> AnubisArmorModel::new);
	public static final ArmorSetRegistryObject CENTURION_ARMOR_SET = new ArmorSetRegistryObject("centurion_armor", CENTURION, () -> CenturionArmorModel::new);
	public static final ArmorSetRegistryObject IRON_PLATE_ARMOR_SET = new ArmorSetRegistryObject("iron_plate_armor", IRON_PLATE, () -> IronPlateArmorModel::new);
	public static final ArmorSetRegistryObject HOLY_ARMOR_SET = new ArmorSetRegistryObject("holy_armor", HOLY, () -> HolyArmorModel::new);
	public static final ArmorSetRegistryObject PHARAOH_ARMOR_SET = new ArmorSetRegistryObject("pharaoh_armor", PHARAOH, () -> PharaohArmorModel::new);
	public static final ArmorSetRegistryObject JAPANESE_LIGHT_ARMOR_SET = new ArmorSetRegistryObject("japanese_light_armor", JAPANESE_LIGHT, () -> JapaneseLightArmorModel::new);
	public static final ArmorSetRegistryObject O_YOROI_ARMOR_SET = new ArmorSetRegistryObject("o_yoroi_armor", O_YOROI, () -> OYoroiArmorModel::new);
	public static final ArmorSetRegistryObject QUETZALCOATL_ARMOR_SET = new ArmorSetRegistryObject("quetzalcoatl_armor", QUETZALCOATL, () -> QuetzalcoatlModel::new);
	public static final ArmorSetRegistryObject RAIJIN_ARMOR_SET = new ArmorSetRegistryObject("raijin_armor", RAIJIN, () -> RaijinArmorModel::new);

	public final static class ArmorSetRegistryObject {
		private static final EquipmentSlotType[] SLOT_LIST = {HEAD, CHEST, LEGS, FEET };
		private final IArmorMaterial material;
		public final RegistryObject<Item> head;
		public final RegistryObject<Item> chest;
		public final RegistryObject<Item> legs;
		public final RegistryObject<Item> feet;
		public final Supplier<CustomArmorItem.ArmorModelFactory> factorySupplier;

		private ArmorSetRegistryObject(final String setNameIn, final IArmorMaterial materialIn, Supplier<CustomArmorItem.ArmorModelFactory> factorySupplierIn) {
			this.material = materialIn;
			this.factorySupplier = factorySupplierIn;

			final List<RegistryObject<Item>> objectList = new ArrayList<>();
			for (final EquipmentSlotType slot : ArmorSetRegistryObject.SLOT_LIST) {
				final String name = setNameIn + "_" + slot.getName();
				objectList.add(DoTBItemsRegistry.ITEMS.register(name, () -> {
					CustomArmorItem customArmorItem = new CustomArmorItem(setNameIn, name, this.material, slot) {
						/**
						 * Returns the armor model's factory. It needs to be associated
						 * with @OnlyIn(Dist.CLIENT) since BipedModel is Client Side only !
						 */
						@OnlyIn(Dist.CLIENT)
						@Override
						public ArmorModelFactory getModelFactory() {
							return factorySupplier.get();
						}
					};

					DoTBConfig.ARMORS_TO_SYNC.add(customArmorItem);

					return customArmorItem;
				}));
			}

			this.head = objectList.get(0);
			this.chest = objectList.get(1);
			this.legs = objectList.get(2);
			this.feet = objectList.get(3);
		}
	}
}
