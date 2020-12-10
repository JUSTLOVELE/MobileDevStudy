package synchronized_object.case01;

class MyObject {

    public synchronized void methodA() {

        try {

            System.out.println(Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("end");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void methodB() {

        try {

            System.out.println("B:" + Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("end B");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Case01ThreadA extends Thread {

    private MyObject object;

    public Case01ThreadA(MyObject object) {
        super();
        this.object = object;
    }

    @Override
    public void run() {
        super.run();
        object.methodA();
    }
}

class Case01ThreadB extends Thread {

    private MyObject object;

    public Case01ThreadB(MyObject object) {
        super();
        this.object = object;
    }

    @Override
    public void run() {
        super.run();
        object.methodB();
    }
}

/**
 * 共线对象
 */
public class Case01Thread {

    /**
     * A和B一定是按顺序调用的
     * @param args
     */
    public static void main(String[] args) {
        
        MyObject object = new MyObject();
        Case01ThreadA a = new Case01ThreadA(object);
        Case01ThreadB b = new Case01ThreadB(object);
        a.setName("A");
        b.setName("B");
        a.start();
        b.start();
    }
}
