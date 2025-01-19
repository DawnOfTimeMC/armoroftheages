package org.dawnoftime.armoroftheages.client.models.japanese_light_armor;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;
import org.dawnoftime.armoroftheages.client.models.ArmorModel;

public class FeetJapaneseLightArmorModel<T extends LivingEntity> extends ArmorModel<T> {

    public FeetJapaneseLightArmorModel(ModelPart root, boolean isSlim) {
        super(root, isSlim);
    }

    @Override
    public <E extends LivingEntity> ArmorModel<E> create(ModelPart root, boolean isSlim) {
        return new FeetJapaneseLightArmorModel<>(root, isSlim);
    }

    public static LayerDefinition createLayerDefinition() {
        MeshDefinition meshdefinition = templateLayerDefinition(1.0F);
        PartDefinition root = meshdefinition.getRoot();
        root.getChild("right_leg").addOrReplaceChild("right_leg_prot", CubeListBuilder.create().texOffs(40, 0).addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, new CubeDeformation(0.3F)), PartPose.ZERO);
        root.getChild("left_leg").addOrReplaceChild("left_leg_prot", CubeListBuilder.create().mirror().texOffs(40, 0).addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, new CubeDeformation(0.3F)), PartPose.ZERO);
        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    protected void setupArmorPartAnim(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}
}
