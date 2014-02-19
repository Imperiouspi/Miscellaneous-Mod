package miscMod;

import miscMod.items.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Items
{
	public static Item staff;
	public static Item card;
	public static Item wand;
	public static Item dust;
	public static Item derpcoin;
	public static Item dustbottle;
	
	public static void init()
	{
		staff = new ItemStaff(ItemInfo.STAFF_ID);
		card = new ItemCard(ItemInfo.Card_ID);
		wand = new Wand(ItemInfo.WAND_ID);
		dust = new ItemDust(ItemInfo.DUST_ID);
		derpcoin = new ItemDerpCoin(ItemInfo.DERPCOIN_ID);
		dustbottle = new ItemDustBottle(ItemInfo.DUSTBOTTLE_ID);
	}
	
	public static void addNames()
	{
		LanguageRegistry.addName(staff, ItemInfo.STAFF_NAME);
		LanguageRegistry.addName(wand, ItemInfo.WAND_NAME);
		LanguageRegistry.addName(dust, ItemInfo.DUST_NAME);
		LanguageRegistry.addName(derpcoin, ItemInfo.DERPCOIN_NAME);
		LanguageRegistry.addName(dustbottle, ItemInfo.DUSTBOTTLE_NAME);
		
		for (int i = 0; i < ItemInfo.CARD_NAMES.length; i++)
		{
			LanguageRegistry.addName(new ItemStack(card, 1, i), ItemInfo.CARD_NAMES[i]);
		}
	}
	
	public static void registerRecipes()
	{
		GameRegistry.addRecipe(new ItemStack(staff), new Object[] {"  X", "ZYZ", "Y  ", 'X', Item.redstone, 'Y', Item.stick, 'Z', Item.feather});
		GameRegistry.addRecipe(new ItemStack(card, 1, 22), new Object[] {"DGD", "GLG", "DGD", 'D', new ItemStack(Item.dyePowder, 1, 1), 'G', Item.ingotGold, 'L', Item.leather});
		GameRegistry.addRecipe(new ItemStack(wand), new Object[] {"did", "rsr", "rsr", 'd', Item.diamond, 'i', new ItemStack(Item.dyePowder, 1, 0), 's', Item.stick, 'r', Item.redstone});
		GameRegistry.addRecipe(new ItemStack(derpcoin, 4), new Object[] {" x ", "xxx", " x ", 'x', new ItemStack(Item.goldNugget)});

		GameRegistry.addShapelessRecipe(new ItemStack(dustbottle), new ItemStack(dust), new ItemStack(Item.glassBottle));
	}
}
