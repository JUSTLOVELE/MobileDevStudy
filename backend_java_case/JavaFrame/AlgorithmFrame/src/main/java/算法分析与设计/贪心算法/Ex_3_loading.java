package �㷨���������.̰���㷨;

import java.util.Arrays;

/**
 * ����װ��:
 *  ��һ����װ��Ҫװ��һ��������Ϊc���ִ�,���м�װ��i������ΪWi,����װ������Ҫ��ȷ����װ��
 *����������Ƶ������,�������ܶ�ļ�װ��װ���ִ�
 * @author Administrator
 *
 */
public class Ex_3_loading {

	public static int C=30;
	
	public static void main(String[] args) {
		
		int[] W = {10,3,5,9,20,40};
		Arrays.sort(W);
		int count = 0;//��������
		int num = 0;//������
		System.out.println(Arrays.toString(W));
		for(int i=0; i<W.length; i++){
			count += W[i];
			if(count < C){
				num++;
			}else{
				break;
			}
		}
		System.out.println(num);
	}
}
