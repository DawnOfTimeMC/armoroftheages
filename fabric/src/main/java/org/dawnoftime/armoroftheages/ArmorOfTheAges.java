package org.dawnoftime.armoroftheages;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.dawnoftime.armoroftheages.client.ArmorModelProvider;
import org.dawnoftime.armoroftheages.registry.ModelProviderRegistry;
import static org.dawnoftime.armoroftheages.AotAItemRegistry.TAB_ICON;
import static org.dawnoftime.armoroftheages.Constants.MOD_ID;

public class ArmorOfTheAges implements ModInitializer {

    public static final CreativeModeTab CREATIVE_MODE_TAB = FabricItemGroupBuilder.build(
            new ResourceLocation(MOD_ID, "tab"),
            () -> new ItemStack(TAB_ICON));

    @Override
    public void onInitialize() {
        // Items init
        AotAItemRegistry.init();

        // Client Side init
        if (FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT) {
            registerLayerDefinitions();
        }

        CommonClass.init();
    }

    /**
     * Registers the LayerDefinitions. Must be client side only !
     */
    public static void registerLayerDefinitions(){
        ModelProviderRegistry.REGISTRY.forEach((name, provider) -> {
            EntityModelLayerRegistry.registerModelLayer(provider.getLayerLocation(), provider::createLayer);
            if(provider instanceof ArmorModelProvider.MixedArmorModelProvider slimProvide){
                EntityModelLayerRegistry.registerModelLayer(slimProvide.getSlimLayerLocation(), slimProvide::createSlimLayer);
            }
        });
    }
}
