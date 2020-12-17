package 算法导论.ch07.快速排序;

import java.util.Arrays;

import 算法导论.BaseService;

/**
 * 快速排序
 * 最坏为O(n^2),期望为O(nlogn)
 * @author Administrator
 *
 */
public class Qucik_Sort extends BaseService{
	
	public static void main(String[] args) {
		int[] A = reduceArray(10, 20);
		System.out.println(Arrays.toString(A));
		quickSort(A, 0, A.length-1);
		System.out.println(Arrays.toString(A));
	}
	
	
	public static void quickSort(int[] A, int p, int r){
		
		if(p<r){
			int q = partition(A, p, r);
			quickSort(A, p, q-1);
			quickSort(A, q+1, r);
		}
	}

	public static int partition(int[] A ,int p, int r){
		
		int x = A[r];
		int i=p-1;
		
		for(int j=p; j<r; j++){
			
			if(A[j] <= x){
				
				i++;
				exchage(A, i, j);
			}
		}
		
		exchage(A, i+1, r);
		
		return i+1;
	}
}
