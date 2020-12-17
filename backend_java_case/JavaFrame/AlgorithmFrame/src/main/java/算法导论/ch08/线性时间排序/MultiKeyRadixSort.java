package 算法导论.ch08.线性时间排序;

import java.util.Arrays;

import 算法导论.BaseService;

/**
 * 基数排序
 *  比如一个最大位是3位的数据进行排序,先比较个位,再比较十位,最后比较百位
 *  当每位数字都在0到k-1区间内(这样它就有k个可能的取值),且k的值不太大的时候,计数排序使一个好的选择,
 *对于n个d位数来说,每一轮排序耗时O(n+k),共有d轮,因此基数排序的总时间为O(d(n+k))
 *当d为常数且k=O(n)时,基数排序具有线性的时间代价,更一般的情况中,我们可以灵活的决定如何将每个关键字分解
 *为若干位
 * 那么基数排序是否比快排更好呢?
 *  快排是原址排序,而基数排序显然不是,因此当主存容量比较宝贵时,我们可能会更倾向于快速排序这样的原址排序
 * @author Administrator
 * 
 */
public class MultiKeyRadixSort extends BaseService {

	public static void main(String[] args) {
		int[] data = {3,2,3,2,5,333,45566,2345678,78,990,12,432,56}; 
		print(data);
		radixSort(data, 10, 7);
		print(data);
	}

	/**
	 * 
	 * @param array
	 * @param radix
	 *            :基数
	 * @param distance
	 *            :代表排序元素的位数
	 */
	public static void radixSort(int[] array, int radix, int distance) {

		int length = array.length;
		int[] temp = new int[length];// 用于暂存元素
		int[] count = new int[radix];// 用于基数排序
		int divide = 1;

		for (int i = 0; i < distance; i++) {

			System.arraycopy(array, 0, temp, 0, length);
			Arrays.fill(count, 0);

			for (int j = 0; j < length; j++) {
				//求不同位数的数字,然后计数
				int tempKey = (temp[j] / divide) % radix;
				count[tempKey]++;
			}

			for (int j = 1; j < radix; j++) {
				count[j] = count[j] + count[j - 1];
			}

			for (int j = length - 1; j >= 0; j--) {
				int tempKey = (temp[j] / divide) % radix;
				count[tempKey]--;
				array[count[tempKey]] = temp[j];
			}

			divide = divide * radix;
		}
	}
}
