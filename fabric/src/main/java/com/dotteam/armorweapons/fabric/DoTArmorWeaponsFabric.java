package com.dotteam.armorweapons.fabric;

import com.dotteam.armorweapons.DoTArmorWeapons;

import net.fabricmc.api.ModInitializer;

public class DoTArmorWeaponsFabric implements ModInitializer
{
	@Override
	public void onInitialize()
	{
		DoTArmorWeapons.init();
	}
}
