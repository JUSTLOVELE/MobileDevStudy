package �㷨���������.���ݷ�;

/**
 * 01����
 * @author Administrator
 *
 */
public class Ex_2_01 {

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
		System.out.println("�ñ����ܹ�ȡ��������ֵΪ:"+ex.maxValue);  
        System.out.println("ȡ���ķ���Ϊ:");  
        for(int i : ex.bestWay)  
            System.out.print(i+"  ");  
	}

	public void BackTrack(int t) {
		// �Ѿ����������ڵ�(����TSP�ĵ��Ĳ�)
		if (t > n - 1) {
			if (tempValue > maxValue) {
				maxValue = tempValue;
				for (int i = 0; i < n; i++)
					bestWay[i] = way[i];
			}
			return;
		}
		// ������߽ڵ�:װ��,��������������Ǵ���������,�͸ɵ���һ��
		if (tempWeight + weight[t] <= capacity) {
			tempWeight += weight[t];
			tempValue += value[t];
			way[t] = 1;
			BackTrack(t + 1);
			//���û�����������ڵ�ͻ���ݻ����λ��,�Ǿ�Ҫ�������ϵĲ���,����·����Ϊ0
			tempWeight -= weight[t];
			tempValue -= value[t];
			way[t] = 0;
		}
		// ��װ�������Ʒ��ֱ�������ұߵĽڵ�
		BackTrack(t + 1);
	}
}
