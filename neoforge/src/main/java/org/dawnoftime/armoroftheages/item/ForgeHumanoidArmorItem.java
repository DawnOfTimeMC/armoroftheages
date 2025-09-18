package org.dawnoftime.armoroftheages.item;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.dawnoftime.armoroftheages.ArmorOfTheAgesForge;
import org.dawnoftime.armoroftheages.client.ArmorModelProvider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ForgeHumanoidArmorItem extends HumanoidArmorItem{
    /**
    This class only purpose is to match forge standard armor behavior, expected from other mods.
    Some mods call the ForgeHooksClient#getArmorModel() method, to get and use the custom models.
    All the function in this class are never called or used to render our armors by default.
    */
    public ForgeHumanoidArmorItem(@NotNull String armorSetName, Holder<ArmorMaterial> material, Type type) {
        super(armorSetName, material, type);
    }


    @Override
    public @Nullable ResourceLocation getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, ArmorMaterial.Layer layer, boolean innerModel) {
        ArmorModelProvider provider = this.getModelProvider();
        return provider != null ? provider.getTexture(entity) : null;
    }

    public static void registerClientExtensions(RegisterClientExtensionsEvent event) {
        IClientItemExtensions extensions = new IClientItemExtensions() {
            @Override
            public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel<?> defaultModel) {
                if (stack.getItem() instanceof ForgeHumanoidArmorItem armorItem) {
                    final ArmorModelProvider provider = armorItem.getModelProvider();
                    if (provider != null) {
                        HumanoidModel<?> model = provider.getArmorModel(living);
                        model.crouching = living.isShiftKeyDown();
                        model.riding = defaultModel.riding;
                        return model;
                    }
                }
                return defaultModel;
            }
        };

        ArmorOfTheAgesForge.ItemRegistryImpl.DEFERRED_REGISTER.getEntries()
            .stream()
            .map(DeferredHolder::get)
            .filter(item -> item instanceof ForgeHumanoidArmorItem)
            .forEach(item -> event.registerItem(extensions, item));
    }
}
