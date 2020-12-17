package algorithm.part.I.study;

import java.util.Arrays;

/**
 * �鲢
 * @author 69410
 *
 */
public class MergeSort {
	
	private static Comparable[] aux;
	
	public static void main(String[] args) {
		
		Comparable[] a = {2,3,6,9,5,7};
		sort(a);
		System.out.println(Arrays.toString(a));
	}
	
	public static void sort(Comparable[] a){
		aux = new Comparable[a.length];
		sort(a, aux, 0, a.length-1);
	}
	
	private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi){
		
		if(hi <= lo){
			return ;
		}
		
		int mid = lo + (hi-lo)/2;
		sort(a, aux, lo, mid);
		sort(a, aux, mid+1, hi);
		merge(a, aux, lo, mid, hi);
	}

	private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi){
		
		for(int k=lo; k<=hi; k++){
			aux[k] = a[k];
		}
		
		int i=lo, j=mid+1;
		
		for(int k=lo; k<=hi; k++){
			
			if(i>mid){
				a[k] = aux[j++];
			}else if(j > hi){
				a[k] = aux[i++];
			}else if(Util.less(aux[j], aux[i])){
				a[k] = aux[j++];
			}else{
				a[k] = aux[i++];
			}
		}
	}
}
