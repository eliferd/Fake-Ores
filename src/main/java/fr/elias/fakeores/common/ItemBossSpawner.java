package fr.elias.fakeores.common;

import fr.elias.fakeores.entities.EntityOresBoss;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemBossSpawner extends Item{

    public ItemBossSpawner(Properties properties) {
		super(properties);
	}
 
    public EnumActionResult onItemUse(ItemUseContext itUseCxt)
    {
    	ItemStack itemstack = itUseCxt.getPlayer().getHeldItem(EnumHand.MAIN_HAND);
    	EntityOresBoss entity = new EntityOresBoss(itUseCxt.getWorld());
        entity.setLocationAndAngles((double)itUseCxt.getPos().getX() + 0.5D, (double)itUseCxt.getPos().getY() + 2.5D, (double)itUseCxt.getPos().getZ() + 0.5D, MathHelper.wrapDegrees(itUseCxt.getWorld().rand.nextFloat() * 360.0F), 0.0F);
        if(!itUseCxt.getWorld().isRemote)
        {
        	itUseCxt.getWorld().spawnEntity(entity);
        }
        if (!itUseCxt.getPlayer().abilities.isCreativeMode)
        {
        	itemstack.shrink(1);
        }
        return EnumActionResult.SUCCESS;
    }

    @OnlyIn(Dist.CLIENT)
    public boolean hasEffect(ItemStack par1ItemStack)
    {
        return true;
    }
    
    public EnumRarity getRarity(ItemStack par1ItemStack)
    {
        return EnumRarity.EPIC;
    }
}
