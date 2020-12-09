package 适配器模式;
/**
 * 假设现在缺乏鸭子对象,想用一些火鸡对象来冒充,显然火鸡和鸭子的接口不同,不能公然拿来使用,那就写个适配器吧
 * @author Administrator
 *
 */
public class TurkeyAdapter implements Duck{//首先,需要实现转换成的类型接口,也就是你的客户所期望看的接口
	Turkey turkey;
	public TurkeyAdapter(Turkey turkey){//接着,需要取得要适配的对象引用,利用构造器获得
		this.turkey = turkey;
	}
	@Override
	public void quack() { //实现接口中的方法
		turkey.gobble();
	}
	@Override
	public void fly() {//鸭子和火鸡都能飞,但是火鸡飞行短
		for(int i=0; i<5; i++){
			turkey.fly();
		}
	}
}
