package com.mitko1239.modone.crafting;

import com.mitko1239.modone.blocks.ModBlocks;
import com.mitko1239.modone.items.ModItems;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModCrafting {
	public static void initCrafting() {
		GameRegistry.addRecipe(new ItemStack(ModBlocks.tutorialBlock), "##", "##", '#', ModItems.tutorialItem);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.propertyBlock, 8, 0), "###", "#I#", "###", '#', Blocks.cobblestone, 'I', new ItemStack(Items.dye, 1, 15));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.propertyBlock, 8, 1), "###", "#I#", "###", '#', Blocks.cobblestone, 'I', new ItemStack(Items.dye, 1, 0));
		GameRegistry.addSmelting(Items.diamond, new ItemStack(ModItems.tutorialItem), 1.0F);
	}
}
