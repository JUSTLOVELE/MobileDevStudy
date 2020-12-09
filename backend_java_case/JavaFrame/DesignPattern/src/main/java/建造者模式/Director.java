package 建造者模式;

/**
 * 建造者
 * @author yangzuliang
 *
 */
public class Director {
	
	private Builder builder;
	
	public Director(Builder builder){
		
		this.builder = builder;
	}
	
	public Car construct(){
		
		builder.buildFrame();
		builder.buildSeat();
		builder.buildTire();
		return builder.createCar();
	}
}
