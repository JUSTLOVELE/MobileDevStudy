package 工厂模式;

import java.util.ArrayList;

public abstract class Pizza {
	
	public String name;
	
	public String dough;
	
	public String sauce;
	
	ArrayList toppings = new ArrayList();
	
	
	
	public  void prepare(){
		System.out.println("preparing" + name);
		System.out.println("Tossing dough ..");
		System.out.println("Adding sauce...");
		System.out.println("Adding toppings:");
		for(int i=0; i<toppings.size(); i++){
			System.out.println(" "+ toppings.get(i));
		}
	}
	
	public String getName(){
		return name;
	}
	
	public abstract void bake();
	
	public abstract void cut();
	
	public abstract void box();
}
