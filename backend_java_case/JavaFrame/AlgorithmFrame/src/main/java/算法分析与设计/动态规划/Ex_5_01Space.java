package �㷨���������.��̬�滮;

/**
 * 0-1���� ����n����Ʒ��һ����,��Ʒi��������Wi,���ֵ��Vi,����������Ϊc, ��Ӧ���ѡ��װ�뱳���е���Ʒ,ʹ��װ�뱳������Ʒ���ܼ�ֵ���,����ÿ
 * ����Ʒֻ������ѡ��,��˳�Ϊ0-1����
 * 
 * ����: C[i][j] ǰi�������������Ϊj�ı���������ֵ
 * 
 * @author Administrator
 * 
 */
public class Ex_5_01Space {

	public static int SPACE = 100;
	public static int N = 6;// N == W.length == V.length

	public static void main(String[] args) {

		int[] W = { 0, 3, 5, 8, 9, 10, 6 };// ����
		int[] V = { 0, 10, 6, 7, 11, 16, 9 };// ��ֵ
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

		// ��������д����
		for (int j = 1; j <= SPACE; j++) {// j��ʾ��ǰ����

			for (int i = 1; i <= N; i++) {

				int nowWeight = W[i]; // ��ǰ����������

				if (nowWeight > j) {
					// ��ǰ��������,������
					C[i][j] = C[i - 1][j];
					continue;
				} else if (C[i - 1][j - W[i]] + V[i] > C[i - 1][j]) {
					//j-W[i]��ǰ�����ֵ+��ǰ�����ֵ���ϸ����Ƚ�
					C[i][j] = C[i - 1][j - W[i]] + V[i];
				} else {
					C[i][j] = C[i - 1][j];
				}
			}
		}

		System.out.println(C[N][SPACE]);
	}
}
