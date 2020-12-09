package 适配器模式;

public class MallardDuck implements Duck{
	@Override
	public void quack() {
		System.out.println("Quack");
	}
	@Override
	public void fly() {
		System.out.println("i am flying");
	}
}
