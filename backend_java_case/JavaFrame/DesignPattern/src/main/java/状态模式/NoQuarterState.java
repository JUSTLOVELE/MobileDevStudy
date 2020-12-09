package 状态模式;

public class NoQuarterState implements State{
	
	GumballMachine gumballMachine;
	
	public NoQuarterState(GumballMachine gumballMachine){
		
		this.gumballMachine = gumballMachine;
	}

	@Override
	public void insertQuarter() {
		
		System.out.println(" you can't insert another quarter");
	}

	@Override
	public void ejectQuarter() {
		
		System.out.println("Quarter returned");
		gumballMachine.setState(gumballMachine.getNoQuarterState());
	}

	@Override
	public void turnCrank() {
		
		System.out.println("You turned");
		gumballMachine.setState(gumballMachine.getSoldOutState());
	}

	@Override
	public void dispense() {
		
		System.out.println("No gumball dispensed");
	}

}
