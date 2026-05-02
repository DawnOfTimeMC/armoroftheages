package org.dawnoftime.armoroftheages.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Equipable;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

import net.minecraft.core.registries.BuiltInRegistries;
import org.dawnoftime.armoroftheages.CommonClass;
import net.minecraft.resources.ResourceLocation;
import org.dawnoftime.armoroftheages.Constants;
import org.dawnoftime.armoroftheages.setbonus.SetBonusRegistry;

import static org.dawnoftime.armoroftheages.Constants.MOD_ID;

/**
 * The bamboo hat is a HEAD-slot item that renders via its item model "head" display transform
 * (not as a HumanoidArmorItem with a 3D Java model). This keeps the visual intact while
 * exposing real armor stats driven by config, exactly like every other armor in the mod.
 */
public class HatItem extends Item implements Equipable {
    // Same UUID vanilla ArmorItem uses for the HELMET slot
    private static final UUID HELMET_UUID = UUID.fromString("2AD3F246-FEE1-4E67-B886-69FD380BB150");

    private final AotAMaterials.DoTArmorMaterial material;
    private final Multimap<Attribute, AttributeModifier> defaultModifiers;

    public HatItem(AotAMaterials.DoTArmorMaterial material) {
        super(new Properties().stacksTo(1).durability(material.getDurabilityForType(ArmorItem.Type.HELMET)));
        this.material = material;

        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ARMOR, new AttributeModifier(HELMET_UUID, "Armor modifier",
                material.getDefenseForType(ArmorItem.Type.HELMET), AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ARMOR_TOUGHNESS, new AttributeModifier(HELMET_UUID, "Armor toughness",
                material.getToughness(), AttributeModifier.Operation.ADDITION));
        if (material.getKnockbackResistance() > 0.0F) {
            builder.put(Attributes.KNOCKBACK_RESISTANCE, new AttributeModifier(HELMET_UUID, "Knockback resistance",
                    material.getKnockbackResistance(), AttributeModifier.Operation.ADDITION));
        }
        this.defaultModifiers = builder.build();
    }

    @Override
    public @NotNull EquipmentSlot getEquipmentSlot() {
        return EquipmentSlot.HEAD;
    }

    @Override
    public int getEnchantmentValue() {
        return this.material.getEnchantmentValue();
    }

    @Override
    public @NotNull Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(@NotNull EquipmentSlot slot) {
        return slot == EquipmentSlot.HEAD ? this.defaultModifiers : super.getDefaultAttributeModifiers(slot);
    }

    @Override
    public boolean isValidRepairItem(@NotNull ItemStack stack, @NotNull ItemStack repairCandidate) {
        return this.material.getRepairIngredient().test(repairCandidate);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, @NotNull List<Component> tooltips, @NotNull TooltipFlag flagIn) {
        super.appendHoverText(stack, level, tooltips, flagIn);
        if (this.material.getRepairIngredient().getItems().length > 0) {
            MutableComponent text = Component.translatable("tooltip." + MOD_ID + ".repair_with").withStyle(ChatFormatting.GRAY)
                    .append(this.material.getRepairIngredient().getItems()[0].getHoverName().plainCopy().withStyle(ChatFormatting.YELLOW));
            tooltips.add(text);
        }

        // Combo set bonus tooltip — Bamboo Hat + O-Yoroi chest/legs/feet
        SetBonusRegistry.get(Constants.BAMBOO_HAT_NAME).ifPresent(bonus -> {
            tooltips.add(Component.empty());

            Player player = (level != null && level.isClientSide()) ? CommonClass.LOCAL_PLAYER_SUPPLIER.get() : null;

            boolean headEquipped  = isComboSlotEquipped(player, EquipmentSlot.HEAD,  Constants.BAMBOO_HAT_NAME);
            boolean chestEquipped = isComboSlotEquipped(player, EquipmentSlot.CHEST, Constants.O_YOROI_ARMOR_NAME + "_" + EquipmentSlot.CHEST.getName());
            boolean legsEquipped  = isComboSlotEquipped(player, EquipmentSlot.LEGS,  Constants.O_YOROI_ARMOR_NAME + "_" + EquipmentSlot.LEGS.getName());
            boolean feetEquipped  = isComboSlotEquipped(player, EquipmentSlot.FEET,  Constants.O_YOROI_ARMOR_NAME + "_" + EquipmentSlot.FEET.getName());

            tooltips.add(comboSlotLine(headEquipped,  "set_bonus." + MOD_ID + ".slot.head"));
            tooltips.add(comboSlotLine(chestEquipped, "set_bonus." + MOD_ID + ".slot.chest"));
            tooltips.add(comboSlotLine(legsEquipped,  "set_bonus." + MOD_ID + ".slot.legs"));
            tooltips.add(comboSlotLine(feetEquipped,  "set_bonus." + MOD_ID + ".slot.feet"));

            boolean fullCombo = headEquipped && chestEquipped && legsEquipped && feetEquipped;
            ChatFormatting nameColor = fullCombo ? bonus.nameColor() : ChatFormatting.DARK_GRAY;
            MutableComponent bonusName = Component.translatable(bonus.nameTranslationKey()).withStyle(nameColor);
            tooltips.add(Component.translatable("set_bonus." + MOD_ID + ".unlock", bonusName).withStyle(ChatFormatting.GRAY));

            if (bonus.descriptionTranslationKey() != null) {
                tooltips.add(Component.translatable(bonus.descriptionTranslationKey())
                        .withStyle(fullCombo ? ChatFormatting.WHITE : ChatFormatting.DARK_GRAY));
            }
        });
    }

    private static MutableComponent comboSlotLine(boolean equipped, String translationKey) {
        return Component.translatable(translationKey).withStyle(equipped ? ChatFormatting.WHITE : ChatFormatting.DARK_GRAY);
    }

    /** Checks if the player has a specific mod item (by item path) equipped in the given slot. */
    private static boolean isComboSlotEquipped(@Nullable Player player, EquipmentSlot slot, String itemPath) {
        if (player == null) return false;
        ItemStack equipped = player.getItemBySlot(slot);
        if (equipped.isEmpty()) return false;
        ResourceLocation key = BuiltInRegistries.ITEM.getKey(equipped.getItem());
        return MOD_ID.equals(key.getNamespace()) && itemPath.equals(key.getPath());
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand interactionHand) {
        return this.swapWithEquipmentSlot(this, level, player, interactionHand);
    }
}
