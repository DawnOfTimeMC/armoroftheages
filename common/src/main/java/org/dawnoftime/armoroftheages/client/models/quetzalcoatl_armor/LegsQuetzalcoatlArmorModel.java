package org.dawnoftime.armoroftheages.client.models.quetzalcoatl_armor;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import org.dawnoftime.armoroftheages.client.models.ArmorModel;

public class LegsQuetzalcoatlArmorModel<T extends LivingEntity> extends ArmorModel<T> {
    private final ModelPart underwearFront;
    private final ModelPart underwearBack;

    public LegsQuetzalcoatlArmorModel(ModelPart root, boolean isSlim) {
        super(root, isSlim);
        this.underwearFront = this.body.getChild("underwearFront");
        this.underwearBack = this.body.getChild("underwearBack");
    }

    @Override
    public <E extends LivingEntity> ArmorModel<E> create(ModelPart root, boolean isSlim) {
        return new LegsQuetzalcoatlArmorModel<>(root, isSlim);
    }

    public static LayerDefinition createLayerDefinition() {
        MeshDefinition meshdefinition = templateLayerDefinition(1.0F);
        PartDefinition root = meshdefinition.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                        .texOffs(45, 31)
                        .addBox(-4.5F, 9.5F, -2.5F, 9.0F, 2.0F, 5.0F, new CubeDeformation(-0.1F))
                        .texOffs(61, 24)
                        .addBox(-4.5F, 10.0F, -2.5F, 9.0F, 1.0F, 5.0F, CubeDeformation.NONE)
                        .texOffs(26, 36)
                        .addBox(-2.0F, 9.0F, -2.46F, 4.0F, 2.0F, 1.0F, CubeDeformation.NONE),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        body.addOrReplaceChild("stomachProtectionTop", CubeListBuilder.create()
                        .texOffs(36, 36)
                        .addBox(-2.0F, 6.0F, -2.45F, 3.0F, 3.0F, 1.0F, new CubeDeformation(-0.087F)),
                PartPose.offsetAndRotation(5.6586F, 4.0503F, -0.087F, 0.0F, 0.0F, 0.7854F));

        body.addOrReplaceChild("stomachProtectionLeft", CubeListBuilder.create()
                        .texOffs(98, 28).mirror(true)
                        .addBox(-2.35F, -2.0F, -0.04F, 2.0F, 2.0F, 5.0F, new CubeDeformation(-0.05F)),
                PartPose.offsetAndRotation(4.45F, 11.0F, -2.46F, 0.0F, 0.0F, 0.3927F));

        body.addOrReplaceChild("stomachProtectionRight", CubeListBuilder.create()
                        .texOffs(98, 28)
                        .addBox(0.35F, -2.0F, -0.04F, 2.0F, 2.0F, 5.0F, new CubeDeformation(-0.05F)),
                PartPose.offsetAndRotation(-4.45F, 11.0F, -2.46F, 0.0F, 0.0F, -0.3927F));

        body.addOrReplaceChild("stomachJewel", CubeListBuilder.create()
                        .texOffs(30, 27)
                        .addBox(-1.0F, -1.0F, -0.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(-0.2F)),
                PartPose.offsetAndRotation(0.0F, 11.0F, -2.25F, 0.0F, 0.0F, -0.7854F));

        PartDefinition underwearFront = body.addOrReplaceChild("underwearFront", CubeListBuilder.create()
                        .texOffs(78, 30)
                        .addBox(-2.5F, 0.15F, -0.15F, 5.0F, 7.0F, 0.0F, CubeDeformation.NONE),
                PartPose.offset(0.0F, 11.25F, -2.25F));

        underwearFront.addOrReplaceChild("underwearFeather", CubeListBuilder.create()
                        .texOffs(40, 13)
                        .addBox(5.25F, -11.25F, -2.6F, 6.0F, 6.0F, 0.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(0.0F, 12.75F, 2.25F, 0.0F, 0.0F, -0.7854F));

        body.addOrReplaceChild("underwearBack", CubeListBuilder.create()
                        .texOffs(68, 30)
                        .addBox(-2.5F, 0.1F, 0.1F, 5.0F, 5.0F, 0.0F, CubeDeformation.NONE),
                PartPose.offset(0.0F, 11.3F, 2.3F));

        return LayerDefinition.create(meshdefinition, 128, 64);
    }

    @Override
    protected void setupArmorPartAnim(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        float f = Math.abs(0.05F + 1.02F * this.rightLeg.xRot) + 0.05F * (1 + sinPI(ageInTicks / 40.0F));
        this.underwearFront.xRot = -f;
        this.underwearBack.xRot = f;
    }
}
