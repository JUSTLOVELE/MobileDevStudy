package 命令模式;

public class GarageDoorOpenCommand implements Command{
	
	GarageDoor garageDoor;

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		garageDoor.lightOn();
	}
	
	public void setCommand(GarageDoor garageDoor){
		this.garageDoor = garageDoor;
	}

	@Override
	public void undo() {
		garageDoor.lightOff();
		
	}

}
