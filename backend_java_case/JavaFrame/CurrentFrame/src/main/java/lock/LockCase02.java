package lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ThreadA extends Thread{

    private LockCase02 service;

    public ThreadA(LockCase02 service){
        super();
        this.service = service;
    }

    public void run(){
        service.await();
    }
}
/**
 *   Condition:使用它有更好的灵活性,比如可以实现多路通知功能,也就是在一个Lock对象里面可以创建多个Condition(即对象监视器)实例,
 *线程对象可以注册在指定的Condition中,从而可以有选择性的进行线程通知,在调度线程上更加灵活
 *   在使用notify()/notifyAll()方法进行通知时,被通知的线程却是由JVM随机选择的,但使用ReentrantLock结合Condition类是
 *可以实现前面介绍过的"选择性通知",这个功能是非常重要的,而且在Condition类中是默认提供的
 *   而synchronized就相当于整个Lock对象中只有一个单一的Condition对象,所有的线程都注册在它一个对象的身上,线程开始notifyAll()
 *时,需要通知所有的WAITING线程,没有选择权,会出现效率问题
 * @author yangzuliang
 *
 */
public class LockCase02 {

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    /**
     *   报错的异常信息是监视器出错,解决的办法是必须在condition.await()方法调用之前调用lock.lock()
     * 代码获得同步监视器
     */
    public void await(){
        try {

            condition.await();

			/*lock.lock();
			System.out.println("A");
			condition.await();
			System.out.println("B");*/
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            lock.unlock();
            System.out.println("锁释放了!");
        }
    }

    public static void main(String[] args) {

        LockCase02 service = new LockCase02();
        ThreadA threadA = new ThreadA(service);
        threadA.start();
    }
}
