package book.chapter01;

import org.junit.Test;

class MyThread extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println("我的线程");
    }
}

public class ThreadStudy {

    @Test
    public void getName() {
        System.out.println(Thread.currentThread().getName());
        MyThread thread = new MyThread();
        thread.start();
    }
}
