package miscMod;

import miscMod.items.ItemInfo;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MiscCreativeTab extends CreativeTabs {
	
	public MiscCreativeTab(String par2Str) {
		super(par2Str);
	}

	@SideOnly(Side.CLIENT)
	public Item getTabIconItem() {
		Item staff =  new miscMod.items.ItemStaff(ItemInfo.STAFF_ID);
		return staff;
	}
}