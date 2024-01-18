package org.armoroftheages;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import org.armoroftheages.item.CustomArmorItem;

@Mod.EventBusSubscriber(modid = ArmorOfTheAges.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class HandlerCommon {
	@SubscribeEvent
	public static void modConfigLoadingEvent(final ModConfig.Loading event) {
		for (CustomArmorItem customArmorItem : DoTBConfig.ARMORS_TO_SYNC) {
			customArmorItem.updateAttributes();
		}
	}

	@SubscribeEvent
	public static void fMLDedicatedServerSetupEvent(final FMLDedicatedServerSetupEvent event) {
		ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, DoTBConfig.COMMON_SPEC);
	}

	@SubscribeEvent
	public static void fMLCommonSetupEvent(final FMLCommonSetupEvent event) {
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, DoTBConfig.COMMON_SPEC);
	}
}