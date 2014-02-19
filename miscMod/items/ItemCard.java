package miscMod.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemCard extends Item
{
	@SideOnly(Side.CLIENT)
	private Icon[] icons;

	public ItemCard(int id)
	{
		super(id);
		setCreativeTab(CreativeTabs.tabMisc);
		setHasSubtypes(true);
		setMaxStackSize(1);
	}

	//21
	@Override
	public boolean itemInteractionForEntity(ItemStack itemstack, EntityPlayer player, EntityLivingBase target)
	{
		ItemStack MattCard = new ItemStack (ItemInfo.Card_ID, 1, 21);
		if(!target.worldObj.isRemote && itemstack.getItemDamage() == MattCard.getItemDamage())
		{
			target.setFire(7);	
		}

		return false;
	}
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,EntityPlayer player)
	{
		EntityArrow entityArrow = new EntityArrow(par2World, player, 2.0F);
		entityArrow.canBePickedUp = 0;

		ItemStack SkeletonCard = new ItemStack (ItemInfo.Card_ID, 1, 1);
		ItemStack SunsetCard = new ItemStack (ItemInfo.Card_ID, 1, 2);
		ItemStack NightCard = new ItemStack (ItemInfo.Card_ID, 1, 13);
		ItemStack DayCard = new ItemStack (ItemInfo.Card_ID, 1, 7);
		ItemStack DrawnCard = new ItemStack (ItemInfo.Card_ID, 1, 22);
		ItemStack MountainCard = new ItemStack (ItemInfo.Card_ID, 1, 5);
		ItemStack DragonCard = new ItemStack (ItemInfo.Card_ID, 1, 8);
		ItemStack PitCard = new ItemStack (ItemInfo.Card_ID, 1, 14);
		ItemStack DarkCard = new ItemStack(ItemInfo.Card_ID, 1, 6);

		if(par1ItemStack.getItemDamage() == (SkeletonCard.getItemDamage()))
		{
			par2World.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
			if (!par2World.isRemote)
			{
				par2World.spawnEntityInWorld(entityArrow);
			}
		}

		if(par1ItemStack.getItemDamage() == SunsetCard.getItemDamage())
		{
			par2World.setWorldTime(12000);
		}


		if(par1ItemStack.getItemDamage() == NightCard.getItemDamage())
		{
			par2World.setWorldTime(13000);
		}

		if(par1ItemStack.getItemDamage() == DayCard.getItemDamage())
		{
			par2World.setWorldTime(0);
		}

		if(par1ItemStack.getItemDamage() == DrawnCard.getItemDamage())
		{
			par1ItemStack.setItemDamage((int) (Math.random() * 22));
		}

		if(par1ItemStack.getItemDamage() == MountainCard.getItemDamage())
		{
			//set player height to top of mountain
			//gen mountain beneath them
		}

		if(par1ItemStack.getItemDamage() == DragonCard.getItemDamage())
		{
			//spawn Dragon
			//Start with Ender Dragon.
			Entity entity = EntityList.createEntityByName("EnderDragon", par2World);
			System.out.println("Dragon Created!");


			if (entity != null && entity instanceof EntityLivingBase)
			{
				System.out.println("Dragon Time!");
				//EntityLiving entityliving = (EntityLiving)entity;
				entity.setLocationAndAngles(player.posX, player.posY, player.posZ, MathHelper.wrapAngleTo180_float(par2World.rand.nextFloat() * 360.0F), 0.0F);
				//entityliving.rotationYawHead = entityliving.rotationYaw;
				//entityliving.renderYawOffset = entityliving.rotationYaw;
				//entityliving.onSpawnWithEgg((EntityLivingData)null);
				par2World.spawnEntityInWorld(entity);
				//entityliving.playLivingSound();
			}
		}

		if(par1ItemStack.getItemDamage() == PitCard.getItemDamage())
		{
			if(!par2World.isRemote){
				for(int i = 0; i < (int)(player.posY/10); i++){
					System.out.println("Boom");
					par2World.createExplosion (player, player.posX, player.posY - (i*10), player.posZ, 70.0F, true);
				}
				System.out.println("done booming");
			}
		}
		
		if(par1ItemStack.getItemDamage() == DarkCard.getItemDamage()){
			player.dimension = 3;
		}

		return par1ItemStack;
	}



	@Override
	public String getUnlocalizedName(ItemStack itemstack)
	{
		return ItemInfo.CARD_UNLOCALIZEDNAME + itemstack.getItemDamage();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register)
	{
		icons = new Icon [ItemInfo.CARD_ICONS.length];
		for (int i = 0; i < icons.length; i++)
		{
			icons[i] = register.registerIcon("miscmod:cards/" + ItemInfo.CARD_ICONS[i]);
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int dmg)
	{
		return icons[dmg];
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(int id, CreativeTabs tab, List list)
	{
		for (int i = 0; i < ItemInfo.CARD_NAMES.length; i++)
		{
			ItemStack stack = new ItemStack(id, 1, i);
			list.add(stack);
		}
	}
}
