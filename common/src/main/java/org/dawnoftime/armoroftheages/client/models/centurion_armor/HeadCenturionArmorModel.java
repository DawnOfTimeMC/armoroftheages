package org.dawnoftime.armoroftheages.client.models.centurion_armor;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;
import org.dawnoftime.armoroftheages.client.models.ArmorModel;

public class HeadCenturionArmorModel<T extends LivingEntity> extends ArmorModel<T> {

    public HeadCenturionArmorModel(ModelPart root, boolean isSlim) {
        super(root, isSlim);
    }

    @Override
    public <E extends LivingEntity> ArmorModel<E> create(ModelPart root, boolean isSlim) {
        return new HeadCenturionArmorModel<>(root, isSlim);
    }

    public static LayerDefinition createLayerDefinition() {
        MeshDefinition meshdefinition = templateLayerDefinition(1.0F);
        PartDefinition root = meshdefinition.getRoot();
        PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create()
                        .texOffs(0, 0).addBox(-4.5F, -8.5F, -4.5F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.25F))
                        .texOffs(75, 0).addBox(-5.0F, -6.0F, -5.25F, 10.0F, 1.0F, 1.0F, CubeDeformation.NONE)
                        .texOffs(24, 6).addBox(-1.0F, -14.25F, -2.75F, 2.0F, 11.0F, 12.0F, CubeDeformation.NONE)
                        .texOffs(40, 17).addBox(-1.0F, -14.25F, -2.75F, 2.0F, 11.0F, 12.0F, new CubeDeformation(0.25F))
                        .texOffs(0, 0).addBox(-1.0F, -14.25F, -3.75F, 2.0F, 4.0F, 1.0F, CubeDeformation.NONE)
                        .texOffs(0, 59).addBox(-1.0F, -14.25F, -3.75F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.25F)),
                PartPose.ZERO);

        head.addOrReplaceChild("jow", CubeListBuilder.create()
                        .texOffs(75, -4).addBox(4.65F, -26.0F, 4.75F, 0.0F, 3.0F, 6.0F, CubeDeformation.NONE)
                        .texOffs(75, -4).addBox(-4.65F, -26.0F, 4.75F, 0.0F, 3.0F, 6.0F, CubeDeformation.NONE),
                PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.3927F, 0.0F, 0.0F));
        return LayerDefinition.create(meshdefinition, 128, 64);
    }

    @Override
    protected void setupArmorPartAnim(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}
}
