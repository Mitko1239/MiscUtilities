package com.mitko1239.miscutilities.crafting;

import com.mitko1239.miscutilities.blocks.ModBlocks;
import com.mitko1239.miscutilities.items.ModItems;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModCrafting {
	public static void initCrafting() {
		GameRegistry.addRecipe(new ItemStack(ModBlocks.tutorialBlock), "##",
				"##", '#', ModItems.bluestone);
		GameRegistry.addRecipe(new ItemStack(ModItems.magnet), "R L",
				"I I", "I#I", 'R', Items.REDSTONE, 'L', new ItemStack(Items.DYE, 1, 4), 'I', Items.IRON_INGOT, '#', Items.ENDER_PEARL);
		GameRegistry.addRecipe(new ItemStack(ModItems.luckyCandy, 2, 0), " # ",
				"#I#", " # ", '#', ModItems.randomEssence, 'I', Items.COOKIE);
		GameRegistry.addRecipe(new ItemStack(ModItems.chocolate, 4, 0), "###", "#I#", "###", '#', new ItemStack(Items.DYE, 1, 3), 'I', Items.MILK_BUCKET);
		
		GameRegistry.addRecipe(new ItemStack(ModBlocks.COLORED_COBBLESTONE, 8, 0),
				"###", "#I#", "###", '#', Blocks.COBBLESTONE, 'I',
				new ItemStack(Items.DYE, 1, 15));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.COLORED_COBBLESTONE, 8, 1),
				"###", "#I#", "###", '#', Blocks.COBBLESTONE, 'I',
				new ItemStack(Items.DYE, 1, 0));
		
		GameRegistry.addShapelessRecipe(
				new ItemStack(ModItems.bluestone, 4, 0),
				ModBlocks.tutorialBlock);

		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.chocolateMilk, 1), Items.MILK_BUCKET, ModItems.chocolate);
		GameRegistry.addRecipe(new ItemStack(ModItems.chocolateCake), "###", "SES", "WWW", '#', ModItems.chocolateMilk, 'S', Items.SUGAR, 'E', Items.EGG, 'W', Items.WHEAT);
		
		// GameRegistry.addSmelting(Items.diamond,
		// new ItemStack(ModItems.tutorialItem), 1.0F);

        GameRegistry.addSmelting(ModBlocks.bluestoneOre, new ItemStack(ModItems.bluestone, 1), 0.5F);
        GameRegistry.addSmelting(ModBlocks.randomOre, new ItemStack(ModItems.randomEssence, 1), 0.5F);

		GameRegistry.addRecipe(new ItemStack(ModItems.tutorialAxe), "## ",
				"#I ", " I ", '#', Items.EMERALD, 'I', Items.STICK);
		GameRegistry.addRecipe(new ItemStack(ModItems.tutorialHoe), "## ",
				" I ", " I ", '#', Items.EMERALD, 'I', Items.STICK);
		GameRegistry.addRecipe(new ItemStack(ModItems.tutorialPickaxe), "###",
				" I ", " I ", '#', Items.EMERALD, 'I', Items.STICK);
		GameRegistry.addRecipe(new ItemStack(ModItems.tutorialSpade), " # ",
				" I ", " I ", '#', Items.EMERALD, 'I', Items.STICK);
		GameRegistry.addRecipe(new ItemStack(ModItems.tutorialSword), " # ",
				" # ", " I ", '#', Items.EMERALD, 'I', Items.STICK);
		GameRegistry.addRecipe(new ItemStack(ModItems.direHammer), " # ",
				"###", "#I#", '#', Items.EMERALD, 'I', Items.STICK);

        GameRegistry.addRecipe(new ItemStack(ModItems.multitool),
                "#IO", " S ", " P ", '#', ModItems.tutorialPickaxe, 'I', ModItems.tutorialSpade, 'O', ModItems.tutorialAxe, 'S', ModItems.tutorialHoe, 'P', Items.STICK);
		
		GameRegistry.addRecipe(new ItemStack(ModItems.tutorialHelmet), "###", "# #", '#', Items.EMERALD);
		GameRegistry.addRecipe(new ItemStack(ModItems.tutorialChestplate), "# #", "###", "###", '#', Items.EMERALD);
		GameRegistry.addRecipe(new ItemStack(ModItems.tutorialLeggings), "###", "# #", "# #", '#', Items.EMERALD);
		GameRegistry.addRecipe(new ItemStack(ModItems.tutorialBoots), "# #", "# #", '#', Items.EMERALD);
	}
}
