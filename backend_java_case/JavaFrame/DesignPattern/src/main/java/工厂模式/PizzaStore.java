package 工厂模式;

public abstract class PizzaStore {
	
	public Pizza orderPizza(String type){
		Pizza pizza;
		pizza = createPizza(type);
		pizza.prepare();
		pizza.cut();
		pizza.bake();
		pizza.box();
		return pizza;
		
	}
	//把创建让给子类去处理,允许子类做决定,实例化披萨的责任被移到一个方法中,此方法就如同是一个工厂
	public abstract Pizza createPizza(String type);
	
	

}
