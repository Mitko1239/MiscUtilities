package com.mitko1239.miscutilities.items;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class ModItems {
	
	public static ToolMaterial BTD = EnumHelper.addToolMaterial("BTD", 3, 1561, 15.0F, 3.0F, 22);
	
	public static Item tutorialItem;
	public static Item metaItem;
	public static Item tutorialPickaxe;
	public static Item tutorialSword;
	public static Item tutorialAxe;
	public static Item tutorialSpade;
	public static Item tutorialHoe;
	
	public static void createItems() {
		GameRegistry.registerItem(tutorialItem = new BasicItem("tutorial_item"), "tutorial_item");
		GameRegistry.registerItem(metaItem = new MetaItem("meta_item"), "meta_item");
		GameRegistry.registerItem(tutorialPickaxe = new ItemModPickaxe("tutorial_pickaxe", BTD), "tutorial_pickaxe");
		GameRegistry.registerItem(tutorialAxe = new ItemModAxe("tutorial_axe", BTD), "tutorial_axe");
		GameRegistry.registerItem(tutorialSpade = new ItemModSpade("tutorial_spade", BTD), "tutorial_spade");
		GameRegistry.registerItem(tutorialHoe = new ItemModHoe("tutorial_hoe", BTD), "tutorial_hoe");
		GameRegistry.registerItem(tutorialSword = new ItemModSword("tutorial_sword", BTD), "tutorial_sword");
	}
}
