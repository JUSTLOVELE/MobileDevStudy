package 算法导论;

import java.util.HashMap;
import java.util.Map;



/**
 * 求解最大子数组,最大子数组只可能有三种情况，最大点和最小点都在左边，或者都在右边，或者一个左一个右，分别求解三种情况的值，再比较即可
 * @author yangzuliang
 *
 */
public class MaxArrayChild {
	
	public static void main(String[] args) {
		
		Integer[] i = new Integer[]{-1,3,4,-3,5,7,-2,-1,4};
		
		Map<String, Integer> ma = findMaxImumSubarray(i, 0, i.length-1);
		
		System.out.println(ma.toString());
		
	}
	
	public static Map<String, Integer> findMaxImumSubarray(Integer A[], int low, int high){
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		if(low == high){
			
			map.put("low", low);
			map.put("high", high);
			map.put("sum", A[low]);
			
			return map;
		}else{
			int mid = (low + high) / 2;
			
			Map<String, Integer> map1 = findMaxImumSubarray(A, low, mid);
			int left_low = map1.get("low");
			int left_high = map1.get("high");
			int left_sum = map1.get("sum");
			
			Map<String, Integer> map2 = findMaxImumSubarray(A, mid+1, high);
			int right_low = map2.get("low");
			int right_high = map2.get("high");
			int right_sum = map2.get("sum");
			
			Map<String, Integer> map3 = findMaxCrossingSubarray(A, low, mid, high);
			int cross_low = map3.get("low");
			int cross_high = map3.get("high");
			int cross_sum = map3.get("sum");
			
			if(left_sum >= right_sum && left_sum >= cross_sum){
				map.put("low", left_low);
				map.put("high", left_high);
				map.put("sum", left_sum);
				return map;
			}else if(right_sum >= left_sum && right_sum >= cross_sum){
				map.put("low", right_low);
				map.put("high", right_high);
				map.put("sum", right_sum);
				return map;
			}else{
				map.put("low", cross_low);
				map.put("high", cross_high);
				map.put("sum", cross_sum);
				return map;
			}
			
			
		}
	}
	
	public static Map<String, Integer> findMaxCrossingSubarray(Integer A[], int low, int mid, int high){
		
		//左数组
		Map<String, Integer> map1 = findLeftSubarray(A, low, mid);
		//System.out.println(map1.toString());
		//右数组
		Map<String, Integer> map2 = findRightSubarray(A, mid+1, high);
		//System.out.println(map2.toString());
		
		int left = map1.get("data");
		int right = map2.get("data");
		int all = left + right;
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("low", map1.get("index"));
		map.put("high", map2.get("index"));
		map.put("sum", map1.get("data") + map2.get("data"));
		
		return map;
	}
	
    public static Map<String, Integer> findRightSubarray(Integer A[], int mid, int high){
		
		int data = -1000;
		int temp = 0;
		int index = 0;
		Map<String, Integer> map = new HashMap<>();
		for(int i=mid; i<=high; i++){
			temp += A[i];
			if(temp > data){
				data = temp;
				index = i;
			}
		}
		
		map.put("index", index);
		map.put("data", data);
		
		return map;
	}
	
	public static Map<String, Integer> findLeftSubarray(Integer A[], int low, int mid){
		
		int data = -1000;
		int temp = 0;
		int index = 0;
		Map<String, Integer> map = new HashMap<>();
		for(int i=mid; i>=low; i--){
			temp += A[i];
			if(temp > data){
				data = temp;
				index = i;
			}
		}
		
		map.put("index", index);
		map.put("data", data);
		
		return map;
	}
	
	
	/**
	 * 求解跨越中点的子数组
	 * @param A
	 * @param low
	 * @param mid
	 * @param high
	 */
	
	/*public static Map<String, Integer> findMaxCrossingSubarray(Integer A[], int low, int mid, int high){
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		Map<String, Integer> leftMap = findMaxMumLeftSubarray(A, low, mid);
		
		
		Map<String, Integer> rightMap = findMaxMumRightSubarray(A, mid, high);
		
		map.put("mid_left", leftMap.get("max_left"));
		map.put("mid_right", rightMap.get("max_right"));
		map.put("mid_sum", leftMap.get("left_sum")+rightMap.get("right_sum"));
		
		return map;
	}*/
	
	/**
	 * 求解最大左子数组
	 * @param A
	 * @param low
	 * @param mid
	 * @return
	 *//*
	public static Map<String, Integer> findMaxMumLeftSubarray(Integer A[], int low, int mid){
		Map<String, Integer> map = new HashMap<String, Integer>();
		if(A != null && A.length >1){
			int leftSum = -100;//最大左子数组和
			int sum = 0; 
			int maxLeft = -10 ;//最大左子数组下标
			for(int i=mid; i<low; i--){
				sum += A[i];
				if(sum > leftSum){
					leftSum = sum;
					maxLeft = i;
				}
			}
			map.put("max_left", maxLeft);
			map.put("left_sum", leftSum);
		}
		
		return map;
		
	}
	
	*//**
	 * 求解最大有子数组
	 * @param A
	 * @param mid
	 * @param high
	 * @return
	 *//*
    public static Map<String, Integer>  findMaxMumRightSubarray(Integer A[], int mid, int high){
		Map<String, Integer> map = new HashMap<String, Integer>();
		if(A != null && A.length >1){
			int RightSum = -100;//最大左子数组和
			int sum = 0; 
			int maxRight = -10 ;//最大左子数组下标
			for(int i=mid+1; i<=high; i++){
				sum += A[i];
				if(sum > RightSum){
					RightSum = sum;
					maxRight = i;
				}
			}
			map.put("max_right", maxRight);
			map.put("right_sum", RightSum);
		}
		
		return map;
	}*/

}
