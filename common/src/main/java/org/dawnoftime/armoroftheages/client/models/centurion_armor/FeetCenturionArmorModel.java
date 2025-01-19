package org.dawnoftime.armoroftheages.client.models.centurion_armor;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;
import org.dawnoftime.armoroftheages.client.models.ArmorModel;

public class FeetCenturionArmorModel<T extends LivingEntity> extends ArmorModel<T> {

    public FeetCenturionArmorModel(ModelPart root, boolean isSlim) {
        super(root, isSlim);
    }

    @Override
    public <E extends LivingEntity> ArmorModel<E> create(ModelPart root, boolean isSlim) {
        return new FeetCenturionArmorModel<>(root, isSlim);
    }

    public static LayerDefinition createLayerDefinition() {
        MeshDefinition meshdefinition = templateLayerDefinition(1.0F);
        PartDefinition root = meshdefinition.getRoot();
        root.addOrReplaceChild("right_leg", CubeListBuilder.create()
                        .texOffs(59, 48).addBox(-2.6F, 9.25F, -2.5F, 5.0F, 3.0F, 5.0F, new CubeDeformation(0.15F))
                        .texOffs(59, 56).addBox(-2.6F, 9.3F, -2.5F, 5.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)),
                PartPose.offset(-1.9F, 12.0F, 0.0F));
        root.addOrReplaceChild("left_leg", CubeListBuilder.create().mirror()
                        .texOffs(59, 48).addBox(-2.4F, 9.25F, -2.5F, 5.0F, 3.0F, 5.0F, new CubeDeformation(0.15F))
                        .texOffs(59, 56).addBox(-2.4F, 9.3F, -2.5F, 5.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)),
                PartPose.offset(1.9F, 12.0F, 0.0F));
        return LayerDefinition.create(meshdefinition, 128, 64);
    }

    @Override
    protected void setupArmorPartAnim(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}
}
