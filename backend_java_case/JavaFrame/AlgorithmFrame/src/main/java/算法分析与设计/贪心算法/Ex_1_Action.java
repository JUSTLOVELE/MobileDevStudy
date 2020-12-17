package 算法分析与设计.贪心算法;

import java.util.Date;

/**
 * 活动安排问题
 *   设有n个活动的集合E={1,2,...,n},其中每个
 *活动都要求使用同一资源,如演讲会场等,而在同一时间内
 *只有一个活动能使用这一资源,每个活动i都有一个要求使用该资源的起始时间
 *si和一个结束时间fi,且si<fi,如果选择了活动i,则它在半开时间区间
 *[si, fi)内占用资源,若区间[si, fi)与区间[sj, fj)不相交,则称为
 *活动i与活动j是相容的,也就是说当si>=fj或sj>=fi时活动i与j相容
 * @author Administrator
 *
 */
public class Ex_1_Action {
	
	public static void main(String[] args) {
		
		int[] s = {1,3,0,5,3,5,6,8,8,2,12};
		//按结束时间非减序排列
		int[] f = {4,5,6,7,8,9,10,11,12,13,14};
		boolean[] A = {false,false,false,false,false,false,false,false,false,false,false};
		GreedySelector(10, s, f, A);
	}
	
	public static void GreedySelector(int n, int[] s, int[] f, boolean[] A){
		
		A[1] = true;
		int j = 1;
		for(int i=2; i<=n; i++){
			if(s[i] >= f[j]){
				A[i] = true;
				j=i;
			}
		}
		
		for(int i=0; i<A.length; i++){
			
			if(A[i]){
				System.out.println("开始时间:" + s[i] + ";结束时间:" + f[i]);
			}
		}
		
	}
}
