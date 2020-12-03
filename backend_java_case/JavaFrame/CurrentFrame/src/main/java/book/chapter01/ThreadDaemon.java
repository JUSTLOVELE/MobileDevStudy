package book.chapter01;

/**
 * @author yangzl 2020.12.03
 * @version 1.00.00
 * @Description:
 * @history:
 */


class DaemonThread extends Thread {

    private int i=0;

    @Override
    public void run() {
        try{
            while (true) {
                i++;
                System.out.println("i=" +(i));
                Thread.sleep(1000);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}


public class ThreadDaemon {

    public static void main(String[] args) {

        try {
            DaemonThread t = new DaemonThread();
            t.setDaemon(true);
            t.start();
            Thread.sleep(5000);
            System.out.println("主线程退出，守护进程立刻消亡");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
