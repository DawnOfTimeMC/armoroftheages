package org.dawnoftime.armoroftheages.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Equipable;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.Level;
import org.dawnoftime.armoroftheages.CommonClass;
import org.dawnoftime.armoroftheages.Constants;
import org.dawnoftime.armoroftheages.setbonus.SetBonusRegistry;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HatItem extends Item implements Equipable {

    private final int enchantability;

    public HatItem(int durabilityFactor, int helmetDef, float toughness, int enchantability) {
        super(new Properties()
                .stacksTo(1)
                .durability(ArmorItem.Type.HELMET.getDurability(durabilityFactor))
                .attributes(buildModifiers(helmetDef, toughness)));
        this.enchantability = enchantability;
    }

    private static ItemAttributeModifiers buildModifiers(int helmetDef, float toughness) {
        ItemAttributeModifiers.Builder builder = ItemAttributeModifiers.builder();
        builder.add(Attributes.ARMOR,
                new AttributeModifier(
                        ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "armor.head"),
                        helmetDef,
                        AttributeModifier.Operation.ADD_VALUE),
                EquipmentSlotGroup.HEAD);
        if (toughness > 0.0F) {
            builder.add(Attributes.ARMOR_TOUGHNESS,
                    new AttributeModifier(
                            ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "armor_toughness.head"),
                            toughness,
                            AttributeModifier.Operation.ADD_VALUE),
                    EquipmentSlotGroup.HEAD);
        }
        return builder.build();
    }

    @Override
    public @NotNull EquipmentSlot getEquipmentSlot() {
        return EquipmentSlot.HEAD;
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantability;
    }

    @Override
    public boolean isValidRepairItem(@NotNull ItemStack stack, @NotNull ItemStack repairCandidate) {
        return repairCandidate.is(Items.BAMBOO);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context,
            @NotNull List<Component> tooltips, @NotNull TooltipFlag flag) {
        super.appendHoverText(stack, context, tooltips, flag);
        MutableComponent text = Component.translatable("tooltip." + Constants.MOD_ID + ".repair_with")
                .withStyle(ChatFormatting.GRAY)
                .append(Items.BAMBOO.getDefaultInstance().getHoverName().plainCopy()
                        .withStyle(ChatFormatting.YELLOW));
        tooltips.add(text);

        SetBonusRegistry.get(Constants.BAMBOO_HAT_NAME).ifPresent(bonus -> {
            tooltips.add(Component.empty());

            Player player = CommonClass.LOCAL_PLAYER_SUPPLIER.get();

            boolean headEquipped  = isComboSlotEquipped(player, EquipmentSlot.HEAD,  Constants.BAMBOO_HAT_NAME);
            boolean chestEquipped = isComboSlotEquipped(player, EquipmentSlot.CHEST, Constants.O_YOROI_ARMOR_NAME + "_" + EquipmentSlot.CHEST.getName());
            boolean legsEquipped  = isComboSlotEquipped(player, EquipmentSlot.LEGS,  Constants.O_YOROI_ARMOR_NAME + "_" + EquipmentSlot.LEGS.getName());
            boolean feetEquipped  = isComboSlotEquipped(player, EquipmentSlot.FEET,  Constants.O_YOROI_ARMOR_NAME + "_" + EquipmentSlot.FEET.getName());

            tooltips.add(comboSlotLine(headEquipped,  "set_bonus." + Constants.MOD_ID + ".slot.head"));
            tooltips.add(comboSlotLine(chestEquipped, "set_bonus." + Constants.MOD_ID + ".slot.chest"));
            tooltips.add(comboSlotLine(legsEquipped,  "set_bonus." + Constants.MOD_ID + ".slot.legs"));
            tooltips.add(comboSlotLine(feetEquipped,  "set_bonus." + Constants.MOD_ID + ".slot.feet"));

            boolean fullCombo = headEquipped && chestEquipped && legsEquipped && feetEquipped;
            ChatFormatting nameColor = fullCombo ? bonus.nameColor() : ChatFormatting.DARK_GRAY;
            MutableComponent bonusName = Component.translatable(bonus.nameTranslationKey()).withStyle(nameColor);
            tooltips.add(Component.translatable("set_bonus." + Constants.MOD_ID + ".unlock", bonusName)
                    .withStyle(ChatFormatting.GRAY));

            if (bonus.descriptionTranslationKey() != null) {
                tooltips.add(Component.translatable(bonus.descriptionTranslationKey())
                        .withStyle(fullCombo ? ChatFormatting.WHITE : ChatFormatting.DARK_GRAY));
            }
        });
    }

    private static MutableComponent comboSlotLine(boolean equipped, String key) {
        return Component.translatable(key).withStyle(equipped ? ChatFormatting.WHITE : ChatFormatting.DARK_GRAY);
    }

    private static boolean isComboSlotEquipped(@Nullable Player player, EquipmentSlot slot, String itemPath) {
        if (player == null) return false;
        ItemStack equipped = player.getItemBySlot(slot);
        if (equipped.isEmpty()) return false;
        ResourceLocation key = BuiltInRegistries.ITEM.getKey(equipped.getItem());
        return Constants.MOD_ID.equals(key.getNamespace()) && itemPath.equals(key.getPath());
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player,
            @NotNull InteractionHand interactionHand) {
        return this.swapWithEquipmentSlot(this, level, player, interactionHand);
    }
}
