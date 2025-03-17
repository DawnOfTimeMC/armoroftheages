package org.dawnoftime.armoroftheages;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import org.dawnoftime.armoroftheages.item.HatItem;
import org.dawnoftime.armoroftheages.item.HumanoidArmorItem;

import java.util.ArrayList;
import java.util.List;

import static net.minecraft.world.item.ArmorItem.Type.*;
import static org.dawnoftime.armoroftheages.AotAArmorMaterialRegistry.*;
import static org.dawnoftime.armoroftheages.Constants.*;

public class AotAItemRegistry {

    public static final List<Item> ITEMS = new ArrayList<>();
    public static final Item TAB_ICON = new Item(new Item.Properties());

    public static void init(){
        register(MOD_ID, TAB_ICON);

        // Item registry
        register(BAMBOO_HAT_NAME, new HatItem());
        register(ANUBIS_ARMOR_NAME, ANUBIS, HELMET, 25);
        register(ANUBIS_ARMOR_NAME, ANUBIS, CHESTPLATE, 25);
        register(ANUBIS_ARMOR_NAME, ANUBIS, LEGGINGS, 25);
        register(ANUBIS_ARMOR_NAME, ANUBIS, BOOTS, 25);
        register(CENTURION_ARMOR_NAME, CENTURION, HELMET, 22);
        register(CENTURION_ARMOR_NAME, CENTURION, CHESTPLATE, 22);
        register(CENTURION_ARMOR_NAME, CENTURION, LEGGINGS, 22);
        register(CENTURION_ARMOR_NAME, CENTURION, BOOTS, 22);
        register(HOLY_ARMOR_NAME, HOLY, HELMET, 40);
        register(HOLY_ARMOR_NAME, HOLY, CHESTPLATE, 40);
        register(HOLY_ARMOR_NAME, HOLY, LEGGINGS, 40);
        register(HOLY_ARMOR_NAME, HOLY, BOOTS, 40);
        register(IRON_PLATE_ARMOR_NAME, IRON_PLATE, HELMET, 25);
        register(IRON_PLATE_ARMOR_NAME, IRON_PLATE, CHESTPLATE, 25);
        register(IRON_PLATE_ARMOR_NAME, IRON_PLATE, LEGGINGS, 25);
        register(IRON_PLATE_ARMOR_NAME, IRON_PLATE, BOOTS, 25);
        register(JAPANESE_LIGHT_ARMOR_NAME, JAPANESE_LIGHT, HELMET, 12);
        register(JAPANESE_LIGHT_ARMOR_NAME, JAPANESE_LIGHT, CHESTPLATE, 12);
        register(JAPANESE_LIGHT_ARMOR_NAME, JAPANESE_LIGHT, LEGGINGS, 12);
        register(JAPANESE_LIGHT_ARMOR_NAME, JAPANESE_LIGHT, BOOTS, 12);
        register(O_YOROI_ARMOR_NAME, O_YOROI, HELMET, 20);
        register(O_YOROI_ARMOR_NAME, O_YOROI, CHESTPLATE, 20);
        register(O_YOROI_ARMOR_NAME, O_YOROI, LEGGINGS, 20);
        register(O_YOROI_ARMOR_NAME, O_YOROI, BOOTS, 20);
        register(PHARAOH_ARMOR_NAME, PHARAOH, HELMET, 10);
        register(PHARAOH_ARMOR_NAME, PHARAOH, CHESTPLATE, 10);
        register(PHARAOH_ARMOR_NAME, PHARAOH, LEGGINGS, 10);
        register(PHARAOH_ARMOR_NAME, PHARAOH, BOOTS, 10);
        register(QUETZALCOATL_ARMOR_NAME, QUETZALCOATL, HELMET, 25);
        register(QUETZALCOATL_ARMOR_NAME, QUETZALCOATL, CHESTPLATE, 25);
        register(QUETZALCOATL_ARMOR_NAME, QUETZALCOATL, LEGGINGS, 25);
        register(QUETZALCOATL_ARMOR_NAME, QUETZALCOATL, BOOTS, 25);
        register(RAIJIN_ARMOR_NAME, RAIJIN, HELMET, 35);
        register(RAIJIN_ARMOR_NAME, RAIJIN, CHESTPLATE, 35);
        register(RAIJIN_ARMOR_NAME, RAIJIN, LEGGINGS, 35);
        register(RAIJIN_ARMOR_NAME, RAIJIN, BOOTS, 35);
    }

    public static void register(String name, Item item){
        Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(MOD_ID, name), item);
        ITEMS.add(item);
    }

    public static void register(String armorSetName, Holder<ArmorMaterial> material, ArmorItem.Type slot, int durabilityFactor){
        Item item = new HumanoidArmorItem(armorSetName, material, slot, durabilityFactor);
        Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(MOD_ID, armorSetName + "_" + slot.getSlot().getName()), item);
        ITEMS.add(item);
    }
}
