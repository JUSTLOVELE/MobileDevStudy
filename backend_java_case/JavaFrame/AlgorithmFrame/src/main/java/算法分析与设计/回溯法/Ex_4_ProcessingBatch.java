package 算法分析与设计.回溯法;

/**
 * 批处理作业调度 给定n个作业的集合{J1,J2,J3...Jn},每个作业必须先由机器1处理,然后由机器2处理,
 * 作业Ji需要机器j的处理时间为tji,对于一个确定的作业调度,设Fji是作业i在机器j上完成
 * 处理的时间,所有作业在机器2上完成处理的时间和称为该作业调度的完成时间和，
 * 批处理作业调度问题要求对于给定的n个作业,制定最佳作业调度方案,使其完成时间和达到最小
 * 显然,批处理作业的一个最优调度应使机器1没有空闲时间,且机器2的空闲时间最小,可以证明, 存在一个最优作业调度使得在机器1和机器2上作业以相同次序完成
 * 
 * @author Administrator
 * 
 */
public class Ex_4_ProcessingBatch {

	int n; // 作业数；
	int f1; // 机器1完成处理时间；
	int f; // 完成时间和；
	int bestf; // 当前最优值；

	int[][] m; // 各作业所需的处理时间；
	int[] x; // 当前作业调度；
	int[] bestx; // 当前最优作业调度；
	int[] f2; // 机器2完成处理时间；

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
		System.out.println("当前最优值:" + bestf);
		System.out.println("当前最优作业调度");
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
			System.out.println("每条深度优先搜索结果为：" + bestf);

		} else
			for (int j = i; j <= n; j++) {
				f1 += m[x[j]][0];
				f2[i] = ((f2[i - 1] > f1) ? f2[i - 1] : f1) + m[x[j]][1];
				f += f2[i];
				//剪枝函数
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
