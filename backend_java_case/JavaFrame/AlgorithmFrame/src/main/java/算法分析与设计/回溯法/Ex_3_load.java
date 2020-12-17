package �㷨���������.���ݷ�;

import java.util.Arrays;

/**
 * װ������:
 * ����:
 *   ��һ����n����װ��Ҫװ��2���������ֱ�Ϊc1��c2���ִ�,���м�װ��i������Ϊwi,��w1+w2...+wi<=(c1+c2)
 *װ������Ҫ��ȷ���Ƿ���һ�������װ�ط����ɽ�������װ��װ����2���ִ�,�����,�ҳ�һ��װ�ط���
 * ����:
 * 1.����һ���ִ�������װ��
 * 2.ʣ��ļ�װ��װ�ϵڶ����ִ�
 * 
 * ����һ���ִ�������װ���ȼ���ѡȡȫ�弯װ���һ���Ӽ�,ʹ���Ӽ��м�װ������֮����ӽ�,�ɴ˿�֪,װ������ȼ��������0-1��������
 * @author Administrator
 *
 */
public class Ex_3_load {
	
	private int c1 = 15;
	private int c2 = 20;
	private int[] N = {3,5,10,4,6,7};
	private int maxValue = 0;
	private int tempValue = 0;
	private int[] way = new int[N.length];
	private int[] bestWay = new int[N.length];
	
	public static void main(String[] args) {
		
		Ex_3_load load = new Ex_3_load();
		load.backTrack(0);
		System.out.println("���ս�:" + Arrays.toString(load.bestWay));
		
		for(int i : load.bestWay){
			if(i == 1){
				System.out.println("��" + i + "���������c1");
			}else{
				System.out.println("��" + i + "���������c2");
			}
		}
	}
	
	/**
	 * w1+w2...+wi<=(c1+c2)
	 * @param t
	 */
	public void backTrack(int t){
		//Ѱ�ҵ���ײ���
		if(t > N.length-1){
			//System.out.println("���н�:" + Arrays.toString(way));
			if(maxValue < tempValue){
				maxValue = tempValue;
				for(int i=0; i<way.length; i++){
					bestWay[i] = way[i];
				}
			}
			return;
		}
		//����:֮ǰ���������ϵ�ǰ������ҪС��c1
		int nowWeight = tempValue + N[t];
		if(nowWeight <= c1){
			//��ߵĽڵ��������,����
			tempValue = nowWeight;
			way[t] = 1;
			backTrack(t+1);
			//��ֹû���ҵ����н��ֻ��˻���
			tempValue = tempValue - N[t];
			way[t] = 0;
		}
		//�ұ߲�����
		backTrack(t+1);
	}
}
