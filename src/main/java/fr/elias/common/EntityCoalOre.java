package fr.elias.common;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

public class EntityCoalOre  extends EntityOres
{
	public EntityCoalOre(World worldIn)
	{
		super(worldIn);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIAttackMelee(this, 1.0D, false));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, new Class[0]));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
        setSize(1F, 1F);
	}
	
	public void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2D);
	}
    protected SoundEvent getHurtSound()
    {
        return SoundEvents.block_stone_hit;
    }
    protected SoundEvent getDeathSound()
    {
        return SoundEvents.block_stone_break;
    }
    /**
     * Returns a boundingBox used to collide the entity with other entities and blocks. This enables the entity to be
     * pushable on contact, like boats or minecarts.
     */
    public AxisAlignedBB getCollisionBox(Entity p_70114_1_)
    {
        return p_70114_1_.getEntityBoundingBox();
    }

    /**
     * returns the bounding box for this entity
     */
    public AxisAlignedBB getBoundingBox()
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
	public boolean attackEntityFrom(DamageSource damagesource, float f)
	{
		Entity entity = damagesource.getEntity();
		if(entity != null)
		{
			if(entity instanceof EntityPlayer)
			{
				ItemStack stack = ((EntityPlayer) entity).inventory.getCurrentItem();
				if(stack != null)
				{
					if(stack.getItem() == FakeOres.antiOresBlade)
					{
						f = Float.MAX_VALUE;
					}
					if(stack.getItem() instanceof ItemPickaxe)
					{
						f = (f * 5);
					}
				}
			}
		}
		if(damagesource.isFireDamage())
		{
			return false;
		}
		if(damagesource.isExplosion())
		{
			f = Float.MAX_VALUE;
			return true;
		}
		return super.attackEntityFrom(damagesource, f);
	}
	public void onDeath(DamageSource cause)
	{
		super.onDeath(cause);
		if(!worldObj.isRemote)
		{
			this.dropItem(Items.coal, rand.nextInt(2));
			if(rand.nextInt(25) == 0)
			{
				this.dropItem(FakeOres.boss_fragment_1, 1);
			}
			if(rand.nextInt(30) == 0)
			{
				this.dropItem(FakeOres.boss_fragment_2, 1);
			}
			if(rand.nextInt(35) == 0)
			{
				this.dropItem(FakeOres.boss_fragment_3, 1);
			}
			if(rand.nextInt(40) == 0)
			{
				this.dropItem(FakeOres.boss_fragment_4, 1);
			}
		}
	}
}