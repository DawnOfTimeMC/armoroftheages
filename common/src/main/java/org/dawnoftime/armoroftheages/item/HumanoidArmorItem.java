package org.dawnoftime.armoroftheages.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import org.dawnoftime.armoroftheages.CommonClass;
import org.dawnoftime.armoroftheages.client.ArmorModelProvider;
import org.dawnoftime.armoroftheages.registry.ModelProviderRegistry;
import org.dawnoftime.armoroftheages.setbonus.SetBonus;
import org.dawnoftime.armoroftheages.setbonus.SetBonusRegistry;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static org.dawnoftime.armoroftheages.Constants.MOD_ID;

public class HumanoidArmorItem extends ArmorItem {

    private static final EquipmentSlot[] ARMOR_SLOTS = {
            EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET
    };

    private final String armorSetName;
    private final String armorPartName;

    private static Rarity deriveRarity(Holder<ArmorMaterial> material) {
        if (material.value().knockbackResistance() > 0f) return Rarity.EPIC;
        if (material.value().toughness() >= 2f) return Rarity.RARE;
        if (material.value().defense().getOrDefault(Type.HELMET, 0) >= 2) return Rarity.UNCOMMON;
        return Rarity.COMMON;
    }

    public HumanoidArmorItem(@NotNull String armorSetName, Holder<ArmorMaterial> material, Type type, int durabilityFactor) {
        super(material, type, new Properties().stacksTo(1).durability(type.getDurability(durabilityFactor)).rarity(deriveRarity(material)));
        this.armorSetName = armorSetName;
        this.armorPartName = armorSetName + "_" + type.getSlot().getName();
    }

    public @Nullable ArmorModelProvider getModelProvider() {
        return ModelProviderRegistry.REGISTRY.get(this.armorPartName);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
        if (this.material.value().repairIngredient().get().getItems().length > 0) {
            MutableComponent text = Component.translatable("tooltip." + MOD_ID + ".repair_with").withStyle(ChatFormatting.GRAY)
                    .append(this.material.value().repairIngredient().get().getItems()[0].getHoverName().plainCopy().withStyle(ChatFormatting.YELLOW));
            tooltipComponents.add(text);
        }

        SetBonusRegistry.get(this.armorSetName).ifPresent(bonus -> {
            tooltipComponents.add(Component.empty());

            Player player = CommonClass.LOCAL_PLAYER_SUPPLIER.get();

            for (EquipmentSlot slot : ARMOR_SLOTS) {
                boolean equipped = isSlotEquippedWithSet(player, slot);
                tooltipComponents.add(Component.translatable("set_bonus." + MOD_ID + ".slot." + slot.getName())
                        .withStyle(equipped ? ChatFormatting.WHITE : ChatFormatting.DARK_GRAY));
            }

            boolean fullSetEquipped = player != null
                    && isSlotEquippedWithSet(player, EquipmentSlot.HEAD)
                    && isSlotEquippedWithSet(player, EquipmentSlot.CHEST)
                    && isSlotEquippedWithSet(player, EquipmentSlot.LEGS)
                    && isSlotEquippedWithSet(player, EquipmentSlot.FEET);
            ChatFormatting nameColor = fullSetEquipped ? bonus.nameColor() : ChatFormatting.DARK_GRAY;
            MutableComponent bonusName = Component.translatable(bonus.nameTranslationKey()).withStyle(nameColor);
            tooltipComponents.add(Component.translatable("set_bonus." + MOD_ID + ".unlock", bonusName)
                    .withStyle(ChatFormatting.GRAY));

            if (bonus.descriptionTranslationKey() != null) {
                tooltipComponents.add(Component.translatable(bonus.descriptionTranslationKey())
                        .withStyle(fullSetEquipped ? ChatFormatting.WHITE : ChatFormatting.DARK_GRAY));
            }
        });
    }

    private boolean isSlotEquippedWithSet(@Nullable Player player, EquipmentSlot slot) {
        if (player == null) return false;
        ItemStack equipped = player.getItemBySlot(slot);
        if (equipped.isEmpty()) return false;
        ResourceLocation key = BuiltInRegistries.ITEM.getKey(equipped.getItem());
        return MOD_ID.equals(key.getNamespace())
                && (armorSetName + "_" + slot.getName()).equals(key.getPath());
    }
}
