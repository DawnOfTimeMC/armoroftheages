package org.dawnoftime.armoroftheages.client.models.anubis_armor;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;
import org.dawnoftime.armoroftheages.client.models.ArmorModel;

public class HeadAnubisArmorModel<T extends LivingEntity> extends ArmorModel<T> {
    private final ModelPart ribbonLeft;
    private final ModelPart ribbonRight;
    private final ModelPart earLeft;
    private final ModelPart earRight;

    public HeadAnubisArmorModel(ModelPart root, boolean isSlim) {
        super(root, isSlim);
        this.ribbonLeft = this.head.getChild("ribbonLeft");
        this.ribbonRight = this.head.getChild("ribbonRight");
        this.earLeft = this.head.getChild("earLeft");
        this.earRight = this.head.getChild("earRight");
    }

    @Override
    public <E extends LivingEntity> ArmorModel<E> create(ModelPart root, boolean isSlim) {
        return new HeadAnubisArmorModel<>(root, isSlim);
    }

    public static LayerDefinition createLayerDefinition() {
        MeshDefinition meshdefinition = templateLayerDefinition(1.0F);
        PartDefinition root = meshdefinition.getRoot();
        PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create()
                        .texOffs(96, 48).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.5F))
                        .texOffs(34, 0).addBox(-4.5F, -10.25F, -4.5F, 9.0F, 12.0F, 9.0F, new CubeDeformation(0.05F))
                        .texOffs(0, 0).addBox(-4.0F, -10.0F, -6.0F, 8.0F, 7.0F, 9.0F, CubeDeformation.NONE),
                PartPose.ZERO);

        head.addOrReplaceChild("ribbonLeft", CubeListBuilder.create()
                        .texOffs(10, 16).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 10.0F, 0.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(4.75F, -8.0F, -4.386F, 0.0F, -0.9599F, 0.0F));

        head.addOrReplaceChild("ribbonLeftNode", CubeListBuilder.create()
                        .texOffs(0, 5).addBox(0.1F, -2.1F, -0.032F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)),
                PartPose.offsetAndRotation(2.7151F, -6.9F, -4.168F, 0.0F, 0.6109F, 0.0F));

        head.addOrReplaceChild("ribbonRight", CubeListBuilder.create().mirror()
                        .texOffs(10, 16).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 10.0F, 0.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(-4.75F, -8.0F, -4.386F, 0.0F, 0.9599F, 0.0F));

        head.addOrReplaceChild("ribbonRightNode", CubeListBuilder.create().mirror()
                        .texOffs(0, 5).addBox(-2.1F, -2.1F, -0.032F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)),
                PartPose.offsetAndRotation(-2.7151F, -6.9F, -4.168F, 0.0F, -0.6109F, 0.0F));

        head.addOrReplaceChild("nose_r1", CubeListBuilder.create()
                        .texOffs(25, 0).addBox(-3.0F, 0.0F, -5.0F, 4.0F, 4.0F, 5.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(1.0F, -7.0F, -6.0F, 0.3054F, 0.0F, 0.0F));

        head.addOrReplaceChild("headLayerRight_r1", CubeListBuilder.create().mirror()
                        .texOffs(98, 0).addBox(0.05F, 0.05F, 0.04F, 3.0F, 10.0F, 4.0F, new CubeDeformation(0.05F)),
                PartPose.offsetAndRotation(-4.55F, -10.3F, -0.55F, 0.0F, 0.0F, 0.2618F));

        head.addOrReplaceChild("headLayerLeft_r1", CubeListBuilder.create()
                        .texOffs(98, 0).addBox(-3.05F, 0.05F, 0.04F, 3.0F, 10.0F, 4.0F, new CubeDeformation(0.05F)),
                PartPose.offsetAndRotation(4.55F, -10.3F, -0.55F, 0.0F, 0.0F, -0.2618F));

        head.addOrReplaceChild("earRight", CubeListBuilder.create()
                        .texOffs(0, 0).addBox(-0.7342F, -5.0323F, -1.0764F, 2.0F, 4.0F, 1.0F, CubeDeformation.NONE)
                        .texOffs(0, 16).addBox(-3.2342F, -10.5323F, -0.5764F, 5.0F, 10.0F, 0.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(-4.0F, -7.0F, -0.5F, 0.1249F, 0.2577F, -0.0465F));

        head.addOrReplaceChild("earLeft", CubeListBuilder.create().mirror()
                        .texOffs(0, 0).addBox(-1.2658F, -5.0323F, -1.0764F, 2.0F, 4.0F, 1.0F, CubeDeformation.NONE)
                        .texOffs(0, 16).addBox(-1.7658F, -10.5323F, -0.5764F, 5.0F, 10.0F, 0.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(4.0F, -7.0F, -0.5F, 0.1249F, -0.2577F, 0.0465F));

        return LayerDefinition.create(meshdefinition, 128, 64);
    }

    public static LayerDefinition createSlimLayerDefinition() {
        MeshDefinition meshdefinition = templateLayerDefinition(1.0F);
        PartDefinition root = meshdefinition.getRoot();
        PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create()
                        .texOffs(96, 48).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.5F))
                        .texOffs(34, 0).addBox(-4.5F, -10.25F, -4.5F, 9.0F, 12.0F, 9.0F, new CubeDeformation(0.05F))
                        .texOffs(0, 0).addBox(-4.0F, -10.0F, -6.0F, 8.0F, 7.0F, 9.0F, CubeDeformation.NONE),
                PartPose.ZERO);

        head.addOrReplaceChild("ribbonLeft", CubeListBuilder.create()
                        .texOffs(10, 16).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 10.0F, 0.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(4.75F, -8.0F, -4.386F, 0.0F, -0.9599F, 0.0F));

        head.addOrReplaceChild("ribbonLeftNode", CubeListBuilder.create()
                        .texOffs(0, 5).addBox(0.1F, -2.1F, -0.032F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)),
                PartPose.offsetAndRotation(2.7151F, -6.9F, -4.168F, 0.0F, 0.6109F, 0.0F));

        head.addOrReplaceChild("ribbonRight", CubeListBuilder.create().mirror()
                        .texOffs(10, 16).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 10.0F, 0.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(-4.75F, -8.0F, -4.386F, 0.0F, 0.9599F, 0.0F));

        head.addOrReplaceChild("ribbonRightNode", CubeListBuilder.create().mirror()
                        .texOffs(0, 5).addBox(-2.1F, -2.1F, -0.032F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)),
                PartPose.offsetAndRotation(-2.7151F, -6.9F, -4.168F, 0.0F, -0.6109F, 0.0F));

        head.addOrReplaceChild("nose_r1", CubeListBuilder.create()
                        .texOffs(25, 0).addBox(-3.0F, 0.0F, -5.0F, 4.0F, 4.0F, 5.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(1.0F, -7.0F, -6.0F, 0.3054F, 0.0F, 0.0F));

        head.addOrReplaceChild("headLayerRight_r1", CubeListBuilder.create().mirror()
                        .texOffs(98, 0).addBox(0.05F, 0.05F, 0.04F, 3.0F, 10.0F, 4.0F, new CubeDeformation(0.05F)),
                PartPose.offsetAndRotation(-4.55F, -10.3F, -0.55F, 0.0F, 0.0F, 0.2618F));

        head.addOrReplaceChild("headLayerLeft_r1", CubeListBuilder.create()
                        .texOffs(98, 0).addBox(-3.05F, 0.05F, 0.04F, 3.0F, 10.0F, 4.0F, new CubeDeformation(0.05F)),
                PartPose.offsetAndRotation(4.55F, -10.3F, -0.55F, 0.0F, 0.0F, -0.2618F));

        head.addOrReplaceChild("earRight", CubeListBuilder.create()
                        .texOffs(0, 0).addBox(-0.7342F, -5.0323F, -1.0764F, 2.0F, 4.0F, 1.0F, CubeDeformation.NONE)
                        .texOffs(0, 16).addBox(-3.2342F, -10.5323F, -0.5764F, 5.0F, 10.0F, 0.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(-4.0F, -7.0F, -0.5F, 0.1681F, 0.2322F, 0.1315F));

        head.addOrReplaceChild("earLeft", CubeListBuilder.create().mirror()
                        .texOffs(0, 0).addBox(-1.2658F, -5.0323F, -1.0764F, 2.0F, 4.0F, 1.0F, CubeDeformation.NONE)
                        .texOffs(0, 16).addBox(-1.7658F, -10.5323F, -0.5764F, 5.0F, 10.0F, 0.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(4.0F, -7.0F, -0.5F, 0.1681F, -0.2322F, -0.1315F));

        return LayerDefinition.create(meshdefinition, 128, 64);
    }

    @Override
    protected void setupArmorPartAnim(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        float rh = 0.1F * sinPI(ageInTicks / 35.0F);
        if(this.isSlim){
            this.earRight.setRotation(0.1249F + rh, 0.2577F, -0.0465F);
            this.earLeft.setRotation(0.1249F + rh, -0.2577F, 0.0465F);
        }else{
            this.earRight.setRotation(0.1681F + rh, 0.2322F, 0.1315F);
            this.earLeft.setRotation(0.1681F + rh, -0.2322F, -0.1315F);
        }
        rh = 0.05F * sinPI((ageInTicks - 15) / 50.0F);
        this.ribbonRight.zRot = rh;
        this.ribbonLeft.zRot = -rh;
    }
}
