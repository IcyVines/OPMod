package Mod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemDevilFruit extends ItemFood{
 
	 private final int typeDevil;
	 
	public ItemDevilFruit(int par1, int par2, float par3, boolean par4, boolean par5, int par6) {
		super(par1, par2, par3, par4);
        this.setCreativeTab(CreativeTabs.tabFood);
        this.maxStackSize = 1;
        this.typeDevil = par6;
	}
	
	
	 public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	    {
	        --par1ItemStack.stackSize;
	        par3EntityPlayer.getFoodStats().addStats(this);
	        par2World.playSoundAtEntity(par3EntityPlayer, "random.burp", 0.5F, par2World.rand.nextFloat() * 0.1F + 0.9F);
	        this.onFoodEaten(par1ItemStack, par2World, par3EntityPlayer);
	        return par1ItemStack;  
	    }
	    
	
	  public int getMaxItemUseDuration(ItemStack par1ItemStack)
	    {
	        return 48;
	    }
	  
	  /**
     * gets the saturationModifier of the ItemFood
     */
    public float getSaturationModifier()
    {
        return 0;
    }

    /**
     * Whether wolves like this food (true for raw and cooked porkchop).
     */
    public boolean isWolfsFavoriteMeat()
    {
        return false;
    }	
    
}
