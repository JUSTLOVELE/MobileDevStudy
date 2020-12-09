package 命令模式;

/**
 * 
 * 命令接口
 * @author Administrator
 *
 */
public interface Command {
	
	public void execute();
	
	public void undo();

}
