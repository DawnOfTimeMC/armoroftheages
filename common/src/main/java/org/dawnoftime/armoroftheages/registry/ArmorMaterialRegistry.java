package org.dawnoftime.armoroftheages.registry;

import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorMaterial;

public abstract class ArmorMaterialRegistry {
    public static ArmorMaterialRegistry REGISTRY;

    public abstract Holder<ArmorMaterial> register(String name, ArmorMaterial material);

    protected static ResourceLocation id(String name) {
        return ResourceLocation.fromNamespaceAndPath("armoroftheages", name);
    }
}