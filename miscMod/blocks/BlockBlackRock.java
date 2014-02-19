package miscMod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBlackRock extends Block
{
	public BlockBlackRock(int id)
	{
		super(id, Material.rock);
		
		setCreativeTab(CreativeTabs.tabBlock);
		setHardness(2F);
		setStepSound(Block.soundStoneFootstep);
		setUnlocalizedName(BlockInfo.BLACKROCK_UNLOCALIZED_NAME);
		MinecraftForge.setBlockHarvestLevel(this, "pickaxe", 0);

	}
	
	@SideOnly(Side.CLIENT)
	private Icon icon;
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister register)
	{
		icon = register.registerIcon("miscmod:" + BlockInfo.BLACKROCK_TEXTURE);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIcon(int side, int meta)
	{
		return icon;
	}
}
