package 建造者模式;

public interface Builder {
	
	void buildFrame();
	void buildSeat();
	void buildTire();
	Car createCar();

}
