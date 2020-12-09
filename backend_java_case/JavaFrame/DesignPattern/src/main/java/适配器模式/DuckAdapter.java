package 适配器模式;

public class DuckAdapter implements Turkey{
	Duck duck;
	public DuckAdapter(Duck duck){
		this.duck= duck;
	}
	@Override
	public void gobble() {
		// TODO Auto-generated method stub
		duck.quack();
	}
	@Override
	public void fly() {
		// TODO Auto-generated method stub
		duck.fly();
		
	}

	

}
