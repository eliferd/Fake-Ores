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
	
	public void preInit(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		try {
			config.load();
			
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
