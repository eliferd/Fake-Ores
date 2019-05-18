package fr.elias.fakeores.client;

import fr.elias.fakeores.entities.EntityOres;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class RenderOres extends Render<EntityOres> {

	private IBlockState iblockstate;

	public RenderOres(Block block, RenderManager rmg) {
		super(rmg);
		this.iblockstate = block.getDefaultState();
	}

	public void doRender(EntityOres entity, double x, double y, double z, float entityYaw, float partialTicks) {
	     
	    BlockRendererDispatcher blockrendererdispatcher = Minecraft.getInstance().getBlockRendererDispatcher();

		GlStateManager.pushMatrix();

		GlStateManager.translatef((float) x, (float) y + 0.5F, (float) z);
		GlStateManager.rotatef(entity.rotationYawHead, 0, 1, 0);
		GlStateManager.rotatef(-90.0F, 0.0F, 1.0F, 0.0F);
		GlStateManager.translatef(-0.5F, -0.5F, 0.5F);
		this.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
		blockrendererdispatcher.renderBlockBrightness(this.iblockstate, entity.getBrightness());
		GlStateManager.translatef(0.0F, 0.0F, 1.0F);
		if (this.renderOutlines) {
			GlStateManager.enableColorMaterial();
			GlStateManager.enableOutlineMode(this.getTeamColor(entity));
			blockrendererdispatcher.renderBlockBrightness(this.iblockstate, 1.0F);
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
		return TextureMap.LOCATION_BLOCKS_TEXTURE;
	}
}
