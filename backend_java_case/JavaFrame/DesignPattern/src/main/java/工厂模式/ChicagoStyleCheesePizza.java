package 工厂模式;

public class ChicagoStyleCheesePizza  extends Pizza{
	
	public ChicagoStyleCheesePizza(){
		name = "Chicago Style Deep Dish Cheese Pizza";
		dough = "Extra Thick Crust Dough";
		sauce = "Plum Tomoto Sauce";
		toppings.add("Shredded Mozzarella Cheese");
	}
	
	
	public void bake(){
		System.out.println("bake ClamPizza");
	}
	
	public void cut(){
		System.out.println("cut ClamPizza");
	}
	
	public void box(){
		System.out.println("box ClamPizza");
	}

}
