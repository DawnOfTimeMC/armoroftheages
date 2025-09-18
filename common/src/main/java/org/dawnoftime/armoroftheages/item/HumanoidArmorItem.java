package org.dawnoftime.armoroftheages.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.dawnoftime.armoroftheages.client.ArmorModelProvider;
import org.dawnoftime.armoroftheages.registry.ModelProviderRegistry;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static org.dawnoftime.armoroftheages.Constants.MOD_ID;

public class HumanoidArmorItem extends ArmorItem {
    private final String armorPartName;
    public HumanoidArmorItem(@NotNull String armorSetName, Holder<ArmorMaterial> material, Type type) {
        super(material, type, new Properties().stacksTo(1));
        this.armorPartName = armorSetName + "_" + type.getSlot().getName();
    }

    public @Nullable ArmorModelProvider getModelProvider(){
        return ModelProviderRegistry.REGISTRY.get(this.armorPartName);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
        if(this.material.value().repairIngredient().get().getItems().length > 0){
            MutableComponent text = Component.translatable("tooltip." + MOD_ID + ".repair_with").withStyle(ChatFormatting.GRAY)
                    .append(this.material.value().repairIngredient().get().getItems()[0].getHoverName().plainCopy().withStyle(ChatFormatting.YELLOW));
            tooltipComponents.add(text);
        }
    }
}
