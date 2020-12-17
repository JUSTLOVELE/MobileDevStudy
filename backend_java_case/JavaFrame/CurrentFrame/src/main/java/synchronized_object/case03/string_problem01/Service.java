package synchronized_object.case03.string_problem01;

public class Service {
	
	/**
	 * 打印的结果都是AA
	 * 这是因为String的两个值都是AA,两个线程持有相同的锁,所以造成B线程不能执行,这就是String常量池带来的问题
	 * @param stringParam
	 */
	public static void print(String stringParam){
		
		try {
			synchronized(stringParam){
				while(true){
					System.out.println(Thread.currentThread().getName());
					Thread.sleep(1000);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Service service = new Service();
		ThreadA a = new ThreadA(service);
		a.setName("A thread");
		a.start();
		ThreadB b = new ThreadB(service);
		b.setName("B thread");
		b.start();
	}

}
