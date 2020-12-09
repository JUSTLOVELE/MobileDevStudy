package 装饰者;
/**
 * 基类
 * @author Administrator
 *
 */
public abstract class Berverage {
	
	String description = "Unknow Berverage";
	
	public String getDescription(){
		return description;
	}
	
	public abstract double cost();

}
