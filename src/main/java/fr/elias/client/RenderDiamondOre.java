package fr.elias.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import fr.elias.common.EntityDiamondOre;

public class RenderDiamondOre extends RenderLiving 
{
	public static final ResourceLocation diamond = new ResourceLocation("fakeores:textures/entity/diamondOre.png");

	public RenderDiamondOre()
	{
		super(Minecraft.getMinecraft().getRenderManager(), new ModelOre(), 0.0F);
	}

	protected float getDeathMaxRotation(EntityLivingBase par1EntityLivingBase)
    {
        return 0.0F;
    }
	public ResourceLocation bindTexture(EntityDiamondOre ore)
	{
		return diamond;
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) 
	{
		return bindTexture((EntityDiamondOre)entity);
	}
}
