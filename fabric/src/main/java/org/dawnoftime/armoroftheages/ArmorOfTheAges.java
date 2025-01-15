package org.dawnoftime.armoroftheages;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientEntityEvents;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.dawnoftime.armoroftheages.client.ArmorModelProvider;
import org.dawnoftime.armoroftheages.networking.FabricConfigSyncNetworkHandler;
import org.dawnoftime.armoroftheages.registry.ModelProviderRegistry;

import static org.dawnoftime.armoroftheages.AotAItemRegistry.ITEMS;
import static org.dawnoftime.armoroftheages.AotAItemRegistry.TAB_ICON;
import static org.dawnoftime.armoroftheages.Constants.MOD_ID;

public class ArmorOfTheAges implements ModInitializer {

    private static final CreativeModeTab CREATIVE_MODE_TAB = FabricItemGroup.builder()
            .title(Component.translatable("itemGroup." + MOD_ID))
            .icon(() -> new ItemStack(TAB_ICON))
            .displayItems((params, output) -> output.acceptAll(ITEMS.stream().filter(holder -> holder != TAB_ICON).map(Item::getDefaultInstance).toList()))
            .build();

    @Override
    public void onInitialize() {
        Constants.CONFIG_PATH = FabricLoader.getInstance().getConfigDir().resolve(MOD_ID + ".json");
        CommonClass.CONFIG_SYNC_HANDLER = new FabricConfigSyncNetworkHandler();

        // Items init
        AotAItemRegistry.init();

        // Creative inventory init
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, ResourceLocation.fromNamespaceAndPath(MOD_ID, MOD_ID), CREATIVE_MODE_TAB);

        // Client Side init
        if (FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT) {
            registerLayerDefinitions();
        }

        CommonClass.init();

        ClientPlayConnectionEvents.JOIN.register((handler, sender, client) -> {
            CommonClass.CONFIG_SYNC_HANDLER.syncConfig();
        });
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
