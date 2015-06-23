package fr.elias.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import fr.elias.common.CommonProxy;
import fr.elias.common.EntityCoalOre;
import fr.elias.common.EntityCup;
import fr.elias.common.EntityDiamondOre;
import fr.elias.common.EntityEmeraldOre;
import fr.elias.common.EntityGoldOre;
import fr.elias.common.EntityIronOre;
import fr.elias.common.EntityLapisOre;
import fr.elias.common.EntityNetherQuartzOre;
import fr.elias.common.EntityRedstoneOre;
import fr.elias.common.FakeOres;

public class ClientProxy extends CommonProxy
{
	public void renderEntity()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityDiamondOre.class, new RenderDiamondOre());
		RenderingRegistry.registerEntityRenderingHandler(EntityCoalOre.class, new RenderCoalOre());
		RenderingRegistry.registerEntityRenderingHandler(EntityEmeraldOre.class, new RenderEmeraldOre());
		RenderingRegistry.registerEntityRenderingHandler(EntityGoldOre.class, new RenderGoldOre());
		RenderingRegistry.registerEntityRenderingHandler(EntityIronOre.class, new RenderIronOre());
		RenderingRegistry.registerEntityRenderingHandler(EntityLapisOre.class, new RenderLapisOre());
		RenderingRegistry.registerEntityRenderingHandler(EntityNetherQuartzOre.class, new RenderNetherQuartzOre());
		RenderingRegistry.registerEntityRenderingHandler(EntityRedstoneOre.class, new RenderRedstoneOre());
		RenderingRegistry.registerEntityRenderingHandler(EntityCup.class, new RenderCup());
	}
	
	public void renderItems()
	{
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(FakeOres.antiOresBlade, 0, new ModelResourceLocation("fakeores:antiOresBlade", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(FakeOres.boss_fragment_1, 0, new ModelResourceLocation("fakeores:boss_fragment_1", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(FakeOres.boss_fragment_2, 0, new ModelResourceLocation("fakeores:boss_fragment_2", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(FakeOres.boss_fragment_3, 0, new ModelResourceLocation("fakeores:boss_fragment_3", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(FakeOres.boss_fragment_4, 0, new ModelResourceLocation("fakeores:boss_fragment_4", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(FakeOres.boss_spawner, 0, new ModelResourceLocation("fakeores:boss_spawner", "inventory"));
	}
	
	public void renderBlocks()
	{
		
	}
}
