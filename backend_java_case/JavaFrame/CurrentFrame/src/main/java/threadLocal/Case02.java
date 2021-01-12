package threadLocal;


/**
 * @author yangzl 2020.01.12
 * @version 1.00.00
 * @Description:验证ThreadLocal的隔离性
 * @history:
 */

class ThreadB extends Thread {
    @Override
    public void run() {
        try{
            for(int i=0; i<100; i++) {
                Tools.t1.set("ThreadB" + (i+1));
                System.out.println("ThreadB get Value=" + Tools.t1.get());
                Thread.sleep(200);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ThreadA extends Thread {
    @Override
    public void run() {
        try{
            for(int i=0; i<100; i++) {
                Tools.t1.set("ThreadA" + (i+1));
                System.out.println("ThreadA get Value=" + Tools.t1.get());
                Thread.sleep(200);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/**
 * 虽然三个线程都同时向ThreadLocal设置数据,但是每个线程能取出自己的值
 */
public class Case02 {
    public static void main(String[] args) {
        try{

            ThreadA a = new ThreadA();
            ThreadB b = new ThreadB();
            a.start();
            b.start();

            for(int i=0; i<100; i++) {
                Tools.t1.set("main" + (i+1));
                System.out.println("Main get value = " + Tools.t1.get());
                Thread.sleep(200);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
