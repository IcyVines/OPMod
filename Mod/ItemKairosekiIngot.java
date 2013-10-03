package Mod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemKairosekiIngot extends Item
{
    public ItemKairosekiIngot(int par1)
    {
        super(par1);
        this.maxStackSize = 64;
        this.setCreativeTab(CreativeTabs.tabMaterials);
    }
}
