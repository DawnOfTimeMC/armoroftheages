package org.dawnoftime.armoroftheages.registry;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.ArmorMaterial;
import net.neoforged.neoforge.registries.DeferredRegister;

import static org.dawnoftime.armoroftheages.Constants.MOD_ID;

public class ArmorMaterialRegistryNeoForge extends ArmorMaterialRegistry {
    private static final DeferredRegister<ArmorMaterial> DEFERRED_REGISTER = 
        DeferredRegister.create(Registries.ARMOR_MATERIAL, MOD_ID);

    @Override
    public Holder<ArmorMaterial> register(String name, ArmorMaterial material) {
        return DEFERRED_REGISTER.register(name, () -> material);
    }

    public static DeferredRegister<ArmorMaterial> getDeferredRegister() {
        return DEFERRED_REGISTER;
    }
}