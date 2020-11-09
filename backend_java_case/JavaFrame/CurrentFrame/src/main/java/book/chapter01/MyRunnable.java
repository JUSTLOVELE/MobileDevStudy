package book.chapter01;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("MyRunnable");
    }

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
        System.out.println("运行结束!");
    }
}
