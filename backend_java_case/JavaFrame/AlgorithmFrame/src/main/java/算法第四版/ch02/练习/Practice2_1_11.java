package 算法第四版.ch02.练习;

import 算法第四版.ch02.排序.Example;

/**
 * 将希尔排序中实时计算递增序列改为预先计算并存储在一个数组中
 * 
 * @author Administrator
 * 
 */
public class Practice2_1_11 extends Example {

	public static void sort(Comparable[] a) {

		int N = a.length;
		int h = 1;

		while (h < N / 3) {
			h = 3 * h + 1;
		}

		while (h >= 1) {
			// 将数组变为有序
			for (int i = h; i < N; i++) {
				// 将a[i]插入到a[i-h],a[i-2*h], a[i-3*h]...之中
				for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
					exch(a, j, j - h);
				}
			}

			h = h / 3;
		}
	}
}
