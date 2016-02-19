package com.mitko1239.miscutilities;

import com.mitko1239.miscutilities.client.render.blocks.BlockRenderRegister;
import com.mitko1239.miscutilities.client.render.items.ItemRenderRegister;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
	public void preInit(FMLPreInitializationEvent e) {
		super.preInit(e);
		ItemRenderRegister.preInit();
		BlockRenderRegister.preInit();
	}
	
	public void init(FMLInitializationEvent e) {
		super.init(e);
		
		ItemRenderRegister.registerItemRenderer();
		BlockRenderRegister.registerBlockRenderer();
	}
	
	public void postInit(FMLPostInitializationEvent e) {
		super.postInit(e);
	}
}
