package lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yangzl 2020.12.01
 * @version 1.00.00
 * @Description: 公平锁表示线程获取锁的顺序是按照线程枷锁的顺序来分配的(FIFO),非公平锁就是一种获取锁的抢占机制,是随机获得锁的
 * @Copyright:
 * @history:
 */
public class LockCase06 {

    private ReentrantLock lock;

    public LockCase06(boolean isFair){

        super();
        lock = new ReentrantLock(isFair);
    }

    public void serviceMethod(){
        try {
            lock.lock();
            System.out.println("ThreadName=" + Thread.currentThread().getName() + "获得锁定");
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        //runFair();
        runNotFair();
    }

    //不公平锁
    public static void runNotFair(){

        final LockCase06 service = new LockCase06(false);

        Runnable runnable = new Runnable(){

            @Override
            public void run() {
                System.out.println("1线程" + Thread.currentThread().getName());
                service.serviceMethod();
            }
        };

        Thread[] threadArray = new Thread[10];

        for(int i=0; i<10; i++){
            threadArray[i] = new Thread(runnable);
        }

        for(int i=0; i<10; i++){
            threadArray[i].start();
        }
    }

    /**
     * 公平锁
     */
    public static void runFair(){

        final LockCase06 service = new LockCase06(true);

        Runnable runnable = new Runnable(){

            @Override
            public void run() {
                System.out.println("1线程" + Thread.currentThread().getName());
                service.serviceMethod();
            }
        };

        Thread[] threadArray = new Thread[10];

        for(int i=0; i<10; i++){
            threadArray[i] = new Thread(runnable);
        }

        for(int i=0; i<10; i++){
            threadArray[i].start();
        }
    }
}
