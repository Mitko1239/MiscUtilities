package com.mitko1239.miscutilities.client.render.items;

import com.mitko1239.miscutilities.Main;
import com.mitko1239.miscutilities.items.ModItems;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public final class ItemRenderRegister {

	public static String modid = Main.MODID;

	public static void preInit() {
		ModelBakery.registerItemVariants(ModItems.metaItem,
				new ResourceLocation(modid + ":meta_item_white"),
				new ResourceLocation(modid + ":meta_item_black"));
	}

	public static void registerItemRenderer() {
		reg(ModItems.tutorialItem);
		reg(ModItems.metaItem, 0, "meta_item_white");
		reg(ModItems.metaItem, 1, "meta_item_black");
		reg(ModItems.tutorialAxe);
		reg(ModItems.tutorialHoe);
		reg(ModItems.tutorialPickaxe);
		reg(ModItems.tutorialSpade);
		reg(ModItems.tutorialSword);
		reg(ModItems.tutorialMultitool);
		
		reg(ModItems.tutorialHelmet);
		reg(ModItems.tutorialChestplate);
		reg(ModItems.tutorialLeggings);
		reg(ModItems.tutorialBoots);
		
		reg(ModItems.tutorialChocolate);
		reg(ModItems.tutorialLuckyCandy);
	}

	public static void reg(Item item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
				.register(item, 0,
						new ModelResourceLocation(modid + ":"
								+ item.getUnlocalizedName().substring(5),
						"inventory"));
	}

	public static void reg(Item item, int meta, String file) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(
				item, meta,
				new ModelResourceLocation(modid + ":" + file, "inventory"));
	}
}
