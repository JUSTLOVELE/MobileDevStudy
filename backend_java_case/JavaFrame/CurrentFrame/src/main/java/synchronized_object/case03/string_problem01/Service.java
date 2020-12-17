package synchronized_object.case03.string_problem01;

public class Service {
	
	/**
	 * ��ӡ�Ľ������AA
	 * ������ΪString������ֵ����AA,�����̳߳�����ͬ����,�������B�̲߳���ִ��,�����String�����ش���������
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
