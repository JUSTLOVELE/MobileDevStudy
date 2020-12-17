package �㷨���������.�ݹ�ͷ��β���;

/**
 * ��������
 * @author yangzuliang
 *
 */
public class Ex_7_BinarySearch {

	
	public static int binarySearch(int key, int[] a){
		
		int lo = 0;
		int length = a.length - 1;
		
		while(lo <= length){
			
			int mid = (lo+length)/2;
			
			if(key == a[mid]){
				return mid;
			}else if(key > a[mid]){
				lo = mid + 1;
			}else {
				length = mid - 1;
			}
		}
		
		return -1;
	}
}
