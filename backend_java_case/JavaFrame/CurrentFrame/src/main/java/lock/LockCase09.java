package lock;

import java.util.Calendar;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yangzl 2020.01.20
 * @version 1.00.00
 * @Description:
 * @history:
 */

class MyThreadA_09 extends Thread {

    private LockCase09 service;

    public MyThreadA_09(LockCase09 service){
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.waitMethod();
    }
}

class MyThreadB_09 extends Thread {

    private LockCase09 service;

    public MyThreadB_09(LockCase09 service){
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.waitMethod();
    }
}

public class LockCase09 {

    private ReentrantLock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    public void waitMethod() {

        try{

            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.SECOND, 10);
            lock.lock();
            System.out.println("wait begin timer=" + System.currentTimeMillis());
            condition.awaitUntil(calendar.getTime());
            System.out.println("wait end timer = " + System.currentTimeMillis());
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void notifyMethod() {

        try{

            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.SECOND, 10);
            lock.lock();
            System.out.println("wait begin timer=" + System.currentTimeMillis());
            condition.signalAll();
            System.out.println("wait end timer = " + System.currentTimeMillis());
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {

        try{
            //        LockCase09 service = new LockCase09();
//        MyThreadA_09 myThreadA_09 = new MyThreadA_09(service);
//        myThreadA_09.start();
            LockCase09 service = new LockCase09();
            MyThreadA_09 myThreadA_09 = new MyThreadA_09(service);
            myThreadA_09.start();
            Thread.sleep(2000);
            MyThreadB_09 myThreadB_09 = new MyThreadB_09(service);
            myThreadB_09.start();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
