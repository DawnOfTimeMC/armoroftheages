package org.dawnoftime.armoroftheages;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import org.dawnoftime.armoroftheages.client.ArmorModelProvider;
import org.dawnoftime.armoroftheages.item.HumanoidArmorItem;
import org.dawnoftime.armoroftheages.networking.FabricConfigSyncNetworkHandler;
import org.dawnoftime.armoroftheages.registry.ItemRegistry;
import org.dawnoftime.armoroftheages.registry.ModelProviderRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static org.dawnoftime.armoroftheages.Constants.MOD_ID;

public class ArmorOfTheAges implements ModInitializer {

    private static final CreativeModeTab CREATIVE_MODE_TAB = FabricItemGroup.builder()
            .title(Component.translatable("itemGroup." + MOD_ID))
            .icon(() -> ItemRegistry.REGISTRY.TAB_ICON.get().getDefaultInstance())
            .displayItems((params, output) -> output.acceptAll(ItemRegistryImpl.ITEMS.stream().filter(item -> item != ItemRegistry.REGISTRY.TAB_ICON.get()).map(Item::getDefaultInstance).toList()))
            .build();

    @Override
    public void onInitialize() {
        Constants.CONFIG_PATH = FabricLoader.getInstance().getConfigDir().resolve(MOD_ID + ".json");

        // Items init
        ItemRegistryImpl.REGISTRY = new ItemRegistryImpl();

        // Creative inventory init
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, new ResourceLocation(MOD_ID, MOD_ID), CREATIVE_MODE_TAB);

        // Client Side init
        if (FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT) {
            registerLayerDefinitions();
        }

        CommonClass.CONFIG_SYNC_HANDLER = new FabricConfigSyncNetworkHandler();
        CommonClass.init();
    }

    /**
     * Registers the LayerDefinitions. Must be client side only !
     */
    public static void registerLayerDefinitions() {
        ModelProviderRegistry.REGISTRY.forEach((name, provider) -> {
            EntityModelLayerRegistry.registerModelLayer(provider.getLayerLocation(), provider::createLayer);
            if(provider instanceof ArmorModelProvider.MixedArmorModelProvider slimProvide){
                EntityModelLayerRegistry.registerModelLayer(slimProvide.getSlimLayerLocation(), slimProvide::createSlimLayer);
            }
        });
    }

    public static class ItemRegistryImpl extends ItemRegistry {
        public static final List<Item> ITEMS = new ArrayList<>();

        @Override
        public void register(String armorSetName, ArmorMaterial material, ArmorItem.Type slot) {
            Item item = new HumanoidArmorItem(armorSetName, material, slot);
            Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(MOD_ID, armorSetName + "_" + slot.getSlot().getName()), item);
            ITEMS.add(item);
        }

        @Override
        public Supplier<Item> register(String name, Supplier<Item> itemSupplier) {
            Item item = itemSupplier.get();
            Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(MOD_ID, name), item);
            ITEMS.add(item);
            return () -> item;
        }
    }
}
