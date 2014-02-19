package miscMod.blocks;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

//Model code generated by MCModeller. All animation, AI,
//and special features are yours to program. Also keep in
//mind that some of these class names may have changed since
//wrote this. Make sure to check for compatibility with the
//latest version of the Minecraft Coder Pack before attempting
//to use this code.

public class ModelBasket extends ModelBase
{
	public ModelRenderer Side1;
	public ModelRenderer Side2;
	public ModelRenderer Side3;
	public ModelRenderer Side4;
	public ModelRenderer Bottom;
	public ModelRenderer Handle1;
	public ModelRenderer Handle2;
	public ModelRenderer Handle3;
	public ModelRenderer HandleTwo1;
	public ModelRenderer HandleTwo2;
	public ModelRenderer HandleTwo3;
	public ModelRenderer Handle4;
	public ModelRenderer HandleTwo4;
	public ModelRenderer HandleMiddle;
	
	public ModelBasket()
	{
		Side1 = new ModelRenderer(this, "Side1");
		Side1.addBox(-8.5F, -8.0F, -8.0F, 1, 16, 16, 0);
		
		Side2 = new ModelRenderer(this, "Side2");
		Side2.addBox(-8.0F, -8.0F, 7.5F, 16, 16, 1, 0);
		
		Side3 = new ModelRenderer(this, "Side3");
		Side3.addBox(-8.0F, -8.0F, -8.5F, 16, 16, 1, 0);
		
		Side4 = new ModelRenderer(this, "Side4");
		Side4.addBox(7.5F, -8.0F, -8.0F, 1, 16, 16, 0);
		
		Bottom = new ModelRenderer(this, "Bottom");
		Bottom.addBox(-8.0F, -0.5F, -8.0F, 16, 1, 16, 0);
		
		Handle1 = new ModelRenderer(this, "Handle1");
		Handle1.addBox(-0.5F, -1.5F, -1.0F, 1, 3, 2, 0);
		
		Handle2 = new ModelRenderer(this, "Handle2");
		Handle2.addBox(-0.5F, -0.5F, -1.0F, 1, 1, 2, 0);
		
		Handle3 = new ModelRenderer(this, "Handle3");
		Handle3.addBox(-0.5F, -0.5F, -1.0F, 1, 1, 2, 0);
		
		HandleTwo1 = new ModelRenderer(this, "HandleTwo1");
		HandleTwo1.addBox(-0.5F, -1.5F, -1.0F, 1, 3, 2, 0);
		
		HandleTwo2 = new ModelRenderer(this, "HandleTwo2");
		HandleTwo2.addBox(-0.5F, -0.5F, -1.0F, 1, 1, 2, 0);
		
		HandleTwo3 = new ModelRenderer(this, "HandleTwo3");
		HandleTwo3.addBox(-0.5F, -0.5F, -1.0F, 1, 1, 2, 0);
		
		Handle4 = new ModelRenderer(this, "Handle4");
		Handle4.addBox(-0.5F, -0.5F, -1.0F, 1, 1, 2, 0);
		
		HandleTwo4 = new ModelRenderer(this, "HandleTwo4");
		HandleTwo4.addBox(-0.5F, -0.5F, -1.0F, 1, 1, 2, 0);
		
		HandleMiddle = new ModelRenderer(this, "HandleMiddle");
		HandleMiddle.addBox(-6.0F, -0.5F, -1.0F, 12, 1, 2, 0);		
	}
	
	public void render(float f, float f1, float f2, float f3, float f4, float f5)
	{
		this.setRotationAngles(f, f1, f2, f3, f4, f5);
		Side1.render(f5);
		Side2.render(f5);
		Side3.render(f5);
		Side4.render(f5);
		Bottom.render(f5);
		Handle1.render(f5);
		Handle2.render(f5);
		Handle3.render(f5);
		HandleTwo1.render(f5);
		HandleTwo2.render(f5);
		HandleTwo3.render(f5);
		Handle4.render(f5);
		HandleTwo4.render(f5);
		HandleMiddle.render(f5);
	}
	//Method you're going to want to override:
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
	{
	}
	
}
