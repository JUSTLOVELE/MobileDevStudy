package 复合模式;

public class GooseAdapter implements Quackable {
	
	private Goose goose;
	
	public GooseAdapter(Goose goose){
		this.goose = goose;
	}

	@Override
	public void quack() {
		// TODO Auto-generated method stub
		goose.honk();
	}

}
