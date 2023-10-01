package com.dotteam.armorweapons.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.decoration.ArmorStand;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public abstract class HumanoidArmorPartModel<T extends LivingEntity> extends HumanoidModel<T> {

	public HumanoidArmorPartModel(ModelPart root){
		super(root);
	}

	protected abstract void setupArmorPartAnim(T entityIn, float ageInTicks);

	protected abstract Set<ModelPart> getRenderedParts();

	@Override
	public void setupAnim(@NotNull T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		//Fix the "breathing" and wrong head rotation on ArmorStands
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
		}else{
			this.setupArmorPartAnim(entity, ageInTicks);
		}
	}

	@Override
	public void renderToBuffer(@NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		super.renderToBuffer(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		this.bodyParts().forEach(modelPart -> modelPart.visible = this.getRenderedParts().contains(modelPart));
	}

	public static float sinPI(float f) {
		return Mth.sin(f * (float)Math.PI);
	}

	public static float cosPI(float f) {
		return Mth.cos(f * (float)Math.PI);
	}
}
