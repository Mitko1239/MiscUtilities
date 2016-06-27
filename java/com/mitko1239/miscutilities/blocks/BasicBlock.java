package com.mitko1239.miscutilities.blocks;

import com.mitko1239.miscutilities.Main;
import com.mitko1239.miscutilities.creativetabs.ModCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BasicBlock extends Block {
	public BasicBlock(Material material, float hardness, float resistance, SoundType stepSound, String blockName) {
		super(material);
		this.setCreativeTab(Main.creativeTab);
		this.setHardness(hardness);
		this.setResistance(resistance);
		this.setSoundType(stepSound);
		setBlockName(this, blockName);
	}

	public static void setBlockName(Block block, String blockName) {
		block.setRegistryName(Main.MODID, blockName);
		block.setUnlocalizedName(blockName);
	}
	
	public BasicBlock(float hardness, float resistance, String blockName) {
		this(Material.ROCK, hardness, resistance, SoundType.GLASS, blockName);
	}
	
	public BasicBlock(String blockName) {
		this(2.0f, 10.0f, blockName);
	}
}
