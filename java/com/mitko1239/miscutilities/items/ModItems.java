package com.mitko1239.miscutilities.items;

import com.mitko1239.miscutilities.Main;

import com.mitko1239.miscutilities.blocks.ItemBlockMeta;
import com.mitko1239.miscutilities.blocks.ModBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class ModItems {

	public static String modid = Main.MODID;

	public static ToolMaterial BTD = EnumHelper.addToolMaterial("BTD", 3, 1561, 15.0F, 5.0F, 22);
    public static ToolMaterial BTD_MT = EnumHelper.addToolMaterial("BTD_M", 3, 781, 15.0F, 3.0F, 22);
	public static ArmorMaterial BTD_A = EnumHelper.addArmorMaterial("BTD_A", modid + ":btd", 50, new int[]{3, 8, 6, 3}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F);

	public static Item bluestone;
	public static Item magnet;
	public static Item randomEssence;

//    public static Item tutorialBlockItem;
//    public static Item bluestoneOreItem;
//    public static Item randomOreItem;

	public static Item chocolateMilk;
	public static Item chocolateCake;

	public static Item metaItem;

	public static Item tutorialPickaxe;
	public static Item tutorialSword;
	public static Item tutorialAxe;
	public static Item tutorialSpade;
	public static Item tutorialHoe;
	
	public static Item multitool;
	public static Item direHammer;

	public static Item tutorialHelmet;
	public static Item tutorialChestplate;
	public static Item tutorialLeggings;
	public static Item tutorialBoots;

	public static Item chocolate;
	public static Item luckyCandy;


	public static void createItems() {

		GameRegistry.register(bluestone = new BasicItem("bluestone").setRegistryName(modid, "bluestone"));
		GameRegistry.register(magnet = new ItemMagnet("magnet").setRegistryName(modid, "magnet"));
		GameRegistry.register(randomEssence = new BasicItem("randomEssence").setRegistryName(modid, "randomEssence"));

		GameRegistry.register(chocolateMilk = new ItemBirthdayChocolateMilk("chocolate_milk").setRegistryName(modid, "chocolate_milk"));
		GameRegistry.register(chocolateCake = new ItemBirthdayChocolateCake(Blocks.CAKE, "chocolate_cake").setRegistryName(modid, "chocolate_cake"));

		GameRegistry.register(metaItem = new ItemMeta("meta_item").setRegistryName(modid, "meta_item"));

		GameRegistry.register(tutorialPickaxe = new ItemModPickaxe("tutorial_pickaxe", BTD).setRegistryName(modid, "tutorial_pickaxe"));
        GameRegistry.register(tutorialSword = new ItemModSword("tutorial_sword", BTD).setRegistryName(modid, "tutorial_sword"));
        GameRegistry.register(tutorialAxe = new ItemModAxe("tutorial_axe", BTD).setRegistryName(modid, "tutorial_axe"));
        GameRegistry.register(tutorialSpade = new ItemModSpade("tutorial_spade", BTD).setRegistryName(modid, "tutorial_spade"));
        GameRegistry.register(tutorialHoe = new ItemModHoe("tutorial_hoe", BTD).setRegistryName(modid, "tutorial_hoe"));
        GameRegistry.register(multitool = new ItemModMultitool("multitool", BTD_MT).setRegistryName(modid, "multitool"));

		GameRegistry.register(direHammer = new ItemDireHammer("dire_hammer", BTD).setRegistryName(modid, "dire_hammer"));

		GameRegistry.register(tutorialHelmet = new ItemModArmor(
				"tutorial_helmet", BTD_A, 1, EntityEquipmentSlot.HEAD).setRegistryName(modid, "tutorial_helmet"));
		GameRegistry.register(tutorialChestplate = new ItemModArmor(
                "tutorial_chestplate", BTD_A, 1, EntityEquipmentSlot.CHEST).setRegistryName(modid, "tutorial_chestplate"));
		GameRegistry.register(tutorialLeggings = new ItemModArmor(
				"tutorial_leggings", BTD_A, 2, EntityEquipmentSlot.LEGS).setRegistryName(modid, "tutorial_leggings"));
		GameRegistry.register(tutorialBoots = new ItemModArmor(
                "tutorial_boots", BTD_A, 1, EntityEquipmentSlot.FEET).setRegistryName(modid, "tutorial_boots"));

		GameRegistry.register(chocolate = new ItemModFood("chocolate", 2, 0.2f, false,
				new PotionEffect(MobEffects.SPEED, 1200, 1),
				new PotionEffect(MobEffects.JUMP_BOOST, 600, 0),
				new PotionEffect(MobEffects.REGENERATION, 200, 1))
				.setAlwaysEdible().setRegistryName(modid, "chocolate"));


//		GameRegistry.register(tutorialLuckyCandy = new ItemModAdvancedFood("tutorial_lucky_candy", 1, 0.5f, false)
//			    .addPotionEffect(new PotionEffect(Potion.regeneration.id, 200, 4), 0.5)
//			    .addPotionEffect(new PotionEffect(Potion.wither.id, 200, 4), 0.5)
//			    .setAlwaysEdible(), "tutorial_lucky_candy");
		
		GameRegistry.register(luckyCandy = new ItemModFood("lucky_candy", 1, 0.5f, false)
				.setAlwaysEdible().setRegistryName(modid, "lucky_candy"));
	}
}
