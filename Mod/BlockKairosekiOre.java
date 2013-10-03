package Mod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class BlockKairosekiOre extends Block
{
    public BlockKairosekiOre(int par1, Material material)
    {
        super(par1, material);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
}
