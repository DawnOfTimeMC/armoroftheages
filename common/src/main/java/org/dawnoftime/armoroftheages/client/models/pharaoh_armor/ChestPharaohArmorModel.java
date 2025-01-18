package org.dawnoftime.armoroftheages.client.models.pharaoh_armor;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;
import org.dawnoftime.armoroftheages.client.models.ArmorModel;

public class ChestPharaohArmorModel<T extends LivingEntity> extends ArmorModel<T> {

    public ChestPharaohArmorModel(ModelPart root, boolean isSlim) {
        super(root, isSlim);
    }

    @Override
    public <E extends LivingEntity> ArmorModel<E> create(ModelPart root, boolean isSlim) {
        return new ChestPharaohArmorModel<>(root, isSlim);
    }

    public static LayerDefinition createLayerDefinition() {
        MeshDefinition meshdefinition = templateLayerDefinition(1.0F);
        PartDefinition root = meshdefinition.getRoot();
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-4.5F, -0.5F, -2.5F, 9, 13, 5, new CubeDeformation(-0.1F)),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        body.addOrReplaceChild("bodyCollar", CubeListBuilder.create()
                        .texOffs(28, 0)
                        .addBox(-5.5F, -0.25F, -2.5F, 11, 5, 5, new CubeDeformation(0.2F)),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        root.addOrReplaceChild("left_arm", CubeListBuilder.create()
                        .texOffs(0, 18).mirror(true)
                        .addBox(-1.5F, -2.5F, -2.5F, 5, 10, 5, new CubeDeformation(-0.2F)),
                PartPose.offset(5.0F, 2.0F, 0.0F));

        root.addOrReplaceChild("right_arm", CubeListBuilder.create()
                        .texOffs(0, 18)
                        .addBox(-3.5F, -2.5F, -2.5F, 5, 10, 5, new CubeDeformation(-0.2F)),
                PartPose.offset(-5.5F, 2.0F, -0.5F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    public static LayerDefinition createSlimLayerDefinition() {
        MeshDefinition meshdefinition = templateLayerDefinition(1.0F);
        PartDefinition root = meshdefinition.getRoot();

        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-4.5F, -0.5F, -2.5F, 9, 13, 5, new CubeDeformation(-0.1F)),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        body.addOrReplaceChild("bodyCollar", CubeListBuilder.create()
                        .texOffs(28, 0)
                        .addBox(-5.5F, -0.25F, -2.5F, 11, 5, 5, new CubeDeformation(0.2F)),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        root.addOrReplaceChild("left_arm", CubeListBuilder.create()
                        .texOffs(0, 18).mirror(true)
                        .addBox(-1.5F, -2.5F, -2.5F, 4, 10, 5, new CubeDeformation(-0.2F)),
                PartPose.offset(5.0F, 2.5F, 0.0F));

        root.addOrReplaceChild("right_arm", CubeListBuilder.create()
                        .texOffs(0, 18)
                        .addBox(-2.5F, -2.5F, -2.5F, 4, 10, 5, new CubeDeformation(-0.2F)),
                PartPose.offset(-5.0F, 2.5F, 0.0F));

        body.addOrReplaceChild("bodyBreast", CubeListBuilder.create()
                        .texOffs(38, 49)
                        .addBox(-3.5F, 0.0F, -3.65F, 7, 2, 3, new CubeDeformation(-0.1F)),
                PartPose.offsetAndRotation(0.0F, 0.9F, -2.1F, 0.99483767F, 0.0F, 0.0F));

        body.addOrReplaceChild("bodyBreastCollar", CubeListBuilder.create()
                        .texOffs(38, 54)
                        .addBox(-5.5F, 0.0F, 0.0F, 11, 5, 0, new CubeDeformation(0.2F)),
                PartPose.offsetAndRotation(0.0F, -0.25F, -2.5F, -0.3403392F, 0.0F, 0.0F));
        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    protected void setupArmorPartAnim(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}
}
