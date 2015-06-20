package fr.elias.common;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityCoalOre  extends EntityMob 
{
	public EntityCoalOre(World worldIn)
	{
		super(worldIn);
        ((PathNavigateGround)this.getNavigator()).func_179688_b(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
        this.tasks.addTask(2, this.field_175455_a);
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
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(3D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.2D);
	}
    protected String getHurtSound()
    {
        return "dig.stone";
    }
    protected String getDeathSound()
    {
        return "dig.stone";
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
    public void onUpdate()
    {
    	super.onUpdate();
        if (!this.worldObj.isRemote)
        {
            List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, getEntityBoundingBox().expand(16D, 16D, 16D));

            if (list != null && !list.isEmpty())
            {
                for (int k1 = 0; k1 < list.size(); ++k1)
                {
                    Entity entity = (Entity)list.get(k1);

                    if (entity.canBePushed() && entity instanceof EntityCreeper)
                    {
                        entity.applyEntityCollision(this);
                    }
                }
            }
        }
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
			this.dropItem(Item.getItemFromBlock(Blocks.coal_ore), rand.nextInt(2));
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