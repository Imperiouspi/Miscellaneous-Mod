package miscMod.blocks;

import miscMod.tileentity.BuildPlantTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BuildPlantBlock extends BlockContainer{

	public static int setblock = -1, setblockmeta, numberstack;

	public BuildPlantBlock(int id) {
		super(id, Material.plants);
		setStepSound(Block.soundGrassFootstep);
		setCreativeTab(CreativeTabs.tabBlock);
		setUnlocalizedName(BlockInfo.BUILDPLANT_UNLOCALIZED_NAME);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new miscMod.tileentity.BuildPlantTileEntity();
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister register)
	{
		blockIcon = register.registerIcon("miscMod:" + BlockInfo.BUILDPLANT_TEXTURE);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
		BuildPlantTileEntity.numberstack = 0;
		if (!world.isRemote)
		{
			BuildPlantTileEntity.active = true;
			if (!(player.inventory.getCurrentItem() == null)){
				setblock = player.inventory.getCurrentItem().getItem().itemID;
				setblockmeta = player.inventory.getCurrentItem().getItemDamage();
				numberstack = player.inventory.getCurrentItem().stackSize;
				int stackleft = numberstack;
				System.out.println(setblock + " " + setblockmeta + " " + numberstack);
				while (stackleft > 0 && !player.capabilities.isCreativeMode){
					player.inventory.consumeInventoryItem(setblock);
					stackleft--;
				}
			}
		}
		return true;
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
	{
		return null;
	}

	public boolean isOpaqueCube()
	{
		return false;
	}

	public boolean renderAsNormalBlock()
	{
		return false;
	}

	public int getRenderType()
	{
		return 1;


	}
}
