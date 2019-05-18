package fr.elias.fakeores.common;

import java.util.List;

import fr.elias.fakeores.entities.EntityOres;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemTotem extends Item {

	public ItemTotem(Properties properties) {
		super(properties);
		// TODO Auto-generated constructor stub
	}

    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected)
    {
    	super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
    	if(isSelected)
    	{
        	List<EntityOres> list = worldIn.getEntitiesWithinAABB(EntityOres.class, new AxisAlignedBB(new BlockPos(entityIn.posX, entityIn.posY, entityIn.posZ), new BlockPos(entityIn.posX + 1, entityIn.posY + 1, entityIn.posZ + 1)).grow(4, 4, 4));
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
