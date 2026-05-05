package org.dawnoftime.armoroftheages.client;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ClientPlayerNetworkEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import org.dawnoftime.armoroftheages.CommonClass;
import org.dawnoftime.armoroftheages.client.patreon.PatronFetcher;
import org.dawnoftime.armoroftheages.registry.ModelProviderRegistry;

public class ArmorOfTheAgesClientForge {

    public static void init() {
        CommonClass.LOCAL_PLAYER_SUPPLIER = () -> Minecraft.getInstance().player;
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

    public static void playerLoggedInEvent(ClientPlayerNetworkEvent.LoggingIn event) {
        CommonClass.CONFIG_SYNC_HANDLER.syncConfig();
        if (event.getPlayer() != null) {
            PatronFetcher.fetchAndApply(event.getPlayer().getUUID());
        }
    }
}
