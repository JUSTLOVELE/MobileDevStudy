package base.thread_api;

/**
 * java�߳����������߳�,һ�����û��߳�,��һ���ػ��߳�,�ػ��߳���һ��������߳�,
 * �������в����ڷ��ػ��߳�,���ػ��߳��Զ�����,�������������߳�
 * @author yangzuliang
 *
 */
public class MyThread7 extends Thread{

	private int i=0;
	
	public void run() {
		
		try {
			
			while(true){
				i++;
				System.out.println("i=" + i);
				Thread.sleep(1000);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		try {
			
			MyThread7 thread7 = new MyThread7();
			thread7.setDaemon(true);
			thread7.start();
			Thread.sleep(5000);
			System.out.println("���뿪thread����Ҳ���ٴ�ӡ��,Ҳ����ֹͣ��");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
