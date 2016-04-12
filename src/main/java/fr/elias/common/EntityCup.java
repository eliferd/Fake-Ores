package fr.elias.common;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

public class EntityCup extends EntityCreature {

	public EntityCup(World worldIn)
	{
		super(worldIn);
		setSize(0.7F, 0.8F);
	}

	public void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.0D);
	}
	public void onLivingUpdate()
	{
		this.rotationYaw = this.rotationYawHead = 0.0F;
        this.motionX *= 0.0d;
        this.motionY *= 0.0d;
        this.motionZ *= 0.0d;
		super.onLivingUpdate();
	}
	public boolean isMovementBlocked()
	{
		return true;
	}
	public boolean attackEntityFrom(DamageSource damagesource, float f)
	{
		if(damagesource.getEntity() instanceof EntityPlayer)
		{
			((EntityPlayer)damagesource.getEntity()).addStat(FakeOres.broken_Cup);
			if(!worldObj.isRemote)
			{
				this.dropItem(Items.apple, rand.nextInt(9));
				this.dropItem(Items.gold_ingot, rand.nextInt(9));
				this.dropItem(Items.diamond, rand.nextInt(9));
				this.dropItem(Items.emerald, rand.nextInt(9));
				this.dropItem(Items.iron_ingot, rand.nextInt(9));
				this.dropItem(Items.coal, rand.nextInt(9));
				this.dropItem(Items.quartz, rand.nextInt(9));
			}
			this.spawnExplosionParticle();
			this.setDead();
			this.worldObj.playSound(posX, posY, posZ, SoundEvents.block_anvil_place, SoundCategory.BLOCKS, 1.0F, 1.0F, false);
			return true;
		}else{
			return false;
		}
	}
    public AxisAlignedBB getCollisionBox(Entity p_70114_1_)
    {
        return p_70114_1_.getEntityBoundingBox();
    }

    public AxisAlignedBB getCollisionBoundingBox()
    {
        return this.getEntityBoundingBox();
    }
    public boolean canBeCollidedWith()
    {
        return !this.isDead;
    }
    public boolean canBePushed()
    {
    	return true;
    }
}
