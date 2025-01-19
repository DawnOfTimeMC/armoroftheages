package org.dawnoftime.armoroftheages.client.models.quetzalcoatl_armor;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;
import org.dawnoftime.armoroftheages.client.models.ArmorModel;

public class HeadQuetzalcoatlArmorModel<T extends LivingEntity> extends ArmorModel<T> {
    private final ModelPart featherCrownLeft;
    private final ModelPart featherCrownRight;
    private final ModelPart featherCrownMiddle;

    public HeadQuetzalcoatlArmorModel(ModelPart root, boolean isSlim) {
        super(root, isSlim);
        this.featherCrownLeft = this.head.getChild("featherCrownLeft");
        this.featherCrownRight = this.head.getChild("featherCrownRight");
        this.featherCrownMiddle = this.head.getChild("featherCrownMiddle");
    }

    @Override
    public <E extends LivingEntity> ArmorModel<E> create(ModelPart root, boolean isSlim) {
        return new HeadQuetzalcoatlArmorModel<>(root, isSlim);
    }

    public static LayerDefinition createLayerDefinition() {
        MeshDefinition meshdefinition = templateLayerDefinition(1.0F);
        PartDefinition root = meshdefinition.getRoot();

        PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create()
                        .texOffs(28, 0)
                        .addBox(-2.0F, -15.0F, -1.0F, 4.0F, 5.0F, 2.0F, CubeDeformation.NONE)
                        .texOffs(52, 0)
                        .addBox(-5.0F, -10.0F, -1.0F, 10.0F, 3.0F, 2.0F, CubeDeformation.NONE)
                        .texOffs(19, 4)
                        .addBox(-6.25F, -7.5F, 0.0F, 3.0F, 3.0F, 0.0F, CubeDeformation.NONE)
                        .texOffs(19, 4).mirror()
                        .addBox(3.25F, -7.5F, 0.0F, 3.0F, 3.0F, 0.0F, CubeDeformation.NONE),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        head.addOrReplaceChild("featherCrownLeft", CubeListBuilder.create()
                        .texOffs(40, 7).mirror()
                        .addBox(-1.5F, -9.0F, 0.0F, 6.0F, 6.0F, 0.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(0.0F, -10.0F, 0.0F, -0.4363F, 0.0F, 1.3963F));

        head.addOrReplaceChild("featherCrownRight", CubeListBuilder.create()
                        .texOffs(40, 7)
                        .addBox(-4.5F, -9.0F, 0.0F, 6.0F, 6.0F, 0.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(0.0F, -10.0F, 0.0F, -0.4363F, 0.0F, -1.3963F));

        head.addOrReplaceChild("featherCrownMiddle", CubeListBuilder.create()
                        .texOffs(0, 8)
                        .addBox(-6.5F, -13.0F, 0.0F, 13.0F, 12.0F, 0.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(0.0F, -10.0F, 0.0F, -0.4363F, 0.0F, 0.0F));

        head.addOrReplaceChild("smallEarringLeft", CubeListBuilder.create()
                        .texOffs(18, 3).mirror()
                        .addBox(-1.5F, -2.0F, -0.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(-0.5F)),
                PartPose.offsetAndRotation(4.75F, -3.5F, 0.0F, 0.0F, 1.5708F, 0.0F));

        head.addOrReplaceChild("smallEarringRight", CubeListBuilder.create()
                        .texOffs(18, 3)
                        .addBox(-1.5F, -2.0F, -0.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(-0.5F)),
                PartPose.offsetAndRotation(-4.75F, -3.5F, 0.0F, 0.0F, -1.5708F, 0.0F));

        head.addOrReplaceChild("crownLeft", CubeListBuilder.create()
                        .texOffs(40, 0).mirror()
                        .addBox(-8.0F, -12.0F, -0.75F, 4.0F, 5.0F, 2.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

        head.addOrReplaceChild("crownRight", CubeListBuilder.create()
                        .texOffs(40, 0)
                        .addBox(4.0F, -12.0F, -0.75F, 4.0F, 5.0F, 2.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

        head.addOrReplaceChild("skull", CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-3.5F, -6.0F, -3.0F, 7.0F, 6.0F, 2.0F, CubeDeformation.NONE)
                        .texOffs(18, 0)
                        .addBox(-1.5F, 0.0F, -3.0F, 3.0F, 1.0F, 2.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(0.0F, -6.0F, -3.0F, -0.8727F, 0.0F, 0.0F));
        return LayerDefinition.create(meshdefinition, 128, 64);
    }

    @Override
    protected void setupArmorPartAnim(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        float rh = -0.4363F + 0.1F * sinPI(ageInTicks / 40.0F);
        this.featherCrownLeft.xRot = rh;
        this.featherCrownRight.xRot = rh;
        this.featherCrownMiddle.xRot = rh;
    }
}
