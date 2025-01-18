package org.dawnoftime.armoroftheages.client.models.o_yoroi_armor;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;
import org.dawnoftime.armoroftheages.client.models.ArmorModel;

public class ChestOYoroiArmorModel<T extends LivingEntity> extends ArmorModel<T> {

    public <E extends LivingEntity> ChestOYoroiArmorModel(ModelPart root, boolean isSlim) {
        super(root, isSlim);
    }

    @Override
    public <E extends LivingEntity> ArmorModel<E> create(ModelPart root, boolean isSlim) {
        return new ChestOYoroiArmorModel<>(root, isSlim);
    }

    public static LayerDefinition createLayerDefinition() {
        MeshDefinition meshdefinition = templateLayerDefinition(1.0F);
        PartDefinition root = meshdefinition.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                        .texOffs(0, 0).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.3F)),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition chestProtBot = body.addOrReplaceChild("chestProtBot", CubeListBuilder.create()
                        .texOffs(24, 0).addBox(-4.5F, 4.0F, -2.0F, 9.0F, 7.0F, 5.0F, new CubeDeformation(0.1F)),
                PartPose.offset(0.0F, 0.0F, -0.5F));

        chestProtBot.addOrReplaceChild("chestProtTop", CubeListBuilder.create()
                        .texOffs(19, 12).addBox(-3.0F, 1.0F, -2.0F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.1F)),
                PartPose.offset(0.0F, 0.0F, -0.5F));

        PartDefinition rightArm = root.addOrReplaceChild("right_arm", CubeListBuilder.create()
                        .texOffs(0, 30).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.3F)),
                PartPose.offset(-5.0F, 2.0F, 0.0F));

        rightArm.addOrReplaceChild("armRightBot", CubeListBuilder.create()
                        .texOffs(38, 34).addBox(-3.5F, 8.5F, -2.5F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.2F)),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        rightArm.addOrReplaceChild("armRightMid", CubeListBuilder.create()
                        .texOffs(27, 36).addBox(-3.5F, 4.5F, -2.5F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.1F)),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        rightArm.addOrReplaceChild("armRightTop", CubeListBuilder.create()
                        .texOffs(16, 30).addBox(-3.5F, -2.5F, -2.5F, 3.0F, 6.0F, 5.0F, new CubeDeformation(0.2F)),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        rightArm.addOrReplaceChild("armRightShoulder", CubeListBuilder.create()
                        .texOffs(46, 35).addBox(-4.5F, -5.5F, -3.0F, 1.0F, 8.0F, 6.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3491F));

        PartDefinition leftArm = root.addOrReplaceChild("left_arm", CubeListBuilder.create()
                        .texOffs(0, 30).mirror(true).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.3F)),
                PartPose.offset(5.0F, 2.0F, 0.0F));

        leftArm.addOrReplaceChild("armLeftBot", CubeListBuilder.create()
                        .texOffs(38, 34).mirror(true).addBox(1.5F, 8.5F, -2.5F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.2F)),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        leftArm.addOrReplaceChild("armLeftMid", CubeListBuilder.create()
                        .texOffs(27, 36).mirror(true).addBox(0.5F, 4.5F, -2.5F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.1F)),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        leftArm.addOrReplaceChild("armLeftTop", CubeListBuilder.create()
                        .texOffs(16, 30).mirror(true).addBox(0.5F, -2.5F, -2.5F, 3.0F, 6.0F, 5.0F, new CubeDeformation(0.2F)),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        leftArm.addOrReplaceChild("armLeftShoulder", CubeListBuilder.create()
                        .texOffs(46, 35).mirror(true).addBox(3.5F, -5.5F, -3.0F, 1.0F, 8.0F, 6.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3491F));
        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    public static LayerDefinition createSlimLayerDefinition() {
        MeshDefinition meshdefinition = templateLayerDefinition(1.0F);
        PartDefinition root = meshdefinition.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                        .texOffs(0, 0).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.3F)),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition chestProtBot = body.addOrReplaceChild("chestProtBot", CubeListBuilder.create()
                        .texOffs(24, 0).addBox(-4.5F, 4.0F, -2.0F, 9.0F, 7.0F, 5.0F, new CubeDeformation(0.1F)),
                PartPose.offset(0.0F, 0.0F, -0.5F));

        chestProtBot.addOrReplaceChild("chestProtTop", CubeListBuilder.create()
                        .texOffs(24, 12).addBox(-3.0F, 1.0F, 2.0F, 6.0F, 2.0F, 1.0F, new CubeDeformation(0.1F)),
                PartPose.offset(0.0F, 0.0F, -0.5F));

        body.addOrReplaceChild("bodyBreast", CubeListBuilder.create()
                        .texOffs(27, 47).addBox(-3.5F, 0.0F, -3.65F, 7.0F, 2.0F, 3.0F, new CubeDeformation(-0.1F)),
                PartPose.offsetAndRotation(0.0F, 0.9F, -2.1F, 0.9948F, 0.0F, 0.0F));

        body.addOrReplaceChild("bodyBreastProt", CubeListBuilder.create()
                        .texOffs(23, 16).addBox(-3.0F, 0.8F, -0.1F, 6.0F, 2.0F, 1.0F, new CubeDeformation(0.1F)),
                PartPose.offsetAndRotation(0.0F, 0.9F, -2.1F, -0.5760F, 0.0F, 0.0F));

        PartDefinition rightArm = root.addOrReplaceChild("right_arm", CubeListBuilder.create()
                        .texOffs(0, 30).addBox(-2.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, new CubeDeformation(0.3F)),
                PartPose.offset(-5.0F, 2.5F, 0.0F));

        rightArm.addOrReplaceChild("armRightBot", CubeListBuilder.create()
                        .texOffs(38, 34).addBox(-2.5F, 8.5F, -2.5F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.2F)),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        rightArm.addOrReplaceChild("armRightMid", CubeListBuilder.create()
                        .texOffs(27, 36).addBox(-2.5F, 4.5F, -2.5F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.1F)),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        rightArm.addOrReplaceChild("armRightTop", CubeListBuilder.create()
                        .texOffs(16, 30).addBox(-2.5F, -2.5F, -2.5F, 3.0F, 6.0F, 5.0F, new CubeDeformation(0.2F)),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        rightArm.addOrReplaceChild("armRightShoulder", CubeListBuilder.create()
                        .texOffs(46, 35).addBox(-3.5F, -5.5F, -3.0F, 1.0F, 8.0F, 6.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2618F));

        PartDefinition leftArm = root.addOrReplaceChild("left_arm", CubeListBuilder.create()
                        .texOffs(0, 30).mirror(true).addBox(-1.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, new CubeDeformation(0.3F)),
                PartPose.offset(5.0F, 2.5F, 0.0F));

        leftArm.addOrReplaceChild("armLeftBot", CubeListBuilder.create()
                        .texOffs(38, 34).mirror(true).addBox(0.5F, 8.5F, -2.5F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.2F)),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        leftArm.addOrReplaceChild("armLeftMid", CubeListBuilder.create()
                        .texOffs(27, 36).mirror(true).addBox(-0.5F, 4.5F, -2.5F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.1F)),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        leftArm.addOrReplaceChild("armLeftTop", CubeListBuilder.create()
                        .texOffs(16, 30).mirror(true).addBox(-0.5F, -2.5F, -2.5F, 3.0F, 6.0F, 5.0F, new CubeDeformation(0.2F)),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        leftArm.addOrReplaceChild("armLeftShoulder", CubeListBuilder.create()
                        .texOffs(46, 35).mirror(true).addBox(2.5F, -5.5F, -3.0F, 1.0F, 8.0F, 6.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2618F));
        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    protected void setupArmorPartAnim(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}
}
