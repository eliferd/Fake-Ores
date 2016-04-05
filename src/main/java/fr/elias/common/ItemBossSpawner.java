package fr.elias.common;

import java.util.List;

import net.minecraft.block.BlockLiquid;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
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
    
    /*public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand)
    {
        if (worldIn.isRemote)
        {
            return new ActionResult(EnumActionResult.PASS, itemStackIn);
        }
        else
        {
        	RayTraceResult result = this.getMovingObjectPositionFromPlayer(worldIn, playerIn, true);

            if (result == null)
            {
                return new ActionResult(EnumActionResult.PASS, itemStackIn);
            }
            else
            {
                if (result.typeOfHit == RayTraceResult.Type.BLOCK)
                {
                    BlockPos blockpos = result.getBlockPos();

                    if (!worldIn.isBlockModifiable(playerIn, blockpos))
                    {
                        return new ActionResult(EnumActionResult.PASS, itemStackIn);
                    }

                    if (!playerIn.canPlayerEdit(blockpos, result.sideHit, itemStackIn))
                    {
                        return new ActionResult(EnumActionResult.PASS, itemStackIn);
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

                return new ActionResult(EnumActionResult.PASS, itemStackIn);
            }
        }
    }*/
    public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos blockpos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
    	EntityOresBoss entity = new EntityOresBoss(worldIn);
        entity.setLocationAndAngles((double)blockpos.getX() + 0.5D, (double)blockpos.getY() + 0.5D, (double)blockpos.getZ() + 0.5D, MathHelper.wrapAngleTo180_float(worldIn.rand.nextFloat() * 360.0F), 0.0F);
        if(!worldIn.isRemote)
        {
        	worldIn.spawnEntityInWorld(entity);
        }
            if (!playerIn.capabilities.isCreativeMode)
            {
                --stack.stackSize;
            }
        return EnumActionResult.SUCCESS;
    }
    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack par1ItemStack)
    {
        return EnumRarity.EPIC;
    }
}
