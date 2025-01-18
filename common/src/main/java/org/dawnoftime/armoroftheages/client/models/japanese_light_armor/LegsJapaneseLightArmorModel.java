package org.dawnoftime.armoroftheages.client.models.japanese_light_armor;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;
import org.dawnoftime.armoroftheages.client.models.ArmorModel;

public class LegsJapaneseLightArmorModel<T extends LivingEntity> extends ArmorModel<T> {

    public LegsJapaneseLightArmorModel(ModelPart root, boolean isSlim) {
        super(root, isSlim);
    }

    @Override
    public <E extends LivingEntity> ArmorModel<E> create(ModelPart root, boolean isSlim) {
        return new LegsJapaneseLightArmorModel<>(root, isSlim);
    }

    public static LayerDefinition createLayerDefinition() {
        MeshDefinition meshdefinition = templateLayerDefinition(1.0F);
        PartDefinition root = meshdefinition.getRoot();
        root.getChild("right_leg").addOrReplaceChild("right_leg_prot", CubeListBuilder.create().texOffs(0, 16).addBox(-2.4F, -0.2F, -2.0F, 2, 5, 4, new CubeDeformation(0.6F)), PartPose.rotation(0.0F, 0.0F, 0.2F));
        root.getChild("left_leg").addOrReplaceChild("left_leg_prot", CubeListBuilder.create().mirror().texOffs(0, 16).addBox(0.4F, -0.2F, -2.0F, 2, 5, 4, new CubeDeformation(0.6F)), PartPose.rotation(0.0F, 0.0F, -0.2F));
        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    protected void setupArmorPartAnim(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}
}
