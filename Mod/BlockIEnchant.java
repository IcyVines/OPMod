package Mod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockIEnchant extends Block
{
    public BlockIEnchant(int par1, Material material)
    {
        super(par1, material);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
    
    @SideOnly(Side.CLIENT)
    public static Icon topIcon;
    @SideOnly(Side.CLIENT)
    public static Icon bottomIcon;
    @SideOnly(Side.CLIENT)
    public static Icon sideIcon;

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister icon) {
    topIcon = icon.registerIcon("onepiecemod" + ":" + "IEnchant_top");
    bottomIcon = icon.registerIcon("onepiecemod" + ":" + "IEnchant_bottom");
    sideIcon = icon.registerIcon("onepiecemod" + ":" + "IEnchant_side");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIcon(int side, int metadata) {
    if(side == 0) {
    return bottomIcon;
    } else if(side == 1) {
    return topIcon;
    } else {
    return sideIcon;
    }
    }
    
    public boolean onBlockActivated(World par1World, int par2,int par3,int par4,EntityPlayer par5EntityPlayer,int par6,float par7,float par8,float par9)
    {
    	int x = par2, y = par3, z = par4;
    	ChunkCoordinates ent = par5EntityPlayer.getPlayerCoordinates();
    	int playerX = ent.posX, playerY = ent.posY, playerZ = ent.posZ;
    	int playerDirection = 0;
    	
    	if (playerY > y || playerY < y)
    		playerDirection = 0;
    	else if(playerX < x){
    		playerDirection = 1;
    	}
    	else if (playerZ < z){
    		playerDirection = 2;
    	}
    	else if (playerX > x){
    		playerDirection = 3;
    	}
    	else if (playerZ > z){
    		playerDirection = 4;
    	}
    	
    	for(int j = -1; j < 2; j++){
    		for(int k = 0; k < 5; k++){
    			for(int l = 0; l < 5; l++){
    				if(j == -1){
    					if(par1World.isAirBlock(x-2+l, y+j, z-2+k)){
    						playerDirection = 0;
    						break;
    					}
    				}
    				else if((l == 2 && k == 2 && j == 0)){// || (x == playerX && z == playerZ)){
    				}	
    				else if (!par1World.isAirBlock(x-2+l, y+j, z-2+k)){
    					playerDirection = 0;
    					break;
    				}
    			}
    		}
    	}
			
    	if((Math.abs(z-playerZ) <= 1) && (Math.abs(x-playerX) <= 1)){
    		if(playerDirection > 0){
    			for(int i = 0; i < 2; i++){
    				if(i == 0)
    					par1World.setBlock(x, y, z, Block.enchantmentTable.blockID);
    				if(playerDirection % 2 == 1){
		    			par1World.setBlock(x, y+i, z+2, Block.bookShelf.blockID);
		    			par1World.setBlock(x, y+i, z-2, Block.bookShelf.blockID);
		    			par1World.setBlock(x+1, y+i, z+2, Block.bookShelf.blockID);
		    			par1World.setBlock(x-1, y+i, z+2, Block.bookShelf.blockID);
		    			par1World.setBlock(x+1, y+i, z-2, Block.bookShelf.blockID);
		    			par1World.setBlock(x-1, y+i, z-2, Block.bookShelf.blockID);
		    			par1World.setBlock(x+2, y+i, z+2, Block.bookShelf.blockID);
		    			par1World.setBlock(x-2, y+i, z+2, Block.bookShelf.blockID);
		    			par1World.setBlock(x+2, y+i, z-2, Block.bookShelf.blockID);
		    			par1World.setBlock(x-2, y+i, z-2, Block.bookShelf.blockID);
		    			par1World.setBlock(x+2, y+i, z+1, Block.bookShelf.blockID);
		    			par1World.setBlock(x-2, y+i, z+1, Block.bookShelf.blockID);
		    			par1World.setBlock(x+2, y+i, z-1, Block.bookShelf.blockID);
		    			par1World.setBlock(x-2, y+i, z-1, Block.bookShelf.blockID);
		    			if(playerDirection == 1)
		    				par1World.setBlock(x+2, y+i, z, Block.bookShelf.blockID);
		    			else if (playerDirection == 3)
		    				par1World.setBlock(x-2, y+i, z, Block.bookShelf.blockID);
		    				
		    		}
	    			else{
	    				par1World.setBlock(x+2, y+i, z, Block.bookShelf.blockID);
		    			par1World.setBlock(x-2, y+i, z, Block.bookShelf.blockID);
		    			par1World.setBlock(x+2, y+i, z+1, Block.bookShelf.blockID);
		    			par1World.setBlock(x+2, y+i, z-1, Block.bookShelf.blockID);
		    			par1World.setBlock(x-2, y+i, z+1, Block.bookShelf.blockID);
		    			par1World.setBlock(x-2, y+i, z-1, Block.bookShelf.blockID);
		    			par1World.setBlock(x+2, y+i, z+2, Block.bookShelf.blockID);
		    			par1World.setBlock(x-2, y+i, z+2, Block.bookShelf.blockID);
		    			par1World.setBlock(x+2, y+i, z-2, Block.bookShelf.blockID);
		    			par1World.setBlock(x-2, y+i, z-2, Block.bookShelf.blockID);
		    			par1World.setBlock(x+1, y+i, z+2, Block.bookShelf.blockID);
		    			par1World.setBlock(x+1, y+i, z-2, Block.bookShelf.blockID);
		    			par1World.setBlock(x-1, y+i, z+2, Block.bookShelf.blockID);
		    			par1World.setBlock(x-1, y+i, z-2, Block.bookShelf.blockID);
		    			if(playerDirection == 2)
		    				par1World.setBlock(x, y+i, z+2, Block.bookShelf.blockID);
		    			else if (playerDirection == 4)
		    				par1World.setBlock(x, y+i, z-2, Block.bookShelf.blockID);
	    			}
	    		}
	    	}
    	}
    	return true;
    }
    
}
