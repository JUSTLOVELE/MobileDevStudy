package 算法分析与设计.作业2;

import java.util.Scanner;

/**
 * 子矩阵
 * 
 * 给定一个 n*m 的矩阵，矩阵中只有元素 0 和 1。 现在，你的任务就是找出这个矩阵中有 多少个子矩阵。这些子矩阵中的元素只有 0
 * 对于一个矩阵，输出只包含 0 的子矩阵个数， 个数对 1000000007 取模
 * 
 * @author Administrator
 * 
 */
public class Matrix_1 {

	private static int count = 0;
	private static int N;
	private static int M;

	public static void main(String[] args) {

		init();
	}

	public static void init() {

		N = 3;
		M = 3;
		int[][] A = new int[N][M];
		int ISZERO = 0;
		int ISONE = 0;

		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				A[i][j] = scanner.nextInt();
				if (A[i][j] == 0) {
					count++;
					ISONE = 1;
				} else {
					ISZERO = 1;
				}
			}
		}

		if (ISONE == 0) {
			System.out.println("0");
		}

		if (ISZERO == 0) {
			System.out.println("-1");
		}

		/*
		 * A[0][0] = 1; A[0][1] = 1; A[0][2] = 0;
		 * 
		 * A[1][0] = 0; A[1][1] = 1; A[1][2] = 0;
		 * 
		 * A[2][0] = 0; A[2][1] = 0; A[2][2] = 0;
		 */

		work2(A, N - 1);
		work3(A, M - 1);
		System.out.println(count);
	}

	/**
	 * 每行变化
	 * 
	 * @param A
	 * @param n
	 */
	public static void work2(int[][] A, int n) {

		for (int i = 0; i <= n; i++) {
			test2(A, i, M - 1);
		}
	}

	public static void test2(int[][] A, int n, int m) {

		if (m > 0) {

			System.out.println("-------------------");
			System.out.println("坐标:" + n + " ; " + m + ";value = " + A[n][m]);
			System.out.println("坐标:" + n + " ; " + (m - 1) + ";value = " + A[n][m - 1]);

			if (A[n][m] == 0 && A[n][m - 1] == 0) {
				count = count + 1;
				test2(A, n, m - 1);
			}

			test2(A, n, m - 1);
		}
	}

	/**
	 * 每列变化
	 * 
	 * @param A
	 * @param m
	 */
	public static void work3(int[][] A, int m) {

		for (int i = 0; i <= m; i++) {
			test3(A, N - 1, i);
		}

		// System.out.println(count);
	}

	/**
	 * 
	 * @param A
	 * @param n
	 * @param m
	 */
	public static void test3(int[][] A, int n, int m) {

		if (n > 0) {

			/*
			 * System.out.println("-------------------");
			 * System.out.println("坐标:" + n + " ; " + m + ";value = " +
			 * A[n][m]); System.out.println("坐标:" + (n-1) + " ; " + m +
			 * ";value = " + A[n-1][m]);
			 */

			if (A[n][m] == 0 && A[n - 1][m] == 0) {
				count = count + 1;
				test3(A, n - 1, m);
			}

			test3(A, n - 1, m);
		}
	}
}
