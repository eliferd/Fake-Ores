package fr.elias.common;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

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
			   lapisOre_ID;
	public static Item antiOresBlade;
	
	public static final CreativeTabs fakeOresTab = new CreativeTabs("fakeOresTab"){

		@Override
		public Item getTabIconItem()
		{
			return Item.getItemFromBlock(Blocks.diamond_ore);
		}
		
	};
	
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
			config.save();
		} finally{
			if(config.hasChanged())
			{
				config.save();
			}
		}
		antiOresBlade = new ItemSword(ToolMaterial.WOOD).setCreativeTab(fakeOresTab).setUnlocalizedName("antiOresBlade");
		
		GameRegistry.registerItem(antiOresBlade, "antiOresBlade", "fakeores");
		
		
		
		EntityRegistry.registerGlobalEntityID(EntityDiamondOre.class, "DiamondOre", EntityRegistry.findGlobalUniqueEntityId(), 0, 0);
		EntityRegistry.registerModEntity(EntityDiamondOre.class, "DiamondOre", diamondOre_ID, this, 40, 1, true);
		
		if(event.getSide().isServer())
		{
			MinecraftForge.EVENT_BUS.register(new BlockDropEvent());
		}
	}
	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
		proxy.loadAllRender();
	}
}
