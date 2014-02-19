package miscMod.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemStaff extends Item
{
	@SideOnly(Side.CLIENT)
	private Icon chargedIcon;
	
	public ItemStaff(int id)
	{
		super(id);
		setCreativeTab(CreativeTabs.tabTools);
		setMaxStackSize(1);
		setUnlocalizedName(ItemInfo.STAFF_UNLOCALIZEDNAME);
	}
	
	@Override
	public boolean itemInteractionForEntity(ItemStack itemstack, EntityPlayer player, EntityLivingBase target)
	{
		if(!target.worldObj.isRemote)
		{
			target.motionY = 4;
			target.setFire(7);
			
			if (isCharged(itemstack.getItemDamage()))
			{
				target.motionX = (target.posX - player.posX) * 2;
				itemstack.setItemDamage(0);
			}
			else
			{
				itemstack.setItemDamage(itemstack.getItemDamage()+1);
			}
		}
		
		return false;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register)
	{
		itemIcon = register.registerIcon("miscmod:StaffOff");
		chargedIcon = register.registerIcon("miscmod:StaffOn");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List info, boolean useExtraInformation)
	{
		info.add("Make your enemies and friends fry. I mean fly. " + itemStack.getItemDamage());
		
		if (isCharged(itemStack.getItemDamage()))
			info.add("This item is charged");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int dmg)
	{
		if (isCharged(dmg))
		{
			return chargedIcon;
		}
		else
		{
			return itemIcon;
		}
	}
	
	private boolean isCharged(int dmg)
	{
		return (dmg >=10);
	}
}
