package org.dawnoftime.armoroftheages.client.models.exalted_aurum;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;
import org.dawnoftime.armoroftheages.client.models.ArmorModel;

public class LegsExaltedAurumArmorModel<T extends LivingEntity> extends ArmorModel<T> {
    private final ModelPart beltFront;
    private final ModelPart beltBack;

    public LegsExaltedAurumArmorModel(ModelPart root, boolean isSlim) {
        super(root, isSlim);
        this.beltFront = this.body.getChild("belt_front");
        this.beltBack = this.body.getChild("belt_back");
    }

    @Override
    public <E extends LivingEntity> ArmorModel<E> create(ModelPart root, boolean isSlim) {
        return new LegsExaltedAurumArmorModel<>(root, isSlim);
    }

    public static LayerDefinition createLayerDefinition() {
        MeshDefinition meshdefinition = templateLayerDefinition(1.0F);
        PartDefinition root = meshdefinition.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(19, 40).addBox(-4.475F, 8.75F, -2.525F, 9.0F, 3.0F, 5.0F, CubeDeformation.NONE), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition beltFront = body.addOrReplaceChild("belt_front", CubeListBuilder.create().texOffs(48, 30).addBox(-2.5F, 3.25F, -0.45F, 5.0F, 10.0F, 1.0F, CubeDeformation.NONE), PartPose.offset(0.0F, 10.75F, -2.75F));
        beltFront.addOrReplaceChild("beltJewelBotFront_r1", CubeListBuilder.create().texOffs(42, 25).addBox(-1.5F, -1.5F, -0.5F, 4.0F, 4.0F, 1.0F, CubeDeformation.NONE), PartPose.offsetAndRotation(0.0F, 2.75F, 0.025F, 0.0F, 0.0F, 0.7854F));
        beltFront.addOrReplaceChild("beltJewelTopFront_r1", CubeListBuilder.create().texOffs(42, 25).addBox(-1.5F, -1.5F, -0.5F, 4.0F, 4.0F, 1.0F, CubeDeformation.NONE), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition beltBack = body.addOrReplaceChild("belt_back", CubeListBuilder.create(), PartPose.offset(0.0F, 9.5F, 2.75F));
        beltBack.addOrReplaceChild("Body_r1", CubeListBuilder.create().texOffs(48, 30).addBox(-2.5F, 0.5F, -0.5F, 5.0F, 10.0F, 1.0F, CubeDeformation.NONE), PartPose.offsetAndRotation(0.0F, 0.5F, -0.025F, 0.0F, 3.1416F, 0.0F));
        beltBack.addOrReplaceChild("beltJewelTopBack_r1", CubeListBuilder.create().texOffs(42, 25).addBox(-1.5F, -1.5F, -0.5F, 4.0F, 4.0F, 1.0F, CubeDeformation.NONE), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 3.1416F, 0.0F, 2.3562F));

        PartDefinition left_leg = root.addOrReplaceChild("left_leg", CubeListBuilder.create(),
                PartPose.offset(1.9F, 12.0F, 0.0F));
        left_leg.addOrReplaceChild("LeftLeg_r1", CubeListBuilder.create().texOffs(47, 41).mirror().addBox(-1.5244F, -0.7751F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.5F)).mirror(false),
                PartPose.offsetAndRotation(1.0244F, 4.7751F, 0.0F, 0.0F, 0.0F, -0.1833F));
        left_leg.addOrReplaceChild("LeftLeg_r2", CubeListBuilder.create().texOffs(60, 30).mirror().addBox(-1.5F, -2.75F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.8F)).mirror(false),
                PartPose.offsetAndRotation(1.5744F, 2.2751F, 0.0F, 0.0F, 0.0F, -0.3578F));

        PartDefinition right_leg = root.addOrReplaceChild("right_leg", CubeListBuilder.create(),
                PartPose.offset(-1.9F, 12.0F, 0.0F));
        right_leg.addOrReplaceChild("RightLeg_r1", CubeListBuilder.create().texOffs(47, 41).addBox(-2.4756F, -0.7751F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.5F)),
                PartPose.offsetAndRotation(-1.0244F, 4.7751F, 0.0F, 0.0F, 0.0F, 0.1833F));
        right_leg.addOrReplaceChild("RightLeg_r2", CubeListBuilder.create().texOffs(60, 30).addBox(-2.5F, -2.75F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.8F)),
                PartPose.offsetAndRotation(-1.5744F, 2.2751F, 0.0F, 0.0F, 0.0F, 0.3578F));

        return LayerDefinition.create(meshdefinition, 128, 64);
    }

    public static LayerDefinition createSlimLayerDefinition() {
        MeshDefinition meshdefinition = templateLayerDefinition(1.0F);
        PartDefinition root = meshdefinition.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(19, 40).addBox(-4.475F, 8.75F, -2.525F, 9.0F, 3.0F, 5.0F, CubeDeformation.NONE), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition beltFront = body.addOrReplaceChild("belt_front", CubeListBuilder.create().texOffs(49, 31).addBox(-2.5F, 3.25F, -0.45F, 5.0F, 10.0F, 0.0F, CubeDeformation.NONE), PartPose.offset(0.0F, 10.75F, -2.75F));
        beltFront.addOrReplaceChild("beltJewelBotFront_r1", CubeListBuilder.create().texOffs(42, 25).addBox(-1.5F, -1.5F, -0.5F, 4.0F, 4.0F, 1.0F, CubeDeformation.NONE), PartPose.offsetAndRotation(0.0F, 2.75F, 0.025F, 0.0F, 0.0F, 0.7854F));
        beltFront.addOrReplaceChild("beltJewelTopFront_r1", CubeListBuilder.create().texOffs(42, 25).addBox(-1.5F, -1.5F, -0.5F, 4.0F, 4.0F, 1.0F, CubeDeformation.NONE), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition beltBack = body.addOrReplaceChild("belt_back", CubeListBuilder.create(), PartPose.offset(0.0F, 9.5F, 2.75F));
        beltBack.addOrReplaceChild("Body_r1", CubeListBuilder.create().texOffs(48, 30).addBox(-2.5F, 0.5F, -0.5F, 5.0F, 10.0F, 1.0F, CubeDeformation.NONE), PartPose.offsetAndRotation(0.0F, 0.5F, -0.025F, 0.0F, 3.1416F, 0.0F));
        beltBack.addOrReplaceChild("beltJewelTopBack_r1", CubeListBuilder.create().texOffs(42, 25).addBox(-1.5F, -1.5F, -0.5F, 4.0F, 4.0F, 1.0F, CubeDeformation.NONE), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 3.1416F, 0.0F, 2.3562F));

        PartDefinition left_leg = root.addOrReplaceChild("left_leg", CubeListBuilder.create(),
                PartPose.offset(-1.9F, 12.0F, 0.0F));
        left_leg.addOrReplaceChild("LeftLeg_r1", CubeListBuilder.create().texOffs(47, 41).mirror().addBox(-1.5244F, -0.7751F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.5F)).mirror(false),
                PartPose.offsetAndRotation(0.9244F, 4.7751F, 0.0F, 0.0F, 0.0F, -0.4451F));
        left_leg.addOrReplaceChild("LeftLeg_r2", CubeListBuilder.create().texOffs(60, 30).mirror().addBox(-1.5F, -2.75F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.8F)).mirror(false),
                PartPose.offsetAndRotation(1.4744F, 2.2751F, 0.0F, 0.0F, 0.0F, -0.6196F));

        PartDefinition right_leg = root.addOrReplaceChild("right_leg", CubeListBuilder.create(),
                PartPose.offset(1.9F, 12.0F, 0.0F));
        right_leg.addOrReplaceChild("RightLeg_r1", CubeListBuilder.create().texOffs(47, 41).addBox(-2.4756F, -0.7751F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.5F)),
                PartPose.offsetAndRotation(-0.9244F, 4.7751F, 0.0F, 0.0F, 0.0F, 0.4451F));
        right_leg.addOrReplaceChild("RightLeg_r2", CubeListBuilder.create().texOffs(60, 30).addBox(-2.5F, -2.75F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.8F)),
                PartPose.offsetAndRotation(-1.4744F, 2.2751F, 0.0F, 0.0F, 0.0F, 0.6196F));
        return LayerDefinition.create(meshdefinition, 128, 64);
    }

    @Override
    protected void setupArmorPartAnim(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        float f = Math.abs(this.rightLeg.xRot);
        this.beltBack.xRot = f;
        this.beltFront.xRot = -f;

        if (this.riding) {
            this.beltBack.xRot += 1.0F;
            this.beltFront.xRot -= 1.0F;
        }
    }
}
