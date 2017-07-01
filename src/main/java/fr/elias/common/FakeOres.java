package fr.elias.common;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

@Mod(modid="fakeores", name="Fake Ores 2", version="1.9")
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
					   boss_spawner,
					   totem,
					   red_gem;
	
	//items for achievement icon !!! RESERVED !!!
	public static Item cupAchiev;
	
	public static Block antiOreStone;
	
	public int fakeOres_prob;
	
	public static final CreativeTabs fakeOresTab = new CreativeTabs("fakeOresTab"){
		@Override
		public ItemStack getTabIconItem()
		{
			return new ItemStack(FakeOres.antiOresBlade);
		}
	};
	
	/*
	public static Achievement boss_defeated;
	public static Achievement broken_Cup;
	public static Achievement killFakeOreWithAntiOreBlade;
	*/
	
	public static boolean useOldOresBossModel;
	
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
			
			fakeOres_prob = config.get("Spawn", "Fake Ore Probability", 9).getInt();
			
			useOldOresBossModel = config.getBoolean("useOldOresBossModel", "Property", false, "Use the old Ores Boss Model (made by UnknownOrigins) from the 1.6 mod version.");
			config.save();
		} finally {
			if(config.hasChanged())
			{
				config.save();
			}
		}
		
		antiOresBlade = new ItemSword(ToolMaterial.WOOD).setCreativeTab(fakeOresTab).setUnlocalizedName("antiOresBlade").setRegistryName("antiOresBlade");
		boss_fragment_1 = new Item().setCreativeTab(fakeOresTab).setUnlocalizedName("boss_fragment_1").setRegistryName("boss_fragment_1");
		boss_fragment_2 = new Item().setCreativeTab(fakeOresTab).setUnlocalizedName("boss_fragment_2").setRegistryName("boss_fragment_2");
		boss_fragment_3 = new Item().setCreativeTab(fakeOresTab).setUnlocalizedName("boss_fragment_3").setRegistryName("boss_fragment_3");
		boss_fragment_4 = new Item().setCreativeTab(fakeOresTab).setUnlocalizedName("boss_fragment_4").setRegistryName("boss_fragment_4");
		boss_spawner = new ItemBossSpawner().setCreativeTab(fakeOresTab).setUnlocalizedName("boss_spawner").setRegistryName("boss_spawner");
		totem = new ItemTotem().setMaxStackSize(1).setCreativeTab(fakeOresTab).setUnlocalizedName("totem").setRegistryName("totem");
		red_gem = new Item().setCreativeTab(fakeOresTab).setUnlocalizedName("red_gem").setRegistryName("red_gem");
		
		EntityRegistry.registerModEntity(new ResourceLocation("fakeores:DiamondOre"), EntityDiamondOre.class, "DiamondOre", diamondOre_ID, this, 40, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation("fakeores:CoalOre"), EntityCoalOre.class, "CoalOre", coalOre_ID, this, 40, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation("fakeores:EmeraldOre"), EntityEmeraldOre.class, "EmeraldOre", emeraldOre_ID, this, 40, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation("fakeores:GoldOre"), EntityGoldOre.class, "GoldOre", goldOre_ID, this, 40, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation("fakeores:IronOre"), EntityIronOre.class, "IronOre", ironOre_ID, this, 40, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation("fakeores:LapisOre"), EntityLapisOre.class, "LapisOre", lapisOre_ID, this, 40, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation("fakeores:NetherQuartzOre"), EntityNetherQuartzOre.class, "NetherQuartzOre", quartzOre_ID, this, 40, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation("fakeores:RedstoneOre"), EntityRedstoneOre.class, "RedstoneOre", redstoneOre_ID, this, 40, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation("fakeores:Cup"), EntityCup.class, "Cup", cup_ID, this, 40, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation("fakeores:BossTeleporter"), EntityBossTeleporter.class, "BossTeleporter", boss_teleporter_ID, this, 40, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation("fakeores:OresBoss"), EntityOresBoss.class, "OresBoss", ores_boss_ID, this, 40, 1, true);
		
		antiOreStone = new BlockAntiOreStone().setResistance(1F).setHardness(0.8F).setUnlocalizedName("antiOreStone").setRegistryName("antiOreStone");
		GameRegistry.registerWorldGenerator(new WorldGenAntiOreStone(), 0);
		
		cupAchiev = new Item().setUnlocalizedName("cupAchiev").setRegistryName("cupAchiev");
		
		/*
		boss_defeated = new Achievement("achievement.boss_defeated", "boss_defeated", 1, 0, FakeOres.boss_spawner, null).initIndependentStat().registerStat();
		broken_Cup = new Achievement("achievement.broken_Cup", "broken_Cup", 1, -2, cupAchiev, boss_defeated).registerStat();
		killFakeOreWithAntiOreBlade = new Achievement("achievement.killFakeOreWithAntiOreBlade", "killFakeOreWithAntiOreBlade", 1, -4, antiOresBlade, null).initIndependentStat().registerStat();
		*/

		MinecraftForge.EVENT_BUS.register(this);
		MinecraftForge.EVENT_BUS.register(new BlockDropEvent());
		MinecraftForge.EVENT_BUS.register(new FakeOresSoundEvent());
	}
	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
		proxy.loadAllRender();
	}
	
	@SubscribeEvent
	public void registerBlocks(RegistryEvent.Register<Block> event)
	{
		event.getRegistry().registerAll(antiOreStone);
	}
	
	@SubscribeEvent
	public void registerItems(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll(antiOresBlade, boss_fragment_1, boss_fragment_2,
		boss_fragment_3, boss_fragment_4, boss_spawner, cupAchiev, getItemBlock(antiOreStone), totem, red_gem);
	}
	
	public static Item getItemBlock(Block block)
	{
		return new ItemBlock(block).setRegistryName(block.getRegistryName());
	}
}
