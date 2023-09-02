package com.dotteam.armorweapons.fabric;

import java.nio.file.Path;

import net.fabricmc.loader.api.FabricLoader;

public class DoTArmorWeaponsExpectPlatformImpl
{
	/**
	 * This is our actual method to {@link DoTArmorWeaponsExpectPlatform#getConfigDirectory()}.
	 */
	public static Path getConfigDirectory()
	{
		return FabricLoader.getInstance().getConfigDir();
	}
}
