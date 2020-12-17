package base.thread_api;

/**
 * ������ʹ��Thread.stop()����ͣ�߳�(�ѷ���)
 * �����ֹͣһ���̵߳Ĳ���ʹ��Thread.interrupt(),���������������ֹһ���������е��߳�,����Ҫ����һ���жϲſ������ֹͣ
 * ��java�������ַ���������ֹ�������е��߳�:
 *  1.ʹ���˳���־,ʹ�߳������˳�,Ҳ���ǵ�run��ɺ�
 *  2.ʹ��stop����ǿ����ֹ�߳�,���ǲ��Ƽ�ʹ��,��Ϊstop��suspend��resumeһ��,�������Ϲ��ڵ�
 *  3.ʹ��interrupt�����ж�
 *  
 * interrupted : ���Ե�ǰ�߳��Ƿ��Ѿ��ж�,ִ�к���н�״̬��־�����Ϊfalse�Ĺ���,�����������ε��þͱ�Ϊtrue
 * isInterrupted : �����߳��Ƿ��Ѿ��ж�,�������״̬��־
 * @author yangzuliang
 *
 */
public class MyThread5 extends Thread{

	public void run(){
		super.run();
		for(int i=0; i< 50000; i++){
			System.out.println("i = " + (i+1));
		}
	}
	
	public static void main(String[] args) {
		run2();
		//run3();
	}
	
	/**
	 * ���Ե�ǰ�߳��Ƿ��ж�,main��δ�жϹ�,����һֱ��false
	 */
	public static void run3(){
		
		try {
			
			MyThread5 myThread5 = new MyThread5();
			myThread5.start();
			Thread.sleep(1000);
			myThread5.interrupt();
			System.out.println("�Ƿ�ֹͣ1? = " + myThread5.isInterrupted());
			System.out.println("�Ƿ�ֹͣ2? = " + myThread5.isInterrupted());
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * �̵߳��ж�״̬�ɸ÷������,���仰˵,����������ε��ø÷���,�ڶ��ε��ý�����false(�ڵ�һ�ε�������������ж�״̬֮��
	 * �ҵڶ��ε��ü������ж�״̬ǰ,��ǰ�߳��ٴ��жϵ��������)
	 */
	public static void run2(){
		
		Thread.currentThread().interrupt();
		System.out.println("�Ƿ�ֹͣ1? = " + Thread.interrupted());
		System.out.println("�Ƿ�ֹͣ2? = " + Thread.interrupted());
		System.out.println("end!");
	}
	
	public static void  run1(){
		
		try {
			
			MyThread5 myThread5 = new MyThread5();
			myThread5.start();
			Thread.sleep(1000);
			myThread5.interrupt();
			System.out.println("�Ƿ�ֹͣ1? = " + Thread.interrupted());
			System.out.println("�Ƿ�ֹͣ2? = " + Thread.interrupted());
		} catch (Exception e) {
			System.out.println("main catch");
			e.printStackTrace();
		}
	}
}
