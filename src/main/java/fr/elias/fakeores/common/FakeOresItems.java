package fr.elias.fakeores.common;

import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTier;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = FakeOres.MOD_ID, bus = Bus.MOD)
public class FakeOresItems {

	public static Item ANTI_ORES_BLADE = new ItemSword(ItemTier.WOOD, 1, -1.2F, new Item.Properties().group(FakeOres.FAKEORES_TAB)).setRegistryName("anti_ore_blade"), 
					   BOSS_FRAGMENT_1 = new Item(new Item.Properties().group(FakeOres.FAKEORES_TAB)).setRegistryName("boss_fragment1"),
					   BOSS_FRAGMENT_2 = new Item(new Item.Properties().group(FakeOres.FAKEORES_TAB)).setRegistryName("boss_fragment2"),
					   BOSS_FRAGMENT_3 = new Item(new Item.Properties().group(FakeOres.FAKEORES_TAB)).setRegistryName("boss_fragment3"),
					   BOSS_FRAGMENT_4 = new Item(new Item.Properties().group(FakeOres.FAKEORES_TAB)).setRegistryName("boss_fragment4"),
					   BOSS_SPAWNER = new ItemBossSpawner(new Item.Properties().group(FakeOres.FAKEORES_TAB)).setRegistryName("boss_spawner"),
					   TOTEM = new ItemTotem(new Item.Properties().maxStackSize(1).group(FakeOres.FAKEORES_TAB)).setRegistryName("totem"),
					   RED_GEM = new Item(new Item.Properties().group(FakeOres.FAKEORES_TAB)).setRegistryName("red_gem");

	public FakeOresItems() {
	}

	@SubscribeEvent
    public static void registerItem(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(ANTI_ORES_BLADE, BOSS_FRAGMENT_1, BOSS_FRAGMENT_2, BOSS_FRAGMENT_3, BOSS_FRAGMENT_4, BOSS_SPAWNER, TOTEM, RED_GEM);
		event.getRegistry().register(new ItemBlock(FakeOresBlocks.ANTI_ORE_STONE, new Item.Properties().group(FakeOres.FAKEORES_TAB)).setRegistryName(FakeOresBlocks.ANTI_ORE_STONE.getRegistryName()));
    }
}
