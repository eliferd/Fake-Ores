package fr.elias.fakeores.client;

import fr.elias.fakeores.entities.EntityCup;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderCup extends RenderLiving<EntityCup> {
	public static final ResourceLocation texture = new ResourceLocation("fakeores:textures/entity/cup.png");

	public RenderCup(RenderManager renderManager) {
		super(renderManager, new ModelCup(), 0.0F);
		this.addLayer(new LayerCupAnimation());
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityCup entity) {
		return texture;
	}

}