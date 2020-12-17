package com.algorithm;

public class ChooseMaxOrMin {


	/**
	 * 找最小值
	 */
	public static int minimum(int[] A) {

		int min = A[0];

		for (int i = 1; i < A.length; i++) {

			if (min > A[i]) {

				min = A[i];
			}
		}

		return min;
	}
	
	/**
	 * 找最大值
	 */
	public static int maximum(int[] A) {

		int max = A[0];

		for (int i = 1; i < A.length; i++) {

			if (max < A[i]) {

				max = A[i];
			}
		}

		return max;
	}
	
	/**
	 * 同时找最大值和最小值
	 * @param A
	 */
    public static int[] minAndmaximin(int[] A){
		
    	if(A.length <= 2){
    		throw new RuntimeException("the array A length < 2");
    	}
    	
    	
		//int length = A.length / 2;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for(int i=0; i<A.length; i++){
			
			if(i+1 >= A.length){
				
				if(A[i] > max){
					max = A[i];
				}
				
				if(A[i] < min){
					min = A[i];
				}
				
			}else{
				//System.out.println(A[i] + ";" + A[i+1]);
				if(A[i] > A[i+1]){
					
					if(A[i] > max){
						max = A[i];
					}
					
					if(A[i+1] < min){
						min = A[i+1];
					}
					
				}else{
					
					if(A[i+1] > max){
						max = A[i+1];
					}
					
					if(A[i] < min){
						min = A[i];
					}
				}
			}
			i++;
		}
		
		System.out.println("max = " + max + ";min = " + min);
		int[] array = {max,min};
		return array;
	}

}
