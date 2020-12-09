package 装饰者;
/**
 * 摩卡是一个装饰者,它扩展CondimentDecorator
 * @author Administrator
 *
 */
public class Mocha extends CondimentDecorator{
	
	Berverage berverage;
	
	public Mocha(Berverage berverage){
		this.berverage = berverage;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return berverage.getDescription() + ",Mocha";
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return berverage.cost() +0.51;
	}

}
