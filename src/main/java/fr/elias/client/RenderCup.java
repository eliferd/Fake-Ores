package fr.elias.client;

import fr.elias.common.EntityCup;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.util.ResourceLocation;

public class RenderCup extends RenderLiving<EntityCup> {
	public static final ResourceLocation texture = new ResourceLocation("fakeores:textures/entity/Cup2.png");

	public RenderCup() {
		super(Minecraft.getMinecraft().getRenderManager(), new ModelCup(), 0.0F);
		this.addLayer(new LayerCupAnimation());
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityCup entity) {
		return texture;
	}

}