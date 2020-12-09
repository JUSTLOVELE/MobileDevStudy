package 工厂模式;

public class ChicagoPizzaStroe extends PizzaStore{

	@Override
	public Pizza createPizza(String type) {
		Pizza pizza = null ;
		
		if(type.equals("cheese")){
			pizza = new NyStyleCheesePizza();
		}
		else if(type.equals("pepperoni")){
			pizza = new PepperonPizza();
		}
		else if(type.equals("clam")){
			pizza = new ChicagoStyleCheesePizza();
		}
		else if(type.equals("veggie")){
			pizza = new VeggiePizza();
		}
		
		return pizza;
	}

}
