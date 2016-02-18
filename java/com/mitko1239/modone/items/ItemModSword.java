package com.mitko1239.modone.items;

import net.minecraft.item.ItemSword;

public class ItemModSword extends ItemSword {
	public ItemModSword(String unlocalizedName, ToolMaterial material) {
		super(material);
		this.setUnlocalizedName(unlocalizedName);
	}
}
