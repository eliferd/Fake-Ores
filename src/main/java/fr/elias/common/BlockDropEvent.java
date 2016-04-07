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
	  	  if (event.getState().getBlock() == Blocks.diamond_ore)
	  	  {
	  		  EntityDiamondOre fakeDiamond = new EntityDiamondOre(event.getWorld());
	  		  fakeDiamond.setPositionAndRotation(event.getPos().getX() + 0.5D, event.getPos().getY(), event.getPos().getZ() + 0.5D, 0.0F, 0.0F);
	  		  if(!event.getWorld().isRemote && rand.nextInt(FakeOres.instance.fakeOres_prob) == 0)
	  		  {
	  			  event.getWorld().spawnEntityInWorld(fakeDiamond);
	  		  }
	  	  }
	  	  
	  	  if (event.getState().getBlock() == Blocks.coal_ore)
	  	  {
	  		  EntityCoalOre fakeCoal = new EntityCoalOre(event.getWorld());
	  		fakeCoal.setPositionAndRotation(event.getPos().getX() + 0.5D, event.getPos().getY(), event.getPos().getZ() + 0.5D, 0.0F, 0.0F);
	  		  if(!event.getWorld().isRemote && rand.nextInt(FakeOres.instance.fakeOres_prob) == 0)
	  		  {
	  			  event.getWorld().spawnEntityInWorld(fakeCoal);
	  		  }
	  	  }

	  	  if (event.getState().getBlock() == Blocks.emerald_ore)
	  	  {
	  		  EntityEmeraldOre fakeEmerald = new EntityEmeraldOre(event.getWorld());
	  		  fakeEmerald.setPositionAndRotation(event.getPos().getX() + 0.5D, event.getPos().getY(), event.getPos().getZ() + 0.5D, 0.0F, 0.0F);
	  		  if(!event.getWorld().isRemote && rand.nextInt(FakeOres.instance.fakeOres_prob) == 0)
	  		  {
	  			  event.getWorld().spawnEntityInWorld(fakeEmerald);
	  		  }
	  	  }
	  	  
	  	  if (event.getState().getBlock() == Blocks.gold_ore)
	  	  {
	  		  EntityGoldOre fakeGold = new EntityGoldOre(event.getWorld());
	  		  fakeGold.setPositionAndRotation(event.getPos().getX() + 0.5D, event.getPos().getY(), event.getPos().getZ() + 0.5D, 0.0F, 0.0F);
	  		  if(!event.getWorld().isRemote && rand.nextInt(FakeOres.instance.fakeOres_prob) == 0)
	  		  {
	  			  event.getWorld().spawnEntityInWorld(fakeGold);
	  		  }
	  	  }
	  	  
	  	  if (event.getState().getBlock() == Blocks.iron_ore)
	  	  {
	  		  EntityIronOre fakeIron = new EntityIronOre(event.getWorld());
	  		  fakeIron.setPositionAndRotation(event.getPos().getX() + 0.5D, event.getPos().getY(), event.getPos().getZ() + 0.5D, 0.0F, 0.0F);
	  		  if(!event.getWorld().isRemote && rand.nextInt(FakeOres.instance.fakeOres_prob) == 0)
	  		  {
	  			  event.getWorld().spawnEntityInWorld(fakeIron);
	  		  }
	  	  }
	  	  
	  	  if (event.getState().getBlock() == Blocks.lapis_ore)
	  	  {
	  		  EntityLapisOre fakeLapis = new EntityLapisOre(event.getWorld());
	  		fakeLapis.setPositionAndRotation(event.getPos().getX() + 0.5D, event.getPos().getY(), event.getPos().getZ() + 0.5D, 0.0F, 0.0F);
	  		  if(!event.getWorld().isRemote && rand.nextInt(FakeOres.instance.fakeOres_prob) == 0)
	  		  {
	  			  event.getWorld().spawnEntityInWorld(fakeLapis);
	  		  }
	  	  }
	  	  
	  	  if (event.getState().getBlock() == Blocks.quartz_ore)
	  	  {
	  		  EntityNetherQuartzOre fakeQuartz = new EntityNetherQuartzOre(event.getWorld());
	  		  fakeQuartz.setPositionAndRotation(event.getPos().getX() + 0.5D, event.getPos().getY(), event.getPos().getZ() + 0.5D, 0.0F, 0.0F);
	  		  if(!event.getWorld().isRemote && rand.nextInt(FakeOres.instance.fakeOres_prob) == 0)
	  		  {
	  			  event.getWorld().spawnEntityInWorld(fakeQuartz);
	  		  }
	  	  }
	  	  
	  	  if (event.getState().getBlock() == Blocks.redstone_ore)
	  	  {
	  		  EntityRedstoneOre fakeRed = new EntityRedstoneOre(event.getWorld());
	  		  fakeRed.setPositionAndRotation(event.getPos().getX() + 0.5D, event.getPos().getY(), event.getPos().getZ() + 0.5D, 0.0F, 0.0F);
	  		  if(!event.getWorld().isRemote && rand.nextInt(FakeOres.instance.fakeOres_prob) == 0)
	  		  {
	  			  event.getWorld().spawnEntityInWorld(fakeRed);
	  		  }
	  	  }
    }
}
