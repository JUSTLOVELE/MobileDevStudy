package �㷨����.ch06.������;

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
	 * ������:
	 * ÿ�������õ����ĵ�(ͬ���һ������)
	 * Ȼ��������ĳ���-1,���ö�����,���¹���
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
			//ÿ�ζ���B�ĳ�������1������,Ȼ�󸳸�A
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
	 * ��������Ե����ϵķ��򹹽�
	 * ��ôΪʲô������Ҫ�������һ�뿪ʼ��?
	 * ��Ϊ��������Ҫȥ�Ƚ��ӽڵ�����ҽڵ�Ĵ�С,��Ȼ����������������и����Կ�����һ�뿪ʼ�ȽϾͿ�����
	 * ���ﹹ������:
	 *   ĳ���ڵ��ֵ�������丸�ڵ�һ����
	 *  ע�Ⲣ���ǽ��ж�����,���еĽ�����ܲ��ǰ�˳��
	 * @param A
	 */
	public static void build_max_heap(int [] A){
		
		for(int i=A.length/2; i>0; i--){
			max_heapify(A, i);
		}
	}
	
	/**
	 * 
	 * ��һ�������ɶ�����,��Ȼ�и����ʾ���һ���±�(i)���нڵ������ӱ�Ȼ��2*i
	 * �Һ������Ȼ��2*i+1
	 * @param A
	 * @param i
	 * @param length
	 */
	public static void max_heapify(int[] A, int i){
		
		int l = 2*i;
		int r =2*i + 1;
		int largest = -1;
		//�жϽڵ��ǲ����к���,�������鳤�Ⱦ���û�к�����
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
