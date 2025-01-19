package org.dawnoftime.armoroftheages.client.models;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.decoration.ArmorStand;
import org.dawnoftime.armoroftheages.client.ArmorModelSupplier;
import org.jetbrains.annotations.NotNull;

public abstract class ArmorModel<T extends LivingEntity> extends HumanoidModel<T> implements ArmorModelSupplier {
    public final boolean isSlim;

    public ArmorModel(ModelPart root, boolean isSlim) {
        super(root);
        this.isSlim = isSlim;
    }

    /**
     * Override this function to animate the model, instead of overriding {@link ArmorModel#setupAnim}.
     */
    protected abstract void setupArmorPartAnim(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch);

    /**
     * This function must be called before adding the parts in the other models !!!
     *
     * @return A minimal mesh with all the part of the player model and their appropriate rotation positions.
     */
    public static MeshDefinition templateLayerDefinition(float scale) {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        root.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F + scale, 0.0F));
        root.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F + scale, 0.0F));
        root.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F + scale, 0.0F));
        root.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offset(-5.0F, 2.0F + scale, 0.0F));
        root.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offset(5.0F, 2.0F + scale, 0.0F));
        root.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.offset(-1.9F, 12.0F + scale, 0.0F));
        root.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.offset(1.9F, 12.0F + scale, 0.0F));
        return mesh;
    }

    @Override
    public void setupAnim(@NotNull LivingEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        // Fix the "breathing" and wrong head rotation on ArmorStands
        if (entity instanceof ArmorStand entityAS) {
            float f = (float) Math.PI / 180F;
            this.head.xRot = f * entityAS.getHeadPose().getX();
            this.head.yRot = f * entityAS.getHeadPose().getY();
            this.head.zRot = f * entityAS.getHeadPose().getZ();
            this.body.xRot = f * entityAS.getBodyPose().getX();
            this.body.yRot = f * entityAS.getBodyPose().getY();
            this.body.zRot = f * entityAS.getBodyPose().getZ();
            this.leftArm.xRot = f * entityAS.getLeftArmPose().getX();
            this.leftArm.yRot = f * entityAS.getLeftArmPose().getY();
            this.leftArm.zRot = f * entityAS.getLeftArmPose().getZ();
            this.rightArm.xRot = f * entityAS.getRightArmPose().getX();
            this.rightArm.yRot = f * entityAS.getRightArmPose().getY();
            this.rightArm.zRot = f * entityAS.getRightArmPose().getZ();
            this.leftLeg.xRot = f * entityAS.getLeftLegPose().getX();
            this.leftLeg.yRot = f * entityAS.getLeftLegPose().getY();
            this.leftLeg.zRot = f * entityAS.getLeftLegPose().getZ();
            this.rightLeg.xRot = f * entityAS.getRightLegPose().getX();
            this.rightLeg.yRot = f * entityAS.getRightLegPose().getY();
            this.rightLeg.zRot = f * entityAS.getRightLegPose().getZ();
        } else {
            this.setupArmorPartAnim(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        }
    }

    public static float sinPI(float f) { return Mth.sin(f * (float) Math.PI); }

    public static float cosPI(float f) { return Mth.cos(f * (float) Math.PI); }

    public <M extends HumanoidModel<? extends LivingEntity>> void copyEntityModelPosition(M parentModel) {
        this.leftArmPose = parentModel.leftArmPose;
        this.rightArmPose = parentModel.rightArmPose;
        this.crouching = parentModel.crouching;
        this.head.copyFrom(parentModel.head);
        this.hat.copyFrom(parentModel.hat);
        this.body.copyFrom(parentModel.body);
        this.rightArm.copyFrom(parentModel.rightArm);
        this.leftArm.copyFrom(parentModel.leftArm);
        this.rightLeg.copyFrom(parentModel.rightLeg);
        this.leftLeg.copyFrom(parentModel.leftLeg);
    }
}