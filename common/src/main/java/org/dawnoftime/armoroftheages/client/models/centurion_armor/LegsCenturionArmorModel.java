package org.dawnoftime.armoroftheages.client.models.centurion_armor;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;
import org.dawnoftime.armoroftheages.client.models.ArmorModel;

public class LegsCenturionArmorModel<T extends LivingEntity> extends ArmorModel<T> {

    public LegsCenturionArmorModel(ModelPart root, boolean isSlim) {
        super(root, isSlim);
    }

    @Override
    public <E extends LivingEntity> ArmorModel<E> create(ModelPart root, boolean isSlim) {
        return new LegsCenturionArmorModel<>(root, isSlim);
    }

    public static LayerDefinition createLayerDefinition() {
        MeshDefinition meshdefinition = templateLayerDefinition(1.0F);
        PartDefinition root = meshdefinition.getRoot();
        root.addOrReplaceChild("right_leg", CubeListBuilder.create()
                        .texOffs(40, 0).addBox(-2.6F, 0.3F, -2.5F, 5.0F, 8.0F, 5.0F, CubeDeformation.NONE)
                        .texOffs(60, 0).addBox(-2.6F, 0.25F, -2.5F, 5.0F, 7.0F, 5.0F, new CubeDeformation(0.15F)),
                PartPose.offset(-1.9F, 12.0F, 0.0F));

        root.addOrReplaceChild("left_leg", CubeListBuilder.create().mirror()
                        .texOffs(40, 0).addBox(-2.4F, 0.3F, -2.5F, 5.0F, 8.0F, 5.0F, CubeDeformation.NONE)
                        .texOffs(60, 0).addBox(-2.4F, 0.25F, -2.5F, 5.0F, 7.0F, 5.0F, new CubeDeformation(0.15F)),
                PartPose.offset(1.9F, 12.0F, 0.0F));
        return LayerDefinition.create(meshdefinition, 128, 64);
    }

    @Override
    protected void setupArmorPartAnim(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}
}
