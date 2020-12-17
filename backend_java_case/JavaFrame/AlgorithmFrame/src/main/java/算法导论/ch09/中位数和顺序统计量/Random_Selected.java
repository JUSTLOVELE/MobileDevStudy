package 算法导论.ch09.中位数和顺序统计量;

import java.util.Arrays;

import 算法导论.BaseService;

/**
 * 最坏情况为线性时间的选择算法
 * 
 * @author Administrator
 * 
 */
public class Random_Selected extends BaseService {
	
	private static int selectX;
	
	public static void main(String[] args) {

		int[] A = reduceArray(10, 20);
		System.out.println(Arrays.toString(A));
		int result = random_select(A, 0, A.length - 1, 3);
		System.out.println(result);
	}
	
	public static int random_select(int[] A, int p, int r, int i) {

		selectX = 0;
		Select(A, p, r);
		int q = Partition(A, p, r, selectX);
		
		int k = q - p + 1;

		if (k == i) {
			return A[q];
		} else if (i<k) {
			return random_select(A, p, q - 1, i);
		} else {
			return random_select(A, q + 1, r, i - k);
		}
	

	}

	public static int Partition(int[] A, int p, int r, int x) {

		int index = -1;
		for (int i = p; i <= r; i++) {
			if (A[i] == x) {
				index = i;
				break;
			}
		}
		if (index == -1) {
			return -1;
		}
		int temp = A[index];
		A[index] = A[r];
		A[r] = temp;
		int i = p - 1;

		for (int j = p; j < r; j++) {
			if (A[j] <= x) {
				i++;
				int tmp = A[i];
				A[i] = A[j];
				A[j] = tmp;
			}
		}
		int pivot = A[r];
		A[r] = A[i + 1];
		A[i + 1] = pivot;

		return i + 1;
	}

	public static void Select(int[] A, int p, int r) {

		if (p == r) {
		    selectX = A[p];
		    return ;
		}

		int n = r - p + 1;
		int m = 0;

		if (n % 5 == 0) {
			m = n / 5;
		} else {
			m = n / 5 + 1;
		}
		// 五个分为一组,每组进行插入排序
		int[] b = new int[m];
		int i = p;

		for (int j = 0; j < m; j++) {
			selectX = 0;
			if (i + 4 <= r) {
				InsertionSort(A, i, i + 4);
				b[j] = selectX;
				i += 5;
			} else {
				InsertionSort(A, i, r);
				b[j] = selectX;
			}
		}
		// 对包含各分组中位数的数组b，递归调用Select，找出中位数x
		Select(b, 0, m - 1);
	}

	public static void InsertionSort(int[] A, int p, int r) {

		int i = 0;

		for (int j = p + 1; j <= r; j++) {
			i = j - 1;
			int key = A[j];
			while (i >= p && A[i] > key) {
				A[i + 1] = A[i];
				i--;
			}
			A[i + 1] = key;
		}
		int d = r - p + 1;
		if (d % 2 == 0) {
			d = d / 2 - 1;
		} else {
			d = d / 2;
		}

		selectX = A[d + p];
	}
}
