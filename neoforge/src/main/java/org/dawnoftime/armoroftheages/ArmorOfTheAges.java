package org.dawnoftime.armoroftheages;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.fml.loading.FMLPaths;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.dawnoftime.armoroftheages.client.ArmorModelProvider;
import org.dawnoftime.armoroftheages.config.AOTAConfig;
import org.dawnoftime.armoroftheages.networking.NeoforgeConfigSyncNetworkHandler;
import org.dawnoftime.armoroftheages.networking.packets.C2SDisablePreferencesPacket;
import org.dawnoftime.armoroftheages.networking.packets.C2SPreferenceSyncPacket;
import org.dawnoftime.armoroftheages.networking.packets.S2CPreferenceSyncPacket;
import org.dawnoftime.armoroftheages.registry.ModelProviderRegistry;

import static org.dawnoftime.armoroftheages.AotAArmorMaterialRegistry.ARMOR_MATERIALS;
import static org.dawnoftime.armoroftheages.Constants.MOD_ID;
import static org.dawnoftime.armoroftheages.AotAItemRegistry.ITEMS;
import static org.dawnoftime.armoroftheages.AotAItemRegistry.TAB_ICON;

@Mod(MOD_ID)
public class ArmorOfTheAges {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);

    public ArmorOfTheAges(IEventBus modEventBus, ModContainer modContainer) {
        CommonClass.CONFIG_SYNC_HANDLER = new NeoforgeConfigSyncNetworkHandler();
        Constants.CONFIG_PATH = FMLPaths.CONFIGDIR.get().resolve(MOD_ID + ".json");

        ModLoadingContext.get().registerExtensionPoint(
                IConfigScreenFactory.class,
                () -> (client, parent) -> AOTAConfig.createScreen().generateScreen(parent)
        );

        modEventBus.addListener(this::registerPackets);

        // Materials init
        ARMOR_MATERIALS.register(modEventBus);

        // Items init
        ITEMS.register(modEventBus);

        // Creative inventory init
        CREATIVE_MODE_TAB.register(modEventBus);
        CREATIVE_MODE_TAB.register(MOD_ID, () -> CreativeModeTab.builder()
                .title(Component.translatable("itemGroup." + MOD_ID))
                .icon(() -> TAB_ICON.get().getDefaultInstance())
                .displayItems((params, output) -> output.acceptAll(ITEMS.getEntries().stream().filter(holder -> holder != TAB_ICON).map((itemDeferredHolder) -> itemDeferredHolder.get().getDefaultInstance()).toList()))
                .build());

        // Client init
        if (FMLEnvironment.dist == Dist.CLIENT) {
            modEventBus.addListener(ArmorOfTheAges::registerLayerDefinitions);
        }

        CommonClass.init();
    }

    public void registerPackets(final RegisterPayloadHandlersEvent event) {
        final PayloadRegistrar registrar = event.registrar("my_mod")
                .versioned("1.2.3")
                .optional();

        NeoforgeConfigSyncNetworkHandler handler = (NeoforgeConfigSyncNetworkHandler) CommonClass.CONFIG_SYNC_HANDLER;

        registrar.playToClient(S2CPreferenceSyncPacket.TYPE, S2CPreferenceSyncPacket.STREAM_CODEC, handler::handle);
        registrar.playToServer(C2SPreferenceSyncPacket.TYPE, C2SPreferenceSyncPacket.STREAM_CODEC, handler::handle);
        registrar.playToServer(C2SDisablePreferencesPacket.TYPE, StreamCodec.unit(new C2SDisablePreferencesPacket()), handler::handle);
    }

    @SubscribeEvent
    public void playerLoggedInEvent(PlayerEvent.PlayerLoggedInEvent event) {
        if (!event.getEntity().level().isClientSide) return;

        CommonClass.CONFIG_SYNC_HANDLER.syncConfig();
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
}