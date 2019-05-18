package fr.elias.fakeores.client;

import java.util.Random;

import org.lwjgl.opengl.GL11;

import fr.elias.fakeores.common.FakeOres;
import fr.elias.fakeores.entities.EntityOresBoss;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderOresBoss extends RenderLivingBase<EntityOresBoss> {

	private Random rand;

	public static final ResourceLocation texture = new ResourceLocation("fakeores:textures/entity/oresboss.png");

	public RenderOresBoss(RenderManager renderManager) {// RenderPlayer
		super(renderManager, new ModelOresBoss(), 2F);
		this.addLayer(new LayerBossPhases(this, new ModelOresBoss()));
	}

	public void renderHealthBar(EntityOresBoss mob, double x, double y, double z, float entityYaw, float partialTicks) {
		if (mob.getPhase() == 2) {
			GL11.glColor3f(0.0F, 2.0F, 1.0F);
		}
		if (mob.getPhase() == 3) {
			GL11.glColor3f(2.0F, 1.0F, 2.0F);
		}
		super.doRender(mob, x, y, z, entityYaw, partialTicks);
	}

	public void doRender(EntityLiving par1EntityLiving, double x, double y, double z, float entityYaw, float partialTicks) {
		this.renderHealthBar((EntityOresBoss) par1EntityLiving, x, y, z, entityYaw, partialTicks);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityOresBoss entity) {
		return texture;
	}

}