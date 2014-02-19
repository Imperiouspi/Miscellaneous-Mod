package miscMod.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;	
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Wand extends Item
{
	@SideOnly(Side.CLIENT)
	private Icon chargedIcon;
	
	public Wand(int id)
	{
		super(id);
		setCreativeTab(CreativeTabs.tabTools);
		setMaxStackSize(1);
		setUnlocalizedName(ItemInfo.WAND_UNLOCALIZED_NAME);
	}
	
	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10)
	{
		int X, Y, Z;
		X = x;
		Y = y;
		Z = z;
				
		while(!world.isAirBlock(X, Y, Z))
		{
			world.setBlock(X, Y, Z, 0);
			Y++;
		}
		
		return true;
	}
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register)
	{
		itemIcon = register.registerIcon("miscmod:" + ItemInfo.WAND_ICON);
	}
}

