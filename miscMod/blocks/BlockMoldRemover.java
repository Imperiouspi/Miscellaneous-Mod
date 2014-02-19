package miscMod.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockMoldRemover extends BlockContainer
{

	public BlockMoldRemover(int id)
	{
		super(id, Material.cactus);
		setStepSound(Block.soundGrassFootstep);
		setUnlocalizedName(BlockInfo.REMOVER_UNLOCALIZED_NAME);
		setCreativeTab(CreativeTabs.tabBlock);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new miscMod.tileentity.TileEntityMoldRemover();
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister register)
	{
		blockIcon = register.registerIcon("miscMod:" + BlockInfo.REMOVER_TEXTURE);
	}

}
