package org.armoroftheages.item;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import javax.annotation.Nullable;

import static org.armoroftheages.ArmorOfTheAges.MOD_TAB;

public class HatItem extends Item {

    public HatItem() {
        super(new Properties().tab(MOD_TAB));
    }

    @Nullable
    @Override
    public EquipmentSlotType getEquipmentSlot(ItemStack stack) {
        return EquipmentSlotType.HEAD;
    }
}
