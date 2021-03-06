package miscMod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MestronLog extends Block
{
	public MestronLog(int id)
	{
		super(id, Material.wood);
		
		setCreativeTab(CreativeTabs.tabBlock);
		setHardness(2F);
		setStepSound(Block.soundWoodFootstep);
		setUnlocalizedName(BlockInfo.MLOG_UNLOCALIZED_NAME);
	}
	
	@SideOnly(Side.CLIENT)
	private Icon topIcon;
	@SideOnly(Side.CLIENT)
	private Icon sideIcon;
	
	private Icon[] textures  = {null, null};
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister register)
	{
		topIcon = register.registerIcon("miscMod:" + BlockInfo.MLOG_TOP);
		sideIcon = register.registerIcon("miscmod:"+ BlockInfo.MLOG_SIDE);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIcon(int side, int meta)
	{
		if (side == 0 || side == 1)
			return topIcon;

		else
			return sideIcon;
	}
	
	@Override
    public boolean canSustainLeaves(World world, int x, int y, int z)
    {
        return true;
    }
}
