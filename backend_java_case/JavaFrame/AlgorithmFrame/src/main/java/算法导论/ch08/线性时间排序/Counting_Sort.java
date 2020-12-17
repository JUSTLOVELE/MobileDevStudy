package �㷨����.ch08.����ʱ������;

import java.util.Arrays;

import org.junit.Test;

import �㷨����.BaseService;

/**
 * ֮ǰ���㷨���ǻ��ڱȽϵ�:��Ԫ�صĴ�������������֮��ıȽ�,���ǰ����������㷨��Ϊ�Ƚ�����
 * ��������(�ȶ����㷨)
 *  ����˼��:��ÿһ������Ԫ��x,ȷ��С��x��Ԫ�ظ���,������һ��Ϣ,�Ϳ���ֱ�Ӱ�x�ŵ�������������е�λ������
 *����:�����17��Ԫ��С��x,��x��Ӧ���ڵ�18�����λ����,���м���Ԫ����ͬʱ,�������Ҫ�����޸�,���ܰ����Ƿ���ͬһ��λ����
 *  �ܴ�����O(k+n)(k��ָ���Ԫ��)
 *  ��ʵ����,��k=O(n)ʱ,�Ͳ��ü�������
 * @author Administrator
 *
 */
public class Counting_Sort extends BaseService {
	
	@Test
	public void counting_SortTest(){
		//int[] A = reduceArray(100, 1000);
	    int[] A = {2,5,3,0,2,3,0,3};
		int[] B = new int[A.length];
		int max = A[0];
		for(int i=1; i<A.length; i++){
			if(A[i]>max){
				max = A[i];
			}
		}
		
		/*for(int i=0; i<A.length; i++){
			System.out.print(A[i] + ",");
		}*/
		//System.out.println("");
		counting_Sort(A, B, max+1);
		System.out.println(Arrays.toString(B));
		/*for(int i=0; i<B.length; i++){
			System.out.println(B[i] + ",");
		}*/
	
	}
	
	/**
	 * @param A:��������
	 * @param B:�������
	 * @param k:��C�ṩ��ʱ�Ĵ洢�ռ�(A�����ֵ+1)
	 * @return
	 */
	public static void counting_Sort(int[] A, int[] B, int k){
		
		Integer[] C = new Integer[k];

		for(int i=0; i<k; i++){
			C[i] = 0;
		}
		//C���±���A��Ԫ�ص�ֵ,C��ֵ��A�ж�ӦC��ʱֵ���±�ĸ���
		for(int i=0; i<A.length; i++){
			int a = A[i];
			C[a]++;
		}
		
		for(int i=1; i<k; i++){
			C[i] = C[i] + C[i-1];
		}
		
		/*for(int i=0; i<k; i++){
			System.out.print(C[i] + ",");
		}*/
		for(int i=(A.length-1); i>=0; i--){
			//�ҵ�A[i]�ǵڼ�С,C[]�е�ֵ��ŵ���B������,C�������Ƕ�Ӧ��ֵ
			int index = C[A[i]];
			//��Ϊ�����0��ʼ����Ҫ-1,��A�ж�Ӧ��ֵ�ŵ�B�ж�Ӧ��λ��
			B[index-1] = A[i];
			//��Ӧ��λ�ü���-1
			C[A[i]] = C[A[i]]-1;
		}
	}
}
