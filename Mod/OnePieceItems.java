package Mod;

import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraftforge.common.EnumHelper;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class OnePieceItems {
	public static void loadItems(){
		
		//Items
		OPMod.KairosekiIngot = new ItemKairosekiIngot(5000).setUnlocalizedName("KIngot").func_111206_d("onepiecemod:KIngot");
		LanguageRegistry.addName(OPMod.KairosekiIngot, "Kairoseki Ingot");
		//Tools
		OPMod.KairosekiShovel = new ItemSpade(5001, EnumToolMaterial.KAIROSEKI).setUnlocalizedName("KShovel").func_111206_d("onepiecemod:KShovel");
		LanguageRegistry.addName(OPMod.KairosekiShovel, "Kairoseki Shovel");
		
		OPMod.KairosekiPick = new ItemPickaxe(5002, EnumToolMaterial.KAIROSEKI).setUnlocalizedName("KPick").func_111206_d("onepiecemod:KPick");
		LanguageRegistry.addName(OPMod.KairosekiPick, "Kairoseki Pick");
		
		OPMod.KairosekiAxe = new ItemAxe(5003, EnumToolMaterial.KAIROSEKI).setUnlocalizedName("KAxe").func_111206_d("onepiecemod:KAxe");
		LanguageRegistry.addName(OPMod.KairosekiAxe, "Kairoseki Axe");
		
		OPMod.KairosekiSword = new ItemSword(5004, EnumToolMaterial.KAIROSEKI).setUnlocalizedName("KSword").func_111206_d("onepiecemod:KSword");
		LanguageRegistry.addName(OPMod.KairosekiSword, "Kairoseki Sword");
		
		OPMod.KairosekiHoe = new ItemHoe(5005, EnumToolMaterial.KAIROSEKI).setUnlocalizedName("KHoe").func_111206_d("onepiecemod:KHoe");
		LanguageRegistry.addName(OPMod.KairosekiHoe, "Kairoseki Hoe");
		
		OPMod.KairosekiSaw = new ItemSaw(5006, EnumToolMaterial.KAIROSEKI).setUnlocalizedName("KSaw").func_111206_d("onepiecemod:KSaw");
		LanguageRegistry.addName(OPMod.KairosekiSaw, "Kairoseki Saw");
		
		OPMod.WoodenSaw = new ItemSaw(5007, EnumToolMaterial.WOOD).setUnlocalizedName("WSaw").func_111206_d("onepiecemod:WSaw");
		LanguageRegistry.addName(OPMod.WoodenSaw, "Wood Saw");
		
		OPMod.StoneSaw = new ItemSaw(5008, EnumToolMaterial.STONE).setUnlocalizedName("SSaw").func_111206_d("onepiecemod:SSaw");
		LanguageRegistry.addName(OPMod.StoneSaw, "Stone Saw");

		OPMod.IronSaw = new ItemSaw(5009, EnumToolMaterial.IRON).setUnlocalizedName("ISaw").func_111206_d("onepiecemod:ISaw");
		LanguageRegistry.addName(OPMod.IronSaw, "Iron Saw");
		
		OPMod.GoldSaw = new ItemSaw(5010, EnumToolMaterial.GOLD).setUnlocalizedName("GSaw").func_111206_d("onepiecemod:GSaw");
		LanguageRegistry.addName(OPMod.GoldSaw, "Gold Saw");
		
		OPMod.DiamondSaw = new ItemSaw(5011, EnumToolMaterial.EMERALD).setUnlocalizedName("DSaw").func_111206_d("onepiecemod:DSaw");
		LanguageRegistry.addName(OPMod.DiamondSaw, "Diamond Saw");
		//Armor
		OPMod.KairosekiHelmet = (new ItemKArmor(5012, EnumArmorMaterial.KAIROSEKI, 0, 0, "kairoseki").setUnlocalizedName("KHelm").func_111206_d("onepiecemod:KHelmet"));
		LanguageRegistry.addName(OPMod.KairosekiHelmet, "Kairoseki Helmet");
		
		OPMod.KairosekiChest = new ItemKArmor(5013, EnumArmorMaterial.KAIROSEKI, 0, 1, "kairoseki").setUnlocalizedName("KChest").func_111206_d("onepiecemod:KBody");
		LanguageRegistry.addName(OPMod.KairosekiChest, "Kairoseki Chestplate");
		
		OPMod.KairosekiPants = new ItemKArmor(5014, EnumArmorMaterial.KAIROSEKI, 0, 2, "kairoseki").setUnlocalizedName("KLegs").func_111206_d("onepiecemod:KLegs");
		LanguageRegistry.addName(OPMod.KairosekiPants, "Kairoseki Leggings");
		
		OPMod.KairosekiBoots = new ItemKArmor(5015, EnumArmorMaterial.KAIROSEKI, 0, 3, "kairoseki").setUnlocalizedName("KBoots").func_111206_d("onepiecemod:KBoots");
		LanguageRegistry.addName(OPMod.KairosekiBoots, "Kairoseki Boots");
		
		OPMod.MizuMi = new ItemDevilFruit(5016, -4, -1.0F, true, false, 43).setAlwaysEdible().setPotionEffect(Potion.confusion.id, 10, 0, 100).setUnlocalizedName("MizuMi").func_111206_d("onepiecemod:MizuMi");
		LanguageRegistry.addName(OPMod.MizuMi, "Mizu Mizu no Mi");
		
		OPMod.MeraMi = new ItemDevilFruit(5017, -4, -1.0F, true, false, 42).setAlwaysEdible().setPotionEffect(Potion.confusion.id, 10, 0, 100).setUnlocalizedName("MeraMi").func_111206_d("onepiecemod:MeraMi");
		LanguageRegistry.addName(OPMod.MeraMi, "Mera Mera no Mi");
		
	}
}
