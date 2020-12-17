package 算法分析与设计.贪心算法;

import java.util.Arrays;

/**
 * 最优装载:
 *  有一批集装箱要装上一搜载重量为c的轮船,其中集装箱i的重量为Wi,最优装载问题要求确定在装载
 *体积不受限制的情况下,将尽可能多的集装箱装上轮船
 * @author Administrator
 *
 */
public class Ex_3_loading {

	public static int C=30;
	
	public static void main(String[] args) {
		
		int[] W = {10,3,5,9,20,40};
		Arrays.sort(W);
		int count = 0;//总量计数
		int num = 0;//计数器
		System.out.println(Arrays.toString(W));
		for(int i=0; i<W.length; i++){
			count += W[i];
			if(count < C){
				num++;
			}else{
				break;
			}
		}
		System.out.println(num);
	}
}
