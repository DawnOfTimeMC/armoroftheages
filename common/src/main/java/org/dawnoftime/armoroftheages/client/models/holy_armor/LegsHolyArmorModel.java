package org.dawnoftime.armoroftheages.client.models.holy_armor;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;
import org.dawnoftime.armoroftheages.client.models.ArmorModel;

public class LegsHolyArmorModel<T extends LivingEntity> extends ArmorModel<T> {

    public LegsHolyArmorModel(ModelPart root, boolean isSlim) {
        super(root, isSlim);
    }

    @Override
    public <E extends LivingEntity> ArmorModel<E> create(ModelPart root, boolean isSlim) {
        return new LegsHolyArmorModel<>(root, isSlim);
    }

    public static LayerDefinition createLayerDefinition() {
        MeshDefinition meshdefinition = templateLayerDefinition(1.0F);
        PartDefinition root = meshdefinition.getRoot();

        PartDefinition chest = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 23).addBox(-1.0F, 9.5F, -3.3F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        chest.addOrReplaceChild("hipsLeft", CubeListBuilder.create().texOffs(28, 54).addBox(0.0F, 0.0F, -3.0F, 4.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 10.0F, 0.0F, 0.0F, 0.0F, -0.2618F));

        chest.addOrReplaceChild("hipsRight", CubeListBuilder.create().texOffs(28, 54).mirror().addBox(-4.0F, 0.0F, -3.0F, 4.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 10.0F, 0.0F, 0.0F, 0.0F, 0.2618F));

        root.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(28, 33).addBox(-1.5F, -0.3F, -2.5F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(63, 51).addBox(-1.2598F, -0.1375F, -3.0F, 4.0F, 3.0F, 6.0F, new CubeDeformation(-0.01F)), PartPose.offset(1.9F, 12.0F, 0.0F));

        root.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(28, 33).mirror().addBox(-2.5F, -0.3F, -2.5F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(63, 51).mirror().addBox(-2.7402F, -0.1375F, -3.0F, 4.0F, 3.0F, 6.0F, new CubeDeformation(-0.01F)).mirror(false), PartPose.offset(-1.9F, 12.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    protected void setupArmorPartAnim(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}
}
