package synchronized_object.case06;


/**
 * synchronized同步方法:
 *  实验证明:
 * 对其他synchronized同步方法或synchronized(this)同步代码块调用呈阻塞状态
 * @author yangzuliang
 *
 */
public class Service {

    private String usernameParam;
    private String passwordParam;
    private String anyStirng = new String();
    public void setUsernamePassword(String username, String password){

        try {
            //使用同步代码块锁非this对象,则synchronized代码块中的程序与同步方法是异步的,不与其他锁this同步方法争抢this锁,大大提高运行效率
            //String testString = new String();
            //synchronized(testString){
            synchronized(anyStirng){
                System.out.println("线程名称为:" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "进入同步块");
                usernameParam = username;
                Thread.sleep(3000);
                passwordParam = password;
                System.out.println("线程名称为:" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "离开同步块");
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Service service = new Service();
        ThreadA a = new ThreadA(service);
        a.setName("A");
        a.start();
        ThreadB b = new ThreadB(service);
        b.setName("B");
        b.start();
    }


}
