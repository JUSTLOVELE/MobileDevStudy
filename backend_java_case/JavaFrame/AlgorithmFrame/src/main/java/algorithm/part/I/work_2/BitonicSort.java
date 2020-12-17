package algorithm.part.I.work_2;

import java.util.Arrays;

import org.junit.Test;

/**
 * Ë«Â·ÅÅĞò
 * @author 69410
 *
 */
public class BitonicSort {

	@Test
	public void init(){
		
		int[] a = {5,7,11,78,23,10,8,3};
		int n = a.length/2;
		System.out.println("×óÂ·ÅÅĞò");
		recursionLeft(a, 0, n);
		System.out.println("ÓÒÂ·ÅÅĞò");
		recursionRight(a, 0, n);
		System.out.println(Arrays.toString(a));
	}
	
	public void recursionLeft(int[] a, int start, int end){
		
		if((end - start) == 1){
			return ;
		}
		
		sort(a, start, end, "left");
		int n = end/2;
		recursionLeft(a, start, n);
	}
	
	//int[] a = {5,7,11,78,23,10,8,3};
	public void recursionRight(int[] a, int start, int end){
		
		if((end - start) == 1){
			return ;
		}
		
		sort(a, start, end, "right");
		
		int n = end/2;
		recursionRight(a, n, end);
	}
	
	public void sort(int[] a, int start, int end, String key){
		
		int step = 0 ;
		if("left".equals(key)){
			step = end/2;
		}else{
			step = start/2;
		}
		
		
		for(int i=start; i<end; i++){
			
			if(a[i] > a[i+step]){
				
				int temp = a[i];
				a[i] = a[i+step];
				a[i+step] = temp;
			}
		}
	}
}
