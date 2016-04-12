package fr.elias.common;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class FakeOresSoundEvent {
	public static SoundEvent oreboss_hurt;
	public static SoundEvent oreboss_death;
	public static SoundEvent oreboss_phase2;
	public static SoundEvent oreboss_phase3;

	public static void registerSounds() {
		oreboss_hurt = registerSound("oreboss.hurt");
		oreboss_death = registerSound("oreboss.death"); 
		oreboss_phase2 = registerSound("oreboss.phase.two");
		oreboss_phase3 = registerSound("oreboss.phase.three");
	}

	private static SoundEvent registerSound(String soundName) {
		final ResourceLocation soundID = new ResourceLocation("fakeores", soundName);
		return GameRegistry.register(new SoundEvent(soundID).setRegistryName(soundID));
	}
}