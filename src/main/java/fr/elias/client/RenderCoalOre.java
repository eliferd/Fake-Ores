package fr.elias.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import fr.elias.common.EntityCoalOre;

public class RenderCoalOre extends RenderLiving 
{
	public static final ResourceLocation coal = new ResourceLocation("fakeores:textures/entity/coalOre.png");

	public RenderCoalOre()
	{
		super(Minecraft.getMinecraft().getRenderManager(), new ModelOre(), 0.0F);
	}

	protected float getDeathMaxRotation(EntityLivingBase par1EntityLivingBase)
    {
        return 0.0F;
    }
	public ResourceLocation bindTexture(EntityCoalOre ore)
	{
		return coal;
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) 
	{
		return bindTexture((EntityCoalOre)entity);
	}
}
