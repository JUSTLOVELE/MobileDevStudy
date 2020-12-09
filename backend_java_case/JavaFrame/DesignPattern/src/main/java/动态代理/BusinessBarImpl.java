package 动态代理;

public class BusinessBarImpl implements BusinessBar{

	@Override
	public String bar(String message) {
		System.out.println("BusinessBarImpl.bar()");
		return message;
	}
}
