package com.mitko1239.modone;

import com.mitko1239.modone.client.render.blocks.BlockRenderRegister;
import com.mitko1239.modone.client.render.items.ItemRenderRegister;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
	public void preInit(FMLPreInitializationEvent e) {
		super.preInit(e);
		
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
