package org.dawnoftime.armoroftheages.client.models.raijin_armor;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;
import org.dawnoftime.armoroftheages.client.models.ArmorModel;

public class HeadRaijinArmorModel<T extends LivingEntity> extends ArmorModel<T> {
    private final ModelPart flyA;
    private final ModelPart flyB;
    private final ModelPart flyC;
    private final ModelPart flyD;
    private final ModelPart flyE;
    private final ModelPart flyF;

    public HeadRaijinArmorModel(ModelPart root, boolean isSlim) {
        super(root, isSlim);
        this.flyA = this.body.getChild("flyA");
        this.flyB = this.body.getChild("flyB");
        this.flyC = this.body.getChild("flyC");
        this.flyD = this.body.getChild("flyD");
        this.flyE = this.body.getChild("flyE");
        this.flyF = this.body.getChild("flyF");
    }

    @Override
    public <E extends LivingEntity> ArmorModel<E> create(ModelPart root, boolean isSlim) {
        return new HeadRaijinArmorModel<>(root, isSlim);
    }

    public static LayerDefinition createLayerDefinition() {
        MeshDefinition meshdefinition = templateLayerDefinition(1.0F);
        PartDefinition root = meshdefinition.getRoot();
        PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create(),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition headHornLeftA = head.addOrReplaceChild("headHornLeftA", CubeListBuilder.create()
                        .texOffs(0, 0).addBox(-0.5F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.2F)),
                PartPose.offsetAndRotation(2.5F, -6.5F, -5.0F, -0.2618F, 0.0F, 0.1745F));

        headHornLeftA.addOrReplaceChild("headHornLeftB", CubeListBuilder.create()
                        .texOffs(15, 0).addBox(-0.5F, -5.0F, -3.0F, 1.0F, 4.0F, 1.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.2217F, 0.0F, 0.0F));

        headHornLeftA.addOrReplaceChild("headHornLeftC", CubeListBuilder.create()
                        .texOffs(30, 0).addBox(-0.5F, -3.0F, 2.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.1F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.0472F, 0.0F, 0.0F));

        headHornLeftA.addOrReplaceChild("headHornLeftD", CubeListBuilder.create()
                        .texOffs(0, 0).addBox(-0.5F, -8.0F, 0.8F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.1F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.5236F, 0.0F, 0.0F));

        PartDefinition headHornRightA = head.addOrReplaceChild("headHornRightA", CubeListBuilder.create()
                        .texOffs(0, 0).addBox(-0.5F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.2F)),
                PartPose.offsetAndRotation(-2.5F, -6.5F, -5.0F, -0.2618F, 0.0F, -0.1745F));

        headHornRightA.addOrReplaceChild("headHornRightB", CubeListBuilder.create()
                        .texOffs(15, 0).addBox(-0.5F, -5.0F, -3.0F, 1.0F, 4.0F, 1.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.2217F, 0.0F, 0.0F));

        headHornRightA.addOrReplaceChild("headHornRightC", CubeListBuilder.create()
                        .texOffs(30, 0).addBox(-0.5F, -3.0F, 2.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.1F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.0472F, 0.0F, 0.0F));

        headHornRightA.addOrReplaceChild("headHornRightD", CubeListBuilder.create()
                        .texOffs(0, 0).addBox(-0.5F, -8.0F, 0.8F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.1F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.5236F, 0.0F, 0.0F));

        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.ZERO);
        
        body.addOrReplaceChild("flyA", CubeListBuilder.create()
                        .texOffs(45, 0).addBox(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 2.0F, CubeDeformation.NONE),
                PartPose.offset(-5.0F, -15.0F, 3.0F));

        body.addOrReplaceChild("flyB", CubeListBuilder.create()
                        .texOffs(45, 0).addBox(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 2.0F, CubeDeformation.NONE),
                PartPose.offset(5.0F, -15.0F, 3.0F));

        body.addOrReplaceChild("flyC", CubeListBuilder.create()
                        .texOffs(45, 0).addBox(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 2.0F, CubeDeformation.NONE),
                PartPose.offset(-11.0F, -7.5F, 3.0F));

        body.addOrReplaceChild("flyD", CubeListBuilder.create()
                        .texOffs(45, 0).addBox(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 2.0F, CubeDeformation.NONE),
                PartPose.offset(11.0F, -7.5F, 3.0F));

        body.addOrReplaceChild("flyE", CubeListBuilder.create()
                        .texOffs(45, 0).addBox(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 2.0F, CubeDeformation.NONE),
                PartPose.offset(-9.0F, 2.0F, 3.0F));

        body.addOrReplaceChild("flyF", CubeListBuilder.create()
                        .texOffs(45, 0).addBox(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 2.0F, CubeDeformation.NONE),
                PartPose.offset(9.0F, 2.0F, 3.0F));
        
        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    public static LayerDefinition createSlimLayerDefinition() {
        MeshDefinition meshdefinition = templateLayerDefinition(1.0F);
        PartDefinition root = meshdefinition.getRoot();
        PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create(),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition headHornLeftA = head.addOrReplaceChild("headHornLeftA", CubeListBuilder.create()
                        .texOffs(0, 0).addBox(-0.5F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.2F)),
                PartPose.offsetAndRotation(2.5F, -6.5F, -5.0F, -0.2618F, 0.0F, 0.1745F));

        headHornLeftA.addOrReplaceChild("headHornLeftB", CubeListBuilder.create()
                        .texOffs(15, 0).addBox(-0.5F, -5.0F, -3.0F, 1.0F, 4.0F, 1.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.2217F, 0.0F, 0.0F));

        headHornLeftA.addOrReplaceChild("headHornLeftC", CubeListBuilder.create()
                        .texOffs(30, 0).addBox(-0.5F, -3.0F, 2.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.1F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.0472F, 0.0F, 0.0F));

        headHornLeftA.addOrReplaceChild("headHornLeftD", CubeListBuilder.create()
                        .texOffs(0, 0).addBox(-0.5F, -8.0F, 0.8F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.1F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.5236F, 0.0F, 0.0F));

        PartDefinition headHornRightA = head.addOrReplaceChild("headHornRightA", CubeListBuilder.create()
                        .texOffs(0, 0).addBox(-0.5F, -3.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.2F)),
                PartPose.offsetAndRotation(-2.5F, -6.5F, -5.0F, -0.2618F, 0.0F, -0.1745F));

        headHornRightA.addOrReplaceChild("headHornRightB", CubeListBuilder.create()
                        .texOffs(15, 0).addBox(-0.5F, -5.0F, -3.0F, 1.0F, 4.0F, 1.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.2217F, 0.0F, 0.0F));

        headHornRightA.addOrReplaceChild("headHornRightC", CubeListBuilder.create()
                        .texOffs(30, 0).addBox(-0.5F, -3.0F, 2.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.1F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.0472F, 0.0F, 0.0F));

        headHornRightA.addOrReplaceChild("headHornRightD", CubeListBuilder.create()
                        .texOffs(0, 0).addBox(-0.5F, -8.0F, 0.8F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.1F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.5236F, 0.0F, 0.0F));

        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.ZERO);

        body.addOrReplaceChild("flyA", CubeListBuilder.create()
                        .texOffs(45, 0).addBox(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offset(-4.5F, -15.0F, 3.0F));

        body.addOrReplaceChild("flyB", CubeListBuilder.create()
                        .texOffs(45, 0).addBox(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offset(4.5F, -15.0F, 3.0F));

        body.addOrReplaceChild("flyC", CubeListBuilder.create()
                        .texOffs(45, 0).addBox(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offset(-10.0F, -7.5F, 3.0F));

        body.addOrReplaceChild("flyD", CubeListBuilder.create()
                        .texOffs(45, 0).addBox(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offset(10.0F, -7.5F, 3.0F));

        body.addOrReplaceChild("flyE", CubeListBuilder.create()
                        .texOffs(45, 0).addBox(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offset(-8.0F, 2.0F, 3.0F));

        body.addOrReplaceChild("flyF", CubeListBuilder.create()
                        .texOffs(45, 0).addBox(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offset(8.0F, 2.0F, 3.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    protected void setupArmorPartAnim(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        float d = ageInTicks / 60.0F;
        float f = d % (2.0F * (float)Math.PI);
        this.flyA.y = -15.0F + sinPI(d + 1.0F);
        this.flyA.zRot = f;
        this.flyB.y = -15.0F + sinPI(d + 1.333F);
        this.flyB.zRot = f + 0.33F;
        this.flyC.y = -7.5F + sinPI(d + 1.667F);
        this.flyC.zRot = f + 0.67F;
        this.flyD.y = -7.5F + sinPI(d + 0.333F);
        this.flyD.zRot = f + 0.17F;
        this.flyE.y = 2.0F + sinPI(d);
        this.flyE.zRot = f + 0.83F;
        this.flyF.y = 2.0F + sinPI(d + 0.667F);
        this.flyF.zRot = f + 0.5F;
    }
}
