package synchronized_object.case02;

import synchronized_object.case02.MyOneList;

public class MyService {
	
	/**
	 * 如果不同步list就发生脏读
	 * object是监视器要监视的对象.当一个对象被监视器监视的时候,同一时刻只能有一个线程访问它,其它要访问它的线程必须在等待队列中等待
	 * @param list
	 * @param data
	 * @return
	 */
	public MyOneList addServiceMehtod(MyOneList list, String data){
		
		try {
			
			synchronized (list) {
				if(list.getSize() < 1){
					Thread.sleep(2000);
					list.add(data);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list;
	}
	
	public static void main(String[] args) {
		
		try {
			MyOneList list = new MyOneList();
			MyThread1 thread1 = new MyThread1(list);
			thread1.setName("A");
			thread1.start();
			System.out.println("listsize=" + list.getSize());
			MyThread2 thread2 = new MyThread2(list);
			thread2.setName("B");
			thread2.start();
			System.out.println("listsize=" + list.getSize());
			thread2.sleep(6000);
			System.out.println("listsize=" + list.getSize());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
