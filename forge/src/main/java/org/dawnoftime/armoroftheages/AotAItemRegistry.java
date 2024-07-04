package org.dawnoftime.armoroftheages;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.dawnoftime.armoroftheages.item.ForgeHumanoidArmorItem;
import org.dawnoftime.armoroftheages.item.HatItem;
import org.dawnoftime.armoroftheages.item.AotAMaterials.DoTArmorMaterial;

import static net.minecraft.world.entity.EquipmentSlot.*;
import static org.dawnoftime.armoroftheages.ArmorOfTheAges.CREATIVE_MODE_TAB;
import static org.dawnoftime.armoroftheages.Constants.*;

public class AotAItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
    public static final RegistryObject<Item> TAB_ICON = ITEMS.register(MOD_ID, () -> new Item(new Item.Properties()));

    // Item registry
    static{
        ITEMS.register(BAMBOO_HAT_NAME, () -> new HatItem(new Item.Properties().stacksTo(1).tab(CREATIVE_MODE_TAB)));
        register(ANUBIS_ARMOR_NAME, DoTArmorMaterial.ANUBIS, HEAD);
        register(ANUBIS_ARMOR_NAME, DoTArmorMaterial.ANUBIS, CHEST);
        register(ANUBIS_ARMOR_NAME, DoTArmorMaterial.ANUBIS, LEGS);
        register(ANUBIS_ARMOR_NAME, DoTArmorMaterial.ANUBIS, FEET);
        register(CENTURION_ARMOR_NAME, DoTArmorMaterial.CENTURION, HEAD);
        register(CENTURION_ARMOR_NAME, DoTArmorMaterial.CENTURION, CHEST);
        register(CENTURION_ARMOR_NAME, DoTArmorMaterial.CENTURION, LEGS);
        register(CENTURION_ARMOR_NAME, DoTArmorMaterial.CENTURION, FEET);
        register(HOLY_ARMOR_NAME, DoTArmorMaterial.HOLY, HEAD);
        register(HOLY_ARMOR_NAME, DoTArmorMaterial.HOLY, CHEST);
        register(HOLY_ARMOR_NAME, DoTArmorMaterial.HOLY, LEGS);
        register(HOLY_ARMOR_NAME, DoTArmorMaterial.HOLY, FEET);
        register(IRON_PLATE_ARMOR_NAME, DoTArmorMaterial.IRON_PLATE, HEAD);
        register(IRON_PLATE_ARMOR_NAME, DoTArmorMaterial.IRON_PLATE, CHEST);
        register(IRON_PLATE_ARMOR_NAME, DoTArmorMaterial.IRON_PLATE, LEGS);
        register(IRON_PLATE_ARMOR_NAME, DoTArmorMaterial.IRON_PLATE, FEET);
        register(JAPANESE_LIGHT_ARMOR_NAME, DoTArmorMaterial.JAPANESE_LIGHT, HEAD);
        register(JAPANESE_LIGHT_ARMOR_NAME, DoTArmorMaterial.JAPANESE_LIGHT, CHEST);
        register(JAPANESE_LIGHT_ARMOR_NAME, DoTArmorMaterial.JAPANESE_LIGHT, LEGS);
        register(JAPANESE_LIGHT_ARMOR_NAME, DoTArmorMaterial.JAPANESE_LIGHT, FEET);
        register(O_YOROI_ARMOR_NAME, DoTArmorMaterial.O_YOROI, HEAD);
        register(O_YOROI_ARMOR_NAME, DoTArmorMaterial.O_YOROI, CHEST);
        register(O_YOROI_ARMOR_NAME, DoTArmorMaterial.O_YOROI, LEGS);
        register(O_YOROI_ARMOR_NAME, DoTArmorMaterial.O_YOROI, FEET);
        register(PHARAOH_ARMOR_NAME, DoTArmorMaterial.PHARAOH, HEAD);
        register(PHARAOH_ARMOR_NAME, DoTArmorMaterial.PHARAOH, CHEST);
        register(PHARAOH_ARMOR_NAME, DoTArmorMaterial.PHARAOH, LEGS);
        register(PHARAOH_ARMOR_NAME, DoTArmorMaterial.PHARAOH, FEET);
        register(QUETZALCOATL_ARMOR_NAME, DoTArmorMaterial.QUETZALCOATL, HEAD);
        register(QUETZALCOATL_ARMOR_NAME, DoTArmorMaterial.QUETZALCOATL, CHEST);
        register(QUETZALCOATL_ARMOR_NAME, DoTArmorMaterial.QUETZALCOATL, LEGS);
        register(QUETZALCOATL_ARMOR_NAME, DoTArmorMaterial.QUETZALCOATL, FEET);
        register(RAIJIN_ARMOR_NAME, DoTArmorMaterial.RAIJIN, HEAD);
        register(RAIJIN_ARMOR_NAME, DoTArmorMaterial.RAIJIN, CHEST);
        register(RAIJIN_ARMOR_NAME, DoTArmorMaterial.RAIJIN, LEGS);
        register(RAIJIN_ARMOR_NAME, DoTArmorMaterial.RAIJIN, FEET);
    }

    private static void register(String armorSetName, ArmorMaterial material, EquipmentSlot slot){
        ITEMS.register(armorSetName + "_" + slot.getName(), () -> new ForgeHumanoidArmorItem(armorSetName, material, slot, new Item.Properties().stacksTo(1).tab(CREATIVE_MODE_TAB)));
    }
}
