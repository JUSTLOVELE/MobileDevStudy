package base.thread_api;

import java.util.Random;

/**
 *   �����ȼ����߳����Ǵ󲿷���ִ����,������������ȼ����߳�ȫ��ִ����
 *   ��Ҫ��ΪMyThread1�߳��ȱ�main�߳������þͻ���ִ����,���������Ľ��,ȫ������Ϊ
 * MyThread6�̵߳����ȼ������ֵΪ10��ɵ�
 *   ���߳����ȼ��Ĳ��ܴ�ʱ,˭��ִ����ʹ���ĵ���˳���޹�,���������
 * @author yangzuliang
 *
 */
public class MyThread6 extends Thread {

	public void run(){
		
		long beginTime = System.currentTimeMillis();
		long addResult = 0;
		
		for(int j=0; j<10; j++){
			
			for(int i=0; i<5000; i++){
				
				Random random = new Random();
				random.nextInt();
				addResult = addResult + 1;
			}
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println("***1***��ʱ : " + (endTime - beginTime));
	}
	
	public static void main(String[] args) {
		
		for(int i=0; i<5; i++){
			
			MyThread6 myThread6 = new MyThread6();
			myThread6.setPriority(10);
			myThread6.start();
			
			MyThread6_2 myThread6_2 = new MyThread6_2();
			myThread6_2.setPriority(1);
			myThread6_2.start();
		}
	}
}
