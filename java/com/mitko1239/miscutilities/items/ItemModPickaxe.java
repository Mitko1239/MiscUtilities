package com.mitko1239.miscutilities.items;

import com.mitko1239.miscutilities.Main;
import net.minecraft.item.ItemPickaxe;

public class ItemModPickaxe extends ItemPickaxe {
	public ItemModPickaxe(String unlocalizedName, ToolMaterial material) {
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(Main.creativeTab);
	}
}
