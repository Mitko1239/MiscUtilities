package com.mitko1239.miscutilities.items;

import com.mitko1239.miscutilities.Main;
import com.mitko1239.miscutilities.items.TempReplace.ItemAxeFix;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;


public class ItemModAxe extends ItemAxeFix {
	public ItemModAxe(String unlocalizedName, Item.ToolMaterial material) {

		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(Main.creativeTab);
	}
}
