package fr.elias.common;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityOresBoss extends EntityMob implements IBossDisplayData{

	public int phase;
	
	public EntityOresBoss(World worldIn)
	{
		super(worldIn);
		phase = 1;
        this.isImmuneToFire = true;
        this.experienceValue = 4750;
        setSize(3F, 5F);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(4, new EntityOresBoss.AIAttackPhase());
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 0.5D));
        this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, new Class[0]));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
    }
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(800D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(18D);
    }
    
    public void onLivingUpdate()
    {
    	if(phase == 1)
    	{
    		if(this.getHealth() < 500)
    		{
    			phase = 2;
    		}
    	}
    	if(phase == 2)
    	{
    		if(this.getHealth() < 200)
    		{
    			phase = 3;
    		}
    		teleport(1520);
    	}
    	if(phase == 3)
    	{
    		teleport(775);
    	}
    	super.onLivingUpdate();
    }
    
    public void attackEntityWithRangedAttack(EntityLivingBase par1EntityLivingBase, float par2)
    {
        EntitySnowball entitysnowball = new EntitySnowball(this.worldObj, this);
        EntityArrow entityarrow = new EntityArrow(this.worldObj, this, par2);
        double d0 = par1EntityLivingBase.posX - this.posX;
        double d1 = par1EntityLivingBase.posY + (double)par1EntityLivingBase.getEyeHeight() - 1.100000023841858D - entitysnowball.posY;
        double d2 = par1EntityLivingBase.posZ - this.posZ;
        float f1 = MathHelper.sqrt_double(d0 * d0 + d2 * d2) * 0.2F;
        entitysnowball.setThrowableHeading(d0, d1 + (double)f1, d2, 1.6F, 12.0F);
        entityarrow.setThrowableHeading(d0, d1 + (double)f1, d2, 1.6F, 12.0F);
        this.playSound("random.bow", 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
        this.worldObj.spawnEntityInWorld(entityarrow);
        this.worldObj.spawnEntityInWorld(entitysnowball);
    }
    
    public void attackEntity(Entity entity, float f)
    {
    	if(phase == 1)
    	{
            double d0 = entity.posX - this.posX;
            double d1 = entity.getEntityBoundingBox().minY + (double)(entity.height / 2.0F) - (this.posY + (double)(this.height / 2.0F));
            double d2 = entity.posZ - this.posZ;
            if(rand.nextInt(34) == 0)
            {
                float f1 = MathHelper.sqrt_float(f) * 0.5F;
                this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1009, new BlockPos((int)this.posX, (int)this.posY, (int)this.posZ), 0);

                for (int i = 0; i < 1; ++i)
                {
                    EntityLargeFireball entitysmallfireball = new EntityLargeFireball(this.worldObj, this, d0 + this.rand.nextGaussian() * (double)f1, d1, d2 + this.rand.nextGaussian() * (double)f1);
                    entitysmallfireball.posY = this.posY + (double)(this.height / 2.0F) + 0.5D;
                    this.worldObj.spawnEntityInWorld(entitysmallfireball);
                }
            }
    	}
    	if(phase == 2)
    	{
    		if(rand.nextInt(50) == 0)
    		{
        		attackEntityWithRangedAttack((EntityLivingBase)entity, f);
    		}
    		if(rand.nextInt(220) == 0)
    		{
    			this.spawnSomeSbires("all", posX + rand.nextInt(5), posY + 3, posZ + rand.nextInt(5));
    		}
    	}
    	if(phase == 3)
    	{
    		if(rand.nextInt(100) == 0)
    		{
        		worldObj.addWeatherEffect(new EntityLightningBolt(worldObj, rand.nextInt(2) == 0 ? posX : entity.posX, rand.nextInt(2) == 0 ? posY : entity.posY, rand.nextInt(2) == 0 ? posZ : entity.posZ));
    		}
    		if(rand.nextInt(8) == 0)
    		{
        		attackEntityWithRangedAttack((EntityLivingBase)entity, f);
    		}
    	}
    }
    
    public class AIAttackPhase extends EntityAIBase {

    	public EntityOresBoss boss = EntityOresBoss.this;
    	public int attackTime;
    	public AIAttackPhase() {}
    	
		@Override
		public boolean shouldExecute() {
            EntityLivingBase entitylivingbase = this.boss.getAttackTarget();
            return entitylivingbase != null && entitylivingbase.isEntityAlive();
		}
        public void updateTask()
        {
        	--attackTime;
            EntityLivingBase entitylivingbase = this.boss.getAttackTarget();
            double d0 = this.boss.getDistanceSqToEntity(entitylivingbase);

            if (d0 < 4.0D)
            {
                if (this.attackTime <= 0)
                {
                    this.attackTime = 20;
                    this.boss.attackEntityAsMob(entitylivingbase);
                }
                
                this.boss.getMoveHelper().setMoveTo(entitylivingbase.posX, entitylivingbase.posY, entitylivingbase.posZ, 1.0D);
            }
            else if (d0 < 256.0D)
            {
                // ATTACK ENTITY GOES HERE
                boss.attackEntity(entitylivingbase, (float)d0);
                this.boss.getLookHelper().setLookPositionWithEntity(entitylivingbase, 10.0F, 10.0F);
            }
            else
            {
                this.boss.getNavigator().clearPathEntity();
                this.boss.getMoveHelper().setMoveTo(entitylivingbase.posX, entitylivingbase.posY, entitylivingbase.posZ, 0.5D);
            }
        }
    }
    public void spawnSomeSbires(String entityToSpawn, double x, double y, double z)
    {
		EntityDiamondOre diamondOre = new EntityDiamondOre(worldObj);
		EntityEmeraldOre emeraldOre = new EntityEmeraldOre(worldObj);
		EntityGoldOre goldOre = new EntityGoldOre(worldObj);
		EntityIronOre ironOre = new EntityIronOre(worldObj);
		EntityCoalOre coalOre = new EntityCoalOre(worldObj);
		EntityRedstoneOre redstoneOre = new EntityRedstoneOre(worldObj);
		EntityNetherQuartzOre quartzOre = new EntityNetherQuartzOre(worldObj);
		EntityLapisOre lapisOre = new EntityLapisOre(worldObj);
		
		diamondOre.setPosition(x, y, z);
		emeraldOre.setPosition(x, y, z);
		goldOre.setPosition(x, y, z);
		ironOre.setPosition(x, y, z);
		coalOre.setPosition(x, y, z);
		redstoneOre.setPosition(x, y, z);
		quartzOre.setPosition(x, y, z);
		lapisOre.setPosition(x, y, z);
    	if(entityToSpawn.equals("diamond"))
    	{
    		worldObj.spawnEntityInWorld(diamondOre);
    	}
    	if(entityToSpawn.equals("emerald"))
    	{
    		worldObj.spawnEntityInWorld(emeraldOre);
    	}
    	if(entityToSpawn.equals("gold"))
    	{
    		worldObj.spawnEntityInWorld(goldOre);
    	}
    	if(entityToSpawn.equals("iron"))
    	{
    		worldObj.spawnEntityInWorld(ironOre);
    	}
    	if(entityToSpawn.equals("coal"))
    	{
    		worldObj.spawnEntityInWorld(coalOre);
    	}
    	if(entityToSpawn.equals("redstone"))
    	{
    		worldObj.spawnEntityInWorld(redstoneOre);
    	}
    	if(entityToSpawn.equals("quartz"))
    	{
    		worldObj.spawnEntityInWorld(quartzOre);
    	}
    	if(entityToSpawn.equals("lapis"))
    	{
    		worldObj.spawnEntityInWorld(lapisOre);
    	}
    	if(entityToSpawn.equals("all"))
    	{
    		worldObj.spawnEntityInWorld(diamondOre);
    		worldObj.spawnEntityInWorld(emeraldOre);
    		worldObj.spawnEntityInWorld(goldOre);
    		worldObj.spawnEntityInWorld(ironOre);
    		worldObj.spawnEntityInWorld(coalOre);
    		worldObj.spawnEntityInWorld(redstoneOre);
    		worldObj.spawnEntityInWorld(quartzOre);
    		worldObj.spawnEntityInWorld(lapisOre);
    	}
    }
    
    public void teleport(int cooldownBeforeTeleport)
    {
		if(rand.nextInt(cooldownBeforeTeleport) == 0)
		{
			worldObj.spawnEntityInWorld(new EntityBossTeleporter(worldObj, this));
		}
    }
    
    public boolean attackEntityFrom(DamageSource damagesource, float f)
    {
    	Entity entity = damagesource.getEntity();
    	if(entity != null && entity instanceof EntityPlayer)
    	{
    		ItemStack itemstack = ((EntityPlayer)entity).inventory.getCurrentItem();
    		if(itemstack != null)
    		{
    			if(itemstack.getItem() == FakeOres.antiOresBlade)
    			{
    				f = 35 + rand.nextFloat();
    			}
    		}
        	if(entity instanceof EntityLightningBolt)
        	{
        		f = 0f;
        	}
        	
        	if(entity instanceof EntityLargeFireball)
        	{
        		f = 75f;
        	}
        	if(this.phase == 2)
        	{
        		f = 50f;
        	}
    	}
    	return super.attackEntityFrom(damagesource, f);
    }
    public void onDeath(DamageSource sourceOfDamage)
    {
    	EntityCup cup = new EntityCup(worldObj);
    	cup.setPosition(posX, posY, posZ);
    	if(!worldObj.isRemote)
    	{
    		worldObj.spawnEntityInWorld(cup);
    	}
		((EntityPlayer)sourceOfDamage.getEntity()).triggerAchievement(FakeOres.boss_defeated);
    }
    public int getPhase()
    {
    	return phase;
    }
}
