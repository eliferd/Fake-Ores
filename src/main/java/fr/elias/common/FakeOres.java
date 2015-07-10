package fr.elias.common;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid="fakeores", name="Fake Ores 2", version="2.0")
public class FakeOres
{
	@SidedProxy(clientSide = "fr.elias.client.ClientProxy", serverSide = "fr.elias.common.CommonProxy")
	public static CommonProxy proxy;
	
	@Instance("fakeores")
	public static FakeOres instance;
	
	public int diamondOre_ID,
			   emeraldOre_ID,
			   goldOre_ID,
			   ironOre_ID,
			   coalOre_ID,
			   redstoneOre_ID,
			   quartzOre_ID,
			   lapisOre_ID,
			   cup_ID,
			   boss_teleporter_ID,
			   ores_boss_ID;
	public static Item antiOresBlade,
					   boss_fragment_1,
					   boss_fragment_2,
					   boss_fragment_3,
					   boss_fragment_4,
					   boss_spawner;
	
	//items for achievement icon !!! RESERVED !!!
	public static Item cupAchiev;
	
	public static Block antiOreStone;
	
	public int fakeOres_prob;
	
	public static final CreativeTabs fakeOresTab = new CreativeTabs("fakeOresTab"){

		@Override
		public Item getTabIconItem()
		{
			return antiOresBlade;
		}
		
	};
	
	public static Achievement boss_defeated;
	public static Achievement broken_Cup;
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		try {
			config.load();
			diamondOre_ID = config.get("Entity", "Diamond Ore Entity", 1010).getInt();
			emeraldOre_ID = config.get("Entity", "Emerald Ore Entity", 1011).getInt();
			goldOre_ID = config.get("Entity", "Gold Ore Entity", 1012).getInt();
			ironOre_ID = config.get("Entity", "Iron Ore Entity", 1013).getInt();
			coalOre_ID = config.get("Entity", "Coal Ore Entity", 1014).getInt();
			redstoneOre_ID = config.get("Entity", "Redstone Ore Entity", 1015).getInt();
			quartzOre_ID = config.get("Entity", "Quartz Ore Entity", 1016).getInt();
			lapisOre_ID = config.get("Entity", "Lapis Ore Entity", 1017).getInt();
			cup_ID = config.get("Entity", "Cup Entity", 1018).getInt();
			boss_teleporter_ID = config.get("Entity", "Boss Teleporter Entity", 1019).getInt();
			ores_boss_ID = config.get("Entity", "Ores Boss Entity", 1020).getInt();
			
			fakeOres_prob = config.get("Spawn", "Fake Ore Probability", 10).getInt();
			config.save();
		} finally{
			if(config.hasChanged())
			{
				config.save();
			}
		}
		antiOresBlade = new ItemSword(ToolMaterial.WOOD).setCreativeTab(fakeOresTab).setUnlocalizedName("antiOresBlade");
		boss_fragment_1 = new Item().setCreativeTab(fakeOresTab).setUnlocalizedName("boss_fragment_1");
		boss_fragment_2 = new Item().setCreativeTab(fakeOresTab).setUnlocalizedName("boss_fragment_2");
		boss_fragment_3 = new Item().setCreativeTab(fakeOresTab).setUnlocalizedName("boss_fragment_3");
		boss_fragment_4 = new Item().setCreativeTab(fakeOresTab).setUnlocalizedName("boss_fragment_4");
		boss_spawner = new ItemBossSpawner().setCreativeTab(fakeOresTab).setUnlocalizedName("boss_spawner");
		
		GameRegistry.registerItem(antiOresBlade, "antiOresBlade", "fakeores");
		GameRegistry.registerItem(boss_fragment_1, "boss_fragment_1", "fakeores");
		GameRegistry.registerItem(boss_fragment_2, "boss_fragment_2", "fakeores");
		GameRegistry.registerItem(boss_fragment_3, "boss_fragment_3", "fakeores");
		GameRegistry.registerItem(boss_fragment_4, "boss_fragment_4", "fakeores");
		GameRegistry.registerItem(boss_spawner, "boss_spawner", "fakeores");
		
		EntityRegistry.registerModEntity(EntityDiamondOre.class, "DiamondOre", diamondOre_ID, this, 40, 1, true);
		EntityRegistry.registerModEntity(EntityCoalOre.class, "CoalOre", coalOre_ID, this, 40, 1, true);
		EntityRegistry.registerModEntity(EntityEmeraldOre.class, "EmeraldOre", emeraldOre_ID, this, 40, 1, true);
		EntityRegistry.registerModEntity(EntityGoldOre.class, "GoldOre", goldOre_ID, this, 40, 1, true);
		EntityRegistry.registerModEntity(EntityIronOre.class, "IronOre", ironOre_ID, this, 40, 1, true);
		EntityRegistry.registerModEntity(EntityLapisOre.class, "LapisOre", lapisOre_ID, this, 40, 1, true);
		EntityRegistry.registerModEntity(EntityNetherQuartzOre.class, "NetherQuartzOre", quartzOre_ID, this, 40, 1, true);
		EntityRegistry.registerModEntity(EntityRedstoneOre.class, "RedstoneOre", redstoneOre_ID, this, 40, 1, true);
		EntityRegistry.registerModEntity(EntityCup.class, "Cup", cup_ID, this, 40, 1, true);
		EntityRegistry.registerModEntity(EntityBossTeleporter.class, "BossTeleporter", boss_teleporter_ID, this, 40, 1, true);
		EntityRegistry.registerModEntity(EntityOresBoss.class, "OresBoss", ores_boss_ID, this, 40, 1, true);
		
		MinecraftForge.EVENT_BUS.register(new BlockDropEvent());
		
		antiOreStone = new BlockAntiOreStone().setResistance(1F).setHardness(0.8F).setUnlocalizedName("antiOreStone");
		GameRegistry.registerBlock(antiOreStone, "antiOreStone");
		GameRegistry.registerWorldGenerator(new WorldGenAntiOreStone(), 0);
		
		cupAchiev = new Item().setUnlocalizedName("cupAchiev");
		GameRegistry.registerItem(cupAchiev, "cupAchiev");
		
		boss_defeated = new Achievement("achievement.boss_defeated", "boss_defeated", 1, 0, FakeOres.boss_spawner, null).setIndependent().func_180788_c();
		broken_Cup = new Achievement("achievement.broken_Cup", "broken_Cup", 1, -2, cupAchiev, boss_defeated).func_180788_c();
	}
	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
		GameRegistry.addRecipe(new ItemStack(boss_spawner, 1), new Object[]{"FGH", "GIG", "ZGV", 'F', boss_fragment_1, 'G', Items.gold_ingot, 'H', boss_fragment_2, 'I', Blocks.iron_block, 'Z', boss_fragment_4, 'V', boss_fragment_3});
		GameRegistry.addRecipe(new ItemStack(antiOresBlade, 1), new Object[]{"G", "G", "Z", 'G', antiOreStone, 'Z', Items.stick});
		proxy.loadAllRender();
	}
}
