package com.mitko1239.modone.client.render.items;

import com.mitko1239.modone.Main;
import com.mitko1239.modone.items.ModItems;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

public final class ItemRenderRegister {
	
	public static String modid = Main.MODID;
	
	public static void preInit() {
		ModelBakery.addVariantName(ModItems.metaItem, "modone:meta_item_white", "modone:meta_item_black");
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
	}
	


	public static void reg(Item item) {
	    Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
	    .register(item, 0, new ModelResourceLocation(modid + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
	
	public static void reg(Item item, int meta, String file) {
	    Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, new ModelResourceLocation(modid + ":" + file, "inventory"));
	}
}
