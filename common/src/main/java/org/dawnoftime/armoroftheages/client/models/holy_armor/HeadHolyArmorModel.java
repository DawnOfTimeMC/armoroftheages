package org.dawnoftime.armoroftheages.client.models.holy_armor;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;
import org.dawnoftime.armoroftheages.client.models.ArmorModel;

public class HeadHolyArmorModel<T extends LivingEntity> extends ArmorModel<T> {
    private final ModelPart headWingLeft;
    private final ModelPart headWingRight;

    public HeadHolyArmorModel(ModelPart root, boolean isSlim) {
        super(root, isSlim);
        this.headWingLeft = this.head.getChild("headWingLeft");
        this.headWingRight = this.head.getChild("headWingRight");
    }

    @Override
    public <E extends LivingEntity> ArmorModel<E> create(ModelPart root, boolean isSlim) {
        return new HeadHolyArmorModel<>(root, isSlim);
    }

    public static LayerDefinition createLayerDefinition() {
        MeshDefinition meshdefinition = templateLayerDefinition(1.0F);
        PartDefinition root = meshdefinition.getRoot();

        PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create()
                        .texOffs(0, 0).addBox(-4.5F, -9.0F, -4.5F, 9, 10, 9, new CubeDeformation(0.1F))
                        .texOffs(0, 0).addBox(-6.0F, -6.0F, -1.0F, 2, 2, 2, CubeDeformation.NONE)
                        .texOffs(0, 0).addBox(4.0F, -6.0F, -1.0F, 2, 2, 2, CubeDeformation.NONE)
                        .texOffs(36, 0).addBox(-1.0F, -9.5F, -3.0F, 2, 7, 8, CubeDeformation.NONE),
                PartPose.ZERO);

        head.addOrReplaceChild("headWingLeft", CubeListBuilder.create()
                        .texOffs(36, 7).addBox(0.0F, -2.5F, -2.0F, 0, 5, 8, CubeDeformation.NONE),
                PartPose.offsetAndRotation(5.5F, -5.5F, 0.0F, 0.3491F, 0.4363F, 0.0F));

        head.addOrReplaceChild("headWingRight", CubeListBuilder.create()
                        .texOffs(36, 7).addBox(0.0F, -2.5F, -2.0F, 0, 5, 8, CubeDeformation.NONE),
                PartPose.offsetAndRotation(-5.5F, -5.5F, 0.0F, 0.3491F, -0.4363F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    protected void setupArmorPartAnim(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.headWingLeft.xRot = 0.3491F + 0.15F * sinPI(ageInTicks / 40.0F);
        this.headWingRight.xRot = 0.3491F + 0.15F * sinPI(ageInTicks / 40.0F);
    }
}
