package fr.elias.fakeores.client;

import java.util.Random;

import fr.elias.fakeores.entities.EntityCup;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class LayerCupAnimation implements LayerRenderer<EntityCup> {

	public void render(EntityCup entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		Tessellator tessellator = Tessellator.getInstance();
		BufferBuilder vertexbuffer = tessellator.getBuffer();
		RenderHelper.disableStandardItemLighting();
		float animationTicks = (float) (720.0 * (System.currentTimeMillis() & 0x3FFFL) / 0x3FFFL);

		float f = ((float) animationTicks + partialTicks) / 400.0F;
		float f1 = 0.0F;

		if (f > 0.8F) {
			f1 = (f - 0.8F) / 1F;
		}

		Random random = new Random(432L);
		GlStateManager.pushMatrix();
		GlStateManager.disableTexture2D();
		GlStateManager.shadeModel(7425);
		GlStateManager.enableBlend();
		GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE);
		GlStateManager.disableAlphaTest();
		GlStateManager.enableCull();
		GlStateManager.depthMask(false);
		GlStateManager.pushMatrix();
		GlStateManager.translatef(0.0F, 1.0F, 0.0F);
		GlStateManager.scaled(0.05D, 0.05D, 0.05D);

		for (int i = 0; (float) i < (f + f * f) / 4.0F * 60.0F; ++i) {
			GlStateManager.rotatef(random.nextFloat() * 360.0F, 1.0F, 0.0F, 0.0F);
			GlStateManager.rotatef(random.nextFloat() * 360.0F, 0.0F, 1.0F, 0.0F);
			GlStateManager.rotatef(random.nextFloat() * 360.0F, 0.0F, 0.0F, 1.0F);
			GlStateManager.rotatef(random.nextFloat() * 360.0F, 1.0F, 0.0F, 0.0F);
			GlStateManager.rotatef(random.nextFloat() * 360.0F, 0.0F, 1.0F, 0.0F);
			GlStateManager.rotatef(random.nextFloat() * 360.0F + f * 90.0F, 0.0F, 0.0F, 1.0F);
			float f2 = random.nextFloat() * 20.0F + 5.0F + f1 * 10.0F;
			float f3 = random.nextFloat() * 2.0F + 1.0F + f1 * 2.0F;
			vertexbuffer.begin(6, DefaultVertexFormats.POSITION_COLOR);
			vertexbuffer.pos(0.0D, 0.0D, 0.0D).color(204, 201, 0, (int) (255.0F * (1.0F - f1))).endVertex();
			vertexbuffer.pos(-0.866D * (double) f3, (double) f2, (double) (-0.5F * f3)).color(242, 240, 84, 0).endVertex();
			vertexbuffer.pos(0.866D * (double) f3, (double) f2, (double) (-0.5F * f3)).color(242, 240, 84, 0).endVertex();
			vertexbuffer.pos(0.0D, (double) f2, (double) (1.0F * f3)).color(242, 240, 84, 0).endVertex();
			vertexbuffer.pos(-0.866D * (double) f3, (double) f2, (double) (-0.5F * f3)).color(242, 240, 84, 0).endVertex();
			tessellator.draw();
		}

		GlStateManager.popMatrix();
		GlStateManager.depthMask(true);
		GlStateManager.disableCull();
		GlStateManager.disableBlend();
		GlStateManager.shadeModel(7424);
		GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		GlStateManager.enableTexture2D();
		GlStateManager.enableAlphaTest();
		RenderHelper.enableStandardItemLighting();
		GlStateManager.popMatrix();
	}

	public boolean shouldCombineTextures() {
		return false;
	}
}