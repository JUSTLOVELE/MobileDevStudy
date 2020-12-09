package 责任链模式;

/**
 * 具体处理者角色
 * @author yangzuliang
 *
 */
public class ConcreteHandler extends Handler{

	/**
	 * 判断是否有后继的责任对象
	 * 如果有,就转发请求给后继的责任对象
	 * 如果没有,则处理请求
	 */
	@Override
	public void handleRequest() {
		
		if(getSuccessor() != null){
			
			System.out.println("放过请求");
			getSuccessor().handleRequest();
		}else{
			System.out.println("处理请求");
		}
	}

}
