package org.dawnoftime.armoroftheages.client.models.holy_armor;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;
import org.dawnoftime.armoroftheages.client.models.ArmorModel;

public class ChestHolyArmorModel<T extends LivingEntity> extends ArmorModel<T> {
    private final ModelPart chestEffectFrontA;
    private final ModelPart chestEffectFrontB;
    private final ModelPart chestEffectBig;
    private final ModelPart chestEffectMiddle;
    private final ModelPart chestEffectMiddleRotated;
    private final ModelPart chestEffectSmall;
    private final ModelPart chestEffectSmallRotated;
    private final ModelPart armLeftEffect;
    private final ModelPart armLeftEffectRotated;
    private final ModelPart armLeftWing;
    private final ModelPart armRightEffect;
    private final ModelPart armRightEffectRotated;
    private final ModelPart armRightWing;

    public ChestHolyArmorModel(ModelPart root, boolean isSlim) {
        super(root, isSlim);
        ModelPart chestCore = this.body.getChild("chestCore");
        this.chestEffectFrontA = chestCore.getChild("chestEffectFrontA");
        this.chestEffectFrontB = chestCore.getChild("chestEffectFrontB");
        this.chestEffectBig = this.body.getChild("chestEffectBig");
        this.chestEffectMiddle = this.body.getChild("chestEffectMiddle");
        this.chestEffectMiddleRotated = this.body.getChild("chestEffectMiddleRotated");
        this.chestEffectSmall = this.body.getChild("chestEffectSmall");
        this.chestEffectSmallRotated = this.body.getChild("chestEffectSmallRotated");

        this.armLeftEffect = this.leftArm.getChild("armLeftEffect");
        this.armLeftEffectRotated = this.leftArm.getChild("armLeftEffectRotated");
        this.armLeftWing = this.leftArm.getChild("armLeftElbow").getChild("armLeftWing");

        this.armRightEffect = this.rightArm.getChild("armRightEffect");
        this.armRightEffectRotated = this.rightArm.getChild("armRightEffectRotated");
        this.armRightWing = this.rightArm.getChild("armRightElbow").getChild("armRightWing");
    }

    @Override
    public <E extends LivingEntity> ArmorModel<E> create(ModelPart root, boolean isSlim) {
        return new ChestHolyArmorModel<>(root, isSlim);
    }

    public static LayerDefinition createLayerDefinition() {
        MeshDefinition meshdefinition = templateLayerDefinition(1.0F);
        PartDefinition root = meshdefinition.getRoot();

        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 28).addBox(-4.5F, -0.5F, -2.5F, 9.0F, 13.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.ZERO);
        PartDefinition chestEffectBig = body.addOrReplaceChild("chestEffectBig", CubeListBuilder.create().texOffs(66, 0).addBox(-15.5F, -15.5F, 0.0F, 31.0F, 31.0F, 0.0F), PartPose.offset(0.0F, -2.5F, 7.0F));
        chestEffectBig.addOrReplaceChild("chestEffectBigRotated", CubeListBuilder.create().texOffs(90, 31).addBox(-9.5F, -9.5F, 0.0F, 19.0F, 19.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));
        body.addOrReplaceChild("chestEffectMiddle", CubeListBuilder.create().texOffs(0, 63).addBox(-8.5F, -8.5F, 0.01F, 17.0F, 17.0F, 0.0F), PartPose.offset(0.0F, -2.5F, 8.0F));
        body.addOrReplaceChild("chestEffectMiddleRotated", CubeListBuilder.create().texOffs(0, 80).addBox(-6.5F, -6.5F, 0.0F, 13.0F, 13.0F, 0.0F), PartPose.offset(0.0F, -2.5F, 8.0F));
        body.addOrReplaceChild("chestEffectSmall", CubeListBuilder.create().texOffs(83, 50).addBox(-4.5F, -4.5F, 0.0F, 9.0F, 9.0F, 0.0F), PartPose.offset(0.0F, -2.5F, 9.0F));
        body.addOrReplaceChild("chestEffectSmallRotated", CubeListBuilder.create().texOffs(101, 50).addBox(-4.5F, -4.5F, 0.01F, 9.0F, 9.0F, 0.0F), PartPose.offset(0.0F, -2.5F, 9.0F));
        body.addOrReplaceChild("chestBack", CubeListBuilder.create().texOffs(0, 46).addBox(-3.5F, -6.5F, -1.7F, 7.0F, 12.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 6.2F, 2.5F, -0.0873F, 0.0F, 0.0F));
        body.addOrReplaceChild("chestPecRight", CubeListBuilder.create().texOffs(37, 45).mirror().addBox(-4.0F, -5.0F, -2.9F, 4.0F, 5.0F, 4.0F), PartPose.offsetAndRotation(0.5F, 4.0F, -0.5F, -0.2007F, 0.0F, -0.2618F));
        body.addOrReplaceChild("chestPecLeft", CubeListBuilder.create().texOffs(37, 45).addBox(0.0F, -5.0F, -2.9F, 4.0F, 5.0F, 4.0F), PartPose.offsetAndRotation(-0.5F, 4.0F, -0.5F, -0.2007F, 0.0F, 0.2618F));
        PartDefinition chestCore = body.addOrReplaceChild("chestCore", CubeListBuilder.create().texOffs(0, 19).addBox(-1.0F, -3.5F, 0.0F, 2.0F, 3.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 4.5F, -3.6F, -0.1745F, 0.0F, 0.0F));
        chestCore.addOrReplaceChild("chestEffectFrontA", CubeListBuilder.create().texOffs(34, 70).addBox(-2.5F, -2.5F, 0.01F, 5.0F, 5.0F, 0.0F), PartPose.offset(0.0F, -1.0F, 0.3F));
        chestCore.addOrReplaceChild("chestEffectFrontB", CubeListBuilder.create().texOffs(34, 75).addBox(-2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 0.0F), PartPose.offset(0.0F, -1.0F, 0.3F));
        body.addOrReplaceChild("abs", CubeListBuilder.create().texOffs(18, 48).addBox(-3.5F, -1.0F, 0.3F, 7.0F, 8.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 4.7F, -3.3F, 0.0873F, 0.0F, 0.0F));

        PartDefinition armRight = root.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(46, 28).mirror().addBox(-3.5F, -2.0F, -2.5F, 5.0F, 12.0F, 5.0F, new CubeDeformation(-0.19F)), PartPose.offset(-5.0F, 2.0F, 0.0F));
        armRight.addOrReplaceChild("armRightShoulderA", CubeListBuilder.create().texOffs(25, 21).mirror().addBox(-4.0F, -3.5F, -3.5F, 6.0F, 5.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1745F));
        armRight.addOrReplaceChild("armRightShoulderB", CubeListBuilder.create().texOffs(0, 19).mirror().addBox(-6.2F, -2.0F, -4.0F, 8.0F, 1.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.6109F));
        PartDefinition armRightElbow = armRight.addOrReplaceChild("armRightElbow", CubeListBuilder.create().texOffs(44, 20).mirror().addBox(-3.5F, 3.3F, -3.0F, 5.0F, 2.0F, 6.0F), PartPose.ZERO);
        armRightElbow.addOrReplaceChild("armRightElbowDetail", CubeListBuilder.create().texOffs(0, 6).mirror().addBox(-4.0F, 3.8F, -1.1F, 1.0F, 1.0F, 1.0F), PartPose.ZERO);
        armRightElbow.addOrReplaceChild("armRightWing", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-0.099F, -1.0F, 0.0F, 0.0F, 2.0F, 4.0F), PartPose.offsetAndRotation(-3.401F, 4.3F, -1.6F, 0.1745F, -0.3054F, 0.0F));
        armRight.addOrReplaceChild("armRightGlove", CubeListBuilder.create().texOffs(47, 48).mirror().addBox(-2.5F, -1.5F, 0.0F, 5.0F, 3.0F, 6.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-1.0F, 9.0F, -3.0F, 0.0F, 0.0F, -0.0873F));
        armRight.addOrReplaceChild("armRightEffect", CubeListBuilder.create().texOffs(34, 56).mirror().addBox(0.0F, -3.5F, -3.5F, 0.0F, 7.0F, 7.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-3.0F, 5.0F, 0.0F, 0.0F, 0.0F, -1.0F));
        armRight.addOrReplaceChild("armRightEffectRotated", CubeListBuilder.create().texOffs(34, 56).mirror().addBox(0.0F, -3.5F, -3.5F, 0.0F, 7.0F, 7.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-3.0F, 5.0F, 0.0F, -0.7854F, 0.0F, -1.0F));

        PartDefinition armLeft = root.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(46, 28).addBox(-1.5F, -2.0F, -2.5F, 5.0F, 12.0F, 5.0F, new CubeDeformation(-0.19F)), PartPose.offset(5.0F, 2.0F, 0.0F));
        armLeft.addOrReplaceChild("armLeftShoulderA", CubeListBuilder.create().texOffs(25, 21).addBox(-2.0F, -3.5F, -3.5F, 6.0F, 5.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1745F));
        armLeft.addOrReplaceChild("armLeftShoulderB", CubeListBuilder.create().texOffs(0, 19).addBox(-1.8F, -2.0F, -4.0F, 8.0F, 1.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6109F));
        PartDefinition armLeftElbow = armLeft.addOrReplaceChild("armLeftElbow", CubeListBuilder.create().texOffs(44, 20).addBox(-1.5F, 3.3F, -3.0F, 5.0F, 2.0F, 6.0F), PartPose.ZERO);
        armLeftElbow.addOrReplaceChild("armLeftElbowDetail", CubeListBuilder.create().texOffs(0, 6).addBox(3.0F, 3.8F, -1.1F, 1.0F, 1.0F, 1.0F), PartPose.ZERO);
        armLeftElbow.addOrReplaceChild("armLeftWing", CubeListBuilder.create().texOffs(0, 0).addBox(0.099F, -1.0F, 0.0F, 0.0F, 2.0F, 4.0F), PartPose.offsetAndRotation(3.401F, 4.3F, -1.6F, 0.1745F, 0.3054F, 0.0F));
        armLeft.addOrReplaceChild("armLeftGlove", CubeListBuilder.create().texOffs(47, 48).addBox(-2.5F, -1.5F, 0.0F, 5.0F, 3.0F, 6.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(1.0F, 9.0F, -3.0F, 0.0F, 0.0F, 0.0873F));
        armLeft.addOrReplaceChild("armLeftEffect", CubeListBuilder.create().texOffs(34, 56).addBox(0.0F, -3.5F, -3.5F, 0.0F, 7.0F, 7.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(3.0F, 5.0F, 0.0F, 0.0F, 0.0F, 1.0F));
        armLeft.addOrReplaceChild("armLeftEffectRotated", CubeListBuilder.create().texOffs(34, 56).addBox(0.0F, -3.5F, -3.5F, 0.0F, 7.0F, 7.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(3.0F, 5.0F, 0.0F, -0.7854F, 0.0F, 1.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }


    public static LayerDefinition createSlimLayerDefinition() {
        MeshDefinition meshdefinition = templateLayerDefinition(1.0F);
        PartDefinition root = meshdefinition.getRoot();

        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 28).addBox(-4.5F, -0.5F, -2.5F, 9.0F, 13.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition chestEffectBig = body.addOrReplaceChild("chestEffectBig", CubeListBuilder.create().texOffs(66, 0).addBox(-15.5F, -15.5F, 0.0F, 31.0F, 31.0F, 0.0F), PartPose.offset(0.0F, -2.5F, 7.0F));
        chestEffectBig.addOrReplaceChild("chestEffectBigRotated", CubeListBuilder.create().texOffs(90, 31).addBox(-9.5F, -9.5F, 0.0F, 19.0F, 19.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));
        body.addOrReplaceChild("chestEffectMiddle", CubeListBuilder.create().texOffs(0, 63).addBox(-8.5F, -8.5F, 0.01F, 17.0F, 17.0F, 0.0F), PartPose.offset(0.0F, -2.5F, 8.0F));
        body.addOrReplaceChild("chestEffectMiddleRotated", CubeListBuilder.create().texOffs(0, 80).addBox(-6.5F, -6.5F, 0.0F, 13.0F, 13.0F, 0.0F), PartPose.offset(0.0F, -2.5F, 8.0F));
        body.addOrReplaceChild("chestEffectSmall", CubeListBuilder.create().texOffs(83, 50).addBox(-4.5F, -4.5F, 0.0F, 9.0F, 9.0F, 0.0F), PartPose.offset(0.0F, -2.5F, 9.0F));
        body.addOrReplaceChild("chestEffectSmallRotated", CubeListBuilder.create().texOffs(101, 50).addBox(-4.5F, -4.5F, 0.01F, 9.0F, 9.0F, 0.0F), PartPose.offset(0.0F, -2.5F, 9.0F));
        body.addOrReplaceChild("chestBack", CubeListBuilder.create().texOffs(0, 46).addBox(-3.5F, -6.5F, -1.7F, 7.0F, 12.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 6.2F, 2.5F, -0.0873F, 0.0F, 0.0F));
        body.addOrReplaceChild("chestPecRight", CubeListBuilder.create().texOffs(37, 45).mirror().addBox(-4.0F, -4.0F, -3.5F, 4.0F, 5.0F, 4.0F), PartPose.offsetAndRotation(0.5F, 4.0F, -0.5F, -0.3752F, 0.0F, -0.1745F));
        body.addOrReplaceChild("chestPecLeft", CubeListBuilder.create().texOffs(37, 45).addBox(0.0F, -4.0F, -3.5F, 4.0F, 5.0F, 4.0F), PartPose.offsetAndRotation(-0.5F, 4.0F, -0.5F, -0.3752F, 0.0F, 0.1745F));
        PartDefinition chestCore = body.addOrReplaceChild("chestCore", CubeListBuilder.create().texOffs(0, 19).addBox(-1.0F, -3.5F, -0.7F, 2.0F, 3.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 4.5F, -3.6F, -0.1745F, 0.0F, 0.0F));
        chestCore.addOrReplaceChild("chestEffectFrontA", CubeListBuilder.create().texOffs(34, 70).addBox(-2.5F, -2.5F, 0.01F, 5.0F, 5.0F, 0.0F), PartPose.offset(0.0F, -0.5F, 0.3F));
        chestCore.addOrReplaceChild("chestEffectFrontB", CubeListBuilder.create().texOffs(34, 75).addBox(-2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 0.0F), PartPose.offset(0.0F, -0.5F, 0.3F));
        body.addOrReplaceChild("abs", CubeListBuilder.create().texOffs(18, 48).addBox(-3.5F, -1.0F, 0.8F, 7.0F, 8.0F, 1.0F), PartPose.offset(0.0F, 4.7F, -3.3F));

        PartDefinition armRight = root.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(46, 28).mirror().addBox(-2.5F, -2.0F, -2.5F, 4.0F, 12.0F, 5.0F, new CubeDeformation(-0.19F)), PartPose.offset(-5.0F, 2.0F, 0.0F));
        armRight.addOrReplaceChild("armRightShoulderA", CubeListBuilder.create().texOffs(25, 21).mirror().addBox(-3.0F, -3.5F, -3.5F, 5.0F, 5.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1745F));
        armRight.addOrReplaceChild("armRightShoulderB", CubeListBuilder.create().texOffs(0, 19).mirror().addBox(-5.2F, -2.0F, -4.0F, 7.0F, 1.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.6109F));
        PartDefinition armRightElbow = armRight.addOrReplaceChild("armRightElbow", CubeListBuilder.create().texOffs(44, 20).mirror().addBox(-2.5F, 3.3F, -3.0F, 4.0F, 2.0F, 6.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
        armRightElbow.addOrReplaceChild("armRightElbowDetail", CubeListBuilder.create().texOffs(0, 6).mirror().addBox(-3.0F, 3.8F, -1.1F, 1.0F, 1.0F, 1.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
        armRightElbow.addOrReplaceChild("armRightWing", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.901F, -1.0F, 0.0F, 0.0F, 2.0F, 4.0F), PartPose.offsetAndRotation(-3.401F, 4.3F, -1.6F, 0.1745F, -0.3054F, 0.0F));
        armRight.addOrReplaceChild("armRightGlove", CubeListBuilder.create().texOffs(47, 48).mirror().addBox(-1.5F, -1.5F, 0.0F, 4.0F, 3.0F, 6.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-1.0F, 9.0F, -3.0F, 0.0F, 0.0F, -0.0873F));
        armRight.addOrReplaceChild("armRightEffect", CubeListBuilder.create().texOffs(34, 56).mirror().addBox(0.0F, -3.5F, -3.5F, 0.0F, 7.0F, 7.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-3.0F, 5.0F, 0.0F, 0.0F, 0.0F, -1.0F));
        armRight.addOrReplaceChild("armRightEffectRotated", CubeListBuilder.create().texOffs(34, 56).mirror().addBox(0.0F, -3.5F, -3.5F, 0.0F, 7.0F, 7.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-3.0F, 5.0F, 0.0F, -0.7854F, 0.0F, -1.0F));

        PartDefinition armLeft = root.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(46, 28).addBox(-1.5F, -2.0F, -2.5F, 4.0F, 12.0F, 5.0F, new CubeDeformation(-0.19F)), PartPose.offset(5.0F, 2.0F, 0.0F));
        armLeft.addOrReplaceChild("armLeftShoulderA", CubeListBuilder.create().texOffs(25, 21).addBox(-2.0F, -3.5F, -3.5F, 5.0F, 5.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1745F));
        armLeft.addOrReplaceChild("armLeftShoulderB", CubeListBuilder.create().texOffs(0, 19).addBox(-1.8F, -2.0F, -4.0F, 7.0F, 1.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6109F));
        PartDefinition armLeftElbow = armLeft.addOrReplaceChild("armLeftElbow", CubeListBuilder.create().texOffs(44, 20).addBox(-1.5F, 3.3F, -3.0F, 4.0F, 2.0F, 6.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
        armLeftElbow.addOrReplaceChild("armLeftElbowDetail", CubeListBuilder.create().texOffs(0, 6).addBox(2.0F, 3.8F, -1.1F, 1.0F, 1.0F, 1.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
        armLeftElbow.addOrReplaceChild("armLeftWing", CubeListBuilder.create().texOffs(0, 0).addBox(-0.901F, -1.0F, 0.0F, 0.0F, 2.0F, 4.0F), PartPose.offsetAndRotation(3.401F, 4.3F, -1.6F, 0.1745F, 0.3054F, 0.0F));
        armLeft.addOrReplaceChild("armLeftGlove", CubeListBuilder.create().texOffs(47, 48).addBox(-2.5F, -1.5F, 0.0F, 4.0F, 3.0F, 6.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(1.0F, 9.0F, -3.0F, 0.0F, 0.0F, 0.0873F));
        armLeft.addOrReplaceChild("armLeftEffect", CubeListBuilder.create().texOffs(34, 56).addBox(0.0F, -3.5F, -3.5F, 0.0F, 7.0F, 7.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(3.0F, 5.0F, 0.0F, 0.0F, 0.0F, 1.0F));
        armLeft.addOrReplaceChild("armLeftEffectRotated", CubeListBuilder.create().texOffs(34, 56).addBox(0.0F, -3.5F, -3.5F, 0.0F, 7.0F, 7.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(3.0F, 5.0F, 0.0F, -0.7854F, 0.0F, 1.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }


    @Override
    protected void setupArmorPartAnim(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        float dA = ageInTicks / 40.0F;
        float rotation = dA % (2.0F * (float)Math.PI);
        float rotationD = (dA + (float)Math.PI / 4.0F) % (2.0F * (float)Math.PI);
        this.chestEffectFrontA.zRot = rotation;
        this.chestEffectFrontB.zRot = rotationD;
        this.chestEffectMiddle.zRot = rotation;
        this.chestEffectMiddleRotated.zRot = rotationD;

        this.armLeftEffect.xRot = -rotation;
        this.armLeftEffectRotated.xRot = -rotationD;
        this.armRightEffect.xRot = -rotation;
        this.armRightEffectRotated.xRot = -rotationD;

        dA = 0.1F * sinPI(dA);
        this.armLeftWing.xRot = 0.1745F + dA;
        this.armRightWing.xRot = 0.1745F + dA;

        dA = 0.06F * sinPI(ageInTicks / 80.0F);
        this.chestEffectBig.y = dA;
        this.chestEffectMiddle.y = dA;
        this.chestEffectMiddleRotated.y = dA;
        this.chestEffectSmall.y = dA;
        this.chestEffectSmallRotated.y = dA;
        dA = ageInTicks / 20.0F;
        rotation = dA % (2.0F * (float)Math.PI);
        rotationD = (dA + (float)Math.PI / 4.0F) % (2.0F * (float)Math.PI);
        this.chestEffectSmall.zRot = -rotation;
        this.chestEffectSmallRotated.zRot = -rotationD;
    }
}
