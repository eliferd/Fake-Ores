package fr.elias.client;

import java.util.Random;

import org.lwjgl.opengl.GL11;

import fr.elias.common.EntityOresBoss;
import fr.elias.common.FakeOres;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderOresBoss<T extends EntityOresBoss> extends RenderLiving
{
	public static final ResourceLocation texture = new ResourceLocation(FakeOres.useOldOresBossModel ? "fakeores:textures/entity/OresBoss2.png" : "fakeores:textures/entity/OresBoss.png");
	public RenderOresBoss(ModelBase model)
	{
		super(Minecraft.getMinecraft().getRenderManager(), model, 2F);
	}
	private Random rand;
	public void renderHealthBar(EntityOresBoss mob, double x, double y, double z, float par8, float par9)
	{
		if(mob.getPhase() == 2)
		{ 
			GL11.glColor3f(0.0F, 2.0F, 1.0F);
		}
		if(mob.getPhase() == 3)
		{
			GL11.glColor3f(2.0F, 1.0F, 2.0F);
		}
		super.doRender((EntityLiving)mob, x, y, z, par8, par9);
	}
    public void doRender(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderHealthBar((EntityOresBoss)par1EntityLiving, par2, par4, par6, par8, par9);
    }
	protected ResourceLocation getEntityTexture(EntityOresBoss entity) {
		return texture;
	}
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return getEntityTexture((EntityOresBoss)entity);
	}
}
