package synchronized_object.case09_dead_thread;

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
