package miscMod.tileentity;

import miscMod.blocks.BlockInfo;
import miscMod.blocks.BuildPlantBlock;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BuildPlantTileEntity extends TileEntity
{
	private double timer = 100;
	public static int setblock = -1, setblockmeta, numberstack = 0;
	public static boolean active = false;

	@Override
	public void updateEntity()
	{
		if(!worldObj.isRemote && active)
		{
			setblock = BuildPlantBlock.setblock;
			if(setblock != -1 && numberstack < BuildPlantBlock.numberstack){//disappears when right clicked. TODO figure out this logic.
				System.out.println(numberstack);
				if (timer == 0) {
					spread(xCoord, yCoord + 1, zCoord, setblock);
					timer = 100;
					numberstack++;
				}
				else
				{
					timer--;
				}
			}
			else
			{
				System.out.println("NOPE! " + numberstack + " " + BuildPlantBlock.numberstack);
				setblock = -1;
				setblockmeta = 0;
				timer = 100;
				worldObj.setBlock(xCoord, yCoord, zCoord, 0);
				active = false;
			}
		}
	}

	private void spread(int x, int y, int z, int setblock) {
		int lookBlock = worldObj.getBlockId(x, y, z);
		if (lookBlock == 0) {
			setblockmeta = BuildPlantBlock.setblockmeta;
			worldObj.setBlock(x, y, z, BlockInfo.BUILDPLANT_ID);
			worldObj.setBlock(x, y-1, z, setblock);
			worldObj.setBlockMetadataWithNotify(x, y-1, z, setblockmeta, 2);

			BuildPlantTileEntity plant = (BuildPlantTileEntity)worldObj.getBlockTileEntity(x, y, z);
		}
	}
	@Override
	public void writeToNBT(NBTTagCompound compound)
	{
		compound.setShort("Timer", (short)timer);
		compound.setInteger("Setblock", setblock);
	}

	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		timer = compound.getShort("Timer");
		setblock = compound.getInteger("Setblock");
	}
}