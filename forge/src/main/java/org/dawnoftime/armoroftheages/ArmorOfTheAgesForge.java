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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dawnoftime.armoroftheages.client.ArmorOfTheAgesClientForge;
import org.dawnoftime.armoroftheages.config.AOTAConfig;
import org.dawnoftime.armoroftheages.item.ForgeHumanoidArmorItem;
import org.dawnoftime.armoroftheages.loot.LootModifierProvider;
import org.dawnoftime.armoroftheages.loot.LootModifiers;
import org.dawnoftime.armoroftheages.networking.ForgeConfigSyncNetworkHandler;
import org.dawnoftime.armoroftheages.registry.ItemRegistry;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import static org.dawnoftime.armoroftheages.Constants.MOD_ID;

@Mod(MOD_ID)
public class ArmorOfTheAgesForge {
    private static final Logger LOGGER = LogManager.getLogger();

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);

    public ArmorOfTheAgesForge() {
        // Chemin correct Forge : .minecraft/config/<modid>.json (NE PAS préfixer par "config/")
        Constants.CONFIG_PATH = FMLPaths.CONFIGDIR.get().resolve(MOD_ID + ".json");

        /*
         * ================================================================
         *  TODO: SUPPRIMER CE BLOC DANS UNE PROCHAINE VERSION
         *  FIX TEMPORAIRE DE MIGRATION DE CONFIG (Forge uniquement)
         *
         *  Objectif :
         *   - Si un ancien fichier existe en ".minecraft/config/config/<modid>.json",
         *     le copier vers ".minecraft/config/<modid>.json" S'IL N'EXISTE PAS DÉJÀ.
         *   - Supprimer l'ancien fichier puis tenter de supprimer le dossier
         *     ".minecraft/config/config" UNIQUEMENT s'il est vide.
         *
         *  Sécurité :
         *   - On ne remplace PAS un fichier déjà présent à la nouvelle destination.
         *   - On journalise tout pour faciliter le debug chez les joueurs.
         * ================================================================
         */
        migrateForgeConfigIfNeeded();
        // ========================== FIN FIX TEMPORAIRE ==========================

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
                .displayItems((params, output) -> output.acceptAll(
                        ItemRegistryImpl.DEFERRED_REGISTER.getEntries().stream()
                                .filter(holder -> holder != ItemRegistry.REGISTRY.TAB_ICON)
                                .map(holder -> holder.get().getDefaultInstance())
                                .toList()))
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

    public void gatherData(GatherDataEvent event) {
        event.getGenerator().addProvider(event.includeServer(), (DataProvider.Factory<LootModifierProvider>) LootModifierProvider::new);
    }

    // ===== FIX TEMPORAIRE DE MIGRATION DE CONFIG (voir TODO au-dessus) =====
    private static void migrateForgeConfigIfNeeded() {
        final Path configDir = FMLPaths.CONFIGDIR.get();        // .../.minecraft/config
        final Path oldDir    = configDir.resolve("config");      // .../.minecraft/config/config
        final Path oldFile   = oldDir.resolve(MOD_ID + ".json"); // ancien emplacement
        final Path newFile   = configDir.resolve(MOD_ID + ".json"); // nouvel emplacement correct

        try {
            if (Files.exists(oldFile)) {
                // Copier seulement si le nouveau n'existe pas
                if (!Files.exists(newFile)) {
                    try {
                        Files.createDirectories(newFile.getParent());
                        Files.copy(oldFile, newFile, StandardCopyOption.REPLACE_EXISTING);
                        LOGGER.info("[{}] Configuration migrée de '{}' vers '{}'.", MOD_ID, oldFile, newFile);
                    } catch (IOException e) {
                        LOGGER.warn("[{}] Échec de copie de l'ancienne configuration '{}' vers '{}': {}",
                                MOD_ID, oldFile, newFile, e.getMessage());
                    }
                } else {
                    LOGGER.info("[{}] Nouveau fichier de configuration déjà présent : '{}'. " +
                            "L'ancien sera nettoyé si possible.", MOD_ID, newFile);
                }

                // Supprimer l'ancien fichier (best-effort)
                try {
                    Files.deleteIfExists(oldFile);
                } catch (IOException e) {
                    LOGGER.warn("[{}] Impossible de supprimer l'ancien fichier de configuration '{}': {}",
                            MOD_ID, oldFile, e.getMessage());
                }

                // Tenter de supprimer le dossier '.../config/config' s'il est vide
                try {
                    if (Files.isDirectory(oldDir)) {
                        try (DirectoryStream<Path> ds = Files.newDirectoryStream(oldDir)) {
                            Iterator<Path> it = ds.iterator();
                            if (!it.hasNext()) {
                                Files.delete(oldDir);
                                LOGGER.info("[{}] Dossier ancien '{}' supprimé (était vide).", MOD_ID, oldDir);
                            } else {
                                LOGGER.info("[{}] Dossier ancien '{}' conservé (contenu détecté).", MOD_ID, oldDir);
                            }
                        }
                    }
                } catch (IOException e) {
                    LOGGER.warn("[{}] Impossible de nettoyer le dossier ancien '{}': {}",
                            MOD_ID, oldDir, e.getMessage());
                }
            }
        } catch (Exception e) {
            LOGGER.warn("[{}] Problème durant la migration de configuration: {}", MOD_ID, e.getMessage());
        }
    }
    // ===================== FIN FIX TEMPORAIRE DE MIGRATION =====================

    public static class ItemRegistryImpl extends ItemRegistry {
        public static final DeferredRegister<Item> DEFERRED_REGISTER =
                DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
        public static final Map<String, List<ResourceLocation>> ARMORS_LOCATION_FROM_NAME =
                new Object2ObjectOpenHashMap<>();

        @Override
        public void register(String armorSetName, ArmorMaterial material, ArmorItem.Type slot) {
            ARMORS_LOCATION_FROM_NAME
                    .computeIfAbsent(armorSetName, s -> new ObjectArrayList<>())
                    .add(new ResourceLocation(MOD_ID, armorSetName + "_" + slot.getSlot().getName()));
            DEFERRED_REGISTER.register(armorSetName + "_" + slot.getSlot().getName(),
                    () -> new ForgeHumanoidArmorItem(armorSetName, material, slot));
        }

        @Override
        public Supplier<Item> register(String name, Supplier<Item> itemSupplier) {
            ARMORS_LOCATION_FROM_NAME
                    .computeIfAbsent(name, s -> new ObjectArrayList<>())
                    .add(new ResourceLocation(MOD_ID, name));
            return DEFERRED_REGISTER.register(name, itemSupplier);
        }
    }
}