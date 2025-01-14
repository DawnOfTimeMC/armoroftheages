package org.dawnoftime.armoroftheages.client.models.exalted_aurum;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;
import org.dawnoftime.armoroftheages.client.models.ArmorModel;

public class ChestExaltedAurumArmorModel<T extends LivingEntity> extends ArmorModel<T> {
    private final ModelPart ring;
    private final ModelPart rightDeco;
    private final ModelPart rightHang;
    private final ModelPart leftDeco;
    private final ModelPart leftHang;
    private final ModelPart midDeco;
    private final ModelPart midHang;

    public ChestExaltedAurumArmorModel(ModelPart root, boolean isSlim) {
        super(root, isSlim);
        this.ring = this.body.getChild("ring");
        this.rightDeco = this.ring.getChild("right_deco");
        this.rightHang = this.rightDeco.getChild("right_hang");
        this.leftDeco = this.ring.getChild("left_deco");
        this.leftHang = this.leftDeco.getChild("left_hang");
        this.midDeco = this.ring.getChild("mid_deco");
        this.midHang = this.midDeco.getChild("mid_hang");
    }

    public static LayerDefinition createLayerDefinition() {
        MeshDefinition meshdefinition = templateLayerDefinition(1.0F);
        PartDefinition root = meshdefinition.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 27).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.4F))
                .texOffs(27, 0).addBox(-4.0F, -1.0F, -1.75F, 8.0F, 1.0F, 4.0F, new CubeDeformation(0.24F))
                .texOffs(39, 17).addBox(-4.0F, -1.0F, 2.0F, 8.0F, 7.0F, 1.0F, CubeDeformation.NONE), PartPose.ZERO);
        body.addOrReplaceChild("Body_r1", CubeListBuilder.create().texOffs(0, 21).mirror().addBox(-0.24F, -1.5F, -1.0F, 1.0F, 1.0F, 2.0F, CubeDeformation.NONE).mirror(false)
                .texOffs(0, 21).addBox(7.24F, -1.5F, -1.0F, 1.0F, 1.0F, 2.0F, CubeDeformation.NONE), PartPose.offsetAndRotation(-4.0F, 0.4395F, -1.3348F, 0.9599F, 0.0F, 0.0F));
        body.addOrReplaceChild("Body_r2", CubeListBuilder.create().texOffs(0, 15).mirror().addBox(-0.3F, -1.5F, -1.0F, 1.0F, 4.0F, 2.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(-3.9426F, 1.2526F, -2.2778F, 0.3927F, 0.0F, 0.0F));
        body.addOrReplaceChild("Body_r3", CubeListBuilder.create().texOffs(0, 15).addBox(-0.5F, -1.5F, -1.0F, 1.0F, 4.0F, 2.0F, CubeDeformation.NONE), PartPose.offsetAndRotation(3.7426F, 1.2526F, -2.2778F, 0.3927F, 0.0F, 0.0F));
        body.addOrReplaceChild("bodyChestLayer_r1", CubeListBuilder.create().texOffs(21, 17).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, CubeDeformation.NONE), PartPose.offsetAndRotation(0.0F, 0.5F, -3.15F, 0.5299F, -0.7119F, -0.3655F));
        body.addOrReplaceChild("bodyChest_r1", CubeListBuilder.create().texOffs(24, 27).addBox(-3.0F, -3.5F, -3.0F, 6.0F, 7.0F, 6.0F, CubeDeformation.NONE), PartPose.offsetAndRotation(0.0F, 3.4831F, -2.4363F, 0.5299F, -0.7119F, -0.3655F));

        PartDefinition ring = body.addOrReplaceChild("ring", CubeListBuilder.create(), PartPose.offset(0.0F, -13.0F, 8.0F));
        ring.addOrReplaceChild("Body_r4", CubeListBuilder.create().texOffs(52, 26).mirror().addBox(-3.0F, 5.2426F, -1.0F, 6.0F, 2.0F, 2.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(0.0F, -0.2426F, 0.0F, 0.0F, 0.0F, -1.9635F));
        ring.addOrReplaceChild("Body_r5", CubeListBuilder.create().texOffs(52, 26).mirror().addBox(-3.0F, 5.2426F, -1.0F, 6.0F, 2.0F, 2.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(0.0F, -0.2426F, 0.0F, 0.0F, 0.0F, -1.1781F));
        ring.addOrReplaceChild("Body_r6", CubeListBuilder.create().texOffs(52, 26).mirror().addBox(-3.0F, 5.2426F, -1.0F, 6.0F, 2.0F, 2.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(0.0F, -0.2426F, 0.0F, 0.0F, 0.0F, -0.3927F));
        ring.addOrReplaceChild("Body_r7", CubeListBuilder.create().texOffs(52, 26).mirror().addBox(-3.0F, 5.2426F, -1.0F, 6.0F, 2.0F, 2.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(0.0F, -0.2426F, 0.0F, 0.0F, 0.0F, 0.3927F));
        ring.addOrReplaceChild("Body_r8", CubeListBuilder.create().texOffs(52, 26).mirror().addBox(-3.0F, 5.2426F, -1.0F, 6.0F, 2.0F, 2.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(0.0F, -0.2426F, 0.0F, 0.0F, 0.0F, -2.7489F));
        ring.addOrReplaceChild("Body_r9", CubeListBuilder.create().texOffs(0, 1).mirror().addBox(-0.867F, -1.0884F, -1.0308F, 0.0F, 2.0F, 4.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(-2.447F, -8.5003F, 1.9283F, 0.6821F, -0.9432F, -0.6946F));
        ring.addOrReplaceChild("Body_r10", CubeListBuilder.create().texOffs(0, -2).mirror().addBox(-0.918F, -2.4283F, -1.6035F, 0.0F, 3.0F, 4.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(-2.447F, -8.5003F, 1.9283F, 0.7694F, -0.9432F, -0.6946F));
        ring.addOrReplaceChild("Body_r11", CubeListBuilder.create().texOffs(0, -3).mirror().addBox(-1.173F, -0.5402F, -2.8268F, 0.0F, 2.0F, 3.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(-2.447F, -9.0003F, 1.9283F, 0.813F, -0.9432F, -0.6946F));
        ring.addOrReplaceChild("Body_r12", CubeListBuilder.create().texOffs(0, 1).mirror().addBox(-0.918F, -0.1563F, -0.6475F, 0.0F, 2.0F, 4.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(-2.447F, -8.5003F, 1.9283F, 0.1585F, -0.9432F, -0.6946F));
        ring.addOrReplaceChild("Body_r13", CubeListBuilder.create().texOffs(0, -3).addBox(1.173F, -0.5402F, -2.8268F, 0.0F, 2.0F, 3.0F, CubeDeformation.NONE), PartPose.offsetAndRotation(2.447F, -9.0003F, 1.9283F, 0.813F, 0.9432F, 0.6946F));
        ring.addOrReplaceChild("Body_r14", CubeListBuilder.create().texOffs(0, -2).addBox(0.918F, -2.4283F, -1.6035F, 0.0F, 3.0F, 4.0F, CubeDeformation.NONE), PartPose.offsetAndRotation(2.447F, -8.5003F, 1.9283F, 0.7694F, 0.9432F, 0.6946F));
        ring.addOrReplaceChild("Body_r15", CubeListBuilder.create().texOffs(0, 1).addBox(0.867F, -1.0884F, -1.0308F, 0.0F, 2.0F, 4.0F, CubeDeformation.NONE), PartPose.offsetAndRotation(2.447F, -8.5003F, 1.9283F, 0.6821F, 0.9432F, 0.6946F));
        ring.addOrReplaceChild("Body_r16", CubeListBuilder.create().texOffs(0, 1).addBox(0.918F, -0.1563F, -0.6475F, 0.0F, 2.0F, 4.0F, CubeDeformation.NONE), PartPose.offsetAndRotation(2.447F, -8.5003F, 1.9283F, 0.1585F, 0.9432F, 0.6946F));
        ring.addOrReplaceChild("Body_r17", CubeListBuilder.create().texOffs(69, 24).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, CubeDeformation.NONE), PartPose.offsetAndRotation(-0.0279F, -6.7702F, 0.0F, 0.0F, 0.0F, -0.7854F));
        ring.addOrReplaceChild("Body_r18", CubeListBuilder.create().texOffs(52, 26).addBox(-3.0F, 5.2426F, -1.0F, 6.0F, 2.0F, 2.0F, CubeDeformation.NONE), PartPose.offsetAndRotation(0.0F, -0.2426F, 0.0F, 0.0F, 0.0F, 2.7489F));
        ring.addOrReplaceChild("Body_r19", CubeListBuilder.create().texOffs(52, 26).addBox(-3.0F, 5.2426F, -1.0F, 6.0F, 2.0F, 2.0F, CubeDeformation.NONE), PartPose.offsetAndRotation(0.0F, -0.2426F, 0.0F, 0.0F, 0.0F, 1.9635F));
        ring.addOrReplaceChild("Body_r20", CubeListBuilder.create().texOffs(52, 26).addBox(-3.0F, 5.2426F, -1.0F, 6.0F, 2.0F, 2.0F, CubeDeformation.NONE), PartPose.offsetAndRotation(0.0F, -0.2426F, 0.0F, 0.0F, 0.0F, 1.1781F));

        PartDefinition rightDeco = ring.addOrReplaceChild("right_deco", CubeListBuilder.create(), PartPose.offset(-7.4F, 1.0F, 0.0F));
        rightDeco.addOrReplaceChild("Body_r21", CubeListBuilder.create().texOffs(51, 0).addBox(1.0F, -3.0F, 0.0F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1174F, -0.1037F, 0.0F, 0.0F, 0.0F, 1.9199F));
        rightDeco.addOrReplaceChild("Body_r22", CubeListBuilder.create().texOffs(54, 5).addBox(-1.0F, -1.0F, -1.25F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1328F, 0.9941F, -0.25F, 0.0F, 0.0F, 1.9635F));

        PartDefinition rightHang = rightDeco.addOrReplaceChild("right_hang", CubeListBuilder.create(), PartPose.offset(-1.1328F, 4.9941F, 0.0F));
        rightHang.addOrReplaceChild("Body_r23", CubeListBuilder.create().texOffs(54, 10).addBox(-1.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.25F, 0.0F, 0.0F, 0.0F, 1.5708F));
        rightHang.addOrReplaceChild("Body_r24", CubeListBuilder.create().texOffs(54, 5).addBox(-1.0F, -1.0F, -1.25F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -0.25F, 0.0F, 0.0F, 0.7854F));

        PartDefinition leftDeco = ring.addOrReplaceChild("left_deco", CubeListBuilder.create(), PartPose.offset(7.4F, 1.0F, 0.0F));
        leftDeco.addOrReplaceChild("Body_r25", CubeListBuilder.create().texOffs(51, 0).mirror().addBox(-6.0F, -3.0F, 0.0F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.1174F, -0.1037F, 0.0F, 0.0F, 0.0F, -1.9199F));
        leftDeco.addOrReplaceChild("Body_r26", CubeListBuilder.create().texOffs(54, 5).mirror().addBox(-1.0F, -1.0F, -1.25F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.1328F, 0.9941F, -0.25F, 0.0F, 0.0F, -1.9635F));

        PartDefinition leftHang = leftDeco.addOrReplaceChild("left_hang", CubeListBuilder.create(), PartPose.offset(1.1328F, 4.9941F, 0.0F));
        leftHang.addOrReplaceChild("Body_r27", CubeListBuilder.create().texOffs(54, 10).mirror().addBox(-4.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 2.25F, 0.0F, 0.0F, 0.0F, -1.5708F));
        leftHang.addOrReplaceChild("Body_r28", CubeListBuilder.create().texOffs(54, 5).mirror().addBox(-1.0F, -1.0F, -1.25F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.7854F));

        PartDefinition midDeco = ring.addOrReplaceChild("mid_deco", CubeListBuilder.create(), PartPose.offset(-0.1817F, 7.5605F, -0.25F));
        midDeco.addOrReplaceChild("Body_r29", CubeListBuilder.create().texOffs(51, 0).addBox(-2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.9176F, 0.249F, 0.0F, 0.0F, 1.5708F));
        midDeco.addOrReplaceChild("Body_r30", CubeListBuilder.create().texOffs(54, 5).addBox(-1.0F, -1.0F, -1.25F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition midHang = midDeco.addOrReplaceChild("mid_hang", CubeListBuilder.create(), PartPose.offset(0.0F, 4.5034F, 0.0F));
        midHang.addOrReplaceChild("Body_r31", CubeListBuilder.create().texOffs(54, 10).addBox(-1.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.1642F, 0.25F, 0.0F, 0.0F, 1.5708F));
        midHang.addOrReplaceChild("Body_r32", CubeListBuilder.create().texOffs(54, 5).addBox(-1.0F, -1.0F, -1.25F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition right_arm = root.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(67, 10).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.3F))
                .texOffs(52, 20).addBox(-3.5F, 6.75F, -2.5F, 5.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 2.0F, 0.0F));
        right_arm.addOrReplaceChild("RightArm_r1", CubeListBuilder.create().texOffs(0, 7).mirror().addBox(-1.0F, -1.0F, -1.0F, 3.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.5F, 0.75F, -3.0F, -0.2775F, 0.8742F, -0.6854F));
        right_arm.addOrReplaceChild("RightArm_r2", CubeListBuilder.create().texOffs(0, 7).mirror().addBox(-1.0F, -1.0F, -1.0F, 3.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.5F, 2.75F, -2.5F, 0.845F, 0.3772F, 0.9251F));
        right_arm.addOrReplaceChild("RightArm_r3", CubeListBuilder.create().texOffs(0, 7).mirror().addBox(-1.0F, -1.0F, -1.0F, 3.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, 1.75F, -3.375F, 0.3109F, 0.8656F, 0.0694F));
        right_arm.addOrReplaceChild("RightArm_r4", CubeListBuilder.create().texOffs(20, 27).mirror().addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.075F, 1.5F, -2.525F, -0.2386F, 0.2316F, -0.8142F));
        right_arm.addOrReplaceChild("RightArm_r5", CubeListBuilder.create().texOffs(76, 25).mirror().addBox(-3.0F, -0.5F, -2.55F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.2365F, 0.7613F, 0.0F, 3.1416F, 0.0F, -2.9671F));
        right_arm.addOrReplaceChild("RightArm_r6", CubeListBuilder.create().texOffs(64, 0).mirror().addBox(-0.875F, -2.1249F, -2.8312F, 8.0F, 5.0F, 5.0F, new CubeDeformation(0.4F)).mirror(false), PartPose.offsetAndRotation(-1.15F, -0.9501F, -0.2562F, 3.1416F, 0.0F, 2.9671F));
        right_arm.addOrReplaceChild("RightArm_r7", CubeListBuilder.create().texOffs(102, 0).mirror().addBox(-0.875F, -2.1249F, -2.5812F, 8.0F, 5.0F, 5.0F, new CubeDeformation(0.2F)).mirror(false)
                .texOffs(90, 0).mirror().addBox(4.125F, -2.1249F, -2.5812F, 1.0F, 5.0F, 5.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(-1.125F, -0.8751F, -0.0063F, 3.1416F, 0.0F, 2.9671F));
        right_arm.addOrReplaceChild("RightArm_r8", CubeListBuilder.create().texOffs(70, 35).mirror().addBox(-0.202F, -2.4957F, -2.9937F, 5.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.375F, -1.1251F, -0.0063F, -0.0123F, -0.0065F, -0.5669F));

        PartDefinition left_arm = root.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(67, 10).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.3F)).mirror(false)
                .texOffs(52, 20).mirror().addBox(-1.5F, 6.75F, -2.5F, 5.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(67, 10).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.3F)).mirror(false), PartPose.offset(5.0F, 2.0F, 0.0F));
        left_arm.addOrReplaceChild("LeftArm_r1", CubeListBuilder.create().texOffs(90, 0).addBox(-5.125F, -2.1249F, -2.5812F, 1.0F, 5.0F, 5.0F, new CubeDeformation(0.2F))
                .texOffs(102, 0).addBox(-7.125F, -2.1249F, -2.5812F, 8.0F, 5.0F, 5.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(1.125F, -0.8751F, -0.0063F, 3.1416F, 0.0F, -2.9671F));
        left_arm.addOrReplaceChild("LeftArm_r2", CubeListBuilder.create().texOffs(64, 0).addBox(-7.125F, -2.1249F, -2.8312F, 8.0F, 5.0F, 5.0F, new CubeDeformation(0.4F)), PartPose.offsetAndRotation(1.15F, -0.9501F, -0.2562F, 3.1416F, 0.0F, -2.9671F));
        left_arm.addOrReplaceChild("LeftArm_r3", CubeListBuilder.create().texOffs(70, 35).addBox(-4.798F, -2.4957F, -2.9937F, 5.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.375F, -1.1251F, -0.0063F, -0.0123F, 0.0065F, 0.5669F));
        left_arm.addOrReplaceChild("LeftArm_r4", CubeListBuilder.create().texOffs(0, 7).addBox(-2.0F, -1.0F, -1.0F, 3.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 0.75F, -3.0F, -0.2775F, -0.8742F, 0.6854F));
        left_arm.addOrReplaceChild("LeftArm_r5", CubeListBuilder.create().texOffs(0, 7).addBox(-2.0F, -1.0F, -1.0F, 3.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 2.75F, -2.5F, 0.845F, -0.3772F, -0.9251F));
        left_arm.addOrReplaceChild("LeftArm_r6", CubeListBuilder.create().texOffs(0, 7).addBox(-2.0F, -1.0F, -1.0F, 3.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 1.75F, -3.375F, 0.3109F, -0.8656F, -0.0694F));
        left_arm.addOrReplaceChild("LeftArm_r7", CubeListBuilder.create().texOffs(83, 10).addBox(-2.0F, -3.5F, -2.55F, 5.0F, 8.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(2.9865F, 3.7613F, 0.0F, 0.0F, 3.1416F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 64);
    }

    public static LayerDefinition createSlimLayerDefinition() {
        MeshDefinition meshdefinition = templateLayerDefinition(1.0F);
        PartDefinition root = meshdefinition.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 27).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.4F))
                .texOffs(27, 0).addBox(-4.0F, -1.0F, -1.75F, 8.0F, 1.0F, 4.0F, new CubeDeformation(0.24F))
                .texOffs(39, 17).addBox(-4.0F, -1.0F, 2.0F, 8.0F, 7.0F, 1.0F, CubeDeformation.NONE), PartPose.ZERO);
        body.addOrReplaceChild("Body_r1", CubeListBuilder.create().texOffs(0, 21).mirror().addBox(-0.24F, -1.5F, -1.0F, 1.0F, 1.0F, 2.0F, CubeDeformation.NONE).mirror(false)
                .texOffs(0, 21).addBox(7.24F, -1.5F, -1.0F, 1.0F, 1.0F, 2.0F, CubeDeformation.NONE), PartPose.offsetAndRotation(-4.0F, 0.4395F, -1.3348F, 0.9599F, 0.0F, 0.0F));
        body.addOrReplaceChild("Body_r2", CubeListBuilder.create().texOffs(0, 15).mirror().addBox(-0.3F, -1.5F, -1.0F, 1.0F, 4.0F, 2.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(-3.9426F, 1.2526F, -2.2778F, 0.3927F, 0.0F, 0.0F));
        body.addOrReplaceChild("Body_r3", CubeListBuilder.create().texOffs(0, 15).addBox(-0.5F, -1.5F, -1.0F, 1.0F, 4.0F, 2.0F, CubeDeformation.NONE), PartPose.offsetAndRotation(3.7426F, 1.2526F, -2.2778F, 0.3927F, 0.0F, 0.0F));
        body.addOrReplaceChild("bodyChestLayer_r1", CubeListBuilder.create().texOffs(21, 17).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, CubeDeformation.NONE), PartPose.offsetAndRotation(0.0F, 0.5F, -3.15F, 0.5299F, -0.7119F, -0.3655F));
        body.addOrReplaceChild("bodyChest_r1", CubeListBuilder.create().texOffs(24, 27).addBox(-3.0F, -3.5F, -3.0F, 6.0F, 7.0F, 6.0F, CubeDeformation.NONE), PartPose.offsetAndRotation(0.0F, 3.4831F, -2.4363F, 0.5299F, -0.7119F, -0.3655F));

        PartDefinition ring = body.addOrReplaceChild("ring", CubeListBuilder.create(), PartPose.offset(0.0F, -13.0F, 8.0F));
        ring.addOrReplaceChild("Body_r4", CubeListBuilder.create().texOffs(52, 26).mirror().addBox(-3.0F, 5.2426F, -1.0F, 6.0F, 2.0F, 2.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(0.0F, -0.2426F, 0.0F, 0.0F, 0.0F, -1.9635F));
        ring.addOrReplaceChild("Body_r5", CubeListBuilder.create().texOffs(52, 26).mirror().addBox(-3.0F, 5.2426F, -1.0F, 6.0F, 2.0F, 2.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(0.0F, -0.2426F, 0.0F, 0.0F, 0.0F, -1.1781F));
        ring.addOrReplaceChild("Body_r6", CubeListBuilder.create().texOffs(52, 26).mirror().addBox(-3.0F, 5.2426F, -1.0F, 6.0F, 2.0F, 2.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(0.0F, -0.2426F, 0.0F, 0.0F, 0.0F, -0.3927F));
        ring.addOrReplaceChild("Body_r7", CubeListBuilder.create().texOffs(52, 26).mirror().addBox(-3.0F, 5.2426F, -1.0F, 6.0F, 2.0F, 2.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(0.0F, -0.2426F, 0.0F, 0.0F, 0.0F, 0.3927F));
        ring.addOrReplaceChild("Body_r8", CubeListBuilder.create().texOffs(52, 26).mirror().addBox(-3.0F, 5.2426F, -1.0F, 6.0F, 2.0F, 2.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(0.0F, -0.2426F, 0.0F, 0.0F, 0.0F, -2.7489F));
        ring.addOrReplaceChild("Body_r9", CubeListBuilder.create().texOffs(0, 1).mirror().addBox(-0.867F, -1.0884F, -1.0308F, 0.0F, 2.0F, 4.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(-2.447F, -8.5003F, 1.9283F, 0.6821F, -0.9432F, -0.6946F));
        ring.addOrReplaceChild("Body_r10", CubeListBuilder.create().texOffs(0, -2).mirror().addBox(-0.918F, -2.4283F, -1.6035F, 0.0F, 3.0F, 4.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(-2.447F, -8.5003F, 1.9283F, 0.7694F, -0.9432F, -0.6946F));
        ring.addOrReplaceChild("Body_r11", CubeListBuilder.create().texOffs(0, -3).mirror().addBox(-1.173F, -0.5402F, -2.8268F, 0.0F, 2.0F, 3.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(-2.447F, -9.0003F, 1.9283F, 0.813F, -0.9432F, -0.6946F));
        ring.addOrReplaceChild("Body_r12", CubeListBuilder.create().texOffs(0, 1).mirror().addBox(-0.918F, -0.1563F, -0.6475F, 0.0F, 2.0F, 4.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(-2.447F, -8.5003F, 1.9283F, 0.1585F, -0.9432F, -0.6946F));
        ring.addOrReplaceChild("Body_r13", CubeListBuilder.create().texOffs(0, -3).addBox(1.173F, -0.5402F, -2.8268F, 0.0F, 2.0F, 3.0F, CubeDeformation.NONE), PartPose.offsetAndRotation(2.447F, -9.0003F, 1.9283F, 0.813F, 0.9432F, 0.6946F));
        ring.addOrReplaceChild("Body_r14", CubeListBuilder.create().texOffs(0, -2).addBox(0.918F, -2.4283F, -1.6035F, 0.0F, 3.0F, 4.0F, CubeDeformation.NONE), PartPose.offsetAndRotation(2.447F, -8.5003F, 1.9283F, 0.7694F, 0.9432F, 0.6946F));
        ring.addOrReplaceChild("Body_r15", CubeListBuilder.create().texOffs(0, 1).addBox(0.867F, -1.0884F, -1.0308F, 0.0F, 2.0F, 4.0F, CubeDeformation.NONE), PartPose.offsetAndRotation(2.447F, -8.5003F, 1.9283F, 0.6821F, 0.9432F, 0.6946F));
        ring.addOrReplaceChild("Body_r16", CubeListBuilder.create().texOffs(0, 1).addBox(0.918F, -0.1563F, -0.6475F, 0.0F, 2.0F, 4.0F, CubeDeformation.NONE), PartPose.offsetAndRotation(2.447F, -8.5003F, 1.9283F, 0.1585F, 0.9432F, 0.6946F));
        ring.addOrReplaceChild("Body_r17", CubeListBuilder.create().texOffs(69, 24).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, CubeDeformation.NONE), PartPose.offsetAndRotation(-0.0279F, -6.7702F, 0.0F, 0.0F, 0.0F, -0.7854F));
        ring.addOrReplaceChild("Body_r18", CubeListBuilder.create().texOffs(52, 26).addBox(-3.0F, 5.2426F, -1.0F, 6.0F, 2.0F, 2.0F, CubeDeformation.NONE), PartPose.offsetAndRotation(0.0F, -0.2426F, 0.0F, 0.0F, 0.0F, 2.7489F));
        ring.addOrReplaceChild("Body_r19", CubeListBuilder.create().texOffs(52, 26).addBox(-3.0F, 5.2426F, -1.0F, 6.0F, 2.0F, 2.0F, CubeDeformation.NONE), PartPose.offsetAndRotation(0.0F, -0.2426F, 0.0F, 0.0F, 0.0F, 1.9635F));
        ring.addOrReplaceChild("Body_r20", CubeListBuilder.create().texOffs(52, 26).addBox(-3.0F, 5.2426F, -1.0F, 6.0F, 2.0F, 2.0F, CubeDeformation.NONE), PartPose.offsetAndRotation(0.0F, -0.2426F, 0.0F, 0.0F, 0.0F, 1.1781F));

        PartDefinition rightDeco = ring.addOrReplaceChild("right_deco", CubeListBuilder.create(), PartPose.offset(-7.4F, 1.0F, 0.0F));
        rightDeco.addOrReplaceChild("Body_r21", CubeListBuilder.create().texOffs(51, 0).addBox(1.0F, -3.0F, 0.0F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1174F, -0.1037F, 0.0F, 0.0F, 0.0F, 1.9199F));
        rightDeco.addOrReplaceChild("Body_r22", CubeListBuilder.create().texOffs(54, 5).addBox(-1.0F, -1.0F, -1.25F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1328F, 0.9941F, -0.25F, 0.0F, 0.0F, 1.9635F));

        PartDefinition rightHang = rightDeco.addOrReplaceChild("right_hang", CubeListBuilder.create(), PartPose.offset(-1.1328F, 4.9941F, 0.0F));
        rightHang.addOrReplaceChild("Body_r23", CubeListBuilder.create().texOffs(54, 10).addBox(-1.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.25F, 0.0F, 0.0F, 0.0F, 1.5708F));
        rightHang.addOrReplaceChild("Body_r24", CubeListBuilder.create().texOffs(54, 5).addBox(-1.0F, -1.0F, -1.25F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -0.25F, 0.0F, 0.0F, 0.7854F));

        PartDefinition leftDeco = ring.addOrReplaceChild("left_deco", CubeListBuilder.create(), PartPose.offset(7.4F, 1.0F, 0.0F));
        leftDeco.addOrReplaceChild("Body_r25", CubeListBuilder.create().texOffs(51, 0).mirror().addBox(-6.0F, -3.0F, 0.0F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.1174F, -0.1037F, 0.0F, 0.0F, 0.0F, -1.9199F));
        leftDeco.addOrReplaceChild("Body_r26", CubeListBuilder.create().texOffs(54, 5).mirror().addBox(-1.0F, -1.0F, -1.25F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.1328F, 0.9941F, -0.25F, 0.0F, 0.0F, -1.9635F));

        PartDefinition leftHang = leftDeco.addOrReplaceChild("left_hang", CubeListBuilder.create(), PartPose.offset(1.1328F, 4.9941F, 0.0F));
        leftHang.addOrReplaceChild("Body_r27", CubeListBuilder.create().texOffs(54, 10).mirror().addBox(-4.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 2.25F, 0.0F, 0.0F, 0.0F, -1.5708F));
        leftHang.addOrReplaceChild("Body_r28", CubeListBuilder.create().texOffs(54, 5).mirror().addBox(-1.0F, -1.0F, -1.25F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.7854F));

        PartDefinition midDeco = ring.addOrReplaceChild("mid_deco", CubeListBuilder.create(), PartPose.offset(-0.1817F, 7.5605F, -0.25F));
        midDeco.addOrReplaceChild("Body_r29", CubeListBuilder.create().texOffs(51, 0).addBox(-2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.9176F, 0.249F, 0.0F, 0.0F, 1.5708F));
        midDeco.addOrReplaceChild("Body_r30", CubeListBuilder.create().texOffs(54, 5).addBox(-1.0F, -1.0F, -1.25F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition midHang = midDeco.addOrReplaceChild("mid_hang", CubeListBuilder.create(), PartPose.offset(0.0F, 4.5034F, 0.0F));
        midHang.addOrReplaceChild("Body_r31", CubeListBuilder.create().texOffs(54, 10).addBox(-1.0F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.1642F, 0.25F, 0.0F, 0.0F, 1.5708F));
        midHang.addOrReplaceChild("Body_r32", CubeListBuilder.create().texOffs(54, 5).addBox(-1.0F, -1.0F, -1.25F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition right_arm = root.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(67, 10).addBox(-2.0F, -2.0F, -2.0F, 3.0F, 10.0F, 4.0F, new CubeDeformation(0.3F))
                .texOffs(52, 20).addBox(-2.5F, 6.75F, -2.5F, 4.0F, 1.0F, 5.0F, CubeDeformation.NONE), PartPose.offset(-5.0F, 2.0F, 0.0F));
        right_arm.addOrReplaceChild("RightArm_r1", CubeListBuilder.create().texOffs(27, 5).mirror().addBox(-1.0F, -1.0F, -1.0F, 3.0F, 2.0F, 1.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(1.5F, 0.75F, -3.0F, -0.2775F, 0.8742F, -0.6854F));
        right_arm.addOrReplaceChild("RightArm_r2", CubeListBuilder.create().texOffs(27, 5).mirror().addBox(-1.0F, -1.0F, -1.0F, 3.0F, 2.0F, 1.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(1.5F, 2.75F, -2.5F, 0.845F, 0.3772F, 0.9251F));
        right_arm.addOrReplaceChild("RightArm_r3", CubeListBuilder.create().texOffs(27, 5).mirror().addBox(-1.0F, -1.0F, -1.0F, 3.0F, 2.0F, 1.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(2.0F, 1.75F, -3.375F, 0.3109F, 0.8656F, 0.0694F));
        right_arm.addOrReplaceChild("RightArm_r4", CubeListBuilder.create().texOffs(20, 27).mirror().addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 1.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(-0.075F, 1.5F, -2.525F, -0.2386F, 0.2316F, -0.8142F));
        right_arm.addOrReplaceChild("RightArm_r5", CubeListBuilder.create().texOffs(76, 25).mirror().addBox(-3.0F, -0.5F, -2.55F, 4.0F, 5.0F, 5.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(-1.7365F, 0.7613F, 0.0F, 3.1416F, 0.0F, -2.9671F));
        right_arm.addOrReplaceChild("RightArm_r6", CubeListBuilder.create().texOffs(64, 0).mirror().addBox(-0.875F, -2.1249F, -2.8312F, 6.0F, 5.0F, 5.0F, new CubeDeformation(0.4F)).mirror(false), PartPose.offsetAndRotation(-1.15F, -0.9501F, -0.2562F, 3.1416F, 0.0F, 2.9671F));
        right_arm.addOrReplaceChild("RightArm_r7", CubeListBuilder.create().texOffs(104, 0).mirror().addBox(-0.875F, -2.1249F, -2.5812F, 6.0F, 5.0F, 5.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(-1.125F, -0.8751F, -0.0063F, 3.1416F, 0.0F, 2.9671F));
        right_arm.addOrReplaceChild("RightArm_r8", CubeListBuilder.create().texOffs(90, 0).mirror().addBox(4.125F, -2.1249F, -2.5812F, 1.0F, 5.0F, 5.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(0.9946F, -1.2224F, -0.0063F, 3.1416F, 0.0F, 2.9671F));
        right_arm.addOrReplaceChild("RightArm_r9", CubeListBuilder.create().texOffs(70, 35).mirror().addBox(-0.202F, -2.4957F, -2.9937F, 5.0F, 5.0F, 6.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(-3.375F, -1.1251F, -0.0063F, -0.0123F, -0.0065F, -0.5669F));

        PartDefinition left_arm = root.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(52, 20).mirror().addBox(-1.5F, 6.75F, -2.5F, 4.0F, 1.0F, 5.0F, CubeDeformation.NONE).mirror(false)
                .texOffs(67, 10).mirror().addBox(-1.0F, -2.0F, -2.0F, 3.0F, 10.0F, 4.0F, new CubeDeformation(0.3F)).mirror(false), PartPose.offset(5.0F, 2.0F, 0.0F));
        left_arm.addOrReplaceChild("LeftArm_r1", CubeListBuilder.create().texOffs(64, 0).addBox(-5.125F, -2.1249F, -2.8312F, 6.0F, 5.0F, 5.0F, new CubeDeformation(0.4F)), PartPose.offsetAndRotation(1.15F, -0.9501F, -0.2562F, 3.1416F, 0.0F, -2.9671F));
        left_arm.addOrReplaceChild("LeftArm_r2", CubeListBuilder.create().texOffs(104, 0).addBox(-5.125F, -2.1249F, -2.5812F, 6.0F, 5.0F, 5.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(1.125F, -0.8751F, -0.0063F, 3.1416F, 0.0F, -2.9671F));
        left_arm.addOrReplaceChild("LeftArm_r3", CubeListBuilder.create().texOffs(90, 0).addBox(-5.125F, -2.1249F, -2.5812F, 1.0F, 5.0F, 5.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-0.9946F, -1.2224F, -0.0063F, 3.1416F, 0.0F, -2.9671F));
        left_arm.addOrReplaceChild("LeftArm_r4", CubeListBuilder.create().texOffs(70, 35).addBox(-4.798F, -2.4957F, -2.9937F, 5.0F, 5.0F, 6.0F, CubeDeformation.NONE), PartPose.offsetAndRotation(3.375F, -1.1251F, -0.0063F, -0.0123F, 0.0065F, 0.5669F));
        left_arm.addOrReplaceChild("LeftArm_r5", CubeListBuilder.create().texOffs(27, 5).addBox(-2.0F, -1.0F, -1.0F, 3.0F, 2.0F, 1.0F, CubeDeformation.NONE), PartPose.offsetAndRotation(-1.5F, 0.75F, -3.0F, -0.2775F, -0.8742F, 0.6854F));
        left_arm.addOrReplaceChild("LeftArm_r6", CubeListBuilder.create().texOffs(27, 5).addBox(-2.0F, -1.0F, -1.0F, 3.0F, 2.0F, 1.0F, CubeDeformation.NONE), PartPose.offsetAndRotation(-1.5F, 2.75F, -2.5F, 0.845F, -0.3772F, -0.9251F));
        left_arm.addOrReplaceChild("LeftArm_r7", CubeListBuilder.create().texOffs(27, 5).addBox(-2.0F, -1.0F, -1.0F, 3.0F, 2.0F, 1.0F, CubeDeformation.NONE), PartPose.offsetAndRotation(-2.0F, 1.75F, -3.375F, 0.3109F, -0.8656F, -0.0694F));
        left_arm.addOrReplaceChild("LeftArm_r8", CubeListBuilder.create().texOffs(81, 10).addBox(-1.0F, -3.5F, -2.55F, 4.0F, 8.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(1.9865F, 3.7613F, 0.0F, 0.0F, 3.1416F, 0.0F));
        return LayerDefinition.create(meshdefinition, 128, 64);
    }

    @Override
    public <E extends LivingEntity> ArmorModel<E> create(ModelPart root, boolean isSlim) {
        return new ChestExaltedAurumArmorModel<>(root, isSlim);
    }

    @Override
    protected void setupArmorPartAnim(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        super.setupArmorPartAnim(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        float d = ageInTicks / 60.0F;
        this.ring.y = -13 + sinPI(d);
        this.ring.zRot = 0.1F * sinPI(d + 0.5F);
        this.leftHang.zRot = 0.4F * sinPI(d + 0.9F);
        this.leftDeco.zRot = 0.5F * sinPI(d + 1.4F);
        this.rightHang.zRot = 0.4F * sinPI(d + 1.0F);
        this.rightDeco.zRot = 0.5F * sinPI(d + 1.5F);
        this.midHang.zRot = 0.4F * sinPI(d + 0.8F);
        this.midDeco.zRot = 0.5F * sinPI(d + 1.3F);
    }
}
