package fr.elias.client;

import fr.elias.common.EntityOres;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderOres extends Render<EntityOres> {

	private IBlockState iblockState;

	public RenderOres(Block block) {
		super(Minecraft.getMinecraft().getRenderManager());
		this.iblockState = block.getDefaultState();
	}

	public void doRender(EntityOres entity, double x, double y, double z, float entityYaw, float partialTicks) {
		BlockRendererDispatcher blockrendererdispatcher = Minecraft.getMinecraft().getBlockRendererDispatcher();

		GlStateManager.pushMatrix();

		GlStateManager.translate((float) x, (float) y + 0.5F, (float) z);
		// GlStateManager.rotate(entity.rotationYawHead, 0, 1, 0);
		GlStateManager.rotate(-90.0F, 0.0F, 1.0F, 0.0F);
		GlStateManager.translate(-0.5F, -0.5F, 0.5F);

		this.bindTexture(TextureMap.locationBlocksTexture);
		blockrendererdispatcher.renderBlockBrightness(this.iblockState, entity.getBrightness(partialTicks));
		GlStateManager.translate(0.0F, 0.0F, 1.0F);
		if (this.renderOutlines) {
			GlStateManager.enableColorMaterial();
			GlStateManager.enableOutlineMode(this.getTeamColor(entity));
			blockrendererdispatcher.renderBlockBrightness(this.iblockState, 1.0F);
			GlStateManager.disableOutlineMode();
			GlStateManager.disableColorMaterial();
		}

		GlStateManager.popMatrix();

		super.doRender(entity, x, y, z, entityYaw, partialTicks);
	}

	protected float getDeathMaxRotation(EntityLivingBase par1EntityLivingBase) {
		return 0.0F;
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityOres entity) {
		return TextureMap.locationBlocksTexture;
	}
}
