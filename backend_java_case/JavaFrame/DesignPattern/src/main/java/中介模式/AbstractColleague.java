package 中介模式;

public abstract class AbstractColleague {
	
	protected int number;
	
	public int getNumber(){
		
		return number;
	}
	
	public void setNumber(int number){
		
		this.number = number;
	}
	//这里是一个中介者
	public abstract void setNumber(int number, AbstractMediator am);

}
