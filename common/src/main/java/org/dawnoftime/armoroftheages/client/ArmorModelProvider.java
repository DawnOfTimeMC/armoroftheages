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
import org.dawnoftime.armoroftheages.config.SkinSyncState;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;
import java.util.function.Supplier;

import static org.dawnoftime.armoroftheages.Constants.MOD_ID;

// Client side
public class ArmorModelProvider {
    protected static final ResourceLocation PLAYER_RESOURCE_LOCATION = ResourceLocation.withDefaultNamespace("player");

    public interface SkinVariant {
        String getTexturePrefix();
    }

    public static ArmorModelProvider create(String armorName, EquipmentSlot slot, ArmorModelSupplier modelSupplier, Supplier<LayerDefinition> layerDefinitionSupplier){
        return new ArmorModelProvider(armorName, slot, modelSupplier, layerDefinitionSupplier);
    }

    public static ArmorModelProvider create(String armorName, EquipmentSlot slot, ArmorModelSupplier modelSupplier, Supplier<LayerDefinition> layerDefinitionSupplier, Supplier<LayerDefinition> slimLayerDefinitionSupplier){
        return new MixedArmorModelProvider(armorName, slot, modelSupplier, layerDefinitionSupplier, slimLayerDefinitionSupplier);
    }

    public static <E extends Enum<E> & SkinVariant> ArmorModelProvider create(
            String armorName, EquipmentSlot slot, ArmorModelSupplier modelSupplier,
            Supplier<LayerDefinition> layerDefinitionSupplier, Supplier<LayerDefinition> slimLayerDefinitionSupplier,
            Supplier<E> skinSupplier, Class<E> enumClass, Function<SkinSyncState, E> syncStateExtractor) {
        return new SkinnedMixedArmorModelProvider<>(armorName, slot, modelSupplier, layerDefinitionSupplier, slimLayerDefinitionSupplier, skinSupplier, enumClass, syncStateExtractor);
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
        this.resourceLocation = ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/models/armor/" + armorName + ".png");
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
        if (entity == Minecraft.getInstance().player) {
            return AOTAConfig.get().preferredModel == PreferredModel.FEMALE;
        }
        if (CommonClass.CURRENT_PREFERRED_MODEL_MAP.containsKey(entity.getUUID())) {
            return CommonClass.CURRENT_PREFERRED_MODEL_MAP.get(entity.getUUID()) == PreferredModel.FEMALE;
        }
        return entity instanceof AbstractClientPlayer player && "slim".equals(player.getSkin().model().name());
    }

    public ArmorModel<?> getArmorModel(Entity entity) {
        if(this.armorModel == null){
            this.armorModel = this.modelSupplier.create(Minecraft.getInstance().getEntityModels().bakeLayer(this.modelLayerLocation), false);
        }
        return this.armorModel;
    }

    public static class SkinnedMixedArmorModelProvider<E extends Enum<E> & SkinVariant> extends MixedArmorModelProvider {
        private final java.util.Map<E, ResourceLocation> skinTextures;
        private final java.util.Map<E, ResourceLocation> slimSkinTextures;
        private final Supplier<E> skinSupplier;
        private final Function<SkinSyncState, E> syncStateExtractor;

        protected SkinnedMixedArmorModelProvider(
                String armorName,
                EquipmentSlot slot,
                ArmorModelSupplier modelSupplier,
                Supplier<LayerDefinition> layerDefinitionSupplier,
                Supplier<LayerDefinition> slimLayerDefinitionSupplier,
                Supplier<E> skinSupplier,
                Class<E> enumClass,
                Function<SkinSyncState, E> syncStateExtractor) {
            super(armorName, slot, modelSupplier, layerDefinitionSupplier, slimLayerDefinitionSupplier);
            this.skinSupplier = skinSupplier;
            this.syncStateExtractor = syncStateExtractor;
            this.skinTextures = new java.util.EnumMap<>(enumClass);
            this.slimSkinTextures = new java.util.EnumMap<>(enumClass);
            for (E skin : enumClass.getEnumConstants()) {
                String prefix = skin.getTexturePrefix();
                this.skinTextures.put(skin, ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/models/armor/" + prefix + armorName + ".png"));
                this.slimSkinTextures.put(skin, ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/models/armor/" + prefix + armorName + "_slim.png"));
            }
        }

        @Override
        public @NotNull ResourceLocation getTexture(Entity entity) {
            E skin;
            if (entity == Minecraft.getInstance().player) {
                skin = skinSupplier.get();
            } else {
                SkinSyncState syncState = CommonClass.CURRENT_SKIN_MAP.get(entity.getUUID());
                skin = (syncState != null) ? syncStateExtractor.apply(syncState) : skinSupplier.get();
            }
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
            this.slimResourceLocation = ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/models/armor/" + armorName + "_slim.png");
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