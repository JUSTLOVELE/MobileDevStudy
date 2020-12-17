package 算法分析与设计.回溯法;

import java.util.Arrays;

/**
 * 排列树
 * @author Administrator
 *
 */
public class LinedTree {

	int[] x = {1,2,3};
	
	public static void main(String[] args) {
		
		LinedTree l = new LinedTree();
		l.backTrace(0);
	}
	
	public void backTrace(int t){
		
		if(t >= x.length){
			System.out.println(Arrays.toString(x));
		}else{
			for(int i=t; i<x.length; i++){
				swap(i, t);
				backTrace(t+1);
				swap(i, t);
			}
		}
	}
	
	public void swap(int i, int j){
		int a = x[i];
	    x[i] = x[j];
	    x[j] = a;
	}
}
