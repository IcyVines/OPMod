package net.minecraft.block;

import java.util.ArrayList;
import java.util.Random;

import Mod.ISawable;

import cpw.mods.fml.common.network.Player;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockStone extends Block implements ISawable
{
	boolean Sawed = false;
	
    public BlockStone(int par1)
    {
        super(par1, Material.rock);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
    
    @Override
    public boolean isSawable(ItemStack item, World world, int x, int y, int z)
    {
        return true;
    }

    @Override
    public ArrayList<ItemStack> onSawed(ItemStack item, World world, int x, int y, int z, int fortune)
    {
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
        ret.add(new ItemStack(Block.stoneSingleSlab, 2, 0));
        Sawed = true;
        return ret;
    }
    
    /**
     * Returns the ID of the items to drop on destruction.
     */
    
    public int idDropped(int par1, Random par2Random, int par3)
    {
    	if (Sawed == true){
    		Sawed = false;
    		return 0;
    	} 
    	else{
    		return Block.cobblestone.blockID;
    	}
    		
    }
 
}
