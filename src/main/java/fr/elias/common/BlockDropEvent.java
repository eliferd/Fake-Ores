package fr.elias.common;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BlockDropEvent
{
    public Random rand = new Random();

    @SubscribeEvent
    public void onBlockDestroyed(BlockEvent.BreakEvent event)
    {
	  	  if (event.getState().getBlock() == Blocks.DIAMOND_ORE)
	  	  {
	  		  EntityDiamondOre fakeDiamond = new EntityDiamondOre(event.getWorld());
	  		  fakeDiamond.setPositionAndRotation(event.getPos().getX() + 0.5D, event.getPos().getY(), event.getPos().getZ() + 0.5D, 0.0F, 0.0F);
	  		  if(!event.getWorld().isRemote && rand.nextInt(FakeOres.instance.fakeOres_prob) == 0)
	  		  {
	  			  event.getWorld().spawnEntity(fakeDiamond);
	  		  }
	  	  }
	  	  
	  	  if (event.getState().getBlock() == Blocks.COAL_ORE)
	  	  {
	  		  EntityCoalOre fakeCoal = new EntityCoalOre(event.getWorld());
	  		fakeCoal.setPositionAndRotation(event.getPos().getX() + 0.5D, event.getPos().getY(), event.getPos().getZ() + 0.5D, 0.0F, 0.0F);
	  		  if(!event.getWorld().isRemote && rand.nextInt(FakeOres.instance.fakeOres_prob) == 0)
	  		  {
	  			  event.getWorld().spawnEntity(fakeCoal);
	  		  }
	  	  }

	  	  if (event.getState().getBlock() == Blocks.EMERALD_ORE)
	  	  {
	  		  EntityEmeraldOre fakeEmerald = new EntityEmeraldOre(event.getWorld());
	  		  fakeEmerald.setPositionAndRotation(event.getPos().getX() + 0.5D, event.getPos().getY(), event.getPos().getZ() + 0.5D, 0.0F, 0.0F);
	  		  if(!event.getWorld().isRemote && rand.nextInt(FakeOres.instance.fakeOres_prob) == 0)
	  		  {
	  			  event.getWorld().spawnEntity(fakeEmerald);
	  		  }
	  	  }
	  	  
	  	  if (event.getState().getBlock() == Blocks.GOLD_ORE)
	  	  {
	  		  EntityGoldOre fakeGold = new EntityGoldOre(event.getWorld());
	  		  fakeGold.setPositionAndRotation(event.getPos().getX() + 0.5D, event.getPos().getY(), event.getPos().getZ() + 0.5D, 0.0F, 0.0F);
	  		  if(!event.getWorld().isRemote && rand.nextInt(FakeOres.instance.fakeOres_prob) == 0)
	  		  {
	  			  event.getWorld().spawnEntity(fakeGold);
	  		  }
	  	  }
	  	  
	  	  if (event.getState().getBlock() == Blocks.IRON_ORE)
	  	  {
	  		  EntityIronOre fakeIron = new EntityIronOre(event.getWorld());
	  		  fakeIron.setPositionAndRotation(event.getPos().getX() + 0.5D, event.getPos().getY(), event.getPos().getZ() + 0.5D, 0.0F, 0.0F);
	  		  if(!event.getWorld().isRemote && rand.nextInt(FakeOres.instance.fakeOres_prob) == 0)
	  		  {
	  			  event.getWorld().spawnEntity(fakeIron);
	  		  }
	  	  }
	  	  
	  	  if (event.getState().getBlock() == Blocks.LAPIS_ORE)
	  	  {
	  		  EntityLapisOre fakeLapis = new EntityLapisOre(event.getWorld());
	  		fakeLapis.setPositionAndRotation(event.getPos().getX() + 0.5D, event.getPos().getY(), event.getPos().getZ() + 0.5D, 0.0F, 0.0F);
	  		  if(!event.getWorld().isRemote && rand.nextInt(FakeOres.instance.fakeOres_prob) == 0)
	  		  {
	  			  event.getWorld().spawnEntity(fakeLapis);
	  		  }
	  	  }
	  	  
	  	  if (event.getState().getBlock() == Blocks.QUARTZ_ORE)
	  	  {
	  		  EntityNetherQuartzOre fakeQuartz = new EntityNetherQuartzOre(event.getWorld());
	  		  fakeQuartz.setPositionAndRotation(event.getPos().getX() + 0.5D, event.getPos().getY(), event.getPos().getZ() + 0.5D, 0.0F, 0.0F);
	  		  if(!event.getWorld().isRemote && rand.nextInt(FakeOres.instance.fakeOres_prob) == 0)
	  		  {
	  			  event.getWorld().spawnEntity(fakeQuartz);
	  		  }
	  	  }
	  	  
	  	  if (event.getState().getBlock() == Blocks.REDSTONE_ORE)
	  	  {
	  		  EntityRedstoneOre fakeRed = new EntityRedstoneOre(event.getWorld());
	  		  fakeRed.setPositionAndRotation(event.getPos().getX() + 0.5D, event.getPos().getY(), event.getPos().getZ() + 0.5D, 0.0F, 0.0F);
	  		  if(!event.getWorld().isRemote && rand.nextInt(FakeOres.instance.fakeOres_prob) == 0)
	  		  {
	  			  event.getWorld().spawnEntity(fakeRed);
	  		  }
	  	  }
    }
}
