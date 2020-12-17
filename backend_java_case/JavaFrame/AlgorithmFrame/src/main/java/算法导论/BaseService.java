package 算法导论;

import java.util.Random;

public class BaseService {
	
	/**
	 * 产生随机数组
	 * @param length
	 * @param maxValue
	 * @param minValue
	 * @return
	 */
	public static int[] reduceArray(int length, int maxValue){
		
		int[] A = new int[length];
		Random random = new Random();
		for(int i=0; i<length; i++){
			A[i] = random.nextInt(maxValue);
		}
		
		return A;
	}
	
	/**
	 * 产生随机数组
	 * @param length
	 * @param maxValue
	 * @param minValue
	 * @return
	 */
	public static Integer[] reduceArray1(int length, int maxValue){
		
		Integer[] A = new Integer[length];
		Random random = new Random();
		for(int i=0; i<length; i++){
			A[i] = random.nextInt(maxValue);
		}
		
		return A;
	}
	
	public static void exchage(int[] A, int a, int b){
		
		int temp = A[a];
		A[a] = A[b];
		A[b] = temp;
	}
	
	public static void print(int[] data) {  
        for (int i = 0; i < data.length; i++) {  
            System.out.print(data[i] + "\t");  
        }  
        System.out.println();  
    } 

}
