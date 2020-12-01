package lock;

import java.util.Calendar;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yangzl 2020.12.01
 * @version 1.00.00
 * @Description:
 * @Copyright:
 * @history:
 */
public class LockCase07 {

    private ReentrantLock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    public void waitMethod(){

        try {

            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.SECOND, 10);
            lock.lock();
            System.out.println("wait begin timer=" + System.currentTimeMillis());
            condition.awaitUntil(calendar.getTime());
            System.out.println("wait end timer=" + System.currentTimeMillis());
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

    public void notifyMethod(){

        try {

            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.SECOND, 10);
            lock.lock();
            System.out.println("notify begin timer=" + System.currentTimeMillis());
            condition.signalAll();
            System.out.println("notify end timer=" + System.currentTimeMillis());
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        LockCase07 service = new LockCase07();
        MyThreadA07 myThreadA07 = new MyThreadA07(service);
        myThreadA07.start();
        Thread.sleep(2000);
        MyThreadB07 myThreadB07 = new MyThreadB07(service);
        myThreadB07.start();
    }
}

class MyThreadB07 extends Thread{

    private LockCase07 service;

    public MyThreadB07(LockCase07 service){

        super();
        this.service = service;
    }

    public void run(){
        service.notifyMethod();
    }
}

class MyThreadA07 extends Thread{

    private LockCase07 service;

    public MyThreadA07(LockCase07 service){

        super();
        this.service = service;
    }

    public void run(){
        service.waitMethod();
    }
}