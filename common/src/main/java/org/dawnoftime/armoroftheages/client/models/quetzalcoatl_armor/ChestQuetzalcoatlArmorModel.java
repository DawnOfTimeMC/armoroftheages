package org.dawnoftime.armoroftheages.client.models.quetzalcoatl_armor;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;
import org.dawnoftime.armoroftheages.client.models.ArmorModel;

public class ChestQuetzalcoatlArmorModel<T extends LivingEntity> extends ArmorModel<T> {
    private final ModelPart tail;
    private final ModelPart tailTip;
    private final ModelPart armFeather;
    private final ModelPart neckStart;
    private final ModelPart neckEnd;
    private final ModelPart snakeHead;
    private final ModelPart jow;
    private final ModelPart snakeCrownRight;
    private final ModelPart snakeCrownLeft;

    public ChestQuetzalcoatlArmorModel(ModelPart root, boolean isSlim) {
        super(root, isSlim);
        this.tail = this.body.getChild("tail");
        this.tailTip = this.tail.getChild("tailTip");
        this.armFeather = this.leftArm.getChild("armFeather");
        this.neckStart = this.body.getChild("neckStart");
        this.neckEnd = this.neckStart.getChild("neckEnd");
        this.snakeHead = this.neckEnd.getChild("snakeHead");
        this.jow = this.snakeHead.getChild("jow");
        this.snakeCrownRight = this.snakeHead.getChild("snakeCrownRight");
        this.snakeCrownLeft = this.snakeHead.getChild("snakeCrownLeft");
    }

    @Override
    public <E extends LivingEntity> ArmorModel<E> create(ModelPart root, boolean isSlim) {
        return new ChestQuetzalcoatlArmorModel<>(root, isSlim);
    }

    public static LayerDefinition createLayerDefinition() {
        MeshDefinition meshdefinition = templateLayerDefinition(1.0F);
        PartDefinition root = meshdefinition.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                        .texOffs(0, 20)
                        .addBox(-4.0F, -0.5F, -2.5F, 8.0F, 4.0F, 5.0F, CubeDeformation.NONE),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        body.addOrReplaceChild("snakeA", CubeListBuilder.create()
                        .texOffs(50, 19)
                        .addBox(-6.0F, 0.0F, -3.0F, 3.0F, 3.0F, 5.0F, CubeDeformation.NONE)
                        .texOffs(76, 0)
                        .addBox(-6.0F, 0.0F, 2.0F, 12.0F, 3.0F, 3.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(-0.67F, 0.2454F, -1.0F, 0.0F, 0.0F, 0.4363F));

        body.addOrReplaceChild("snakeB", CubeListBuilder.create()
                        .texOffs(85, 11)
                        .addBox(3.5F, 2.5F, -3.25F, 3.0F, 3.0F, 7.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(2.6523F, -0.9639F, 0.25F, 0.0F, 0.0F, 0.4363F));

        body.addOrReplaceChild("snakeC", CubeListBuilder.create()
                        .texOffs(98, 10)
                        .addBox(3.5F, -2.5F, -3.0F, 3.0F, 5.0F, 3.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(2.6523F, -0.9639F, 0.0F, 0.0F, 0.0F, 0.4363F));

        body.addOrReplaceChild("snakeD", CubeListBuilder.create()
                        .texOffs(114, 18)
                        .addBox(3.25F, -5.5F, -3.5F, 3.0F, 4.0F, 3.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(3.0428F, 1.4415F, -2.6225F, -1.0308F, -0.0415F, 0.1632F));

        PartDefinition neckStart = body.addOrReplaceChild("neckStart", CubeListBuilder.create()
                        .texOffs(102, 18)
                        .addBox(-1.3977F, -6.9113F, -2.4979F, 3.0F, 7.0F, 3.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(8.0F, -1.25F, 1.5F, -0.6929F, 0.0315F, 0.1992F));

        PartDefinition neckEnd = neckStart.addOrReplaceChild("neckEnd", CubeListBuilder.create()
                        .texOffs(110, 10)
                        .addBox(-1.5F, -5.0F, -2.25F, 3.0F, 5.0F, 3.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(-0.0551F, -6.6055F, -0.1796F, 0.9904F, 0.0148F, -0.0067F));

        neckEnd.addOrReplaceChild("featherA", CubeListBuilder.create()
                        .texOffs(100, 0)
                        .addBox(-0.2694F, -0.4602F, -2.4251F, 4.0F, 4.0F, 6.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(-0.1511F, -1.337F, 1.1273F, -1.078F, 0.7476F, 0.3405F));

        neckEnd.addOrReplaceChild("featherB", CubeListBuilder.create()
                        .texOffs(68, 6)
                        .addBox(0.5858F, 0.3358F, 0.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(-0.25F)),
                PartPose.offsetAndRotation(-0.1511F, -6.337F, 1.1273F, -0.5992F, 0.4909F, 0.6321F));

        PartDefinition snakeHead = neckEnd.addOrReplaceChild("snakeHead", CubeListBuilder.create()
                        .texOffs(61, 19).mirror()
                        .addBox(-1.9512F, -1.3244F, -7.3903F, 4.0F, 1.0F, 4.0F, CubeDeformation.NONE)
                        .texOffs(86, 6)
                        .addBox(-1.4512F, -0.5744F, -6.8903F, 3.0F, 1.0F, 4.0F, CubeDeformation.NONE)
                        .texOffs(52, 5)
                        .addBox(-1.9512F, -3.3244F, -3.3903F, 4.0F, 4.0F, 4.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(-0.1999F, -5.0126F, -0.4824F, 0.1176F, 0.0076F, -0.0741F));

        snakeHead.addOrReplaceChild("snakeCrownLeft", CubeListBuilder.create()
                        .texOffs(26, 7)
                        .addBox(-7.0F, 0.0F, 0.0F, 7.0F, 12.0F, 0.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(0.0488F, -8.0026F, 2.1767F, -2.5831F, 0.3378F, -2.9374F));

        snakeHead.addOrReplaceChild("snakeCrownRight", CubeListBuilder.create()
                        .texOffs(26, 7)
                        .addBox(-7.0F, 0.0F, 0.0F, 7.0F, 12.0F, 0.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(0.0488F, -8.0026F, 2.1767F, -0.5585F, 0.3378F, -0.2042F));

        snakeHead.addOrReplaceChild("featherC", CubeListBuilder.create()
                        .texOffs(68, 6)
                        .addBox(-0.1642F, -0.1642F, -2.0F, 6.0F, 6.0F, 6.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(0.0488F, -1.3244F, 1.6097F, -0.5992F, 0.4909F, 0.6321F));

        snakeHead.addOrReplaceChild("featherD", CubeListBuilder.create()
                        .texOffs(68, 6)
                        .addBox(0.25F, 0.25F, -2.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.25F)),
                PartPose.offsetAndRotation(0.0488F, -3.3244F, 1.6097F, 0.0F, 0.0F, 0.7854F));

        snakeHead.addOrReplaceChild("featherE", CubeListBuilder.create()
                        .texOffs(68, 6)
                        .addBox(-0.2324F, -0.25F, -0.3181F, 6.0F, 6.0F, 6.0F, new CubeDeformation(-0.25F)),
                PartPose.offsetAndRotation(0.0488F, -3.3244F, -0.3903F, 0.4711F, -0.3981F, 0.6996F));

        snakeHead.addOrReplaceChild("headA", CubeListBuilder.create()
                        .texOffs(120, 6)
                        .addBox(-4.9F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)),
                PartPose.offsetAndRotation(3.4488F, -1.28F, -6.2866F, -0.1309F, 0.0F, 0.0F));

        snakeHead.addOrReplaceChild("headB", CubeListBuilder.create()
                        .texOffs(114, 0)
                        .addBox(-3.5F, 0.0F, -4.0F, 3.0F, 2.0F, 4.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(2.0488F, -3.3244F, -3.3903F, 0.3491F, 0.0F, 0.0F));

        snakeHead.addOrReplaceChild("headC", CubeListBuilder.create()
                        .texOffs(68, 8)
                        .addBox(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 2.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(-2.4204F, -3.6286F, -3.8423F, 0.2236F, 0.1398F, 0.224F));

        snakeHead.addOrReplaceChild("headD", CubeListBuilder.create()
                        .texOffs(68, 5)
                        .addBox(-1.75F, -1.35F, -0.5F, 1.0F, 1.0F, 2.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(-0.4512F, -1.8244F, -3.8903F, 0.2589F, -0.5398F, 0.0571F));

        snakeHead.addOrReplaceChild("headE", CubeListBuilder.create()
                        .texOffs(119, 8)
                        .addBox(-0.45F, -1.75F, -1.8F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.25F)),
                PartPose.offsetAndRotation(-1.9512F, -1.3244F, -3.3903F, 0.0F, -0.2618F, 0.0F));

        snakeHead.addOrReplaceChild("headF", CubeListBuilder.create()
                        .texOffs(68, 8).mirror()
                        .addBox(-1.0F, 0.0F, 0.0F, 1.0F, 2.0F, 2.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(2.5179F, -3.6286F, -3.8423F, 0.2236F, -0.1398F, -0.224F));

        snakeHead.addOrReplaceChild("headG", CubeListBuilder.create()
                        .texOffs(68, 5).mirror()
                        .addBox(0.75F, -1.35F, -0.5F, 1.0F, 1.0F, 2.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(0.5488F, -1.8244F, -3.8903F, 0.2589F, 0.5398F, -0.0571F));

        snakeHead.addOrReplaceChild("headH", CubeListBuilder.create()
                        .texOffs(119, 8).mirror()
                        .addBox(-1.55F, -1.75F, -1.8F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.25F)),
                PartPose.offsetAndRotation(2.0488F, -1.3244F, -3.3903F, 0.0F, 0.2618F, 0.0F));

        snakeHead.addOrReplaceChild("jow", CubeListBuilder.create()
                        .texOffs(73, 18).mirror()
                        .addBox(-3.4471F, 0.7487F, -5.805F, 4.0F, 1.0F, 4.0F, CubeDeformation.NONE)
                        .texOffs(86, 6)
                        .addBox(-2.9471F, -0.0013F, -5.305F, 3.0F, 1.0F, 4.0F, CubeDeformation.NONE)
                        .texOffs(52, 13)
                        .addBox(-3.9471F, -1.2513F, -1.805F, 5.0F, 3.0F, 3.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(1.4959F, 0.4269F, -1.5853F, 0.1309F, 0.0F, 0.0F));

        PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create()
                        .texOffs(87, 21)
                        .addBox(0.0F, 0.0F, 0.0F, 2.0F, 6.0F, 2.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(-6.9225F, 0.0F, -3.5F, 0.0F, 0.0F, 0.2182F));

        PartDefinition tailTip = tail.addOrReplaceChild("tailTip", CubeListBuilder.create(),
                PartPose.offset(0.5F, 6.0F, 0.5F));

        tailTip.addOrReplaceChild("tailTipFeather", CubeListBuilder.create()
                        .texOffs(20, 33)
                        .addBox(1.0F, 0.0F, -1.0F, 0.0F, 9.0F, 3.0F, CubeDeformation.NONE)
                        .texOffs(96, 21)
                        .addBox(-0.5F, 0.0F, 0.5F, 3.0F, 9.0F, 0.0F, CubeDeformation.NONE)
                        .texOffs(122, 12)
                        .addBox(0.5F, 0.0F, 0.0F, 1.0F, 5.0F, 1.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(-0.5F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3491F));

        body.addOrReplaceChild("necklaceJewel", CubeListBuilder.create()
                        .texOffs(21, 20)
                        .addBox(-1.5F, -1.5F, -0.5F, 3.0F, 3.0F, 1.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(0.0F, 3.0F, -2.5F, 0.0F, 0.0F, -0.7854F));

        PartDefinition rightArm = root.addOrReplaceChild("right_arm", CubeListBuilder.create()
                        .texOffs(30, 19)
                        .addBox(-3.5F, 0.5F, -2.5F, 5.0F, 2.0F, 5.0F, new CubeDeformation(0.1F)),
                PartPose.offset(-5.0F, 2.0F, 0.0F));

        rightArm.addOrReplaceChild("shoulderRightProtection", CubeListBuilder.create()
                        .texOffs(20, 24)
                        .addBox(-0.5F, -5.25F, -0.4F, 2.0F, 6.0F, 6.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(-3.6F, 0.4F, -2.6F, 0.0F, 0.0F, -0.1745F));

        PartDefinition leftArm = root.addOrReplaceChild("left_arm", CubeListBuilder.create()
                        .texOffs(0, 29).mirror(true)
                        .addBox(-1.5F, 5.5F, -2.5F, 5.0F, 3.0F, 5.0F, new CubeDeformation(0.1F)),
                PartPose.offset(5.0F, 2.0F, 0.0F));

        leftArm.addOrReplaceChild("leftArmJewel", CubeListBuilder.create()
                        .texOffs(29, 20)
                        .addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(3.5F, 7.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

        leftArm.addOrReplaceChild("armFeather", CubeListBuilder.create()
                        .texOffs(36, 19)
                        .addBox(0.15F, -5.0F, -3.5F, 0.0F, 10.0F, 7.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(3.75F, 5.5F, 1.0F, 0.0F, 0.0873F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 64);
    }

    public static LayerDefinition createSlimLayerDefinition() {
        MeshDefinition meshdefinition = templateLayerDefinition(1.0F);
        PartDefinition root = meshdefinition.getRoot();

        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                        .texOffs(0, 20)
                        .addBox(-4.0F, -0.5F, -2.5F, 8.0F, 4.0F, 5.0F, CubeDeformation.NONE),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        body.addOrReplaceChild("snakeA", CubeListBuilder.create()
                        .texOffs(50, 19)
                        .addBox(-6.0F, 0.0F, -3.0F, 3.0F, 3.0F, 5.0F, CubeDeformation.NONE)
                        .texOffs(76, 0)
                        .addBox(-6.0F, 0.0F, 2.0F, 12.0F, 3.0F, 3.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(-0.67F, 0.2454F, -1.0F, 0.0F, 0.0F, 0.4363F));

        body.addOrReplaceChild("snakeB", CubeListBuilder.create()
                        .texOffs(85, 11)
                        .addBox(3.5F, 2.5F, -3.25F, 3.0F, 3.0F, 7.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(2.6523F, -0.9639F, 0.25F, 0.0F, 0.0F, 0.4363F));

        body.addOrReplaceChild("snakeC", CubeListBuilder.create()
                        .texOffs(98, 10)
                        .addBox(3.5F, -2.5F, -3.0F, 3.0F, 5.0F, 3.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(2.6523F, -0.9639F, 0.0F, 0.0F, 0.0F, 0.4363F));

        body.addOrReplaceChild("snakeD", CubeListBuilder.create()
                        .texOffs(114, 18)
                        .addBox(3.25F, -5.5F, -3.5F, 3.0F, 4.0F, 3.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(3.0428F, 1.4415F, -2.6225F, -1.0308F, -0.0415F, 0.1632F));

        PartDefinition neckStart = body.addOrReplaceChild("neckStart", CubeListBuilder.create()
                        .texOffs(102, 18)
                        .addBox(-1.3977F, -6.9113F, -2.4979F, 3.0F, 7.0F, 3.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(8.0F, -1.25F, 1.5F, -0.6929F, 0.0315F, 0.1992F));

        PartDefinition neckEnd = neckStart.addOrReplaceChild("neckEnd", CubeListBuilder.create()
                        .texOffs(110, 10)
                        .addBox(-1.5F, -5.0F, -2.25F, 3.0F, 5.0F, 3.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(-0.0551F, -6.6055F, -0.1796F, 0.9904F, 0.0148F, -0.0067F));

        neckEnd.addOrReplaceChild("featherA", CubeListBuilder.create()
                        .texOffs(100, 0)
                        .addBox(-0.2694F, -0.4602F, -2.4251F, 4.0F, 4.0F, 6.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(-0.1511F, -1.337F, 1.1273F, -1.078F, 0.7476F, 0.3405F));

        neckEnd.addOrReplaceChild("featherB", CubeListBuilder.create()
                        .texOffs(68, 6)
                        .addBox(0.5858F, 0.3358F, 0.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(-0.25F)),
                PartPose.offsetAndRotation(-0.1511F, -6.337F, 1.1273F, -0.5992F, 0.4909F, 0.6321F));

        PartDefinition snakeHead = neckEnd.addOrReplaceChild("snakeHead", CubeListBuilder.create()
                        .texOffs(61, 19).mirror()
                        .addBox(-1.9512F, -1.3244F, -7.3903F, 4.0F, 1.0F, 4.0F, CubeDeformation.NONE)
                        .texOffs(86, 6)
                        .addBox(-1.4512F, -0.5744F, -6.8903F, 3.0F, 1.0F, 4.0F, CubeDeformation.NONE)
                        .texOffs(52, 5)
                        .addBox(-1.9512F, -3.3244F, -3.3903F, 4.0F, 4.0F, 4.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(-0.1999F, -5.0126F, -0.4824F, 0.1176F, 0.0076F, -0.0741F));

        snakeHead.addOrReplaceChild("snakeCrownLeft", CubeListBuilder.create()
                        .texOffs(26, 7)
                        .addBox(-7.0F, 0.0F, 0.0F, 7.0F, 12.0F, 0.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(0.0488F, -8.0026F, 2.1767F, -2.5831F, 0.3378F, -2.9374F));

        snakeHead.addOrReplaceChild("snakeCrownRight", CubeListBuilder.create()
                        .texOffs(26, 7)
                        .addBox(-7.0F, 0.0F, 0.0F, 7.0F, 12.0F, 0.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(0.0488F, -8.0026F, 2.1767F, -0.5585F, 0.3378F, -0.2042F));

        snakeHead.addOrReplaceChild("featherC", CubeListBuilder.create()
                        .texOffs(68, 6)
                        .addBox(-0.1642F, -0.1642F, -2.0F, 6.0F, 6.0F, 6.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(0.0488F, -1.3244F, 1.6097F, -0.5992F, 0.4909F, 0.6321F));

        snakeHead.addOrReplaceChild("featherD", CubeListBuilder.create()
                        .texOffs(68, 6)
                        .addBox(0.25F, 0.25F, -2.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.25F)),
                PartPose.offsetAndRotation(0.0488F, -3.3244F, 1.6097F, 0.0F, 0.0F, 0.7854F));

        snakeHead.addOrReplaceChild("featherE", CubeListBuilder.create()
                        .texOffs(68, 6)
                        .addBox(-0.2324F, -0.25F, -0.3181F, 6.0F, 6.0F, 6.0F, new CubeDeformation(-0.25F)),
                PartPose.offsetAndRotation(0.0488F, -3.3244F, -0.3903F, 0.4711F, -0.3981F, 0.6996F));

        snakeHead.addOrReplaceChild("headA", CubeListBuilder.create()
                        .texOffs(120, 6)
                        .addBox(-4.9F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.1F)),
                PartPose.offsetAndRotation(3.4488F, -1.28F, -6.2866F, -0.1309F, 0.0F, 0.0F));

        snakeHead.addOrReplaceChild("headB", CubeListBuilder.create()
                        .texOffs(114, 0)
                        .addBox(-3.5F, 0.0F, -4.0F, 3.0F, 2.0F, 4.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(2.0488F, -3.3244F, -3.3903F, 0.3491F, 0.0F, 0.0F));

        snakeHead.addOrReplaceChild("headC", CubeListBuilder.create()
                        .texOffs(68, 8)
                        .addBox(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 2.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(-2.4204F, -3.6286F, -3.8423F, 0.2236F, 0.1398F, 0.224F));

        snakeHead.addOrReplaceChild("headD", CubeListBuilder.create()
                        .texOffs(68, 5)
                        .addBox(-1.75F, -1.35F, -0.5F, 1.0F, 1.0F, 2.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(-0.4512F, -1.8244F, -3.8903F, 0.2589F, -0.5398F, 0.0571F));

        snakeHead.addOrReplaceChild("headE", CubeListBuilder.create()
                        .texOffs(119, 8)
                        .addBox(-0.45F, -1.75F, -1.8F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.25F)),
                PartPose.offsetAndRotation(-1.9512F, -1.3244F, -3.3903F, 0.0F, -0.2618F, 0.0F));

        snakeHead.addOrReplaceChild("headF", CubeListBuilder.create()
                        .texOffs(68, 8).mirror()
                        .addBox(-1.0F, 0.0F, 0.0F, 1.0F, 2.0F, 2.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(2.5179F, -3.6286F, -3.8423F, 0.2236F, -0.1398F, -0.224F));

        snakeHead.addOrReplaceChild("headG", CubeListBuilder.create()
                        .texOffs(68, 5).mirror()
                        .addBox(0.75F, -1.35F, -0.5F, 1.0F, 1.0F, 2.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(0.5488F, -1.8244F, -3.8903F, 0.2589F, 0.5398F, -0.0571F));

        snakeHead.addOrReplaceChild("headH", CubeListBuilder.create()
                        .texOffs(119, 8).mirror()
                        .addBox(-1.55F, -1.75F, -1.8F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.25F)),
                PartPose.offsetAndRotation(2.0488F, -1.3244F, -3.3903F, 0.0F, 0.2618F, 0.0F));

        snakeHead.addOrReplaceChild("jow", CubeListBuilder.create()
                        .texOffs(73, 18).mirror()
                        .addBox(-3.4471F, 0.7487F, -5.805F, 4.0F, 1.0F, 4.0F, CubeDeformation.NONE)
                        .texOffs(86, 6)
                        .addBox(-2.9471F, -0.0013F, -5.305F, 3.0F, 1.0F, 4.0F, CubeDeformation.NONE)
                        .texOffs(52, 13)
                        .addBox(-3.9471F, -1.2513F, -1.805F, 5.0F, 3.0F, 3.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(1.4959F, 0.4269F, -1.5853F, 0.1309F, 0.0F, 0.0F));

        PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create()
                        .texOffs(87, 21)
                        .addBox(0.0F, 0.0F, 0.0F, 2.0F, 6.0F, 2.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(-6.9225F, 0.0F, -3.5F, 0.0F, 0.0F, 0.2182F));

        PartDefinition tailTip = tail.addOrReplaceChild("tailTip", CubeListBuilder.create(),
                PartPose.offset(0.5F, 6.0F, 0.5F));

        tailTip.addOrReplaceChild("tailTipFeather", CubeListBuilder.create()
                        .texOffs(20, 33)
                        .addBox(1.0F, 0.0F, -1.0F, 0.0F, 9.0F, 3.0F, CubeDeformation.NONE)
                        .texOffs(96, 21)
                        .addBox(-0.5F, 0.0F, 0.5F, 3.0F, 9.0F, 0.0F, CubeDeformation.NONE)
                        .texOffs(122, 12)
                        .addBox(0.5F, 0.0F, 0.0F, 1.0F, 5.0F, 1.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(-0.5F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3491F));

        body.addOrReplaceChild("chestBreast", CubeListBuilder.create()
                        .texOffs(26, 40)
                        .addBox(-3.5F, -1.75F, 0.0F, 7.0F, 4.0F, 2.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(0.0F, 2.0F, -3.0F, -0.48F, 0.0F, 0.0F));

        body.addOrReplaceChild("necklaceJewel", CubeListBuilder.create()
                        .texOffs(21, 20)
                        .addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 1.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(0.0F, 3.0F, -2.5F, -0.3527F, 0.3326F, 0.7256F));

        PartDefinition rightArm = root.addOrReplaceChild("right_arm", CubeListBuilder.create()
                        .texOffs(30, 19)
                        .addBox(-2.5F, 0.5F, -2.5F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.1F)),
                PartPose.offset(-5.0F, 2.0F, 0.0F));

        rightArm.addOrReplaceChild("shoulderRightProtection", CubeListBuilder.create()
                        .texOffs(20, 24)
                        .addBox(0.5F, -5.25F, -0.4F, 2.0F, 6.0F, 6.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(-3.6F, 0.4F, -2.6F, 0.0F, 0.0F, -0.1745F));

        PartDefinition leftArm = root.addOrReplaceChild("left_arm", CubeListBuilder.create()
                        .texOffs(0, 29).mirror(true)
                        .addBox(-1.5F, 5.5F, -2.5F, 4.0F, 3.0F, 5.0F, new CubeDeformation(0.1F)),
                PartPose.offset(5.0F, 2.0F, 0.0F));

        leftArm.addOrReplaceChild("leftArmJewel", CubeListBuilder.create()
                        .texOffs(29, 20)
                        .addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(2.5F, 7.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

        leftArm.addOrReplaceChild("armFeather", CubeListBuilder.create()
                        .texOffs(36, 19)
                        .addBox(0.15F, -5.0F, -3.5F, 0.0F, 10.0F, 7.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(2.75F, 5.5F, 1.0F, 0.0F, 0.0873F, 0.0F));
        return LayerDefinition.create(meshdefinition, 128, 64);
    }

    @Override
    protected void setupArmorPartAnim(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        float rA = sinPI(ageInTicks / 40.0F);
        float rB = sinPI((ageInTicks - 15) / 40.0F);
        this.tail.xRot = this.rightArm.xRot < 0.0F ? this.rightArm.xRot : this.rightArm.xRot * 0.1F;
        this.tail.zRot = 0.2182F + 0.1F * rA;
        this.tailTip.zRot = 0.1F * rB;
        this.armFeather.zRot = -0.05F * rB;
        this.armFeather.xRot = 0.1F * rB;
        this.neckStart.xRot = -0.3F + 0.2F * rA;
        this.neckStart.zRot = 0.2F + 0.04F * rB;
        this.neckEnd.xRot = 0.6F + 0.1F * rB;
        this.snakeHead.xRot = -0.2F * rB + 0.02F * headPitch;
        this.snakeHead.yRot = 0.02F * netHeadYaw;
        this.jow.xRot = 0.13F + 0.1F * rA;
        this.snakeCrownRight.yRot = 0.3378F + 0.1F * rB;
        this.snakeCrownLeft.yRot = 0.3378F - 0.1F * rB;
    }
}
