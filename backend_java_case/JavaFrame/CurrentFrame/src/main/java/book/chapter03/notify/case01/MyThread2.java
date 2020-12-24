package book.chapter03.notify.case01;

/**
 * @author yangzl 2020.12.23
 * @version 1.00.00
 * @Description:
 * @history:
 */
public class MyThread2 extends Thread {

    private Object lock;

    public MyThread2(Object lock) {
        this.lock = lock;
    }

    /**
     * notify唤醒的线程如果被sync锁住,也是要等同步代码块顺序执行完的
     * 调用notify每次只随机通知一个线程进行唤醒,唤醒全部用notifyall
     */
    @Override
    public void run() {

        synchronized (lock) {

            System.out.println("开始  wait time = " + System.currentTimeMillis());
            lock.notify();
            System.out.println("结束 wait time = " + System.currentTimeMillis());
        }
    }

    public static void main(String[] args) {

        try{

            Object lock = new Object();
            MyThread1 t1 = new MyThread1(lock);
            t1.start();
            Thread.sleep(3000);
            MyThread2 t2 = new MyThread2(lock);
            t2.start();

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
