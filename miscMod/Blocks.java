package miscMod;

import miscMod.blocks.BlockAbysmalFont;
import miscMod.blocks.BlockBlackRock;
import miscMod.blocks.BlockDarkStone;
import miscMod.blocks.BlockDarkeDirt;
import miscMod.blocks.BlockDust;
import miscMod.blocks.BlockFlightTable;
import miscMod.blocks.BlockInfo;
import miscMod.blocks.BlockMachine;
import miscMod.blocks.BlockMoldRemover;
import miscMod.blocks.BuildPlantBlock;
import miscMod.blocks.CardMountain;
import miscMod.blocks.CardTable;
import miscMod.blocks.DustLamp;
import miscMod.blocks.LavaStone;
import miscMod.blocks.MestronLog;
import miscMod.blocks.MestronPlanks;
import miscMod.blocks.MoldyBlock;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;


public class Blocks
{
	public static Block machine;
	public static Block DarkStone;
	public static Block Mold;
	public static Block Remover;
	public static Block LavaStone;
	public static Block MestronLog;
	public static Block MestronPlanks;
	public static Block CardTable;
	public static Block DustLamp;
	public static Block FlightTable;
	public static Block MountainCard;
	public static Block BuildPlant;
	public static Block BlackRock;
	public static Block DustBlock;
	public static Block AbysmalFont;
	public static Block DarkeDirt;

	public static void init()
	{
		machine = new BlockMachine(BlockInfo.MACHINE_ID);
		DarkStone = new BlockDarkStone(BlockInfo.DARKSTONE_ID);
		Mold = new MoldyBlock(BlockInfo.MOLD_ID);
		Remover = new BlockMoldRemover(BlockInfo.REMOVER_ID);
		LavaStone = new LavaStone(BlockInfo.LAVASTONE_ID);
		MestronLog = new MestronLog(BlockInfo.MLOG_ID);
		MestronPlanks = new MestronPlanks(BlockInfo.MPLANK_ID);
		CardTable = new CardTable(BlockInfo.CARDTABLE_ID);
		DustLamp = new DustLamp(BlockInfo.LAMP_ID);
		FlightTable = new BlockFlightTable(BlockInfo.FLIGHTTABLE_ID);
		MountainCard = new CardMountain(BlockInfo.MOUNTAINCARD_ID);
		BuildPlant = new BuildPlantBlock(BlockInfo.BUILDPLANT_ID);
		BlackRock = new BlockBlackRock(BlockInfo.BLACKROCK_ID);
		DustBlock = new BlockDust(BlockInfo.DUSTBLOCK_ID);
		AbysmalFont = new BlockAbysmalFont(BlockInfo.ABYSMAL_ID);
		DarkeDirt = new BlockDarkeDirt(BlockInfo.DIRT_ID);

		GameRegistry.registerBlock(machine, BlockInfo.MACHINE_KEY);
		GameRegistry.registerBlock(DarkStone, BlockInfo.DARKSTONE_KEY);
		GameRegistry.registerBlock(Mold, BlockInfo.MOLD_KEY);
		GameRegistry.registerBlock(Remover, BlockInfo.REMOVER_KEY);
		GameRegistry.registerBlock(LavaStone, BlockInfo.LAVASTONE_KEY);
		GameRegistry.registerBlock(MestronLog, BlockInfo.MLOG_KEY);
		GameRegistry.registerBlock(MestronPlanks, BlockInfo.MPLANK_KEY);
		GameRegistry.registerBlock(CardTable, BlockInfo.CARDTABLE_KEY);
		GameRegistry.registerBlock(DustLamp, BlockInfo.LAMP_KEY);
		GameRegistry.registerBlock(FlightTable, BlockInfo.FLIGHTTALBE_KEY);
		GameRegistry.registerBlock(MountainCard, BlockInfo.MOUNTAINCARD_KEY);
		GameRegistry.registerBlock(BuildPlant, BlockInfo.BUILDPLANT_KEY);
		GameRegistry.registerBlock(BlackRock, BlockInfo.BLACKROCK_KEY);
		GameRegistry.registerBlock(DustBlock, BlockInfo.DUSTBLOCK_KEY);
		GameRegistry.registerBlock(AbysmalFont, BlockInfo.ABYSMAL_KEY);
		GameRegistry.registerBlock(DarkeDirt, BlockInfo.DIRT_KEY);
	}

	public static void addNames()
	{
		LanguageRegistry.addName(machine, BlockInfo.MACHINE_NAME);
		LanguageRegistry.addName(DarkStone, BlockInfo.DARKSTONE_NAME);
		LanguageRegistry.addName(Mold, BlockInfo.MOLD_NAME);
		LanguageRegistry.addName(Remover, BlockInfo.REMOVER_NAME);
		LanguageRegistry.addName(LavaStone, BlockInfo.LAVASTONE_NAME);
		LanguageRegistry.addName(MestronLog, BlockInfo.MLOG_NAME);
		LanguageRegistry.addName(MestronPlanks, BlockInfo.MPLANK_NAME);
		LanguageRegistry.addName(CardTable, BlockInfo.CARDTABLE_NAME);
		LanguageRegistry.addName(DustLamp, BlockInfo.LAMP_NAME);
		LanguageRegistry.addName(FlightTable, BlockInfo.FLIGHTTABLE_NAME);
		LanguageRegistry.addName(MountainCard, BlockInfo.MOUNTAINCARD_NAME);
		LanguageRegistry.addName(BuildPlant, BlockInfo.BUILDPLANT_NAME);
		LanguageRegistry.addName(BlackRock, BlockInfo.BLACKROCK_NAME);
		LanguageRegistry.addName(DustBlock, BlockInfo.DUSTBLOCK_NAME);
		LanguageRegistry.addName(AbysmalFont, BlockInfo.ABYSMAL_NAME);
		LanguageRegistry.addName(DarkeDirt, BlockInfo.DIRT_NAME);
	}

	public static void registerRecipes()
	{
		GameRegistry.addRecipe(new ItemStack(CardTable), "WWW", "GRG", "GBG", 'W', new ItemStack(Block.cloth, 1, 8), 'G', new ItemStack(Item.ingotGold), 'B', new ItemStack(Block.cloth, 1, 11), 'R', new ItemStack(Item.redstone));
		GameRegistry.addRecipe(new ItemStack(FlightTable), "EWE", "FDF", "EEE", 'E', new ItemStack(Item.emerald), 'W', new ItemStack(Block.cloth, 1, 8), 'F',  new ItemStack(Item.feather), 'D', new ItemStack(Block.blockDiamond));
		GameRegistry.addRecipe(new ItemStack(DustLamp), " D ", "DGD", " D ", 'G', new ItemStack(Block.glowStone), 'D', new ItemStack(Items.dust));
		GameRegistry.addRecipe(new ItemStack(DustBlock), "dd", "dd", 'd', new ItemStack(Items.dust));

		OreDictionary.registerOre("logWood", new ItemStack(MestronLog));
		OreDictionary.registerOre("plankWood", new ItemStack(MestronPlanks));


		GameRegistry.addShapelessRecipe(new ItemStack(MestronPlanks, 4), new ItemStack(MestronLog));
		GameRegistry.addShapelessRecipe(new ItemStack(LavaStone), new ItemStack(Item.bucketLava), new ItemStack(Block.stone));
		GameRegistry.addShapelessRecipe(new ItemStack(BlackRock), new ItemStack(Block.stone), new ItemStack(Item.coal));
		GameRegistry.addShapelessRecipe(new ItemStack(BlackRock), new ItemStack(DarkStone), new ItemStack(Item.coal));
	}
}