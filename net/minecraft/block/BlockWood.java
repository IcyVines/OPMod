package net.minecraft.block;

import Mod.ISawable;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockWood extends Block implements ISawable
{
    /** The type of tree this block came from. */
    public static final String[] woodType = new String[] {"oak", "spruce", "birch", "jungle"};
    @SideOnly(Side.CLIENT)
    private Icon[] iconArray;
    boolean Sawed = false;

    public BlockWood(int par1)
    {
        super(par1, Material.wood);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    @SideOnly(Side.CLIENT)

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public Icon getIcon(int par1, int par2)
    {
        if (par2 < 0 || par2 >= this.iconArray.length)
        {
            par2 = 0;
        }

        return this.iconArray[par2];
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    public int damageDropped(int par1)
    {
        return par1;
    }

    @SideOnly(Side.CLIENT)

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        par3List.add(new ItemStack(par1, 1, 0));
        par3List.add(new ItemStack(par1, 1, 1));
        par3List.add(new ItemStack(par1, 1, 2));
        par3List.add(new ItemStack(par1, 1, 3));
    }

    @SideOnly(Side.CLIENT)

    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.iconArray = new Icon[woodType.length];

        for (int i = 0; i < this.iconArray.length; ++i)
        {
            this.iconArray[i] = par1IconRegister.registerIcon(this.func_111023_E() + "_" + woodType[i]);
        }
    }
    
    int wood;    
    @Override
    public boolean isSawable(ItemStack item, World world, int x, int y, int z)
    {
    	wood = world.getBlockMetadata(x, y, z);
        return true;
    }
    
    @Override
    public ArrayList<ItemStack> onSawed(ItemStack item, World world, int x, int y, int z, int fortune)
    {
    	ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
    	ret.add(new ItemStack(Block.woodSingleSlab, 2, wood));
        Sawed = true;
        return ret;
    }
    
    public int idDropped(int par1, Random par2Random, int par3)
    {
    	if (Sawed == true){
    		Sawed = false;
    		return 0;
    	} 
    	else{
    		return this.blockID;
    	}
    		
    }
    
    
    
}
