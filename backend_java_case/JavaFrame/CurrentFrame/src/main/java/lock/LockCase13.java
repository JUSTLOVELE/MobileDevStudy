package lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author yangzl 2021.01.27
 * @version 1.00.00
 * @Description:
 * @history:
 */
public class LockCase13 {


    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void read() {
        try {

            try {
                lock.readLock().lock();
                System.out.println("get read lock" + Thread.currentThread().getName() + " " + System.currentTimeMillis());
            }finally {
                lock.readLock().unlock();
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void write() {
        try {

            try {
                lock.writeLock().lock();
                System.out.println("get write lock" + Thread.currentThread().getName() + " " + System.currentTimeMillis());
                Thread.sleep(10000);
            }finally {
                lock.writeLock().unlock();
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        LockCase13 service = new LockCase13();
        Case13ThreadB b = new Case13ThreadB(service);
        b.setName("B");
        b.start();
        Thread.sleep(1000);
        Case13ThreadA a = new Case13ThreadA(service);
        a.setName("A");
        a.start();
    }
}

class Case13ThreadA extends Thread {

    private LockCase13 lockCase13;

    public Case13ThreadA(LockCase13 service) {
        this.lockCase13 = service;
    }

    @Override
    public void run() {
        lockCase13.read();
    }
}

class Case13ThreadB extends Thread {

    private LockCase13 lockCase13;

    public Case13ThreadB(LockCase13 service) {
        this.lockCase13 = service;
    }

    @Override
    public void run() {
        lockCase13.read();
    }
}