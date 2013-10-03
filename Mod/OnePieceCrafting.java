package Mod;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import cpw.mods.fml.common.registry.GameRegistry;

public class OnePieceCrafting {
	public static void loadRecipes(){
		
		GameRegistry.addRecipe(new ItemStack(OPMod.KairosekiBlock), 
			new Object[]{
				"XXX","XXX","XXX",'X', OPMod.KairosekiIngot
			}
		);
		GameRegistry.addShapelessRecipe(new ItemStack(OPMod.KairosekiIngot, 9), 
				new Object[]{
					OPMod.KairosekiBlock
				}
			);
		GameRegistry.addRecipe(new ItemStack(OPMod.DiamondSaw), 
			new Object[]{
				"CXX","XIC","ICC",'X', Item.diamond, 'I', Item.stick
			}
		);
		GameRegistry.addRecipe(new ItemStack(OPMod.GoldSaw), 
			new Object[]{
				"CXX","XIC","ICC",'X', Item.ingotGold, 'I', Item.stick
			}
		);
		GameRegistry.addRecipe(new ItemStack(OPMod.IronSaw), 
			new Object[]{
				"CXX","XIC","ICC",'X', Item.ingotIron, 'I', Item.stick
			}
		);
		GameRegistry.addRecipe(new ItemStack(OPMod.KairosekiAxe), 
			new Object[]{
				"CXX","CIX","CXC",'X', OPMod.KairosekiIngot, 'I', Item.stick
			}
		);
		GameRegistry.addRecipe(new ItemStack(OPMod.KairosekiHoe), 
			new Object[]{
				"XXC","CIC","CIC",'X', OPMod.KairosekiIngot, 'I', Item.stick
			}
		);
		GameRegistry.addRecipe(new ItemStack(OPMod.KairosekiPick), 
			new Object[]{
				"XXX","CIC","CIC",'X', OPMod.KairosekiIngot, 'I', Item.stick
			}
		);
		GameRegistry.addRecipe(new ItemStack(OPMod.KairosekiSaw), 
			new Object[]{
				"CXX","XIC","ICC",'X', OPMod.KairosekiIngot, 'I', Item.stick
			}
		);
		GameRegistry.addRecipe(new ItemStack(OPMod.KairosekiShovel), 
			new Object[]{
				"CXC","CIC","CIC",'X', OPMod.KairosekiIngot, 'I', Item.stick
			}
		);
		GameRegistry.addRecipe(new ItemStack(OPMod.KairosekiSword), 
			new Object[]{
				"CXC","CXC","CIC",'X', OPMod.KairosekiIngot, 'I', Item.stick
			}
		);
		GameRegistry.addRecipe(new ItemStack(OPMod.StoneSaw), 
			new Object[]{
				"CXX","XIC","ICC",'X', Block.cobblestone, 'I', Item.stick
			}
		);
		GameRegistry.addRecipe(new ItemStack(OPMod.WoodenSaw), 
			new Object[]{
				"CXX","XIC","ICC",'X', Block.planks, 'I', Item.stick
			}
		);
		GameRegistry.addRecipe(new ItemStack(OPMod.KairosekiHelmet), 
				new Object[]{
					"XXX","XCX",'X', OPMod.KairosekiIngot
				}
			);
		GameRegistry.addRecipe(new ItemStack(OPMod.KairosekiChest), 
				new Object[]{
					"XCX","XXX","XXX",'X',  OPMod.KairosekiIngot
				}
			);
		GameRegistry.addRecipe(new ItemStack(OPMod.KairosekiPants), 
				new Object[]{
					"XXX","XCX","XCX",'X',  OPMod.KairosekiIngot
				}
			);
		GameRegistry.addRecipe(new ItemStack(OPMod.KairosekiBoots), 
				new Object[]{
					"XCX","XCX",'X',  OPMod.KairosekiIngot
				}
			);
		GameRegistry.addRecipe(new ItemStack(OPMod.InstantEnchant), 
				new Object[]{
					"RDR", "RER", "RRR", 'R', Item.redstone, 'E', Block.enchantmentTable, 'D',  Item.diamond
				}
			);
		
		FurnaceRecipes.smelting().addSmelting(OPMod.KairosekiOre.blockID, new ItemStack(OPMod.KairosekiIngot), 0.5F);
		
	}	
}
