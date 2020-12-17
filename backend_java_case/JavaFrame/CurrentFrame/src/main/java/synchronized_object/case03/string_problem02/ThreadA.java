package synchronized_object.case03.string_problem02;

public class ThreadA extends Thread{

	private Service service;
	public ThreadA(Service service){
		super();
		this.service = service;
	}
	
	public void run(){
		service.print(new Object());
	}
}
