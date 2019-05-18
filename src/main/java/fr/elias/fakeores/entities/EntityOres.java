package fr.elias.fakeores.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.world.World;

public class EntityOres extends EntityMob {

	protected EntityOres(EntityType<?> type, World p_i48553_2_) {
		super(type, p_i48553_2_);
	}

	public void fall(float distance, float damageMultiplier) {}
	
}
