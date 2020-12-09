package 命令模式;

/**
 * 实现一个开灯关灯的命令
 * @author Administrator
 *
 */
public class LightOnCommand implements Command{
	
	Light light;
	
	public LightOnCommand(Light light){
		this.light = light;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		light.on();
	}

	@Override
	public void undo() {
		light.off();
		
	}

}
