package 算法分析与设计.作业3;

import java.util.Scanner;

/**
 * 最大报销问题
 *   实验室经常要报销一定额度的发票，Sao 负责这项工作。允许报销的发票类型包括买图
 *书（A 类） 、文具（B 类） 、差旅（C 类） ，要求每张发票的总额不得超过 1000 元，每张发票
 *上，单项物品的价值不得超过 600 元。
 *  现请你编写程序， 在给出的一堆发票中找出可以报销的、 不超过给定额度的最大报销额
 *  
 *  测试输入包含若干测试用例。每个测试用例的第1行包含两个正数 Q 和 N，其中 Q 是
 *  给定的报销额度，N（<=30）是发票张数。随后是 N 行输入，每行的格式为：
 *  m Type_1:price_1 Type_2:price_2 ...
 *  其中正整数 m 是这张发票上所开物品的件数，Type_i 和 price_i 是第 i 项物品的种类和
 *  价值。物品种类用一个大写英文字母表示。当 N 为0时，全部输入结束，相应的结果不要输
 *  出
 *  
 *  输入格式:
 *    200.00 3
 *    2 A:23.50 B:100.00
 *    1 C:650.00
 *    3 A:59.99 A:120.00 B:110.00
 *    
 *    
 *  
 * @author Administrator
 *
 */
public class Zdbx {

	private static double Q;
	private static int N;
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		/*Q = scanner.nextDouble();
		N = scanner.nextInt();
		double[] A = new double[N];
		
		for(int i=0; i<N; i++){
			int m = scanner.nextInt();
			double d = 0.0;
			for(int j=0; j<m;j++){
				String s = scanner.next();
				String[] array = s.split(":");
				d += Double.valueOf(array[1]);
			}
			A[i] = d;
		}*/
		
		Q = 200.00;
		N = 3;		
		double[] A = new double[N];
		A[0] = 23.5 + 100;
		A[1] = 650.00;
		A[2] = 59.99 + 120.00 + 110.00;
		
		
		double sum = work(A);
		System.out.println(sum);
	}
	
	public static double work(double[] A){
		
		double sum = 0;
		double b = A[0];
		//单个值<Q, 合起来小于Q
		for(int i=1; i<A.length; i++){
			
			double temp = b + A[i];
			
			if(temp > Q){
				
				if(b > Q && A[i] > Q){
					b=0;
				}else if(b > Q && A[i] < Q){
					b = A[i];
				}
			}
			
			if(sum < b){
				sum = b;
			}
		}
		
		
		
		return sum;
	}
}
