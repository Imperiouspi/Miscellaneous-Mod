/*package miscMod.blocks;

import miscMod.items.ItemInfo;
import miscMod.tileentity.TileEntityMultiTableCore;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockMultiTableCore extends BlockContainer
{

	public BlockMultiTableCore(int id) {
		super(id, Material.wood);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityMultiTableCore();
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
	{
		if (player.isSneaking())
		{
			return false;
		}
		
		TileEntityMultiTableCore tileentity = (TileEntityMultiTableCore)world.getBlockTileEntity(x, y, z);
		
		if(tileentity != (null))
		{
			if(!tileentity.getIsValid())
			{
				if(tileentity.getIsProperlyFormed())
				{
					tileEntity.convertToDummies();
				}
			}
			
			if(tileentity.getIsValid && player.inventory.hasItem(Item.feather.itemID))
			{
				player.capabilities.allowFlying = true;
				player.inventory.consumeInventoryItem(Item.feather.itemID);
			}
		}
		return true;
		
	}
}*/
