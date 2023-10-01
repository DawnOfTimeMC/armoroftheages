package com.dotteam.armorweapons.model;

import com.google.common.collect.Sets;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Set;
import java.util.stream.Stream;

import static com.dotteam.armorweapons.DoTAWConfig.JAPANESE_LIGHT_NAME;
import static com.dotteam.armorweapons.DoTArmorWeapons.MOD_ID;

@OnlyIn(Dist.CLIENT)
public class DoTWAModelLayers {
    private static final Set<ModelLayerLocation> ALL_MODELS = Sets.newHashSet();
    public static final ModelLayerLocation JAPANESE_LIGHT_HELMET = register(JAPANESE_LIGHT_NAME, Type.HELMET);

    private static ModelLayerLocation register(String armorSet, Type type) {
        ModelLayerLocation modellayerlocation = new ModelLayerLocation(new ResourceLocation(MOD_ID, armorSet + "/" + type.getName()), "main");
        if (!ALL_MODELS.add(modellayerlocation)) {
            throw new IllegalStateException("Duplicate registration for " + modellayerlocation);
        } else {
            return modellayerlocation;
        }
    }

    private static ModelLayerLocation createLocation(String pPath) {
        return
    }
    public static Stream<ModelLayerLocation> getKnownLocations() {
        return ALL_MODELS.stream();
    }
}
