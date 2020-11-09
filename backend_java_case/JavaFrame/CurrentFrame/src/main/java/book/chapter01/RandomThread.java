package book.chapter01;

public class RandomThread extends Thread{

    @Override
    public void run() {

        try {

            for(int i=0; i<10; i++) {
                int time = (int) (Math.random() * 1000);
                Thread.sleep(time);
                System.out.println("run=" + Thread.currentThread().getName());
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        try {

            RandomThread thread = new RandomThread();
            thread.setName("thread");
            thread.start();

            for(int i=0; i<10; i++) {
                int time = (int) (Math.random() * 1000);
                Thread.sleep(time);
                System.out.println("main=" + Thread.currentThread().getName());
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
