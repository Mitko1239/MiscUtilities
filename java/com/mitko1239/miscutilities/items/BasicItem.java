package com.mitko1239.miscutilities.items;

import com.mitko1239.miscutilities.Main;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BasicItem extends Item {
	public BasicItem(String blockName) {
		super();
		setItemName(this, blockName);
		this.setCreativeTab(Main.creativeTab);
	}

	public static void setItemName(Item item, String blockName) {
		item.setRegistryName(Main.MODID, blockName);
		item.setUnlocalizedName(blockName);
	}
}
