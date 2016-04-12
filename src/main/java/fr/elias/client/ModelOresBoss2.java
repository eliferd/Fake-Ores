package fr.elias.client;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelOresBoss2 extends ModelBase
{
	ModelRenderer Shape1;
	ModelRenderer Shape2;
	ModelRenderer Shape3;
	ModelRenderer Shape4;
	ModelRenderer Shape5;
	ModelRenderer Shape6;
	ModelRenderer Shape7;
	ModelRenderer Shape8;
	ModelRenderer Shape9;
	ModelRenderer Shape10;
	ModelRenderer Shape11;
	ModelRenderer Shape12;
	ModelRenderer Shape13;
	ModelRenderer Shape14;
	ModelRenderer Shape15;
	ModelRenderer Shape16;
	ModelRenderer Shape17;
	ModelRenderer Shape18;
	ModelRenderer Shape19;
	ModelRenderer Shape20;

	public ModelOresBoss2()
	{
		textureWidth = 512;
		textureHeight = 64;

		Shape1 = new ModelRenderer(this, 64, 0);
		Shape1.addBox(-8F, 0F, -8F, 16, 16, 16);
		Shape1.setRotationPoint(0F, -38F, 0F);
		Shape1.setTextureSize(512, 64);
		Shape1.mirror = true;
		setRotation(Shape1, 0.0174533F, 0.0523599F, 0F);
		Shape2 = new ModelRenderer(this, 128, 0);
		Shape2.addBox(8.5F, -3F, -6F, 16, 16, 16);
		Shape2.setRotationPoint(0F, -38F, -2F);
		Shape2.setTextureSize(512, 64);
		Shape2.mirror = true;
		setRotation(Shape2, -0.0174533F, 0.0523599F, 0.1396263F);
		Shape3 = new ModelRenderer(this, 192, 0);
		Shape3.addBox(-24.5F, -1F, -9F, 16, 16, 16);
		Shape3.setRotationPoint(0F, -38F, 0F);
		Shape3.setTextureSize(512, 64);
		Shape3.mirror = true;
		setRotation(Shape3, 0.0523599F, -0.0349066F, -0.0523599F);
		Shape4 = new ModelRenderer(this, 256, 0);
		Shape4.addBox(-19F, 14F, -6F, 16, 16, 16);
		Shape4.setRotationPoint(0F, -38F, 0F);
		Shape4.setTextureSize(512, 64);
		Shape4.mirror = true;
		setRotation(Shape4, 0F, -0.1047198F, -0.0523599F);
		Shape5 = new ModelRenderer(this, 320, 0);
		Shape5.addBox(-1F, 14F, -8F, 16, 16, 16);
		Shape5.setRotationPoint(0F, -38F, 0F);
		Shape5.setTextureSize(512, 64);
		Shape5.mirror = true;
		setRotation(Shape5, 0.0349066F, -0.0523599F, 0.0523599F);
		Shape6 = new ModelRenderer(this, 384, 0);
		Shape6.addBox(-8F, -16F, -8F, 16, 16, 16);
		Shape6.setRotationPoint(0F, -38F, 0F);
		Shape6.setTextureSize(512, 64);
		Shape6.mirror = true;
		setRotation(Shape6, 0F, 0F, 0F);
		Shape7 = new ModelRenderer(this, 0, 32);
		Shape7.addBox(-4F, 8F, -4F, 8, 8, 8);
		Shape7.setRotationPoint(7.5F, -8F, 0F);
		Shape7.setTextureSize(512, 64);
		Shape7.mirror = true;
		setRotation(Shape7, 0F, -0.2443461F, 0F);
		Shape8 = new ModelRenderer(this, 0, 32);
		Shape8.addBox(-4F, 0F, -4F, 8, 8, 8);
		Shape8.setRotationPoint(7.5F, -8F, 0F);
		Shape8.setTextureSize(512, 64);
		Shape8.mirror = true;
		setRotation(Shape8, 0F, 0.122173F, 0F);
		Shape9 = new ModelRenderer(this, 32, 32);
		Shape9.addBox(-8F, 16F, -9F, 16, 16, 16);
		Shape9.setRotationPoint(7.5F, -8F, 0F);
		Shape9.setTextureSize(512, 64);
		Shape9.mirror = true;
		setRotation(Shape9, 0F, 0.0872665F, 0F);
		Shape10 = new ModelRenderer(this, 0, 32);
		Shape10.addBox(-4F, 0F, -4F, 8, 8, 8);
		Shape10.setRotationPoint(-11.5F, -8F, 0F);
		Shape10.setTextureSize(512, 64);
		Shape10.mirror = true;
		setRotation(Shape10, 0F, -0.0872665F, 0F);
		Shape11 = new ModelRenderer(this, 0, 32);
		Shape11.addBox(-4F, 8F, -4F, 8, 8, 8);
		Shape11.setRotationPoint(-11.5F, -8F, 0F);
		Shape11.setTextureSize(512, 64);
		Shape11.mirror = true;
		setRotation(Shape11, 0F, 0.0523599F, 0F);
		Shape12 = new ModelRenderer(this, 448, 0);
		Shape12.addBox(-8F, 16F, -9F, 16, 16, 16);
		Shape12.setRotationPoint(-11.5F, -8F, 0F);
		Shape12.setTextureSize(512, 64);
		Shape12.mirror = true;
		setRotation(Shape12, 0F, -0.0698132F, 0F);
		Shape13 = new ModelRenderer(this, 0, 32);
		Shape13.addBox(-4F, 0F, -4F, 8, 8, 8);
		Shape13.setRotationPoint(27F, -36F, 0F);
		Shape13.setTextureSize(512, 64);
		Shape13.mirror = true;
		setRotation(Shape13, 0F, 0F, 0F);
		Shape14 = new ModelRenderer(this, 0, 32);
		Shape14.addBox(-4F, 0F, -4F, 8, 8, 8);
		Shape14.setRotationPoint(-28F, -36F, 0F);
		Shape14.setTextureSize(512, 64);
		Shape14.mirror = true;
		setRotation(Shape14, 0F, 0F, 0F);
		Shape15 = new ModelRenderer(this, 0, 32);
		Shape15.addBox(-5F, 8F, -4F, 8, 8, 8);
		Shape15.setRotationPoint(-28F, -36F, 0F);
		Shape15.setTextureSize(512, 64);
		Shape15.mirror = true;
		setRotation(Shape15, 0F, 0.1745329F, 0F);
		Shape16 = new ModelRenderer(this, 0, 32);
		Shape16.addBox(-6F, 16F, -4F, 8, 8, 8);
		Shape16.setRotationPoint(-28F, -36F, 0F);
		Shape16.setTextureSize(512, 64);
		Shape16.mirror = true;
		setRotation(Shape16, 0F, 0.2094395F, 0F);
		Shape17 = new ModelRenderer(this, 96, 32);
		Shape17.addBox(-10F, 24F, -8F, 16, 16, 16);
		Shape17.setRotationPoint(-28F, -36F, 0F);
		Shape17.setTextureSize(512, 64);
		Shape17.mirror = true;
		setRotation(Shape17, 0F, -0.1396263F, 0F);
		Shape18 = new ModelRenderer(this, 0, 32);
		Shape18.addBox(-3F, 8F, -4F, 8, 8, 8);
		Shape18.setRotationPoint(27F, -36F, 0F);
		Shape18.setTextureSize(512, 64);
		Shape18.mirror = true;
		setRotation(Shape18, 0F, 0.0698132F, 0F);
		Shape19 = new ModelRenderer(this, 0, 32);
		Shape19.addBox(-2F, 16F, -4F, 8, 8, 8);
		Shape19.setRotationPoint(27F, -36F, 0F);
		Shape19.setTextureSize(512, 64);
		Shape19.mirror = true;
		setRotation(Shape19, 0F, -0.1047198F, 0F);
		Shape20 = new ModelRenderer(this, 0, 0);
		Shape20.addBox(-6F, 24F, -7F, 16, 16, 16);
		Shape20.setRotationPoint(27F, -36F, -1F);
		Shape20.setTextureSize(512, 64);
		Shape20.mirror = true;
		setRotation(Shape20, 0F, -0.2094395F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Shape1.render(f5);
		Shape2.render(f5);
		Shape3.render(f5);
		Shape4.render(f5);
		Shape5.render(f5);
		Shape6.render(f5);
		Shape7.render(f5);
		Shape8.render(f5);
		Shape9.render(f5);
		Shape10.render(f5);
		Shape11.render(f5);
		Shape12.render(f5);
		Shape13.render(f5);
		Shape14.render(f5);
		Shape15.render(f5);
		Shape16.render(f5);
		Shape17.render(f5);
		Shape18.render(f5);
		Shape19.render(f5);
		Shape20.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);

		this.Shape10.rotateAngleX = MathHelper.cos((180F / (float)Math.PI)) * 2F * f1;
		this.Shape11.rotateAngleX = MathHelper.cos((180F / (float)Math.PI)) * 2F * f1;
		this.Shape12.rotateAngleX = MathHelper.cos((180F / (float)Math.PI)) * 2F * f1;

		this.Shape7.rotateAngleX = MathHelper.cos((180F / (float)Math.PI)) * -2F * f1;
		this.Shape8.rotateAngleX = MathHelper.cos((180F / (float)Math.PI)) * -2F * f1;
		this.Shape9.rotateAngleX = MathHelper.cos((180F / (float)Math.PI)) * -2F * f1;

		this.Shape13.rotateAngleX = MathHelper.cos((180F / (float)Math.PI)) * 2F * f1;
		this.Shape18.rotateAngleX = MathHelper.cos((180F / (float)Math.PI)) * 2F * f1;
		this.Shape19.rotateAngleX = MathHelper.cos((180F / (float)Math.PI)) * 2F * f1;
		this.Shape20.rotateAngleX = MathHelper.cos((180F / (float)Math.PI)) * 2F * f1;

		this.Shape14.rotateAngleX = MathHelper.cos((180F / (float)Math.PI)) * -2F * f1;
		this.Shape15.rotateAngleX = MathHelper.cos((180F / (float)Math.PI)) * -2F * f1;
		this.Shape16.rotateAngleX = MathHelper.cos((180F / (float)Math.PI)) * -2F * f1;
		this.Shape17.rotateAngleX = MathHelper.cos((180F / (float)Math.PI)) * -2F * f1;

	}

}