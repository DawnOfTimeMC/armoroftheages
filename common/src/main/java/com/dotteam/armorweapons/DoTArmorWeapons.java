package com.dotteam.armorweapons;

import java.util.function.Supplier;

import com.google.common.base.Suppliers;

import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class DoTArmorWeapons
{
	public static final String MOD_ID = "dotarmorweapons";

	// We can use this if we don't want to use DeferredRegister
	/**
	 * public static final Supplier<Registries> REGISTRIES = Suppliers.memoize(() -> Registries.get(MOD_ID)); // Registering a new creative tab public static final CreativeModeTab EXAMPLE_TAB = CreativeTabRegistry.create(new
	 * ResourceLocation(MOD_ID, "example_tab"), () -> new ItemStack(DoTArmorWeapons.EXAMPLE_ITEM.get()));
	 * 
	 * public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(MOD_ID, Registry.ITEM_REGISTRY); public static final RegistrySupplier<Item> EXAMPLE_ITEM = ITEMS.register("example_item", () -> new Item(new
	 * Item.Properties().tab(DoTArmorWeapons.EXAMPLE_TAB)));
	 **/

	public static void init()
	{
		// ITEMS.register();

		System.out.println(DoTArmorWeaponsExpectPlatform.getConfigDirectory().toAbsolutePath().normalize().toString());
	}
}
