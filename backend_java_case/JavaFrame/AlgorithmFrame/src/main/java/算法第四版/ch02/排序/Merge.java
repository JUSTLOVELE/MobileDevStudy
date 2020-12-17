package 算法第四版.ch02.排序;
/**
 * 5.归并排序
 *   归并操作:将两个有序的数组归并成一个更大的有序数组
 *   归并排序最吸引人的性质是它能够保证任意长度为N的数组排序所需时间和NlogN成正比,它的主要缺点则是它所需的额外空间和N成正比
 *   实现归并的一种直截了当的办法是将两个不同的有序数组归并到第三个数组中,两个数组中的元素应该都实现了Comparable接口,实现方法很简单
 * 创建一个适当大小的数组然后将两个输入数组中的元素一个个从小到大放入这个数组中
 *   但是,当用归并将一个大数组排序时,我们需要进行很多次归并,因此在每次归并时都创建个新数组来存储排序结果会带来问题,我们更希望有一种能够在原地归并的
 *方法,这样就可以先将前半部分排序,再讲后半部分排序,然后数组中移动元素而不需要使用额外的空间
 *
 * 排序算法的复杂度:
 *  研究复杂度的第一步是建立一个计算模型,一般来说会尽量寻找一个和问题相关的最简单的模型,对排序来说,我们研究对象时基于比较的算法,他们对数组
 * 元素的操作方式是由主键的比较决定的,一个基于比较的算法在两次比较之间可能会进行任意规模的计算,但它只能通过主键之间的比较得到关于某个主键的
 * 信息(因为我们局限于实现了Comparable接口的对象)
 *  命题I：没有任何基于比较的算法能够保证使用少于lg(N!)~NlgN次比较将长度为N的数组排序
 *
 * @author yangzuliang
 *
 */
public class Merge extends Example{
	
	private static Comparable[] aux; //辅助数组
	
	public static void sort(Comparable[] a){
		
		aux = new Comparable[a.length];//一次性分配空间
		sort(a, 0, a.length-1);
	}
	
	private static void sort(Comparable[] a, int lo, int hi){
		//将数组a[lo..hi]排序
		if(hi <= lo){
			return ;
		}
		int mid = lo + (hi-lo)/2;
		sort(a, lo, mid);//左半边排序
		sort(a, mid+1, hi);//右半边排序
		merge(a, lo, mid, hi);//归并结果
	}

	public static void merge(Comparable[] a, int lo, int mid, int hi){
		//将a[lo..mid]和a[mid+1...hi]归并
		int i = lo, j = mid + 1;
        //将a[lo..hi]复制到aux[lo..hi]
		for(int k = lo; k<= hi; k++){
			aux[k] = a[k];
		}
		//归并回到a[lo..hi]
		for(int k=lo; k<=hi; k++){
			if(j > mid){
				a[k] = aux[j++];
			}else if(j > hi) {
				a[k] = aux[i++];
			}else if(less(aux[j], aux[i])){
			    a[k] = aux[j++];	
			}else{
				a[k] = aux[i++];
			}
		}
	}
}
