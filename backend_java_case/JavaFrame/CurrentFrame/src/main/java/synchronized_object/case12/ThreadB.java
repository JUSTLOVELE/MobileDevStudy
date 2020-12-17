package synchronized_object.case12;

public class ThreadB extends Thread {

    private MyService service;
    public ThreadB(MyService service){
        super();
        this.service = service;
    }

    public void run(){
        service.testMethod();
    }
}
