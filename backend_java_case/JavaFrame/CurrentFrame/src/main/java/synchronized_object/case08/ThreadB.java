package synchronized_object.case08;

public class ThreadB extends Thread{

    public void run(){
        Service.printB();
    }

}

