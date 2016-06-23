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
        final String colors[] = {"black","white"};
        ResourceLocation[] resLoc = new ResourceLocation[2];
        for (int i=0; i < 2; i++)
            resLoc[i] = new ResourceLocation(modid + ":colored_cobblestone_" + colors[i]);
        try {
            ModelBakery.registerItemVariants(Item.getItemFromBlock(ModBlocks.COLORED_COBBLESTONE), resLoc);
        } catch (NullPointerException e) {
            System.out.println("AAAAH WHY NO WORK?");
        }
	}

	public static void registerBlockRenderer() {
		reg(ModBlocks.tutorialBlock);
		reg(ModBlocks.bluestoneOre);
		reg(ModBlocks.randomOre);
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
