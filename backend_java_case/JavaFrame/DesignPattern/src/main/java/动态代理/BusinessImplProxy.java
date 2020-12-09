package 动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 借助于JVM的支持，可以在运行时动态生成代理类（“代理角色”），我们就可以解决上述代理模式中代码膨胀的问题，
 * 使用了动态代理后，“代理角色”将不用手动生成，而由JVM在运行时，通过指定类加载器、接口数组、调用处理程序这3个参数来动态生成
 * @author yangzuliang
 *
 */
public class BusinessImplProxy implements InvocationHandler {

	private Object obj;

	public BusinessImplProxy() {
	}

	public BusinessImplProxy(Object obj) {
		this.obj = obj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = null;
		doBefore();
		result = method.invoke(result, args);
		doAfter();
		return result;
	}

	public void doBefore() {
		System.out.println("do something before Business Logic");
	}

	public void doAfter() {
		System.out.println("do something after Business Logic");
	}
	
	public static Object factory(Object obj){
		Class cls = obj.getClass();
		return Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), new BusinessImplProxy(obj));
	}
}
