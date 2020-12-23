package book.chapter03.notify.case01;

/**
 * @author yangzl 2020.12.23
 * @version 1.00.00
 * @Description:
 * @history:
 */
public class MyThread1 extends Thread{

    private Object lock;

    public MyThread1(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {

        try {

            synchronized (lock) {

                System.out.println("开始  wait time = " + System.currentTimeMillis());
                lock.wait();
                System.out.println("结束 wait time = " + System.currentTimeMillis());
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
