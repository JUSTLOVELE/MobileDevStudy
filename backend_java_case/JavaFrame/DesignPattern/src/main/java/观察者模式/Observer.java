package 观察者模式;

/**
 * 观察者接口
 * @author Administrator
 *
 */
public interface Observer {
	
	public void update(float temp, float humidity, float pressure);

}
