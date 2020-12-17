package synchronized_object.case08;

public class ThreadA extends Thread{

    public void run(){
        Service.printA();
    }

}