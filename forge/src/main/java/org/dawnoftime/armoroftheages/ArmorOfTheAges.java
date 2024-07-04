package org.dawnoftime.armoroftheages;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import org.dawnoftime.armoroftheages.client.ArmorModelProvider;
import org.dawnoftime.armoroftheages.registry.ModelProviderRegistry;
import org.jetbrains.annotations.NotNull;

import static org.dawnoftime.armoroftheages.Constants.MOD_ID;
import static org.dawnoftime.armoroftheages.AotAItemRegistry.ITEMS;
import static org.dawnoftime.armoroftheages.AotAItemRegistry.TAB_ICON;

@Mod(MOD_ID)
public class ArmorOfTheAges {
    public static final CreativeModeTab CREATIVE_MODE_TAB = new CreativeModeTab(CreativeModeTab.getGroupCountSafe(), MOD_ID + ".tab") {
        @Override
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(TAB_ICON.get());
        }
    };

    public ArmorOfTheAges() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Items init
        ITEMS.register(modEventBus);

        // Client init
        if (FMLEnvironment.dist == Dist.CLIENT) {
            modEventBus.addListener(ArmorOfTheAges::registerLayerDefinitions);
        }

        CommonClass.init();
    }

    /**
     * Registers the LayerDefinitions. Must be client side only !
     * @param event Event called.
     */
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event){
        ModelProviderRegistry.REGISTRY.forEach((name, provider) -> {
            event.registerLayerDefinition(provider.getLayerLocation(), provider::createLayer);
            if(provider instanceof ArmorModelProvider.MixedArmorModelProvider slimProvide){
                event.registerLayerDefinition(slimProvide.getSlimLayerLocation(), slimProvide::createSlimLayer);
            }
        });
    }
}