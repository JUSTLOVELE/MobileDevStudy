package book.chapter02.sync;


/**
 * 脏读
 * @author yangzuliang
 *
 */
public class PublicVar {

    public String username = "A";
    public String password = "AA";

    public void setValue(String username, String password){

        try {

            this.username = username;
            Thread.sleep(5000);
            this.password = password;
            System.out.println("setValue method thread name = " + Thread.currentThread().getName() + " username = " + username + " password = " + password );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getValue() {

        System.out.println("getValue method thread name = "
                + Thread.currentThread().getName() + " username = " + username
                + " password = " + password
        );
    }

    public static void main(String[] args) {

        try {

            PublicVar publicVar = new PublicVar();
            ThreadA threadA = new ThreadA(publicVar);
            threadA.start();
            threadA.sleep(200);
            publicVar.getValue();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
