package �㷨���İ�.ch02.��ϰ;

import �㷨���İ�.ch02.����.Example;

/**
 * ��ϣ��������ʵʱ����������и�ΪԤ�ȼ��㲢�洢��һ��������
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
			// �������Ϊ����
			for (int i = h; i < N; i++) {
				// ��a[i]���뵽a[i-h],a[i-2*h], a[i-3*h]...֮��
				for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
					exch(a, j, j - h);
				}
			}

			h = h / 3;
		}
	}
}
