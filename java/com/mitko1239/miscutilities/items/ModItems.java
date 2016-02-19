package com.mitko1239.miscutilities.items;

import com.mitko1239.miscutilities.Main;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class ModItems {

	public static String modid = Main.MODID;

	public static ToolMaterial BTD = EnumHelper.addToolMaterial("BTD", 3, 1561,
			15.0F, 5.0F, 22);
	public static ArmorMaterial BTD_A = EnumHelper.addArmorMaterial("BTD_A",
			modid + ":btd", 50, new int[]{3, 8, 6, 3}, 30);

	public static Item tutorialItem;
	
	public static ItemMeta metaItem;

	public static ItemModPickaxe tutorialPickaxe;
	public static ItemModSword tutorialSword;
	public static ItemModAxe tutorialAxe;
	public static ItemModSpade tutorialSpade;
	public static ItemModHoe tutorialHoe;
	
	public static ItemModMultitool tutorialMultitool;

	public static ItemModArmor tutorialHelmet;
	public static ItemModArmor tutorialChestplate;
	public static ItemModArmor tutorialLeggings;
	public static ItemModArmor tutorialBoots;
	
	public static ItemFood tutorialChocolate;
	private static ItemFood tutorialLuckyCandy;


	public static void createItems() {
		GameRegistry.registerItem(tutorialItem = new BasicItem("tutorial_item"),
				"tutorial_item");

		GameRegistry.registerItem(metaItem = new ItemMeta("meta_item"),
				"meta_item");

		GameRegistry.registerItem(
				tutorialPickaxe = new ItemModPickaxe("tutorial_pickaxe", BTD),
				"tutorial_pickaxe");
		GameRegistry.registerItem(
				tutorialAxe = new ItemModAxe("tutorial_axe", BTD),
				"tutorial_axe");
		GameRegistry.registerItem(
				tutorialSpade = new ItemModSpade("tutorial_spade", BTD),
				"tutorial_spade");
		GameRegistry.registerItem(
				tutorialHoe = new ItemModHoe("tutorial_hoe", BTD),
				"tutorial_hoe");
		GameRegistry.registerItem(
				tutorialSword = new ItemModSword("tutorial_sword", BTD),
				"tutorial_sword");
		GameRegistry.registerItem(
				tutorialMultitool = new ItemModMultitool("tutorial_multitool", BTD),
				"tutorial_multitool");

		GameRegistry.registerItem(tutorialHelmet = new ItemModArmor(
				"tutorial_helmet", BTD_A, 1, 0), "tutorial_helmet");
		GameRegistry
				.registerItem(
						tutorialChestplate = new ItemModArmor(
								"tutorial_chestplate", BTD_A, 1, 1),
						"tutorial_chestplate");
		GameRegistry.registerItem(tutorialLeggings = new ItemModArmor(
				"tutorial_leggings", BTD_A, 2, 2), "tutorial_leggings");
		GameRegistry.registerItem(
				tutorialBoots = new ItemModArmor("tutorial_boots", BTD_A, 1, 3),
				"tutorial_boots");
		
		GameRegistry.registerItem(tutorialChocolate = new ItemModFood("tutorial_chocolate", 2, 0.2f, false,
				new PotionEffect(Potion.moveSpeed.id, 1200, 1),
				new PotionEffect(Potion.jump.id, 600, 0),
				new PotionEffect(Potion.regeneration.id, 200, 1))
				.setAlwaysEdible(), "tutorial_chocolate");
		
		GameRegistry.registerItem(tutorialLuckyCandy = new ItemModAdvancedFood("tutorial_lucky_candy", 1, 0.5f, false)
			    .addPotionEffect(new PotionEffect(Potion.regeneration.id, 200, 4), 0.5)
			    .addPotionEffect(new PotionEffect(Potion.wither.id, 200, 4), 0.5)
			    .setAlwaysEdible(), "tutorial_lucky_candy");
	}
}
