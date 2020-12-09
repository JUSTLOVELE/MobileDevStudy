package 原型模式;

public class Client {
	
	public static void main(String[] args) {
		
		ConcretePrototype cp = new ConcretePrototype();
		for(int i=0; i<10; i++){
			
			ConcretePrototype cloneCp = (ConcretePrototype) cp.clone();
			cloneCp.show();
		}
	}

}
