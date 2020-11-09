package book.chapter01;

/**
 * 不安全的线程
 */
public class MyThreadVariableAndSafe extends Thread {

    private int count = 5;
    //把变量改为静态虽然共享了变量,但是却引出了线程不安全的问题
    //    private static int count = 5;

    public MyThreadVariableAndSafe(String name) {
        super();
        this.setName(name);
    }

    @Override
    public void run() {
        super.run();
        while (count > 0) {
            count--;
            System.out.println("由 " + this.getName() + " 计算,count=" + count);
        }
    }

    public static void main(String[] args) {

//        MyThreadVariableAndSafe a = new MyThreadVariableAndSafe("A");
//        MyThreadVariableAndSafe b = new MyThreadVariableAndSafe("B");
//        MyThreadVariableAndSafe c = new MyThreadVariableAndSafe("C");
//        a.start();
//        b.start();
//        c.start();


        MyThreadVariableAndSafeSultion m = new MyThreadVariableAndSafeSultion();
        Thread d = new Thread(m, "D");
        Thread e = new Thread(m, "E");
        Thread f = new Thread(m, "f");
        Thread h = new Thread(m, "H");
        Thread g = new Thread(m, "G");
        d.start();
        e.start();
        f.start();
        h.start();
        g.start();
    }
}

//线程安全的类
class MyThreadVariableAndSafeSultion extends Thread {

    private int a = 5;

    @Override
    synchronized public void run() {
        super.run();
        a = a-1;
        System.out.println("由 " + this.getName() + " 计算,a=" + a);
    }
}