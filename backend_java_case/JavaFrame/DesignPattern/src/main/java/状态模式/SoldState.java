package 状态模式;

public class SoldState implements State{
	
    GumballMachine gumballMachine;
	
	public SoldState(GumballMachine gumballMachine){
		
		this.gumballMachine = gumballMachine;
	}

	@Override
	public void insertQuarter() {
		
		System.out.println("pelase wait, we're already giving you a gumball");
	}

	@Override
	public void ejectQuarter() {
		
		System.out.println("sorry you already turned the crank");
	}

	@Override
	public void turnCrank() {
		
		System.out.println("Turning twice dosen't get you another gumball !");
	}

	@Override
	public void dispense() {
		
		gumballMachine.releaseBall();
		
		if(gumballMachine.getCout() > 0){
			
			gumballMachine.setState(gumballMachine.getNoQuarterState());
		}else{
			
			System.out.println("Oops, out of gumballs !");
			gumballMachine.setState(gumballMachine.getSoldOutState());
		}
	}

}
