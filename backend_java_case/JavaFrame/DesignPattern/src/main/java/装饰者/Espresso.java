package 装饰者;

public class Espresso extends Berverage{
	
	public Espresso(){
		description = "Espresso";
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return 1.99;
	}

}
