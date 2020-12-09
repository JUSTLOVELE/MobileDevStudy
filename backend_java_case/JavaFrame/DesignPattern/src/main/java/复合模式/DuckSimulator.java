package 复合模式;

public class DuckSimulator {
	
	public static void main(String[] args) {
		DuckSimulator simulator = new DuckSimulator();
		AbstractDuckFactory duckFactory = new CountingDuckFactory();
		simulator.simulator(duckFactory);
	}
	
	public void simulator(AbstractDuckFactory duckFactory){
		Flock flock = new Flock();
		Quackable mallardDuck = duckFactory.createMallardDuck();
		Quackable redheadDuck = duckFactory.createRedheadDuck();
		Quackable duckCall = duckFactory.createDuckCall();
		Quackable rubberDuck = duckFactory.createRubberDuck();
		Quackable gooseDuck = new QuackCounter(new GooseAdapter(new Goose()));
		flock.add(gooseDuck);
		flock.add(rubberDuck);
		flock.add(duckCall);
		flock.add(redheadDuck);
		flock.add(mallardDuck);
		System.out.println("\nDuck Simulator");
		simulator(flock);
		
	}
	
	public void simulator(Quackable duck){
		duck.quack();
	}

}
