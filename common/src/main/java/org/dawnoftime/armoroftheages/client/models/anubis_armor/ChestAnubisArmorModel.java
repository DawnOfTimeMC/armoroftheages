package org.dawnoftime.armoroftheages.client.models.anubis_armor;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;
import org.dawnoftime.armoroftheages.client.models.ArmorModel;

public class ChestAnubisArmorModel<T extends LivingEntity> extends ArmorModel<T> {
    private final ModelPart collarBack;
    private final ModelPart crossA;
    private final ModelPart crossB;
    private final ModelPart crossC;
    private final ModelPart crossD;

    public ChestAnubisArmorModel(ModelPart root, boolean isSlim) {
        super(root, isSlim);
        this.collarBack = this.body.getChild("collar_back");
        this.crossA = this.body.getChild("cross_a");
        this.crossB = this.body.getChild("cross_b");
        this.crossC = this.body.getChild("cross_c");
        this.crossD = this.body.getChild("cross_d");
    }

    @Override
    public <E extends LivingEntity> ArmorModel<E> create(ModelPart root, boolean isSlim) {
        return new ChestAnubisArmorModel<>(root, isSlim);
    }

    public static LayerDefinition createLayerDefinition() {
        MeshDefinition meshdefinition = templateLayerDefinition(1.0F);
        PartDefinition root = meshdefinition.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(70, 0).addBox(-4.5F, -0.5F, -2.5F, 9.0F, 13.0F, 5.0F, new CubeDeformation(-0.22F))
                .texOffs(-6, 52).addBox(-4.5F, -0.45F, -2.5F, 9.0F, 0.0F, 6.0F), PartPose.ZERO);
        body.addOrReplaceChild("abs", CubeListBuilder.create()
                .texOffs(38, 21).addBox(-3.5F, -1.0F, 0.3F, 7.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.7F, -3.3F, 0.0873F, 0.0F, 0.0F));
        body.addOrReplaceChild("chest_back", CubeListBuilder.create()
                .texOffs(20, 31).addBox(-3.5F, -6.5F, -1.7F, 7.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.2F, 2.5F, -0.0873F, 0.0F, 0.0F));

        body.addOrReplaceChild("collar_front", CubeListBuilder.create()
                .texOffs(-5, 58).addBox(-4.5F, 0.0F, -5.0F, 9.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.45F, -2.5F, 1.309F, 0.0F, 0.0F));
        body.addOrReplaceChild("collar_back", CubeListBuilder.create()
                .texOffs(-8, 44).addBox(-4.5F, 0.0F, 0.0F, 9.0F, 0.0F, 8.0F), PartPose.offsetAndRotation(0.0F, -0.45F, 3.5F, -1.5708F, 0.0F, 0.0F));
        body.addOrReplaceChild("chest_core", CubeListBuilder.create()
                .texOffs(61, 0).addBox(-1.0F, -3.5F, 0.05F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.5F, -3.6F, -0.192F, 0.0F, 0.0F));
        body.addOrReplaceChild("chest_pec_right", CubeListBuilder.create()
                .texOffs(108, 10).addBox(-4.0F, -4.0F, -2.9F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 4.0F, -0.5F, -0.2007F, 0.0F, -0.2618F));
        body.addOrReplaceChild("chest_pec_left", CubeListBuilder.create()
                .texOffs(108, 10).addBox(0.0F, -4.0F, -2.9F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 4.0F, -0.5F, -0.2007F, 0.0F, 0.2618F));

        body.addOrReplaceChild("cross_a", CubeListBuilder.create()
                .texOffs(18, 45).addBox(-2.5F, -44.0F, 2.0F, 5.0F, 6.0F, 0.0F), PartPose.offset(0.0F, 20.0F, 4.0F));
        body.addOrReplaceChild("cross_b", CubeListBuilder.create()
                .texOffs(18, 45).addBox(-2.5F, -44.0F, 2.0F, 5.0F, 6.0F, 0.0F), PartPose.offset(0.0F, 20.0F, 4.0F));
        body.addOrReplaceChild("cross_c", CubeListBuilder.create()
                .texOffs(18, 45).addBox(-2.5F, -44.0F, 2.0F, 5.0F, 6.0F, 0.0F), PartPose.offset(0.0F, 20.0F, 4.0F));
        body.addOrReplaceChild("cross_d", CubeListBuilder.create()
                .texOffs(18, 45).addBox(-2.5F, -44.0F, 2.0F, 5.0F, 6.0F, 0.0F), PartPose.offset(0.0F, 20.0F, 4.0F));

        PartDefinition rightArm = root.addOrReplaceChild("right_arm", CubeListBuilder.create()
                .texOffs(112, 48).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F))
                .texOffs(0, 26).addBox(-3.5F, -2.5F, -2.5F, 5.0F, 13.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.offset(-5.0F, 2.0F, 0.0F));
        rightArm.addOrReplaceChild("shoulderRight", CubeListBuilder.create()
                .texOffs(112, 0).addBox(-1.75F, -2.0F, -2.5F, 3.0F, 5.0F, 5.0F, new CubeDeformation(0.05F))
                .texOffs(25, 0).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 1.0F)
                .texOffs(18, 16).addBox(-3.0F, -6.0F, -3.0F, 4.0F, 9.0F, 6.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-2.25F, -0.75F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition leftArm = root.addOrReplaceChild("left_arm", CubeListBuilder.create().mirror()
                .texOffs(112, 48).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F))
                .texOffs(0, 26).addBox(-1.5F, -2.5F, -2.5F, 5.0F, 13.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.offset(5.0F, 2.0F, 0.0F));
        leftArm.addOrReplaceChild("shoulderLeft", CubeListBuilder.create().mirror()
                .texOffs(112, 0).addBox(-1.25F, -2.0F, -2.5F, 3.0F, 5.0F, 5.0F, new CubeDeformation(0.05F))
                .texOffs(25, 0).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 1.0F)
                .texOffs(18, 16).addBox(-1.0F, -6.0F, -3.0F, 4.0F, 9.0F, 6.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(2.25F, -0.75F, 0.0F, 0.0F, 0.0F, 0.1745F));

        return LayerDefinition.create(meshdefinition, 128, 64);
    }

    public static LayerDefinition createSlimLayerDefinition() {
        MeshDefinition meshdefinition = templateLayerDefinition(1.0F);
        PartDefinition root = meshdefinition.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                .texOffs(70, 0).addBox(-4.5F, -0.5F, -2.5F, 9.0F, 13.0F, 5.0F, new CubeDeformation(-0.22F))
                .texOffs(-6, 52).addBox(-4.5F, -0.45F, -2.5F, 9.0F, 0.0F, 6.0F, CubeDeformation.NONE), PartPose.ZERO);
        body.addOrReplaceChild("abs", CubeListBuilder.create()
                .texOffs(38, 21).addBox(-3.5F, -1.0F, 0.3F, 7.0F, 8.0F, 1.0F, CubeDeformation.NONE), PartPose.offsetAndRotation(0.0F, 4.7F, -3.3F, 0.0873F, 0.0F, 0.0F));
        body.addOrReplaceChild("chest_back", CubeListBuilder.create()
                .texOffs(20, 31).addBox(-3.5F, -6.5F, -1.7F, 7.0F, 12.0F, 2.0F, CubeDeformation.NONE), PartPose.offsetAndRotation(0.0F, 6.2F, 2.5F, -0.0873F, 0.0F, 0.0F));

        body.addOrReplaceChild("collar_front", CubeListBuilder.create()
                .texOffs(-5, 58).addBox(-4.5F, 0.0F, -5.0F, 9.0F, 0.0F, 5.0F, CubeDeformation.NONE), PartPose.offsetAndRotation(0.0F, -0.45F, -2.5F, 1.1345F, 0.0F, 0.0F));
        body.addOrReplaceChild("collar_back", CubeListBuilder.create()
                .texOffs(-8, 44).addBox(-4.5F, 0.0F, 0.0F, 9.0F, 0.0F, 8.0F, CubeDeformation.NONE), PartPose.offsetAndRotation(0.0F, -0.45F, 3.5F, -1.5708F, 0.0F, 0.0F));
        body.addOrReplaceChild("chest_core", CubeListBuilder.create()
                .texOffs(61, 0).addBox(-1.0F, -1.2974F, -0.1F, 2.0F, 3.0F, 1.0F, CubeDeformation.NONE), PartPose.offsetAndRotation(0.0F, 2.5F, -3.6F, -0.3491F, 0.0F, 0.0F));
        body.addOrReplaceChild("chest_pec_right", CubeListBuilder.create()
                .texOffs(108, 10).addBox(-4.0F, -3.0F, -3.5F, 4.0F, 4.0F, 4.0F, CubeDeformation.NONE), PartPose.offsetAndRotation(0.5F, 4.0F, -0.5F, -0.3752F, 0.0F, -0.1745F));
        body.addOrReplaceChild("chest_pec_left", CubeListBuilder.create()
                .texOffs(108, 10).addBox(0.0F, -3.0F, -3.5F, 4.0F, 4.0F, 4.0F, CubeDeformation.NONE), PartPose.offsetAndRotation(-0.5F, 4.0F, -0.5F, -0.3752F, 0.0F, 0.1745F));

        body.addOrReplaceChild("cross_a", CubeListBuilder.create()
                .texOffs(18, 45).addBox(-2.5F, -44.0F, 2.0F, 5.0F, 6.0F, 0.0F, CubeDeformation.NONE), PartPose.offset(0.0F, 20.0F, 4.0F));
        body.addOrReplaceChild("cross_b", CubeListBuilder.create()
                .texOffs(18, 45).addBox(-2.5F, -44.0F, 2.0F, 5.0F, 6.0F, 0.0F, CubeDeformation.NONE), PartPose.offset(0.0F, 20.0F, 4.0F));
        body.addOrReplaceChild("cross_c", CubeListBuilder.create()
                .texOffs(18, 45).addBox(-2.5F, -44.0F, 2.0F, 5.0F, 6.0F, 0.0F, CubeDeformation.NONE), PartPose.offset(0.0F, 20.0F, 4.0F));
        body.addOrReplaceChild("cross_d", CubeListBuilder.create()
                .texOffs(18, 45).addBox(-2.5F, -44.0F, 2.0F, 5.0F, 6.0F, 0.0F, CubeDeformation.NONE), PartPose.offset(0.0F, 20.0F, 4.0F));

        PartDefinition rightArm = root.addOrReplaceChild("right_arm", CubeListBuilder.create()
                .texOffs(112, 48).addBox(-2.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, new CubeDeformation(0.25F))
                .texOffs(0, 26).addBox(-2.5F, -2.5F, -2.5F, 4.0F, 13.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.offset(-5.0F, 2.0F, 0.0F));
        rightArm.addOrReplaceChild("right_shoulder", CubeListBuilder.create()
                .texOffs(112, 0).addBox(-1.75F, -2.0F, -2.5F, 3.0F, 5.0F, 5.0F, new CubeDeformation(0.05F))
                .texOffs(25, 0).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 1.0F, CubeDeformation.NONE)
                .texOffs(18, 16).addBox(-3.0F, -6.0F, -3.0F, 4.0F, 9.0F, 6.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-1.25F, -0.75F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition leftArm = root.addOrReplaceChild("left_arm", CubeListBuilder.create().mirror()
                .texOffs(112, 48).addBox(-1.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, new CubeDeformation(0.25F))
                .texOffs(0, 26).addBox(-1.5F, -2.5F, -2.5F, 4.0F, 13.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.offset(5.0F, 2.0F, 0.0F));
        leftArm.addOrReplaceChild("left_shoulder", CubeListBuilder.create().mirror()
                .texOffs(112, 0).addBox(-1.25F, -2.0F, -2.5F, 3.0F, 5.0F, 5.0F, new CubeDeformation(0.05F))
                .texOffs(25, 0).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 1.0F, CubeDeformation.NONE)
                .texOffs(18, 16).addBox(-1.0F, -6.0F, -3.0F, 4.0F, 9.0F, 6.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(1.25F, -0.75F, 0.0F, 0.0F, 0.0F, 0.1745F));

        return LayerDefinition.create(meshdefinition, 128, 64);
    }

    @Override
    protected void setupArmorPartAnim(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.collarBack.xRot = - 1.5708F + 0.08F * (1 + sinPI(ageInTicks / 40.0F));
        this.crossA.x = getOrbitalX(8.5F + 2 * sinPI(ageInTicks / 40.0F), 0.5F, ageInTicks);
        this.crossA.y = getOrbitalY(8.5F + 2 * sinPI((ageInTicks + 10) / 30.0F), -0.5F, ageInTicks);
        this.crossB.x = getOrbitalX(8.0F + 2 * sinPI(ageInTicks / 70.0F), 0.45F, ageInTicks+ 5);
        this.crossB.y = getOrbitalY(8.0F + 2 * sinPI((ageInTicks + 10) / 40.0F), 0.45F, ageInTicks + 25);
        this.crossC.x = getOrbitalX(9.0F + 2 * sinPI((ageInTicks + 25) / 30.0F), 0.55F, ageInTicks+ 25);
        this.crossC.y = getOrbitalY(9.0F + 2 * sinPI((ageInTicks + 5) / 50.0F), 0.55F, ageInTicks + 30);
        this.crossD.x = getOrbitalX(8.0F + 2 * sinPI((ageInTicks + 30) / 80.0F), 0.42F, ageInTicks + 20);
        this.crossD.y = getOrbitalY(8.0F + 2 * sinPI(ageInTicks / 50.0F), 0.42F, ageInTicks + 20);
    }

    private float getOrbitalX(float amplitude, float frequency, float ageInTicks){
        return amplitude * cosPI(2 * frequency * ageInTicks / 40);
    }

    private float getOrbitalY(float amplitude, float frequency, float ageInTicks){
        return 30.0F + amplitude * sinPI(2 * frequency * ageInTicks / 40);
    }
}
