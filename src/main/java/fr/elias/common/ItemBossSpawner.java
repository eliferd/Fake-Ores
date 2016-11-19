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
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack par1ItemStack)
    {
        return true;
    }
    
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos blockpos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
    	ItemStack itemstack = player.getHeldItem(hand);
    	EntityOresBoss entity = new EntityOresBoss(world);
        entity.setLocationAndAngles((double)blockpos.getX() + 0.5D, (double)blockpos.getY() + 2.5D, (double)blockpos.getZ() + 0.5D, MathHelper.wrapDegrees(world.rand.nextFloat() * 360.0F), 0.0F);
        if(!world.isRemote)
        {
        	world.spawnEntityInWorld(entity);
        }
            if (!player.capabilities.isCreativeMode)
            {
            	itemstack.func_190918_g(1);
            }
        return EnumActionResult.SUCCESS;
    }
    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack par1ItemStack)
    {
        return EnumRarity.EPIC;
    }
}
