package 责任链模式;

/**
 * 客户端创建了两个处理者对象,并制定第一个处理者对象的下家是第二个处理者对象,
 * 而第二个处理者对象没有下家,然后客户端将请求传递给第一个处理者对象
 * @author yangzuliang
 *
 */
public class Client {
	
	public static void main(String[] args) {
		//组装责任链
		Handler handler1 = new ConcreteHandler();
		Handler handler2 = new ConcreteHandler();
		handler1.setSuccessor(handler2);
		//提交请求
		handler1.handleRequest();
	}

}
