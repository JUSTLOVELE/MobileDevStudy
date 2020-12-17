package synchronized_object.case08;


/**
 * 静态同步synchronized方法和synchronized(class)代码块
 *    synchronized加到static静态方法上是给Class类上锁,而synchronized关键字
 * 加到非static静态方法上是给对象上锁的
 * @author yangzuliang
 *
 */
public class Service {

    synchronized public static void printA(){
        try {
            System.out.println("线程名称为:" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "进入PrintA");
            Thread.sleep(3000);
            System.out.println("线程名称为:" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "离开printA");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    synchronized public static void printB(){
        System.out.println("线程名称为:" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "进入PrintB");
        System.out.println("线程名称为:" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "离开printB");
    }

    public static void main(String[] args) {
        ThreadA a = new ThreadA();
        a.setName("A");
        a.start();
        ThreadB b = new ThreadB();
        b.setName("B");
        b.start();
    }

}