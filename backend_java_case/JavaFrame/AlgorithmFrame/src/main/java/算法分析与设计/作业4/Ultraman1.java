package �㷨���������.��ҵ4;

import java.util.Arrays;

import �㷨����.BaseService;
import �㷨���İ�.ch02.����.Quick;

/**
 * �������
 * �ϵ�����е���
 * �е�����µ���
 * �µ�����ϵ���
 * @author Administrator
 *
 */
public class Ultraman1 extends BaseService{
	
	public static void main(String[] args) {
		
		int N = 3;
		//Integer [] G = new Integer[]{25,33,77,64,28,101,74, 87, 98};//����
		//Integer [] A = new Integer[]{71,20,29,34,29,102,71, 83, 92};//��͹��
		//Integer[] G = reduceArray1(10000, 10000);
		//Integer[] A = reduceArray1(10000, 10000);
		Integer[] G = new Integer[]{95,87,74};
		Integer[] A = new Integer[]{92,71,83};
		Arrays.sort(G);
		Arrays.sort(A);
		int cout = 0;
		System.out.println(Arrays.toString(G));
		System.out.println(Arrays.toString(A));
		int a_start = 0;
		int a_end = N-1;
		int g_start = 0;
		int g_end = N-1;
		
		while(N>=1){
			if(A[a_start] > G[g_start]){
				//��������Сֵ���ڹ�����Сֵ,��ƴ��
				g_start++;
				a_start++;
				cout++;
			}else{
				//����������СֵС�ڹ��޵���Сֵ,���������Сֵƴ���������ֵ
				a_start++;
				g_end--;
				cout--;
			}
			N--;
		}
		
		System.out.println(cout*200);
	}
}
