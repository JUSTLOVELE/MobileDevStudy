package 算法分析与设计.作业3;


/**
 * 斌哥学医
 *   abingoo 的梦想是成为一位悬壶济世的医生。为了达成愿望，于是想拜附近最有威望的
 * 医生为师。医生为了判断他的资质，给他出了一个难题。医生把他带到一个到处都是草药的
 * 山洞里对他说：“孩子，这个山洞里有一些不同的草药，采每一株都需要一些时间，每一株
 * 也有它自身的价值。我会给你一段时间，在这段时间里，你可以采到一些草药。如果你是一
 * 个聪明的孩子，你应该可以让采到的草药的总价值最大
 * 
 * 现请你编写程序，在给出的这段时间里采草药，让采到的草药的总价值最大
 * 
 * 输入的第一行有两个整数 T（1 <= T <= 1000）和 M（1 <= M <= 100） ，用一个空格隔开
 * T 代表总共能够用来采药的时间，M 代表山洞里的草药的数目。接下来的 M 行每行包括两
 * 个在 1 到 100 之间（包括 1 和 100）的整数，分别表示采摘某株草药的时间和这株草药的价值。
 * 
 * @author Administrator
 *
 */
public class Bgxy {

	private static int TIME = 100;
	private static int NUM = 5;
	private static int[][] memo;
	private static int MAX = Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		int[] T = {77,22,29,50,99};
		int[] M = {92,22,87,46,90};
		memo = new int[NUM][NUM];
		
		for(int i=0; i<NUM; i++){
			for(int j=0; j<NUM; j++){
				memo[i][j] = -1;
			}
		}
		work(T, M, 0, 4);
		System.out.println(MAX);
	}
	
	public static void work(int[] T, int M[], int left, int right){
		
		for(int i=left; i<right; i++){
			
			if(memo[left][i] == -1){
				work(T, M, left, i);
				memo[left][i] = -2;
				int timeSum = 0;
				int numSum = 0;
				for(int k=left; k<=i; k++){
					timeSum += T[k];
					numSum += M[k];
				}
				if(timeSum <= TIME){
					memo[left][i] = numSum;
					if(numSum > MAX){
						MAX = numSum;
					}
				}else{
					memo[left][i] = -2;
				}
				System.out.println(left+","+i+" " + numSum + " " + timeSum);
			}
			
			if(memo[i+1][right] == -1){
				work(T, M, i+1, right); 
				memo[i+1][right] = -2;
				int timeSum = 0;
				int numSum = 0;
				for(int k= i+1; k<=right; k++){
					timeSum += T[k];
					numSum += M[k];
				}
				if(timeSum <= TIME){
					memo[i+1][right] = numSum;
					if(numSum > MAX){
						MAX = numSum;
					}
				}else{
					memo[i+1][right] = -2;
				}
				System.out.println((i+1) + "," + right + " " + numSum + " " + timeSum);				
			}
		}
	}
}
