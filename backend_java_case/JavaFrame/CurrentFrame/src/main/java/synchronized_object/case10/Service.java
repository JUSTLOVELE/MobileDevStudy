package synchronized_object.case10;

public class Service {

    Object object1 = new Object();

    public void methodA() {

        synchronized (object1) {
            System.out.println("methodA begin");
            boolean isContinueRun = true;
            while (isContinueRun) {
            }
            System.out.println("methodA end");
        }
    }

    Object object2 = new Object();
    public void methodB() {

        synchronized(object2){
            System.out.println("mehtodB begin");
            System.out.println("methodB end");
        }

    }

    /**
     *解决case09中的死锁问题
     *
     * @param args
     */
    public static void main(String[] args) {
        Service service = new Service();
        ThreadA athead = new ThreadA(service);
        athead.start();
        ThreadB bThreadB = new ThreadB(service);
        bThreadB.start();
    }

}

