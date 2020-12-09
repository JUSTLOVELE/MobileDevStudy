package 观察者模式;

/**
 * 目前状况布告板
 * @author Administrator
 *
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {
	
	private float temperature;
	
	private float humidity;
	
	private Subject wetherData;
	
	public CurrentConditionsDisplay(Subject wetherData){
		this.wetherData = wetherData;
		wetherData.registerObserver(this);
	}

	@Override
	public void display() {
		System.out.println("CurrentConditionsDisplay : temperature = " + temperature + ",humidity = " + humidity );
	}

	@Override
	public void update(float temp, float humidity, float pressure) {
		
		this.temperature = temp;
		
		this.humidity = humidity;
		
		display();
		
	}

}
