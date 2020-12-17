package �㷨����;

import java.util.Arrays;


/**
 * �鲢����:�ֽп�������,ʹð�������һ�ָĽ�
 * ������(���������������ϲ���һ���µ���������Ѵ��������з�Ϊ���ɸ������У�ÿ�����ж�������ģ�Ȼ���ٰ����������кϲ�
 * Ϊ������������
 * ���鲢�����㹻Сʱ�����Կ����ò�������ʹ�鲢Ҷ���
 * ʱ�临�Ӷ���O(nlogn)
 * @author yangzuliang
 *
 */
public class MergeSort {
	
	public static void main(String[] args) {
	
		Integer[] nums = {1, 9, 8, 2, 3, 6  };
		MERGE_SORT(nums, 1, 6);
		//MERGE(nums, 1, 3, 6);
	}
	
	/**
	 * ��ϸ��������
	 *�ݹ�
	 *  ������p<r ,���ݹ鵽p>=rʱ�Ͳ����ٵݹ��ˣ����л�ȥִ�У���ô��Ȼ����ֻ��Ƚ��������λ�õ���
	 * @param A
	 * @param p
	 * @param r
	 */
	public static void MERGE_SORT(Integer[] A, int p, int r){
		if(p<r){
			int q =(p+r)/2;
			MERGE_SORT(A, p, q);
			MERGE_SORT(A, q+1, r);
			MERGE(A, p, q, r);
		}
	}
	/**
	 * ��ϸ�������̣�
	 * 1.��ʼ��
	 *   1.1.����A[p,q]�ĳ���n1,A[q,r]�ĳ���n2
	 *   1.2.��������A1��A2��Ӧ����2���ָ�����飬���ڱ��������
	 * 2.����
	 *   2.1.ά��ѭ������ʽ���Ƚ�A1��A2�Ĵ�С��С�ľͷŽ�A��
	 * 3.��ֹ
	 *   �������鶼ѭ�����
	 * @param A
	 * @param p
	 * @param q
	 * @param r
	 */
	public static void MERGE(Integer[] A, int p, int q, int r){
		int n1 = q - p + 1;
		int n2 = r - q;
		Integer[] A1 = new Integer[n1 + 1];
		Integer[] A2 = new Integer[n2 + 1];
		for(int i=0; i<n1; i++){
			A1[i] = A[i + p - 1];
		}
		for(int i=0; i<n2; i++){
			A2[i] = A[q + i];
		}
		A1[n1] = 1000;
		A2[n2] = 1000;
		System.out.println(Arrays.toString(A1));
		System.out.println(Arrays.toString(A2));
		
		int i = 0;
		int j = 0;
		
		for(int k=p-1; k<r; k++){
			if(A1[i] <= A2[j]){
				A[k] = A1[i];
				i++;
			}else{
				A[k] = A2[j];
				j++;
			}
		}
		
		System.out.println(Arrays.toString(A));
		
	}
}  

