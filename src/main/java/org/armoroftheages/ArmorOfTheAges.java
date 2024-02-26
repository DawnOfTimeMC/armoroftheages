package org.armoroftheages;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.armoroftheages.item.AotAItemsRegistry;

@Mod(ArmorOfTheAges.MOD_ID)
public class ArmorOfTheAges {
	public static final String MOD_ID = "armoroftheages";
	public static final ItemGroup MOD_TAB = new ItemGroup(ItemGroup.getGroupCountSafe(), ArmorOfTheAges.MOD_ID) {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(AotAItemsRegistry.HOLY_ARMOR_SET.head.get());
		}
	};

	public ArmorOfTheAges() {
		final IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
		AotAItemsRegistry.ITEMS.register(eventBus);
		eventBus.addListener(HandlerCommon::modConfigLoadingEvent);
		eventBus.addListener(HandlerCommon::fMLDedicatedServerSetupEvent);
		eventBus.addListener(HandlerCommon::fMLCommonSetupEvent);
	}
}