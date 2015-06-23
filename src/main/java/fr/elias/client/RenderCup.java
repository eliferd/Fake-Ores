package fr.elias.client;

import fr.elias.common.EntityCup;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderCup extends RenderLiving
{
	public static final ResourceLocation texture = new ResourceLocation("fakeores:textures/entity/Cup2.png");
	public RenderCup() {
		super(Minecraft.getMinecraft().getRenderManager(), new ModelCup(), 0.0F);
	}
	protected ResourceLocation getEntityTexture(EntityCup entity) {
		// TODO Auto-generated method stub
		return texture;
	}

	protected float getDeathMaxRotation(EntityLivingBase par1EntityLivingBase)
    {
        return 0.0F;
    }

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		// TODO Auto-generated method stub
		return getEntityTexture((EntityCup) entity);
	}

}
