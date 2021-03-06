package com.error22.thelta;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class TheltaModule {

	public void loadConfig(Context context) {
	}

	public void init(Context context) {
	}

	public void registerBlocks(Context context) {
	}

	public void registerItems(Context context) {
	}

	public void registerRecipes(Context context) {
	}

	public void registerSounds(Context context) {
	}

	public void registerEntities(Context context) {
	}

	public void registerWorldGenerators(Context context) {
	}

	@SideOnly(Side.CLIENT)
	public void registerRenderers(ClientContext context) {
	}
	
	@SideOnly(Side.CLIENT)
	public void registerModels(ClientContext context) {
	}
	
	@SideOnly(Side.CLIENT)
	public void loadTextures(ClientContext context) {
	}
	
	@SideOnly(Side.CLIENT)
	public void loadModels(ClientContext context) {
	}
	
	public void lateInit(Context context) {
	}

	public void postInit(Context context) {
	}
}
