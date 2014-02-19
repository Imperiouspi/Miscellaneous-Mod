package miscMod;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderHell;

public class DarkeRealmeWorldProvider extends WorldProvider{

	public void registerWorldChunkManager()
    {
        this.worldChunkMgr = new WorldChunkManagerHell(BiomeGenBase.desert, 0.8F, 0.1F);
        this.dimensionId = 3;
    }
	
	@Override
	public String getDimensionName() {
		return "The Darke Realm";
	}
	
	@Override
	public boolean isSurfaceWorld(){
		return false;
	}
	
	@Override
	public boolean canRespawnHere(){
		return false;
	}
	
	@Override
	public String getWelcomeMessage(){
		return "Entering the Darke Realm";
	}
	
	@Override
	public String getDepartMessage(){
		return "Leaving the Darke Realm";
	}
	
	public IChunkProvider createChunkGenerator()
    {
        return new ChunkProviderDarkeRealme(this.worldObj, this.worldObj.getSeed(), true);
    }
}
