package com.mitko1239.modone;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Main.MODID, name = Main.MODNAME, version = Main.VERSION)
public class Main {
	public static final String MODID = "modone";
	public static final String MODNAME = "undefined's First Mod";
	public static final String VERSION = "1.0.0";
	
	@Instance
	public static Main instance = new Main();
	
	@SidedProxy(clientSide="com.mitko1239.modone.ClientProxy", serverSide="com.mitko1239.modone.ServerProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		Main.proxy.preInit(e);
	}
	
    @EventHandler
    public void init(FMLInitializationEvent e) {
    	Main.proxy.init(e);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {
    	Main.proxy.postInit(e);
    }
}
