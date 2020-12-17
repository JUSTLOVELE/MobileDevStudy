package synchronized_object.case04;


/**
 * 两个线程分别访问同一个类的两个不同实例的相同名称的同步方法,效果却以异步的方式运行
 * @author yangzuliang
 *
 */
public class HasSelfPrivateNum {

    private int num = 0;

    /**
     * synchronized取得的锁都是对象锁,而不是把一段代码或方法当锁
     * 那个线程先执行带有synchronized关键字的方法,哪个线程就持有该方法所属对象的锁LOCK,
     * 那么其他线程只能呈等待状态,前提是多个线程访问的是同一个对象,但如果是多个线程访问多个对象,
     * 则JVM会创建多个锁
     * @param username
     */
    synchronized public void addI(String username){

        try {
            if(username.equals("a")){
                num = 100;
                System.out.println("a set over");
                Thread.sleep(2000);
            }else{
                num = 200;
                System.out.println("b set over");
            }
            System.out.println(username + "num = " + num);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        HasSelfPrivateNum numRef1 = new HasSelfPrivateNum();
        HasSelfPrivateNum numRef2 = new HasSelfPrivateNum();
        ThreadA athThread = new ThreadA(numRef1);
        athThread.start();
        ThreadB bThreadB = new ThreadB(numRef2);
        bThreadB.start();
    }
}
