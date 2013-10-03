package Mod;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.stats.StatList;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

public class ItemSaw extends ItemTool
{
	  
    public static final Block[] blocksEffectiveAgainst = new Block[] {Block.cobblestone, Block.stoneDoubleSlab, Block.stone, Block.sandStone, Block.brick, Block.stoneBrick, Block.netherBrick, Block.woodDoubleSlab, Block.planks, Block.fenceIron, Block.fence, Block.netherFence, Block.blockNetherQuartz, OPMod.KairosekiBlock};
    
    public ItemSaw(int par1, EnumToolMaterial par2EnumToolMaterial)
    {
    	super(par1, 3.5F, par2EnumToolMaterial, blocksEffectiveAgainst);
    	this.efficiencyOnProperMaterial = par2EnumToolMaterial.getEfficiencyOnProperMaterial() + 4.5F;
    }
    
    /**
     * Returns if the item (tool) can harvest results from the block type.
     */
    public boolean canHarvestBlock(Block par1Block)
    {
        return par1Block == Block.stone ? this.toolMaterial.getHarvestLevel() == 3 : (par1Block != Block.stoneBrick && par1Block != Block.netherBrick ? (par1Block != Block.blockNetherQuartz && par1Block != Block.netherFence ? (par1Block != Block.fenceIron && par1Block != Block.brick ? (par1Block != Block.sandStone && par1Block != Block.cobblestone ? (par1Block != Block.wood && par1Block != Block.stoneDoubleSlab ? (par1Block != OPMod.KairosekiBlock ? (par1Block.blockMaterial == Material.cloth ? true : (par1Block.blockMaterial == Material.wood ? true : par1Block.blockMaterial == Material.leaves)) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 1) : this.toolMaterial.getHarvestLevel() >= 1) : this.toolMaterial.getHarvestLevel() >= 1) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 2);
    }
    
    public boolean onBlockDestroyed(ItemStack par1ItemStack, World par2World, int par3, int par4, int par5, int par6, EntityLivingBase par7EntityLivingBase)
    {
        if (par3 != Block.planks.blockID && par3 != Block.stoneBrick.blockID && par3 != Block.sandStone.blockID && par3 != Block.cobblestone.blockID && par3 != Block.stone.blockID && par3 != Block.wood.blockID && !(Block.blocksList[par3] instanceof ISawable))
        {
            return super.onBlockDestroyed(par1ItemStack, par2World, par3, par4, par5, par6, par7EntityLivingBase);
        }
        else
        {
            return true;
        }
    }
    
    @Override
    public boolean func_111207_a(ItemStack itemstack, EntityPlayer player, EntityLivingBase entity)
    {
        if (entity.worldObj.isRemote)
        {
            return false;
        }
        if (entity instanceof ISawable)
        {
            ISawable target = (ISawable)entity;
            if (target.isSawable(itemstack, entity.worldObj, (int)entity.posX, (int)entity.posY, (int)entity.posZ))
            {
                ArrayList<ItemStack> drops = target.onSawed(itemstack, entity.worldObj, (int)entity.posX, (int)entity.posY, (int)entity.posZ,
                        EnchantmentHelper.getEnchantmentLevel(Enchantment.fortune.effectId, itemstack));

                Random rand = new Random();
                for(ItemStack stack : drops)
                {
                    EntityItem ent = entity.entityDropItem(stack, 1.0F);
                    ent.motionY += rand.nextFloat() * 0.05F;
                    ent.motionX += (rand.nextFloat() - rand.nextFloat()) * 0.1F;
                    ent.motionZ += (rand.nextFloat() - rand.nextFloat()) * 0.1F;
                }
                itemstack.damageItem(1, entity);
            }
            return true;
        }
        return false;
    }
    
    @Override
    public boolean onBlockStartBreak(ItemStack itemstack, int x, int y, int z, EntityPlayer player) 
    {
        if (player.worldObj.isRemote)
        {
            return false;
        }
        int id = player.worldObj.getBlockId(x, y, z);
        if (Block.blocksList[id] instanceof ISawable)
        {
            ISawable target = (ISawable)Block.blocksList[id];
            if (target.isSawable(itemstack, player.worldObj, x, y, z))
            {
                ArrayList<ItemStack> drops = target.onSawed(itemstack, player.worldObj, x, y, z,
                        EnchantmentHelper.getEnchantmentLevel(Enchantment.fortune.effectId, itemstack));
                Random rand = new Random();

                for(ItemStack stack : drops)
                {
                    float f = 0.7F;
                    double d  = (double)(rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
                    double d1 = (double)(rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
                    double d2 = (double)(rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
                    EntityItem entityitem = new EntityItem(player.worldObj, (double)x + d, (double)y + d1, (double)z + d2, stack);
                    entityitem.delayBeforeCanPickup = 10;
                    player.worldObj.spawnEntityInWorld(entityitem);
                }

                itemstack.damageItem(1, player);
                player.addStat(StatList.mineBlockStatArray[id], 1);
            }
        }
        return false;
    }
   
}