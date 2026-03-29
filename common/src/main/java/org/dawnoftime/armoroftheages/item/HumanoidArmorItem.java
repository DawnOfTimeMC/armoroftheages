package org.dawnoftime.armoroftheages.item;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
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
import net.minecraft.world.level.Level;
import org.dawnoftime.armoroftheages.client.ArmorModelProvider;
import org.dawnoftime.armoroftheages.registry.ModelProviderRegistry;
import org.dawnoftime.armoroftheages.setbonus.SetBonus;
import org.dawnoftime.armoroftheages.setbonus.SetBonusRegistry;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static org.dawnoftime.armoroftheages.Constants.MOD_ID;

public class HumanoidArmorItem extends ArmorItem {

    // The four armor slots in display order (top to bottom)
    private static final EquipmentSlot[] ARMOR_SLOTS = {
            EquipmentSlot.HEAD,
            EquipmentSlot.CHEST,
            EquipmentSlot.LEGS,
            EquipmentSlot.FEET
    };

    private final String armorSetName;
    private final String armorPartName;

    public HumanoidArmorItem(@NotNull String armorSetName, ArmorMaterial material, Type type) {
        super(material, type, new Properties().stacksTo(1).rarity(deriveRarity(material)));
        this.armorSetName = armorSetName;
        this.armorPartName = armorSetName + "_" + type.getSlot().getName();
    }

    /**
     * Derives the item rarity (= name color) from the armor material stats,
     * following the vanilla Minecraft tier system:
     *   COMMON   (white)  = Leather-tier  → toughness=0, kbr=0, low defense
     *   UNCOMMON (yellow) = Iron-tier     → toughness=0, kbr=0, higher defense
     *   RARE     (aqua)   = Diamond-tier  → toughness≥2, kbr=0
     *   EPIC     (purple) = Netherite-tier → kbr>0
     */
    private static Rarity deriveRarity(ArmorMaterial material) {
        if (material.getKnockbackResistance() > 0f)                          return Rarity.EPIC;
        if (material.getToughness() >= 2f)                                   return Rarity.RARE;
        if (material.getDefenseForType(Type.HELMET) >= 2)                    return Rarity.UNCOMMON;
        return Rarity.COMMON;
    }

    public @Nullable ArmorModelProvider getModelProvider() {
        return ModelProviderRegistry.REGISTRY.get(this.armorPartName);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, @NotNull List<Component> tooltips, @NotNull TooltipFlag flagIn) {
        super.appendHoverText(stack, level, tooltips, flagIn);

        // Repair ingredient hint
        if (this.material.getRepairIngredient().getItems().length > 0) {
            MutableComponent text = Component.translatable("tooltip." + MOD_ID + ".repair_with")
                    .withStyle(ChatFormatting.GRAY)
                    .append(this.material.getRepairIngredient().getItems()[0].getHoverName()
                            .plainCopy().withStyle(ChatFormatting.YELLOW));
            tooltips.add(text);
        }

        // Set bonus tooltip — only shown client-side, and only if this set has a bonus defined
        SetBonusRegistry.get(this.armorSetName).ifPresent(bonus -> {
            // Blank line as separator
            tooltips.add(Component.empty());

            // Retrieve the local player if available (null in JEI/REI catalogue or on server)
            Player player = (level != null && level.isClientSide())
                    ? Minecraft.getInstance().player
                    : null;

            // One line per armor slot — white if the player has that piece equipped, dark gray if not
            for (EquipmentSlot slot : ARMOR_SLOTS) {
                boolean equipped = isSlotEquippedWithSet(player, slot);
                MutableComponent slotLine = Component.translatable("set_bonus." + MOD_ID + ".slot." + slot.getName())
                        .withStyle(equipped ? ChatFormatting.WHITE : ChatFormatting.DARK_GRAY);
                tooltips.add(slotLine);
            }

            // "Set Bonus: <name>" — name is colored only when the full set is active, gray otherwise
            boolean fullSetEquipped = player != null
                    && isSlotEquippedWithSet(player, EquipmentSlot.HEAD)
                    && isSlotEquippedWithSet(player, EquipmentSlot.CHEST)
                    && isSlotEquippedWithSet(player, EquipmentSlot.LEGS)
                    && isSlotEquippedWithSet(player, EquipmentSlot.FEET);
            ChatFormatting nameColor = fullSetEquipped ? bonus.nameColor() : ChatFormatting.DARK_GRAY;
            MutableComponent bonusName = Component.translatable(bonus.nameTranslationKey())
                    .withStyle(nameColor);
            tooltips.add(Component.translatable("set_bonus." + MOD_ID + ".unlock", bonusName)
                    .withStyle(ChatFormatting.GRAY));

            // Short description — white when full set is active, dark gray otherwise
            if (bonus.descriptionTranslationKey() != null) {
                tooltips.add(Component.translatable(bonus.descriptionTranslationKey())
                        .withStyle(fullSetEquipped ? ChatFormatting.WHITE : ChatFormatting.DARK_GRAY));
            }
        });
    }

    /**
     * Returns true if the given player has the correct piece of this set equipped in the given slot.
     * Safe to call with a null player (returns false).
     */
    private boolean isSlotEquippedWithSet(@Nullable Player player, EquipmentSlot slot) {
        if (player == null) return false;
        ItemStack equipped = player.getItemBySlot(slot);
        if (equipped.isEmpty()) return false;
        ResourceLocation key = BuiltInRegistries.ITEM.getKey(equipped.getItem());
        return MOD_ID.equals(key.getNamespace())
                && (armorSetName + "_" + slot.getName()).equals(key.getPath());
    }
}
