package 适配器模式;

public class MallardTurkey implements Turkey{

	@Override
	public void gobble() {
		// TODO Auto-generated method stub
		System.out.println("i am MallardTurkey");
		
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("MallardTurkey Fly");
		
	}

}
