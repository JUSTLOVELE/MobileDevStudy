package 算法导论;

import java.util.Arrays;


/**
 * 归并排序:又叫快速排序,使冒泡排序的一种改进
 * 将两个(或两个以上有序表合并成一个新的有序表，即把待排序序列分为若干个子序列，每个序列都是有序的，然后再把有序子序列合并
 * 为整体有序序列
 * 当归并排序足够小时，可以考虑用插入排序使归并叶变粗
 * 时间复杂度是O(nlogn)
 * @author yangzuliang
 *
 */
public class MergeSort {
	
	public static void main(String[] args) {
	
		Integer[] nums = {1, 9, 8, 2, 3, 6  };
		MERGE_SORT(nums, 1, 6);
		//MERGE(nums, 1, 3, 6);
	}
	
	/**
	 * 详细工作过程
	 *递归
	 *  条件是p<r ,当递归到p>=r时就不会再递归了，就切回去执行，那么显然，它只会比较最近两个位置的数
	 * @param A
	 * @param p
	 * @param r
	 */
	public static void MERGE_SORT(Integer[] A, int p, int r){
		if(p<r){
			int q =(p+r)/2;
			MERGE_SORT(A, p, q);
			MERGE_SORT(A, q+1, r);
			MERGE(A, p, q, r);
		}
	}
	/**
	 * 详细工作过程：
	 * 1.初始化
	 *   1.1.计算A[p,q]的长度n1,A[q,r]的长度n2
	 *   1.2.创建数组A1，A2对应上面2个分割的数组，将哨兵放在最后
	 * 2.保持
	 *   2.1.维持循环不变式，比较A1，A2的大小，小的就放进A中
	 * 3.终止
	 *   两个数组都循环完毕
	 * @param A
	 * @param p
	 * @param q
	 * @param r
	 */
	public static void MERGE(Integer[] A, int p, int q, int r){
		int n1 = q - p + 1;
		int n2 = r - q;
		Integer[] A1 = new Integer[n1 + 1];
		Integer[] A2 = new Integer[n2 + 1];
		for(int i=0; i<n1; i++){
			A1[i] = A[i + p - 1];
		}
		for(int i=0; i<n2; i++){
			A2[i] = A[q + i];
		}
		A1[n1] = 1000;
		A2[n2] = 1000;
		System.out.println(Arrays.toString(A1));
		System.out.println(Arrays.toString(A2));
		
		int i = 0;
		int j = 0;
		
		for(int k=p-1; k<r; k++){
			if(A1[i] <= A2[j]){
				A[k] = A1[i];
				i++;
			}else{
				A[k] = A2[j];
				j++;
			}
		}
		
		System.out.println(Arrays.toString(A));
		
	}
}  

