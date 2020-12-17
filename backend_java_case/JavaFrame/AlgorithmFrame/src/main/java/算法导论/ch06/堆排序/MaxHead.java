package 算法导论.ch06.堆排序;

import java.util.Arrays;
/**
 * 
 * @author Administrator
 *
 */
public class MaxHead {

	public static void main(String[] args) {
		//int[] A = {16,4,10,14,7,9,3,2,8,1};
		int[] A = {4,1,3,2,16,9,10,14,8,7};
		//build_max_heap(A);
		A = HeapSort(A);
		//max_heapify(A, 1);
		System.out.println(Arrays.toString(A));
	}
	
	/**
	 * 堆排序:
	 * 每次排序都拿掉最大的点(同最后一个交换)
	 * 然后让数组的长度-1,调用堆排序,重新构建
	 * @param A
	 */
    public static int[] HeapSort(int[] A){
		
    	build_max_heap(A);
    	int[] C = new int[A.length];
    	
		for(int i=C.length; i>1; i--){
			
			int temp = A[i-1];
			A[i-1] = A[0];
			C[i-1] = A[0];
			A[0] = temp;
			int length = A.length - 1;
			//每次都让B的长度缩短1个距离,然后赋给A
			int[] B = new int[length];
			for(int k=0; k<length; k++){
				B[k] = A[k];
			}
			A = B;
			
			max_heapify(A, 1);
		}
		
		C[0] = A[0];
		
		return C;
	}
	
	/**
	 * 这里采用自底向上的方向构建
	 * 那么为什么构建堆要从数组的一半开始呢?
	 * 因为构建堆是要去比较子节点和左右节点的大小,显然构建二叉树后从树中个可以看出从一半开始比较就可以了
	 * 这里构建最大堆:
	 *   某个节点的值至多与其父节点一样大
	 *  注意并不是进行堆排序,排列的结果可能不是按顺序
	 * @param A
	 */
	public static void build_max_heap(int [] A){
		
		for(int i=A.length/2; i>0; i--){
			max_heapify(A, i);
		}
	}
	
	/**
	 * 
	 * 将一个数组变成二叉树,显然有个性质就是一个下标(i)若有节点则左孩子必然是2*i
	 * 右孩子则必然是2*i+1
	 * @param A
	 * @param i
	 * @param length
	 */
	public static void max_heapify(int[] A, int i){
		
		int l = 2*i;
		int r =2*i + 1;
		int largest = -1;
		//判断节点是不是有孩子,大于数组长度就是没有孩子了
		if(l <= A.length && A[l-1] > A[i-1]){
			System.out.println(A[l-1] + "," +  A[i-1]);
			largest = l;
		}else{
			largest = i;
		}
		
		if(r <= A.length && A[r-1] > A[largest-1]){
			System.out.println(A[r-1] + "," +  A[largest-1]);
			largest = r;
		}
		
		if(largest != i){
			
			int temp = A[i-1];
			A[i-1] = A[largest-1];
			A[largest-1] = temp;
			max_heapify(A,largest);
		}
	}
}
