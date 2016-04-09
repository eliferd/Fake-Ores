package fr.elias.client;

import fr.elias.common.CommonProxy;
import fr.elias.common.EntityBossTeleporter;
import fr.elias.common.EntityCoalOre;
import fr.elias.common.EntityCup;
import fr.elias.common.EntityDiamondOre;
import fr.elias.common.EntityEmeraldOre;
import fr.elias.common.EntityGoldOre;
import fr.elias.common.EntityIronOre;
import fr.elias.common.EntityLapisOre;
import fr.elias.common.EntityNetherQuartzOre;
import fr.elias.common.EntityOresBoss;
import fr.elias.common.EntityRedstoneOre;
import fr.elias.common.FakeOres;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
	public void renderEntity() {
		RenderingRegistry.registerEntityRenderingHandler(EntityDiamondOre.class, new RenderOres(Blocks.diamond_ore));
		RenderingRegistry.registerEntityRenderingHandler(EntityCoalOre.class, new RenderOres(Blocks.coal_ore));
		RenderingRegistry.registerEntityRenderingHandler(EntityEmeraldOre.class, new RenderOres(Blocks.emerald_ore));
		RenderingRegistry.registerEntityRenderingHandler(EntityGoldOre.class, new RenderOres(Blocks.gold_ore));
		RenderingRegistry.registerEntityRenderingHandler(EntityIronOre.class, new RenderOres(Blocks.iron_ore));
		RenderingRegistry.registerEntityRenderingHandler(EntityLapisOre.class, new RenderOres(Blocks.lapis_ore));
		RenderingRegistry.registerEntityRenderingHandler(EntityNetherQuartzOre.class, new RenderOres(Blocks.quartz_ore));
		RenderingRegistry.registerEntityRenderingHandler(EntityRedstoneOre.class, new RenderOres(Blocks.redstone_ore));
		RenderingRegistry.registerEntityRenderingHandler(EntityCup.class, new RenderCup());
		RenderingRegistry.registerEntityRenderingHandler(EntityBossTeleporter.class, new RenderSnowball(Minecraft.getMinecraft().getRenderManager(), FakeOres.boss_spawner, Minecraft.getMinecraft().getRenderItem()));
		RenderingRegistry.registerEntityRenderingHandler(EntityOresBoss.class, new RenderOresBoss());
	}

	public void renderItems() {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(FakeOres.antiOresBlade, 0, new ModelResourceLocation("fakeores:antiOresBlade", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(FakeOres.boss_fragment_1, 0, new ModelResourceLocation("fakeores:boss_fragment_1", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(FakeOres.boss_fragment_2, 0, new ModelResourceLocation("fakeores:boss_fragment_2", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(FakeOres.boss_fragment_3, 0, new ModelResourceLocation("fakeores:boss_fragment_3", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(FakeOres.boss_fragment_4, 0, new ModelResourceLocation("fakeores:boss_fragment_4", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(FakeOres.boss_spawner, 0, new ModelResourceLocation("fakeores:boss_spawner", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(FakeOres.cupAchiev, 0, new ModelResourceLocation("fakeores:cupAchiev", "inventory"));
	}

	public void renderBlocks() {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(FakeOres.antiOreStone), 0, new ModelResourceLocation("fakeores:antiOreStone", "inventory"));
	}
}
