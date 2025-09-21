package org.dawnoftime.armoroftheages;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import org.dawnoftime.armoroftheages.item.HumanoidArmorItem;
import org.dawnoftime.armoroftheages.loot.AmorOfTheAgesLootModifiersFabric;
import org.dawnoftime.armoroftheages.networking.FabricConfigSyncNetworkHandler;
import org.dawnoftime.armoroftheages.registry.ArmorMaterialRegistry;
import org.dawnoftime.armoroftheages.registry.ArmorMaterialRegistryFabric;
import org.dawnoftime.armoroftheages.registry.ItemRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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

        // ArmorMaterial registry init
        ArmorMaterialRegistry.REGISTRY = new ArmorMaterialRegistryFabric();

        // Items init
        ItemRegistryImpl.REGISTRY = new ItemRegistryImpl();

        // Creative inventory init
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, ResourceLocation.fromNamespaceAndPath(MOD_ID, MOD_ID), CREATIVE_MODE_TAB);
        AmorOfTheAgesLootModifiersFabric.modifyLootTables();
    }

    public static class ItemRegistryImpl extends ItemRegistry {
        public static final List<Item> ITEMS = new ArrayList<>();
        public static final Map<String, List<ResourceLocation>> ARMORS_LOCATION_FROM_NAME = new Object2ObjectOpenHashMap<>();

        @Override
        public void register(String armorSetName, Holder<ArmorMaterial> material, ArmorItem.Type slot, int durabilityFactor) {
            Item item = new HumanoidArmorItem(armorSetName, material, slot, durabilityFactor);
            ResourceLocation armorLocation = ResourceLocation.fromNamespaceAndPath(MOD_ID, armorSetName + "_" + slot.getSlot().getName());
            Registry.register(BuiltInRegistries.ITEM, armorLocation, item);
            ARMORS_LOCATION_FROM_NAME.computeIfAbsent(armorSetName, s -> new ObjectArrayList<>()).add(armorLocation);
            ITEMS.add(item);
        }

        @Override
        public Supplier<Item> register(String name, Supplier<Item> itemSupplier) {
            Item item = itemSupplier.get();
            ResourceLocation location = ResourceLocation.fromNamespaceAndPath(MOD_ID, name);
            Registry.register(BuiltInRegistries.ITEM, location, item);
            ARMORS_LOCATION_FROM_NAME.computeIfAbsent(name, s -> new ObjectArrayList<>()).add(location);
            ITEMS.add(item);
            return () -> item;
        }
    }
}
