package 命令模式;

/**
 * 测试类
 * @author Administrator
 *
 */
public class RemoteControlTest {
	
	public static void main(String[] args) {
		SimpleRemoteControl remote = new SimpleRemoteControl();
		Light light = new Light();
		LightOnCommand lightOn = new LightOnCommand(light);
		remote.setCommand(lightOn);
		remote.buttonWasPressed();
	}

}
