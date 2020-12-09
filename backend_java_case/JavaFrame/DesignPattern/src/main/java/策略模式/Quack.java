package 策略模式;

public class Quack implements QuackBehavior {

	@Override
	public void quack() {
		// TODO Auto-generated method stub
		System.out.println("鸭子叫");
	}

}
