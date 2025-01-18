package org.dawnoftime.armoroftheages.client.models.raijin_armor;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;
import org.dawnoftime.armoroftheages.client.models.ArmorModel;

public class LegsRaijinArmorModel<T extends LivingEntity> extends ArmorModel<T> {
    private final ModelPart chestBeltHangA;
    private final ModelPart chestBeltHangB;

    public LegsRaijinArmorModel(ModelPart root, boolean isSlim) {
        super(root, isSlim);
        this.chestBeltHangA = this.body.getChild("chestBeltHangA");
        this.chestBeltHangB = this.body.getChild("chestBeltHangB");
    }

    @Override
    public <E extends LivingEntity> ArmorModel<E> create(ModelPart root, boolean isSlim) {
        return new LegsRaijinArmorModel<>(root, isSlim);
    }

    public static LayerDefinition createLayerDefinition() {
        MeshDefinition meshdefinition = templateLayerDefinition(1.0F);
        PartDefinition root = meshdefinition.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                        .texOffs(0, 16).addBox(-4.5F, 9.0F, -2.5F, 9.0F, 2.0F, 5.0F, new CubeDeformation(0.2F)),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        body.addOrReplaceChild("chestBeltJewel", CubeListBuilder.create()
                        .texOffs(0, 23).addBox(0.0F, 8.5F, -3.0F, 3.0F, 3.0F, 1.0F, CubeDeformation.NONE),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        body.addOrReplaceChild("chestBeltHangA", CubeListBuilder.create()
                        .texOffs(14, 23).addBox(0.0F, 0.0F, -0.5F, 2.0F, 5.0F, 1.0F, new CubeDeformation(-0.2F)),
                PartPose.offset(0.0F, 11.2F, -2.5F));

        body.addOrReplaceChild("chestBeltHangB", CubeListBuilder.create()
                        .texOffs(8, 23).addBox(0.0F, 0.0F, -0.5F, 2.0F, 4.0F, 1.0F, new CubeDeformation(-0.3F)),
                PartPose.offset(1.0F, 11.0F, -2.75F));

        PartDefinition chestPant = body.addOrReplaceChild("chestPant", CubeListBuilder.create()
                        .texOffs(20, 23).addBox(-4.0F, 11.0F, -2.0F, 8.0F, 1.0F, 4.0F, new CubeDeformation(0.1F)),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        chestPant.addOrReplaceChild("chestPantLeftFront", CubeListBuilder.create()
                        .texOffs(23, 18).addBox(0.4F, -2.0F, -0.5F, 4.0F, 2.0F, 1.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(0.0F, 9.0F, 2.0F, -0.523599F, 0.0F, 0.0F));

        chestPant.addOrReplaceChild("chestPantRightFront", CubeListBuilder.create()
                        .texOffs(23, 18).addBox(-4.4F, -2.0F, -0.5F, 4.0F, 2.0F, 1.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(0.0F, 9.0F, 2.0F, -0.523599F, 0.0F, 0.0F));

        chestPant.addOrReplaceChild("chestPantLeft", CubeListBuilder.create()
                        .texOffs(28, 16).addBox(-0.5F, -2.0F, 0.0F, 1.0F, 2.0F, 5.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(4.0F, 9.0F, -2.5F, 0.0F, 0.0F, 0.523599F));

        chestPant.addOrReplaceChild("chestPantRight", CubeListBuilder.create()
                        .texOffs(28, 16).addBox(-0.5F, -2.0F, 0.0F, 1.0F, 2.0F, 5.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(-4.0F, 9.0F, -2.5F, 0.0F, 0.0F, -0.523599F));

        chestPant.addOrReplaceChild("chestPantLeftBack", CubeListBuilder.create()
                        .texOffs(23, 18).addBox(0.4F, -2.0F, -0.5F, 4.0F, 2.0F, 1.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(0.0F, 9.0F, -2.0F, 0.523599F, 0.0F, 0.0F));

        chestPant.addOrReplaceChild("chestPantRightBack", CubeListBuilder.create()
                        .texOffs(23, 18).addBox(-4.4F, -2.0F, -0.5F, 4.0F, 2.0F, 1.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(0.0F, 9.0F, -2.0F, 0.523599F, 0.0F, 0.0F));

        PartDefinition left_leg = root.addOrReplaceChild("left_leg", CubeListBuilder.create()
                        .texOffs(24, 7).addBox(-2.0F, 5.0F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.2F)),
                PartPose.offset(1.9F, 12.0F, 0.0F));

        left_leg.addOrReplaceChild("legLeftPantTop", CubeListBuilder.create()
                        .texOffs(35, 7).addBox(-2.5F, -1.0F, -2.5F, 5.0F, 6.0F, 5.0F, CubeDeformation.NONE),
                PartPose.ZERO);

        PartDefinition right_leg = root.addOrReplaceChild("right_leg", CubeListBuilder.create()
                        .texOffs(24, 7).addBox(-2.0F, 5.0F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.2F)),
                PartPose.offset(-1.9F, 12.0F, 0.0F));

        right_leg.addOrReplaceChild("legRightPantTop", CubeListBuilder.create()
                        .texOffs(35, 7).addBox(-2.5F, -1.0F, -2.5F, 5.0F, 6.0F, 5.0F, CubeDeformation.NONE),
                PartPose.ZERO);
        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    public static LayerDefinition createSlimLayerDefinition() {
        MeshDefinition meshdefinition = templateLayerDefinition(1.0F);
        PartDefinition root = meshdefinition.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                        .texOffs(0, 16).addBox(-4.5F, 9.0F, -2.5F, 9.0F, 2.0F, 5.0F, new CubeDeformation(0.2F)),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        body.addOrReplaceChild("chestBeltJewel", CubeListBuilder.create()
                        .texOffs(0, 23).addBox(0.0F, 8.5F, -3.0F, 3.0F, 3.0F, 1.0F, CubeDeformation.NONE),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        body.addOrReplaceChild("chestBeltHangA", CubeListBuilder.create()
                        .texOffs(14, 23).addBox(0.0F, 0.0F, -0.5F, 2.0F, 5.0F, 1.0F, new CubeDeformation(-0.2F)),
                PartPose.offset(0.0F, 11.2F, -2.5F));

        body.addOrReplaceChild("chestBeltHangB", CubeListBuilder.create()
                        .texOffs(8, 23).addBox(0.0F, 0.0F, -0.5F, 2.0F, 4.0F, 1.0F, new CubeDeformation(-0.3F)),
                PartPose.offset(1.0F, 11.0F, -2.75F));

        PartDefinition chestPant = body.addOrReplaceChild("chestPant", CubeListBuilder.create()
                        .texOffs(20, 23).addBox(-4.0F, 11.0F, -2.0F, 8.0F, 1.0F, 4.0F, new CubeDeformation(0.1F)),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        chestPant.addOrReplaceChild("chestPantLeftFront", CubeListBuilder.create()
                        .texOffs(23, 18).addBox(0.4F, -2.0F, -0.5F, 4.0F, 2.0F, 1.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(0.0F, 9.0F, 2.0F, -0.523599F, 0.0F, 0.0F));

        chestPant.addOrReplaceChild("chestPantRightFront", CubeListBuilder.create()
                        .texOffs(23, 18).addBox(-4.4F, -2.0F, -0.5F, 4.0F, 2.0F, 1.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(0.0F, 9.0F, 2.0F, -0.523599F, 0.0F, 0.0F));

        chestPant.addOrReplaceChild("chestPantLeft", CubeListBuilder.create()
                        .texOffs(28, 16).addBox(-0.5F, -2.0F, 0.0F, 1.0F, 2.0F, 5.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(4.0F, 9.0F, -2.5F, 0.0F, 0.0F, 0.523599F));

        chestPant.addOrReplaceChild("chestPantRight", CubeListBuilder.create()
                        .texOffs(28, 16).addBox(-0.5F, -2.0F, 0.0F, 1.0F, 2.0F, 5.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(-4.0F, 9.0F, -2.5F, 0.0F, 0.0F, -0.523599F));

        chestPant.addOrReplaceChild("chestPantLeftBack", CubeListBuilder.create()
                        .texOffs(23, 18).addBox(0.4F, -2.0F, -0.5F, 4.0F, 2.0F, 1.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(0.0F, 9.0F, -2.0F, 0.523599F, 0.0F, 0.0F));

        chestPant.addOrReplaceChild("chestPantRightBack", CubeListBuilder.create()
                        .texOffs(23, 18).addBox(-4.4F, -2.0F, -0.5F, 4.0F, 2.0F, 1.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(0.0F, 9.0F, -2.0F, 0.523599F, 0.0F, 0.0F));

        PartDefinition left_leg = root.addOrReplaceChild("left_leg", CubeListBuilder.create()
                        .texOffs(24, 7).addBox(-2.0F, 3.0F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.2F)),
                PartPose.offset(1.9F, 12.0F, 0.0F));

        left_leg.addOrReplaceChild("legLeftPantTop", CubeListBuilder.create()
                        .texOffs(35, 7).addBox(-2.5F, -1.0F, -2.5F, 5.0F, 4.0F, 5.0F, CubeDeformation.NONE),
                PartPose.ZERO);

        PartDefinition right_leg = root.addOrReplaceChild("right_leg", CubeListBuilder.create()
                        .texOffs(24, 7).addBox(-2.0F, 3.0F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.2F)),
                PartPose.offset(-1.9F, 12.0F, 0.0F));

        right_leg.addOrReplaceChild("legRightPantTop", CubeListBuilder.create()
                        .texOffs(35, 7).addBox(-2.5F, -1.0F, -2.5F, 5.0F, 4.0F, 5.0F, CubeDeformation.NONE),
                PartPose.ZERO);
        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    protected void setupArmorPartAnim(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        float f = this.leftLeg.xRot;
        if(f > 0.0F) {
            this.chestBeltHangA.xRot = f * 0.5F;
            this.chestBeltHangB.xRot = f * 0.5F;
        } else {
            this.chestBeltHangA.xRot = f;
            this.chestBeltHangA.zRot = f * 0.25F;
            this.chestBeltHangB.xRot = f;
            this.chestBeltHangB.yRot = f * 0.25F;
            this.chestBeltHangB.zRot = f * 0.5F;
        }

        if (this.riding) {
            this.chestBeltHangA.xRot += 3.0F;
            this.chestBeltHangB.xRot += 3.0F;
        }

        this.chestBeltHangA.y = 11.2F;
        this.chestBeltHangB.y = 11.0F;
    }
}
