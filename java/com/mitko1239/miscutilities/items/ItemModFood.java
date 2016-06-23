package com.mitko1239.miscutilities.items;

import com.mitko1239.miscutilities.Main;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemModFood extends ItemFood {

	private PotionEffect[] effects;
	
	public ItemModFood(String unlocalizedName, int amount, float saturation,
			boolean isWolfFood, PotionEffect... effects) {
		super(amount, saturation, isWolfFood);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(Main.creativeTab);
		this.effects = effects;
	}

	@Override
	protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
		super.onFoodEaten(stack, world, player);
		
		for(int i = 0; i < effects.length; i++) {
			if(!world.isRemote && effects[i] != null && effects[i].getEffectName() != null) {
				player.addPotionEffect(new PotionEffect(this.effects[i]));
			}
		}
	}
}
