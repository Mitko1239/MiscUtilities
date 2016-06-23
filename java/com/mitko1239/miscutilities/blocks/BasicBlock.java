package com.mitko1239.miscutilities.blocks;

import com.mitko1239.miscutilities.Main;
import com.mitko1239.miscutilities.creativetabs.ModCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BasicBlock extends Block {
	public BasicBlock(String unlocalizedName, Material material, float hardness, float resistance, SoundType stepSound) {
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(Main.creativeTab);
		this.setHardness(hardness);
		this.setResistance(resistance);
		this.setSoundType(stepSound);
	}
	
	public BasicBlock(String unlocalizedName, float hardness, float resistance) {
		this(unlocalizedName, Material.ROCK, hardness, resistance, SoundType.GLASS);
	}
	
	public BasicBlock(String unlocalizedName) {
		this(unlocalizedName, 2.0f, 10.0f);
	}
}
