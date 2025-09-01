package org.dawnoftime.armoroftheages.compat;

import com.github.razorplay01.ismah.client.api.CustomArmorRenderer;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.dawnoftime.armoroftheages.client.ArmorModelProvider;
import org.dawnoftime.armoroftheages.client.models.ArmorModel;
import org.dawnoftime.armoroftheages.item.HumanoidArmorItem;

public class ISMAHCompat implements CustomArmorRenderer {
    @Override
    public boolean canRender(ItemStack stack) {
        return stack.getItem() instanceof HumanoidArmorItem;
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource vertexConsumers, int light, ItemStack stack, HumanoidArm arm, HumanoidModel playerModel) {
        if (!(stack.getItem() instanceof HumanoidArmorItem armorItem)) {
            return;
        }

        ArmorModelProvider provider = armorItem.getModelProvider();
        if (provider == null) {
            return;
        }

        LivingEntity entity = Minecraft.getInstance().player;
        ArmorModel<?> model = provider.getArmorModel(entity);
        if (model == null) {
            return;
        }

        model.copyEntityModelPosition(playerModel);
        model.setupAnim(entity, 0.0F, 0.0F, 0.0F, entity.yHeadRot, entity.getXRot());

        boolean originalRightArmVisible = model.rightArm.visible;
        boolean originalLeftArmVisible = model.leftArm.visible;
        boolean originalHeadVisible = model.head.visible;
        boolean originalBodyVisible = model.body.visible;
        boolean originalRightLegVisible = model.rightLeg.visible;
        boolean originalLeftLegVisible = model.leftLeg.visible;

        boolean isRightArm = arm == HumanoidArm.RIGHT;
        model.rightArm.visible = isRightArm;
        model.leftArm.visible = !isRightArm;
        model.head.visible = false;
        model.body.visible = false;
        model.rightLeg.visible = false;
        model.leftLeg.visible = false;

        VertexConsumer vertexConsumer = vertexConsumers.getBuffer(RenderType.armorCutoutNoCull(provider.getTexture(entity)));
        model.renderToBuffer(poseStack, vertexConsumer, light, OverlayTexture.NO_OVERLAY);

        if (stack.hasFoil()) {
            model.renderToBuffer(poseStack, vertexConsumers.getBuffer(RenderType.armorEntityGlint()), light, OverlayTexture.NO_OVERLAY);
        }

        model.rightArm.visible = originalRightArmVisible;
        model.leftArm.visible = originalLeftArmVisible;
        model.head.visible = originalHeadVisible;
        model.body.visible = originalBodyVisible;
        model.rightLeg.visible = originalRightLegVisible;
        model.leftLeg.visible = originalLeftLegVisible;
    }
}