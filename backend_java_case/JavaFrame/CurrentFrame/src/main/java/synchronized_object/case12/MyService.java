package synchronized_object.case12;


/**
 * 锁对象的改变
 * 在将任何数据类型作为同步锁时,需要注意的是,是否有多个线程同时持有锁对象,如果同时持有相同的锁对象,
 * 则这些线程之间就是同步的;如果分别获得锁对象,这些线程之间就是异步的
 * @author yangzuliang
 *
 */
public class MyService {

    private String lock = "123";


    public static void main(String[] args) throws InterruptedException {
        MyService service = new MyService();
        ThreadA a = new ThreadA(service);
        a.setName("A");
        ThreadB b = new ThreadB(service);
        b.setName("B");
        a.start();
        Thread.sleep(50);
        b.start();
    }

    public void testMethod(){
        try {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + " begin " + System.currentTimeMillis());
                lock ="456";
                Thread.sleep(200);
                System.out.println(Thread.currentThread().getName() + " end " + System.currentTimeMillis());
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

}