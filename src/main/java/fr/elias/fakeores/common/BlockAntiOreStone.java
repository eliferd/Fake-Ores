package fr.elias.fakeores.common;

import java.util.List;
import java.util.Random;

import fr.elias.fakeores.entities.EntityOres;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Particles;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class BlockAntiOreStone extends Block {

	public static final AxisAlignedBB FULL_BLOCK_AABB_WITHOUT_SOMETHING = new AxisAlignedBB(0.025D, 0.0D, 0.025D, 1.0D - 0.025D, 1.0D - 0.025D, 1.0D - 0.025D);

	public BlockAntiOreStone(Properties properties){
		super(properties);
	}
    @Override
    public VoxelShape getCollisionShape(IBlockState state, IBlockReader worldIn, BlockPos pos) {
    	return VoxelShapes.create(FULL_BLOCK_AABB_WITHOUT_SOMETHING);
    }
    
    @Override
    public void onEntityCollision(IBlockState state, World worldIn, BlockPos pos, Entity entityIn)
    {
        actionHandler(entityIn);
    }
    
    @Override
    public void onBlockAdded(IBlockState state, World world, BlockPos pos, IBlockState oldState)
    {
        removeNearBlock(world, pos.add(1, 0, 0));
        removeNearBlock(world, pos.add(0, 1, 0));
        removeNearBlock(world, pos.add(0, 0, 1));
        removeNearBlock(world, pos.add(-1, 0, 0));
        removeNearBlock(world, pos.add(0, -1, 0));
        removeNearBlock(world, pos.add(0, 0, -1));
    }
    
    @Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
    {
        removeNearBlock(worldIn, new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ()));
        removeNearBlock(worldIn, new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()));
        removeNearBlock(worldIn, new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1));
        removeNearBlock(worldIn, new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ()));
        removeNearBlock(worldIn, new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ()));
        removeNearBlock(worldIn, new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1));
    }

    @Override
    public void tick(IBlockState state, World worldIn, BlockPos pos, Random random)
    {
        AxisAlignedBB aabb = new AxisAlignedBB(pos, pos.add(1, 1, 1)).expand(1, 1, 1);

        List<EntityOres> list = worldIn.getEntitiesWithinAABB(EntityOres.class, aabb);
        if(list.size() > 0)
        {
            Entity entity = (Entity)list.get(0);
            if(entity instanceof EntityOres)
            {
                entity.attackEntityFrom(DamageSource.GENERIC, Float.MAX_VALUE);
            }
        }
    }

    public void removeNearBlock(World world, BlockPos pos)
    {
        if(world.getBlockState(pos).getBlock() instanceof BlockOre)
        {
        	world.destroyBlock(pos, true);
        }
    }

    public void actionHandler(Entity entity)
    {
        if(entity instanceof EntityOres)
        {
            entity.attackEntityFrom(DamageSource.GENERIC, Float.MAX_VALUE);
        }
    }

    
    public boolean isFullCube(IBlockState state) {
        return false;
    }
}
