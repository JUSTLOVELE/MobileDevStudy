package 建造者模式;

public class ConcreteBuilder implements Builder{

	private Car car = new Car();
	
	@Override
	public void buildFrame() {
		// TODO Auto-generated method stub
		car.setFrame("frame");
	}

	@Override
	public void buildSeat() {
		// TODO Auto-generated method stub
		car.setSeat("seat");
	}

	@Override
	public void buildTire() {
		// TODO Auto-generated method stub
		car.setTire("tire");
	}

	@Override
	public Car createCar() {
		// TODO Auto-generated method stub
		return car;
	}
	
}
