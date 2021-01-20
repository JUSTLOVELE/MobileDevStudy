package lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yangzl 2020.01.20
 * @version 1.00.00
 * @Description:程序运行后会出现异常这是正常的
 * @history:
 */

class MyThread08 extends Thread {

    private LockCase08 service;

    public MyThread08(LockCase08 service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.testMethod();
    }
}



public class LockCase08 {

    private ReentrantLock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    public void testMethod() {

        try{

            lock.lock();
            System.out.println("wait begin");
            condition.await();
            System.out.println("wait end");

        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {

        try{

            LockCase08 service = new LockCase08();
            MyThread08 myThread = new MyThread08(service);
            myThread.start();
            Thread.sleep(3000);
            myThread.interrupt();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
