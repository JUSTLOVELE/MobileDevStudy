package �㷨����.ch06.������;

import java.util.Arrays;

/**
 * ��С��
 * ͬ����һ������������ʱ���ڹ����һ����С��
 * @author Administrator
 *
 */
public class MinHead {

	public static void main(String[] args) {
		//int[] A = {16,4,10,14,7,9,3,2,8,1};
		int[] A = {4,1,3,2,16,9,10,14,8,7};
		//build_min_heap(A);
		A = HeapSort(A);
		for(int a : A){
			System.out.print(a + " ");
		}
	}
	
	public static int[] HeapSort(int[] A){
		
		build_min_heap(A);
		System.out.println(Arrays.toString(A));
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
			min_heapify(A, 1);
		}
		
		C[0] = A[0];
		
		return  C;
	}
	
	public static void build_min_heap(int [] A){
		
		for(int i=A.length/2; i>0; i--){
			min_heapify(A, i);
		}
	}
	
	public static void min_heapify(int[] A, int i){
		
		int leftNode = 2*i;//���ӽڵ�
		int rightNode = 2*i + 1;//���ӽڵ�
		int min = Integer.MIN_VALUE;
		
		if(leftNode <= A.length && A[leftNode-1] < A[i-1]){
			//���Ӵ���,��������С�ڸ��ڵ�
			min = leftNode;
		}else{
			min = i;
		}
		
		if(rightNode <= A.length && A[rightNode-1] < A[min-1]){
			//�Һ��Ӵ���,�����Һ���С������
			min = rightNode;
		}
		
		if(min != i){
			
			int temp = A[i-1];
			A[i-1] = A[min-1];
			A[min-1] = temp;
			min_heapify(A, min);
		}
	}
}
