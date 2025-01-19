package org.dawnoftime.armoroftheages.client.models.pharaoh_armor;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;
import org.dawnoftime.armoroftheages.client.models.ArmorModel;

public class FeetPharaohArmorModel<T extends LivingEntity> extends ArmorModel<T> {

    public FeetPharaohArmorModel(ModelPart root, boolean isSlim) {
        super(root, isSlim);
    }

    @Override
    public <E extends LivingEntity> ArmorModel<E> create(ModelPart root, boolean isSlim) {
        return new FeetPharaohArmorModel<>(root, isSlim);
    }

    public static LayerDefinition createLayerDefinition() {
        MeshDefinition meshdefinition = templateLayerDefinition(1.0F);
        PartDefinition root = meshdefinition.getRoot();
        root.addOrReplaceChild("left_leg", CubeListBuilder.create()
                        .texOffs(0, 44).mirror(true)
                        .addBox(-2.5F, 10.3F, -2.5F, 5, 2, 5, new CubeDeformation(-0.2F)),
                PartPose.offset(1.9F, 12.0F, 0.0F));

        root.addOrReplaceChild("right_leg", CubeListBuilder.create()
                        .texOffs(0, 44)
                        .addBox(-2.5F, 10.3F, -2.5F, 5, 2, 5, new CubeDeformation(-0.2F)),
                PartPose.offset(-1.9F, 12.0F, 0.0F));
        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    protected void setupArmorPartAnim(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}
}
