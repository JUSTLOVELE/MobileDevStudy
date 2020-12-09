package 中介模式;

public class ColleagueA extends AbstractColleague{

	@Override
	public void setNumber(int number, AbstractMediator am) {
		
		this.number = number;
		am.AaffectB();
	}

}
