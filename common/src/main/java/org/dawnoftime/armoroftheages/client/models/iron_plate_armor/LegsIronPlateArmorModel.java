package org.dawnoftime.armoroftheages.client.models.iron_plate_armor;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;
import org.dawnoftime.armoroftheages.client.models.ArmorModel;

public class LegsIronPlateArmorModel<T extends LivingEntity> extends ArmorModel<T> {
    private final ModelPart miscB;
    private final ModelPart beltA;
    private final ModelPart beltB;

    public LegsIronPlateArmorModel(ModelPart root, boolean isSlim) {
        super(root, isSlim);
        this.miscB = this.body.getChild("miscB");
        this.beltA = this.body.getChild("beltA");
        this.beltB = this.body.getChild("beltB");
    }

    @Override
    public <E extends LivingEntity> ArmorModel<E> create(ModelPart root, boolean isSlim) {
        return new LegsIronPlateArmorModel<>(root, isSlim);
    }

    public static LayerDefinition createLayerDefinition() {
        MeshDefinition meshdefinition = templateLayerDefinition(1.0F);
        PartDefinition root = meshdefinition.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create(),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        body.addOrReplaceChild("beltA", CubeListBuilder.create()
                        .texOffs(84, 57).addBox(-4.51F, 10.0F, -2.4F, 9.0F, 2.0F, 5.0F, new CubeDeformation(0.3F)),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        body.addOrReplaceChild("beltB", CubeListBuilder.create()
                        .texOffs(60, 54).addBox(-3.0F, 8.9F, -3.7F, 6.0F, 4.0F, 6.0F, new CubeDeformation(-0.8F)),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        body.addOrReplaceChild("miscB", CubeListBuilder.create()
                        .texOffs(50, 44).addBox(-1.5F, -0.1F, 0.2F, 3.0F, 8.0F, 0.0F),
                PartPose.offsetAndRotation(0.0F, 12.1F, -3.0F, -0.0456F, 0.0F, 0.0F));

        PartDefinition armorLeftLeg = root.addOrReplaceChild("left_leg", CubeListBuilder.create(),
                PartPose.offset(1.9F, 12.0F, 0.0F));

        armorLeftLeg.addOrReplaceChild("leftLegging", CubeListBuilder.create()
                        .texOffs(32, 36).addBox(-0.3F, -0.2F, -3.0F, 3.0F, 6.0F, 6.0F, new CubeDeformation(0.1F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1367F));

        PartDefinition armorRightLeg = root.addOrReplaceChild("right_leg", CubeListBuilder.create(),
                PartPose.offset(-1.9F, 12.0F, 0.0F));

        armorRightLeg.addOrReplaceChild("rightLegging", CubeListBuilder.create()
                        .texOffs(32, 36).mirror(true).addBox(-2.7F, -0.2F, -3.0F, 3.0F, 6.0F, 6.0F, new CubeDeformation(0.1F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1367F));
        return LayerDefinition.create(meshdefinition, 128, 64);
    }

    @Override
    protected void setupArmorPartAnim(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        float f = Math.abs(this.rightLeg.xRot);
        this.miscB.xRot = -(f + 0.05F * sinPI(ageInTicks / 60.0F + 1.0F));

        if (this.riding) this.miscB.xRot -= 1.0F;

        this.beltA.y = 0.0F;
        this.beltB.y = 0.0F;
        this.miscB.y = 12.1F;
    }
}
