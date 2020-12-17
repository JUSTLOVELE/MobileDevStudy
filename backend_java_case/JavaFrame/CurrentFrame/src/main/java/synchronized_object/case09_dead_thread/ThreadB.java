package synchronized_object.case09_dead_thread;

public class ThreadB extends Thread {

    private Service service;
    public ThreadB(Service service){
        super();
        this.service = service;
    }

    public void run(){
        service.methodB();
    }
}
