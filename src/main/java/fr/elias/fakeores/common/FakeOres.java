package fr.elias.fakeores.common;

import fr.elias.fakeores.client.RenderLoaders;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.MinableConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// https://stackoverflow.com/questions/27015495/meaning-of-in-java-syntax
// https://stackoverflow.com/questions/20001427/double-colon-operator-in-java-8
// https://javapapers.com/core-java/lambda-expression-in-java-8/

@Mod(FakeOres.MOD_ID)

public class FakeOres {
	
	public static final String MOD_ID = "fakeores";
	public static final String MOD_NAME = "Fake Ores";
	public static final String MOD_VER = "2.0";
	
	public static ItemGroup FAKEORES_TAB = new ItemGroup("fakeores") {
	   public boolean hasSearchBar() {
	        return true;
	   }
		@Override
		public ItemStack createIcon() {
			return new ItemStack(Blocks.DIAMOND_ORE);
		}		
	};
	
	public FakeOres() {
 		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::init);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientInit);
		ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, FakeOresConfig.serverSpec);
		ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, FakeOresConfig.clientSpec);
	}
	
	public void init(final FMLCommonSetupEvent event) {
		MinecraftForge.EVENT_BUS.register(FakeOresEvents.class);
		
		Biome.BIOMES.forEach(biome -> {
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, 
            				 Biome.createCompositeFeature(Feature.MINABLE, new MinableConfig(MinableConfig.IS_ROCK, FakeOresBlocks.ANTI_ORE_STONE.getDefaultState(), 6), Biome.COUNT_RANGE, new CountRangeConfig(9, 0, 0, 135)));
        });
	}
	
	public void clientInit(final FMLClientSetupEvent event) {
		new RenderLoaders();
	}
}
