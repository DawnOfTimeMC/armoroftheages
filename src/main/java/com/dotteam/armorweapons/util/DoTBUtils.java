package com.dotteam.armorweapons.util;

import java.util.List;

import javax.annotation.Nonnull;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.ForgeRegistries;

import static com.dotteam.armorweapons.DoTArmorWeapons.MOD_ID;

public class DoTBUtils {

	//General
	public static final int						HIGHEST_Y				= 255;

	//Tooltip translation text
	public static final Component			TOOLTIP_HOLD_SHIFT		= Component.translatable("tooltip." + MOD_ID + ".hold_key").withStyle(ChatFormatting.GRAY).append(Component.translatable("tooltip." + MOD_ID + ".shift").withStyle(ChatFormatting.AQUA));
	public static final String					TOOLTIP_COLUMN			= "column";
	public static final String					TOOLTIP_CLIMBING_PLANT	= "climbing_plant";
	public static final String					TOOLTIP_BEAM			= "beam";
	public static final String					TOOLTIP_CROP			= "crop";
	public static final String					TOOLTIP_SIDED_WINDOW	= "sided_window";
	public static final String 					TOOLTIP_FIREPLACE 		= "fireplace";
	public static final String 					TOOLTIP_ADD_COLUMN 		= "add_column";

	public static void addTooltip(final List<Component> tooltip, @Nonnull final Item item, final String... tooltipNames) {
		final ResourceLocation itemName = ForgeRegistries.ITEMS.getKey(item);
		if (itemName != null){
			String[] tts = new String[tooltipNames.length + 1];
			System.arraycopy(tooltipNames, 0, tts, 0, tooltipNames.length);
			tts[tooltipNames.length] = itemName.getPath();
			DoTBUtils.addTooltip(tooltip, tts);
		}
	}

	public static void addTooltip(final List<Component> tooltip, final String... tooltipNames) {
		if (Screen.hasShiftDown()) {
			for (final String tooltipName : tooltipNames) {
				tooltip.add(Component.translatable("tooltip." + MOD_ID + "." + tooltipName).withStyle(ChatFormatting.GRAY));
			}
		} else {
			tooltip.add(DoTBUtils.TOOLTIP_HOLD_SHIFT);
		}
	}
}