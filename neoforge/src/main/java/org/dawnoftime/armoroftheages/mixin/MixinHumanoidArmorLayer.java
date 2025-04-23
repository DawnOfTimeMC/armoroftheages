package org.dawnoftime.armoroftheages.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.dawnoftime.armoroftheages.client.ArmorModelProvider;
import org.dawnoftime.armoroftheages.client.models.ArmorModel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.dawnoftime.armoroftheages.item.HumanoidArmorItem;

@Mixin(HumanoidArmorLayer.class)
public abstract class MixinHumanoidArmorLayer<T extends LivingEntity, M extends HumanoidModel<T>, A extends HumanoidModel<T>> extends RenderLayer<T, M> {

    public MixinHumanoidArmorLayer(RenderLayerParent<T, M> parentLayer) {
        super(parentLayer);
    }

    /**
     * I created a custom render function because MC doesn't pass many useful parameters to animate the armor, such as partial ticks or limbSwing.
     */
    @Inject(method = "Lnet/minecraft/client/renderer/entity/layers/HumanoidArmorLayer;render(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;ILnet/minecraft/world/entity/LivingEntity;FFFFFF)V", at = @At("HEAD"))
    public void render(PoseStack poseStack, MultiBufferSource buffer, int packedLight, T livingEntity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, CallbackInfo ci){
        this.armorOfTheAges$renderCustomArmor(poseStack, buffer, livingEntity, EquipmentSlot.HEAD, packedLight, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        this.armorOfTheAges$renderCustomArmor(poseStack, buffer, livingEntity, EquipmentSlot.CHEST, packedLight, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        this.armorOfTheAges$renderCustomArmor(poseStack, buffer, livingEntity, EquipmentSlot.LEGS, packedLight, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        this.armorOfTheAges$renderCustomArmor(poseStack, buffer, livingEntity, EquipmentSlot.FEET, packedLight, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
    }

    @Unique
    private void armorOfTheAges$renderCustomArmor(PoseStack stack, MultiBufferSource buffer, T entity, EquipmentSlot slot, int packedLight, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        ItemStack itemStack = entity.getItemBySlot(slot);
        if (itemStack.getItem() instanceof HumanoidArmorItem armorItem) {
            if (armorItem.getEquipmentSlot() == slot) {
                ArmorModelProvider provider = armorItem.getModelProvider();
                if(provider != null){
                    // First we get the model from the armorItem.
                    ArmorModel<?> model = provider.getArmorModel(entity);
                    // Now we will animate the model !
                    model.copyEntityModelPosition(this.getParentModel());
                    model.young = entity.isBaby();
                    model.crouching = entity.isShiftKeyDown();
                    model.riding = this.getParentModel().riding;
                    model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
                    VertexConsumer vertexconsumer = buffer.getBuffer(RenderType.armorCutoutNoCull(provider.getTexture(entity)));
                    model.renderToBuffer(stack, vertexconsumer, packedLight, OverlayTexture.NO_OVERLAY);

                    if (itemStack.hasFoil()) {
                        model.renderToBuffer(stack, buffer.getBuffer(RenderType.armorEntityGlint()), packedLight, OverlayTexture.NO_OVERLAY);
                    }
                }
            }
        }
    }

    /**
     * Since I already renderer my armor in my custom renderer, I will cancel the rendering if the item is a AotA armor item.
     */
    @Inject(method = "renderArmorPiece", at = @At("HEAD"), cancellable = true)
    private void onRenderArmorPiece(PoseStack stack, MultiBufferSource buffer, T entity, EquipmentSlot slot, int packedLight, A defaultModel, CallbackInfo ci) {
        ItemStack itemStack = entity.getItemBySlot(slot);
        if (itemStack.getItem() instanceof HumanoidArmorItem) {
            ci.cancel();
        }
    }
}