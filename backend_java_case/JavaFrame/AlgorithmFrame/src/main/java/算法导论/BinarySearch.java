package 算法导论;

/**
 * 二分查找
 * 一个有序的序列进行折半查找,每次比较中间的大小来判断界限
 * 最坏运行时间为O(lgn)
 * @author Administrator
 *
 */
public class BinarySearch extends BaseService{
	
	public static void main(String[] args) {
		int[] nums = reduceArray(10, 10);
		for(int i=0; i<nums.length; i++){
			System.out.print(nums[i] + ",");
		}
		System.out.println("");
		//find(nums, 9);
		int a =find2(nums, 8, 0, nums.length-1);
		System.out.println(a);
	}
	
	public static int find2(int[] a, int x, int l, int r){
		
		while(r>=l){
			int m = (l+r)/2;
			if(x == a[m]){
				return m;
			}
			
			if(x<a[m]){
				r = m-1;
			}else{
				l = m+1;
			}
		}
		
		return -1;
	}
	
	public static void find(Integer[] nums, Integer target){
		if(nums != null && target != null){
			int length = nums.length;
			int mid = length/2;
			if(nums[mid] == target){
				System.out.println("find");
				return ;
					
			}else if(nums[mid] < target){
				Integer[] temps = new Integer[length - mid];
				for(int i=0; i<temps.length; i++){
					temps[i] = nums[i+mid];
				}
				find(temps, target);
			}else{
				Integer[] temps = new Integer[mid];
				for(int i=0; i<mid; i++){
					temps[i] = nums[i];
				}
				find(temps, target);
			}
		}else{
			System.out.println("params is contain null");
		}
	}

}
