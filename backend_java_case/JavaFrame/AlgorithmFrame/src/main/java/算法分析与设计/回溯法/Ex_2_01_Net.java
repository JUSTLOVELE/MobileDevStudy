package 算法分析与设计.回溯法;

/**
 * 网络版
 * @author Administrator
 *
 */
public class Ex_2_01_Net {

	int n = 5;
	int capacity = 10;
	int[] weight = { 2, 6, 4, 1, 5 };
	double[] value = { 6, 9, 6, 1, 4 };
	int maxValue = 0;
	int tempValue;
	int tempWeight;
	int[] way = new int[n];
	int[] bestWay = new int[n];

	public static void main(String[] args) {

		Ex_2_01 ex = new Ex_2_01();
		ex.BackTrack(0);
		System.out.println("该背包能够取到的最大价值为:"+ex.maxValue);  
        System.out.println("取出的方法为:");  
        for(int i : ex.bestWay)  
            System.out.print(i+"  ");  
	}

	public void BackTrack(int t) {
		// 已经搜索到根节点(就是TSP的第四层)
		if (t > n - 1) {
			if (tempValue > maxValue) {
				maxValue = tempValue;
				for (int i = 0; i < n; i++)
					bestWay[i] = way[i];
			}
			return;
		}
		// 搜索左边节点:装入,如果背包的容量是大于总容量,就干掉这一边
		if (tempWeight + weight[t] <= capacity) {
			tempWeight += weight[t];
			tempValue += value[t];
			way[t] = 1;
			BackTrack(t + 1);
			//如果没有搜索到跟节点就会回溯回这个位置,那就要减掉加上的部分,并且路径设为0
			tempWeight -= weight[t];
			tempValue -= value[t];
			way[t] = 0;
		}
		// 不装入这个物品，直接搜索右边的节点
		if (Bound(t + 1) >= maxValue) {
			BackTrack(t + 1);
		}
	}

	// 用于计算剩余物品的最高价值上界
	public double Bound(int k) {
		double maxLeft = tempValue;
		int leftWeight = capacity - tempWeight;
		// 尽力依照单位重量价值次序装剩余的物品
		while (k <= n - 1 && leftWeight > weight[k]) {
			leftWeight -= weight[k];
			maxLeft += value[k];
			k++;
		}
		// 不能装时，用下一个物品的单位重量价值折算到剩余空间。
		if (k <= n - 1) {
			maxLeft += value[k] / weight[k] * leftWeight;
		}
		return maxLeft;
	}
}
