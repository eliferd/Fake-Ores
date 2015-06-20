package fr.elias.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import fr.elias.common.EntityNetherQuartzOre;

public class RenderNetherQuartzOre extends RenderLiving 
{
	public static final ResourceLocation netherquartz = new ResourceLocation("fakeores:textures/entity/netherquartzOre.png");

	public RenderNetherQuartzOre()
	{
		super(Minecraft.getMinecraft().getRenderManager(), new ModelOre(), 0.0F);
	}

	protected float getDeathMaxRotation(EntityLivingBase par1EntityLivingBase)
    {
        return 0.0F;
    }
	public ResourceLocation bindTexture(EntityNetherQuartzOre ore)
	{
		return netherquartz;
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) 
	{
		return bindTexture((EntityNetherQuartzOre)entity);
	}
}
