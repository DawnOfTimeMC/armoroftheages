package com.dotteam.armorweapons.forge;

import com.dotteam.armorweapons.DoTArmorWeapons;

import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(DoTArmorWeapons.MOD_ID)
public class DoTArmorWeaponsForge
{
	public DoTArmorWeaponsForge()
	{
		// Submit our event bus to let architectury register our content on the right time
		EventBuses.registerModEventBus(DoTArmorWeapons.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
		DoTArmorWeapons.init();
	}
}
