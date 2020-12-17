package 算法导论.ch09.中位数和顺序统计量;

import java.util.Arrays;

import 算法导论.BaseService;

public class Ex_9_2 extends BaseService{
	
	public static void main(String[] args) {
		
		int[] A = reduceArray(10, 300);
		System.out.println(Arrays.toString(A));
		int min = randomized_select(A, 0, A.length-1, 2);
		System.out.println(min);
	}
	
	/**
	 * 1.期望时间为线性时间的选择算法
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
		//A[q]为主元,左边都小于它,右边都大于它
		int q = partition(A, p, r);
		//要找第i小的元素 比较i,k的值就可以了
		int k = q-p+1;
		//i==k刚好A[q]就是第i小的了
		if(i==k){
			return A[q];
		}else if(i<k){
			return randomized_select(A, p, q-1, i);
		}else{
			return randomized_select(A, q+1, r, i-k);
		}

	}

	
	/**
	 * 实现了对子数组A[p..r]的原址重排
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
