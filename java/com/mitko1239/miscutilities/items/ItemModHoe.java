package com.mitko1239.miscutilities.items;

import com.mitko1239.miscutilities.Main;
import net.minecraft.item.ItemHoe;

public class ItemModHoe extends ItemHoe {
	public ItemModHoe(String unlocalizedName, ToolMaterial material) {
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(Main.creativeTab);
	}
}
