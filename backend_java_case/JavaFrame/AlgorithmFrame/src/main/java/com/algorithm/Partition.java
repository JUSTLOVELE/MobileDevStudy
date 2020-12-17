package com.algorithm;

public class Partition {

	
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
	
    public static void exchage(int[] A, int a, int b){
		
		int temp = A[a];
		A[a] = A[b];
		A[b] = temp;
	}
}
