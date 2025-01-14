package org.dawnoftime.armoroftheages.client.models.exalted_aurum;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;
import org.dawnoftime.armoroftheages.client.models.ArmorModel;

public class HeadExaltedAurumArmorModel<T extends LivingEntity> extends ArmorModel<T> {

    public HeadExaltedAurumArmorModel(ModelPart root, boolean isSlim) {
        super(root, isSlim);
    }

    public static LayerDefinition createLayerDefinition() {
        MeshDefinition meshdefinition = templateLayerDefinition(1.0F);
        PartDefinition root = meshdefinition.getRoot();
        PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create()
                        .texOffs(0, 15).addBox(-4.5F, -8.5F, -4.5F, 9.0F, 3.0F, 9.0F, new CubeDeformation(0.1F))
                        .texOffs(27, 6).addBox(-4.5F, -6.5F, -4.5F, 9.0F, 2.0F, 9.0F, new CubeDeformation(0.05F))
                        .texOffs(0, 0).addBox(-4.5F, -14.0F, -4.5F, 9.0F, 6.0F, 9.0F, new CubeDeformation(0.3F)),
                PartPose.ZERO);
        head.addOrReplaceChild("head_r1", CubeListBuilder.create().texOffs(0, 1).addBox(0.867F, -1.0884F, -1.0308F, 0.0F, 2.0F, 4.0F, CubeDeformation.NONE), PartPose.offsetAndRotation(4.947F, -8.9003F, -1.3217F, 0.6055F, 0.5544F, 0.1178F));
        head.addOrReplaceChild("head_r2", CubeListBuilder.create().texOffs(0, 1).addBox(0.918F, -0.1563F, -0.6475F, 0.0F, 2.0F, 4.0F, CubeDeformation.NONE), PartPose.offsetAndRotation(4.947F, -8.9003F, -1.3217F, 0.0819F, 0.5544F, 0.1178F));
        head.addOrReplaceChild("head_r3", CubeListBuilder.create().texOffs(0, -2).addBox(0.918F, -2.4283F, -1.6035F, 0.0F, 3.0F, 4.0F, CubeDeformation.NONE), PartPose.offsetAndRotation(4.947F, -8.9003F, -1.3217F, 0.6927F, 0.5544F, 0.1178F));
        head.addOrReplaceChild("head_r4", CubeListBuilder.create().texOffs(0, -3).addBox(-1.173F, -0.5402F, -2.8268F, 0.0F, 2.0F, 3.0F, CubeDeformation.NONE), PartPose.offsetAndRotation(-4.947F, -8.9003F, -1.3217F, 0.3873F, -0.5544F, -0.1178F));
        head.addOrReplaceChild("head_r5", CubeListBuilder.create().texOffs(0, -2).mirror().addBox(-0.918F, -2.4283F, -1.6035F, 0.0F, 3.0F, 4.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(-4.947F, -8.9003F, -1.3217F, 0.6927F, -0.5544F, -0.1178F));
        head.addOrReplaceChild("head_r6", CubeListBuilder.create().texOffs(0, 1).mirror().addBox(-0.918F, -0.1563F, -0.6475F, 0.0F, 2.0F, 4.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(-4.947F, -8.9003F, -1.3217F, 0.0819F, -0.5544F, -0.1178F));
        head.addOrReplaceChild("head_r7", CubeListBuilder.create().texOffs(0, 1).mirror().addBox(-0.867F, -1.0884F, -1.0308F, 0.0F, 2.0F, 4.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(-4.947F, -8.9003F, -1.3217F, 0.6055F, -0.5544F, -0.1178F));
        head.addOrReplaceChild("head_r8", CubeListBuilder.create().texOffs(0, -3).mirror().addBox(1.173F, -0.5402F, -2.8268F, 0.0F, 2.0F, 3.0F, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(4.947F, -8.9003F, -1.3217F, 0.3873F, 0.5544F, 0.1178F));

        return LayerDefinition.create(meshdefinition, 128, 64);
    }

    @Override
    public <E extends LivingEntity> ArmorModel<E> create(ModelPart root, boolean isSlim) {
        return new HeadExaltedAurumArmorModel<>(root, isSlim);
    }

    @Override
    protected void setupArmorPartAnim(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        super.setupArmorPartAnim(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
    }
}
