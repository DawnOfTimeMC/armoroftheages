package org.dawnoftime.armoroftheages.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.dawnoftime.armoroftheages.client.models.ArmorModel;
import org.dawnoftime.armoroftheages.item.HumanoidArmorItem;

import static net.minecraft.client.renderer.entity.LivingEntityRenderer.isEntityUpsideDown;

public class CustomArmorRenderer implements ArmorRenderer {

    @Override
    public void render(PoseStack stack, MultiBufferSource buffer, ItemStack itemStack, LivingEntity entity, EquipmentSlot slot, int packedLight, HumanoidModel<LivingEntity> contextModel) {
        this.renderCustomArmor(stack, buffer, itemStack, entity, slot, packedLight, contextModel);
    }

    private void renderCustomArmor(PoseStack stack, MultiBufferSource buffer, ItemStack itemStack, LivingEntity entity, EquipmentSlot slot, int packedLight, HumanoidModel<LivingEntity> contextModel) {
        if (itemStack.getItem() instanceof HumanoidArmorItem armorItem) {
            if (armorItem.getEquipmentSlot() == slot) {
                ArmorModelProvider provider = armorItem.getModelProvider();
                if(provider != null) {
                    // First we get the model from the armorItem.
                    ArmorModel<?> model = provider.getArmorModel(entity);
                    // Now we will animate the model !
                    model.copyEntityModelPosition(contextModel);
                    model.young = entity.isBaby();
                    model.crouching = entity.isShiftKeyDown();
                    model.riding = contextModel.riding;

                    // Code copied from LivingEntityRenderer
                    float partialTicks = Minecraft.getInstance().getTimer().getGameTimeDeltaPartialTick(true);

                    float f = Mth.rotLerp(partialTicks, entity.yBodyRotO, entity.yBodyRot);
                    float f1 = Mth.rotLerp(partialTicks, entity.yHeadRotO, entity.yHeadRot);
                    float netHeadYaw = f1 - f;

                    if (entity.isPassenger() && entity.getVehicle() instanceof LivingEntity livingentity) {
                        f = Mth.rotLerp(partialTicks, livingentity.yBodyRotO, livingentity.yBodyRot);
                        netHeadYaw = f1 - f;
                        float f7 = Mth.wrapDegrees(netHeadYaw);
                        if (f7 < -85.0F)
                            f7 = -85.0F;

                        if (f7 >= 85.0F)
                            f7 = 85.0F;

                        f = f1 - f7;
                        if (f7 * f7 > 2500.0F)
                            f += f7 * 0.2F;

                        netHeadYaw = f1 - f;
                    }

                    float headPitch = Mth.lerp(partialTicks, entity.xRotO, entity.getXRot());
                    if (isEntityUpsideDown(entity)) {
                        headPitch *= -1.0F;
                        netHeadYaw *= -1.0F;
                    }

                    netHeadYaw = Mth.wrapDegrees(netHeadYaw);

                    float limbSwingAmount = 0.0F;
                    float limbSwing = 0.0F;

                    if (!entity.isPassenger() && entity.isAlive()) {
                        limbSwingAmount = entity.walkAnimation.speed(partialTicks);
                        limbSwing = entity.walkAnimation.position(partialTicks);

                        if (entity.isBaby())
                            limbSwing *= 3.0F;

                        if (limbSwingAmount > 1.0F)
                            limbSwingAmount = 1.0F;

                    }

                    model.setupAnim(entity, limbSwing, limbSwingAmount, (float) entity.tickCount + partialTicks, netHeadYaw, headPitch);
                    VertexConsumer vertexconsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(provider.getTexture(entity)));
                    model.renderToBuffer(stack, vertexconsumer, packedLight, OverlayTexture.NO_OVERLAY);

                    if (itemStack.hasFoil())
                        model.renderToBuffer(stack, buffer.getBuffer(RenderType.armorEntityGlint()), packedLight, OverlayTexture.NO_OVERLAY);
                }
            }
        }
    }
}
