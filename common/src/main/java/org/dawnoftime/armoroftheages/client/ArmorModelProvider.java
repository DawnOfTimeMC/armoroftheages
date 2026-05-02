package org.dawnoftime.armoroftheages.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import org.dawnoftime.armoroftheages.CommonClass;
import org.dawnoftime.armoroftheages.client.models.ArmorModel;
import org.dawnoftime.armoroftheages.config.AOTAConfig;
import org.dawnoftime.armoroftheages.config.PreferredModel;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

import static org.dawnoftime.armoroftheages.Constants.MOD_ID;

// Client side
public class ArmorModelProvider {
    protected static final ResourceLocation PLAYER_RESOURCE_LOCATION = new ResourceLocation("minecraft:player");

    public static ArmorModelProvider create(String armorName, EquipmentSlot slot, ArmorModelSupplier modelSupplier, Supplier<LayerDefinition> layerDefinitionSupplier){
        return new ArmorModelProvider(armorName, slot, modelSupplier, layerDefinitionSupplier);
    }

    public static ArmorModelProvider create(String armorName, EquipmentSlot slot, ArmorModelSupplier modelSupplier, Supplier<LayerDefinition> layerDefinitionSupplier, Supplier<LayerDefinition> slimLayerDefinitionSupplier){
        return new MixedArmorModelProvider(armorName, slot, modelSupplier, layerDefinitionSupplier, slimLayerDefinitionSupplier);
    }

    public static ArmorModelProvider create(String armorName, EquipmentSlot slot, ArmorModelSupplier modelSupplier,
            Supplier<LayerDefinition> layerDefinitionSupplier, Supplier<LayerDefinition> slimLayerDefinitionSupplier,
            java.util.function.Supplier<org.dawnoftime.armoroftheages.config.OYoroiSkin> skinSupplier) {
        return new SkinnedMixedArmorModelProvider(armorName, slot, modelSupplier, layerDefinitionSupplier, slimLayerDefinitionSupplier, skinSupplier);
    }

    private final Supplier<LayerDefinition> layerDefinitionSupplier;
    protected final ArmorModelSupplier modelSupplier;
    private ArmorModel<?> armorModel;
    private final ModelLayerLocation modelLayerLocation;
    private final ResourceLocation resourceLocation;

    protected ArmorModelProvider(String armorName, EquipmentSlot slot, ArmorModelSupplier modelSupplier, Supplier<LayerDefinition> layerDefinitionSupplier){
        this.layerDefinitionSupplier = layerDefinitionSupplier;
        this.modelSupplier = modelSupplier;
        this.modelLayerLocation = new ModelLayerLocation(PLAYER_RESOURCE_LOCATION, armorName + "_" + slot.name().toLowerCase());
        this.resourceLocation = new ResourceLocation(MOD_ID, "textures/models/armor/" + armorName + ".png");
    }

    @NotNull
    public ResourceLocation getTexture(Entity entity) {
        return this.resourceLocation;
    }

    @NotNull
    public ModelLayerLocation getLayerLocation() {
        return this.modelLayerLocation;
    }

    public LayerDefinition createLayer(){
        return this.layerDefinitionSupplier.get();
    }

    public static boolean isSlim(Entity entity) {
        // Respect preferences only if specified in configuration.
        if (entity == Minecraft.getInstance().player) {
            if (AOTAConfig.get().usePreferredModel) {
                return AOTAConfig.get().preferredModel == PreferredModel.FEMALE;
            }
        }
        if (!AOTAConfig.get().ignoredSynchronizedPreferredModel) {
            if (CommonClass.CURRENT_PREFERRED_MODEL_MAP.containsKey(entity.getUUID())) {
                return CommonClass.CURRENT_PREFERRED_MODEL_MAP.get(entity.getUUID()) == PreferredModel.FEMALE;
            }
        }

        return entity instanceof AbstractClientPlayer player && "slim".equals(player.getModelName());
    }

    public ArmorModel<?> getArmorModel(Entity entity) {
        if(this.armorModel == null){
            this.armorModel = this.modelSupplier.create(Minecraft.getInstance().getEntityModels().bakeLayer(this.modelLayerLocation), false);
        }
        return this.armorModel;
    }

    public static class SkinnedMixedArmorModelProvider extends MixedArmorModelProvider {
        private final java.util.Map<org.dawnoftime.armoroftheages.config.OYoroiSkin, ResourceLocation> skinTextures;
        private final java.util.Map<org.dawnoftime.armoroftheages.config.OYoroiSkin, ResourceLocation> slimSkinTextures;
        private final java.util.function.Supplier<org.dawnoftime.armoroftheages.config.OYoroiSkin> skinSupplier;

        protected SkinnedMixedArmorModelProvider(
                String armorName,
                EquipmentSlot slot,
                ArmorModelSupplier modelSupplier,
                java.util.function.Supplier<LayerDefinition> layerDefinitionSupplier,
                java.util.function.Supplier<LayerDefinition> slimLayerDefinitionSupplier,
                java.util.function.Supplier<org.dawnoftime.armoroftheages.config.OYoroiSkin> skinSupplier) {
            super(armorName, slot, modelSupplier, layerDefinitionSupplier, slimLayerDefinitionSupplier);
            this.skinSupplier = skinSupplier;
            this.skinTextures = new java.util.EnumMap<>(org.dawnoftime.armoroftheages.config.OYoroiSkin.class);
            this.slimSkinTextures = new java.util.EnumMap<>(org.dawnoftime.armoroftheages.config.OYoroiSkin.class);
            for (org.dawnoftime.armoroftheages.config.OYoroiSkin skin : org.dawnoftime.armoroftheages.config.OYoroiSkin.values()) {
                String prefix = skin.getTexturePrefix();
                this.skinTextures.put(skin, new ResourceLocation(MOD_ID, "textures/models/armor/" + prefix + armorName + ".png"));
                this.slimSkinTextures.put(skin, new ResourceLocation(MOD_ID, "textures/models/armor/" + prefix + armorName + "_slim.png"));
            }
        }

        @Override
        public @NotNull ResourceLocation getTexture(net.minecraft.world.entity.Entity entity) {
            org.dawnoftime.armoroftheages.config.OYoroiSkin skin = skinSupplier.get();
            return isSlim(entity) ? slimSkinTextures.get(skin) : skinTextures.get(skin);
        }
    }

    public static class MixedArmorModelProvider extends ArmorModelProvider{
        private final Supplier<LayerDefinition> slimLayerDefinitionSupplier;
        private final ModelLayerLocation slimModelLayerLocation;
        private final ResourceLocation slimResourceLocation;
        private ArmorModel<?> slimArmorModel;

        protected MixedArmorModelProvider(String armorName, EquipmentSlot slot, ArmorModelSupplier modelSupplier, Supplier<LayerDefinition> layerDefinitionSupplier, Supplier<LayerDefinition> slimLayerDefinitionSupplier){
            super(armorName, slot, modelSupplier, layerDefinitionSupplier);
            this.slimLayerDefinitionSupplier = slimLayerDefinitionSupplier;
            this.slimModelLayerLocation = new ModelLayerLocation(PLAYER_RESOURCE_LOCATION, armorName + "_" + slot.name().toLowerCase() + "_slim");
            this.slimResourceLocation = new ResourceLocation(MOD_ID, "textures/models/armor/" + armorName + "_slim.png");
        }

        @NotNull
        public ModelLayerLocation getSlimLayerLocation() {
            return this.slimModelLayerLocation;
        }

        public LayerDefinition createSlimLayer(){
            return this.slimLayerDefinitionSupplier.get();
        }

        @Override
        public @NotNull ResourceLocation getTexture(Entity entity) {
            return isSlim(entity) ? this.slimResourceLocation : super.getTexture(entity);
        }

        @Override
        public ArmorModel<?> getArmorModel(Entity entity) {
            if(ArmorModelProvider.isSlim(entity)){
                if(this.slimArmorModel == null){
                    this.slimArmorModel = this.modelSupplier.create(Minecraft.getInstance().getEntityModels().bakeLayer(this.slimModelLayerLocation), true);
                }
                return this.slimArmorModel;
            }else{
                return super.getArmorModel(entity);
            }
        }
    }
}