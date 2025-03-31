package org.dawnoftime.armoroftheages.loot;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.NumberProvider;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import org.dawnoftime.armoroftheages.ArmorOfTheAgesForge;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class AmorOfTheAgesLootModifiersForge extends LootModifier {
    public static final Supplier<Codec<AmorOfTheAgesLootModifiersForge>> CODEC = Suppliers.memoize(
            () -> RecordCodecBuilder.create(
                    instance -> codecStart(instance)
                            .and(Codec.STRING.fieldOf("armor_name").forGetter(m -> m.armorSetName))
                            .and(Codec.FLOAT.fieldOf("armor_state").forGetter(m -> m.state))
                            .apply(instance, AmorOfTheAgesLootModifiersForge::new)
            )
    );


    private final String armorSetName;
    private final float state;
    private final Random RANDOM = new Random();

    public AmorOfTheAgesLootModifiersForge(LootItemCondition[] conditionsIn, String armorSetName, float state) {
        super(conditionsIn);
        this.armorSetName = armorSetName;
        this.state = state;
    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext lootContext) {
        for (LootItemCondition condition : this.conditions)
            if (!condition.test(lootContext))
                return generatedLoot;

        List<ResourceLocation> armorPieceLocations = ArmorOfTheAgesForge.ItemRegistryImpl
                .ARMORS_LOCATION_FROM_NAME
                .get(armorSetName);

        Item armorPieceItem = BuiltInRegistries.ITEM.get(armorPieceLocations.get(RANDOM.nextInt(armorPieceLocations.size())));
        ItemStack armorPieceItemStack = new ItemStack(armorPieceItem);

        generatedLoot.add(addDamage(armorPieceItemStack, lootContext));

        return generatedLoot;
    }

    public ItemStack addDamage(ItemStack itemStack, LootContext lootContext) {
        if (itemStack.isDamageableItem()) {
            NumberProvider damage = ConstantValue.exactly(state);
            int i = itemStack.getMaxDamage();
            float f = 0.0F;
            float g = 1.0F - Mth.clamp(damage.getFloat(lootContext) + f, 0.0F, 1.0F);
            itemStack.setDamageValue(Mth.floor(g * (float)i));
        }

        return itemStack;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}
