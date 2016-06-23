package com.mitko1239.miscutilities.blocks;

import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public interface IMetaBlockName {
	String getSpecialName(ItemStack stack);

	ItemStack getPickBlock(RayTraceResult target, World world,
						   BlockPos pos);
}
