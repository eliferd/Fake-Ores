package fr.elias.client;

import java.util.Random;

import org.lwjgl.opengl.GL11;

import fr.elias.common.EntityOresBoss;
import fr.elias.common.FakeOres;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderOresBoss extends RenderLivingBase<EntityOresBoss> {

	private Random rand;

	public static final ResourceLocation texture = new ResourceLocation(FakeOres.useOldOresBossModel ? "fakeores:textures/entity/OresBoss2.png" : "fakeores:textures/entity/OresBoss.png");

	public RenderOresBoss(ModelBase modelBoss) {// RenderPlayer
		super(Minecraft.getMinecraft().getRenderManager(), modelBoss, 2F);
		this.addLayer(new LayerBossPhases(this, modelBoss));
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