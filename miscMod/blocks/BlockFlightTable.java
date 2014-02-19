package miscMod.blocks;

import miscMod.Items;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockFlightTable extends Block
{

	public BlockFlightTable(int id)
	{
		super(id, Material.wood);

		setCreativeTab(CreativeTabs.tabBlock);
		setHardness(2F);
		setStepSound(Block.soundWoodFootstep);
		setUnlocalizedName(BlockInfo.FLIGHTTABLE_UNLOCALIZED_NAME);
	}

	@SideOnly(Side.CLIENT)
	private Icon topIcon;
	@SideOnly(Side.CLIENT)
	private Icon sideIcon;

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister register)
	{
		topIcon = register.registerIcon("miscMod:" + BlockInfo.FLIGHTTABLE_TOP);
		sideIcon = register.registerIcon("miscmod:" + BlockInfo.FLIGHTTABLE_SIDE);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIcon(int side, int meta)
	{
		if (side == 1 || side == 0)
			return topIcon;
		else
			return sideIcon;
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
		if (player.inventory.hasItem(Item.feather.itemID) && player.inventory.hasItem(Item.diamond.itemID))
		{
			if (!player.capabilities.allowFlying)
			{
				player.inventory.consumeInventoryItem(Item.feather.itemID);
				player.inventory.consumeInventoryItem(Item.diamond.itemID);
			}
			player.capabilities.allowFlying = !player.capabilities.allowFlying;
			player.onUpdate();
		}
		return true;
	}
}
