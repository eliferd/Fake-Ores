package fr.elias.fakeores.client;

import net.minecraft.client.renderer.entity.model.ModelBase;
import net.minecraft.client.renderer.entity.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCup extends ModelBase{
	
    ModelRenderer pied;
    ModelRenderer manche;
    ModelRenderer cupTOP;
    ModelRenderer cupFACE;
    ModelRenderer cupRIGHT;
    ModelRenderer cupLEFT;
    ModelRenderer cupBACK;
    ModelRenderer cupPixelRight1;
    ModelRenderer cupPixelRight2;
    ModelRenderer cupPixelRight3;
    ModelRenderer cupPixelLeft1;
    ModelRenderer cupPixelLeft2;
    ModelRenderer cupPixelLeft3;
    
	public ModelCup() {
	    textureWidth = 24;
	    textureHeight = 20;
	    
	      pied = new ModelRenderer(this, 0, 0);
	      pied.addBox(-2F, 0F, -2F, 4, 1, 4);
	      pied.setRotationPoint(0F, 23F, 0F);
	      pied.setTextureSize(24, 20);
	      pied.mirror = true;
	      setRotation(pied, 0F, 0F, 0F);
	      manche = new ModelRenderer(this, 0, 5);
	      manche.addBox(-1F, -5F, -1F, 2, 6, 2);
	      manche.setRotationPoint(0F, 22F, 0F);
	      manche.setTextureSize(24, 20);
	      manche.mirror = true;
	      setRotation(manche, 0F, 0F, 0F);
	      cupTOP = new ModelRenderer(this, 0, 13);
	      cupTOP.addBox(-3F, -1F, -3F, 6, 1, 6);
	      cupTOP.setRotationPoint(0F, 17F, 0F);
	      cupTOP.setTextureSize(24, 20);
	      cupTOP.mirror = true;
	      setRotation(cupTOP, 0F, 0F, 0F);
	      cupFACE = new ModelRenderer(this, 0, 13);
	      cupFACE.addBox(-3F, -1F, -3F, 6, 1, 6);
	      cupFACE.setRotationPoint(0F, 13F, -3F);
	      cupFACE.setTextureSize(24, 20);
	      cupFACE.mirror = true;
	      setRotation(cupFACE, 1.570796F, 0F, 0F);
	      cupRIGHT = new ModelRenderer(this, 0, 13);
	      cupRIGHT.addBox(-3F, -1F, -3F, 6, 1, 6);
	      cupRIGHT.setRotationPoint(-3F, 13F, 0F);
	      cupRIGHT.setTextureSize(24, 20);
	      cupRIGHT.mirror = true;
	      setRotation(cupRIGHT, 1.570796F, 1.570796F, 0F);
	      cupLEFT = new ModelRenderer(this, 0, 13);
	      cupLEFT.addBox(-3F, -1F, -3F, 6, 1, 6);
	      cupLEFT.setRotationPoint(3F, 13F, 0F);
	      cupLEFT.setTextureSize(24, 20);
	      cupLEFT.mirror = true;
	      setRotation(cupLEFT, -1.570796F, 1.570796F, 0F);
	      cupBACK = new ModelRenderer(this, 0, 13);
	      cupBACK.addBox(-3F, -1F, -3F, 6, 1, 6);
	      cupBACK.setRotationPoint(0F, 13F, 3F);
	      cupBACK.setTextureSize(24, 20);
	      cupBACK.mirror = true;
	      setRotation(cupBACK, -1.570796F, 0F, 0F);
	      cupPixelRight1 = new ModelRenderer(this, 0, 15);
	      cupPixelRight1.addBox(-1F, 0F, -0.5F, 1, 1, 1);
	      cupPixelRight1.setRotationPoint(-4F, 11F, 0F);
	      cupPixelRight1.setTextureSize(24, 20);
	      cupPixelRight1.mirror = true;
	      setRotation(cupPixelRight1, 0F, 0F, 0F);
	      cupPixelRight2 = new ModelRenderer(this, 0, 15);
	      cupPixelRight2.addBox(-1F, 0F, -0.5F, 1, 1, 1);
	      cupPixelRight2.setRotationPoint(-4F, 14F, 0F);
	      cupPixelRight2.setTextureSize(24, 20);
	      cupPixelRight2.mirror = true;
	      setRotation(cupPixelRight2, 0F, 0F, 0F);
	      cupPixelRight3 = new ModelRenderer(this, 19, 15);
	      cupPixelRight3.addBox(-1F, -1F, -0.5F, 1, 2, 1);
	      cupPixelRight3.setRotationPoint(-5F, 13F, 0F);
	      cupPixelRight3.setTextureSize(24, 20);
	      cupPixelRight3.mirror = true;
	      setRotation(cupPixelRight3, 0F, 0F, 0F);
	      cupPixelLeft1 = new ModelRenderer(this, 0, 15);
	      cupPixelLeft1.addBox(0F, 0F, -0.5F, 1, 1, 1);
	      cupPixelLeft1.setRotationPoint(4F, 11F, 0F);
	      cupPixelLeft1.setTextureSize(24, 20);
	      cupPixelLeft1.mirror = true;
	      setRotation(cupPixelLeft1, 0F, 0F, 0F);
	      cupPixelLeft2 = new ModelRenderer(this, 0, 15);
	      cupPixelLeft2.addBox(0F, 0F, -0.5F, 1, 1, 1);
	      cupPixelLeft2.setRotationPoint(4F, 14F, 0F);
	      cupPixelLeft2.setTextureSize(24, 20);
	      cupPixelLeft2.mirror = true;
	      setRotation(cupPixelLeft2, 0F, 0F, 0F);
	      cupPixelLeft3 = new ModelRenderer(this, 19, 15);
	      cupPixelLeft3.addBox(0F, -1F, -0.5F, 1, 2, 1);
	      cupPixelLeft3.setRotationPoint(5F, 13F, 0F);
	      cupPixelLeft3.setTextureSize(24, 20);
	      cupPixelLeft3.mirror = true;
	      setRotation(cupPixelLeft3, 0F, 0F, 0F);
	}
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
	    super.render(entity, f, f1, f2, f3, f4, f5);
	    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	    pied.render(f5);
	    manche.render(f5);
	    cupTOP.render(f5);
	    cupFACE.render(f5);
	    cupRIGHT.render(f5);
	    cupLEFT.render(f5);
	    cupBACK.render(f5);
	    cupPixelRight1.render(f5);
	    cupPixelRight2.render(f5);
	    cupPixelRight3.render(f5);
	    cupPixelLeft1.render(f5);
	    cupPixelLeft2.render(f5);
	    cupPixelLeft3.render(f5);
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
	}
}
