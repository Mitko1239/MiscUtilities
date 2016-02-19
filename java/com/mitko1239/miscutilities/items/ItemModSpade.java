package com.mitko1239.miscutilities.items;

import net.minecraft.item.ItemSpade;

public class ItemModSpade extends ItemSpade {
	public ItemModSpade(String unlocalizedName, ToolMaterial material) {
		super(material);
		this.setUnlocalizedName(unlocalizedName);
	}
}
