package Mod;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class OnePieceBlocks {
	public static void loadBlocks(){
		
		OPMod.KairosekiBlock = new BlockKairoseki(1000, Material.iron).setHardness(5.0F).setResistance(80.0F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("KBlock").func_111022_d("onepiecemod:KBlock");
		GameRegistry.registerBlock(OPMod.KairosekiBlock, "Kairoseki Block");
		LanguageRegistry.addName(OPMod.KairosekiBlock, "Kairoseki Block");
		
		OPMod.KairosekiOre = new BlockKairosekiOre(1001, Material.rock).setHardness(3.0F).setResistance(25.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("KOre").func_111022_d("onepiecemod:KOre");
		GameRegistry.registerBlock(OPMod.KairosekiOre, "Kairoseki Ore");
		LanguageRegistry.addName(OPMod.KairosekiOre, "Kairoseki Ore");
		
		OPMod.DevilFruit = new BlockDevilFruit(1002, Material.plants).setStepSound(Block.soundClothFootstep).setUnlocalizedName("DFruit").func_111022_d("onepiecemod:DFruit");
		GameRegistry.registerBlock(OPMod.DevilFruit, "Devil Fruit");
		LanguageRegistry.addName(OPMod.DevilFruit, "Devil Fruit");
		
		OPMod.InstantEnchant = new BlockIEnchant(1003, Material.rock).setHardness(10.0F).setResistance(100.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("IEnchant").func_111022_d("onepiecemod:IEnchant");
		GameRegistry.registerBlock(OPMod.InstantEnchant, "Insta-chant");
		LanguageRegistry.addName(OPMod.InstantEnchant, "Insta-chant");
		
	}
}
