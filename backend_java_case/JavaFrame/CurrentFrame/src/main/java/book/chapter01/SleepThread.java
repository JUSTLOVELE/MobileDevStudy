package book.chapter01;


import org.junit.Test;

class MySleepThread extends Thread {

    @Override
    public void run() {
        super.run();
        try{

            System.out.println("run begin");
            Thread.sleep(200000);
            System.out.println("run end");

        }catch (Exception e) {
            System.out.println("被停止");
            e.printStackTrace();
        }
    }
}

public class SleepThread {

    @Test
    public void case01() {

        try {
            MySleepThread sleepThread = new MySleepThread();
            sleepThread.start();
            Thread.sleep(200);
            sleepThread.interrupt();
        }catch (Exception e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
    }
}
