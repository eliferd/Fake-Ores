package fr.elias.common;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemTotem extends Item
{
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected)
    {
    	super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
    	if(isSelected)
    	{
        	List list = worldIn.getEntitiesWithinAABB(EntityOres.class, new AxisAlignedBB(new BlockPos(entityIn.posX, entityIn.posY, entityIn.posZ), new BlockPos(entityIn.posX + 1, entityIn.posY + 1, entityIn.posZ + 1)).grow(4, 4, 4));
        	for(int i = 0; i < list.size(); i++)
        	{
        		Entity entity = (Entity) list.get(i);
        		if(!list.isEmpty())
        		{
        			double d1 = entity.posX - entityIn.posX,
         				   d2 = entity.posY - entityIn.posY,
         				   d3 = entity.posZ - entityIn.posZ;
         			entity.motionX = d1;
         			entity.motionY = d2;
         			entity.motionZ = d3;
        		}
        	}
    	}
    }
}
