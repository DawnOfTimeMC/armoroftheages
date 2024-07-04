package org.dawnoftime.armoroftheages;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import org.dawnoftime.armoroftheages.item.AotAMaterials;
import org.dawnoftime.armoroftheages.item.HatItem;
import org.dawnoftime.armoroftheages.item.HumanoidArmorItem;

import java.util.ArrayList;
import java.util.List;

import static net.minecraft.world.entity.EquipmentSlot.*;
import static org.dawnoftime.armoroftheages.ArmorOfTheAges.CREATIVE_MODE_TAB;
import static org.dawnoftime.armoroftheages.Constants.*;

public class AotAItemRegistry {

    public static final List<Item> ITEMS = new ArrayList<>();
    public static final Item TAB_ICON = new Item(new Item.Properties());

    public static void init(){
        register(MOD_ID, TAB_ICON);

        // Item registry
        register(BAMBOO_HAT_NAME, new HatItem(new Item.Properties().stacksTo(1).tab(CREATIVE_MODE_TAB)));
        register(ANUBIS_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.ANUBIS, HEAD);
        register(ANUBIS_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.ANUBIS, CHEST);
        register(ANUBIS_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.ANUBIS, LEGS);
        register(ANUBIS_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.ANUBIS, FEET);
        register(CENTURION_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.CENTURION, HEAD);
        register(CENTURION_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.CENTURION, CHEST);
        register(CENTURION_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.CENTURION, LEGS);
        register(CENTURION_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.CENTURION, FEET);
        register(HOLY_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.HOLY, HEAD);
        register(HOLY_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.HOLY, CHEST);
        register(HOLY_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.HOLY, LEGS);
        register(HOLY_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.HOLY, FEET);
        register(IRON_PLATE_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.IRON_PLATE, HEAD);
        register(IRON_PLATE_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.IRON_PLATE, CHEST);
        register(IRON_PLATE_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.IRON_PLATE, LEGS);
        register(IRON_PLATE_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.IRON_PLATE, FEET);
        register(JAPANESE_LIGHT_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.JAPANESE_LIGHT, HEAD);
        register(JAPANESE_LIGHT_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.JAPANESE_LIGHT, CHEST);
        register(JAPANESE_LIGHT_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.JAPANESE_LIGHT, LEGS);
        register(JAPANESE_LIGHT_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.JAPANESE_LIGHT, FEET);
        register(O_YOROI_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.O_YOROI, HEAD);
        register(O_YOROI_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.O_YOROI, CHEST);
        register(O_YOROI_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.O_YOROI, LEGS);
        register(O_YOROI_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.O_YOROI, FEET);
        register(PHARAOH_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.PHARAOH, HEAD);
        register(PHARAOH_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.PHARAOH, CHEST);
        register(PHARAOH_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.PHARAOH, LEGS);
        register(PHARAOH_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.PHARAOH, FEET);
        register(QUETZALCOATL_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.QUETZALCOATL, HEAD);
        register(QUETZALCOATL_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.QUETZALCOATL, CHEST);
        register(QUETZALCOATL_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.QUETZALCOATL, LEGS);
        register(QUETZALCOATL_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.QUETZALCOATL, FEET);
        register(RAIJIN_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.RAIJIN, HEAD);
        register(RAIJIN_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.RAIJIN, CHEST);
        register(RAIJIN_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.RAIJIN, LEGS);
        register(RAIJIN_ARMOR_NAME, AotAMaterials.DoTArmorMaterial.RAIJIN, FEET);
    }

    public static void register(String name, Item item){
        Registry.register(Registry.ITEM, new ResourceLocation(MOD_ID, name), item);
        ITEMS.add(item);
    }

    public static void register(String armorSetName, ArmorMaterial material, EquipmentSlot slot){
        Item item = new HumanoidArmorItem(armorSetName, material, slot, new Item.Properties().stacksTo(1).tab(CREATIVE_MODE_TAB));
        Registry.register(Registry.ITEM, new ResourceLocation(MOD_ID, armorSetName + "_" + slot.getName()), item);
        ITEMS.add(item);
    }
}
