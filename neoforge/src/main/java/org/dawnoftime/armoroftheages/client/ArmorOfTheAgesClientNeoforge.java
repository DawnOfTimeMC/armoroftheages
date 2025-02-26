package org.dawnoftime.armoroftheages.client;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.client.event.ClientPlayerNetworkEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.common.NeoForge;
import org.dawnoftime.armoroftheages.CommonClass;
import org.dawnoftime.armoroftheages.item.ForgeHumanoidArmorItem;
import org.dawnoftime.armoroftheages.registry.ModelProviderRegistry;
import org.jetbrains.annotations.NotNull;

import static org.dawnoftime.armoroftheages.AotAItemRegistry.ITEMS;

public class ArmorOfTheAgesClientNeoforge {

    public static void setup(IEventBus bus) {
        bus.addListener(ArmorOfTheAgesClientNeoforge::registerLayerDefinitions);
        bus.addListener(ArmorOfTheAgesClientNeoforge::onRegisterClientExtensions);
        NeoForge.EVENT_BUS.addListener(ArmorOfTheAgesClientNeoforge::playerLoggedInEvent);
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
    }

    public static void onRegisterClientExtensions(RegisterClientExtensionsEvent event) {
        ITEMS.getEntries().forEach(itemDeferredHolder -> {
            if(itemDeferredHolder.get() instanceof ForgeHumanoidArmorItem armorItem) {
                event.registerItem(new IClientItemExtensions() {
                    public @NotNull HumanoidModel<?> getHumanoidArmorModel(@NotNull LivingEntity living, @NotNull ItemStack stack, @NotNull EquipmentSlot slot, @NotNull HumanoidModel<?> defaultModel) {
                        final ArmorModelProvider provider = armorItem.getModelProvider();
                        if (provider != null) {
                            HumanoidModel<?> model = provider.getArmorModel(living);
                            model.crouching = living.isShiftKeyDown();
                            model.riding = defaultModel.riding;
                            return model;
                        } else {
                            return defaultModel;
                        }
                    }
                }, armorItem);
            }
        });
    }
}
