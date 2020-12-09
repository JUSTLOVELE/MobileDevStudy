package 工厂模式;

public class NyStyleCheesePizza extends Pizza {
	
	public NyStyleCheesePizza(){
		name = "NY Style Sauce and Cheese Pizza";
		dough = "Thin Crust Dough";
		sauce = "Marinara Sauce";
		toppings.add("Grated Reggiano Cheese");
	}
	
	public void bake(){
		System.out.println("bake CheesePizza");
	}
	
	public void cut(){
		System.out.println("cut CheesePizza");
	}
	
	public void box(){
		System.out.println("box CheesePizza");
	}

}
