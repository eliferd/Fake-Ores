package fr.elias.common;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BlockDropEvent
{
    public Random rand = new Random();

    @SubscribeEvent
    public void onBlockDestroyed(HarvestDropsEvent event)
    {
  	  if (event.state == Blocks.diamond_ore.getDefaultState())
  	  {
  		  EntityDiamondOre fakeDiamond = new EntityDiamondOre(event.world);
  		  fakeDiamond.setPositionAndRotation(event.pos.getX(), event.pos.getY(), event.pos.getZ(), 0.0F, 0.0F);
  		  if(!event.world.isRemote)
  		  {
  			  event.world.spawnEntityInWorld(fakeDiamond);
  		  }
  	  }
    }
}
