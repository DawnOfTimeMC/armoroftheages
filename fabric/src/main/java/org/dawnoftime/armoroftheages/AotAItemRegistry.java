package org.dawnoftime.armoroftheages;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import org.dawnoftime.armoroftheages.item.AotAMaterials;
import org.dawnoftime.armoroftheages.item.HatItem;
import org.dawnoftime.armoroftheages.item.HumanoidArmorItem;

import java.util.ArrayList;
import java.util.List;

import static net.minecraft.world.item.ArmorItem.Type.*;
import static org.dawnoftime.armoroftheages.Constants.*;

public class AotAItemRegistry {

    public static final List<Item> ITEMS = new ArrayList<>();
    public static final Item TAB_ICON = new Item(new Item.Properties());

    public static void init(){
        register(MOD_ID, TAB_ICON);

        // Item registry
        register(BAMBOO_HAT_NAME, new HatItem());
        register(ANUBIS_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.ANUBIS, HELMET);
        register(ANUBIS_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.ANUBIS, CHESTPLATE);
        register(ANUBIS_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.ANUBIS, LEGGINGS);
        register(ANUBIS_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.ANUBIS, BOOTS);
        register(CENTURION_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.CENTURION, HELMET);
        register(CENTURION_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.CENTURION, CHESTPLATE);
        register(CENTURION_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.CENTURION, LEGGINGS);
        register(CENTURION_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.CENTURION, BOOTS);
        register(HOLY_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.HOLY, HELMET);
        register(HOLY_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.HOLY, CHESTPLATE);
        register(HOLY_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.HOLY, LEGGINGS);
        register(HOLY_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.HOLY, BOOTS);
        register(IRON_PLATE_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.IRON_PLATE, HELMET);
        register(IRON_PLATE_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.IRON_PLATE, CHESTPLATE);
        register(IRON_PLATE_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.IRON_PLATE, LEGGINGS);
        register(IRON_PLATE_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.IRON_PLATE, BOOTS);
        register(JAPANESE_LIGHT_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.JAPANESE_LIGHT, HELMET);
        register(JAPANESE_LIGHT_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.JAPANESE_LIGHT, CHESTPLATE);
        register(JAPANESE_LIGHT_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.JAPANESE_LIGHT, LEGGINGS);
        register(JAPANESE_LIGHT_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.JAPANESE_LIGHT, BOOTS);
        register(O_YOROI_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.O_YOROI, HELMET);
        register(O_YOROI_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.O_YOROI, CHESTPLATE);
        register(O_YOROI_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.O_YOROI, LEGGINGS);
        register(O_YOROI_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.O_YOROI, BOOTS);
        register(PHARAOH_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.PHARAOH, HELMET);
        register(PHARAOH_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.PHARAOH, CHESTPLATE);
        register(PHARAOH_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.PHARAOH, LEGGINGS);
        register(PHARAOH_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.PHARAOH, BOOTS);
        register(QUETZALCOATL_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.QUETZALCOATL, HELMET);
        register(QUETZALCOATL_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.QUETZALCOATL, CHESTPLATE);
        register(QUETZALCOATL_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.QUETZALCOATL, LEGGINGS);
        register(QUETZALCOATL_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.QUETZALCOATL, BOOTS);
        register(RAIJIN_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.RAIJIN, HELMET);
        register(RAIJIN_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.RAIJIN, CHESTPLATE);
        register(RAIJIN_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.RAIJIN, LEGGINGS);
        register(RAIJIN_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.RAIJIN, BOOTS);
    }

    public static void register(String name, Item item){
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(MOD_ID, name), item);
        ITEMS.add(item);
    }

    public static void register(String armorSetName, ArmorMaterial material, ArmorItem.Type slot){
        Item item = new HumanoidArmorItem(armorSetName, material, slot);
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(MOD_ID, armorSetName + "_" + slot.getName()), item);
        ITEMS.add(item);
    }
}
