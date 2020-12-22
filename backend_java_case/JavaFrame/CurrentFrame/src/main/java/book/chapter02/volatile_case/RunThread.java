package book.chapter02.volatile_case;

/**
 * @author yangzl 2020.12.21
 * @version 1.00.00
 * @Description:
 * @history:
 */
public class RunThread extends Thread {

    /**
     * volatile的主要作用就是当线程访问isRuning这个变量时强制从公共堆栈中取值(当加上该修饰符该值就会被强制弄到主内存中)
     * 使用volatile增加了实例变量在多个线程之间的可见性，但其关键字最致命的缺点是不支持原子性
     */
    volatile private boolean isRunning = true;

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    @Override
    public void run() {

        System.out.println("run method");

        while (isRunning == true) {

        }

        System.out.println("run method end");
    }

    public static void main(String[] args) {

        try {

            RunThread run = new RunThread();
            run.start();
            Thread.sleep(1000);
            run.setRunning(false);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
