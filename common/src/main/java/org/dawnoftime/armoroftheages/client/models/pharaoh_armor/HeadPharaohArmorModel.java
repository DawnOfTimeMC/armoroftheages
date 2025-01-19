package org.dawnoftime.armoroftheages.client.models.pharaoh_armor;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;
import org.dawnoftime.armoroftheages.client.models.ArmorModel;

public class HeadPharaohArmorModel<T extends LivingEntity> extends ArmorModel<T> {
    private final ModelPart headTail;

    public HeadPharaohArmorModel(ModelPart root, boolean isSlim) {
        super(root, isSlim);
        this.headTail = this.head.getChild("headTail");
    }

    @Override
    public <E extends LivingEntity> ArmorModel<E> create(ModelPart root, boolean isSlim) {
        return new HeadPharaohArmorModel<>(root, isSlim);
    }

    public static LayerDefinition createLayerDefinition() {
        MeshDefinition meshdefinition = templateLayerDefinition(1.0F);
        PartDefinition root = meshdefinition.getRoot();
        PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create()
                .texOffs(20, 19)
                .addBox(-4.5F, -8.5F, -4.5F, 9, 9, 9, new CubeDeformation(0.1F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        head.addOrReplaceChild("headLeftSideBottom", CubeListBuilder.create()
                        .texOffs(0, 57).mirror(true)
                        .addBox(-3.0F, -1.0F, -4.0F, 3, 1, 4, CubeDeformation.NONE),
                PartPose.offsetAndRotation(9.58F, -1.23F, 0.91F, 0.0F, 0.9147271F, -0.2687807F));

        head.addOrReplaceChild("headLeftSideMiddle", CubeListBuilder.create()
                        .texOffs(14, 51).mirror(true)
                        .addBox(-5.0F, 0.0F, 0.19F, 5, 6, 2, new CubeDeformation(0.14F)),
                PartPose.offsetAndRotation(7.82F, -7.11F, 0.86F, 0.0F, 0.0F, -0.2687807F));

        head.addOrReplaceChild("headRightSideTop", CubeListBuilder.create()
                        .texOffs(0, 51)
                        .addBox(-5.15F, 0.13F, 0.19F, 5, 4, 2, new CubeDeformation(0.13F)),
                PartPose.offsetAndRotation(-4.6F, -11.4F, 0.86F, 0.0F, 0.0F, -0.8901179F));

        head.addOrReplaceChild("headRightSideMiddle", CubeListBuilder.create()
                        .texOffs(14, 51)
                        .addBox(0.0F, 0.0F, 0.19F, 5, 6, 2, new CubeDeformation(0.14F)),
                PartPose.offsetAndRotation(-7.82F, -7.11F, 0.86F, 0.0F, 0.0F, 0.2687807F));

        head.addOrReplaceChild("headRightSideBottom", CubeListBuilder.create()
                        .texOffs(0, 57)
                        .addBox(0.0F, -1.0F, -4.0F, 3, 1, 4, CubeDeformation.NONE),
                PartPose.offsetAndRotation(-9.58F, -1.23F, 0.91F, 0.0F, -0.9147271F, 0.2687807F));

        head.addOrReplaceChild("headLeftSideTop", CubeListBuilder.create()
                        .texOffs(0, 51).mirror(true)
                        .addBox(0.15F, 0.13F, 0.19F, 5, 4, 2, new CubeDeformation(0.13F)),
                PartPose.offsetAndRotation(4.6F, -11.4F, 0.86F, 0.0F, 0.0F, 0.8901179F));

        head.addOrReplaceChild("headTop", CubeListBuilder.create()
                        .texOffs(20, 37)
                        .addBox(-4.5F, 0.0F, 0.0F, 9, 4, 8, new CubeDeformation(0.09F)),
                PartPose.offsetAndRotation(0.0F, -8.55F, -4.45F, 0.47141343F, 0.0F, 0.0F));

        head.addOrReplaceChild("headCap", CubeListBuilder.create()
                        .texOffs(18, 49)
                        .addBox(-4.5F, 0.15F, 0.19F, 9, 0, 2, new CubeDeformation(0.131F)),
                PartPose.offset(0.0F, -11.4F, 0.85F));

        head.addOrReplaceChild("headTail", CubeListBuilder.create()
                        .texOffs(28, 51)
                        .addBox(0.0F, 0.0F, 0.0F, 3, 6, 2, new CubeDeformation(-0.2F)),
                PartPose.offset(-1.5F, 0.4F, 2.5F));

        head.addOrReplaceChild("snakeBody", CubeListBuilder.create()
                        .texOffs(60, 0)
                        .addBox(-0.5F, -3.0F, -1.0F, 1, 3, 1, CubeDeformation.NONE),
                PartPose.offsetAndRotation(0.0F, -7.5F, -4.6F, -0.34906584F, 0.0F, 0.0F));

        head.addOrReplaceChild("snakeHead", CubeListBuilder.create()
                        .texOffs(47, 19)
                        .addBox(-1.5F, -1.0F, -2.0F, 3, 3, 3, new CubeDeformation(-0.99F)),
                PartPose.offsetAndRotation(0.0F, -10.65F, -4.5F, 0.27925268F, 0.0F, 0.0F));
        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    protected void setupArmorPartAnim(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.headTail.xRot = sinPI(ageInTicks / 60.0F + 1.0F) * 0.05F - this.head.xRot * 0.8F;
        this.headTail.zRot = (0.3F * sinPI(ageInTicks / 60.0F + 1.0F) + this.rightLeg.xRot) * 0.1F;
    }
}
