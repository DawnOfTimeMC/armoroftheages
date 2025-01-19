package org.dawnoftime.armoroftheages.client.models.raijin_armor;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;
import org.dawnoftime.armoroftheages.client.models.ArmorModel;

public class FeetRaijinArmorModel<T extends LivingEntity> extends ArmorModel<T> {

    public FeetRaijinArmorModel(ModelPart root, boolean isSlim) {
        super(root, isSlim);
    }

    @Override
    public <E extends LivingEntity> ArmorModel<E> create(ModelPart root, boolean isSlim) {
        return new FeetRaijinArmorModel<>(root, isSlim);
    }

    public static LayerDefinition createLayerDefinition() {
        MeshDefinition meshdefinition = templateLayerDefinition(1.0F);
        PartDefinition root = meshdefinition.getRoot();
        PartDefinition left_leg = root.addOrReplaceChild("left_leg", CubeListBuilder.create()
                        .texOffs(30, 0).addBox(-2.5F, 8.5F, -2.5F, 5.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)),
                PartPose.offset(1.9F, 12.0F, 0.0F));

        left_leg.addOrReplaceChild("legRingLeftB", CubeListBuilder.create()
                        .texOffs(15, 1).addBox(-2.5F, 7.0F, -2.5F, 5.0F, 1.0F, 5.0F, new CubeDeformation(0.01F)),
                PartPose.ZERO);

        PartDefinition right_leg = root.addOrReplaceChild("right_leg", CubeListBuilder.create()
                        .texOffs(0, 0).addBox(-2.5F, 8.5F, -2.5F, 5.0F, 1.0F, 5.0F, new CubeDeformation(0.01F)),
                PartPose.offset(-1.9F, 12.0F, 0.0F));

        right_leg.addOrReplaceChild("legRingRightB", CubeListBuilder.create()
                        .texOffs(30, 0).addBox(-2.5F, 7.0F, -2.5F, 5.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)),
                PartPose.ZERO);
        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    protected void setupArmorPartAnim(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}
}
