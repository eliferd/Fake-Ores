package fr.elias.client;

import fr.elias.common.EntityOresBoss;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;

public class ModelOresBoss extends ModelBase
{
    ModelRenderer leftFoot;
    ModelRenderer rightFoot;
    ModelRenderer leftLeg1;
    ModelRenderer leftLeg2;
    ModelRenderer leftLeg3;
    ModelRenderer rightLeg1;
    ModelRenderer rightLeg2;
    ModelRenderer rightLeg3;
    ModelRenderer bodyLegConnector;
    ModelRenderer bodyBottom2;
    ModelRenderer bodyTopLeft;
    ModelRenderer bodyTopRight;
    ModelRenderer leftArm1;
    ModelRenderer leftArm2;
    ModelRenderer leftArm3;
    ModelRenderer leftHand;
    ModelRenderer rightArm1;
    ModelRenderer rightArm2;
    ModelRenderer rightArm3;
    ModelRenderer rightHand;
    ModelRenderer head;
    ModelRenderer spinningGem;
  
  public ModelOresBoss()
  {
    textureWidth = 136;
    textureHeight = 160;
    
    leftFoot = new ModelRenderer(this, 0, 32);
    leftFoot.addBox(-8F, 0F, -8F, 16, 16, 16);
    leftFoot.setRotationPoint(-16F, 8F, 0F);
    leftFoot.setTextureSize(136, 160);
    leftFoot.mirror = true;
    setRotation(leftFoot, 0F, 0F, 0F);
    rightFoot = new ModelRenderer(this, 0, 64);
    rightFoot.addBox(-8F, 0F, -8F, 16, 16, 16);
    rightFoot.setRotationPoint(16F, 8F, 0F);
    rightFoot.setTextureSize(136, 160);
    rightFoot.mirror = true;
    setRotation(rightFoot, 0F, 0F, 0F);
    leftLeg1 = new ModelRenderer(this, 90, 0);
    leftLeg1.addBox(-4F, 0F, -4F, 8, 8, 8);
    leftLeg1.setRotationPoint(-10F, -16F, 0F);
    leftLeg1.setTextureSize(136, 160);
    leftLeg1.mirror = true;
    setRotation(leftLeg1, 0F, 0F, 0F);
    leftLeg2 = new ModelRenderer(this, 90, 0);
    leftLeg2.addBox(-4F, 0F, -4F, 8, 8, 8);
    leftLeg2.setRotationPoint(-14F, -8F, 0F);
    leftLeg2.setTextureSize(136, 160);
    leftLeg2.mirror = true;
    setRotation(leftLeg2, 0F, 0F, 0F);
    leftLeg3 = new ModelRenderer(this, 90, 0);
    leftLeg3.addBox(-4F, 0F, -4F, 8, 8, 8);
    leftLeg3.setRotationPoint(-16F, 0F, 0F);
    leftLeg3.setTextureSize(136, 160);
    leftLeg3.mirror = true;
    setRotation(leftLeg3, 0F, 0F, 0F);
    
    leftLeg1.addChild(leftLeg2);
    leftLeg2.addChild(leftLeg3);
    leftLeg3.addChild(leftFoot);
    
    rightLeg1 = new ModelRenderer(this, 90, 0);
    rightLeg1.addBox(-4F, 0F, -4F, 8, 8, 8);
    rightLeg1.setRotationPoint(10F, -16F, 0F);
    rightLeg1.setTextureSize(136, 160);
    rightLeg1.mirror = true;
    setRotation(rightLeg1, 0F, 0F, 0F);
    rightLeg2 = new ModelRenderer(this, 90, 0);
    rightLeg2.addBox(-4F, 0F, -4F, 8, 8, 8);
    rightLeg2.setRotationPoint(14F, -8F, 0F);
    rightLeg2.setTextureSize(136, 160);
    rightLeg2.mirror = true;
    setRotation(rightLeg2, 0F, 0F, 0F);
    rightLeg3 = new ModelRenderer(this, 90, 0);
    rightLeg3.addBox(-4F, 0F, -4F, 8, 8, 8);
    rightLeg3.setRotationPoint(16F, 0F, 0F);
    rightLeg3.setTextureSize(136, 160);
    rightLeg3.mirror = true;
    setRotation(rightLeg3, 0F, 0F, 0F);
    
    rightLeg1.addChild(rightLeg2);
    rightLeg2.addChild(rightLeg3);
    rightLeg3.addChild(rightFoot);
    
    bodyLegConnector = new ModelRenderer(this, 72, 16);
    bodyLegConnector.addBox(-5.5F, -5.5F, -5.5F, 11, 11, 11);
    bodyLegConnector.setRotationPoint(0F, -16F, 0F);
    bodyLegConnector.setTextureSize(136, 160);
    bodyLegConnector.mirror = true;
    setRotation(bodyLegConnector, 0F, 0F, 0.7853982F);
    bodyBottom2 = new ModelRenderer(this, 64, 38);
    bodyBottom2.addBox(-8F, -8F, -8F, 16, 16, 16);
    bodyBottom2.setRotationPoint(0F, -24F, 0F);
    bodyBottom2.setTextureSize(136, 160);
    bodyBottom2.mirror = true;
    setRotation(bodyBottom2, 0F, 0F, 0F);
    bodyTopLeft = new ModelRenderer(this, 64, 70);
    bodyTopLeft.addBox(-9F, -9F, -9F, 18, 18, 18);
    bodyTopLeft.setRotationPoint(-9F, -41F, 0F);
    bodyTopLeft.setTextureSize(136, 160);
    bodyTopLeft.mirror = true;
    setRotation(bodyTopLeft, 0F, 0F, -0.1047198F);
    bodyTopRight = new ModelRenderer(this, 64, 106);
    bodyTopRight.addBox(-9F, -9F, -9F, 18, 18, 18);
    bodyTopRight.setRotationPoint(9F, -41F, 0F);
    bodyTopRight.setTextureSize(136, 160);
    bodyTopRight.mirror = true;
    setRotation(bodyTopRight, 0F, 0F, 0.1047198F);
    leftArm1 = new ModelRenderer(this, 90, 0);
    leftArm1.addBox(-9F, -2F, -4F, 8, 8, 8);
    leftArm1.setRotationPoint(-18F, -49F, 0F);
    leftArm1.setTextureSize(136, 160);
    leftArm1.mirror = true;
    setRotation(leftArm1, 0F, 0F, 0F);
    leftArm2 = new ModelRenderer(this, 90, 0);
    leftArm2.addBox(-4F, 0F, -4F, 8, 8, 8);
    leftArm2.setRotationPoint(-25F, -43F, 0F);
    leftArm2.setTextureSize(136, 160);
    leftArm2.mirror = true;
    setRotation(leftArm2, 0F, 0F, 0F);
    leftArm3 = new ModelRenderer(this, 90, 0);
    leftArm3.addBox(-4F, 0F, -4F, 8, 8, 8);
    leftArm3.setRotationPoint(-28F, -35F, 0F);
    leftArm3.setTextureSize(136, 160);
    leftArm3.mirror = true;
    setRotation(leftArm3, 0F, 0F, 0F);
    leftHand = new ModelRenderer(this, 0, 96);
    leftHand.addBox(-8F, 0F, -8F, 16, 16, 16);
    leftHand.setRotationPoint(-28F, -27F, 0F);
    leftHand.setTextureSize(136, 160);
    leftHand.mirror = true;
    setRotation(leftHand, 0F, 0F, 0F);
    rightArm1 = new ModelRenderer(this, 90, 0);
    rightArm1.addBox(1F, -2F, -4F, 8, 8, 8);
    rightArm1.setRotationPoint(18F, -49F, 0F);
    rightArm1.setTextureSize(136, 160);
    rightArm1.mirror = true;
    setRotation(rightArm1, 0F, 0F, 0F);
    rightArm2 = new ModelRenderer(this, 90, 0);
    rightArm2.addBox(-4F, 0F, -4F, 8, 8, 8);
    rightArm2.setRotationPoint(25F, -43F, 0F);
    rightArm2.setTextureSize(136, 160);
    rightArm2.mirror = true;
    setRotation(rightArm2, 0F, 0F, 0F);
    rightArm3 = new ModelRenderer(this, 90, 0);
    rightArm3.addBox(-4F, 0F, -4F, 8, 8, 8);
    rightArm3.setRotationPoint(28F, -35F, 0F);
    rightArm3.setTextureSize(136, 160);
    rightArm3.mirror = true;
    setRotation(rightArm3, 0F, 0F, 0F);
    rightHand = new ModelRenderer(this, 0, 128);
    rightHand.addBox(-8F, 0F, -8F, 16, 16, 16);
    rightHand.setRotationPoint(28F, -27F, 0F);
    rightHand.setTextureSize(136, 160);
    rightHand.mirror = true;
    setRotation(rightHand, 0F, 0F, 0F);
    head = new ModelRenderer(this, 0, 0);
    head.addBox(-8F, -16F, -8F, 16, 16, 16);
    head.setRotationPoint(0F, -50F, 0F);
    head.setTextureSize(136, 160);
    head.mirror = true;
    setRotation(head, 0F, 0F, 0F);
    spinningGem = new ModelRenderer(this, 48, 0);
    spinningGem.addBox(-8F, -8F, -1F, 16, 16, 0);
    spinningGem.setRotationPoint(0F, -33F, -9F);
    spinningGem.setTextureSize(136, 160);
    spinningGem.mirror = true;
    setRotation(spinningGem, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    //rightFoot.render(f5);
    leftLeg1.render(f5);
    rightLeg1.render(f5);
    //rightLeg2.render(f5);
    //rightLeg3.render(f5);
    bodyLegConnector.render(f5);
    bodyBottom2.render(f5);
    bodyTopLeft.render(f5);
    bodyTopRight.render(f5);
    leftArm1.render(f5);
    leftArm2.render(f5);
    leftArm3.render(f5);
    leftHand.render(f5);
    rightArm1.render(f5);
    rightArm2.render(f5);
    rightArm3.render(f5);
    rightHand.render(f5);
    head.render(f5);
    spinningGem.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
  {
	  leftLeg2.rotationPointX = -4.0F;
	  leftLeg2.rotationPointY = 8.0F;
	  leftLeg2.rotationPointZ = 0.0F;
	  leftLeg3.rotationPointX = -2.0F;
	  leftLeg3.rotationPointY = 8.0F;
	  leftLeg3.rotationPointZ = 0.0F;
	  leftFoot.rotationPointX = 0F;
	  
	  rightLeg2.rotationPointX = 4.0F;
	  rightLeg2.rotationPointY = 8.0F;
	  rightLeg2.rotationPointZ = 0.0F;
	  rightLeg3.rotationPointX = 2.0F;
	  rightLeg3.rotationPointY = 8.0F;
	  rightLeg3.rotationPointZ = 0.0F;
	  rightFoot.rotationPointX = 0F;
	  
	  
    boolean flag = entityIn instanceof EntityLivingBase && ((EntityLivingBase)entityIn).getTicksElytraFlying() > 4;
    if(entityIn instanceof EntityOresBoss)
    {
    	if(((EntityOresBoss)entityIn).phase == 1)
    	{
    	    spinningGem.rotateAngleZ += 0.08F;
    	}
    	if(((EntityOresBoss)entityIn).phase == 2)
    	{
    	    spinningGem.rotateAngleZ += 0.16F;
    	}
    	if(((EntityOresBoss)entityIn).phase == 3)
    	{
    	    spinningGem.rotateAngleZ += 0.32F;
    	}
    }
    this.head.rotateAngleY = netHeadYaw * 0.017453292F;
    
    float f = 1.0F;
    if (flag)
    {
        f = (float)(entityIn.motionX * entityIn.motionX + entityIn.motionY * entityIn.motionY + entityIn.motionZ * entityIn.motionZ);
        f = f / 0.2F;
        f = f * f * f;
    }

    if (f < 1.0F)
    {
        f = 1.0F;
    }
    
    this.rightArm1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F / f;
    this.leftArm1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F / f;
    
    this.rightArm1.rotateAngleZ = 0.0F;
    this.leftArm1.rotateAngleZ = 0.0F;
    
    this.rightLeg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.4F * limbSwingAmount / f;
    this.leftLeg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 0.4F * limbSwingAmount / f;
    
    this.rightLeg1.rotateAngleY = 0.0F;
    this.leftLeg1.rotateAngleY = 0.0F;
    
    this.rightLeg1.rotateAngleZ = 0.0F;
    this.leftLeg1.rotateAngleZ = 0.0F;
    
    this.rightArm1.rotateAngleY = 0.0F;
    this.rightArm1.rotateAngleZ = 0.0F;
    
    this.rightArm1.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
    this.leftArm1.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
    
    this.rightArm1.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
    this.leftArm1.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
    
    rightArm3.rotateAngleX = rightArm2.rotateAngleX;
    rightArm2.rotateAngleX = rightArm1.rotateAngleX;
    leftArm3.rotateAngleX = leftArm2.rotateAngleX;
    leftArm2.rotateAngleX = leftArm1.rotateAngleX;
    leftHand.rotateAngleX = leftArm3.rotateAngleX;
    rightHand.rotateAngleX = rightArm3.rotateAngleX;
    //
    rightLeg3.rotateAngleX = rightLeg2.rotateAngleX;
    rightLeg2.rotateAngleX = rightLeg1.rotateAngleX;
    leftLeg3.rotateAngleX = leftLeg2.rotateAngleX;
    leftLeg2.rotateAngleX = leftLeg1.rotateAngleX;
    
    leftFoot.rotateAngleX = leftLeg3.rotateAngleX;
    rightFoot.rotateAngleX = rightLeg3.rotateAngleX;
  }

}
