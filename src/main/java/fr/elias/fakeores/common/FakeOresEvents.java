package fr.elias.fakeores.common;

import java.util.Random;

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
import net.minecraft.entity.EntityType;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;


@EventBusSubscriber(modid = FakeOres.MOD_ID, bus = Bus.MOD)
public class FakeOresEvents {
	
	public static Random rand = new Random();
	
	//ENTITIES
    public static final EntityType<EntityCoalOre> FAKE_COAL = EntityType.Builder.create(EntityCoalOre.class, EntityCoalOre::new).tracker(64, 2, true).build("coal_ore");
    public static final EntityType<EntityDiamondOre> FAKE_DIAMOND = EntityType.Builder.create(EntityDiamondOre.class, EntityDiamondOre::new).tracker(64, 2, true).build("diamond_ore");
    public static final EntityType<EntityEmeraldOre> FAKE_EMERALD = EntityType.Builder.create(EntityEmeraldOre.class, EntityEmeraldOre::new).tracker(64, 2, true).build("emerald_ore");
    public static final EntityType<EntityGoldOre> FAKE_GOLD = EntityType.Builder.create(EntityGoldOre.class, EntityGoldOre::new).tracker(64, 2, true).build("gold_ore");
    public static final EntityType<EntityIronOre> FAKE_IRON = EntityType.Builder.create(EntityIronOre.class, EntityIronOre::new).tracker(64, 2, true).build("iron_ore");
    public static final EntityType<EntityLapisOre> FAKE_LAPIS = EntityType.Builder.create(EntityLapisOre.class, EntityLapisOre::new).tracker(64, 2, true).build("lapis_ore");
    public static final EntityType<EntityNetherQuartzOre> FAKE_QUARTZ = EntityType.Builder.create(EntityNetherQuartzOre.class, EntityNetherQuartzOre::new).tracker(64, 2, true).build("quartz_ore");
    public static final EntityType<EntityRedstoneOre> FAKE_REDSTONE = EntityType.Builder.create(EntityRedstoneOre.class, EntityRedstoneOre::new).tracker(64, 2, true).build("ore_boss");
    public static final EntityType<EntityCup> CUP = EntityType.Builder.create(EntityCup.class, EntityCup::new).tracker(64, 2, true).build("cup");
    public static final EntityType<EntityBossTeleporter> BOSS_TELEPORTER = EntityType.Builder.create(EntityBossTeleporter.class, EntityBossTeleporter::new).tracker(64, 2, true).build("boss_teleporter");
    public static final EntityType<EntityOresBoss> ORES_BOSS = EntityType.Builder.create(EntityOresBoss.class, EntityOresBoss::new).tracker(64, 2, true).build("ores_boss");

    // SOUNDS
    public static final SoundEvent ORE_BOSS_DEATH = new SoundEvent(new ResourceLocation(FakeOres.MOD_ID, "oreboss.death")).setRegistryName("ore_boss_death");
    public static final SoundEvent ORE_BOSS_HURT = new SoundEvent(new ResourceLocation(FakeOres.MOD_ID, "oreboss.hurt")).setRegistryName("ore_boss_hurt");
    public static final SoundEvent ORE_BOSS_PHASE_2 = new SoundEvent(new ResourceLocation(FakeOres.MOD_ID, "oreboss.phase.two")).setRegistryName("ore_boss_phase2");
    public static final SoundEvent ORE_BOSS_PHASE_3 = new SoundEvent(new ResourceLocation(FakeOres.MOD_ID, "oreboss.phase.three")).setRegistryName("ore_boss_phase3");
    
    
	@SubscribeEvent
	public static void initEntitiesEvent(RegistryEvent.Register<EntityType<?>> event) {
		FAKE_COAL.setRegistryName("coal_ore");
		FAKE_DIAMOND.setRegistryName("diamond_ore");
		FAKE_EMERALD.setRegistryName("emerald_ore");
		FAKE_GOLD.setRegistryName("gold_ore");
		FAKE_IRON.setRegistryName("iron_ore");
		FAKE_LAPIS.setRegistryName("lapis_ore");
		FAKE_QUARTZ.setRegistryName("quartz_ore");
		FAKE_REDSTONE.setRegistryName("redstone_ore");
		CUP.setRegistryName("cup");
		BOSS_TELEPORTER.setRegistryName("boss_teleporter");
		ORES_BOSS.setRegistryName("ores_boss");
		
		
		event.getRegistry().registerAll(FAKE_COAL, FAKE_DIAMOND, FAKE_EMERALD, FAKE_GOLD, FAKE_IRON, FAKE_LAPIS, FAKE_QUARTZ, FAKE_REDSTONE, CUP, BOSS_TELEPORTER, ORES_BOSS);
	}
	
	@SubscribeEvent
    public static void registerSound(RegistryEvent.Register<SoundEvent> event) {
        event.getRegistry().registerAll(ORE_BOSS_DEATH, ORE_BOSS_HURT, ORE_BOSS_PHASE_2, ORE_BOSS_PHASE_3);
    }
	
	@SubscribeEvent
	public static void onBlockDestroyed(BlockEvent.BreakEvent event) {
		World world = (World) event.getWorld();
		
		if(event.getState().getBlock() == Blocks.DIAMOND_ORE) {
	  		  EntityDiamondOre fakeDiamond = new EntityDiamondOre(world);
	  		  fakeDiamond.setPositionAndRotation(event.getPos().getX() + 0.5D, event.getPos().getY(), event.getPos().getZ() + 0.5D, 0.0F, 0.0F);
	  		  if(!world.isRemote && rand.nextInt(FakeOresConfig.Server.fakeores_prob.get()) == 0)
	  		  {
	  			  world.spawnEntity(fakeDiamond);
	  		  }
		}
		
		if (event.getState().getBlock() == Blocks.COAL_ORE) {
			EntityCoalOre fakeCoal = new EntityCoalOre(world);
			fakeCoal.setPositionAndRotation(event.getPos().getX() + 0.5D, event.getPos().getY(), event.getPos().getZ() + 0.5D, 0.0F, 0.0F);
			if (!world.isRemote && rand.nextInt(FakeOresConfig.Server.fakeores_prob.get()) == 0) {
				world.spawnEntity(fakeCoal);
			}
		}

		if (event.getState().getBlock() == Blocks.EMERALD_ORE) {
			EntityEmeraldOre fakeEmerald = new EntityEmeraldOre(world);
			fakeEmerald.setPositionAndRotation(event.getPos().getX() + 0.5D, event.getPos().getY(),	event.getPos().getZ() + 0.5D, 0.0F, 0.0F);
			if (!world.isRemote && rand.nextInt(FakeOresConfig.Server.fakeores_prob.get()) == 0) {
				world.spawnEntity(fakeEmerald);
			}
		}

		if (event.getState().getBlock() == Blocks.GOLD_ORE) {
			EntityGoldOre fakeGold = new EntityGoldOre(world);
			fakeGold.setPositionAndRotation(event.getPos().getX() + 0.5D, event.getPos().getY(), event.getPos().getZ() + 0.5D, 0.0F, 0.0F);
			if (!world.isRemote && rand.nextInt(FakeOresConfig.Server.fakeores_prob.get()) == 0) {
				world.spawnEntity(fakeGold);
			}
		}

		if (event.getState().getBlock() == Blocks.IRON_ORE) {
			EntityIronOre fakeIron = new EntityIronOre(world);
			fakeIron.setPositionAndRotation(event.getPos().getX() + 0.5D, event.getPos().getY(), event.getPos().getZ() + 0.5D, 0.0F, 0.0F);
			if (!world.isRemote && rand.nextInt(FakeOresConfig.Server.fakeores_prob.get()) == 0) {
				world.spawnEntity(fakeIron);
			}
		}

		if (event.getState().getBlock() == Blocks.LAPIS_ORE) {
			EntityLapisOre fakeLapis = new EntityLapisOre(world);
			fakeLapis.setPositionAndRotation(event.getPos().getX() + 0.5D, event.getPos().getY(), event.getPos().getZ() + 0.5D, 0.0F, 0.0F);
			if (!world.isRemote && rand.nextInt(FakeOresConfig.Server.fakeores_prob.get()) == 0) {
				world.spawnEntity(fakeLapis);
			}
		}

		if (event.getState().getBlock() == Blocks.NETHER_QUARTZ_ORE) {
			EntityNetherQuartzOre fakeQuartz = new EntityNetherQuartzOre(world);
			fakeQuartz.setPositionAndRotation(event.getPos().getX() + 0.5D, event.getPos().getY(), event.getPos().getZ() + 0.5D, 0.0F, 0.0F);
			if (!world.isRemote && rand.nextInt(FakeOresConfig.Server.fakeores_prob.get()) == 0) {
				world.spawnEntity(fakeQuartz);
			}
		}

		if (event.getState().getBlock() == Blocks.REDSTONE_ORE) {
			EntityRedstoneOre fakeRed = new EntityRedstoneOre(world);
			fakeRed.setPositionAndRotation(event.getPos().getX() + 0.5D, event.getPos().getY(),	event.getPos().getZ() + 0.5D, 0.0F, 0.0F);
			if (!world.isRemote && rand.nextInt(FakeOresConfig.Server.fakeores_prob.get()) == 0) {
				world.spawnEntity(fakeRed);
			}
		}
	}
}
