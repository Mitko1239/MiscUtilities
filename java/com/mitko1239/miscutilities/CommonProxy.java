package com.mitko1239.miscutilities;

import com.mitko1239.miscutilities.blocks.ModBlocks;
import com.mitko1239.miscutilities.crafting.ModCrafting;
import com.mitko1239.miscutilities.items.ModItems;
import com.mitko1239.miscutilities.world.TutorialWorldGen;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {
	public void preInit(FMLPreInitializationEvent e) {
		ModItems.createItems();
		ModBlocks.createBlocks();
	}
	
	public void init(FMLInitializationEvent e) {
		ModCrafting.initCrafting();
		GameRegistry.registerWorldGenerator(new TutorialWorldGen(), 0);
	}
	
	public void postInit(FMLPostInitializationEvent e) {
		
	}
}
