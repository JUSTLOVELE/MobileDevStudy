package lock;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MyThread05A extends Thread{
    private LockCase05 myservice;
    public MyThread05A(LockCase05 myservice){
        super();
        this.myservice = myservice;
    }

    public void run(){
        for(int i=0; i<Integer.MAX_VALUE; i++){
            myservice.set();
        }
    }
}

class MyThread05B extends Thread{
    private LockCase05 myservice;
    public MyThread05B(LockCase05 myservice){
        super();
        this.myservice = myservice;
    }

    public void run(){
        for(int i=0; i<Integer.MAX_VALUE; i++){
            myservice.get();
        }
    }
}

public class LockCase05 {

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private boolean hasValue = false;

    public void set(){
        try {
            lock.lock();
            while(hasValue == true){
                condition.await();
            }
            System.out.println("打印:BBBB");
            hasValue = true;
            condition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

    public void get(){
        try {
            lock.lock();
            while(hasValue == false){
                condition.await();
            }
            System.out.println("打印:AAAA");
            hasValue = false;
            condition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        LockCase05 myService = new LockCase05();
        MyThread05A a = new MyThread05A(myService);
        a.start();
        MyThread05B b = new MyThread05B(myService);
        b.start();
    }
}
