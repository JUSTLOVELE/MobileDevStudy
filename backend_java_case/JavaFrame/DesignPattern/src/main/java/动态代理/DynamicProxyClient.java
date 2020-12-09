package 动态代理;

public class DynamicProxyClient {

	public static void main(String[] args) {
		
		BusinessBarImpl bfoo = new BusinessBarImpl();
		BusinessFoo bf = (BusinessFoo) BusinessImplProxy.factory(bfoo);
		bf.foo();
		System.out.println("----------");
		BusinessBarImpl bbar = new BusinessBarImpl();
        BusinessBar bb = (BusinessBar)BusinessImplProxy.factory(bbar);
        String message = bb.bar("Hello,World");
        System.out.println(message);
	}
}
