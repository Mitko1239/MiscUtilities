package com.mitko1239.miscutilities.world;

import java.util.Random;

import com.mitko1239.miscutilities.blocks.ModBlocks;

import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class TutorialWorldGen implements IWorldGenerator {

	private WorldGenerator gen_bluestoneOre;
	private WorldGenerator gen_randomOre;
	private WorldGenerator gen_cobblestone;

	public TutorialWorldGen() {
		this.gen_bluestoneOre = new WorldGenMinable(
				ModBlocks.bluestoneOre.getDefaultState(), 8);
		this.gen_randomOre = new WorldGenSingleMinable(
				ModBlocks.randomOre.getDefaultState());
		this.gen_cobblestone = new WorldGenMinable(
				Blocks.COBBLESTONE.getDefaultState(), 16,
				BlockMatcher.forBlock(Blocks.END_STONE));
	}

//	@Override
//	public void generate(Random random, int chunkX, int chunkZ, World world,
//			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
//		switch (world.provider.getDimensionType()) {
//			case OVERWORLD: // Overworld
//				this.runGenerator(this.gen_bluestoneOre, world, random, chunkX,
//						chunkZ, 20, 0, 64);
//				this.runGenerator(this.gen_randomOre, world, random, chunkX,
//						chunkZ, 10, 0, 16);
//				break;
//			case NETHER: // Nether
//				this.runGenerator(this.gen_cobblestone, world, random, chunkX, chunkZ, 10, 0, 80);
//				break;
//			case THE_END: // End
//
//				break;
//		}
//	}

	private void runGenerator(WorldGenerator generator, World world,
			Random rand, int chunk_X, int chunk_Z, int chancesToSpawn,
			int minHeight, int maxHeight) {
		if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
			throw new IllegalArgumentException(
					"Illegal Height Arguments for WorldGenerator");

		int heightDiff = maxHeight - minHeight + 1;
		for (int i = 0; i < chancesToSpawn; i++) {
			int x = chunk_X * 16 + rand.nextInt(16);
			int y = minHeight + rand.nextInt(heightDiff);
			int z = chunk_Z * 16 + rand.nextInt(16);
			generator.generate(world, rand, new BlockPos(x, y, z));
		}
	}

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.getDimensionType()) {
            case OVERWORLD: // Overworld
                this.runGenerator(this.gen_bluestoneOre, world, random, chunkX,
                        chunkZ, 20, 0, 64);
                this.runGenerator(this.gen_randomOre, world, random, chunkX,
                        chunkZ, 10, 0, 16);
                break;
            case NETHER: // Nether
                this.runGenerator(this.gen_cobblestone, world, random, chunkX, chunkZ, 10, 0, 80);
                break;
            case THE_END: // End

                break;
        }
    }
}
