package org.dawnoftime.armoroftheages.client.models.holy_armor;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;
import org.dawnoftime.armoroftheages.client.models.ArmorModel;

public class FeetHolyArmorModel<T extends LivingEntity> extends ArmorModel<T> {
    private final ModelPart legLeftWing;
    private final ModelPart legRightWing;

    public FeetHolyArmorModel(ModelPart root, boolean isSlim) {
        super(root, isSlim);
        this.legLeftWing = this.leftLeg.getChild("leg_left_wing");
        this.legRightWing = this.rightLeg.getChild("leg_right_wing");
    }

    @Override
    public <E extends LivingEntity> ArmorModel<E> create(ModelPart root, boolean isSlim) {
        return new FeetHolyArmorModel<>(root, isSlim);
    }

    public static LayerDefinition createLayerDefinition() {
        MeshDefinition meshdefinition = templateLayerDefinition(1.0F);
        PartDefinition root = meshdefinition.getRoot();

        PartDefinition leg_left = root.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(66, 31).addBox(-2.5F, -0.7F, -2.5F, 5.0F, 13.0F, 5.0F, new CubeDeformation(-0.2F))
                .texOffs(48, 57).addBox(-2.5F, 10.3F, -2.5F, 5.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(25, 43).addBox(-2.5F, 5.3F, -2.6F, 5.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 6).addBox(2.0F, 5.8F, -1.1F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.9F, 12.0F, 0.0F));

        leg_left.addOrReplaceChild("leg_left_wing", CubeListBuilder.create().texOffs(0, 55).addBox(0.0F, -2.3F, 0.0F, 0.0F, 3.0F, 5.0F, CubeDeformation.NONE), PartPose.offsetAndRotation(2.501F, 6.3F, -1.6F, -0.3491F, 0.3054F, 0.0F));

        PartDefinition leg_right = root.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(66, 31).mirror().addBox(-2.5F, -0.7F, -2.5F, 5.0F, 13.0F, 5.0F, new CubeDeformation(-0.2F)).mirror(false)
                .texOffs(48, 57).mirror().addBox(-2.5F, 10.3F, -2.5F, 5.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(25, 43).mirror().addBox(-2.5F, 5.3F, -2.6F, 5.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 6).addBox(-3.0F, 5.8F, -1.1F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.9F, 12.0F, 0.0F));

        leg_right.addOrReplaceChild("leg_right_wing", CubeListBuilder.create().texOffs(0, 55).mirror().addBox(0.0F, -2.3F, 0.0F, 0.0F, 3.0F, 5.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(-2.501F, 6.3F, -1.6F, -0.1745F, -0.3054F, 0.0F));
        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    protected void setupArmorPartAnim(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.legLeftWing.xRot = -0.1745F + 0.1F * sinPI(ageInTicks / 40.0F);
        this.legRightWing.xRot = -0.1745F + 0.1F * sinPI(ageInTicks / 40.0F);
    }
}
