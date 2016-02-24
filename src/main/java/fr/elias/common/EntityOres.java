package fr.elias.common;

import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityOres extends EntityMob {

	public EntityOres(World worldIn) {
		super(worldIn);
	}
	
	public void onDeath(DamageSource damagesource)
	{
		EntityPlayer player = (EntityPlayer) damagesource.getEntity();
		if(player != null)
		{
			if(player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == FakeOres.antiOresBlade)
			{
				player.triggerAchievement(FakeOres.killFakeOreWithAntiOreBlade);
			}
		}
		super.onDeath(damagesource);
	}
	
}
