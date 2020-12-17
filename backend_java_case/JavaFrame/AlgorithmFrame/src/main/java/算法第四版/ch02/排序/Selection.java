package �㷨���İ�.ch02.����;

/**
 * 1.
 * ѡ������: �����ҵ���������С���Ǹ�Ԫ��,����������ĵ�һ��Ԫ�ؽ���λ��,
 * Ȼ����ʣ�µ�Ԫ�����ҵ���С��Ԫ�غ͵ڶ���Ԫ�ؽ���λ��,�������,ֱ����������������
 * ���ڳ���ΪN������,ѡ��������Ҫ��ԼNƽ��/2�αȽϺ�N�ν���
 *   ����ʱ��������޹�,Ϊ���ҳ���С��Ԫ�ض�ɨ��һ�����鲢����Ϊ��һ��ɨ���ṩʲô��Ϣ,����������ĳЩ�������ȱ��
 *��Ϊʹ��ѡ��������˿��ܻᾪ�ȵķ���,һ���Ѿ�����������������ȫ����ȵ������һ��Ԫ��������е��������õ�����ʱ�侹Ȼ
 *һ����,���ǽ����������㷨���������������ĳ�ʼ״̬
 *  ���������ƶ������ٵ�,ÿ�ν�������ı���������Ԫ�ص�ֵ,���ѡ����������N�ν���-��������������Ĵ�Сʱ���Թ�ϵ,����
 *���о��������κ��㷨�����߱��������(�󲿷ֵ������������������Զ�������ƽ������)
 * @author Administrator
 * 
 */
public class Selection {
	
	public static void main(String[] args) {
		
		Comparable[] a = {10,9,8,7,6,5,4,3,2,1,0};
		sort(a);
		show(a);
	}

	public static void sort(Comparable[] a) {

		int N = a.length;
		for (int i = 0; i < N; i++) {
			int min = i;
			for (int j = i + 1; j < N; j++) {

				if(less(a[j], a[min])){
					min = j;
				}
			}
			
			exch(a, i, min);
		}
		
		//show(a);
	}

	public static boolean less(Comparable v, Comparable w) {

		return v.compareTo(w) < 0;
	}

	private static void exch(Comparable[] a, int i, int j) {

		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
    private static void show(Comparable[] a){
		
		for(int i=0; i<a.length; i++){
			System.out.println(a[i]);
		}
	}

}
