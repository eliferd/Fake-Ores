package fr.elias.fakeores.client;

import fr.elias.fakeores.entities.EntityOresBoss;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.ModelBase;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class LayerBossPhases implements LayerRenderer<EntityOresBoss> {

	protected static final ResourceLocation enchantmentEffectTexture = new ResourceLocation("textures/misc/enchanted_item_glint.png");
	private final RenderLivingBase<?> renderer;
	private final ModelBase modelBoss;

	public LayerBossPhases(RenderLivingBase<?> rendererIn, ModelBase modelBoss2) {
		this.renderer = rendererIn; 
		this.modelBoss = modelBoss2;
	}

	@Override
	public void render(EntityOresBoss entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {

		this.renderBossPhasesEffect(renderer, entitylivingbaseIn, modelBoss, limbSwing, limbSwingAmount, partialTicks, ageInTicks, netHeadYaw, headPitch, scale);
	}

	public static void renderBossPhasesEffect(RenderLivingBase<?> renderLivingBase, EntityLivingBase entityLivingBase, ModelBase model, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		EntityOresBoss entityOresBoss = (EntityOresBoss) entityLivingBase;

		float f = (float) entityLivingBase.ticksExisted + ageInTicks;
		renderLivingBase.bindTexture(enchantmentEffectTexture);
		GlStateManager.enableBlend();
		GlStateManager.depthFunc(514);
		GlStateManager.depthMask(false);
		float f1 = 0.5F;
		GlStateManager.color4f(f1, f1, f1, 1.0F);

		for (int i = 0; i < 2; ++i) {
			GlStateManager.disableLighting();
			GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_COLOR, GlStateManager.DestFactor.ONE);
			float f2 = 0.76F;
			switch (entityOresBoss.getPhase()) {
			case 2:
				GlStateManager.color4f(0.0F, 0.65F * f2, 0.15F * f2, 1.0F);
				break;
			case 3:
				GlStateManager.color4f(0.8F * f2, 0.15F * f2, 0.15F * f2, 1.0F);
				break;
			default:
				GlStateManager.color4f(0.0F, 0.0F, 0.0F, 0.0F);
				break;
			}
			GlStateManager.matrixMode(5890);
			GlStateManager.loadIdentity();
			float f3 = 0.33333334F;
			GlStateManager.scalef(f3, f3, f3);
			GlStateManager.rotatef(30.0F - (float) i * 60.0F, 0.0F, 0.0F, 1.0F);
			GlStateManager.translatef(0.0F, f * (0.001F + (float) i * 0.003F) * 20.0F, 0.0F);
			GlStateManager.matrixMode(5888);
			model.render(entityLivingBase, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		}

		GlStateManager.matrixMode(5890);
		GlStateManager.loadIdentity();
		GlStateManager.matrixMode(5888);
		GlStateManager.enableLighting();
		GlStateManager.depthMask(true);
		GlStateManager.depthFunc(515);
		GlStateManager.disableBlend();
	}

	@Override
	public boolean shouldCombineTextures() {
		return false;
	}

}