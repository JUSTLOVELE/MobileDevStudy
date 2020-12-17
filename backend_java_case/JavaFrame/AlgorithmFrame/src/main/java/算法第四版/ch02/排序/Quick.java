package 算法第四版.ch02.排序;
/**
 * 6.快速排序
 *  概述:
 *   它可能是应用最广泛的排序算法了,快速排序流行的原因是它实现简单,适用于各种不同的输入数据,且在一般应用中比其他排序算法都要快的多,快速
 *排序引人注目的特点包括它是原地排序(只需要一个很小的辅助栈),且将长度为N的数据排序所需的时间和NlgN成正比。另外它的内循环比大多数排序算
 *法都要短小,这意味着它无论是在理论上还是在实际中都要更快,它的主要缺点是非常脆弱,在实现时要非常小心才能避免低劣的性能
 *  基本算法:
 *   它是一种分治的排序算法,它将一个数组分为两个子数组,将两部分独立的排序,当两个子数组都有序时,数组就有序了,在归并排序中,一个数组被等分
 *为两半,在快速排序中,切分位置取决与数组的内容
 *  性能特点:
 *   快速排序切分方法的内循环会用一个递增的索引将数组元素和一个定值比较,很难想象排序算法中还能有比这个更短小的内循环了,例如,归并排序和希尔排序
 *一般都比快速排序慢,其原因就是它们还在内循环中移动数据
 * @author yangzuliang
 *
 */
public class Quick extends Example{
	
	public static void sort(Comparable[] a){
		//清除对输入的依赖
		Stdrandom.shuffle(a);
		sort(a, 0, a.length-1);
	}
	
	private static void sort(Comparable[] a, int lo, int hi){
		
		if(hi <=lo) return;
		int j = partition(a, lo, hi); //切分
		sort(a, lo, j-1);//将左半部分a[lo .. j-1]排序
		sort(a, j+1, hi);//将右半部分a[j+1 .. hi]排序
	}
	
	/**
	 * 该方法的关键在于切分:这个过程使得数组满足下面三个条件:
	 *  1.对于某个j,a[j]已经排定
	 *  2.a[lo]到a[j-1]中的所有元素都不大于a[j]
	 *  3.a[j+1]到a[hi]中的所有元素都不小于a[j]
	 *  就是通过递归地调用切分来排序的
	 * @param a
	 * @param lo
	 * @param hi
	 * @return
	 */
	private static int partition(Comparable[] a, int lo, int hi){
		//将数组切分为a[lo..i-1], a[i], a[i+1..hi]
		int i=lo, j=hi + 1; //左右扫描指针
		Comparable v = a[lo]; //切分元素
		while(true){
			//扫描左右,检查扫描是否结束并交换元素
			//从数组的左端开始向右扫描,知道找到一个大于等于切分元素的元素,再从数组的右端开始
			//a[++i] >= v
			while(less(a[++i], v)){
				//左->右扫描
				if(i==hi) break;
			}
			//从右向左扫描直到找到一个小于等于它的元素,这两个元素显然是没有排定的,因此交换他们的位置
			// v >= a[--j]
			while(less(v, a[--j])){
				//右->左扫描
				if(j==lo) break;
			}
			//如此我们就可以保证左指针i的左侧元素都不大于切分元素,右指针j的右侧元素都不小于切分元素
			//相遇时,我们只需要将切分元素a[lo]和左子数组最右侧的元素a[j]交换然后返回j即可
			if(i>=j) {
				break;
			}
			//i位置的数据肯定是大于a[lo]的,j位置的数据肯定是小于a[lo]的,所以交换i,j可以达到我们的目的
			exch(a, i, j);
		}
		//将v=a[j]放入正确的位置
		exch(a, lo, j);
		//a[lo..j-1]<=a[j]<=a[j+1..hi]完成
		return j;
	}
	
	public static void main(String[] args) {
		
		Integer[] a ={1,2,3,4,5,6,7};
		sort(a);
		show(a);
	}

}
