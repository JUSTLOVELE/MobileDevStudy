package �㷨����.ch09.��λ����˳��ͳ����;

import java.util.Arrays;

import �㷨����.BaseService;

public class Ex_9_2 extends BaseService{
	
	public static void main(String[] args) {
		
		int[] A = reduceArray(10, 300);
		System.out.println(Arrays.toString(A));
		int min = randomized_select(A, 0, A.length-1, 2);
		System.out.println(min);
	}
	
	/**
	 * 1.����ʱ��Ϊ����ʱ���ѡ���㷨
	 * @param A
	 * @param p
	 * @param r
	 * @param i
	 * @return
	 */
	public static int randomized_select(int[] A, int p, int r, int i) {

		if (p == r) {
			return A[p];
		}
		//A[q]Ϊ��Ԫ,��߶�С����,�ұ߶�������
		int q = partition(A, p, r);
		//Ҫ�ҵ�iС��Ԫ�� �Ƚ�i,k��ֵ�Ϳ�����
		int k = q-p+1;
		//i==k�պ�A[q]���ǵ�iС����
		if(i==k){
			return A[q];
		}else if(i<k){
			return randomized_select(A, p, q-1, i);
		}else{
			return randomized_select(A, q+1, r, i-k);
		}

	}

	
	/**
	 * ʵ���˶�������A[p..r]��ԭַ����
	 * @param A
	 * @param p
	 * @param r
	 */
	public static int partition(int[] A, int p, int r){
		
		int x = A[r];
		int i = p-1;
		for(int j=p; j<r; j++){
			
			if(A[j] <= x){
				
				i = i+1;
				exchage(A, i, j);
			}
		}
		
		exchage(A, i+1, r);
		return i+1;
	}
}
