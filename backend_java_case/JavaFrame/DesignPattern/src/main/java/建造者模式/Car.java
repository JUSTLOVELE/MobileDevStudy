package 建造者模式;

/**
 * 产品
 * @author Administrator
 *
 */
public class Car {

	private String frame;
	
	private String seat;
	
	private String tire;
	
	public Car() {
		// TODO Auto-generated constructor stub
	}

	public String getFrame() {
		return frame;
	}

	public void setFrame(String frame) {
		this.frame = frame;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	public String getTire() {
		return tire;
	}

	public void setTire(String tire) {
		this.tire = tire;
	}
}
