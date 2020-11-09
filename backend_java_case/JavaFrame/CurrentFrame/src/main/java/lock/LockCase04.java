package lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockCase04 {

    private Lock lock = new ReentrantLock();
    //newCondition能为多个线程提供不同的condition
    private Condition condition = lock.newCondition();
    public void awaitA(){
        try {
            lock.lock();
            System.out.println("begin awaitA 时间为" + System.currentTimeMillis()
                    + "ThreadName = " + Thread.currentThread().getName());
            condition.await();
            System.out.println(" end awaitA时间为" + System.currentTimeMillis()
                    + " ThreadName = " + Thread.currentThread().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

    public void awaitB(){
        try {
            lock.lock();
            System.out.println("begin awaitB 时间为" + System.currentTimeMillis()
                    + " ThreadName = " + Thread.currentThread().getName());
            condition.await();
            System.out.println(" end awaitB时间为" + System.currentTimeMillis()
                    + "ThreadName = " + Thread.currentThread().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

    public void signalAll(){
        try {
            lock.lock();
            System.out.println(" signalAll时间为" + System.currentTimeMillis()
                    + " ThreadName = " + Thread.currentThread().getName());

            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        LockCase04 service = new LockCase04();
        Thread04A a = new Thread04A(service);
        a.setName("A");
        a.start();
        Thread04B b = new Thread04B(service);
        b.setName("B");
        b.start();
        Thread.sleep(3000);
        //A、B线程await的时间不一致,但是end的时间是一致的
        service.signalAll();
    }
}

class Thread04A extends Thread{
    private LockCase04 service;
    public Thread04A(LockCase04 service){
        super();
        this.service = service;
    }
    public void run(){
        service.awaitA();
    }
}

class Thread04B extends Thread{
    private LockCase04 service;
    public Thread04B(LockCase04 service){
        super();
        this.service = service;
    }
    public void run(){
        service.awaitB();
    }
}