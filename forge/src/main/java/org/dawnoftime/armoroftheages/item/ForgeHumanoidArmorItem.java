package org.dawnoftime.armoroftheages.item;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.dawnoftime.armoroftheages.client.ArmorModelProvider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

import static org.dawnoftime.armoroftheages.ArmorOfTheAges.CREATIVE_MODE_TAB;

public class ForgeHumanoidArmorItem extends HumanoidArmorItem{
    /**
    This class only purpose is to match forge standard armor behavior, expected from other mods.
    Some mods call the ForgeHooksClient#getArmorModel() method, to get and use the custom models.
    All the function in this class are never called or used to render our armors by default.
    */
    public ForgeHumanoidArmorItem(@NotNull String armorSetName, ArmorMaterial material, EquipmentSlot type, Properties properties) {
        super(armorSetName, material, type, properties);
    }

    @Override
    public void initializeClient(@NotNull Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel<?> defaultModel) {
                final ArmorModelProvider provider = ForgeHumanoidArmorItem.this.getModelProvider();
                if(provider != null){
                    HumanoidModel<?> model = provider.getArmorModel(living);
                    model.crouching = living.isShiftKeyDown();
                    model.riding = defaultModel.riding;
                    return model;
                }else{
                    return defaultModel;
                }
            }
        });
    }

    @Override
    public @Nullable String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        ArmorModelProvider provider = this.getModelProvider();
        return provider != null ? provider.getTexture(entity).toString() : null;
    }
}
