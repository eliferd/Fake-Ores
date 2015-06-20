package fr.elias.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import fr.elias.common.EntityLapisOre;

public class RenderLapisOre extends RenderLiving 
{
	public static final ResourceLocation lapis = new ResourceLocation("fakeores:textures/entity/lapisOre.png");

	public RenderLapisOre()
	{
		super(Minecraft.getMinecraft().getRenderManager(), new ModelOre(), 0.0F);
	}

	protected float getDeathMaxRotation(EntityLivingBase par1EntityLivingBase)
    {
        return 0.0F;
    }
	public ResourceLocation bindTexture(EntityLapisOre ore)
	{
		return lapis;
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) 
	{
		return bindTexture((EntityLapisOre)entity);
	}
}
