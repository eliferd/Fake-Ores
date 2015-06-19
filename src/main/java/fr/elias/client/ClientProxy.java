package fr.elias.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import fr.elias.common.CommonProxy;
import fr.elias.common.EntityDiamondOre;
import fr.elias.common.FakeOres;

public class ClientProxy extends CommonProxy
{
	public void renderEntity()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityDiamondOre.class, new RenderDiamondOre());
	}
	
	public void renderItems()
	{
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(FakeOres.antiOresBlade, 0, new ModelResourceLocation("fakeores:antiOresBlade", "inventory"));
	}
	
	public void renderBlocks()
	{
		
	}
}
