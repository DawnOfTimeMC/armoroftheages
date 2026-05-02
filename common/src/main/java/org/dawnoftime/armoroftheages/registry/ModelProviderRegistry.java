package org.dawnoftime.armoroftheages.registry;

import java.util.HashMap;
import java.util.function.Supplier;

import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.world.entity.EquipmentSlot;
import org.dawnoftime.armoroftheages.client.ArmorModelProvider;
import org.dawnoftime.armoroftheages.client.ArmorModelSupplier;
import org.dawnoftime.armoroftheages.client.models.anubis_armor.ChestAnubisArmorModel;
import org.dawnoftime.armoroftheages.client.models.anubis_armor.FeetAnubisArmorModel;
import org.dawnoftime.armoroftheages.client.models.anubis_armor.HeadAnubisArmorModel;
import org.dawnoftime.armoroftheages.client.models.anubis_armor.LegsAnubisArmorModel;
import org.dawnoftime.armoroftheages.client.models.exalted_aurum.ChestExaltedAurumArmorModel;
import org.dawnoftime.armoroftheages.client.models.exalted_aurum.FeetExaltedAurumArmorModel;
import org.dawnoftime.armoroftheages.client.models.exalted_aurum.HeadExaltedAurumArmorModel;
import org.dawnoftime.armoroftheages.client.models.exalted_aurum.LegsExaltedAurumArmorModel;
import org.dawnoftime.armoroftheages.client.models.holy_armor.ChestHolyArmorModel;
import org.dawnoftime.armoroftheages.client.models.holy_armor.FeetHolyArmorModel;
import org.dawnoftime.armoroftheages.client.models.holy_armor.HeadHolyArmorModel;
import org.dawnoftime.armoroftheages.client.models.holy_armor.LegsHolyArmorModel;
import org.dawnoftime.armoroftheages.client.models.iron_plate_armor.ChestIronPlateArmorModel;
import org.dawnoftime.armoroftheages.client.models.iron_plate_armor.FeetIronPlateArmorModel;
import org.dawnoftime.armoroftheages.client.models.iron_plate_armor.HeadIronPlateArmorModel;
import org.dawnoftime.armoroftheages.client.models.iron_plate_armor.LegsIronPlateArmorModel;
import org.dawnoftime.armoroftheages.client.models.japanese_light_armor.ChestJapaneseLightArmorModel;
import org.dawnoftime.armoroftheages.client.models.japanese_light_armor.FeetJapaneseLightArmorModel;
import org.dawnoftime.armoroftheages.client.models.japanese_light_armor.HeadJapaneseLightArmorModel;
import org.dawnoftime.armoroftheages.client.models.japanese_light_armor.LegsJapaneseLightArmorModel;
import org.dawnoftime.armoroftheages.client.models.centurion_armor.ChestCenturionArmorModel;
import org.dawnoftime.armoroftheages.client.models.centurion_armor.FeetCenturionArmorModel;
import org.dawnoftime.armoroftheages.client.models.centurion_armor.HeadCenturionArmorModel;
import org.dawnoftime.armoroftheages.client.models.centurion_armor.LegsCenturionArmorModel;
import org.dawnoftime.armoroftheages.client.models.o_yoroi_armor.ChestOYoroiArmorModel;
import org.dawnoftime.armoroftheages.client.models.o_yoroi_armor.FeetOYoroiArmorModel;
import org.dawnoftime.armoroftheages.client.models.o_yoroi_armor.HeadOYoroiArmorModel;
import org.dawnoftime.armoroftheages.client.models.o_yoroi_armor.LegsOYoroiArmorModel;
import org.dawnoftime.armoroftheages.client.models.pharaoh_armor.ChestPharaohArmorModel;
import org.dawnoftime.armoroftheages.client.models.pharaoh_armor.FeetPharaohArmorModel;
import org.dawnoftime.armoroftheages.client.models.pharaoh_armor.HeadPharaohArmorModel;
import org.dawnoftime.armoroftheages.client.models.pharaoh_armor.LegsPharaohArmorModel;
import org.dawnoftime.armoroftheages.client.models.quetzalcoatl_armor.ChestQuetzalcoatlArmorModel;
import org.dawnoftime.armoroftheages.client.models.quetzalcoatl_armor.FeetQuetzalcoatlArmorModel;
import org.dawnoftime.armoroftheages.client.models.quetzalcoatl_armor.HeadQuetzalcoatlArmorModel;
import org.dawnoftime.armoroftheages.client.models.quetzalcoatl_armor.LegsQuetzalcoatlArmorModel;
import org.dawnoftime.armoroftheages.client.models.raijin_armor.ChestRaijinArmorModel;
import org.dawnoftime.armoroftheages.client.models.raijin_armor.FeetRaijinArmorModel;
import org.dawnoftime.armoroftheages.client.models.raijin_armor.HeadRaijinArmorModel;
import org.dawnoftime.armoroftheages.client.models.raijin_armor.LegsRaijinArmorModel;

import org.dawnoftime.armoroftheages.config.AOTAConfig;
import org.dawnoftime.armoroftheages.config.OYoroiSkin;

import static org.dawnoftime.armoroftheages.Constants.*;

// Client side
public class ModelProviderRegistry {

    public static final HashMap<String, ArmorModelProvider> REGISTRY = new HashMap<>();
    static {
        register(ANUBIS_ARMOR_NAME, EquipmentSlot.HEAD, HeadAnubisArmorModel::new, HeadAnubisArmorModel::createLayerDefinition, HeadAnubisArmorModel::createSlimLayerDefinition);
        register(ANUBIS_ARMOR_NAME, EquipmentSlot.CHEST, ChestAnubisArmorModel::new, ChestAnubisArmorModel::createLayerDefinition, ChestAnubisArmorModel::createSlimLayerDefinition);
        register(ANUBIS_ARMOR_NAME, EquipmentSlot.LEGS, LegsAnubisArmorModel::new, LegsAnubisArmorModel::createLayerDefinition);
        register(ANUBIS_ARMOR_NAME, EquipmentSlot.FEET, FeetAnubisArmorModel::new, FeetAnubisArmorModel::createLayerDefinition);
        register(CENTURION_ARMOR_NAME, EquipmentSlot.HEAD, HeadCenturionArmorModel::new, HeadCenturionArmorModel::createLayerDefinition);
        register(CENTURION_ARMOR_NAME, EquipmentSlot.CHEST, ChestCenturionArmorModel::new, ChestCenturionArmorModel::createLayerDefinition, ChestCenturionArmorModel::createSlimLayerDefinition);
        register(CENTURION_ARMOR_NAME, EquipmentSlot.LEGS, LegsCenturionArmorModel::new, LegsCenturionArmorModel::createLayerDefinition);
        register(CENTURION_ARMOR_NAME, EquipmentSlot.FEET, FeetCenturionArmorModel::new, FeetCenturionArmorModel::createLayerDefinition);
        register(EXALTED_AURUM_ARMOR_NAME, EquipmentSlot.HEAD, HeadExaltedAurumArmorModel::new, HeadExaltedAurumArmorModel::createLayerDefinition);
        register(EXALTED_AURUM_ARMOR_NAME, EquipmentSlot.CHEST, ChestExaltedAurumArmorModel::new, ChestExaltedAurumArmorModel::createLayerDefinition, ChestExaltedAurumArmorModel::createSlimLayerDefinition);
        register(EXALTED_AURUM_ARMOR_NAME, EquipmentSlot.LEGS, LegsExaltedAurumArmorModel::new, LegsExaltedAurumArmorModel::createLayerDefinition, LegsExaltedAurumArmorModel::createSlimLayerDefinition);
        register(EXALTED_AURUM_ARMOR_NAME, EquipmentSlot.FEET, FeetExaltedAurumArmorModel::new, FeetExaltedAurumArmorModel::createLayerDefinition);
        register(HOLY_ARMOR_NAME, EquipmentSlot.HEAD, HeadHolyArmorModel::new, HeadHolyArmorModel::createLayerDefinition);
        register(HOLY_ARMOR_NAME, EquipmentSlot.CHEST, ChestHolyArmorModel::new, ChestHolyArmorModel::createLayerDefinition, ChestHolyArmorModel::createSlimLayerDefinition);
        register(HOLY_ARMOR_NAME, EquipmentSlot.LEGS, LegsHolyArmorModel::new, LegsHolyArmorModel::createLayerDefinition);
        register(HOLY_ARMOR_NAME, EquipmentSlot.FEET, FeetHolyArmorModel::new, FeetHolyArmorModel::createLayerDefinition);
        register(IRON_PLATE_ARMOR_NAME, EquipmentSlot.HEAD, HeadIronPlateArmorModel::new, HeadIronPlateArmorModel::createLayerDefinition);
        register(IRON_PLATE_ARMOR_NAME, EquipmentSlot.CHEST, ChestIronPlateArmorModel::new, ChestIronPlateArmorModel::createLayerDefinition, ChestIronPlateArmorModel::createSlimLayerDefinition);
        register(IRON_PLATE_ARMOR_NAME, EquipmentSlot.LEGS, LegsIronPlateArmorModel::new, LegsIronPlateArmorModel::createLayerDefinition);
        register(IRON_PLATE_ARMOR_NAME, EquipmentSlot.FEET, FeetIronPlateArmorModel::new, FeetIronPlateArmorModel::createLayerDefinition);
        register(JAPANESE_LIGHT_ARMOR_NAME, EquipmentSlot.HEAD, HeadJapaneseLightArmorModel::new, HeadJapaneseLightArmorModel::createLayerDefinition);
        register(JAPANESE_LIGHT_ARMOR_NAME, EquipmentSlot.CHEST, ChestJapaneseLightArmorModel::new, ChestJapaneseLightArmorModel::createLayerDefinition, ChestJapaneseLightArmorModel::createSlimLayerDefinition);
        register(JAPANESE_LIGHT_ARMOR_NAME, EquipmentSlot.LEGS, LegsJapaneseLightArmorModel::new, LegsJapaneseLightArmorModel::createLayerDefinition);
        register(JAPANESE_LIGHT_ARMOR_NAME, EquipmentSlot.FEET, FeetJapaneseLightArmorModel::new, FeetJapaneseLightArmorModel::createLayerDefinition);
        registerSkinned(O_YOROI_ARMOR_NAME, EquipmentSlot.HEAD, HeadOYoroiArmorModel::new, HeadOYoroiArmorModel::createLayerDefinition, HeadOYoroiArmorModel::createLayerDefinition, () -> AOTAConfig.get().oYoroiSkin);
        registerSkinned(O_YOROI_ARMOR_NAME, EquipmentSlot.CHEST, ChestOYoroiArmorModel::new, ChestOYoroiArmorModel::createLayerDefinition, ChestOYoroiArmorModel::createSlimLayerDefinition, () -> AOTAConfig.get().oYoroiSkin);
        registerSkinned(O_YOROI_ARMOR_NAME, EquipmentSlot.LEGS, LegsOYoroiArmorModel::new, LegsOYoroiArmorModel::createLayerDefinition, LegsOYoroiArmorModel::createLayerDefinition, () -> AOTAConfig.get().oYoroiSkin);
        registerSkinned(O_YOROI_ARMOR_NAME, EquipmentSlot.FEET, FeetOYoroiArmorModel::new, FeetOYoroiArmorModel::createLayerDefinition, FeetOYoroiArmorModel::createLayerDefinition, () -> AOTAConfig.get().oYoroiSkin);
        register(PHARAOH_ARMOR_NAME, EquipmentSlot.HEAD, HeadPharaohArmorModel::new, HeadPharaohArmorModel::createLayerDefinition);
        register(PHARAOH_ARMOR_NAME, EquipmentSlot.CHEST, ChestPharaohArmorModel::new, ChestPharaohArmorModel::createLayerDefinition, ChestPharaohArmorModel::createSlimLayerDefinition);
        register(PHARAOH_ARMOR_NAME, EquipmentSlot.LEGS, LegsPharaohArmorModel::new, LegsPharaohArmorModel::createLayerDefinition);
        register(PHARAOH_ARMOR_NAME, EquipmentSlot.FEET, FeetPharaohArmorModel::new, FeetPharaohArmorModel::createLayerDefinition);
        register(QUETZALCOATL_ARMOR_NAME, EquipmentSlot.HEAD, HeadQuetzalcoatlArmorModel::new, HeadQuetzalcoatlArmorModel::createLayerDefinition);
        register(QUETZALCOATL_ARMOR_NAME, EquipmentSlot.CHEST, ChestQuetzalcoatlArmorModel::new, ChestQuetzalcoatlArmorModel::createLayerDefinition, ChestQuetzalcoatlArmorModel::createSlimLayerDefinition);
        register(QUETZALCOATL_ARMOR_NAME, EquipmentSlot.LEGS, LegsQuetzalcoatlArmorModel::new, LegsQuetzalcoatlArmorModel::createLayerDefinition);
        register(QUETZALCOATL_ARMOR_NAME, EquipmentSlot.FEET, FeetQuetzalcoatlArmorModel::new, FeetQuetzalcoatlArmorModel::createLayerDefinition);
        register(RAIJIN_ARMOR_NAME, EquipmentSlot.HEAD, HeadRaijinArmorModel::new, HeadRaijinArmorModel::createLayerDefinition, HeadRaijinArmorModel::createSlimLayerDefinition);
        register(RAIJIN_ARMOR_NAME, EquipmentSlot.CHEST, ChestRaijinArmorModel::new, ChestRaijinArmorModel::createLayerDefinition, ChestRaijinArmorModel::createSlimLayerDefinition);
        register(RAIJIN_ARMOR_NAME, EquipmentSlot.LEGS, LegsRaijinArmorModel::new, LegsRaijinArmorModel::createLayerDefinition, LegsRaijinArmorModel::createSlimLayerDefinition);
        register(RAIJIN_ARMOR_NAME, EquipmentSlot.FEET, FeetRaijinArmorModel::new, FeetRaijinArmorModel::createLayerDefinition);

    }

    private static void register(String armorName, EquipmentSlot slot, ArmorModelSupplier armorModelSupplier, Supplier<LayerDefinition> layerDefinition){
        ArmorModelProvider provider = ArmorModelProvider.create(armorName, slot, armorModelSupplier, layerDefinition);
        REGISTRY.put(armorName + "_" + slot.name().toLowerCase(), provider);
    }

    private static void register(String armorName, EquipmentSlot slot, ArmorModelSupplier armorModelSupplier, Supplier<LayerDefinition> layerDefinition, Supplier<LayerDefinition> slimLayerDefinition){
        ArmorModelProvider provider = ArmorModelProvider.create(armorName, slot, armorModelSupplier, layerDefinition, slimLayerDefinition);
        REGISTRY.put(armorName + "_" + slot.name().toLowerCase(), provider);
    }

    private static void registerSkinned(String armorName, EquipmentSlot slot, ArmorModelSupplier armorModelSupplier,
            Supplier<LayerDefinition> layerDefinition, Supplier<LayerDefinition> slimLayerDefinition,
            java.util.function.Supplier<OYoroiSkin> skinSupplier) {
        ArmorModelProvider provider = ArmorModelProvider.create(armorName, slot, armorModelSupplier, layerDefinition, slimLayerDefinition, skinSupplier);
        REGISTRY.put(armorName + "_" + slot.name().toLowerCase(), provider);
    }
}