package fr.elias.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import fr.elias.common.EntityIronOre;

public class RenderIronOre extends RenderLiving 
{
	public static final ResourceLocation iron = new ResourceLocation("fakeores:textures/entity/ironOre.png");

	public RenderIronOre()
	{
		super(Minecraft.getMinecraft().getRenderManager(), new ModelOre(), 0.0F);
	}

	protected float getDeathMaxRotation(EntityLivingBase par1EntityLivingBase)
    {
        return 0.0F;
    }
	public ResourceLocation bindTexture(EntityIronOre ore)
	{
		return iron;
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) 
	{
		return bindTexture((EntityIronOre)entity);
	}
}
