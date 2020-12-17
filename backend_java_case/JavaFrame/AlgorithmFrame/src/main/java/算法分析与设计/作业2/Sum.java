package 算法分析与设计.作业2;

import 算法导论.BaseService;

/**
 * 给一个序列，找出最大子段和
 * 这里用动态规划,也可用分治法
 * @author Administrator
 *
 */
public class Sum extends BaseService {
	

	public static void main(String[] args) {
		
		int[] a  = {0,6,-1,1,-6,7,-5};
		int[] b = new int[a.length];
		b[0] = a[0];
		int max = b[0];
		int j=1;
		int start = -1;
		int end = -1;
		
		for(int i=1; i<a.length; i++){
			if(b[i-1] > 0){
				b[i] = b[i-1] + a[i];
			}else{
				b[i] = a[i];
				j = i+1;
			}
			
			if(b[i] > max){
				max =b[i];     
	            start =  j;     
	            end  = i+1;    
			}
		}
		
		System.out.println(max + " " + start + " " + end);
	}
	
}
