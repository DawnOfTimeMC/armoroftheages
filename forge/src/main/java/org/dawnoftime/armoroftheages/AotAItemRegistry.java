package org.dawnoftime.armoroftheages;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.dawnoftime.armoroftheages.item.ForgeHumanoidArmorItem;
import org.dawnoftime.armoroftheages.item.HatItem;
import org.dawnoftime.armoroftheages.item.AotAMaterials.DoTArmorMaterial;

import static net.minecraft.world.item.ArmorItem.Type.*;
import static org.dawnoftime.armoroftheages.Constants.*;

public class AotAItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
    public static final RegistryObject<Item> TAB_ICON = ITEMS.register(MOD_ID, () -> new Item(new Item.Properties()));

    // Item registry
    static{
        ITEMS.register(BAMBOO_HAT_NAME, HatItem::new);
        register(ANUBIS_ARMOR_NAME, DoTArmorMaterial.ANUBIS, HELMET);
        register(ANUBIS_ARMOR_NAME, DoTArmorMaterial.ANUBIS, CHESTPLATE);
        register(ANUBIS_ARMOR_NAME, DoTArmorMaterial.ANUBIS, LEGGINGS);
        register(ANUBIS_ARMOR_NAME, DoTArmorMaterial.ANUBIS, BOOTS);
        register(CENTURION_ARMOR_NAME, DoTArmorMaterial.CENTURION, HELMET);
        register(CENTURION_ARMOR_NAME, DoTArmorMaterial.CENTURION, CHESTPLATE);
        register(CENTURION_ARMOR_NAME, DoTArmorMaterial.CENTURION, LEGGINGS);
        register(CENTURION_ARMOR_NAME, DoTArmorMaterial.CENTURION, BOOTS);
        register(HOLY_ARMOR_NAME, DoTArmorMaterial.HOLY, HELMET);
        register(HOLY_ARMOR_NAME, DoTArmorMaterial.HOLY, CHESTPLATE);
        register(HOLY_ARMOR_NAME, DoTArmorMaterial.HOLY, LEGGINGS);
        register(HOLY_ARMOR_NAME, DoTArmorMaterial.HOLY, BOOTS);
        register(IRON_PLATE_ARMOR_NAME, DoTArmorMaterial.IRON_PLATE, HELMET);
        register(IRON_PLATE_ARMOR_NAME, DoTArmorMaterial.IRON_PLATE, CHESTPLATE);
        register(IRON_PLATE_ARMOR_NAME, DoTArmorMaterial.IRON_PLATE, LEGGINGS);
        register(IRON_PLATE_ARMOR_NAME, DoTArmorMaterial.IRON_PLATE, BOOTS);
        register(JAPANESE_LIGHT_ARMOR_NAME, DoTArmorMaterial.JAPANESE_LIGHT, HELMET);
        register(JAPANESE_LIGHT_ARMOR_NAME, DoTArmorMaterial.JAPANESE_LIGHT, CHESTPLATE);
        register(JAPANESE_LIGHT_ARMOR_NAME, DoTArmorMaterial.JAPANESE_LIGHT, LEGGINGS);
        register(JAPANESE_LIGHT_ARMOR_NAME, DoTArmorMaterial.JAPANESE_LIGHT, BOOTS);
        register(O_YOROI_ARMOR_NAME, DoTArmorMaterial.O_YOROI, HELMET);
        register(O_YOROI_ARMOR_NAME, DoTArmorMaterial.O_YOROI, CHESTPLATE);
        register(O_YOROI_ARMOR_NAME, DoTArmorMaterial.O_YOROI, LEGGINGS);
        register(O_YOROI_ARMOR_NAME, DoTArmorMaterial.O_YOROI, BOOTS);
        register(PHARAOH_ARMOR_NAME, DoTArmorMaterial.PHARAOH, HELMET);
        register(PHARAOH_ARMOR_NAME, DoTArmorMaterial.PHARAOH, CHESTPLATE);
        register(PHARAOH_ARMOR_NAME, DoTArmorMaterial.PHARAOH, LEGGINGS);
        register(PHARAOH_ARMOR_NAME, DoTArmorMaterial.PHARAOH, BOOTS);
        register(QUETZALCOATL_ARMOR_NAME, DoTArmorMaterial.QUETZALCOATL, HELMET);
        register(QUETZALCOATL_ARMOR_NAME, DoTArmorMaterial.QUETZALCOATL, CHESTPLATE);
        register(QUETZALCOATL_ARMOR_NAME, DoTArmorMaterial.QUETZALCOATL, LEGGINGS);
        register(QUETZALCOATL_ARMOR_NAME, DoTArmorMaterial.QUETZALCOATL, BOOTS);
        register(RAIJIN_ARMOR_NAME, DoTArmorMaterial.RAIJIN, HELMET);
        register(RAIJIN_ARMOR_NAME, DoTArmorMaterial.RAIJIN, CHESTPLATE);
        register(RAIJIN_ARMOR_NAME, DoTArmorMaterial.RAIJIN, LEGGINGS);
        register(RAIJIN_ARMOR_NAME, DoTArmorMaterial.RAIJIN, BOOTS);
    }

    private static void register(String armorSetName, ArmorMaterial material, ArmorItem.Type slot){
        ITEMS.register(armorSetName + "_" + slot.getSlot().getName(), () -> new ForgeHumanoidArmorItem(armorSetName, material, slot));
    }
}
