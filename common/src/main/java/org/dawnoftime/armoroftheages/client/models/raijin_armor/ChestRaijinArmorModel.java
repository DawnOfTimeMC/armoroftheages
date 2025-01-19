package org.dawnoftime.armoroftheages.client.models.raijin_armor;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;
import org.dawnoftime.armoroftheages.client.models.ArmorModel;

public class ChestRaijinArmorModel<T extends LivingEntity> extends ArmorModel<T> {
    private final ModelPart chestScarfTop;
    private final ModelPart chestScarfRightA;
    private final ModelPart chestScarfRightB;
    private final ModelPart chestScarfRightC;
    private final ModelPart chestScarfTopRightA;
    private final ModelPart chestScarfTopRightB;
    private final ModelPart chestScarfLeftA;
    private final ModelPart chestScarfLeftB;
    private final ModelPart chestScarfLeftC;
    private final ModelPart chestScarfTopLeftA;
    private final ModelPart chestScarfTopLeftB;

    public ChestRaijinArmorModel(ModelPart root, boolean isSlim) {
        super(root, isSlim);
        this.chestScarfTop = this.body.getChild("chestScarfTop");
        this.chestScarfRightA = this.body.getChild("chestScarfRightA");
        this.chestScarfRightB = this.chestScarfRightA.getChild("chestScarfRightB");
        this.chestScarfRightC = this.chestScarfRightB.getChild("chestScarfRightC");
        this.chestScarfTopRightA = this.chestScarfTop.getChild("chestScarfTopRightA");
        this.chestScarfTopRightB = this.chestScarfTopRightA.getChild("chestScarfTopRightB");
        this.chestScarfLeftA = this.body.getChild("chestScarfLeftA");
        this.chestScarfLeftB = this.chestScarfLeftA.getChild("chestScarfLeftB");
        this.chestScarfLeftC = this.chestScarfLeftB.getChild("chestScarfLeftC");
        this.chestScarfTopLeftA = this.chestScarfTop.getChild("chestScarfTopLeftA");
        this.chestScarfTopLeftB = this.chestScarfTopLeftA.getChild("chestScarfTopLeftB");
    }

    @Override
    public <E extends LivingEntity> ArmorModel<E> create(ModelPart root, boolean isSlim) {
        return new ChestRaijinArmorModel<>(root, isSlim);
    }

    public static LayerDefinition createLayerDefinition() {
        MeshDefinition meshdefinition = templateLayerDefinition(1.0F);
        PartDefinition root = meshdefinition.getRoot();

        PartDefinition left_arm = root.addOrReplaceChild("left_arm", CubeListBuilder.create()
                        .texOffs(0, 0).addBox(-1.5F, 7.0F, -2.5F, 5.0F, 1.0F, 5.0F, CubeDeformation.NONE),
                PartPose.offset(5.0F, 2.0F, 0.0F));

        left_arm.addOrReplaceChild("armRingLeftB", CubeListBuilder.create()
                        .texOffs(15, 1).addBox(-1.5F, 5.5F, -2.5F, 5.0F, 1.0F, 5.0F, CubeDeformation.NONE),
                PartPose.ZERO);

        PartDefinition right_arm = root.addOrReplaceChild("right_arm", CubeListBuilder.create()
                        .texOffs(30, 0).addBox(-3.5F, 7.0F, -2.5F, 5.0F, 1.0F, 5.0F, CubeDeformation.NONE),
                PartPose.offset(-5.0F, 2.0F, 0.0F));

        right_arm.addOrReplaceChild("armRingRightB", CubeListBuilder.create()
                        .texOffs(0, 0).addBox(-3.5F, 5.5F, -2.5F, 5.0F, 1.0F, 5.0F, CubeDeformation.NONE),
                PartPose.ZERO);

        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                        .texOffs(0, 7).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.3F)),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition chestScarfTop = body.addOrReplaceChild("chestScarfTop", CubeListBuilder.create()
                        .texOffs(0, 29).addBox(-5.0F, -0.5F, -1.5F, 10.0F, 1.0F, 3.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(0.0F, -4.5F, 6.5F, -1.134464F, 0.0F, 0.0F));

        PartDefinition chestScarfTopLeftA = chestScarfTop.addOrReplaceChild("chestScarfTopLeftA", CubeListBuilder.create()
                        .texOffs(35, 18).addBox(-6.0F, -0.5F, -1.0F, 6.0F, 1.0F, 2.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(5.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.094395F));

        chestScarfTopLeftA.addOrReplaceChild("chestScarfTopLeftB", CubeListBuilder.create()
                        .texOffs(40, 21).addBox(-6.0F, -0.5F, -0.5F, 6.0F, 1.0F, 1.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(-6.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.047198F));

        PartDefinition chestScarfTopRightA = chestScarfTop.addOrReplaceChild("chestScarfTopRightA", CubeListBuilder.create()
                        .texOffs(35, 18).addBox(-6.0F, -0.5F, -1.0F, 6.0F, 1.0F, 2.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(-5.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.047198F));

        chestScarfTopRightA.addOrReplaceChild("chestScarfTopRightB", CubeListBuilder.create()
                        .texOffs(40, 21).addBox(-6.0F, -0.5F, -0.5F, 6.0F, 1.0F, 1.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(-6.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.047198F));

        PartDefinition chestScarfLeftA = body.addOrReplaceChild("chestScarfLeftA", CubeListBuilder.create()
                        .texOffs(50, 6).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 5.0F, 1.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(5.0F, 0.0F, -3.0F, 0.0F, 0.349066F, 0.174533F));

        PartDefinition chestScarfLeftB = chestScarfLeftA.addOrReplaceChild("chestScarfLeftB", CubeListBuilder.create()
                        .texOffs(58, 3).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(-0.1F)),
                PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 1.047198F, -0.174533F, 0.0F));

        chestScarfLeftB.addOrReplaceChild("chestScarfLeftC", CubeListBuilder.create()
                        .texOffs(54, 5).addBox(-1.0F, 0.0F, -0.5F, 2.0F, 6.0F, 1.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, -0.872665F, -0.872665F, 0.0F));

        PartDefinition chestScarfRightA = body.addOrReplaceChild("chestScarfRightA", CubeListBuilder.create()
                        .texOffs(50, 6).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 5.0F, 1.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(-5.0F, 0.0F, -3.0F, 0.0F, -0.349066F, -0.174533F));

        PartDefinition chestScarfRightB = chestScarfRightA.addOrReplaceChild("chestScarfRightB", CubeListBuilder.create()
                        .texOffs(58, 3).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(-0.1F)),
                PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 1.047198F, 0.174533F, 0.0F));

        chestScarfRightB.addOrReplaceChild("chestScarfRightC", CubeListBuilder.create()
                        .texOffs(54, 5).addBox(-1.0F, 0.0F, -0.5F, 2.0F, 6.0F, 1.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, -0.872665F, 0.872665F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    public static LayerDefinition createSlimLayerDefinition() {
        MeshDefinition meshdefinition = templateLayerDefinition(1.0F);
        PartDefinition root = meshdefinition.getRoot();

        PartDefinition left_arm = root.addOrReplaceChild("left_arm", CubeListBuilder.create()
                        .texOffs(0, 33).addBox(-1.5F, 7.0F, -2.5F, 4.0F, 1.0F, 5.0F, CubeDeformation.NONE),
                PartPose.offset(5.0F, 2.5F, 0.0F));

        left_arm.addOrReplaceChild("armRingLeftB", CubeListBuilder.create()
                        .texOffs(13, 34).addBox(-1.5F, 5.5F, -2.5F, 4.0F, 1.0F, 5.0F, CubeDeformation.NONE),
                PartPose.ZERO);

        PartDefinition right_arm = root.addOrReplaceChild("right_arm", CubeListBuilder.create()
                        .texOffs(21, 28).addBox(-2.5F, 7.0F, -2.5F, 4.0F, 1.0F, 5.0F, CubeDeformation.NONE),
                PartPose.offset(-5.0F, 2.5F, 0.0F));

        right_arm.addOrReplaceChild("armRingRightB", CubeListBuilder.create()
                        .texOffs(0, 33).addBox(-2.5F, 5.5F, -2.5F, 4.0F, 1.0F, 5.0F, CubeDeformation.NONE),
                PartPose.ZERO);

        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                        .texOffs(0, 7).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.2F)),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        body.addOrReplaceChild("bodyBreast", CubeListBuilder.create()
                        .texOffs(26, 34).addBox(-3.5F, 0.0F, -3.65F, 7.0F, 2.0F, 3.0F, new CubeDeformation(0.2F)),
                PartPose.offsetAndRotation(0.0F, 0.9F, -2.1F, 0.994838F, 0.0F, 0.0F));

        body.addOrReplaceChild("bodyBreastNecklace", CubeListBuilder.create()
                        .texOffs(39, 23).addBox(-4.0F, 0.2F, -5.2F, 8.0F, 0.0F, 5.0F, new CubeDeformation(0.2F)),
                PartPose.offsetAndRotation(0.0F, -0.2F, -2.2F, 1.00976F, 0.0F, 0.0F));

        PartDefinition chestScarfTop = body.addOrReplaceChild("chestScarfTop", CubeListBuilder.create()
                        .texOffs(0, 29).addBox(-5.0F, -0.5F, -1.5F, 10.0F, 1.0F, 3.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(0.0F, -4.5F, 6.5F, -1.134464F, 0.0F, 0.0F));

        PartDefinition chestScarfTopLeftA = chestScarfTop.addOrReplaceChild("chestScarfTopLeftA", CubeListBuilder.create()
                        .texOffs(35, 18).addBox(-6.0F, -0.5F, -1.0F, 6.0F, 1.0F, 2.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(5.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.094395F));

        chestScarfTopLeftA.addOrReplaceChild("chestScarfTopLeftB", CubeListBuilder.create()
                        .texOffs(40, 21).addBox(-6.0F, -0.5F, -0.5F, 6.0F, 1.0F, 1.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(-6.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.047198F));

        PartDefinition chestScarfTopRightA = chestScarfTop.addOrReplaceChild("chestScarfTopRightA", CubeListBuilder.create()
                        .texOffs(35, 18).addBox(-6.0F, -0.5F, -1.0F, 6.0F, 1.0F, 2.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(-5.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.047198F));

        chestScarfTopRightA.addOrReplaceChild("chestScarfTopRightB", CubeListBuilder.create()
                        .texOffs(40, 21).addBox(-6.0F, -0.5F, -0.5F, 6.0F, 1.0F, 1.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(-6.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.047198F));

        PartDefinition chestScarfLeftA = body.addOrReplaceChild("chestScarfLeftA", CubeListBuilder.create()
                        .texOffs(50, 6).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 5.0F, 1.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(5.0F, 0.0F, -3.0F, 0.0F, 0.349066F, 0.174533F));

        PartDefinition chestScarfLeftB = chestScarfLeftA.addOrReplaceChild("chestScarfLeftB", CubeListBuilder.create()
                        .texOffs(58, 3).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(-0.1F)),
                PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 1.047198F, -0.174533F, 0.0F));

        chestScarfLeftB.addOrReplaceChild("chestScarfLeftC", CubeListBuilder.create()
                        .texOffs(54, 5).addBox(-1.0F, 0.0F, -0.5F, 2.0F, 6.0F, 1.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, -0.872665F, -0.872665F, 0.0F));

        PartDefinition chestScarfRightA = body.addOrReplaceChild("chestScarfRightA", CubeListBuilder.create()
                        .texOffs(50, 6).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 5.0F, 1.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(-5.0F, 0.0F, -3.0F, 0.0F, -0.349066F, -0.174533F));

        PartDefinition chestScarfRightB = chestScarfRightA.addOrReplaceChild("chestScarfRightB", CubeListBuilder.create()
                        .texOffs(58, 3).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(-0.1F)),
                PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 1.047198F, 0.174533F, 0.0F));

        chestScarfRightB.addOrReplaceChild("chestScarfRightC", CubeListBuilder.create()
                        .texOffs(54, 5).addBox(-1.0F, 0.0F, -0.5F, 2.0F, 6.0F, 1.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, -0.872665F, 0.872665F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    protected void setupArmorPartAnim(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        float f = 0.03F * sinPI(2 * ageInTicks / 60.0F);
        float d = (0.866F - sinPI(0.333F - f)) * 4.0F;
        this.chestScarfTop.y = -4.5F + -d * 0.75F;
        this.chestScarfTop.z = 6.5F + d * 0.8659F;
        this.chestScarfRightA.y = d * 0.5F;
        this.chestScarfRightB.xRot = 1.047F + f * (float)Math.PI;
        this.chestScarfTopRightA.zRot = -1.047F - f * (float)Math.PI;
        this.chestScarfTopRightB.zRot = -1.047F + 2 * f * (float)Math.PI;
        this.chestScarfLeftA.y = d * 0.5F;
        this.chestScarfLeftB.xRot = 1.047F + f * (float)Math.PI;
        this.chestScarfTopLeftA.zRot = -2.094F + f * (float)Math.PI;
        this.chestScarfTopLeftB.zRot = 1.047F - 2 * f * (float)Math.PI;
        f = -0.872F + 0.03F * sinPI((ageInTicks - 15) / 30.0F) * (float)Math.PI;
        this.chestScarfRightC.xRot = f;
        this.chestScarfLeftC.xRot = f;
    }
}
