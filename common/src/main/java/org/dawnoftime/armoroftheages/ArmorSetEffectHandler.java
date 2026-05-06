package org.dawnoftime.armoroftheages;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class ArmorSetEffectHandler {

    // Always-on effects: 5 minutes. Re-applied only when < 40 ticks remain.
    private static final int EFFECT_DURATION_PERMANENT   = 6000;

    // Condition-based effects: 1 minute. Remove explicitly when condition ends.
    private static final int EFFECT_DURATION_CONDITIONAL = 1200;

    private static final Set<UUID> DOMARU_ACTIVE        = new HashSet<>();
    private static final Set<UUID> PHARAOH_ACTIVE       = new HashSet<>();
    private static final Set<UUID> QUETZALCOATL_ACTIVE  = new HashSet<>();
    private static final Set<UUID> HOLY_ACTIVE          = new HashSet<>();
    private static final Set<UUID> RAIJIN_ACTIVE        = new HashSet<>();
    private static final Set<UUID> IRON_PLATE_ACTIVE    = new HashSet<>();
    private static final Set<UUID> O_YOROI_ACTIVE       = new HashSet<>();
    private static final Set<UUID> CENTURION_ACTIVE     = new HashSet<>();
    private static final Set<UUID> ANUBIS_ACTIVE        = new HashSet<>();
    private static final Set<UUID> EXALTED_AURUM_ACTIVE = new HashSet<>();
    private static final Set<UUID> BAMBOO_ACTIVE        = new HashSet<>();

    public static void onPlayerTick(Player player) {
        if (player.level().isClientSide()) return;

        applyDomaru(player);
        applyPharaoh(player);
        applyQuetzalcoatl(player);
        applyHoly(player);
        applyRaijin(player);
        applyIronPlate(player);
        applyOYoroi(player);
        applyCenturion(player);
        applyAnubis(player);
        applyExaltedAurum(player);
        applyBamboo(player);
    }

    // -------------------------------------------------------------------------
    // Do-maru: Speed I at night | Strength I when sneaking
    // -------------------------------------------------------------------------
    private static void applyDomaru(Player player) {
        boolean wearing = isWearingFullSet(player, Constants.JAPANESE_LIGHT_ARMOR_NAME);
        UUID uuid = player.getUUID();

        if (wearing) {
            if (!DOMARU_ACTIVE.contains(uuid)) {
                DOMARU_ACTIVE.add(uuid);
                player.level().playSound(null, player.getX(), player.getY(), player.getZ(),
                        SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.PLAYERS, 0.8f, 1.4f);
            }
            if (player.level().isNight()) {
                refreshConditional(player, MobEffects.MOVEMENT_SPEED, 0);
            } else {
                player.removeEffect(MobEffects.MOVEMENT_SPEED);
            }
            if (player.isShiftKeyDown()) {
                refreshConditional(player, MobEffects.DAMAGE_BOOST, 0);
            } else {
                player.removeEffect(MobEffects.DAMAGE_BOOST);
            }
        } else {
            if (DOMARU_ACTIVE.remove(uuid)) {
                player.removeEffect(MobEffects.MOVEMENT_SPEED);
                player.removeEffect(MobEffects.DAMAGE_BOOST);
            }
        }
    }

    // -------------------------------------------------------------------------
    // Pharaoh: Fire Resistance + Glowing (always) | Haste I (desert only)
    // -------------------------------------------------------------------------
    private static void applyPharaoh(Player player) {
        boolean wearing = isWearingFullSet(player, Constants.PHARAOH_ARMOR_NAME);
        UUID uuid = player.getUUID();

        if (wearing) {
            if (!PHARAOH_ACTIVE.contains(uuid)) {
                PHARAOH_ACTIVE.add(uuid);
                player.level().playSound(null, player.getX(), player.getY(), player.getZ(),
                        SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.PLAYERS, 0.8f, 1.0f);
            }
            refreshLong(player, MobEffects.FIRE_RESISTANCE, 0);
            refreshLong(player, MobEffects.GLOWING, 0);

            boolean inDesert = player.level().getBiome(player.blockPosition())
                    .unwrapKey()
                    .map(key -> key.location().equals(ResourceLocation.fromNamespaceAndPath("minecraft", "desert")))
                    .orElse(false);
            if (inDesert) {
                refreshConditional(player, MobEffects.DIG_SPEED, 0);
            } else {
                player.removeEffect(MobEffects.DIG_SPEED);
            }
        } else {
            if (PHARAOH_ACTIVE.remove(uuid)) {
                player.removeEffect(MobEffects.FIRE_RESISTANCE);
                player.removeEffect(MobEffects.GLOWING);
                player.removeEffect(MobEffects.DIG_SPEED);
            }
        }
    }

    // -------------------------------------------------------------------------
    // Quetzalcoatl: Hunger I + Poison I (always) | Strength I/II/III (HP-based)
    //   >= 50% HP: Strength I | < 50%: Strength II | < 20%: Strength III
    // -------------------------------------------------------------------------
    private static void applyQuetzalcoatl(Player player) {
        boolean wearing = isWearingFullSet(player, Constants.QUETZALCOATL_ARMOR_NAME);
        UUID uuid = player.getUUID();

        if (wearing) {
            if (!QUETZALCOATL_ACTIVE.contains(uuid)) {
                QUETZALCOATL_ACTIVE.add(uuid);
                player.level().playSound(null, player.getX(), player.getY(), player.getZ(),
                        SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.PLAYERS, 0.8f, 0.8f);
            }
            refreshLong(player, MobEffects.HUNGER, 0);
            refreshEffect(player, MobEffects.POISON, 0);

            float healthRatio = player.getHealth() / player.getMaxHealth();
            int strengthAmplifier = healthRatio < 0.20f ? 2 : healthRatio < 0.50f ? 1 : 0;
            refreshLong(player, MobEffects.DAMAGE_BOOST, strengthAmplifier);
        } else {
            if (QUETZALCOATL_ACTIVE.remove(uuid)) {
                player.removeEffect(MobEffects.HUNGER);
                player.removeEffect(MobEffects.POISON);
                player.removeEffect(MobEffects.DAMAGE_BOOST);
            }
        }
    }

    // -------------------------------------------------------------------------
    // Holy: Resistance I always | Resistance II + Regen I when monster within 16 blocks
    // -------------------------------------------------------------------------
    private static void applyHoly(Player player) {
        boolean wearing = isWearingFullSet(player, Constants.HOLY_ARMOR_NAME);
        UUID uuid = player.getUUID();

        if (wearing) {
            if (!HOLY_ACTIVE.contains(uuid)) {
                HOLY_ACTIVE.add(uuid);
                player.level().playSound(null, player.getX(), player.getY(), player.getZ(),
                        SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.PLAYERS, 0.8f, 1.2f);
            }
            AABB searchBox = player.getBoundingBox().inflate(16.0);
            boolean monsterNearby = !player.level().getEntitiesOfClass(Monster.class, searchBox).isEmpty();

            refreshLong(player, MobEffects.DAMAGE_RESISTANCE, monsterNearby ? 1 : 0);
            if (monsterNearby) {
                refreshConditional(player, MobEffects.REGENERATION, 0);
            } else {
                player.removeEffect(MobEffects.REGENERATION);
            }
        } else {
            if (HOLY_ACTIVE.remove(uuid)) {
                player.removeEffect(MobEffects.DAMAGE_RESISTANCE);
                player.removeEffect(MobEffects.REGENERATION);
            }
        }
    }

    // -------------------------------------------------------------------------
    // Raijin: all effects are weather-conditional
    //   Clear: Speed I + Jump Boost II + Slow Falling
    //   Rain:  Speed II + Strength I
    //   Storm: Speed II + Strength II
    // -------------------------------------------------------------------------
    private static void applyRaijin(Player player) {
        boolean wearing = isWearingFullSet(player, Constants.RAIJIN_ARMOR_NAME);
        UUID uuid = player.getUUID();

        if (wearing) {
            if (!RAIJIN_ACTIVE.contains(uuid)) {
                RAIJIN_ACTIVE.add(uuid);
                player.level().playSound(null, player.getX(), player.getY(), player.getZ(),
                        SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.PLAYERS, 0.8f, 0.6f);
            }
            boolean thundering = player.level().isThundering();
            boolean raining    = player.level().isRaining();

            if (thundering) {
                refreshConditional(player, MobEffects.MOVEMENT_SPEED, 1);
                refreshConditional(player, MobEffects.DAMAGE_BOOST,   1);
                player.removeEffect(MobEffects.JUMP);
                player.removeEffect(MobEffects.SLOW_FALLING);
            } else if (raining) {
                refreshConditional(player, MobEffects.MOVEMENT_SPEED, 1);
                refreshConditional(player, MobEffects.DAMAGE_BOOST,   0);
                player.removeEffect(MobEffects.JUMP);
                player.removeEffect(MobEffects.SLOW_FALLING);
            } else {
                // Clear: downgrade from II to I immediately if coming from rain/thunder
                forceEffect(player, MobEffects.MOVEMENT_SPEED, 0, EFFECT_DURATION_CONDITIONAL);
                refreshConditional(player, MobEffects.JUMP,         1);
                refreshConditional(player, MobEffects.SLOW_FALLING, 0);
                player.removeEffect(MobEffects.DAMAGE_BOOST);
            }
        } else {
            if (RAIJIN_ACTIVE.remove(uuid)) {
                player.removeEffect(MobEffects.MOVEMENT_SPEED);
                player.removeEffect(MobEffects.DAMAGE_BOOST);
                player.removeEffect(MobEffects.JUMP);
                player.removeEffect(MobEffects.SLOW_FALLING);
            }
        }
    }

    // -------------------------------------------------------------------------
    // Iron Plate: Resistance I
    // -------------------------------------------------------------------------
    private static void applyIronPlate(Player player) {
        boolean wearing = isWearingFullSet(player, Constants.IRON_PLATE_ARMOR_NAME);
        UUID uuid = player.getUUID();

        if (wearing) {
            if (!IRON_PLATE_ACTIVE.contains(uuid)) {
                IRON_PLATE_ACTIVE.add(uuid);
                player.level().playSound(null, player.getX(), player.getY(), player.getZ(),
                        SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.PLAYERS, 0.8f, 1.1f);
            }
            refreshLong(player, MobEffects.DAMAGE_RESISTANCE, 0);
        } else {
            if (IRON_PLATE_ACTIVE.remove(uuid)) {
                player.removeEffect(MobEffects.DAMAGE_RESISTANCE);
            }
        }
    }

    // -------------------------------------------------------------------------
    // O-Yoroi: Strength I
    // -------------------------------------------------------------------------
    private static void applyOYoroi(Player player) {
        boolean wearing = isWearingFullSet(player, Constants.O_YOROI_ARMOR_NAME);
        UUID uuid = player.getUUID();

        if (wearing) {
            if (!O_YOROI_ACTIVE.contains(uuid)) {
                O_YOROI_ACTIVE.add(uuid);
                player.level().playSound(null, player.getX(), player.getY(), player.getZ(),
                        SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.PLAYERS, 0.8f, 1.3f);
            }
            refreshLong(player, MobEffects.DAMAGE_BOOST, 0);
        } else {
            if (O_YOROI_ACTIVE.remove(uuid)) {
                player.removeEffect(MobEffects.DAMAGE_BOOST);
            }
        }
    }

    // -------------------------------------------------------------------------
    // Centurion: Saturation I
    // -------------------------------------------------------------------------
    private static void applyCenturion(Player player) {
        boolean wearing = isWearingFullSet(player, Constants.CENTURION_ARMOR_NAME);
        UUID uuid = player.getUUID();

        if (wearing) {
            if (!CENTURION_ACTIVE.contains(uuid)) {
                CENTURION_ACTIVE.add(uuid);
                player.level().playSound(null, player.getX(), player.getY(), player.getZ(),
                        SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.PLAYERS, 0.8f, 0.9f);
            }
            refreshLong(player, MobEffects.SATURATION, 0);
        } else {
            if (CENTURION_ACTIVE.remove(uuid)) {
                player.removeEffect(MobEffects.SATURATION);
            }
        }
    }

    // -------------------------------------------------------------------------
    // Anubis: Health Boost I + Wither (always)
    //   >= 50% HP: Resistance I | < 50%: Resistance II | < 20%: Resistance II + Strength I
    // -------------------------------------------------------------------------
    private static void applyAnubis(Player player) {
        boolean wearing = isWearingFullSet(player, Constants.ANUBIS_ARMOR_NAME);
        UUID uuid = player.getUUID();

        if (wearing) {
            if (!ANUBIS_ACTIVE.contains(uuid)) {
                ANUBIS_ACTIVE.add(uuid);
                player.level().playSound(null, player.getX(), player.getY(), player.getZ(),
                        SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.PLAYERS, 0.8f, 0.7f);
            }
            refreshLong(player, MobEffects.HEALTH_BOOST, 0);
            // refreshEffect prevents Wither tick-counter resets that block damage from firing
            refreshEffect(player, MobEffects.WITHER, 0);

            float healthRatio = player.getHealth() / player.getMaxHealth();
            int resistanceAmplifier = (healthRatio < 0.50f) ? 1 : 0;
            refreshLong(player, MobEffects.DAMAGE_RESISTANCE, resistanceAmplifier);

            if (healthRatio < 0.20f) {
                refreshConditional(player, MobEffects.DAMAGE_BOOST, 0);
            } else {
                player.removeEffect(MobEffects.DAMAGE_BOOST);
            }
        } else {
            if (ANUBIS_ACTIVE.remove(uuid)) {
                player.removeEffect(MobEffects.HEALTH_BOOST);
                player.removeEffect(MobEffects.WITHER);
                player.removeEffect(MobEffects.DAMAGE_RESISTANCE);
                player.removeEffect(MobEffects.DAMAGE_BOOST);
            }
        }
    }

    // -------------------------------------------------------------------------
    // Exalted Aurum: depth and dimension-based effects
    //   Surface  (Y >= 64): Mining Fatigue I + Weakness I
    //   Caves    (0 <= Y < 64): Weakness I + Resistance I
    //   Deep     (Y < 0):   Fire Resistance I + Resistance I
    //   Nether:             Fire Resistance II + Resistance I
    //   End:                Fire Resistance II + Resistance II
    // -------------------------------------------------------------------------
    private static void applyExaltedAurum(Player player) {
        boolean wearing = isWearingFullSet(player, Constants.EXALTED_AURUM_ARMOR_NAME);
        UUID uuid = player.getUUID();

        if (wearing) {
            if (!EXALTED_AURUM_ACTIVE.contains(uuid)) {
                EXALTED_AURUM_ACTIVE.add(uuid);
                player.level().playSound(null, player.getX(), player.getY(), player.getZ(),
                        SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.PLAYERS, 0.8f, 0.5f);
            }
            ResourceKey<Level> dimension = player.level().dimension();

            if (dimension.equals(Level.NETHER)) {
                refreshConditional(player, MobEffects.FIRE_RESISTANCE,   1);
                refreshConditional(player, MobEffects.DAMAGE_RESISTANCE, 0);
                player.removeEffect(MobEffects.WEAKNESS);
                player.removeEffect(MobEffects.DIG_SLOWDOWN);
            } else if (dimension.equals(Level.END)) {
                refreshConditional(player, MobEffects.FIRE_RESISTANCE,   1);
                refreshConditional(player, MobEffects.DAMAGE_RESISTANCE, 1);
                player.removeEffect(MobEffects.WEAKNESS);
                player.removeEffect(MobEffects.DIG_SLOWDOWN);
            } else {
                int y = player.blockPosition().getY();
                if (y < 0) {
                    refreshConditional(player, MobEffects.FIRE_RESISTANCE,   0);
                    refreshConditional(player, MobEffects.DAMAGE_RESISTANCE, 0);
                    player.removeEffect(MobEffects.WEAKNESS);
                    player.removeEffect(MobEffects.DIG_SLOWDOWN);
                } else if (y < 64) {
                    refreshConditional(player, MobEffects.WEAKNESS,          0);
                    refreshConditional(player, MobEffects.DAMAGE_RESISTANCE, 0);
                    player.removeEffect(MobEffects.FIRE_RESISTANCE);
                    player.removeEffect(MobEffects.DIG_SLOWDOWN);
                } else {
                    refreshConditional(player, MobEffects.DIG_SLOWDOWN, 0);
                    refreshConditional(player, MobEffects.WEAKNESS,     0);
                    player.removeEffect(MobEffects.FIRE_RESISTANCE);
                    player.removeEffect(MobEffects.DAMAGE_RESISTANCE);
                }
            }
        } else {
            if (EXALTED_AURUM_ACTIVE.remove(uuid)) {
                player.removeEffect(MobEffects.FIRE_RESISTANCE);
                player.removeEffect(MobEffects.DAMAGE_RESISTANCE);
                player.removeEffect(MobEffects.WEAKNESS);
                player.removeEffect(MobEffects.DIG_SLOWDOWN);
            }
        }
    }

    // -------------------------------------------------------------------------
    // Bamboo Hat combo: Bamboo Hat + O-Yoroi chest + legs + feet -> Haste I
    // -------------------------------------------------------------------------
    private static void applyBamboo(Player player) {
        boolean wearing = isBambooCombo(player);
        UUID uuid = player.getUUID();

        if (wearing) {
            if (!BAMBOO_ACTIVE.contains(uuid)) {
                BAMBOO_ACTIVE.add(uuid);
                player.level().playSound(null, player.getX(), player.getY(), player.getZ(),
                        SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.PLAYERS, 0.8f, 1.5f);
            }
            refreshLong(player, MobEffects.DIG_SPEED, 0);
        } else {
            if (BAMBOO_ACTIVE.remove(uuid)) {
                player.removeEffect(MobEffects.DIG_SPEED);
            }
        }
    }

    private static boolean isBambooCombo(Player player) {
        return isSpecificItem(player.getItemBySlot(EquipmentSlot.HEAD),  Constants.BAMBOO_HAT_NAME)
            && isArmorPiece(player.getItemBySlot(EquipmentSlot.CHEST), Constants.O_YOROI_ARMOR_NAME, EquipmentSlot.CHEST)
            && isArmorPiece(player.getItemBySlot(EquipmentSlot.LEGS),  Constants.O_YOROI_ARMOR_NAME, EquipmentSlot.LEGS)
            && isArmorPiece(player.getItemBySlot(EquipmentSlot.FEET),  Constants.O_YOROI_ARMOR_NAME, EquipmentSlot.FEET);
    }

    private static boolean isSpecificItem(ItemStack stack, String itemPath) {
        if (stack.isEmpty()) return false;
        ResourceLocation key = BuiltInRegistries.ITEM.getKey(stack.getItem());
        return Constants.MOD_ID.equals(key.getNamespace()) && itemPath.equals(key.getPath());
    }

    // -------------------------------------------------------------------------
    // Helpers
    // -------------------------------------------------------------------------

    private static void refreshLong(Player player, Holder<MobEffect> effect, int amplifier) {
        MobEffectInstance existing = player.getEffect(effect);
        if (existing != null && existing.getAmplifier() > amplifier) {
            player.removeEffect(effect);
            existing = null;
        }
        if (existing == null || existing.getAmplifier() != amplifier || existing.getDuration() < 40) {
            player.addEffect(new MobEffectInstance(effect, EFFECT_DURATION_PERMANENT, amplifier, false, false));
        }
    }

    private static void refreshConditional(Player player, Holder<MobEffect> effect, int amplifier) {
        MobEffectInstance existing = player.getEffect(effect);
        if (existing != null && existing.getAmplifier() > amplifier) {
            player.removeEffect(effect);
            existing = null;
        }
        if (existing == null || existing.getAmplifier() != amplifier || existing.getDuration() < 40) {
            player.addEffect(new MobEffectInstance(effect, EFFECT_DURATION_CONDITIONAL, amplifier, false, false));
        }
    }

    private static void forceEffect(Player player, Holder<MobEffect> effect, int amplifier, int durationTicks) {
        MobEffectInstance existing = player.getEffect(effect);
        if (existing == null || existing.getAmplifier() != amplifier || existing.getDuration() < 40) {
            player.removeEffect(effect);
            player.addEffect(new MobEffectInstance(effect, durationTicks, amplifier, false, false));
        }
    }

    // Prevents tick-counter resets that block Poison/Wither damage from firing
    private static void refreshEffect(Player player, Holder<MobEffect> effect, int amplifier) {
        MobEffectInstance existing = player.getEffect(effect);
        if (existing == null || existing.getAmplifier() != amplifier || existing.getDuration() < 40) {
            player.addEffect(new MobEffectInstance(effect, 200, amplifier, false, false));
        }
    }

    private static boolean isWearingFullSet(Player player, String setName) {
        return isArmorPiece(player.getItemBySlot(EquipmentSlot.HEAD),  setName, EquipmentSlot.HEAD)
            && isArmorPiece(player.getItemBySlot(EquipmentSlot.CHEST), setName, EquipmentSlot.CHEST)
            && isArmorPiece(player.getItemBySlot(EquipmentSlot.LEGS),  setName, EquipmentSlot.LEGS)
            && isArmorPiece(player.getItemBySlot(EquipmentSlot.FEET),  setName, EquipmentSlot.FEET);
    }

    private static boolean isArmorPiece(ItemStack stack, String setName, EquipmentSlot slot) {
        if (stack.isEmpty()) return false;
        ResourceLocation key = BuiltInRegistries.ITEM.getKey(stack.getItem());
        return Constants.MOD_ID.equals(key.getNamespace())
            && (setName + "_" + slot.getName()).equals(key.getPath());
    }
}
