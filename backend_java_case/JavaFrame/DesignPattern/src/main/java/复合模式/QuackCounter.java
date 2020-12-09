package 复合模式;

public class QuackCounter implements Quackable {
	
	Quackable duck;
	
	static int numberOfQuacks;
	
	public QuackCounter(Quackable duck){
		this.duck = duck;
	}

	@Override
	public void quack() {
		// TODO Auto-generated method stub
        duck.quack();
        numberOfQuacks++;
	}
	
	public static int getQuacks(){
		return numberOfQuacks;
	}

}
