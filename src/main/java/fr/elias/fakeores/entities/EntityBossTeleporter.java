package fr.elias.fakeores.entities;

import fr.elias.fakeores.common.FakeOresEvents;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Particles;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityBossTeleporter extends EntityThrowable {

   public EntityBossTeleporter(World worldIn) {
	      super(FakeOresEvents.BOSS_TELEPORTER, worldIn);
   }

   public EntityBossTeleporter(World worldIn, EntityLivingBase throwerIn) {
      super(FakeOresEvents.BOSS_TELEPORTER, throwerIn, worldIn);
   }

   public EntityBossTeleporter(World worldIn, double x, double y, double z) {
      super(FakeOresEvents.BOSS_TELEPORTER, x, y, z, worldIn);
   }

	@Override
	protected void onImpact(RayTraceResult result) {
        if (result.entity != null)
        {
        	result.entity.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 0.0F);
        }
        for (int i = 0; i < 32; ++i)
        {
            this.world.spawnParticle(Particles.SMOKE, this.posX, this.posY + this.rand.nextDouble() * 2.0D, this.posZ, this.rand.nextGaussian(), 0.0D, this.rand.nextGaussian());
        }
        if (!this.world.isRemote)
        {
            if (this.getThrower() != null && this.getThrower() instanceof EntityOresBoss)
            {
                EntityOresBoss boss = (EntityOresBoss)this.getThrower();

                if (boss.world == this.world)
                {
                    if(this.getThrower().getHealth() < 100 && rand.nextInt(10) == 0)
                    {
                    	EntityOresBoss newBoss = new EntityOresBoss(world);
                    	newBoss.setPositionAndRotation(this.posX, this.posY, this.posZ, 0.0F, 0.0F);
                    	this.world.spawnEntity(newBoss);
                    	this.getThrower().remove();
                    }
                    this.getThrower().setPositionAndUpdate(this.posX, this.posY, this.posZ);
                    this.getThrower().fallDistance = 0.0F;
                    this.getThrower().attackEntityFrom(DamageSource.GENERIC, 5.0F);
                }
            }

            this.remove();
        }
	}

}
