package Mod;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.world.World;

	public class BlockDevilFruit extends Block
	{
	    public BlockDevilFruit(int par1, Material material)
	    {
	        super(par1, material);
	        this.setTickRandomly(true);
	        this.setCreativeTab(CreativeTabs.tabMisc);
	        this.setBlockBounds(0.3F, -0.5F, 0.3F, 0.7F, 0.03F, 0.7F);
	    }
	    
	    
	    /**
	     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
	     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
	     */
	    public boolean isOpaqueCube()
	    {
	        return false;
	    }

	    /**
	     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
	     */
	    public boolean renderAsNormalBlock()
	    {
	        return false;
	    }
	     
	    public boolean canBlockStay(World par1world, int par1, int par2, int par3){
	    	return true;
	    }
	    
	    public int idDropped(int par1, Random par2Random, int par3)
	    {
	    	int random = (int)(Math.random()*10000) + 1;
	    	
	    	if (random >= 5001)
	    		return Item.appleGold.itemID;
	    	else
	    		return Item.appleRed.itemID;
	    }
}
