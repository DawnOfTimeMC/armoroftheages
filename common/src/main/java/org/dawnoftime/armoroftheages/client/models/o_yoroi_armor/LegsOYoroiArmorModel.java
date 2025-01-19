package org.dawnoftime.armoroftheages.client.models.o_yoroi_armor;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import org.dawnoftime.armoroftheages.client.models.ArmorModel;

public class LegsOYoroiArmorModel<T extends LivingEntity> extends ArmorModel<T> {

    private final ModelPart thighBack;
    private final ModelPart thighBackSub;
    private final ModelPart thighFront;
    private final ModelPart thighFrontSub;

    public LegsOYoroiArmorModel(ModelPart root, boolean isSlim) {
        super(root, isSlim);
        this.thighBack = this.body.getChild("thighBack");
        this.thighBackSub = this.body.getChild("thighBackSub");
        this.thighFront = this.body.getChild("thighFront");
        this.thighFrontSub = this.body.getChild("thighFrontSub");
    }

    @Override
    public <E extends LivingEntity> ArmorModel<E> create(ModelPart root, boolean isSlim) {
        return new LegsOYoroiArmorModel<>(root, isSlim);
    }

    public static LayerDefinition createLayerDefinition() {
        MeshDefinition meshdefinition = templateLayerDefinition(1.0F);
        PartDefinition root = meshdefinition.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                        .texOffs(0, 22).addBox(-5.0F, 12.0F, -2.0F, 1.0F, 4.0F, 4.0F),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        body.addOrReplaceChild("thighFrontSub", CubeListBuilder.create()
                        .texOffs(4, 21).addBox(-4.0F, 0.0F, 0.0F, 8.0F, 1.0F, 0.0F),
                PartPose.offset(0.0F, 11.0F, -2.5F));

        body.addOrReplaceChild("thighFront", CubeListBuilder.create()
                        .texOffs(0, 16).addBox(-4.0F, 1.0F, -0.5F, 8.0F, 4.0F, 1.0F),
                PartPose.offset(0.0F, 11.0F, -2.5F));

        body.addOrReplaceChild("thighBackSub", CubeListBuilder.create()
                        .texOffs(4, 21).addBox(-4.0F, 0.0F, 0.0F, 8.0F, 1.0F, 0.0F),
                PartPose.offset(0.0F, 11.0F, 2.5F));

        body.addOrReplaceChild("thighBack", CubeListBuilder.create()
                        .texOffs(0, 16).addBox(-4.0F, 1.0F, -0.5F, 8.0F, 4.0F, 1.0F),
                PartPose.offset(0.0F, 11.0F, 2.5F));

        body.addOrReplaceChild("thighRightSub", CubeListBuilder.create()
                        .texOffs(12, 18).addBox(-4.5F, 11.0F, -2.0F, 0.0F, 1.0F, 4.0F),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        body.addOrReplaceChild("thighLeftSub", CubeListBuilder.create()
                        .texOffs(12, 18).mirror(true).addBox(4.5F, 11.0F, -2.0F, 0.0F, 1.0F, 4.0F),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        body.addOrReplaceChild("thighLeft", CubeListBuilder.create()
                        .texOffs(0, 22).mirror(true).addBox(4.0F, 12.0F, -2.0F, 1.0F, 4.0F, 4.0F),
                PartPose.offset(0.0F, 0.0F, 0.0F));
        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    protected void setupArmorPartAnim(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        float f = Math.abs(this.rightLeg.xRot);
        this.thighBack.xRot = f;
        this.thighBackSub.xRot = f;
        this.thighFront.xRot = -f;
        this.thighFrontSub.xRot = -f;

        if (this.riding) {
            this.thighBack.xRot += 1.0F;
            this.thighBackSub.xRot += 1.0F;
            this.thighFront.xRot -= 1.0F;
            this.thighFrontSub.xRot -= 1.0F;
        }

        this.thighFront.y = 11.0F;
        this.thighFrontSub.y = 11.0F;
    }
}
