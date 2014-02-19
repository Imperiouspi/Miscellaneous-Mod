package miscMod.tileentity;

import miscMod.blocks.BlockInfo;
import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityMoldRemover extends TileEntity
{
	private double timer = 70;
	@Override
	public void updateEntity()
	{
		if(!worldObj.isRemote)
		{
			if (timer == 0)
			{
				spread (xCoord, yCoord + 1, zCoord);
				spread (xCoord, yCoord - 1, zCoord);
				spread (xCoord + 1, yCoord, zCoord);
				spread (xCoord - 1, yCoord, zCoord);
				spread (xCoord, yCoord, zCoord + 1);
				spread (xCoord, yCoord, zCoord - 1);
				worldObj.setBlock(xCoord, yCoord, zCoord, 0);
				timer = 70;
			}
			else
			{
				timer--;
			}
		}
	}

	private void spread(int x, int y, int z) {
		int lookBlock = worldObj.getBlockId(x, y, z);
		if (lookBlock == BlockInfo.MOLD_ID) {
			worldObj.setBlock(x, y, z, BlockInfo.REMOVER_ID);
			TileEntityMoldRemover moldremover = (TileEntityMoldRemover)worldObj.getBlockTileEntity(x, y, z);
		}
	}
	
	@Override
	public void writeToNBT(NBTTagCompound compound)
	{
		compound.setShort("Timer", (short)timer);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		timer = compound.getShort("Timer");
	}
}