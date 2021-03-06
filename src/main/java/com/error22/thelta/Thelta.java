package com.error22.thelta;

import com.error22.thelta.computers.TheltaComputers;
import com.error22.thelta.tubes.TheltaTubes;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Thelta.MODID, version = Thelta.VERSION)
public class Thelta {
	public static final String MODID = "thelta";
	public static final String VERSION = "1.0";

	@Instance(value = MODID)
	public static Thelta INSTANCE;

	@SidedProxy(modId = MODID, clientSide = "com.error22.thelta.ClientContext", serverSide = "com.error22.thelta.Context")
	public static Context context;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(context);

		context.addModule(new TheltaComputers());
		context.addModule(new TheltaTubes());

		context.preInit(event);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		context.init(event);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		context.postInit(event);
	}
}
