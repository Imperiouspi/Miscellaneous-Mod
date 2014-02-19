package miscMod.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;

public class LavaStone extends Block
{
	public LavaStone(int id)
	{
		super(id, Material.rock);
		
		setUnlocalizedName(BlockInfo.LAVASTONE_UNLOCALIZED_NAME);
		setHardness(2F);
		setStepSound(Block.soundStoneFootstep);
		setCreativeTab(CreativeTabs.tabBlock);
		MinecraftForge.setBlockHarvestLevel(this, "pickaxe", 0);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister register)
	{
		blockIcon = register.registerIcon("miscmod:" + BlockInfo.LAVASTONE_TEXTURE);
	}
}
