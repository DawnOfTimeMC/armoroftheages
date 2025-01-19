package org.dawnoftime.armoroftheages.client.models.iron_plate_armor;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;
import org.dawnoftime.armoroftheages.client.models.ArmorModel;

public class HeadIronPlateArmorModel<T extends LivingEntity> extends ArmorModel<T> {
    private final ModelPart middleFeatherA;
    private final ModelPart middleFeatherB;


    public HeadIronPlateArmorModel(ModelPart root, boolean isSlim) {
        super(root, isSlim);
        this.middleFeatherA = this.head.getChild("middleFeatherA");
        this.middleFeatherB = this.middleFeatherA.getChild("middleFeatherB");
    }

    @Override
    public <E extends LivingEntity> ArmorModel<E> create(ModelPart root, boolean isSlim) {
        return new HeadIronPlateArmorModel<>(root, isSlim);
    }

    public static LayerDefinition createLayerDefinition() {
        MeshDefinition meshdefinition = templateLayerDefinition(1.0F);
        PartDefinition root = meshdefinition.getRoot();
        PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create()
                        .texOffs(62, 11).addBox(-4.5F, -8.2F, -4.5F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.1F)),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition earMiddle = head.addOrReplaceChild("earMiddle", CubeListBuilder.create()
                        .texOffs(57, 49).addBox(-5.5F, -1.0F, -1.0F, 11.0F, 2.0F, 2.0F),
                PartPose.offsetAndRotation(0.0F, -4.0F, 0.4F, -0.3187F, 0.0F, 0.0F));

        earMiddle.addOrReplaceChild("leftEarBottom", CubeListBuilder.create()
                        .texOffs(0, 34).mirror(true).addBox(4.0F, -1.5F, -7.5F, 1.0F, 3.0F, 9.0F),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        earMiddle.addOrReplaceChild("rightEarBottom", CubeListBuilder.create()
                        .texOffs(0, 34).addBox(-5.0F, -1.5F, -7.5F, 1.0F, 3.0F, 9.0F),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        earMiddle.addOrReplaceChild("middleBottom", CubeListBuilder.create()
                        .texOffs(0, 30).addBox(-4.0F, -7.5F, -1.5F, 8.0F, 1.0F, 3.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

        head.addOrReplaceChild("leftHead", CubeListBuilder.create()
                        .texOffs(52, 31).addBox(-2.0F, -9.1F, -4.5F, 4.0F, 1.0F, 9.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2731F));

        head.addOrReplaceChild("rightHead", CubeListBuilder.create()
                        .texOffs(52, 31).mirror(true).addBox(-2.0F, -9.1F, -4.5F, 4.0F, 1.0F, 9.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2731F));

        head.addOrReplaceChild("middleCraneC", CubeListBuilder.create()
                        .texOffs(45, 28).addBox(-1.0F, -10.6F, -2.0F, 2.0F, 2.0F, 4.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.4189F, 0.0F, 0.0F));

        head.addOrReplaceChild("middleHeadA", CubeListBuilder.create()
                        .texOffs(45, 28).addBox(-1.0F, -10.6F, -2.0F, 2.0F, 2.0F, 4.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.4189F, 0.0F, 0.0F));

        head.addOrReplaceChild("middleHeadB", CubeListBuilder.create()
                        .texOffs(44, 19).addBox(-1.0F, -10.5F, -2.5F, 2.0F, 2.0F, 5.0F),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition middleFeatherA = head.addOrReplaceChild("middleFeatherA", CubeListBuilder.create()
                        .texOffs(89, -8).addBox(-2.0F, -4.5F, -1.5F, 4.0F, 9.0F, 9.0F, new CubeDeformation(-2.0F)),
                PartPose.offsetAndRotation(0.0F, -8.0F, 5.0F, -0.1905F, 0.0F, 0.0F));

        middleFeatherA.addOrReplaceChild("middleFeatherB", CubeListBuilder.create()
                        .texOffs(89, 2).addBox(-2.0F, -4.5F, -2.0F, 4.0F, 9.0F, 9.0F, new CubeDeformation(-2.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 4.5F, -0.1188F, 0.0F, 0.0F));

        head.addOrReplaceChild("topHead", CubeListBuilder.create()
                        .texOffs(28, 5).addBox(-5.0F, -8.2F, -5.0F, 10.0F, 3.0F, 10.0F, new CubeDeformation(-0.3F)),
                PartPose.offset(0.0F, 0.0F, 0.0F));
        return LayerDefinition.create(meshdefinition, 128, 64);
    }

    @Override
    protected void setupArmorPartAnim(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        float f = Math.abs(this.rightLeg.xRot);
        this.middleFeatherA.xRot = -0.15F - f * 0.1F + 0.05F * sinPI(ageInTicks / 60.0F + 1.0F);
        this.middleFeatherB.xRot = -0.15F - f * 0.1F + 0.1F * sinPI((ageInTicks - 15)/ 60.0F + 1.0F);
    }
}
