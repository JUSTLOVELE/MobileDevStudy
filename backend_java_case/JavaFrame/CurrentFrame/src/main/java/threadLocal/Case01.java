package threadLocal;

/**
 * @author yangzl 2020.01.12
 * @version 1.00.00
 * @Description:
 * @history:
 */
public class Case01 {

    public static ThreadLocal t1 = new ThreadLocal();

    public static void main(String[] args) {

        if(t1.get() == null) {
            System.out.println("it is null");
            t1.set("my value");
        }

        System.out.println(t1.get());
        System.out.println(t1.get());
    }
}
