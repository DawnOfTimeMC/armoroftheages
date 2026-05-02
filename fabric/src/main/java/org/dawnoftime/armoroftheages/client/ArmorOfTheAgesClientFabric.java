package org.dawnoftime.armoroftheages.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import org.dawnoftime.armoroftheages.ArmorOfTheAgesFabric;
import org.dawnoftime.armoroftheages.CommonClass;
import org.dawnoftime.armoroftheages.item.HumanoidArmorItem;
import org.dawnoftime.armoroftheages.registry.ModelProviderRegistry;

public class ArmorOfTheAgesClientFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        CommonClass.LOCAL_PLAYER_SUPPLIER = () -> net.minecraft.client.Minecraft.getInstance().player;
        ArmorOfTheAgesClientFabric.registerLayerDefinitions();
        ClientPlayConnectionEvents.JOIN.register((handler, sender, client) -> {
            CommonClass.CONFIG_SYNC_HANDLER.syncConfig();
        });
        ArmorOfTheAgesFabric.ItemRegistryImpl.ITEMS.stream()
                .filter(item -> item instanceof HumanoidArmorItem)
                .forEach(item -> ArmorRenderer.register(new CustomArmorRenderer(), item));
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
}
