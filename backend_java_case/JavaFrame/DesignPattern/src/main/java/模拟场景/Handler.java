package 模拟场景;

/**
 * 抽象处理者角色
 * @author yangzuliang
 *
 */
public abstract class Handler {
	//持有后继的责任对象
	protected Handler successor = null;
	
	/**
	 * 处理聚餐费用的申请
	 * @param user 申请人
	 * @param fee 申请的钱
	 * @return 成功或失败的具体通知
	 */
	public abstract String handleFeeRequest(String user , double fee);
	
	public Handler getSuccessor(){
		
		return successor;
	}
	
	public void setSuccessor(Handler successor){
		
		this.successor = successor;
	}

}
