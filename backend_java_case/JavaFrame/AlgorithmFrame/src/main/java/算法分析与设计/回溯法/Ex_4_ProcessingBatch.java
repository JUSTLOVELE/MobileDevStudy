package �㷨���������.���ݷ�;

/**
 * ��������ҵ���� ����n����ҵ�ļ���{J1,J2,J3...Jn},ÿ����ҵ�������ɻ���1����,Ȼ���ɻ���2����,
 * ��ҵJi��Ҫ����j�Ĵ���ʱ��Ϊtji,����һ��ȷ������ҵ����,��Fji����ҵi�ڻ���j�����
 * �����ʱ��,������ҵ�ڻ���2����ɴ����ʱ��ͳ�Ϊ����ҵ���ȵ����ʱ��ͣ�
 * ��������ҵ��������Ҫ����ڸ�����n����ҵ,�ƶ������ҵ���ȷ���,ʹ�����ʱ��ʹﵽ��С
 * ��Ȼ,��������ҵ��һ�����ŵ���Ӧʹ����1û�п���ʱ��,�һ���2�Ŀ���ʱ����С,����֤��, ����һ��������ҵ����ʹ���ڻ���1�ͻ���2����ҵ����ͬ�������
 * 
 * @author Administrator
 * 
 */
public class Ex_4_ProcessingBatch {

	int n; // ��ҵ����
	int f1; // ����1��ɴ���ʱ�䣻
	int f; // ���ʱ��ͣ�
	int bestf; // ��ǰ����ֵ��

	int[][] m; // ����ҵ����Ĵ���ʱ�䣻
	int[] x; // ��ǰ��ҵ���ȣ�
	int[] bestx; // ��ǰ������ҵ���ȣ�
	int[] f2; // ����2��ɴ���ʱ�䣻

	public static void main(String[] args) {

		Ex_4_ProcessingBatch fs = new Ex_4_ProcessingBatch();
		fs.ShowTest();
	}

	public void ShowTest() {
		n = 3;
		bestf = Integer.MAX_VALUE;
		f1 = 0;
		f = 0;

		int[][] m = { { 0, 0 }, { 2, 1 }, { 3, 1 }, { 2, 3 } };
		int[] x = { 0, 1, 2, 3 };
		int[] bestx = { 0, 1, 2, 3 };
		f2 = new int[4];
		this.m = m;
		this.x = x;
		this.bestx = bestx;
		this.f2 = f2;

		backtrack(1);
		System.out.println("��ǰ����ֵ:" + bestf);
		System.out.println("��ǰ������ҵ����");
		for (int i = 1; i <= n; i++) {
			System.out.print(bestx[i] + "  ");
		}
	}

	public static int[] swap(int[] x, int i, int j) {
		// int[] returnString=new int[3];
		int ss;
		ss = x[j];
		x[j] = x[i];
		x[i] = ss;
		return x;
	}

	private void backtrack(int i) {

		if (i > n) {
			
			for (int j = 1; j <= n; j++) {
				bestx[j] = x[j];
				//System.out.print(x[j] + " ");
			}
			System.out.println();
			bestf = f;
			System.out.println("ÿ����������������Ϊ��" + bestf);

		} else
			for (int j = i; j <= n; j++) {
				f1 += m[x[j]][0];
				f2[i] = ((f2[i - 1] > f1) ? f2[i - 1] : f1) + m[x[j]][1];
				f += f2[i];
				//��֦����
				if(f<bestf){
				//if (true) {
					swap(x, i, j);
					backtrack(i + 1);
					swap(x, i, j);
				}
				f1 -= m[x[j]][0];
				f -= f2[i];
			}
	}
}
