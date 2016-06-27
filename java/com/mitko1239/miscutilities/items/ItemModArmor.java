package com.mitko1239.miscutilities.items;

import com.mitko1239.miscutilities.Main;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import java.util.List;

public class ItemModArmor extends ItemArmor {

	public ItemModArmor(String unlocalizedName, ArmorMaterial material,
			int renderIndex, EntityEquipmentSlot equipmentSlot) {
		super(material, renderIndex, equipmentSlot);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(Main.creativeTab);
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player,
			ItemStack itemStack) {
		if (itemStack.getItem() == ModItems.tutorialHelmet) {
			effectPlayer(player, MobEffects.NIGHT_VISION, 400, 0, false, false);
		} else if (itemStack.getItem() == ModItems.tutorialChestplate) {
			effectPlayer(player, MobEffects.HASTE, 80, 0, false, false);
		} else if (itemStack.getItem() == ModItems.tutorialLeggings) {
			effectPlayer(player, MobEffects.SPEED, 200, 0, false, false);
		} else if (itemStack.getItem() == ModItems.tutorialBoots) {
			effectPlayer(player, MobEffects.JUMP_BOOST, 200, 0, false, false);
		}
		if (player.inventory.armorItemInSlot(3) != null
				&& player.inventory.armorItemInSlot(3)
						.getItem() == ModItems.tutorialHelmet
				&& player.inventory.armorItemInSlot(2) != null
				&& player.inventory.armorItemInSlot(2)
						.getItem() == ModItems.tutorialChestplate
				&& player.inventory.armorItemInSlot(1) != null
				&& player.inventory.armorItemInSlot(1)
						.getItem() == ModItems.tutorialLeggings
				&& player.inventory.armorItemInSlot(0) != null
				&& player.inventory.armorItemInSlot(0)
						.getItem() == ModItems.tutorialBoots) {
			//potion effects extension & amplification
			effectPlayer(player, MobEffects.NIGHT_VISION, (int)(400*1.5), 0, false, false);
			effectPlayer(player, MobEffects.HASTE, (int)(80*1.5), 1, false, false);
			effectPlayer(player, MobEffects.SPEED, (int)(200*1.5), 1, false, false);
			effectPlayer(player, MobEffects.JUMP_BOOST, (int)(200*1.5), 1, false, false);

			this.effectPlayer(player, MobEffects.SATURATION, 80, 0, false, false);
//			this.effectPlayer(player, MobEffects.healthBoost, 600, 0, false, false);
//			this.effectPlayer(player, MobEffects.absorption, 600, 0, false, false);
			this.effectPlayer(player, MobEffects.LUCK, 80, 0, false, false);

			if(player.capabilities.allowFlying == false){
				player.capabilities.allowFlying=true;
			}
			player.stepHeight = 1.0F;
		}
	}

	public void onUpdate(ItemStack itemstack, World world, Entity entity, int p_77663_4_, boolean p_77663_5_)
		{
//			System.out.println(entity.stepHeight);
			if (entity != null)
			{
				if(entity instanceof EntityPlayer)
				{
					EntityPlayer player = ((EntityPlayer)entity);
					if(player.inventory.armorItemInSlot(0) == null || player.inventory.armorItemInSlot(1) == null ||player.inventory.armorItemInSlot(2) == null || player.inventory.armorItemInSlot(3) == null){
						if(player.capabilities.allowFlying == true){
							if(!player.capabilities.isCreativeMode) {
								player.capabilities.allowFlying = false;
								player.capabilities.isFlying = false;
							}
							player.stepHeight = 0.5F;
						}
					}else if(player.inventory.armorItemInSlot(2).getItem() != ModItems.tutorialChestplate || player.inventory.armorItemInSlot(2).getItem() != Items.ELYTRA){
						if(player.capabilities.allowFlying == true){
							player.capabilities.allowFlying = false;
							player.stepHeight = 0.5F;
						}
					}
				}
			}
		}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
		list.add("Full set Bonus:");
		list.add(" - Extends potion effects by 1.5");
		list.add(" - Amplifies potion effects by 2");
//		if(stack == new ItemStack(ModItems.tutorialHelmet)) {
//			list.add("Nightvision (0:20)");
//		} else if(stack == new ItemStack(ModItems.tutorialChestplate)) {
//			list.add("Haste I (0:04)");
//		} else if(stack == new ItemStack(ModItems.tutorialLeggings)) {
//			list.add("Speed I (0:10)");
//		} else if(stack == new ItemStack(ModItems.tutorialBoots)) {
//			list.add("Jump Boost I (0:10)");
//		}
	}

	private void effectPlayer(EntityPlayer player, Potion potion, int time,
			int amplifier, boolean isAmbient, boolean showParticles) {
		if (player.getActivePotionEffect(potion) == null
				|| player.getActivePotionEffect(potion).getDuration() <= (time-60)) {
			player.addPotionEffect(
					new PotionEffect(potion, time, amplifier, isAmbient, showParticles));
		}
	}

}
