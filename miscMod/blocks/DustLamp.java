package miscMod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class DustLamp extends Block
{

	public DustLamp(int id)
	{
		super(id, Material.glass);
		
		setLightValue(1F);
		setCreativeTab(CreativeTabs.tabBlock);
		setHardness(1F);
		setStepSound(Block.soundGlassFootstep);
		setUnlocalizedName(BlockInfo.LAMP_UNLOCALIZED_NAME);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister register)
	{
		blockIcon = register.registerIcon("miscMod:" + BlockInfo.LAMP_TEXTURE);
	}
}
