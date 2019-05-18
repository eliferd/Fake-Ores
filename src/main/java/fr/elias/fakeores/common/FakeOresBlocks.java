package fr.elias.fakeores.common;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = FakeOres.MOD_ID, bus = Bus.MOD)
public class FakeOresBlocks {

	public static Block ANTI_ORE_STONE = new BlockAntiOreStone(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8f, 1f)).setRegistryName("anti_ore_stone");
	
	public FakeOresBlocks() {
		// TODO Auto-generated constructor stub
	}

	
	@SubscribeEvent
	public static void registerBlock(final RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(ANTI_ORE_STONE);
	}
}
