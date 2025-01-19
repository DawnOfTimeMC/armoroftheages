package org.dawnoftime.armoroftheages.client.models.japanese_light_armor;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;
import org.dawnoftime.armoroftheages.client.models.ArmorModel;

public class ChestJapaneseLightArmorModel<T extends LivingEntity> extends ArmorModel<T> {

    public ChestJapaneseLightArmorModel(ModelPart root, boolean isSlim) {
        super(root, isSlim);
    }

    @Override
    public <E extends LivingEntity> ArmorModel<E> create(ModelPart root, boolean isSlim) {
        return new ChestJapaneseLightArmorModel<>(root, isSlim);
    }

    public static LayerDefinition createLayerDefinition() {
        MeshDefinition meshdefinition = templateLayerDefinition(1.0F);
        PartDefinition root = meshdefinition.getRoot();
        root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, new CubeDeformation(0.45F)), PartPose.ZERO);
        root.addOrReplaceChild("right_arm", CubeListBuilder.create().mirror()
                        .texOffs(24, 0).addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, new CubeDeformation(0.3F))
                        .texOffs(12, 16).addBox(-3.5F, 3.0F, -2.5F, 2, 5, 5, new CubeDeformation(0.2F)),
                PartPose.offset(-5.0F, 2.0F, 0.0F));
        root.addOrReplaceChild("left_arm", CubeListBuilder.create()
                        .texOffs(24, 0).addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, new CubeDeformation(0.3F))
                        .texOffs(12, 16).addBox(1.5F, 3.0F, -2.5F, 2, 5, 5, new CubeDeformation(0.2F)),
                PartPose.offset(-5.0F, 2.0F, 0.0F));
        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    public static LayerDefinition createSlimLayerDefinition() {
        MeshDefinition meshdefinition = templateLayerDefinition(1.0F);
        PartDefinition root = meshdefinition.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, new CubeDeformation(0.45F)), PartPose.ZERO);
        body.addOrReplaceChild("breast", CubeListBuilder.create().texOffs(0, 26).addBox(-3.0F, 0.0F, -3.65F, 6, 2, 3, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 1.3F, -2.0F, 0.9948376736367678F, 0.0F, 0.0F));
        root.addOrReplaceChild("right_arm", CubeListBuilder.create().mirror()
                        .texOffs(24, 0).addBox(-2.0F, -2.0F, -2.0F, 3, 12, 4, new CubeDeformation(0.3F))
                        .texOffs(12, 16).addBox(-2.5F, 3.0F, -2.5F, 2, 5, 5, new CubeDeformation(0.1F)),
                PartPose.offset(-5.0F, 2.5F, 0.0F));
        root.addOrReplaceChild("left_arm", CubeListBuilder.create()
                        .texOffs(24, 0).addBox(-1.0F, -2.0F, -2.0F, 3, 12, 4, new CubeDeformation(0.3F))
                        .texOffs(12, 16).addBox(0.5F, 3.0F, -2.5F, 2, 5, 5, new CubeDeformation(0.1F)),
                PartPose.offset(-5.0F, 2.5F, 0.0F));
        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    protected void setupArmorPartAnim(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}
}
