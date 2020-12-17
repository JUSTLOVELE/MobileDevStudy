package 算法分析与设计.作业2;

import java.util.Arrays;

import 算法导论.ch09.中位数和顺序统计量.Ex_9_3;

public class Locate1_2 {

	
	public static void main(String[] args) {
		
		
		/*java.util.Scanner sc = new java.util.Scanner(System.in);
		int seed = sc.nextInt();
		int n = sc.nextInt();
		int k = sc.nextInt();*/
		int seed = 100;
		int n = 9;
		int k = 5;
		
		int[] p = new int[n];

		for (int i = 0; i < n; i++) {
			p[i] = findFn(i + 1, seed, p);
		}
		
		System.out.println(Arrays.toString(p));
		
		int lo = (n+1)/2 - (k-1)/2;
		int r = (n+1)/2 + (k-1)/2;
		
		int s = Ex_9_3.random_select(p, 0, p.length-1, lo);
		System.out.println(Arrays.toString(p));
		int e = Ex_9_3.random_select(p, 0, p.length-1, r);
		System.out.println(Arrays.toString(p));
		System.out.println("[" + s + "," + e + "]");
	}
	
	public static int findFn(int n, int seed, int[] p) {

		if (n == 1) {
			return seed;
		}

		int lastFn = p[n - 2];

		if (lastFn % 2 == 0) {
			return (2 * lastFn + 3 * n) % (n * 2);
		} else if (lastFn % 2 == 1) {
			return (3 * lastFn + 5 * n) % (n * 2);
		}
		return -1;
	}
}
