package org.dawnoftime.armoroftheages.client.models.anubis_armor;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;
import org.dawnoftime.armoroftheages.client.models.ArmorModel;

public class LegsAnubisArmorModel<T extends LivingEntity> extends ArmorModel<T> {
    private final ModelPart ribbonLegs;

    public LegsAnubisArmorModel(ModelPart root, boolean isSlim) {
        super(root, isSlim);
        this.ribbonLegs = this.body.getChild("ribbonLegs");
    }

    @Override
    public <E extends LivingEntity> ArmorModel<E> create(ModelPart root, boolean isSlim) {
        return new LegsAnubisArmorModel<>(root, isSlim);
    }

    public static LayerDefinition createLayerDefinition() {
        MeshDefinition meshdefinition = templateLayerDefinition(1.0F);
        PartDefinition root = meshdefinition.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                        .texOffs(65, 18).addBox(-4.5F, 9.5F, -2.5F, 9.0F, 2.0F, 5.0F, new CubeDeformation(0.1F))
                        .texOffs(49, 25).addBox(-4.5F, 10.5F, -2.5F, 9.0F, 2.0F, 5.0F, new CubeDeformation(-0.05F))
                        .texOffs(67, 0).addBox(-1.5F, 8.75F, -2.75F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.1F)),
                PartPose.ZERO);

        body.addOrReplaceChild("ribbonLegs", CubeListBuilder.create()
                        .texOffs(14, 16).addBox(-1.5F, 0.0F, -0.25F, 3.0F, 6.0F, 0.0F, CubeDeformation.NONE),
                PartPose.offset(0.0F, 10.75F, -2.5F));

        PartDefinition leftLeg = root.addOrReplaceChild("left_leg", CubeListBuilder.create().mirror()
                        .texOffs(112, 48).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F))
                        .texOffs(38, 32).addBox(-2.4F, 0.4F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-0.05F)),
                PartPose.offset(1.9F, 12.0F, 0.0F));

        leftLeg.addOrReplaceChild("layerLegLeft", CubeListBuilder.create().mirror()
                        .texOffs(108, 18).addBox(-0.75F, -2.25F, -2.5F, 2.0F, 4.0F, 5.0F, new CubeDeformation(0.15F)),
                PartPose.offsetAndRotation(1.85F, 1.4F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition rightLeg = root.addOrReplaceChild("right_leg", CubeListBuilder.create()
                        .texOffs(112, 48).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F))
                        .texOffs(38, 32).addBox(-2.6F, 0.4F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-0.05F)),
                PartPose.offset(-1.9F, 12.0F, 0.0F));

        rightLeg.addOrReplaceChild("layerLegRight", CubeListBuilder.create()
                        .texOffs(108, 18).addBox(-1.25F, -2.25F, -2.5F, 2.0F, 4.0F, 5.0F, new CubeDeformation(0.15F)),
                PartPose.offsetAndRotation(-1.85F, 1.4F, 0.0F, 0.0F, 0.0F, 0.1745F));

        return LayerDefinition.create(meshdefinition, 128, 64);
    }

    @Override
    protected void setupArmorPartAnim(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.ribbonLegs.xRot = -Math.abs(0.05F + 1.02F * this.rightLeg.xRot) + 0.05F * (1 + sinPI(ageInTicks / 40.0F));
    }
}
