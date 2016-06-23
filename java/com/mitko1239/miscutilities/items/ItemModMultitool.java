package com.mitko1239.miscutilities.items;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.mitko1239.miscutilities.Main;
import com.mitko1239.miscutilities.blocks.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static com.mitko1239.miscutilities.blocks.ModBlocks.*;
import static net.minecraft.init.Blocks.*;

public class ItemModMultitool extends ItemPickaxe {

	protected ItemModMultitool(String unlocalizedName, ToolMaterial material) {
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(Main.creativeTab);
	}

	@Override
	public Set<String> getToolClasses(ItemStack stack) {
		return ImmutableSet.of("pickaxe", "axe", "shovel");
	}


//	private static Set effectiveAgainst = Sets
//			.newHashSet(GRASS, DIRT, SAND,
//					GRAVEL, SNOW_LAYER, SNOW, CLAY,
//					FARMLAND, SOUL_SAND, MYCELIUM,
//
//					PLANKS, BOOKSHELF, LOG, LOG2,
//					CHEST, PUMPKIN, LIT_PUMPKIN,
//
//                    bluestoneOre, randomOre,
//                    propertyBlock, tutorialBlock);

	public static final Block[] SET_VALUES = new Block[] { GRASS, DIRT, SAND,
			GRAVEL, SNOW_LAYER, SNOW, CLAY,
			FARMLAND, SOUL_SAND, MYCELIUM,

			PLANKS, BOOKSHELF, LOG, LOG2,
			CHEST, PUMPKIN, LIT_PUMPKIN,

			bluestoneOre, randomOre,
			COLORED_COBBLESTONE, tutorialBlock };
	private static Set<Block> effectiveAgainst = new HashSet<>(Arrays.asList(SET_VALUES));

	@Override
	public boolean canHarvestBlock(IBlockState state) {
		return effectiveAgainst.contains(state) || super.canHarvestBlock(state);
	}

	@Override
	public float getStrVsBlock(ItemStack stack, IBlockState state) {
		if (state.getMaterial() == Material.WOOD
				|| state.getMaterial() == Material.VINE
				|| state.getMaterial() == Material.PLANTS)
			return this.efficiencyOnProperMaterial;
		return effectiveAgainst.contains(state)
				? this.efficiencyOnProperMaterial
				: super.getStrVsBlock(stack, state);
	}

	@Override
	public EnumActionResult onItemUse(ItemStack stack, EntityPlayer player, World world,
                                      BlockPos pos, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {

        if (!player.canPlayerEdit(pos.offset(side), side, stack)) {
			return EnumActionResult.FAIL;
		} else {
			int hook = net.minecraftforge.event.ForgeEventFactory
					.onHoeUse(stack, player, world, pos);
			if (hook != 0)
				return EnumActionResult.FAIL;

			IBlockState iblockstate = world.getBlockState(pos);
			Block block = iblockstate.getBlock();

			if (side != EnumFacing.DOWN && world.isAirBlock(pos.up())) {
				if (block == GRASS) {
                    this.useHoe(stack, player, world, pos, GRASS_PATH.getDefaultState());
//					this.useHoe(stack, player, world, pos,
//							farmland.getDefaultState());
					return EnumActionResult.SUCCESS;
				}

				if (block == DIRT) {
					switch (SwitchDirtType.TYPE_LOOKUP[(iblockstate
							.getValue(BlockDirt.VARIANT)).ordinal()]) {
						case 1 :
							this.useHoe(stack, player, world, pos,
									FARMLAND.getDefaultState());
							return EnumActionResult.SUCCESS;
						case 2 :
							this.useHoe(stack, player, world, pos,
									DIRT.getDefaultState().withProperty(
											BlockDirt.VARIANT,
											BlockDirt.DirtType.DIRT));
							return EnumActionResult.SUCCESS;
					}
				}
			}

			return EnumActionResult.PASS;
		}
	}



    protected boolean useHoe(ItemStack stack, EntityPlayer player, World worldIn, BlockPos target, IBlockState newState) {
        worldIn.playSound(player,target.getX()+0.5F,target.getY()+0.5F,target.getZ()+0.5F, SoundEvents.ITEM_HOE_TILL,SoundCategory.BLOCKS,newState.getBlock().getSoundType().volume+1.0F,newState.getBlock().getSoundType().pitch*0.8F);
//		worldIn.playSound(player, target.getX() + 0.5F, target.getY() + 0.5F,
//				target.getZ() + 0.5F,
//				newState.getBlock().getStepSound(),
//				(newState.getBlock().getStepSound().volume + 1.0F) / 2.0F,
//				newState.getBlock().getStepSound().pitch* 0.8F);

		if (worldIn.isRemote) {
			return true;
		} else {
			worldIn.setBlockState(target, newState);
			stack.damageItem(1, player);
			return true;
		}
	}

	static final class SwitchDirtType {

		static final int[] TYPE_LOOKUP = new int[BlockDirt.DirtType
				.values().length];

		static {
			try {
				TYPE_LOOKUP[BlockDirt.DirtType.DIRT.ordinal()] = 1;
			} catch (NoSuchFieldError var2) {
            }

			try {
				TYPE_LOOKUP[BlockDirt.DirtType.COARSE_DIRT.ordinal()] = 2;
			} catch (NoSuchFieldError var1) {
            }
		}
	}

}
