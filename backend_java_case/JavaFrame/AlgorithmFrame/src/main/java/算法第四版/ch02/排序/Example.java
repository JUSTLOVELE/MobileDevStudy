package 算法第四版.ch02.排序;

/**
 * 这个类展示的是数组排序实现的框架,对于我们学习的每种排序算法,
 * 我们都会为这样一个类实现一个sort()方法并将Example改为算法的名称
 * 这个模板适用于任何实现了Comparable接口的数据类型,例如Date类(自己写的)
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
