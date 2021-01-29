package lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author yangzl 2021.01.25
 * @version 1.00.00
 * @Description:
 * @history:
 */

/**
 * ReentrantLock具有完全互斥排他的效果,即同一时间只有一个线程在执行ReentrantLock.lock()方法后面的任务。
 * 这样做虽然保证了实例变量的线程安全性,但效率却是非常低下的，所以在JDK中提供了一种读写锁ReentrantReadWriteLock类,
 * 使用它可以加快运行效率,在某些不需要操作实例变量的方法中，完全可以使用读写锁ReentrantReadWriteLock来提升方法的代码运行速度。
 * 读写锁表示也有两个锁,一个是读操作相关的锁,也称为共享锁;另一个是写操作相关的锁,也叫排他锁。也就是多个读锁之间不互斥，读锁
 * 与写锁互斥，写锁与写锁互斥。在没有线程Thread进行写入操作时，进行读取操作的多个Thread都可以获取读锁，而进行写入操作的
 * Thread只有在获取写锁后才能进行写入操作。即多个Thread可以同时进行读取操作。但是同一时刻只允许一个Thread进行写入操作
 */



public class LockCase11 {

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void read() {

        try{
            try{
                lock.readLock().lock();
                System.out.println("get read lock" + Thread.currentThread().getName() + " " + System.currentTimeMillis());
            }finally {
                lock.readLock().unlock();
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        LockCase11 service = new LockCase11();
        Case11ThreadA a = new Case11ThreadA(service);
        a.setName("A");
        Case11ThreadB b = new Case11ThreadB(service);
        b.setName("B");
        a.start();
        b.start();
    }
}

class Case11ThreadA extends Thread {

    private LockCase11 lockCase11;

    public Case11ThreadA(LockCase11 service) {
        this.lockCase11 = service;
    }

    @Override
    public void run() {
        lockCase11.read();
    }
}

class Case11ThreadB extends Thread {

    private LockCase11 lockCase11;

    public Case11ThreadB(LockCase11 service) {
        this.lockCase11 = service;
    }

    @Override
    public void run() {
        lockCase11.read();
    }
}