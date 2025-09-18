package org.dawnoftime.armoroftheages.loot;

import com.mojang.serialization.MapCodec;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.dawnoftime.armoroftheages.Constants;

import java.util.function.Supplier;

public class LootModifiers {
    public static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> LOOT_MODIFIERS = DeferredRegister.create(NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, Constants.MOD_ID);

    public static final Supplier<MapCodec<? extends IGlobalLootModifier>> ADD_ITEM = LOOT_MODIFIERS.register("add_item", ArmorOfTheAgesLootModifier.CODEC);

    public static void register(IEventBus eventBus) {
        LOOT_MODIFIERS.register(eventBus);
    }
}
