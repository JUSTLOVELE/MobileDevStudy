package synchronized_object.case07;


/**
 * 对象监视器不同所以运行结果是异步的,或者说持有不同的对象监视器是异步的效果
 * @author yangzuliang
 *
 */
public class Service {

    private String anyString = new String();

    public synchronized void a(){
        try {
			/*synchronized(anyString){
				System.out.println("a begin");
				Thread.sleep(3000);
				System.out.println("a end");
			}*/
            System.out.println("a begin");
            Thread.sleep(3000);
            System.out.println("a end");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

	/*public  void a(){
		try {
			synchronized(anyString){
				System.out.println("a begin");
				Thread.sleep(3000);
				System.out.println("a end");
			}
			System.out.println("a begin");
			Thread.sleep(3000);
			System.out.println("a end");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}*/

    synchronized public void b(){
        System.out.println("b begin");
        System.out.println("b end");
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