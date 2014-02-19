package miscMod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockDarkeDirt extends Block{

	public BlockDarkeDirt(int id) {
		super(id, Material.ground);
		setStepSound(Block.soundGrassFootstep);
		setCreativeTab(CreativeTabs.tabBlock);
		setUnlocalizedName(BlockInfo.DIRT_UNLOCALIZED_NAME);
	}

	@SideOnly(Side.CLIENT)
	private Icon icon;
	private Icon sideIcon;
	private Icon bottomIcon;

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister register)
	{
		icon = register.registerIcon("miscmod:" + BlockInfo.DIRT_TEXTURE);
		sideIcon = register.registerIcon("miscmod:" + BlockInfo.DIRT_TEXTURE_SIDE);
		bottomIcon = register.registerIcon("miscmod:dirt");
	}

	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIcon(int side, int meta)
	{
		if(side == 1)
			return icon;
		if(side == 0)
			return bottomIcon;
		else
			return sideIcon;
	} 
}
