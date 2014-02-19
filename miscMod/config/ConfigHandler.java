package miscMod.config;

import miscMod.items.ItemInfo;

import java.io.File;

import miscMod.biomes.BiomeInfo;
import miscMod.blocks.BlockInfo;
import net.minecraftforge.common.Configuration;

public class ConfigHandler
{
	public static void init(File file)
	{
		Configuration config = new Configuration(file);
		
		config.load();
		//items
		ItemInfo.STAFF_ID = config.getItem(ItemInfo.STAFF_KEY, ItemInfo.STAFF_DEFAULT_ID).getInt() - 256;
		ItemInfo.Card_ID = config.getItem(ItemInfo.CARD_KEY, ItemInfo.CARD_DEFAULT_ID).getInt() - 256;
		ItemInfo.WAND_ID = config.getItem(ItemInfo.WAND_KEY, ItemInfo.WAND_DEFAULT_ID).getInt() - 256;
		ItemInfo.DUST_ID = config.getItem(ItemInfo.DUST_KEY, ItemInfo.DUST_DEFAULT_ID).getInt() - 256;
		ItemInfo.DERPCOIN_ID = config.getItem(ItemInfo.DERPCOIN_KEY, ItemInfo.DERPCOIN_DEFAULT_ID).getInt() - 256;
		ItemInfo.DUSTBOTTLE_ID = config.getItem(ItemInfo.DUSTBOTTLE_KEY, ItemInfo.DUSTBOTTLE_DEFAULT_ID).getInt() - 256;
		
		//blocks
		BlockInfo.MACHINE_ID = config.getBlock(BlockInfo.MACHINE_KEY, BlockInfo.MACHINE_DEFAULT_ID).getInt() - 256;
		BlockInfo.DARKSTONE_ID = config.getBlock(BlockInfo.DARKSTONE_KEY, BlockInfo.DARKSTONE_DEFAULT_ID).getInt() - 256;
		BlockInfo.MOLD_ID = config.getBlock(BlockInfo.MOLD_KEY, BlockInfo.MOLD_DEFAULT_ID).getInt() - 256;
		BlockInfo.REMOVER_ID = config.getBlock(BlockInfo.REMOVER_KEY, BlockInfo.REMOVER_DEFAULT_ID).getInt() - 256;
		BlockInfo.LAVASTONE_ID = config.getBlock(BlockInfo.LAVASTONE_KEY, BlockInfo.LAVASTONE_DEFAULT_ID).getInt() - 256;
		BlockInfo.MLOG_ID = config.getBlock(BlockInfo.MLOG_KEY, BlockInfo.MLOG_DEFAULT_ID).getInt() - 256;
		BlockInfo.MPLANK_ID = config.getBlock(BlockInfo.MPLANK_KEY, BlockInfo.MPLANK_DEFAULT_ID).getInt() - 256;
		BlockInfo.CARDTABLE_ID = config.getBlock(BlockInfo.CARDTABLE_KEY, BlockInfo.CARDTABLE_DEFAULT_ID).getInt() - 256;
		BlockInfo.LAMP_ID = config.getBlock(BlockInfo.LAMP_KEY, BlockInfo.LAMP_DEFAULT_ID).getInt() - 256;
		BlockInfo.FLIGHTTABLE_ID = config.getBlock(BlockInfo.FLIGHTTALBE_KEY, BlockInfo.FLIGHTTABLE_DEFAULT_ID).getInt() - 256;
		BlockInfo.MOUNTAINCARD_ID = config.getBlock(BlockInfo.MOUNTAINCARD_KEY, BlockInfo.MOUNTAINCARD_DEFAULT_ID).getInt() - 256;
		BlockInfo.BUILDPLANT_ID = config.getBlock(BlockInfo.BUILDPLANT_KEY, BlockInfo.BUILDPLANT_DEFAULT_ID).getInt() - 256;
		BlockInfo.BLACKROCK_ID = config.getBlock(BlockInfo.BLACKROCK_KEY, BlockInfo.BLACKROCK_DEFAULT_ID).getInt() - 256;
		BlockInfo.DUSTBLOCK_ID = config.getBlock(BlockInfo.DUSTBLOCK_KEY, BlockInfo.DUSTBLOCK_DEFAULT_ID).getInt() - 256;
		BlockInfo.ABYSMAL_ID = config.getBlock(BlockInfo.ABYSMAL_KEY, BlockInfo.ABYSMAL_DEFAULT_ID).getInt() - 256;
		BlockInfo.DIRT_ID = config.getBlock(BlockInfo.DIRT_KEY, BlockInfo.DIRT_DEFAULT_ID).getInt() - 256;
		
		config.addCustomCategoryComment("biome", "Biomes");	
		BiomeInfo.BDP_ID = config.get("biome", "BiomeGenDarkePlain", 103).getInt();
		config.save();
		
	}
}
