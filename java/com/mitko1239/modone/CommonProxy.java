package com.mitko1239.modone;

import com.mitko1239.modone.blocks.ModBlocks;
import com.mitko1239.modone.crafting.ModCrafting;
import com.mitko1239.modone.items.ModItems;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
	public void preInit(FMLPreInitializationEvent e) {
		ModItems.createItems();
		ModBlocks.createBlocks();
	}
	
	public void init(FMLInitializationEvent e) {
		ModCrafting.initCrafting();
	}
	
	public void postInit(FMLPostInitializationEvent e) {
		
	}
}
