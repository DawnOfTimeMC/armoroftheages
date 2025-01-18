package org.dawnoftime.armoroftheages.client.models.quetzalcoatl_armor;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;
import org.dawnoftime.armoroftheages.client.models.ArmorModel;

public class FeetQuetzalcoatlArmorModel<T extends LivingEntity> extends ArmorModel<T> {
    private final ModelPart legFeatherRight;
    private final ModelPart legFeatherLeft;

    public FeetQuetzalcoatlArmorModel(ModelPart root, boolean isSlim) {
        super(root, isSlim);
        this.legFeatherRight = this.rightLeg.getChild("legFeatherRight");
        this.legFeatherLeft = this.leftLeg.getChild("legFeatherLeft");
    }

    @Override
    public <E extends LivingEntity> ArmorModel<E> create(ModelPart root, boolean isSlim) {
        return new FeetQuetzalcoatlArmorModel<>(root, isSlim);
    }

    public static LayerDefinition createLayerDefinition() {
        MeshDefinition meshdefinition = templateLayerDefinition(1.0F);
        PartDefinition root = meshdefinition.getRoot();

        PartDefinition rightLeg = root.addOrReplaceChild("right_leg", CubeListBuilder.create()
                        .texOffs(0, 37)
                        .addBox(-2.5F, 1.5F, -2.5F, 5.0F, 11.0F, 5.0F, new CubeDeformation(-0.15F)),
                PartPose.offset(-1.9F, 12.0F, 0.0F));

        rightLeg.addOrReplaceChild("legFeatherRight", CubeListBuilder.create()
                        .texOffs(50, 23)
                        .addBox(-0.3F, -2.0F, -1.0F, 0.0F, 4.0F, 4.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(-2.1F, 2.25F, 0.0F, -0.7931F, -0.1231F, 0.124F));

        rightLeg.addOrReplaceChild("legJewelRight", CubeListBuilder.create()
                        .texOffs(45, 19)
                        .addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(-2.1F, 2.25F, 0.0F, -0.7854F, 0.0F, 0.0F));

        rightLeg.addOrReplaceChild("legProtectionRight", CubeListBuilder.create()
                        .texOffs(88, 29)
                        .addBox(-1.5F, -2.5F, -1.5F, 3.0F, 5.0F, 2.0F, new CubeDeformation(-0.15F)),
                PartPose.offsetAndRotation(-1.25F, 8.0F, -1.25F, 0.0F, 0.0F, -0.0873F));

        PartDefinition leftLeg = root.addOrReplaceChild("left_leg", CubeListBuilder.create()
                        .texOffs(0, 37).mirror(true)
                        .addBox(-2.5F, 1.5F, -2.5F, 5.0F, 11.0F, 5.0F, new CubeDeformation(-0.15F)),
                PartPose.offset(1.9F, 12.0F, 0.0F));

        leftLeg.addOrReplaceChild("legFeatherLeft", CubeListBuilder.create()
                        .texOffs(50, 23).mirror(true)
                        .addBox(0.3F, -2.0F, -1.0F, 0.0F, 4.0F, 4.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(2.1F, 2.25F, 0.0F, -0.7931F, 0.1231F, -0.124F));

        leftLeg.addOrReplaceChild("legProtectionLeft", CubeListBuilder.create()
                        .texOffs(88, 29).mirror(true)
                        .addBox(-1.5F, -2.5F, -1.5F, 3.0F, 5.0F, 2.0F, new CubeDeformation(-0.15F)),
                PartPose.offsetAndRotation(1.25F, 8.0F, -1.25F, 0.0F, 0.0F, 0.0873F));

        leftLeg.addOrReplaceChild("legJewelLeft", CubeListBuilder.create()
                        .texOffs(45, 19).mirror(true)
                        .addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(2.1F, 2.25F, 0.0F, -0.7854F, 0.0F, 0.0F));
        return LayerDefinition.create(meshdefinition, 128, 64);
    }

    @Override
    protected void setupArmorPartAnim(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        float rf = -0.7931F + 0.2F * sinPI((ageInTicks + 10) / 40.0F);
        this.legFeatherRight.xRot = rf;
        this.legFeatherLeft.xRot = rf;
    }
}
