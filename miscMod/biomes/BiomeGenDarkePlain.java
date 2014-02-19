package miscMod.biomes;

import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenDarkePlain extends BiomeGenBase{

	public BiomeGenDarkePlain(int id) {
		super(103);
		
		this.theBiomeDecorator.generateLakes = true;
		this.theBiomeDecorator.cactiPerChunk = 2;
		this.theBiomeDecorator.sandPerChunk = 6;
		this.theBiomeDecorator.treesPerChunk = 1;
	}
	
	@Override
	public int getSkyColorByTemp(float par1){
		return 2000000;
	}

}
