package org.dawnoftime.armoroftheages.client.models.o_yoroi_armor;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;
import org.dawnoftime.armoroftheages.client.models.ArmorModel;

public class HeadOYoroiArmorModel<T extends LivingEntity> extends ArmorModel<T> {

    public HeadOYoroiArmorModel(ModelPart root, boolean isSlim) {
        super(root, isSlim);
    }

    @Override
    public <E extends LivingEntity> ArmorModel<E> create(ModelPart root, boolean isSlim) {
        return new HeadOYoroiArmorModel<>(root, isSlim);
    }

    public static LayerDefinition createLayerDefinition() {
        MeshDefinition meshdefinition = templateLayerDefinition(1.0F);
        PartDefinition root = meshdefinition.getRoot();
        PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(28, 21).addBox(-4.5F, -8.5F, -4.5F, 9.0F, 4.0F, 9.0F, new CubeDeformation(0.02F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        head.addOrReplaceChild("headRight", CubeListBuilder.create().texOffs(11, 20).mirror().addBox(-4.0F, -6.5F, -4.5F, 4.0F, 1.0F, 9.0F, new CubeDeformation(0.01F)).mirror(false)
                .texOffs(52, 9).mirror().addBox(-3.0F, -8.3F, -4.5F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6981F));

        head.addOrReplaceChild("headLeft", CubeListBuilder.create().texOffs(11, 20).addBox(0.0F, -6.5F, -4.5F, 4.0F, 1.0F, 9.0F, new CubeDeformation(0.01F))
                .texOffs(52, 9).addBox(0.0F, -8.3F, -4.5F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.6981F));

        head.addOrReplaceChild("headBack", CubeListBuilder.create().texOffs(36, 12).addBox(-4.5F, -6.5F, 0.0F, 9.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.6981F, 0.0F, 0.0F));

        head.addOrReplaceChild("headFront", CubeListBuilder.create().texOffs(38, 17).addBox(-4.5F, -7.3F, -2.0F, 9.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.6981F, 0.0F, 0.0F));

        PartDefinition horn = head.addOrReplaceChild("horn", CubeListBuilder.create().texOffs(52, 6).addBox(-1.0F, -5.0F, -6.8F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2618F, 0.0F, 0.0F));

        horn.addOrReplaceChild("helmetHorn", CubeListBuilder.create().texOffs(52, 0).addBox(-3.0F, -3.0F, 0.0F, 6.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, -6.6F, 0.0F, 0.0F, -0.7854F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    protected void setupArmorPartAnim(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}
}
