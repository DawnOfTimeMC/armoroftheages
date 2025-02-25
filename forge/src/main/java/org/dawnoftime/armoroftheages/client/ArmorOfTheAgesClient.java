package org.dawnoftime.armoroftheages.client;

import net.minecraftforge.client.event.ClientPlayerNetworkEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import org.dawnoftime.armoroftheages.CommonClass;
import org.dawnoftime.armoroftheages.registry.ModelProviderRegistry;

public class ArmorOfTheAgesClient {


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

    public static void playerLoggedInEvent(ClientPlayerNetworkEvent.LoggingIn event) {
        CommonClass.CONFIG_SYNC_HANDLER.syncConfig();
    }
}
