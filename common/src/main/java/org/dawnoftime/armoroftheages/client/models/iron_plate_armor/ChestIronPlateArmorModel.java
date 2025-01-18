package org.dawnoftime.armoroftheages.client.models.iron_plate_armor;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;
import org.dawnoftime.armoroftheages.client.models.ArmorModel;

public class ChestIronPlateArmorModel<T extends LivingEntity> extends ArmorModel<T> {
    private final ModelPart miscA;

    public ChestIronPlateArmorModel(ModelPart root, boolean isSlim) {
        super(root, isSlim);
        this.miscA = this.body.getChild("miscA");
    }

    @Override
    public <E extends LivingEntity> ArmorModel<E> create(ModelPart root, boolean isSlim) {
        return new ChestIronPlateArmorModel<>(root, isSlim);
    }

    public static LayerDefinition createLayerDefinition() {
        MeshDefinition meshdefinition = templateLayerDefinition(1.0F);
        PartDefinition root = meshdefinition.getRoot();

        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                        .texOffs(0, 4).addBox(-4.5F, -0.1F, -2.5F, 9.0F, 13.0F, 5.0F),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        body.addOrReplaceChild("backLeftBody", CubeListBuilder.create()
                        .texOffs(32, 27).addBox(-1.45F, 1.0F, 3.4F, 5.0F, 8.0F, 1.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.3187F, 0.0F));

        body.addOrReplaceChild("backRightBody", CubeListBuilder.create()
                        .texOffs(32, 27).mirror(true).addBox(-3.55F, 1.0F, 3.4F, 5.0F, 8.0F, 1.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.3187F, 0.0F));

        body.addOrReplaceChild("leftTopBody", CubeListBuilder.create()
                        .texOffs(33, 18).addBox(-2.9F, 0.1F, -5.3F, 4.0F, 8.0F, 1.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3643F, -0.4554F, -0.3643F));

        body.addOrReplaceChild("middleTopBody", CubeListBuilder.create()
                        .texOffs(54, 57).addBox(0.0F, -7.0F, 0.0F, 3.0F, 7.0F, 0.0F),
                PartPose.offsetAndRotation(-1.5F, 9.2F, -2.4F, 0.3491F, 0.0F, 0.0F));

        body.addOrReplaceChild("rightTopBody", CubeListBuilder.create()
                        .texOffs(33, 18).mirror(true).addBox(-1.1F, 0.1F, -5.3F, 4.0F, 8.0F, 1.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3643F, 0.4554F, 0.3643F));

        body.addOrReplaceChild("miscA", CubeListBuilder.create()
                        .texOffs(85, 35).addBox(-3.5F, 0.2F, 0.0F, 7.0F, 12.0F, 0.0F),
                PartPose.offsetAndRotation(0.0F, 8.6F, 3.3F, 0.0456F, 0.0F, 0.0F));

        PartDefinition leftHand = root.addOrReplaceChild("left_arm", CubeListBuilder.create()
                        .texOffs(112, 48).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.3F)),
                PartPose.offset(5.0F, 2.0F, 0.0F));

        PartDefinition leftShoulderA = leftHand.addOrReplaceChild("leftShoulderA", CubeListBuilder.create()
                        .texOffs(0, 54).addBox(-1.4F, -3.2F, -2.5F, 6.0F, 5.0F, 5.0F),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        leftShoulderA.addOrReplaceChild("leftShoulderB", CubeListBuilder.create()
                        .texOffs(0, 46).addBox(-0.4F, -1.3F, -2.5F, 6.0F, 3.0F, 5.0F, new CubeDeformation(0.2F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

        leftShoulderA.addOrReplaceChild("leftShoulderC", CubeListBuilder.create()
                        .texOffs(0, 22).addBox(-0.5F, -1.3F, -3.0F, 2.0F, 2.0F, 6.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1396F));

        PartDefinition rightHand = root.addOrReplaceChild("right_arm", CubeListBuilder.create()
                        .texOffs(112, 48).mirror(true).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.3F)),
                PartPose.offset(-5.0F, 2.0F, 0.0F));

        PartDefinition rightShoulderA = rightHand.addOrReplaceChild("rightShoulderA", CubeListBuilder.create()
                        .texOffs(0, 54).mirror(true).addBox(-5.0F, -3.2F, -2.5F, 6.0F, 5.0F, 5.0F),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        rightShoulderA.addOrReplaceChild("rightShoulderB", CubeListBuilder.create()
                        .texOffs(0, 46).mirror(true).addBox(-5.8F, -1.4F, -2.5F, 6.0F, 3.0F, 5.0F, new CubeDeformation(0.2F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

        rightShoulderA.addOrReplaceChild("rightShoulderC", CubeListBuilder.create()
                        .texOffs(0, 22).mirror(true).addBox(-1.5F, -1.3F, -3.0F, 2.0F, 2.0F, 6.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1396F));
        return LayerDefinition.create(meshdefinition, 128, 64);
    }

    public static LayerDefinition createSlimLayerDefinition() {
        MeshDefinition meshdefinition = templateLayerDefinition(1.0F);
        PartDefinition root = meshdefinition.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                        .texOffs(0, 4).addBox(-4.5F, -0.1F, -2.5F, 9.0F, 13.0F, 5.0F),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        body.addOrReplaceChild("backLeftBody", CubeListBuilder.create()
                        .texOffs(32, 27).addBox(-1.45F, 1.0F, 3.4F, 5.0F, 8.0F, 1.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.3187F, 0.0F));

        body.addOrReplaceChild("backRightBody", CubeListBuilder.create()
                        .texOffs(32, 27).mirror(true).addBox(-3.55F, 1.0F, 3.4F, 5.0F, 8.0F, 1.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.3187F, 0.0F));

        body.addOrReplaceChild("leftTopBody", CubeListBuilder.create()
                        .texOffs(33, 18).addBox(-2.9F, 0.1F, -5.3F, 4.0F, 8.0F, 1.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3643F, -0.4554F, -0.3643F));

        body.addOrReplaceChild("middleTopBody", CubeListBuilder.create()
                        .texOffs(54, 57).addBox(0.0F, -7.0F, 0.0F, 3.0F, 7.0F, 0.0F),
                PartPose.offsetAndRotation(-1.5F, 9.2F, -2.4F, 0.3491F, 0.0F, 0.0F));

        body.addOrReplaceChild("rightTopBody", CubeListBuilder.create()
                        .texOffs(33, 18).mirror(true).addBox(-1.1F, 0.1F, -5.3F, 4.0F, 8.0F, 1.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3643F, 0.4554F, 0.3643F));

        body.addOrReplaceChild("miscA", CubeListBuilder.create()
                        .texOffs(85, 35).addBox(-3.5F, 0.2F, 0.0F, 7.0F, 12.0F, 0.0F),
                PartPose.offsetAndRotation(0.0F, 8.6F, 3.3F, 0.0456F, 0.0F, 0.0F));

        PartDefinition leftHand = root.addOrReplaceChild("left_arm", CubeListBuilder.create()
                        .texOffs(112, 48).addBox(-1.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, new CubeDeformation(0.3F)),
                PartPose.offset(5.0F, 2.5F, 0.0F));

        PartDefinition leftShoulderA = leftHand.addOrReplaceChild("leftShoulderA", CubeListBuilder.create()
                        .texOffs(0, 54).addBox(-1.4F, -3.2F, -2.5F, 5.0F, 5.0F, 5.0F),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        leftShoulderA.addOrReplaceChild("leftShoulderB", CubeListBuilder.create()
                        .texOffs(0, 46).addBox(-0.4F, -1.3F, -2.5F, 5.0F, 3.0F, 5.0F, new CubeDeformation(0.2F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

        leftShoulderA.addOrReplaceChild("leftShoulderC", CubeListBuilder.create()
                        .texOffs(0, 22).addBox(-0.5F, -1.3F, -3.0F, 2.0F, 2.0F, 6.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1396F));

        PartDefinition rightHand = root.addOrReplaceChild("right_arm", CubeListBuilder.create()
                        .texOffs(112, 48).mirror(true).addBox(-2.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, new CubeDeformation(0.3F)),
                PartPose.offset(-5.0F, 2.5F, 0.0F));

        PartDefinition rightShoulderA = rightHand.addOrReplaceChild("rightShoulderA", CubeListBuilder.create()
                        .texOffs(0, 54).mirror(true).addBox(-4.0F, -3.2F, -2.5F, 5.0F, 5.0F, 5.0F),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        rightShoulderA.addOrReplaceChild("rightShoulderB", CubeListBuilder.create()
                        .texOffs(0, 46).mirror(true).addBox(-4.8F, -1.4F, -2.5F, 5.0F, 3.0F, 5.0F, new CubeDeformation(0.2F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

        rightShoulderA.addOrReplaceChild("rightShoulderC", CubeListBuilder.create()
                        .texOffs(0, 22).mirror(true).addBox(-1.5F, -1.3F, -3.0F, 2.0F, 2.0F, 6.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1396F));
        return LayerDefinition.create(meshdefinition, 128, 64);
    }

    @Override
    protected void setupArmorPartAnim(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        float f = Math.abs(this.rightLeg.xRot);
        this.miscA.xRot = 0.05F + 0.05F * sinPI(ageInTicks / 60.0F + 1.0F);
        if (this.riding) this.miscA.xRot += 1.0F;
        if (this.crouching) this.miscA.xRot -= 0.18F;
        else this.miscA.xRot += f;
    }
}
