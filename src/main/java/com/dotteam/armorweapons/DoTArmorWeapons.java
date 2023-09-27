package com.dotteam.armorweapons;

import com.dotteam.armorweapons.registry.DoTAWItemsRegistry;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Map;

@Mod(DoTArmorWeapons.MOD_ID)
public class DoTArmorWeapons {
    public static final String MOD_ID = "dotarmorweapons";

    public DoTArmorWeapons() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        DoTAWItemsRegistry.register(modEventBus);

        modEventBus.addListener(HandlerCommon::commonSetup);
        // modEventBus.addListener(HandlerClient::clientSetup);

        modEventBus.addListener(HandlerCommon::registerCreativeModeTabs);
        modEventBus.addListener(HandlerCommon::setDotTab);
        // modEventBus.addListener(HandlerClient::entityRenderers);

        modEventBus.addListener(this::createCreativeTab);
    }

    public void createCreativeTab(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == HandlerCommon.DOT_TAB) {
            ForgeRegistries.ITEMS.getEntries().stream().filter(
                    entry -> entry
                            .getKey()
                            .location()
                            .getNamespace()
                            .equalsIgnoreCase(MOD_ID))
                            .map(Map.Entry::getValue)
                            .forEachOrdered(event::accept);
        }
    }
}
