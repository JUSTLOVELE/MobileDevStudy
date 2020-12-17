package 算法导论.ch05.概率分析和随机算法;

import java.security.SecureRandom;
import java.util.Arrays;

import org.junit.Test;

import 算法导论.ch08.线性时间排序.Counting_Sort;

/**
 * 随机排列数组
 * @author Administrator
 *
 */
public class RandomSort {
	
	SecureRandom random = new SecureRandom();
	
	@Test
	public void randomize_in_placeTest(){
		
		int[] A = {3,4,2,1};
		randomize_in_place(A);
	}
	
	/**
	 * 产生随机排列的一个更好的方法是原址排列给定数组
	 * @param A
	 */
	public void randomize_in_place(int[] A){
		
		int n = A.length;
		for(int i=0; i<n; i++){
			
			int t = random(i, n);
			System.out.print(t + " ");
			int temp = A[t];
			A[t] = A[i];
			A[i] = temp;
		}
		
		System.out.println(Arrays.toString(A));
	}
	
	public int random(int i, int n){
		//次算法关键是要保证这里产生均匀的随机数列
		return random.nextInt(n-i) + i;
	}
	
	
	
	@Test
	public void prermute_by_sortingTest(){
		
		int[] A = {2,5,9,6,8,4,3};
		int t = prermute_by_sorting(A,3);
		System.out.println(t);
	}
	
	/**
	 * 为数字的每个元素A[i]赋予一个随机的优先级P[i],然后依据优先级取出A
	 * @param A
	 * @param num : 找到第j个小的元素
	 */
	public int prermute_by_sorting(int[] A, int num){
		
		int[] P = new int[A.length];
		int seed = A.length*A.length*A.length;
		
		for(int i=0; i<P.length; i++){
			P[i] =  random.nextInt(seed);
		}
		
		System.out.println("P=" + Arrays.toString(P));
		int[] B = new int[A.length];
		int max = P[0];
		for(int i=1; i<P.length; i++){
			if(P[i]>max){
				max = P[i];
			}
		}
		
		Counting_Sort.counting_Sort(P, B, max+1);
		System.out.println("B=" + Arrays.toString(B));
		int target = B[num-1];
		int i=0;
		
		for(int t : P){
			
			if(t == target){
				break;
			}else{
				i ++;
			}
		}
			
		System.out.println("i=" + i);
		return A[i];
	}
}
