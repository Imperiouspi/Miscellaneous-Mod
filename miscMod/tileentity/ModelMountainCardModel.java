package miscMod.tileentity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelMountainCardModel extends ModelBase
{
	public ModelRenderer BaseLayer;
	public ModelRenderer M1;
	public ModelRenderer M2;
	public ModelRenderer M3;
	public ModelRenderer M4;
	public ModelRenderer M5;
	public ModelRenderer M6;
	public ModelRenderer M7;
	public ModelRenderer M8;

	public ModelMountainCardModel()
	{
		BaseLayer = new ModelRenderer(this, 0, 0);
		BaseLayer.addBox(-8.0F, -0.5F, -8.0F, 16, 1, 16, 0);

		M1 = new ModelRenderer(this, 0, 0);
		M1.addBox(-3.5F, -0.5F, -3.5F, 7, 1, 7, 0);
		setRotation(M1, 4.0F, -1.0F, -4.0f);

		M2 = new ModelRenderer(this, 0, 0);
		M2.addBox(-3.5F, -0.5F, -3.5F, 7, 1, 7, 0);
		setRotation(M2, 3.0F, -1.0F, -3.0F);

		M3 = new ModelRenderer(this, 0, 0);
		M3.addBox(-3.5F, -1.0F, -3.5F, 7, 2, 7, 0);
		setRotation(M3, 4.0F, -2.5F, -4.0F);

		M4 = new ModelRenderer(this, 0, 0);
		M4.addBox(-2.0F, -0.5F, -2.0F, 4, 1, 4, 0);
		setRotation(M4, 5.0F, -4.5F, -4.0F);

		M5 = new ModelRenderer(this, 0, 0);
		M5.addBox(-3.0F, -0.5F, -3.0F, 6, 1, 6, 0);
		setRotation(M5, 4.0F, -3.5F, -4.0F);

		M6 = new ModelRenderer(this, 0, 0);
		M6.addBox(-2.0F, -0.5F, -1.5F, 4, 1, 3, 0);
		setRotation(M6, 5.0F, -5.5F, -4.5F);

		M7 = new ModelRenderer(this, 0, 0);
		M7.addBox(4.0F, -0.5F, -6.0F, 3, 1, 4, 0);
		setRotation(M7, 0.0F, -5.5F, -0.0F);

		M8 = new ModelRenderer(this, 0, 0);
		M8.addBox(4.0F, -0.5F, -6.0F, 3, 1, 3, 0);
		setRotation(M8, 0.0F, -6.5F, -0.0F);

	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		BaseLayer.render(f5);
		M1.render(f5);
		M2.render(f5);
		M3.render(f5);
		M4.render(f5);
		M5.render(f5);
		M6.render(f5);
		M7.render(f5);
		M8.render(f5);
	}
	
	private void setRotation(ModelRenderer model, float x, float y, float z)
	  {
	    model.rotateAngleX = x;
	    model.rotateAngleY = y;
	    model.rotateAngleZ = z;
	  }
	
	//Method you're going to want to override:
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
	{
	}

}
