package book.chapter01;

/**
 * @author yangzl 2020.12.01
 * @version 1.00.00
 * @Description:
 * @history:
 */

class Priority01 extends Thread {

    @Override
    public void run() {

        System.out.println("线程1的优先级:" + this.getPriority());
        Priority02 t = new Priority02();
        t.start();
    }
}

class Priority02 extends Thread {

    @Override
    public void run() {
        System.out.println("线程2的优先级:" + this.getPriority());
    }
}


public class ThreadPriority {

    public static void main(String[] args) {
        //默认优先级都是5,但是高优先级的线程不一定先全部执行完,通常是大部分先执行完
        System.out.println("主线程的优先级:" + Thread.currentThread().getPriority());
        Thread.currentThread().setPriority(6);
        Priority01 thread = new Priority01();
        thread.start();
    }
}
