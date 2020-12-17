package leetcode;

import java.util.Arrays;

import org.junit.Test;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
   You may assume that each input would have exactly one solution.
   example:
   Given nums = [2, 7, 11, 15], target = 9,
   Because nums[0] + nums[1] = 2 + 7 = 9,
   return [0, 1].
 * @author Administrator
 *
 */
public class TwoSum {
	
	@Test
	public void work(){
		
		int[] nums = {0, 4 , 3, 0};
		int target = 0;
		System.out.println(Arrays.toString(twoSum(nums, target)));
	}
	
	public int[] twoSum(int[] nums, int target) {
		int [] arrays = nums.clone();
		Arrays.sort(nums);
		int left = 0;
		int right = nums.length-1;
		while(left < right){
			int sum = nums[left] + nums[right];
			if(sum == target){
				break;
			}else if(sum > target){
				right = right -1;
			}else {
				left = left + 1;
			}
		}
		int[] a = {-1,-1};
		for(int i=0; i<arrays.length; i++){
			if(arrays[i] == nums[left]){
				if(a[0] == -1){
					a[0] = i;
				}
			}
			if(arrays[i] == nums[right]){
				a[1] = i;
			}
		}
		return a;
	}
}
