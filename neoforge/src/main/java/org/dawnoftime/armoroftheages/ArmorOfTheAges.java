package org.dawnoftime.armoroftheages;

import com.github.razorplay01.ismah.client.ISMAHClient;
import com.github.razorplay01.ismah.client.api.ArmorRendererRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLPaths;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.dawnoftime.armoroftheages.client.ArmorOfTheAgesClientNeoforge;
import org.dawnoftime.armoroftheages.compat.ISMAHCompat;
import org.dawnoftime.armoroftheages.config.AOTAConfig;
import org.dawnoftime.armoroftheages.networking.NeoforgeConfigSyncNetworkHandler;
import org.dawnoftime.armoroftheages.networking.packets.C2SDisablePreferencesPacket;
import org.dawnoftime.armoroftheages.networking.packets.C2SPreferenceSyncPacket;
import org.dawnoftime.armoroftheages.networking.packets.S2CPreferenceSyncPacket;

import static org.dawnoftime.armoroftheages.AotAArmorMaterialRegistry.ARMOR_MATERIALS;
import static org.dawnoftime.armoroftheages.Constants.MOD_ID;
import static org.dawnoftime.armoroftheages.AotAItemRegistry.ITEMS;
import static org.dawnoftime.armoroftheages.AotAItemRegistry.TAB_ICON;

@Mod(MOD_ID)
public class ArmorOfTheAges {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);

    public ArmorOfTheAges(IEventBus modEventBus, ModContainer modContainer, Dist dist) {
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
        if (dist.isClient()) {
            ArmorOfTheAgesClientNeoforge.setup(modEventBus);
        }

        CommonClass.init();

        if (ModList.get().isLoaded("ismah")) {
            ArmorRendererRegistry.register(new ISMAHCompat());
            ISMAHClient.LOGGER.info("ISMAH detected. Registering ISMAHCompat.");
        }
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
}