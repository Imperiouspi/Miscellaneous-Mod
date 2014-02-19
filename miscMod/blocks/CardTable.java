package miscMod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CardTable extends Block {

	public CardTable(int id) {
		super(id, Material.wood);

		setCreativeTab(CreativeTabs.tabBlock);
		setHardness(2F);
		setStepSound(Block.soundWoodFootstep);
		setUnlocalizedName(BlockInfo.CARDTABLE_UNLOCALIZED_NAME);
	}

	@SideOnly(Side.CLIENT)
	private Icon topIcon;
	@SideOnly(Side.CLIENT)
	private Icon sideActiveIcon;
	@SideOnly(Side.CLIENT)
	private Icon sideDeactiveIcon;

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister register) {
		topIcon = register.registerIcon("miscMod:" + BlockInfo.CARDTABLE_TOP);
		sideActiveIcon = register.registerIcon("miscmod:"
				+ BlockInfo.CARDTABLE_SIDE_A);
		sideDeactiveIcon = register.registerIcon("miscmod:"
				+ BlockInfo.CARDTABLE_SIDE_B);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIcon(int side, int meta) {
		if (side == 1 || side == 0)
			return topIcon;
		else
			return isDisabled(meta) ? sideDeactiveIcon : sideActiveIcon;
	}

	private boolean isDisabled(int meta) {
		return meta == 1;
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,
			EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if (!world.isRemote) {
			int newMeta = world.getBlockMetadata(x, y, z) == 0 ? 1 : 0;
			world.setBlockMetadataWithNotify(x, y, z, newMeta, 3);

			spawnCardBuilding(world, x, y, z, player, side);
		}
		return true;
	}

	public void spawnCardBuilding(World world, int x, int y, int z,
			EntityPlayer player, int side) {
		//pillars
		for (int i = 0; i < 4; i++) {
			world.setBlock(x - 4, y + i, z - 4, BlockInfo.MLOG_ID);
		}
		for (int i = 0; i < 4; i++) {
			world.setBlock(x + 4, y + i, z - 4, BlockInfo.MLOG_ID);
		}
		for (int i = 0; i < 4; i++) {
			world.setBlock(x + 4, y + i, z + 4, BlockInfo.MLOG_ID);
		}
		for (int i = 0; i < 4; i++) {
			world.setBlock(x - 4, y + i, z + 4, BlockInfo.MLOG_ID);
		}

		//walls
		for (int i = 1; i <= 7; i++) {
			spawnWall(world, x - 4 + i, y, z - 4, player, side);
		}
		for (int i = 1; i <= 7; i++) {
			spawnWall(world, x + 4, y, z - 4 + i, player, side);
		}
		for (int i = 1; i <= 7; i++) {
			spawnWall(world, x - 4 + i, y, z + 4, player, side);
		}
		for (int i = 1; i <= 7; i++) {
			spawnWall(world, x - 4, y, z - 4 + i, player, side);
		}
	}

	public void spawnWall(World world, int x, int y, int z,
			EntityPlayer player, int side) {
		for (int i = 0; i < 3; i++) {
			world.setBlock(x, y + i, z, BlockInfo.BLACKROCK_ID);
		}
		world.setBlock(x, y + 3, z, BlockInfo.MLOG_ID);
	}
}
