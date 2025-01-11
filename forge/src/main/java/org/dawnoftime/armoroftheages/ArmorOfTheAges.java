package org.dawnoftime.armoroftheages;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLConfig;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.fml.loading.FMLLoader;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.dawnoftime.armoroftheages.client.ArmorModelProvider;
import org.dawnoftime.armoroftheages.item.ForgeHumanoidArmorItem;
import org.dawnoftime.armoroftheages.registry.ItemRegistry;
import org.dawnoftime.armoroftheages.registry.ModelProviderRegistry;

import java.util.function.Supplier;

import static org.dawnoftime.armoroftheages.Constants.MOD_ID;

@Mod(MOD_ID)
public class ArmorOfTheAges {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);

    public ArmorOfTheAges() {
        Constants.CONFIG_PATH = FMLLoader.getGamePath().resolve("/config/" + MOD_ID + ".json");

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

    public static class ItemRegistryImpl extends ItemRegistry {
        public static final DeferredRegister<Item> DEFERRED_REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);

        @Override
        public void register(String armorSetName, ArmorMaterial material, ArmorItem.Type slot) {
            DEFERRED_REGISTER.register(armorSetName + "_" + slot.getSlot().getName(), () -> new ForgeHumanoidArmorItem(armorSetName, material, slot));
        }

        @Override
        public Supplier<Item> register(String name, Supplier<Item> itemSupplier) {
            return DEFERRED_REGISTER.register(name, () -> new Item(new Item.Properties()));
        }
    }
}