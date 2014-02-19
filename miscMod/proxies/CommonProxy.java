package miscMod.proxies;

import miscMod.blocks.BasketRendererSpecialRenderer;
import miscMod.tileentity.TileEntityCardMountainEntity;
import cpw.mods.fml.client.registry.ClientRegistry;

public class CommonProxy
{

	public void initSounds()
	{
		
	}

	public void initRenderers()
	{
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCardMountainEntity.class, new BasketRendererSpecialRenderer());
	}
	
}
