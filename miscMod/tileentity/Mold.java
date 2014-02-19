package miscMod.tileentity;

import miscMod.blocks.BlockInfo;
import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class Mold extends TileEntity
{
	private double timer = 100;
	private int replaced;
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
				timer = 100;
			}
			else
			{
				timer--;
			}
		}
	}

	private void spread(int x, int y, int z) {
		int lookBlock = worldObj.getBlockId(x, y, z);
		if (lookBlock == Block.waterMoving.blockID || lookBlock == Block.waterStill.blockID || lookBlock == Block.grass.blockID || lookBlock == Block.dirt.blockID || lookBlock == Block.wood.blockID || lookBlock == Block.cactus.blockID || lookBlock == Block.leaves.blockID) {
			worldObj.setBlock(x, y, z, BlockInfo.MOLD_ID);

			Mold mold = (Mold)worldObj.getBlockTileEntity(x, y, z);
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