	package Mod;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
	
	@Mod(modid = OPMod.modid, name = "One Piece Mod", version = "1.0")
	@NetworkMod(clientSideRequired = true, serverSideRequired = false)
	
	public class OPMod{
		
		public static final String modid = "onepiecemod";
		OPGeneration opgen = new OPGeneration();
		//public static Block creates a block, Item creates an item
		//Blocks
		public static Block KairosekiBlock;
		public static Block KairosekiOre;
		public static Block DevilFruit;
		public static Block InstantEnchant;
		//Items
		public static Item KairosekiIngot;
		public static Item KairosekiShovel;
		public static Item KairosekiPick;
		public static Item KairosekiAxe;
		public static Item KairosekiSword;
		public static Item KairosekiHoe;
		public static Item KairosekiSaw;
		public static Item WoodenSaw;
		public static Item StoneSaw;
		public static Item IronSaw;
		public static Item GoldSaw;
		public static Item DiamondSaw;
		//Armor
		public static Item KairosekiChest;
		public static Item KairosekiPants;
		public static Item KairosekiBoots;
		public static Item KairosekiHelmet;
		//Devil Fruits
		//Logia
		public static Item MizuMi;
		public static Item MaguMi;
		public static Item MeraMi;
		public static Item DarkMi;
		public static Item LightMi;
		public static Item IceMi;
		public static Item RumbleMi;
		public static Item SandMi;
		public static Item SmokeMi;
		public static Item PlasmaMi;
		public static Item GasMi;
		public static Item RoyMi;
		public static Item BrendanMi;
		//Zoan
		public static Item SheepMi;
		public static Item SquidMi;
		public static Item EnderMi;
		public static Item CreeperMi;
		public static Item SilverMi;
		public static Item WolfMi;
		public static Item OcelotMi;
		public static Item ChickenMi;
		public static Item CowMi;
		public static Item BlazeMi;
		public static Item SlimeMi;
		public static Item ZombieMi;
		public static Item GhastMi;
		public static Item SpiderMi;
		public static Item PigMi;
		//Paramecia
		public static Item GomuMi;
		public static Item VenomMi;
		public static Item PotionMi;
		public static Item EnchantMi;
		public static Item DanMi;
		public static Item ClearMi;
		public static Item DoorMi;
		public static Item SmoothMi;
		public static Item KiloMi;
		public static Item FloatMi;
		public static Item SpringMi;
		public static Item MarkMi;
		public static Item BombMi;
		public static Item TomMi;
		
		@EventHandler
		public void load(FMLInitializationEvent event){
			
			OnePieceItems.loadItems();
			OnePieceBlocks.loadBlocks();
			OnePieceCrafting.loadRecipes();
			GameRegistry.registerWorldGenerator(opgen);
		}
	}