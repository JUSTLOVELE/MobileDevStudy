package 算法第四版.ch01.基础;

import java.util.Arrays;

/**
 * 浜屽垎鏌ユ壘
 * @author yangzuliang
 *
 */
public class BinarySearch {
	/**
	 * 二分查找
	 * 二分查找又称折半查找，优点是比较次数少，查找速度快，平均性能好；
	 * 其缺点是要求待查表为有序表，且插入删除困难。因此，折半查找方法适用于不经常变动而查找频繁的有序列表。
	 * 首先，假设表中元素是按升序排列，将表中间位置记录的关键字与查找关键字比较，如果两者相等，
	 * 则查找成功；否则利用中间位置记录将表分成前、后两个子表，如果中间位置记录的关键字大于查找关键字，
	 * 则进一步查找前一子表，否则进一步查找后一子表。重复以上过程，直到找到满足条件的记录，使查找成功，或直到子表不存在为止，此时查找不成功
	 * @param key
	 * @param a
	 * @return
	 */
	public static int rank(int key, int[] a){
		//查找下标
		int lo = 0;
		int hi = a.length - 1;
		while(lo <= hi){
			int mid = lo + (hi -lo) / 2;
			if(key < a[mid]){
				hi = mid - 1;
			}else if( key > a[mid]){
				lo = mid + 1;
			}else{
				return mid;
			}
		}
		return -1;
	}
	 public static void main(String[] args) {
		int[] whitelist = {6,5,3,7,4,9};
		Arrays.sort(whitelist);
		int target = rank(3, whitelist);
		System.out.println(whitelist[target]);
	}

}
