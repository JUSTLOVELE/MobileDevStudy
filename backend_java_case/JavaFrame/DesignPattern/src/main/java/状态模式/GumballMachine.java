package 状态模式;

public class GumballMachine {
	
	State soldOutState;
	
	State noQuarterState;
	
	State hasQuarterState;
	
	State soldState;
	
	State state = soldOutState;
	
	int cout = 0;
	
	public GumballMachine(int numberGumballs){
		
		hasQuarterState = new HasQuarterState(this);
		noQuarterState = new NoQuarterState(this);
		soldState = new SoldState(this);
	}
	
	public void insertQuarter(){
		
		state.insertQuarter();
	}
	
	public void ejectQuarter(){
		
		state.ejectQuarter();
	}
	
	public void turnCrank(){
		
		state.turnCrank();
	}
	
	public void dispense(){
		
		state.dispense();
	}
	
	void releaseBall(){
		
		System.out.println("A gumball comes rolling out the slot...");
		
		if(cout != 0){
			 
			cout = cout -1;
		}
	}
	
	void setState(State state){
		
		this.state = state;
	}

	public State getSoldOutState() {
		return soldOutState;
	}

	public State getNoQuarterState() {
		return noQuarterState;
	}

	public State getHasQuarterState() {
		return hasQuarterState;
	}

	public State getSoldState() {
		return soldState;
	}

	public int getCout() {
		return cout;
	}
}
