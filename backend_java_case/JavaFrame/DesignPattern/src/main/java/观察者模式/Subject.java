package 观察者模式;

/**
 * 主题接口
 * @author Administrator
 *
 */
public interface Subject {
	//注册为主题
	public void registerObserver(Observer o);
	//移除观察者
	public void removeObserver(Observer o);
	//通知所有观察者
	public void notifyObserver();
	

}
