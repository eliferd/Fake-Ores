package fr.elias.common;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityBossTeleporter extends EntityThrowable
{
	   public EntityBossTeleporter(World par1World)
	    {
	        super(par1World);
	    }

	    public EntityBossTeleporter(World par1World, EntityLivingBase par2EntityLivingBase)
	    {
	        super(par1World, par2EntityLivingBase);
	    }
	    @SideOnly(Side.CLIENT)
	    public EntityBossTeleporter(World par1World, double par2, double par4, double par6)
	    {
	        super(par1World, par2, par4, par6);
	    }

	    /**
	     * Called when this EntityThrowable hits a block or entity.
	     */
	    protected void onImpact(MovingObjectPosition par1MovingObjectPosition)
	    {
	        if (par1MovingObjectPosition.entityHit != null)
	        {
	            par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 0.0F);
	        }

	        for (int i = 0; i < 32; ++i)
	        {
	            this.worldObj.spawnParticle(EnumParticleTypes.SMOKE_LARGE, this.posX, this.posY + this.rand.nextDouble() * 2.0D, this.posZ, this.rand.nextGaussian(), 0.0D, this.rand.nextGaussian());
	        }

	        if (!this.worldObj.isRemote)
	        {
	            if (this.getThrower() != null && this.getThrower() instanceof EntityOresBoss)
	            {
	                EntityOresBoss boss = (EntityOresBoss)this.getThrower();

	                if (boss.worldObj == this.worldObj)
	                {
	                    if (this.getThrower().isRiding())
	                    {
	                        this.getThrower().mountEntity((Entity)null);
	                    }
	                    if(this.getThrower().getHealth() < 100)
	                    {
	                    	EntityOresBoss newBoss = new EntityOresBoss(worldObj);
	                    	newBoss.setPositionAndRotation(this.posX, this.posY, this.posZ, 0.0F, 0.0F);
	                    	this.worldObj.spawnEntityInWorld(newBoss);
	                    	this.getThrower().setDead();
	                    }
	                    this.getThrower().setPositionAndUpdate(this.posX, this.posY, this.posZ);
	                    this.getThrower().fallDistance = 0.0F;
	                    this.getThrower().attackEntityFrom(DamageSource.generic, 5.0F);
	                }
	            }

	            this.setDead();
	        }
	    }
	}
