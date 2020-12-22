package book.chapter02.sync;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yangzl 2020.12.22
 * @version 1.00.00
 * @Description:
 * @history:
 */
public class AtomicIntegerTest extends Thread {


    private AtomicInteger count = new AtomicInteger(0);

    @Override
    public void run() {

        for(int i=0; i<10000; i++) {
            System.out.println(count.incrementAndGet());
        }
    }

    public static void main(String[] args) {

        AtomicIntegerTest atomicIntegerTest = new AtomicIntegerTest();
        Thread a1 = new Thread(atomicIntegerTest);
        a1.start();
        Thread a2 = new Thread(atomicIntegerTest);
        a2.start();
        Thread a3 = new Thread(atomicIntegerTest);
        a3.start();
    }
}
