package miscMod;

import java.awt.Color;

import miscMod.biomes.BiomeGenDarkePlain;
import miscMod.biomes.BiomeInfo;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.common.registry.GameRegistry;

public class Biomes {
	public static BiomeGenBase DarkeForest;
	
	public static void init(){
		DarkeForest = new BiomeGenDarkeForest(BiomeInfo.BDF_ID);
		
		GameRegistry.addBiome(DarkeForest);
		GameRegistry.addBiome(new BiomeGenDarkePlain(BiomeInfo.BDP_ID));
	}
}
