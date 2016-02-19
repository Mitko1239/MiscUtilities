package com.mitko1239.miscutilities.client.render.blocks;

import com.mitko1239.miscutilities.Main;
import com.mitko1239.miscutilities.blocks.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public final class BlockRenderRegister {
	public static String modid = Main.MODID;

	public static void preInit() {
		ModelBakery.registerItemVariants(
				Item.getItemFromBlock(ModBlocks.propertyBlock),
				new ResourceLocation(modid + ":block_properties_black"),
				new ResourceLocation(modid + ":block_properties_white"));
	}

	public static void registerBlockRenderer() {
		reg(ModBlocks.tutorialBlock);
		reg(ModBlocks.propertyBlock, 0, "block_properties_white");
		reg(ModBlocks.propertyBlock, 1, "block_properties_black");
	}

	public static void reg(Block block) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
				.register(
						Item.getItemFromBlock(
								block),
						0,
						new ModelResourceLocation(modid + ":"
								+ block.getUnlocalizedName().substring(5),
						"inventory"));
	}

	public static void reg(Block block, int meta, String file) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(
				Item.getItemFromBlock(block), meta,
				new ModelResourceLocation(modid + ":" + file, "inventory"));
	}
}
