package 算法分析与设计.动态规划;

/**
 * 0-1背包 给定n种物品和一背包,物品i的重量是Wi,其价值是Vi,背包的容量为c, 问应如何选择装入背包中的物品,使得装入背包中物品的总价值最大,对于每
 * 种物品只有两种选择,因此成为0-1背包
 * 
 * 分析: C[i][j] 前i个物体放入容量为j的背包的最大价值
 * 
 * @author Administrator
 * 
 */
public class Ex_5_01Space {

	public static int SPACE = 100;
	public static int N = 6;// N == W.length == V.length

	public static void main(String[] args) {

		int[] W = { 0, 3, 5, 8, 9, 10, 6 };// 重量
		int[] V = { 0, 10, 6, 7, 11, 16, 9 };// 价值
		work(W, V);
	}

	public static void work(int[] W, int[] V) {

		int[][] C = new int[N + 1][SPACE + 1];

		for (int i = 0; i < C.length; i++) {

			C[i][0] = 0;
		}

		for (int j = 0; j < C[0].length; j++) {
			C[0][j] = 0;
		}

		// 按照列填写数字
		for (int j = 1; j <= SPACE; j++) {// j表示当前容量

			for (int i = 1; i <= N; i++) {

				int nowWeight = W[i]; // 当前背包的重量

				if (nowWeight > j) {
					// 当前背包过重,不放入
					C[i][j] = C[i - 1][j];
					continue;
				} else if (C[i - 1][j - W[i]] + V[i] > C[i - 1][j]) {
					//j-W[i]个前的最大值+当前的最大值跟上个数比较
					C[i][j] = C[i - 1][j - W[i]] + V[i];
				} else {
					C[i][j] = C[i - 1][j];
				}
			}
		}

		System.out.println(C[N][SPACE]);
	}
}
