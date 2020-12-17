package 算法第四版.ch02.排序;

/**
 * 1.
 * 选择排序: 首先找到数组中最小的那个元素,将它和数组的第一个元素交换位置,
 * 然后再剩下的元素中找到最小的元素和第二个元素交换位置,如此往复,直到将整个数组排序
 * 对于长度为N的数组,选择排序需要大约N平方/2次比较和N次交换
 *   运行时间和输入无关,为了找出最小的元素而扫描一遍数组并不能为下一遍扫描提供什么信息,这种性质在某些情况下是缺点
 *因为使用选择排序的人可能会惊讶的发现,一个已经由序的数组或是主键全部相等的数组和一个元素随机排列的数组所用的排序时间竟然
 *一样长,我们将看到其他算法会更善于利用输入的初始状态
 *  它的数据移动是最少的,每次交换都会改变两个数组元素的值,因此选择排序用了N次交换-交换次数和数组的大小时线性关系,我们
 *将研究的其他任何算法都不具备这个特征(大部分的增长数量级都是线性对数或是平方级别)
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
