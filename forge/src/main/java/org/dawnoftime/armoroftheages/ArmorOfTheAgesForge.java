package org.dawnoftime.armoroftheages;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.ConfigScreenHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.dawnoftime.armoroftheages.client.ArmorOfTheAgesClientForge;
import org.dawnoftime.armoroftheages.config.AOTAConfig;
import org.dawnoftime.armoroftheages.item.ForgeHumanoidArmorItem;
import org.dawnoftime.armoroftheages.loot.LootModifierProvider;
import org.dawnoftime.armoroftheages.loot.LootModifiers;
import org.dawnoftime.armoroftheages.networking.ForgeConfigSyncNetworkHandler;
import org.dawnoftime.armoroftheages.registry.ItemRegistry;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import static org.dawnoftime.armoroftheages.Constants.MOD_ID;

@Mod(MOD_ID)
public class ArmorOfTheAgesForge {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);

    public ArmorOfTheAgesForge() {
        Constants.CONFIG_PATH = FMLPaths.CONFIGDIR.get().resolve("config/" + MOD_ID + ".json");
        CommonClass.CONFIG_SYNC_HANDLER = new ForgeConfigSyncNetworkHandler();
        CommonClass.init();

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();


        // Items init
        ItemRegistryImpl.REGISTRY = new ItemRegistryImpl();
        ItemRegistryImpl.DEFERRED_REGISTER.register(modEventBus);

        // Creative inventory init
        CREATIVE_MODE_TAB.register(modEventBus);
        CREATIVE_MODE_TAB.register(MOD_ID, () -> CreativeModeTab.builder()
                .title(Component.translatable("itemGroup." + MOD_ID))
                .icon(() -> ItemRegistry.REGISTRY.TAB_ICON.get().getDefaultInstance())
                .displayItems((params, output) -> output.acceptAll(ItemRegistryImpl.DEFERRED_REGISTER.getEntries().stream().filter(holder -> holder != ItemRegistry.REGISTRY.TAB_ICON).map((itemDeferredHolder) -> itemDeferredHolder.get().getDefaultInstance()).toList()))
                .build());

        LootModifiers.register(modEventBus);
        modEventBus.addListener(this::gatherData);

        ModLoadingContext.get().registerExtensionPoint(
                ConfigScreenHandler.ConfigScreenFactory.class,
                () -> new ConfigScreenHandler.ConfigScreenFactory(
                        (client, parent) -> AOTAConfig.createScreen().generateScreen(parent)
                )
        );

        // Client init
        if (FMLEnvironment.dist == Dist.CLIENT) {
            modEventBus.addListener(ArmorOfTheAgesClientForge::registerLayerDefinitions);
            MinecraftForge.EVENT_BUS.addListener(ArmorOfTheAgesClientForge::playerLoggedInEvent);
        }
    }

    public void gatherData(GatherDataEvent event){
        event.getGenerator().addProvider(event.includeServer(), (DataProvider.Factory<LootModifierProvider>) LootModifierProvider::new);
    }

    public static class ItemRegistryImpl extends ItemRegistry {
        public static final DeferredRegister<Item> DEFERRED_REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
        public static final Map<String, List<ResourceLocation>> ARMORS_LOCATION_FROM_NAME = new Object2ObjectOpenHashMap<>();

        @Override
        public void register(String armorSetName, ArmorMaterial material, ArmorItem.Type slot) {
            ARMORS_LOCATION_FROM_NAME.computeIfAbsent(armorSetName, s -> new ObjectArrayList<>()).add(new ResourceLocation(MOD_ID, armorSetName + "_" + slot.getSlot().getName()));
            DEFERRED_REGISTER.register(armorSetName + "_" + slot.getSlot().getName(), () -> new ForgeHumanoidArmorItem(armorSetName, material, slot));
        }

        @Override
        public Supplier<Item> register(String name, Supplier<Item> itemSupplier) {
            ARMORS_LOCATION_FROM_NAME.computeIfAbsent(name, s -> new ObjectArrayList<>()).add(new ResourceLocation(MOD_ID, name));
            return DEFERRED_REGISTER.register(name, itemSupplier);
        }
    }
}