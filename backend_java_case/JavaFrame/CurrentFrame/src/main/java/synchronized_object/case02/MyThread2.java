package synchronized_object.case02;

public class MyThread2 extends Thread {

	private MyOneList list;
	
	public MyThread2(MyOneList list){
		super();
		this.list = list;
	}
	
	public void run(){
		MyService msRef = new MyService();
		msRef.addServiceMehtod(list, "B");
	}
}
