package 样例1;

public class BusinessImplProxy implements Business {

	private BusinessImp bi;
	@Override
	public void doAction() {
		if(bi == null){
			bi = new BusinessImp();
		}
		
		before();
		bi.doAction();
		after();
	}
	
	public void after(){
		System.out.println("后置通知");
	}
	
	public void before(){
		System.out.println("前置通知");
	}
	
	public static void main(String[] args) {
		 Business bi = new BusinessImplProxy();
	     bi.doAction();
	}
}
