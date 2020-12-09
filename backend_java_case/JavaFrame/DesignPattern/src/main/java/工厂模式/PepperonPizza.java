package 工厂模式;

public class PepperonPizza extends Pizza{
	
	public void prepare(){
		System.out.println("prepare PepperonPizza");
	}
	
	public void bake(){
		System.out.println("bake PepperonPizza");
	}
	
	public void cut(){
		System.out.println("cut PepperonPizza");
	}
	
	public void box(){
		System.out.println("box PepperonPizza");
	}

}
