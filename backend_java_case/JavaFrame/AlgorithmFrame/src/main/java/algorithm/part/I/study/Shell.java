package algorithm.part.I.study;

import java.util.Arrays;

public class Shell {

	public static void sort(Comparable[] a){
		
		int N = a.length;
		int h=1;
		while(h < N/3){
			h = 3*h + 1;
		}
		
		while(h>=1){
			
			for(int i=h; i<N; i++){
				for(int j=i; j>=h && Util.less(a[j], a[j-h]); j-=h){
					Util.exch(a, j, j-h);
				}
			}
			
			h = h/3;
		}
	}
	
	public static void main(String[] args) {
		
		Integer[] a = {6,5,4,3,7,0};
		sort(a);
		System.out.println(Arrays.toString(a));
	}
}
