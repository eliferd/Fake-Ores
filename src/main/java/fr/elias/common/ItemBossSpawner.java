package fr.elias.common;

import java.util.List;

import net.minecraft.block.BlockLiquid;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBossSpawner extends Item {

	public ItemBossSpawner() {
		super();
	}
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) 
    {
    	par3List.add("MAKE SURE YOU'RE IN A SAFE AREA TO SPAWN ORE BOSS !");
    	super.addInformation(par1ItemStack, par2EntityPlayer, par3List, par4);
    }
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack par1ItemStack)
    {
        return true;
    }
    
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
    {
        if (worldIn.isRemote)
        {
            return itemStackIn;
        }
        else
        {
            MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(worldIn, playerIn, true);

            if (movingobjectposition == null)
            {
                return itemStackIn;
            }
            else
            {
                if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK)
                {
                    BlockPos blockpos = movingobjectposition.getBlockPos();

                    if (!worldIn.isBlockModifiable(playerIn, blockpos))
                    {
                        return itemStackIn;
                    }

                    if (!playerIn.canPlayerEdit(blockpos, movingobjectposition.sideHit, itemStackIn))
                    {
                        return itemStackIn;
                    }

                    if (!(worldIn.getBlockState(blockpos).getBlock() instanceof BlockLiquid))
                    {
                        EntityOresBoss entity = new EntityOresBoss(worldIn);
                        entity.setLocationAndAngles((double)blockpos.getX() + 0.5D, (double)blockpos.getY() + 0.5D, (double)blockpos.getZ() + 0.5D, MathHelper.wrapAngleTo180_float(worldIn.rand.nextFloat() * 360.0F), 0.0F);
                        if(!worldIn.isRemote)
                        {
                        	worldIn.spawnEntityInWorld(entity);
                        }
                        if (entity != null)
                        {
                            if (!playerIn.capabilities.isCreativeMode)
                            {
                                --itemStackIn.stackSize;
                            }

                        }
                    }
                }

                return itemStackIn;
            }
        }
    }
    
    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack par1ItemStack)
    {
        return EnumRarity.EPIC;
    }
}
