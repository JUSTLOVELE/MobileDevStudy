package �㷨����;

/**
 * ð������
 * ���������Ƿ����������ڵ�δ���������е�Ԫ��
 * ���������Ͳ���������ͬ����O(n2)
 * @author Administrator
 *
 */
public class BubbleSort {
	
	public static Integer[] sort(Integer[] nums){
		
		int length = nums.length;
		for(int i=0; i<length; i++){
			//ע��ѭ����ֹ������
			for(int j=length-1; j>i; j--){
				if(nums[j] < nums[j-1]){
					int temp = nums[j];
					nums[j] = nums[j-1];
					nums[j-1] = temp;
				}
			}
		}
		
		return nums;
	}
	
	public static void main(String[] args) {
		Integer[] objs = {3,2,4,5,1,6};
		objs = sort(objs);
		for(int num : objs){
			System.out.println(num);
		}
	}

}
