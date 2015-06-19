package fr.elias.client;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelOre extends ModelBase {
	  //fields
    ModelRenderer CUBE;
  
  public ModelOre()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      CUBE = new ModelRenderer(this, 0, 0);
      CUBE.addBox(-8F, -8F, -8F, 16, 16, 16);
      CUBE.setRotationPoint(0F, 16F, 0F);
      CUBE.setTextureSize(64, 32);
      //CUBE.mirror = true;
      setRotation(CUBE, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
	  super.render(entity, f, f1, f2, f3, f4, f5);
	  setRotationAngles(entity, f, f1, f2, f3, f4, f5);
	  CUBE.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
	  model.rotateAngleX = x;
	  model.rotateAngleY = y;
	  model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
	  super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }
}
