package fr.elias.common;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BlockDropEvent
{
    public Random rand = new Random();

    @SubscribeEvent
    public void onBlockDestroyed(BlockEvent.BreakEvent event)
    {
	  	  if (event.state.getBlock() == Blocks.diamond_ore)
	  	  {
	  		  EntityDiamondOre fakeDiamond = new EntityDiamondOre(event.world);
	  		  fakeDiamond.setPositionAndRotation(event.pos.getX() + 0.5D, event.pos.getY(), event.pos.getZ() + 0.5D, 0.0F, 0.0F);
	  		  if(!event.world.isRemote && rand.nextInt(FakeOres.instance.fakeOres_prob) == 0)
	  		  {
	  			  event.world.spawnEntityInWorld(fakeDiamond);
	  		  }
	  	  }
	  	  
	  	  if (event.state.getBlock() == Blocks.coal_ore)
	  	  {
	  		  EntityCoalOre fakeCoal = new EntityCoalOre(event.world);
	  		fakeCoal.setPositionAndRotation(event.pos.getX() + 0.5D, event.pos.getY(), event.pos.getZ() + 0.5D, 0.0F, 0.0F);
	  		  if(!event.world.isRemote && rand.nextInt(FakeOres.instance.fakeOres_prob) == 0)
	  		  {
	  			  event.world.spawnEntityInWorld(fakeCoal);
	  		  }
	  	  }

	  	  if (event.state.getBlock() == Blocks.emerald_ore)
	  	  {
	  		  EntityEmeraldOre fakeEmerald = new EntityEmeraldOre(event.world);
	  		  fakeEmerald.setPositionAndRotation(event.pos.getX() + 0.5D, event.pos.getY(), event.pos.getZ() + 0.5D, 0.0F, 0.0F);
	  		  if(!event.world.isRemote && rand.nextInt(FakeOres.instance.fakeOres_prob) == 0)
	  		  {
	  			  event.world.spawnEntityInWorld(fakeEmerald);
	  		  }
	  	  }
	  	  
	  	  if (event.state.getBlock() == Blocks.gold_ore)
	  	  {
	  		  EntityGoldOre fakeGold = new EntityGoldOre(event.world);
	  		  fakeGold.setPositionAndRotation(event.pos.getX() + 0.5D, event.pos.getY(), event.pos.getZ() + 0.5D, 0.0F, 0.0F);
	  		  if(!event.world.isRemote && rand.nextInt(FakeOres.instance.fakeOres_prob) == 0)
	  		  {
	  			  event.world.spawnEntityInWorld(fakeGold);
	  		  }
	  	  }
	  	  
	  	  if (event.state.getBlock() == Blocks.iron_ore)
	  	  {
	  		  EntityIronOre fakeIron = new EntityIronOre(event.world);
	  		  fakeIron.setPositionAndRotation(event.pos.getX() + 0.5D, event.pos.getY(), event.pos.getZ() + 0.5D, 0.0F, 0.0F);
	  		  if(!event.world.isRemote && rand.nextInt(FakeOres.instance.fakeOres_prob) == 0)
	  		  {
	  			  event.world.spawnEntityInWorld(fakeIron);
	  		  }
	  	  }
	  	  
	  	  if (event.state.getBlock() == Blocks.lapis_ore)
	  	  {
	  		  EntityLapisOre fakeLapis = new EntityLapisOre(event.world);
	  		fakeLapis.setPositionAndRotation(event.pos.getX() + 0.5D, event.pos.getY(), event.pos.getZ() + 0.5D, 0.0F, 0.0F);
	  		  if(!event.world.isRemote && rand.nextInt(FakeOres.instance.fakeOres_prob) == 0)
	  		  {
	  			  event.world.spawnEntityInWorld(fakeLapis);
	  		  }
	  	  }
	  	  
	  	  if (event.state.getBlock() == Blocks.quartz_ore)
	  	  {
	  		  EntityNetherQuartzOre fakeQuartz = new EntityNetherQuartzOre(event.world);
	  		  fakeQuartz.setPositionAndRotation(event.pos.getX() + 0.5D, event.pos.getY(), event.pos.getZ() + 0.5D, 0.0F, 0.0F);
	  		  if(!event.world.isRemote && rand.nextInt(FakeOres.instance.fakeOres_prob) == 0)
	  		  {
	  			  event.world.spawnEntityInWorld(fakeQuartz);
	  		  }
	  	  }
	  	  
	  	  if (event.state.getBlock() == Blocks.redstone_ore)
	  	  {
	  		  EntityRedstoneOre fakeRed = new EntityRedstoneOre(event.world);
	  		  fakeRed.setPositionAndRotation(event.pos.getX() + 0.5D, event.pos.getY(), event.pos.getZ() + 0.5D, 0.0F, 0.0F);
	  		  if(!event.world.isRemote && rand.nextInt(FakeOres.instance.fakeOres_prob) == 0)
	  		  {
	  			  event.world.spawnEntityInWorld(fakeRed);
	  		  }
	  	  }
    }
}
