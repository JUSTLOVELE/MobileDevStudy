package 算法分析与设计.作业4;

import java.util.Arrays;

import 算法导论.BaseService;
import 算法第四版.ch02.排序.Quick;

/**
 * 田忌赛马
 * 上等马对中等马
 * 中等马对下等马
 * 下等马对上等马
 * @author Administrator
 *
 */
public class Ultraman1 extends BaseService{
	
	public static void main(String[] args) {
		
		int N = 3;
		//Integer [] G = new Integer[]{25,33,77,64,28,101,74, 87, 98};//怪兽
		//Integer [] A = new Integer[]{71,20,29,34,29,102,71, 83, 92};//凹凸曼
		//Integer[] G = reduceArray1(10000, 10000);
		//Integer[] A = reduceArray1(10000, 10000);
		Integer[] G = new Integer[]{95,87,74};
		Integer[] A = new Integer[]{92,71,83};
		Arrays.sort(G);
		Arrays.sort(A);
		int cout = 0;
		System.out.println(Arrays.toString(G));
		System.out.println(Arrays.toString(A));
		int a_start = 0;
		int a_end = N-1;
		int g_start = 0;
		int g_end = N-1;
		
		while(N>=1){
			if(A[a_start] > G[g_start]){
				//奥特玛最小值大于怪兽最小值,则拼掉
				g_start++;
				a_start++;
				cout++;
			}else{
				//奥特曼的最小值小于怪兽的最小值,则奥特曼最小值拼掉怪兽最大值
				a_start++;
				g_end--;
				cout--;
			}
			N--;
		}
		
		System.out.println(cout*200);
	}
}
