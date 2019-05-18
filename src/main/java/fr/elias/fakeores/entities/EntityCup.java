package fr.elias.fakeores.entities;

import fr.elias.fakeores.common.FakeOresEvents;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

public class EntityCup extends EntityCreature {

	public EntityCup(EntityType<?> type, World p_i48553_2_) {
		super(type, p_i48553_2_);
	}
	
	public EntityCup(World worldIn)
	{
		this(FakeOresEvents.CUP, worldIn);
		setSize(0.7F, 0.8F);
	}

	public void registerAttributes()
	{
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.0D);
	}
	public void livingTick()
	{
		this.rotationYaw = this.rotationYawHead = 0.0F;
        this.motionX *= 0.0d;
        this.motionY *= 0.0d;
        this.motionZ *= 0.0d;
		super.livingTick();
	}
	public boolean isMovementBlocked()
	{
		return true;
	}
	public boolean attackEntityFrom(DamageSource damagesource, float f)
	{
		if(damagesource.getTrueSource() instanceof EntityPlayer)
		{
			if(!world.isRemote)
			{
				this.entityDropItem(new ItemStack(Items.APPLE, rand.nextInt(9)));
				this.entityDropItem(new ItemStack(Items.GOLD_INGOT, rand.nextInt(9)));
				this.entityDropItem(new ItemStack(Items.DIAMOND, rand.nextInt(9)));
				this.entityDropItem(new ItemStack(Items.EMERALD, rand.nextInt(9)));
				this.entityDropItem(new ItemStack(Items.IRON_INGOT, rand.nextInt(9)));
				this.entityDropItem(new ItemStack(Items.COAL, rand.nextInt(9)));
				this.entityDropItem(new ItemStack(Items.QUARTZ, rand.nextInt(9)));
			}
			this.spawnExplosionParticle();
			this.remove();
			this.world.playSound(posX, posY, posZ, SoundEvents.BLOCK_ANVIL_PLACE, SoundCategory.BLOCKS, 1.0F, 1.0F, false);
			return true;
		}else{
			return false;
		}
	}
	public AxisAlignedBB getCollisionBox(Entity p_70114_1_) {
		return p_70114_1_.getBoundingBox();
	}

	public AxisAlignedBB getCollisionBoundingBox() {
		return this.getBoundingBox();
	}
	
    public boolean canBeCollidedWith()
    {
        return !this.dead;
    }
    public boolean canBePushed()
    {
    	return true;
    }
}