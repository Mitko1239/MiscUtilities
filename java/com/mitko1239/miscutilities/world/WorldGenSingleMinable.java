package com.mitko1239.miscutilities.world;

import java.util.Random;

import com.google.common.base.Predicate;

import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenSingleMinable extends WorldGenerator {

	private IBlockState block;
	private Predicate<IBlockState> target;
	
	public WorldGenSingleMinable(IBlockState block, Predicate<IBlockState> target) {
		this.block = block;
		this.target = target;
	}
	
	@SuppressWarnings("unchecked")
	public WorldGenSingleMinable(IBlockState block) {
		this(block, BlockMatcher.forBlock(Blocks.STONE));
	}

	@Override
	public boolean generate(World world, Random random, BlockPos pos) {
		if(world.getBlockState(pos).getBlock().isReplaceableOreGen(world.getBlockState(pos), world, pos, this.target))
			world.setBlockState(pos, this.block);
		return true;
	}

}
