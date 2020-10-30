package lock;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Thread03A extends Thread{

    private LockCase03 service;

    public Thread03A(LockCase03 service){
        super();
        this.service = service;
    }

    public void run(){
        service.await();
    }
}

public class LockCase03 {


    private Lock lock = new ReentrantLock();
    public Condition condition = lock.newCondition();

    public void await(){
        try {
            lock.lock();
            System.out.println(" await时间为" + System.currentTimeMillis());
            condition.await();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

    public void signal(){
        try {
            lock.lock();
            System.out.println("signal时间为" + System.currentTimeMillis());
            condition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        LockCase03 service = new LockCase03();
        Thread03A a = new Thread03A(service);
        a.start();
        Thread.sleep(3000);
        service.signal();
    }
}
