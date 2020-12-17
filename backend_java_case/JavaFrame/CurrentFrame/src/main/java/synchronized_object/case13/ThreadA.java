package synchronized_object.case13;

public class ThreadA extends Thread{

    private Service service;
    public ThreadA(Service service){
        super();
        this.service = service;
    }

    public void run(){
        service.methodA();
    }
}
