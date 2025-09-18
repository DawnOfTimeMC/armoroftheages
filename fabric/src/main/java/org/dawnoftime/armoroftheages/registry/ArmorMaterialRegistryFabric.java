package org.dawnoftime.armoroftheages.registry;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.ArmorMaterial;

public class ArmorMaterialRegistryFabric extends ArmorMaterialRegistry {

    @Override
    public Holder<ArmorMaterial> register(String name, ArmorMaterial material) {
        return Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL, id(name), material);
    }
}