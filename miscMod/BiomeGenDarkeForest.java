package miscMod;

import miscMod.biomes.BiomeInfo;
import miscMod.blocks.BlockInfo;
import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenDarkeForest extends BiomeGenBase {
	public BiomeGenDarkeForest(int id) {
		super(id);
		setBiomeName(BiomeInfo.BDF_NAME);
		//setColor(Color.DARK_GRAY.getRGB());
		setMinMaxHeight(-1F, 1F);
		this.setTemperatureRainfall(0F, 0.9F);
		
		this.topBlock = (byte)(BlockInfo.DIRT_ID);
		this.fillerBlock = (byte)(Block.dirt.blockID);
	}
}
