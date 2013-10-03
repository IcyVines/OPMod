package net.minecraft.world.biome;

import java.util.Random;

import Mod.OPGeneration;
import Mod.OPMod;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;


public class BiomeGenOcean extends BiomeGenBase
{
    public BiomeGenOcean(int par1)
    {
        super(par1);
        this.spawnableCreatureList.clear();
    }
}
