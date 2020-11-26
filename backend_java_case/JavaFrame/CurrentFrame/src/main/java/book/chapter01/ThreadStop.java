package book.chapter01;

import org.junit.Test;

class MyThreadStop extends Thread {
    @Override
    public void run() {
        super.run();
        for(int i=0; i<200; i++) {
            System.out.println("i=" + i);
        }
    }
}

/**
 * 这个线程是能中断停止的
 */
class MyThreadStop02 extends Thread {
    @Override
    public void run() {
        super.run();
        try{
            for(int i=0; i<100000; i++) {
                if(this.interrupted()) {
                    System.out.println("停止状态,退出");
                    //break;如果启动break不抛出异常,那么for循环外的代码其实还是会被执行到的,并没有退出线程
                    throw new InterruptedException();
                    //这里配合return也可以达到退出线程的效果
                    //return ;
                }
                System.out.println("i=" + i);
            }
            System.out.println("我只是结束了for其实还在运行哦");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class ThreadStop {

    /**
     * 调用了thread.interrupt();但是后面的代码还是执行了输出
     */
    @Test
    public void case01() {
        try {
            MyThreadStop thread = new MyThreadStop();
            thread.start();
            Thread.sleep(1000);
            thread.interrupt();
            System.out.println("是否停止1? = " + thread.interrupted());
            System.out.println("是否停止2? = " + thread.interrupted());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * interrupted具有清楚状态的功能，所以第二次调用的结果为false
     */
    @Test
    public void case02() {

        try{

            Thread.currentThread().interrupt();
            System.out.println("是否停止1? = " + Thread.interrupted());
            System.out.println("是否停止2? = " + Thread.interrupted());
            System.out.println("end");

        }catch (Exception e) {

        }
    }

    /**
     * isInterrupted不具备清除状态的功能
     */
    @Test
    public void case03() {
        try {
            MyThreadStop thread = new MyThreadStop();
            thread.start();
            Thread.sleep(1000);
            thread.interrupt();
            System.out.println("是否停止1? = " + thread.isInterrupted());
            System.out.println("是否停止2? = " + thread.isInterrupted());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void case04() {
        try {
            MyThreadStop02 thread = new MyThreadStop02();
            thread.start();
            Thread.currentThread().sleep(3);
            thread.interrupt();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
