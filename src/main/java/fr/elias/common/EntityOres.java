package fr.elias.common;

import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityOres extends EntityMob {

	public EntityOres(World worldIn) {
		super(worldIn);
	}
	
	// Put this on comment until i find a way to reimplement achievements.
	/*public void onDeath(DamageSource damagesource)
	{
		Entity entity = damagesource.getTrueSource();
		if(entity != null)
		{
			if(entity instanceof EntityPlayer)
			{
				if(((EntityPlayer)entity).inventory.getCurrentItem() != null && ((EntityPlayer)entity).inventory.getCurrentItem().getItem() == FakeOres.antiOresBlade)
				{
					//player.addStat(FakeOres.killFakeOreWithAntiOreBlade);
				}
			}
		}
		super.onDeath(damagesource);
	}*/
	
	public void fall(float distance, float damageMultiplier){}
	
}
