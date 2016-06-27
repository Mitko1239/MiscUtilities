package com.mitko1239.miscutilities.client.render.blocks;

import com.mitko1239.miscutilities.Main;
import com.mitko1239.miscutilities.blocks.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;

import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class BlockRenderRegister {
	public static String modid = Main.MODID;

	public static void preInit() {
        final String colors[] = {"black", "white"};
        ResourceLocation[] resLoc = new ResourceLocation[2];
        for (int i=0; i < 2; i++)
            resLoc[i] = new ResourceLocation(modid + ":colored_cobblestone_" + colors[i]);

            ModelBakery.registerItemVariants(Item.getItemFromBlock(ModBlocks.COLORED_COBBLESTONE), resLoc);


		final String variants[] = {"rose", "paeonia", "cyan"};
		ResourceLocation[] resLoc2 = new ResourceLocation[3];
		for (int i=0; i < 3; i++)
			resLoc2[i] = new ResourceLocation(modid + ":flower_" + variants[i]);

			ModelBakery.registerItemVariants(Item.getItemFromBlock(ModBlocks.FLOWER), resLoc2);

	}

	public static void registerBlockRenderer() {
		reg(ModBlocks.BLUESTONE);
		reg(ModBlocks.bluestoneOre);
		reg(ModBlocks.randomOre);
		reg(ModBlocks.FLOWER, 0, "flower_rose");
		reg(ModBlocks.FLOWER, 1, "flower_paeonia");
		reg(ModBlocks.FLOWER, 2, "flower_cyan");
		reg(ModBlocks.COLORED_COBBLESTONE, 0, "colored_cobblestone_white");
		reg(ModBlocks.COLORED_COBBLESTONE, 1, "colored_cobblestone_black");
	}

	public static void reg(Block block) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0,
                new ModelResourceLocation(modid + ":" + block.getUnlocalizedName().substring(5), "inventory"));
	}

	public static void reg(Block block, int meta, String file) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(
				Item.getItemFromBlock(block), meta,
				new ModelResourceLocation(modid + ":" + file, "inventory"));
	}
}
