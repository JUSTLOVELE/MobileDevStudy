package �㷨���������.��ҵ4;

/**
 * ������� ĳ�������� 6 �־�����ͬ�߶�h����������Ϊ����Ĳ�Ʒ�������Ĺ��ֱ�Ϊ 1*1,2*2,3*3,4*4,5*5,6*6
 * ����Ҫ����Щ��Ʒ�ø߶�ͬ��Ϊh,������Ϊ6*6�����Ӱ�װ����,Ȼ�����͸��ͻ� �������һ���㷨���������ÿһ�����������Ͳ�Ʒ���������������
 * 
 * ����Ϊһ�У�����һ�������� ��������� 6 ������ numi �� 0<= i <= 5���� �м��ÿո������ ���δ����Ӧ��Ʒ��� 1*1�� 2*2��
 * 3*3�� 4*4�� 5*5�� 6*6�� ����Ҫ�Ĳ�Ʒ��Ŀ
 * 
 * @author Administrator
 * 
 */
public class Packets {

	public static void work() {

		int x1 = 0;
		int x2 = 0;
		int x3 = 0;
		int x4 = 3;
		int x5 = 5;
		int x6 = 4;
		int[] s = { 0, 5, 3, 1 };
		int c = x6 + x5 + x4 + (x3 + 3) / 4;
		int b = x4 * 5 + s[x3 % 4];

		if (x2 > b) {
			c += (x2 - b + 8) / 9;
		}
		int a = 36 * c - 36 * x6 - 25 * x5 - 16 * x4 - 9 * x3 - 4 * x2;
		if (x1 > a) {
			c += (x1 - a + 35) / 36;
		}
		
		System.out.println(c);
	}

	public static void main(String[] args) {

		work();
		// int[] p = new int[] { 7, 5, 1, 0, 0, 0 };
		int[] p = new int[] { 0, 0, 0, 3, 5, 4 };
		int packet = 0;
		packet += p[5];

		for (int i = 4; i >= 0; i--) {

			for (; p[i] > 0;) {

				int area = (i + 1) * (i + 1);
				int num = 36 / area;
				for (; num > 0 && p[i] > 0; num--) {
					p[i]--;
				}
				int remain = 36 % area + num * area;
				int a = i;

				while (remain > 0 && a > 0) {
					a--;
					area = (a + 1) * (a + 1);
					if (remain > area && p[a] > 0) {
						num = remain / area;
						for (; num > 0 && p[a] > 0; num--) {
							p[a]--;
						}
					}
					remain = remain % area + num * area;
				}
				packet++;
			}
		}

		System.out.println(packet);
	}
}
