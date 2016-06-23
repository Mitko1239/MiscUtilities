package com.mitko1239.miscutilities.items;

import com.mitko1239.miscutilities.Main;
import net.minecraft.item.ItemSword;

public class ItemModSword extends ItemSword {
	public ItemModSword(String unlocalizedName, ToolMaterial material) {
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(Main.creativeTab);
	}
}
