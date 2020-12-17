package �㷨����.ch05.���ʷ���������㷨;

import java.security.SecureRandom;
import java.util.Arrays;

import org.junit.Test;

import �㷨����.ch08.����ʱ������.Counting_Sort;

/**
 * �����������
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
	 * ����������е�һ�����õķ�����ԭַ���и�������
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
		//���㷨�ؼ���Ҫ��֤����������ȵ��������
		return random.nextInt(n-i) + i;
	}
	
	
	
	@Test
	public void prermute_by_sortingTest(){
		
		int[] A = {2,5,9,6,8,4,3};
		int t = prermute_by_sorting(A,3);
		System.out.println(t);
	}
	
	/**
	 * Ϊ���ֵ�ÿ��Ԫ��A[i]����һ����������ȼ�P[i],Ȼ���������ȼ�ȡ��A
	 * @param A
	 * @param num : �ҵ���j��С��Ԫ��
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
