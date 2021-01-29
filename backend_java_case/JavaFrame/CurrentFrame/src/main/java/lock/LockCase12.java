package lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author yangzl 2020.01.28
 * @version 1.00.00
 * @Description:
 * @history:
 */
public class LockCase12 {

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

    public static void main(String[] args) {

        LockCase12 service = new LockCase12();
        Case12ThreadA a = new Case12ThreadA(service);
        a.setName("A");
        a.start();
        Case12ThreadB b = new Case12ThreadB(service);
        b.setName("B");
        b.start();
    }
}


class Case12ThreadA extends Thread {

    private LockCase12 lockCase12;

    public Case12ThreadA(LockCase12 service) {
        this.lockCase12 = service;
    }

    @Override
    public void run() {
        lockCase12.read();
    }
}

class Case12ThreadB extends Thread {

    private LockCase12 lockCase12;

    public Case12ThreadB(LockCase12 service) {
        this.lockCase12 = service;
    }

    @Override
    public void run() {
        lockCase12.read();
    }
}