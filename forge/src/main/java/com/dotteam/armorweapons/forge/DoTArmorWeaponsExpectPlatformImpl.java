package com.dotteam.armorweapons.forge;

import java.nio.file.Path;

import net.minecraftforge.fml.loading.FMLPaths;

public class DoTArmorWeaponsExpectPlatformImpl
{
	/**
	 * This is our actual method to {@link DoTArmorWeaponsExpectPlatform#getConfigDirectory()}.
	 */
	public static Path getConfigDirectory()
	{
		return FMLPaths.CONFIGDIR.get();
	}
}
