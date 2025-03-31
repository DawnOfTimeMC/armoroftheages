package org.dawnoftime.armoroftheages;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import org.dawnoftime.armoroftheages.item.HumanoidArmorItem;
import org.dawnoftime.armoroftheages.networking.FabricConfigSyncNetworkHandler;
import org.dawnoftime.armoroftheages.registry.ItemRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static org.dawnoftime.armoroftheages.Constants.MOD_ID;

public class ArmorOfTheAgesFabric implements ModInitializer {

    private static final CreativeModeTab CREATIVE_MODE_TAB = FabricItemGroup.builder()
            .title(Component.translatable("itemGroup." + MOD_ID))
            .icon(() -> ItemRegistry.REGISTRY.TAB_ICON.get().getDefaultInstance())
            .displayItems((params, output) -> output.acceptAll(ItemRegistryImpl.ITEMS.stream().filter(item -> item != ItemRegistry.REGISTRY.TAB_ICON.get()).map(Item::getDefaultInstance).toList()))
            .build();

    @Override
    public void onInitialize() {
        Constants.CONFIG_PATH = FabricLoader.getInstance().getConfigDir().resolve(MOD_ID + ".json");
        CommonClass.CONFIG_SYNC_HANDLER = new FabricConfigSyncNetworkHandler();
        CommonClass.init();

        // Items init
        ItemRegistryImpl.REGISTRY = new ItemRegistryImpl();

        // Creative inventory init
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, new ResourceLocation(MOD_ID, MOD_ID), CREATIVE_MODE_TAB);
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
