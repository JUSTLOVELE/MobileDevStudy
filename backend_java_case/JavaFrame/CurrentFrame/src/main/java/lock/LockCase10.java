package lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yangzl 2021.01.22
 * @version 1.00.00
 * @Description:
 * @history:
 */

class F {
    volatile public static int nextPrintWho = 1;
}


public class LockCase10 {

    volatile public static int nextPrintWho = 1;

    private static ReentrantLock lock = new ReentrantLock();

    final private static Condition conditionA = lock.newCondition();

    final private static Condition conditionB = lock.newCondition();

    final private static Condition conditionC = lock.newCondition();

    public static void main(String[] args) {

        Thread threadA = new Thread() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    while(nextPrintWho != 1) {
                        conditionA.await();
                    }
                    for(int i=0; i<3; i++) {
                        System.out.println("Thread " + (i+1));
                    }
                    nextPrintWho = 2;
                    conditionB.signalAll();
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        };

        Thread threadB = new Thread() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    while(nextPrintWho != 2) {
                        conditionA.await();
                    }
                    for(int i=0; i<3; i++) {
                        System.out.println("Thread " + (i+1));
                    }
                    nextPrintWho = 3;
                    conditionB.signalAll();
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        };

        Thread threadC = new Thread() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    while(nextPrintWho != 3) {
                        conditionA.await();
                    }
                    for(int i=0; i<3; i++) {
                        System.out.println("Thread " + (i+1));
                    }
                    nextPrintWho = 1;
                    conditionB.signalAll();
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        };

        Thread[] aArray = new Thread[5];
        Thread[] bArray = new Thread[5];
        Thread[] cArray = new Thread[5];

        for(int i=0; i<5; i++) {

            aArray[i] = new Thread(threadA);
            bArray[i] = new Thread(threadB);
            cArray[i] = new Thread(threadC);
            aArray[i].start();
            bArray[i].start();
            cArray[i].start();
        }
     }
}
