package miscMod;
import java.util.Random;

import miscMod.config.ConfigHandler;
import miscMod.proxies.CommonProxy;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.DimensionManager;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = ModInfo.ID, name = ModInfo.NAME, version = ModInfo.VERSION)
@NetworkMod(channels = {ModInfo.CHANNEL}, clientSideRequired = true, serverSideRequired = false)

public class MiscMod
{	
	@Instance(ModInfo.ID)
	public static MiscMod instance;

	@SidedProxy(clientSide = "miscMod.proxies.ClientProxy", serverSide = "miscMod.proxies.CommonProxy")
	public static CommonProxy proxy;

	Generator gen = new Generator();

	public static int dimensionId = 3;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		//sounds, textures, items, blocks, config, other mod affecting things
		ConfigHandler.init(event.getSuggestedConfigurationFile());
		Items.init();
		Blocks.init();
		proxy.initSounds();
		proxy.initRenderers();
		Biomes.init();

		GameRegistry.registerWorldGenerator(gen);

		DimensionManager.registerProviderType(dimensionId, DarkeRealmeWorldProvider.class, false);
		DimensionManager.registerDimension(dimensionId, dimensionId);
	}

	@EventHandler
	public void Init(FMLInitializationEvent event)
	{
		//Recipes, Handlers, Data
		Items.addNames();
		Items.registerRecipes();
		Blocks.addNames();
		Blocks.registerRecipes();
	}

	@EventHandler
	public void PostInit(FMLPostInitializationEvent event)
	{

	}
}
