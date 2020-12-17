package 算法分析与设计.贪心算法;

import java.util.Arrays;

/**
 * 背包问题：
 *   给定n种物品和一个背包,物品i的重量是Wi,其价值为Vi,背包的容量为C,应如何选择装入背包的物品,使得装入背包中物品的总价值最大?
 *在选择物品i装入背包时,可以选择物品i的一部分,而不一定要全部装入背包
 * 分析:
 *  一般的做法有三种:
 *    1.选价值最大,虽然这可能尽可能快的增加背包的总价值,但是,虽然每一步选择获得了背包价值的极大增长,但背包容量却可能消耗得太快
 *    2.最重量最轻,装入尽可能多的物品,从而增加背包的总价值,但是虽然每一步选择使背包的容量消耗得慢了,但背包的价值却没有保证迅速增加
 *    3.选择单位重量价值最大的物品,在背包价值增长和背包容量消耗两者之间寻找平衡
 * 
 * 第三种具有最有子结构性质,和贪心选择性
 * @author Administrator
 *
 */
public class Ex_2_0_1 {
	
	public static int SPACE = 50;
	public static int N = 3;// N == W.length == V.length
	
	public static void main(String[] args) {
		
		int[] W = { 20,30,10 };// 重量
		int[] V = { 60,120,50 };// 价值
		knapsack(W, V);
	}
	
	public static void knapsack(int[] W, int[] V){
		
		sort(W, V);
		int space = SPACE;
		int Value = 0;
		
		for(int i=W.length-1; i>=0; i--){
			
			int now = W[i];
			
			if(now < space){
				
				Value += V[i];
				space = space - now;
			}else{
				Value += (space*(V[i]/W[i]));
				break;
			}
		}
		
		System.out.println(Value);
	}
	
	public static void sort(int[] W, int[] V){
		
		int[] value = new int[W.length];
		
		for(int i=0; i<value.length; i++){
			
			value[i] = V[i]/W[i];
		}
		
		sort(W, V, value, 0, W.length-1);
	}
	
	public static void sort(int[] W, int[] V, int[] A, int p, int r){
		if(p<r){
			int q = partition(W,V,A,p,r);
			sort(W,V,A,p,q-1);
			sort(W,V,A,q+1, r);
		}
	}
	
	private static int partition(int[] W, int[] V, int[] A, int p, int r){

		
		int x = A[r];
		int i=p-1;
		
		for(int j=p; j<r; j++){
			
			if(A[j] <= x){
				
				i++;
				exchage(W, V, A, i, j);
			}
		}
		
		exchage(W, V, A, i+1, r);
		
		return i+1;
	}
	
   public static void exchage(int[] W, int[] V, int[] A, int a, int b){
		
		int temp = A[a];
		A[a] = A[b];
		A[b] = temp;
		
		int d = W[a];
		W[a] = W[b];
		W[b] = d;
		
		int e = V[a];
		V[a] = V[b];
		V[b] = e;
	}
}
