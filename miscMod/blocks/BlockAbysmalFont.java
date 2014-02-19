package miscMod.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import miscMod.MiscMod;
import miscMod.TeleporterDarkeRealme;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPortal;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.src.ModLoader;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockAbysmalFont extends BlockPortal{

	public BlockAbysmalFont(int id) {
		super(id);
		this.setCreativeTab(CreativeTabs.tabBlock);
		setUnlocalizedName(BlockInfo.ABYSMAL_UNLOCALIZED_NAME);
	}

	/**
	 * Returns true if the given side of this block type should be rendered, if the adjacent block is at the given
	 * coordinates.  Args: blockAccess, x, y, z, side
	 */
	@Override
	public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
	{
		return true;
	}

	@SideOnly(Side.CLIENT)

	/**
	 * Returns which pass should this block be rendered on. 0 for solids and 1 for alpha
	 */
	public int getRenderBlockPass()
	{
		return 0;
	}


	@Override
	public boolean isOpaqueCube(){
		return true;
	}

	@Override
	public boolean renderAsNormalBlock(){
		return true;
	}

	@Override
	public int getRenderType(){
		return 0;
	}

	@SideOnly(Side.CLIENT)
	private Icon topIcon;
	@SideOnly(Side.CLIENT)
	private Icon sideIcon;
	@SideOnly(Side.CLIENT)
	private Icon bottomIcon;

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister register)
	{
		topIcon = register.registerIcon("miscMod:" + BlockInfo.ABYSMAL_TEXTURE_TOP);
		sideIcon = register.registerIcon("miscmod:" + BlockInfo.ABYSMAL_TEXTURE_SIDE);
		bottomIcon = register.registerIcon("miscMod:" + BlockInfo.ABYSMAL_TEXTURE_BOTTOM);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIcon(int side, int meta)
	{
		if (side == 1)
			return topIcon;
		if(side == 0)
			return bottomIcon;
		else
			return sideIcon;
	}

	@Override
	public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity){
		if ((par5Entity.ridingEntity == null) && (par5Entity.riddenByEntity == null) && ((par5Entity instanceof EntityPlayerMP)))
		{
			EntityPlayerMP player = (EntityPlayerMP) par5Entity;
			ModLoader.getMinecraftServerInstance();
			MinecraftServer mServer = MinecraftServer.getServer();
			if (player.timeUntilPortal > 0)
			{
				player.timeUntilPortal = 10;
			}
			else if (player.dimension != MiscMod.dimensionId)
			{
				player.timeUntilPortal = 10;
				player.mcServer.getConfigurationManager().transferPlayerToDimension(player, MiscMod.dimensionId, new TeleporterDarkeRealme(mServer.worldServerForDimension(MiscMod.dimensionId)));
			}
			else
			{
				player.timeUntilPortal = 10;
				player.mcServer.getConfigurationManager().transferPlayerToDimension(player, 0, new TeleporterDarkeRealme(mServer.worldServerForDimension(1)));
			}
		}
	}

	public boolean tryToCreatePortal(World par1World, int par2, int par3, int par4)
	{
		byte b0 = 0;
		byte b1 = 0;

		if (par1World.getBlockId(par2 - 1, par3, par4) == BlockInfo.DUSTBLOCK_ID || par1World.getBlockId(par2 + 1, par3, par4) == BlockInfo.DUSTBLOCK_ID)
		{
			b0 = 1;
		}

		if (par1World.getBlockId(par2, par3, par4 - 1) == BlockInfo.DUSTBLOCK_ID || par1World.getBlockId(par2, par3, par4 + 1) == BlockInfo.DUSTBLOCK_ID)
		{
			b1 = 1;
		}

		if (b0 == b1)
		{
			return false;
		}
		else
		{
			if (par1World.isAirBlock(par2 - b0, par3, par4 - b1))
			{
				par2 -= b0;
				par4 -= b1;
			}

			int l;
			int i1;

			for (l = -1; l <= 2; ++l)
			{
				for (i1 = -1; i1 <= 3; ++i1)
				{
					boolean flag = l == -1 || l == 2 || i1 == -1 || i1 == 3;

					if (l != -1 && l != 2 || i1 != -1 && i1 != 3)
					{
						int j1 = par1World.getBlockId(par2 + b0 * l, par3 + i1, par4 + b1 * l);
						boolean isAirBlock = par1World.isAirBlock(par2 + b0 * l, par3 + i1, par4 + b1 * l);

						if (flag)
						{
							if (j1 != BlockInfo.DUSTBLOCK_ID)
							{
								return false;
							}
						}
						else if (!isAirBlock && j1 != Block.fire.blockID)
						{
							return true;
						}
					}
				}
			}

			for (l = 0; l < 2; ++l)
			{
				for (i1 = 0; i1 < 3; ++i1)
				{
					par1World.setBlock(par2 + b0 * l, par3 + i1, par4 + b1 * l, BlockInfo.ABYSMAL_ID, 0, 2);
				}
			}

			return true;
		}
	}

	@Override
	/**
	 * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
	 * their own) Args: x, y, z, neighbor blockID
	 */
	 public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5){}


	 @Override
	 /**
	  * Updates the blocks bounds based on its current state. Args: world, x, y, z
	  */
	  public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4){}
}
