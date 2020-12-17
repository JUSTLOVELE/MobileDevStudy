package leetcode;

import java.util.Arrays;

import org.junit.Test;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * ex1:
 * nums1 = [1, 3];nums2 = [2]; The median is 2.0
 * ex2:
 * nums1 = [1, 2];nums2 = [3, 4]; The median is (2 + 3)/2 = 2.5
 * @author yangzuliang
 *
 */
public class FindMedianSortedArrays {

	@Test
	public void work() {

		int[] a = new int[]{};
		int[] b = new int[]{1};
		double c = findMedianSortedArrays(a, b);
		System.out.println(c);
	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {

		int m = nums1.length;
		int n = nums2.length;
		int [] nums = new int[m+n];
		int i=0;
		
		while( m!=0 && n!=0 ){
			
			if(nums1[m-1] > nums2[n-1]){
				nums[i] = nums1[m-1];
				m--;
			}else{
				nums[i] = nums2[n-1];
				n--;
			}
			i++;
		}
		
		if(m != 0){
			
			while(m!=0){
				nums[i] = nums1[m-1]; 
				m--;
				i++;
			}
		}
		
        if(n != 0){
			
			while(n!=0){
				nums[i] = nums2[n-1]; 
				n--;
				i++;
			}
		}
        
        int length = nums.length;
        double result = 0.0;
        
        if(length%2 == 0){
        	
        	length = length / 2;
        	result = Double.valueOf(nums[length] + nums[length - 1]) / 2;
        	
        }else{
        	length = (length-1)/2;
        	result = Double.valueOf(nums[length]);
        }
        
		return result;
	}
}
