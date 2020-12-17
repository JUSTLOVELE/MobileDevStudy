package synchronized_object.case13;


/**
 * Class锁可以对类的所有对象实例起作用
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

        Service service1= new Service();
        Service service2= new Service();


        ThreadA a = new ThreadA(service1);
        a.setName("A");
        a.start();
        ThreadB b = new ThreadB(service2);
        b.setName("B");
        b.start();
    }

}

