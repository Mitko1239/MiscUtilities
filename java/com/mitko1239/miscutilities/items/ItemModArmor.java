package com.mitko1239.miscutilities.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class ItemModArmor extends ItemArmor {

	public ItemModArmor(String unlocalizedName, ArmorMaterial material,
			int renderIndex, int armorType) {
		super(material, renderIndex, armorType);
		this.setUnlocalizedName(unlocalizedName);
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player,
			ItemStack itemStack) {
		if (itemStack.getItem() == ModItems.tutorialHelmet) {
			effectPlayer(player, Potion.nightVision, 400, 0);
		} else if (itemStack.getItem() == ModItems.tutorialChestplate) {
			effectPlayer(player, Potion.digSpeed, 80, 0);
		} else if (itemStack.getItem() == ModItems.tutorialLeggings) {
			effectPlayer(player, Potion.moveSpeed, 200, 0);
		} else if (itemStack.getItem() == ModItems.tutorialBoots) {
			effectPlayer(player, Potion.jump, 200, 0);
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
			this.effectPlayer(player, Potion.regeneration, 80, 0);
//			player.capabilities.allowFlying = true;
		} else {
//			player.isAirBorne = false;
//			player.capabilities.allowFlying = false;
		}
	}

	private void effectPlayer(EntityPlayer player, Potion potion, int time,
			int amplifier) {
		if (player.getActivePotionEffect(potion) == null
				|| player.getActivePotionEffect(potion).getDuration() <= (time-60)) {
			player.addPotionEffect(
					new PotionEffect(potion.id, time, amplifier, true, true));
		}
	}

}
