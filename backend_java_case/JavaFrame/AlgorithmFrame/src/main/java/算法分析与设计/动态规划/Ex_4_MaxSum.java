package 算法分析与设计.动态规划;

import 算法导论.BaseService;

/**
 * 最大子段和问题
 * 给定由n个整数组成的序列a1,a2...an,求该序列的子段和的最大值,当所有整数均为负整数时定义其最大子段和未0
 * 
 * @author Administrator
 *
 */
public class Ex_4_MaxSum extends BaseService{

	public static void main(String[] args) {
		int[] A = {-2, 11, -4, 13, -5, -2};
		//中间数最大
		//int[] A = {2,-10,3,5,7,-2,-1}; 
		//int[] A = {2,-10,-2,-1,3,5,7}; 
		normal(A);
		int sum = divide(A, 0, A.length-1); 
		System.out.println("分治法:最大和 = "+ sum);
		dynamic(A.length-1, A);
	}
	
	/**
	 * 动态规划
	 * @param n
	 * @param A
	 */
	public static void dynamic(int n, int[] A){
		
		int sum = 0;
		int b = 0;
		for(int i=1; i<=n; i++){
			if(b>0){
				b += A[i];
			}else{
				b = A[i];
			}
			if(b>sum){
				sum = b;
			}
		}
		System.out.println("动态规划:最大和=" + sum );
	}
	
	/**
	 * 分治法
	 * @param A
	 * @param left
	 * @param right
	 * @return
	 */
	public static int divide(int[] A, int left, int right){
		
		int sum = 0;
		if(left == right) {
			sum = A[left] > 0 ? A[left]:0;
		}else{
			int center = (left + right)/2;
			int leftSum = divide(A, left, center);
			int rightSum = divide(A, center+1, right);
			int s1 = 0;
			int lefts = 0;
			for(int i=center; i>=left; i--){
				lefts += A[i];
				if(lefts > s1){
					s1 = lefts;
				}
			}
			
			int s2 = 0;
			int rights = 0;
			for(int i=center+1; i<=right; i++){
				rights += A[i];
				if(rights > s2){
					s2 = rights;
				}
			}
			
			sum = s1+s2;
			
			if(sum < leftSum && rightSum < leftSum) {
				sum = leftSum;
			}
			
			if(sum < rightSum && leftSum < rightSum){
				sum = rightSum;
			}
		}
		
		return sum;
	}
	
	/**
	 * 普通解法
	 * 复杂度: n*n
	 * @param A
	 */
	public static void normal(int[] A){
		
		int sum = 0;
		int start = -1;
		int end = -1;
		
		for(int i=0; i<A.length; i++){
			
			int temp = 0;
			
			for(int j=i; j<A.length; j++){
				
				temp += A[j];
				
				if(temp > sum){
					sum = temp;
					start = i;
					end = j;
				}
			}
		}
		
		System.out.println("普通解法:最大和=" + sum + " i=" + start + " j=" + end );
	}
}
