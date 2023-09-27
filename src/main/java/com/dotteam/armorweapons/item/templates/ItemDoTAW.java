package com.dotteam.armorweapons.item.templates;

import com.dotteam.armorweapons.util.DoTBUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;

public class ItemDoTAW extends Item {

    private final boolean hasTooltip;

    public ItemDoTAW() {
        this(false);
    }

    public ItemDoTAW(boolean hasTooltip){
        this(new Properties(), hasTooltip);
    }

    public ItemDoTAW(Properties properties){
        this(properties, false);
    }

    public ItemDoTAW(Properties properties, boolean hasTooltip){
        super(properties);
        this.hasTooltip = hasTooltip;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, @NotNull List<Component> tooltips, @NotNull TooltipFlag flagIn) {
        super.appendHoverText(stack, level, tooltips, flagIn);
        if(this.hasTooltip){
            DoTBUtils.addTooltip(tooltips, this);
        }
    }
}
