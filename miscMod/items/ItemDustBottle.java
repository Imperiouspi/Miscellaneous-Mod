package miscMod.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemDustBottle extends Item
{

	public ItemDustBottle(int id)
	{
		super(id);
		setCreativeTab(CreativeTabs.tabMisc);
		setMaxStackSize(64);
		setUnlocalizedName(ItemInfo.DUSTBOTTLE_UNLOCALIZED_NAME);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register)
	{
		itemIcon = register.registerIcon("miscmod:DustBottle");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List info, boolean useExtraInformation)
	{
		info.add("A Bottle of Dust.");
	}
}
