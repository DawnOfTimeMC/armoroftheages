package com.dotteam.armorweapons.item;

import com.dotteam.armorweapons.model.HumanoidArmorPartModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Vanishable;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.function.Consumer;

import static com.dotteam.armorweapons.DoTArmorWeapons.MOD_ID;

public abstract class HumanoidArmorItem extends ArmorItem implements Vanishable {
	public final String setName;

	public HumanoidArmorItem(String setNameIn, ArmorMaterial materialIn, Type slotIn) {
		super(materialIn, slotIn, new Properties().stacksTo(1));
		this.setName = setNameIn;
	}

	@Override
	public @Nullable String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
		if (entity instanceof AbstractClientPlayer playerEntity) {
			if ("slim".equals(playerEntity.getModelName())) {
				return MOD_ID + ":textures/models/armor/" + this.setName + "_slim.png";
			}
		}
		return MOD_ID + ":textures/models/armor/" + this.setName + ".png";
	}

	@Override
	public void initializeClient(Consumer<IClientItemExtensions> consumer) {
		consumer.accept(new IClientItemExtensions() {
			public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel<?> defaultModel) {
				/*
				HumanoidModel<?> armorModele = new HumanoidModel<>(
						new ModelPart(Collections.emptyList(),
						Map.of(
								"hat", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
								"head", new Balaclava_Model(Minecraft.getInstance().getEntityModels().bakeLayer(Balaclava_Model.LAYER_LOCATION)).Head,
								"body", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
								"right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
								"left_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
								"right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
								"left_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()))));
				*/
				HumanoidModel<?> armorModel = getModel(living, isSlimPlayerEntity(living));


				armorModel.young = living.isBaby();
				armorModel.crouching = living.isShiftKeyDown();
				armorModel.riding = defaultModel.riding;
				// armorModel.rightArmPose = _default.rightArmPose;
				// armorModel.leftArmPose = _default.leftArmPose;
				// armorModel.setupAnim(entityLiving, (float) entityLiving.tickCount);
				return armorModel;
			}
		});
	}

	/**
	 * Checks if the entity in parameter has Alex model or not.
	 * @param living is the entity to study.
	 * @return True if the entity has Alex model, False if it has Steve model.
	 */
	private boolean isSlimPlayerEntity(LivingEntity living){
		return living instanceof AbstractClientPlayer && "slim".equals(((AbstractClientPlayer) living).getModelName());
	}

	/**
	 * Returns the armor model depending on the type of player model.
	 * @param living entity with the equipped item.
	 * @param isSlim is True if the living entity has Alex model, False if it's Steve.
	 * @return the corresponding armor.
	 */
	private HumanoidModel<LivingEntity> getModel(LivingEntity living, boolean isSlim){
		if(isSlim){
			return this.getModelFactory().create(this.getType(), true, living.getScale());
		}else{
			return this.getModelFactory().create(this.getType(), false, living.getScale());
		}
	}

	@OnlyIn(Dist.CLIENT)
	public abstract ArmorModelFactory getModelFactory();

	@FunctionalInterface
	public interface ArmorModelFactory {
		HumanoidArmorPartModel<LivingEntity> create(Type type, boolean isSteve, float scale);
	}

	@Override
	public EquipmentSlot getEquipmentSlot(ItemStack stackIn) {
		if (stackIn.getItem() instanceof HumanoidArmorItem) {
			return this.getType().getSlot();
		}
		return null;
	}

	@Override
	public int getMaxDamage(ItemStack stackIn) {
		return this.material.getDurabilityForType(this.type);
	}
}
