package com.mitko1239.modone.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class ModBlocks {
	
	public static Block tutorialBlock;
	public static Block propertyBlock;
	
	public static void createBlocks() {
		GameRegistry.registerBlock(propertyBlock = new BlockProperties("block_properties"), ItemBlockMeta.class, "block_properties");
		GameRegistry.registerBlock(tutorialBlock = new BasicBlock("tutorial_block", Material.glass, 0.5F, 10.0F).setLightLevel(1.0f).setStepSound(Block.soundTypeGlass), "tutorial_block");
	}
}