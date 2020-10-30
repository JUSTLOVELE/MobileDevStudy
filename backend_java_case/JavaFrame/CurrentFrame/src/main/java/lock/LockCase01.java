package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


class MyThread extends Thread {
    
    private LockCase01 service;

    public MyThread(LockCase01 service) {

        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.testMethod();
    }
}

public class LockCase01 {

    private Lock lock = new ReentrantLock();

    public void testMethod() {

        lock.lock();

        for(int i=0; i<5; i++) {
            System.out.println("ThreadName=" + Thread.currentThread().getName() + " " + (i++));
        }
        lock.unlock();
    }

    public static void main(String[] args) {
        
        LockCase01 service = new LockCase01();
        MyThread a1 = new MyThread(service);
        MyThread a2 = new MyThread(service);
        MyThread a3 = new MyThread(service);
        MyThread a4 = new MyThread(service);
        MyThread a5 = new MyThread(service);

        a1.start();
        a2.start();
        a3.start();
        a4.start();
        a5.start();

    }
    
}
