package synchronized_object.case09_dead_thread;
public class Service {

    synchronized public void methodA(){
        System.out.println("methodA begin");
        boolean isContinueRun = true;
        while(isContinueRun){
        }
        System.out.println("methodA end");
    }

    synchronized public void methodB(){
        System.out.println("mehtodB begin");
        System.out.println("methodB end");
    }

    /**
     * 死锁
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
