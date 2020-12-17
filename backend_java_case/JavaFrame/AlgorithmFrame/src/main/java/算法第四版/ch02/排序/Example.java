package �㷨���İ�.ch02.����;

/**
 * �����չʾ������������ʵ�ֵĿ��,��������ѧϰ��ÿ�������㷨,
 * ���Ƕ���Ϊ����һ����ʵ��һ��sort()��������Example��Ϊ�㷨������
 * ���ģ���������κ�ʵ����Comparable�ӿڵ���������,����Date��(�Լ�д��)
 * @author Administrator
 *
 */
public class Example {

	public static void sort(Comparable[] a){
		
	}
	
	/**
	 * v<w : true
	 * v>w : false
	 * @param v
	 * @param w
	 * @return
	 */
	public static boolean less(Comparable v, Comparable w){
		
		return v.compareTo(w)<0;
	}
	
	public static void exch(Comparable[] a, int i, int j){
		
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	public static void show(Comparable[] a){
		
		for(int i=0; i<a.length; i++){
			System.out.print(a[i]);
		}
	}
	
	public static boolean isSorted(Comparable[] a){
		
		for(int i=1; i<a.length; i++)
			if(less(a[i], a[i-1])) 
				return false;
		return true;
	}
	
	public static void main(String[] args) {
		
		String[] a = {"B", "A", "D", "E"};
		sort(a);
		assert isSorted(a);
		show(a);
	}
}
