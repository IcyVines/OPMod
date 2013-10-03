package Mod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemKArmor extends ItemArmor{

	public String texturePath = "onepiecemod:";
	public EnumArmorMaterial material;

	public ItemKArmor(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4, String type)
	{
	super(par1, par2EnumArmorMaterial, par3, par4);
	this.maxStackSize = 1;
	this.SetArmorType(type.toLowerCase(), par4);
	}

	private void SetArmorType(String type, int par4){
		switch(par4)
		{
		case 0: 
			this.texturePath += "kairoseki_layer_1.png";
		case 1: 
			this.texturePath += "kairoseki_layer_1.png";
		case 2: 
			this.texturePath += "kairoseki_layer_2.png";
		case 3: 
			this.texturePath += "kairoseki_layer_1.png";
		}
	}
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer){
		if(itemID == OPMod.KairosekiHelmet.itemID || itemID == OPMod.KairosekiChest.itemID || itemID == OPMod.KairosekiBoots.itemID)
	{
			return "onepiecemod:models/armor/kairoseki_layer_1.png";
	}
		if(itemID == OPMod.KairosekiPants.itemID)
	{
			return "onepiecemod:models/armor/kairoseki_layer_2.png";
	}
		else return null;
	}
	
	
	

}
