package org.dawnoftime.armoroftheages.client.models.pharaoh_armor;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;
import org.dawnoftime.armoroftheages.client.models.ArmorModel;

public class LegsPharaohArmorModel<T extends LivingEntity> extends ArmorModel<T> {
    private final ModelPart bodyGoldenStrip;
    private final ModelPart bodyJewel;

    public LegsPharaohArmorModel(ModelPart root, boolean isSlim) {
        super(root, isSlim);
        this.bodyGoldenStrip = this.body.getChild("bodyGoldenStrip");
        this.bodyJewel = this.body.getChild("bodyJewel");
    }

    @Override
    public <E extends LivingEntity> ArmorModel<E> create(ModelPart root, boolean isSlim) {
        return new LegsPharaohArmorModel<>(root, isSlim);
    }

    public static LayerDefinition createLayerDefinition() {
        MeshDefinition meshdefinition = templateLayerDefinition(1.0F);
        PartDefinition root = meshdefinition.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                        .texOffs(28, 10)
                        .addBox(-4.5F, 8.5F, -2.5F, 9, 4, 5, CubeDeformation.NONE),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        body.addOrReplaceChild("bodyJewel", CubeListBuilder.create()
                        .texOffs(56, 10)
                        .addBox(-1.5F, -1.5F, -1.0F, 3, 3, 1, new CubeDeformation(-0.3F)),
                PartPose.offsetAndRotation(0.0F, 10.0F, -2.0F, 0.0F, 0.0F, 0.78539816F));

        body.addOrReplaceChild("bodyGoldenStrip", CubeListBuilder.create()
                        .texOffs(56, 14)
                        .addBox(-1.5F, 0.0F, 0.0F, 3, 8, 0, CubeDeformation.NONE),
                PartPose.offset(0.0F, 10.0F, -2.6F));

        root.addOrReplaceChild("left_leg", CubeListBuilder.create()
                        .texOffs(0, 33).mirror(true)
                        .addBox(-2.5F, -0.5F, -2.5F, 5, 6, 5, CubeDeformation.NONE),
                PartPose.offset(2.0F, 12.0F, 0.0F));

        root.addOrReplaceChild("right_leg", CubeListBuilder.create()
                        .texOffs(0, 33)
                        .addBox(-2.5F, -0.5F, -2.5F, 5, 6, 5, CubeDeformation.NONE),
                PartPose.offset(-2.0F, 12.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    protected void setupArmorPartAnim(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.bodyGoldenStrip.xRot = Math.abs(this.rightLeg.xRot);

        if (this.riding) {
            this.bodyGoldenStrip.xRot -= 1.0F;
        }

        this.bodyGoldenStrip.y = 10.0F;
        this.bodyJewel.y = 10.0F;
    }
}
