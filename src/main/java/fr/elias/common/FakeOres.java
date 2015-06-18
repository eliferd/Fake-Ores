package fr.elias.common;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

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
		
	}
	public void init(FMLInitializationEvent event)
	{
		proxy.loadAllRender();
	}
}
