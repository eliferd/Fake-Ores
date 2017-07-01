package fr.elias.common;

import java.util.Random;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenAntiOreStone implements IWorldGenerator
{

	public void generateSurface(World world, int x, int z, Random rand)
	{
		for(int i = 0; i < 2; i++)
		{
			(new WorldGenMinable(FakeOres.antiOreStone.getDefaultState(), 6)).generate(world, rand, new BlockPos(x + rand.nextInt(16), rand.nextInt(128), z + rand.nextInt(16)));
		}
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
	{
		switch(world.provider.getDimension())
		{
		case 0:
			this.generateSurface(world, chunkX * 16, chunkZ * 16, random);
		}
	}
}
