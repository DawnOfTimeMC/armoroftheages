package com.dotteam.armorweapons.registry;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import com.dotteam.armorweapons.DoTAWConfig;
import com.dotteam.armorweapons.item.templates.HumanoidArmorItem;
import com.dotteam.armorweapons.item.templates.HatItem;
import com.dotteam.armorweapons.item.templates.ItemDoTAW;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.dotteam.armorweapons.DoTArmorWeapons.MOD_ID;
import static com.dotteam.armorweapons.util.DoTBMaterials.DoTArmorMaterial.*;

public class DoTAWItemsRegistry {

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);


	public static final RegistryObject<Item> GENERAL = DoTAWItemsRegistry.reg("general", () -> new ItemDoTAW(true));
	public static final RegistryObject<Item> BAMBOO_HAT = DoTAWItemsRegistry.reg("bamboo_hat", HatItem::new);
	//public static final ArmorSetRegistryObject ANUBIS_ARMOR_SET = new ArmorSetRegistryObject("anubis_armor", RAIJIN, () -> AnubisModel::new);
	//public static final ArmorSetRegistryObject CENTURION_ARMOR_SET = new ArmorSetRegistryObject("centurion_armor", CENTURION, () -> CenturionArmorModel::new);
	//public static final ArmorSetRegistryObject IRON_PLATE_ARMOR_SET = new ArmorSetRegistryObject("iron_plate_armor", IRON_PLATE, () -> IronPlateArmorModel::new);
	//public static final ArmorSetRegistryObject HOLY_ARMOR_SET = new ArmorSetRegistryObject("holy_armor", HOLY, () -> HolyArmorModel::new);
	//public static final ArmorSetRegistryObject PHARAOH_ARMOR_SET = new ArmorSetRegistryObject("pharaoh_armor", PHARAOH, () -> PharaohArmorModel::new);
	//public static final ArmorSetRegistryObject JAPANESE_LIGHT_ARMOR_SET = new ArmorSetRegistryObject("japanese_light_armor", JAPANESE_LIGHT, () -> JapaneseLightArmorModel::new);
	//public static final ArmorSetRegistryObject O_YOROI_ARMOR_SET = new ArmorSetRegistryObject("o_yoroi_armor", O_YOROI, () -> OYoroiArmorModel::new);
	//public static final ArmorSetRegistryObject QUETZALCOATL_ARMOR_SET = new ArmorSetRegistryObject("quetzalcoatl_armor", RAIJIN, () -> QuetzalcoatlModel::new);
	//public static final ArmorSetRegistryObject RAIJIN_ARMOR_SET = new ArmorSetRegistryObject("raijin_armor", RAIJIN, () -> RaijinArmorModel::new);

	private static <T extends Item>RegistryObject<T> reg(String name, Supplier<T> item) {
		return ITEMS.register(name, item);
	}

	public final static class ArmorSetRegistryObject {
		private final ArmorMaterial material;
		public final RegistryObject<Item> head;
		public final RegistryObject<Item> chest;
		public final RegistryObject<Item> legs;
		public final RegistryObject<Item> feet;
		public final Supplier<HumanoidArmorItem.ArmorModelFactory> factorySupplier;

		private ArmorSetRegistryObject(final String setNameIn, final ArmorMaterial materialIn, Supplier<HumanoidArmorItem.ArmorModelFactory> factorySupplierIn) {
			this.material = materialIn;
			this.factorySupplier = factorySupplierIn;

			final List<RegistryObject<Item>> objectList = new ArrayList<>();
			for (final ArmorItem.Type type : ArmorItem.Type.values()) {
				final String name = setNameIn + "_" + type.getName();
				objectList.add(DoTAWItemsRegistry.ITEMS.register(name, () -> {
					HumanoidArmorItem humanoidArmorItem = new HumanoidArmorItem(setNameIn, name, this.material, type) {
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

					DoTAWConfig.ARMORS_TO_SYNC.add(humanoidArmorItem);

					return humanoidArmorItem;
				}));
			}

			this.head = objectList.get(0);
			this.chest = objectList.get(1);
			this.legs = objectList.get(2);
			this.feet = objectList.get(3);
		}
	}

	public static void register (IEventBus eventBus) {
		ITEMS.register(eventBus);
	}
}
