package fr.elias.fakeores.client;

import fr.elias.fakeores.common.FakeOresItems;
import fr.elias.fakeores.entities.EntityBossTeleporter;
import fr.elias.fakeores.entities.EntityCoalOre;
import fr.elias.fakeores.entities.EntityCup;
import fr.elias.fakeores.entities.EntityDiamondOre;
import fr.elias.fakeores.entities.EntityEmeraldOre;
import fr.elias.fakeores.entities.EntityGoldOre;
import fr.elias.fakeores.entities.EntityIronOre;
import fr.elias.fakeores.entities.EntityLapisOre;
import fr.elias.fakeores.entities.EntityNetherQuartzOre;
import fr.elias.fakeores.entities.EntityOresBoss;
import fr.elias.fakeores.entities.EntityRedstoneOre;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSprite;
import net.minecraft.init.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

@OnlyIn(Dist.CLIENT)
public class RenderLoaders {

	public RenderLoaders() {
		RenderingRegistry.registerEntityRenderingHandler(EntityCoalOre.class, (RenderManager manager) -> new RenderOres (Blocks.COAL_ORE, manager));
		RenderingRegistry.registerEntityRenderingHandler(EntityDiamondOre.class, (RenderManager manager) -> new RenderOres (Blocks.DIAMOND_ORE, manager));
		RenderingRegistry.registerEntityRenderingHandler(EntityEmeraldOre.class, (RenderManager manager) -> new RenderOres (Blocks.EMERALD_ORE, manager));
		RenderingRegistry.registerEntityRenderingHandler(EntityGoldOre.class, (RenderManager manager) -> new RenderOres (Blocks.GOLD_ORE, manager));
		RenderingRegistry.registerEntityRenderingHandler(EntityIronOre.class, (RenderManager manager) -> new RenderOres (Blocks.IRON_ORE, manager));
		RenderingRegistry.registerEntityRenderingHandler(EntityLapisOre.class, (RenderManager manager) -> new RenderOres (Blocks.LAPIS_ORE, manager));
		RenderingRegistry.registerEntityRenderingHandler(EntityNetherQuartzOre.class, (RenderManager manager) -> new RenderOres (Blocks.NETHER_QUARTZ_ORE, manager));
		RenderingRegistry.registerEntityRenderingHandler(EntityRedstoneOre.class, (RenderManager manager) -> new RenderOres (Blocks.REDSTONE_ORE, manager));
		RenderingRegistry.registerEntityRenderingHandler(EntityCup.class, (RenderManager manager) -> new RenderCup(manager));
		RenderingRegistry.registerEntityRenderingHandler(EntityBossTeleporter.class, (RenderManager manager) -> new RenderSprite<>(manager, FakeOresItems.BOSS_SPAWNER, Minecraft.getInstance().getItemRenderer()));
		RenderingRegistry.registerEntityRenderingHandler(EntityOresBoss.class, (RenderManager manager) -> new RenderOresBoss(manager));
		
	}
}
