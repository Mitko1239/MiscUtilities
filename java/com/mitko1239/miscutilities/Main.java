package com.mitko1239.miscutilities;

import com.mitko1239.miscutilities.creativetabs.ModCreativeTabs;
import com.mitko1239.miscutilities.items.CakeEatHandler;
import com.mitko1239.miscutilities.utilities.ArmorTickHandler;
import com.mitko1239.miscutilities.utilities.MagnetHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Main.MODID, name = Main.MODNAME, version = Main.VERSION)
public class Main {
	public static final String MODID = "miscutilities";
	public static final String MODNAME = "Miscellaneous Utilities";
	public static final String VERSION = "1.1.0";
	public static final ModCreativeTabs creativeTab = new ModCreativeTabs();
	
	@Instance
	public static Main instance = new Main();
	
	@SidedProxy(clientSide="com.mitko1239."+MODID+".ClientProxy", serverSide="com.mitko1239."+MODID+".ServerProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		Main.proxy.preInit(e);
        MinecraftForge.EVENT_BUS.register(new ArmorTickHandler());
        MinecraftForge.EVENT_BUS.register(new CakeEatHandler());
        MinecraftForge.EVENT_BUS.register(new MagnetHandler());
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
