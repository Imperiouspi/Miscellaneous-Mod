package miscMod.blocks;

import java.util.Random;

import miscMod.Items;
import miscMod.items.ItemInfo;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockDust extends Block
{

	public BlockDust(int id)
	{
		super(id, Material.sand);
		setStepSound(Block.soundSandFootstep);
		setUnlocalizedName(BlockInfo.DUSTBLOCK_UNLOCALIZED_NAME);
		setCreativeTab(CreativeTabs.tabBlock);
		setHardness(0.3F);
		MinecraftForge.setBlockHarvestLevel(this, "shovel", 0);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister register)
	{
		blockIcon = register.registerIcon("miscMod:DustBlock");
	}
	
	@Override
	public int idDropped(int par1, Random random, int fortune){
		return Items.dust.itemID;
	}
	
	@Override
	public int quantityDropped(Random par1Random){
		return 4;
	}

}
