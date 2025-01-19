package org.dawnoftime.armoroftheages.client.models.centurion_armor;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;
import org.dawnoftime.armoroftheages.client.models.ArmorModel;

public class ChestCenturionArmorModel<T extends LivingEntity> extends ArmorModel<T> {

    public ChestCenturionArmorModel(ModelPart root, boolean isSlim) {
        super(root, isSlim);
    }

    @Override
    public <E extends LivingEntity> ArmorModel<E> create(ModelPart root, boolean isSlim) {
        return new ChestCenturionArmorModel<>(root, isSlim);
    }

    public static LayerDefinition createLayerDefinition() {
        MeshDefinition meshdefinition = templateLayerDefinition(1.0F);
        PartDefinition root = meshdefinition.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                        .texOffs(0, 18).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.3F))
                        .texOffs(0, 34).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.55F))
                        .texOffs(0, 50).addBox(2.1768F, 5.8232F, -3.0F, 2.0F, 2.0F, 6.0F, CubeDeformation.NONE),
                PartPose.ZERO);

        body.addOrReplaceChild("chestBelt", CubeListBuilder.create()
                        .texOffs(24, 29).addBox(0.0F, -1.0F, 0.0F, 2.0F, 10.0F, 5.0F, new CubeDeformation(0.2F)),
                PartPose.offsetAndRotation(-4.0F, 1.0F, -2.5F, 0.0F, 0.0F, -0.7854F));

        PartDefinition rightArm = root.addOrReplaceChild("right_arm", CubeListBuilder.create()
                        .texOffs(19, 47).addBox(-3.5F, -2.5F, -2.5F, 5.0F, 12.0F, 5.0F, CubeDeformation.NONE)
                        .texOffs(39, 47).addBox(-3.5F, -2.5F, -2.5F, 5.0F, 12.0F, 5.0F, new CubeDeformation(0.25F)),
                PartPose.offset(-5.0F, 2.0F, 0.0F));

        rightArm.addOrReplaceChild("right_shoulder", CubeListBuilder.create()
                        .texOffs(56, 17).addBox(-3.2726F, -3.4043F, -3.0F, 5.0F, 2.0F, 6.0F, CubeDeformation.NONE)
                        .texOffs(74, 11).addBox(0.0F, -3.5F, -3.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.25F)),
                PartPose.offsetAndRotation(-0.25F, -0.25F, 0.0F, 0.0F, 0.0F, -0.3927F));

        PartDefinition leftArm = root.addOrReplaceChild("left_arm", CubeListBuilder.create().mirror()
                        .texOffs(19, 47).addBox(-1.5F, -2.5F, -2.5F, 5.0F, 12.0F, 5.0F, CubeDeformation.NONE)
                        .texOffs(39, 47).addBox(-1.5F, -2.5F, -2.5F, 5.0F, 12.0F, 5.0F, new CubeDeformation(0.25F)),
                PartPose.offset(5.0F, 2.0F, 0.0F));

        leftArm.addOrReplaceChild("left_shoulder", CubeListBuilder.create()
                        .texOffs(56, 17).addBox(-1.7274F, -3.4043F, -3.0F, 5.0F, 2.0F, 6.0F, CubeDeformation.NONE)
                        .texOffs(74, 11).addBox(-1.0F, -3.5F, -3.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.25F)),
                PartPose.offsetAndRotation(0.25F, -0.25F, 0.0F, 0.0F, 0.0F, 0.3927F));

        return LayerDefinition.create(meshdefinition, 128, 64);
    }

    public static LayerDefinition createSlimLayerDefinition() {
        MeshDefinition meshdefinition = templateLayerDefinition(1.0F);
        PartDefinition root = meshdefinition.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                        .texOffs(0, 18).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.3F))
                        .texOffs(0, 34).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.55F))
                        .texOffs(0, 50).addBox(2.1768F, 5.8232F, -3.0F, 2.0F, 2.0F, 6.0F, CubeDeformation.NONE),
                PartPose.ZERO);

        body.addOrReplaceChild("chestBreast", CubeListBuilder.create()
                        .texOffs(68, 25).addBox(-3.5F, -1.75F, 0.0F, 7.0F, 4.0F, 2.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(0.0F, 2.0F, -3.0F, -0.48F, 0.0F, 0.0F));

        body.addOrReplaceChild("chestBelt", CubeListBuilder.create()
                        .texOffs(74, 12).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 4.0F, 0.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(1.9309F, 5.4684F, -3.542F, 0.4386F, -0.0319F, -0.7317F));

        body.addOrReplaceChild("chestBeltDown", CubeListBuilder.create()
                        .texOffs(70, 12).addBox(0.0F, -1.0F, 0.0F, 2.0F, 7.0F, 0.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(-4.0505F, 0.6704F, -3.0498F, -0.2397F, -0.0564F, -0.7652F));

        body.addOrReplaceChild("chestBeltUp", CubeListBuilder.create()
                        .texOffs(24, 29).addBox(0.0F, -1.0F, 0.0F, 2.0F, 10.0F, 5.0F, new CubeDeformation(0.2F)),
                PartPose.offsetAndRotation(-4.0F, 1.0F, -2.5F, 0.0F, 0.0F, -0.7854F));

        PartDefinition rightArm = root.addOrReplaceChild("right_arm", CubeListBuilder.create()
                        .texOffs(19, 47).addBox(-2.5F, -2.5F, -2.5F, 4.0F, 12.0F, 5.0F, CubeDeformation.NONE)
                        .texOffs(37, 47).addBox(-2.5F, -2.5F, -2.5F, 4.0F, 12.0F, 5.0F, new CubeDeformation(0.25F)),
                PartPose.offset(-5.0F, 2.0F, 0.0F));

        rightArm.addOrReplaceChild("right_shoulder", CubeListBuilder.create()
                        .texOffs(56, 17).addBox(-2.2726F, -3.4043F, -3.0F, 4.0F, 2.0F, 6.0F, CubeDeformation.NONE)
                        .texOffs(74, 11).addBox(0.0F, -3.5F, -3.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.25F)),
                PartPose.offsetAndRotation(-0.25F, -0.25F, 0.0F, 0.0F, 0.0F, -0.3927F));

        PartDefinition leftArm = root.addOrReplaceChild("left_arm", CubeListBuilder.create()
                        .texOffs(19, 47).addBox(-1.5F, -2.5F, -2.5F, 4.0F, 12.0F, 5.0F, CubeDeformation.NONE)
                        .texOffs(37, 47).addBox(-1.5F, -2.5F, -2.5F, 4.0F, 12.0F, 5.0F, new CubeDeformation(0.25F)),
                PartPose.offset(5.0F, 2.0F, 0.0F));

        leftArm.addOrReplaceChild("left_shoulder", CubeListBuilder.create()
                        .texOffs(56, 17).addBox(-1.7274F, -3.4043F, -3.0F, 4.0F, 2.0F, 6.0F, CubeDeformation.NONE)
                        .texOffs(74, 11).addBox(-1.0F, -3.5F, -3.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.25F)),
                PartPose.offsetAndRotation(0.25F, -0.25F, 0.0F, 0.0F, 0.0F, 0.3927F));
        return LayerDefinition.create(meshdefinition, 128, 64);
    }

    @Override
    protected void setupArmorPartAnim(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}
}
