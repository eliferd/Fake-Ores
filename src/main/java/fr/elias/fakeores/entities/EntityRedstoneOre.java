package fr.elias.fakeores.entities;

import fr.elias.fakeores.common.FakeOresEvents;
import fr.elias.fakeores.common.FakeOresItems;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
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
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityRedstoneOre extends EntityOres {

	public EntityRedstoneOre(EntityType<?> type, World world) {
		super(type, world);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackMelee(this, 1.0D, false));
		this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
		this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(8, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, new Class[0]));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget<>(this, EntityPlayer.class, true));
		setSize(1F, 1F);
	}
	
	public EntityRedstoneOre(World world) {
		this(FakeOresEvents.FAKE_REDSTONE, world);
	}
	
	public void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20D);
		this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
	}
	
	protected SoundEvent getHurtSound(DamageSource dmg) {
		return SoundEvents.BLOCK_STONE_HIT;
	}

	protected SoundEvent getDeathSound() {
		return SoundEvents.BLOCK_STONE_BREAK;
	}

    protected SoundEvent getStepSound() {
	    return SoundEvents.BLOCK_STONE_PLACE;
	}
    
    protected void playStepSound(BlockPos pos, IBlockState blockIn) {
        this.playSound(this.getStepSound(), 0.15F, 1.0F);
    }
    
	public AxisAlignedBB getCollisionBox(Entity p_70114_1_) {
		return p_70114_1_.getBoundingBox();
	}

	public AxisAlignedBB getCollisionBoundingBox() {
		return this.getBoundingBox();
	}

	public boolean canBeCollidedWith() {
		return !this.dead;
	}

	public boolean canBePushed() {
		return true;
	}
	
	public boolean attackEntityFrom(DamageSource damagesource, float f) {
		Entity entity = damagesource.getTrueSource();
		if (entity != null) {
			if (entity instanceof EntityPlayer) {
				ItemStack stack = ((EntityPlayer) entity).inventory.getCurrentItem();
				if (stack != null) {
					if (stack.getItem() == FakeOresItems.ANTI_ORES_BLADE) {
						f = Float.MAX_VALUE;
					}
					if (stack.getItem() instanceof ItemPickaxe) {
						f = (f * 5);
					}
				}
			}
		}
		if (damagesource.isFireDamage()) {
			return false;
		}
		if (damagesource.isExplosion()) {
			f = Float.MAX_VALUE;
			return true;
		}
		return super.attackEntityFrom(damagesource, f);
	}

	public void onDeath(DamageSource cause) {
		super.onDeath(cause);
		if (!world.isRemote) {
			this.entityDropItem(new ItemStack(Items.REDSTONE, 4 + rand.nextInt(5)));
			if (rand.nextInt(25) == 0) {
				this.entityDropItem(new ItemStack(FakeOresItems.BOSS_FRAGMENT_1, 1));
			}
			if (rand.nextInt(30) == 0) {
				this.entityDropItem(new ItemStack(FakeOresItems.BOSS_FRAGMENT_2, 1));
			}
			if (rand.nextInt(35) == 0) {
				this.entityDropItem(new ItemStack(FakeOresItems.BOSS_FRAGMENT_3, 1));
			}
			if (rand.nextInt(40) == 0) {
				this.entityDropItem(new ItemStack(FakeOresItems.BOSS_FRAGMENT_4, 1));
			}
		}
	}
    
}
