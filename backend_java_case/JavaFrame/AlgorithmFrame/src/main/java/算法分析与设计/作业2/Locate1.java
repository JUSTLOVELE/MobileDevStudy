package 算法分析与设计.作业2;

/**
 * 运用计数排序处理
 * @author Administrator
 *
 */
public class Locate1 {

	public static void main(String[] args) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int seed = sc.nextInt();
		int n = sc.nextInt();
		int k = sc.nextInt();

		int[] p = new int[n];

		for (int i = 0; i < n; i++) {
			p[i] = findFn(i + 1, seed, p);
		}

		int max = seed;

		for (int i = 1; i < n; i++) {
			if (max < p[i]) {
				max = p[i];
			}
		}

		int[] m = new int[max + 1];

		for (int i = 0; i < max + 1; i++) {
			m[i] = 0;
		}

		for (int i = 0; i < n; i++) {
			++m[p[i]];
		}

		int a = (n + 1) / 2 - (k - 1) / 2;
		int b = (n + 1) / 2 + (k - 1) / 2;
		int start = 0, end = 0;
		int sum = 0;
		int flag = 0;

		for (int i = 0; i < max + 1; i++) {
			sum += m[i];
			if (flag == 0 && sum >= a) {
				start = i;
				flag = 1;
			}

			if (sum >= b) {
				end = i;
				break;
			}
		}
		
		System.out.println("[" + start + ".." + end + "]");
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
