package net.minecraft.entity;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;

import cpw.mods.fml.common.FMLLog;
import net.minecraft.entity.ai.EntityMinecartMobSpawner;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.item.EntityEnderEye;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.item.EntityExpBottle;
import net.minecraft.entity.item.EntityFallingSand;
import net.minecraft.entity.item.EntityFireworkRocket;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.item.EntityMinecartChest;
import net.minecraft.entity.item.EntityMinecartEmpty;
import net.minecraft.entity.item.EntityMinecartFurnace;
import net.minecraft.entity.item.EntityMinecartHopper;
import net.minecraft.entity.item.EntityMinecartTNT;
import net.minecraft.entity.item.EntityPainting;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityList
{
    /** Provides a mapping between entity classes and a string */
    public static Map stringToClassMapping = new HashMap();

    /** Provides a mapping between a string and an entity classes */
    public static Map classToStringMapping = new HashMap();

    /** provides a mapping between an entityID and an Entity Class */
    public static Map IDtoClassMapping = new HashMap();

    /** provides a mapping between an Entity Class and an entity ID */
    private static Map classToIDMapping = new HashMap();

    /** Maps entity names to their numeric identifiers */
    private static Map stringToIDMapping = new HashMap();

    /** This is a HashMap of the Creative Entity Eggs/Spawners. */
    public static HashMap entityEggs = new LinkedHashMap();

    /**
     * adds a mapping between Entity classes and both a string representation and an ID
     */
    public static void addMapping(Class par0Class, String par1Str, int par2)
    {
        stringToClassMapping.put(par1Str, par0Class);
        classToStringMapping.put(par0Class, par1Str);
        IDtoClassMapping.put(Integer.valueOf(par2), par0Class);
        classToIDMapping.put(par0Class, Integer.valueOf(par2));
        stringToIDMapping.put(par1Str, Integer.valueOf(par2));
    }

    /**
     * Adds a entity mapping with egg info.
     */
    public static void addMapping(Class par0Class, String par1Str, int par2, int par3, int par4)
    {
        addMapping(par0Class, par1Str, par2);
        entityEggs.put(Integer.valueOf(par2), new EntityEggInfo(par2, par3, par4));
    }

    /**
     * Create a new instance of an entity in the world by using the entity name.
     */
    public static Entity createEntityByName(String par0Str, World par1World)
    {
        Entity entity = null;

        try
        {
            Class oclass = (Class)stringToClassMapping.get(par0Str);

            if (oclass != null)
            {
                entity = (Entity)oclass.getConstructor(new Class[] {World.class}).newInstance(new Object[] {par1World});
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }

        return entity;
    }

    /**
     * create a new instance of an entity from NBT store
     */
    public static Entity createEntityFromNBT(NBTTagCompound par0NBTTagCompound, World par1World)
    {
        Entity entity = null;

        if ("Minecart".equals(par0NBTTagCompound.getString("id")))
        {
            switch (par0NBTTagCompound.getInteger("Type"))
            {
                case 0:
                    par0NBTTagCompound.setString("id", "MinecartRideable");
                    break;
                case 1:
                    par0NBTTagCompound.setString("id", "MinecartChest");
                    break;
                case 2:
                    par0NBTTagCompound.setString("id", "MinecartFurnace");
            }

            par0NBTTagCompound.removeTag("Type");
        }

        Class oclass = null;
        try
        {
            oclass = (Class)stringToClassMapping.get(par0NBTTagCompound.getString("id"));

            if (oclass != null)
            {
                entity = (Entity)oclass.getConstructor(new Class[] {World.class}).newInstance(new Object[] {par1World});
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }

        if (entity != null)
        {
            try
            {
                entity.readFromNBT(par0NBTTagCompound);
            }
            catch (Exception e)
            {
                FMLLog.log(Level.SEVERE, e,
                        "An Entity %s(%s) has thrown an exception during loading, its state cannot be restored. Report this to the mod author",
                        par0NBTTagCompound.getString("id"), oclass.getName());
                entity = null;
            }
        }
        else
        {
            par1World.getWorldLogAgent().logWarning("Skipping Entity with id " + par0NBTTagCompound.getString("id"));
        }

        return entity;
    }

    /**
     * Create a new instance of an entity in the world by using an entity ID.
     */
    public static Entity createEntityByID(int par0, World par1World)
    {
        Entity entity = null;

        try
        {
            Class oclass = getClassFromID(par0);

            if (oclass != null)
            {
                entity = (Entity)oclass.getConstructor(new Class[] {World.class}).newInstance(new Object[] {par1World});
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }

        if (entity == null)
        {
            par1World.getWorldLogAgent().logWarning("Skipping Entity with id " + par0);
        }

        return entity;
    }

    /**
     * gets the entityID of a specific entity
     */
    public static int getEntityID(Entity par0Entity)
    {
        Class oclass = par0Entity.getClass();
        return classToIDMapping.containsKey(oclass) ? ((Integer)classToIDMapping.get(oclass)).intValue() : 0;
    }

    /**
     * Return the class assigned to this entity ID.
     */
    public static Class getClassFromID(int par0)
    {
        return (Class)IDtoClassMapping.get(Integer.valueOf(par0));
    }

    /**
     * Gets the string representation of a specific entity.
     */
    public static String getEntityString(Entity par0Entity)
    {
        return (String)classToStringMapping.get(par0Entity.getClass());
    }

    /**
     * Finds the class using IDtoClassMapping and classToStringMapping
     */
    public static String getStringFromID(int par0)
    {
        Class oclass = getClassFromID(par0);
        return oclass != null ? (String)classToStringMapping.get(oclass) : null;
    }

    static
    {
        addMapping(EntityItem.class, "Item", 1);
        addMapping(EntityXPOrb.class, "XPOrb", 2);
        addMapping(EntityLeashKnot.class, "LeashKnot", 8);
        addMapping(EntityPainting.class, "Painting", 9);
        addMapping(EntityArrow.class, "Arrow", 10);
        addMapping(EntitySnowball.class, "Snowball", 11);
        addMapping(EntityLargeFireball.class, "Fireball", 12);
        addMapping(EntitySmallFireball.class, "SmallFireball", 13);
        addMapping(EntityEnderPearl.class, "ThrownEnderpearl", 14);
        addMapping(EntityEnderEye.class, "EyeOfEnderSignal", 15);
        addMapping(EntityPotion.class, "ThrownPotion", 16);
        addMapping(EntityExpBottle.class, "ThrownExpBottle", 17);
        addMapping(EntityItemFrame.class, "ItemFrame", 18);
        addMapping(EntityWitherSkull.class, "WitherSkull", 19);
        addMapping(EntityTNTPrimed.class, "PrimedTnt", 20);
        addMapping(EntityFallingSand.class, "FallingSand", 21);
        addMapping(EntityFireworkRocket.class, "FireworksRocketEntity", 22);
        addMapping(EntityBoat.class, "Boat", 41);
        addMapping(EntityMinecartEmpty.class, "MinecartRideable", 42);
        addMapping(EntityMinecartChest.class, "MinecartChest", 43);
        addMapping(EntityMinecartFurnace.class, "MinecartFurnace", 44);
        addMapping(EntityMinecartTNT.class, "MinecartTNT", 45);
        addMapping(EntityMinecartHopper.class, "MinecartHopper", 46);
        addMapping(EntityMinecartMobSpawner.class, "MinecartSpawner", 47);
        addMapping(EntityLiving.class, "Mob", 48);
        addMapping(EntityMob.class, "Monster", 49);
        addMapping(EntityCreeper.class, "Creeper", 50, 894731, 0);
        addMapping(EntitySkeleton.class, "Skeleton", 51, 12698049, 4802889);
        addMapping(EntitySpider.class, "Spider", 52, 3419431, 11013646);
        addMapping(EntityGiantZombie.class, "Giant", 53);
        addMapping(EntityZombie.class, "Zombie", 54, 44975, 7969893);
        addMapping(EntitySlime.class, "Slime", 55, 5349438, 8306542);
        addMapping(EntityGhast.class, "Ghast", 56, 16382457, 12369084);
        addMapping(EntityPigZombie.class, "PigZombie", 57, 15373203, 5009705);
        addMapping(EntityEnderman.class, "Enderman", 58, 1447446, 0);
        addMapping(EntityCaveSpider.class, "CaveSpider", 59, 803406, 11013646);
        addMapping(EntitySilverfish.class, "Silverfish", 60, 7237230, 3158064);
        addMapping(EntityBlaze.class, "Blaze", 61, 16167425, 16775294);
        addMapping(EntityMagmaCube.class, "LavaSlime", 62, 3407872, 16579584);
        addMapping(EntityDragon.class, "EnderDragon", 63);
        addMapping(EntityWither.class, "WitherBoss", 64);
        addMapping(EntityBat.class, "Bat", 65, 4996656, 986895);
        addMapping(EntityWitch.class, "Witch", 66, 3407872, 5349438);
        addMapping(EntityPig.class, "Pig", 90, 15771042, 14377823);
        addMapping(EntitySheep.class, "Sheep", 91, 15198183, 16758197);
        addMapping(EntityCow.class, "Cow", 92, 4470310, 10592673);
        addMapping(EntityChicken.class, "Chicken", 93, 10592673, 16711680);
        addMapping(EntitySquid.class, "Squid", 94, 2243405, 7375001);
        addMapping(EntityWolf.class, "Wolf", 95, 14144467, 13545366);
        addMapping(EntityMooshroom.class, "MushroomCow", 96, 10489616, 12040119);
        addMapping(EntitySnowman.class, "SnowMan", 97);
        addMapping(EntityOcelot.class, "Ozelot", 98, 15720061, 5653556);
        addMapping(EntityIronGolem.class, "VillagerGolem", 99);
        addMapping(EntityHorse.class, "EntityHorse", 100, 12623485, 15656192);
        addMapping(EntityVillager.class, "Villager", 120, 5651507, 12422002);
        addMapping(EntityEnderCrystal.class, "EnderCrystal", 200);
    }
}
