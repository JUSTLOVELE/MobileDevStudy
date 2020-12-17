package �㷨����.ch06.������;

import java.util.Arrays;

interface MinPriorityInterface<Item> {

	void insert(int x);// ��Ԫ��x����S��

	int minium();// ����s�е���СԪ��

	int head_extract_Min();// ȥ��������S�о�����С���ֵ�Ԫ��

	void heap_increase_key(int x, int k);// ��Ԫ��x�Ĺؼ������ӵ�k,�������k��ֵ��С��x��ԭ�ؼ���ֵ(��ʵ�����滻)
}

/**
 * �ѵĳ���Ӧ��:���ȶ���(��С) �������еĲ�����������O(lgn)��ʱ�������
 * 
 * @author Administrator
 * 
 */
public class MinPriorityQueue implements MinPriorityInterface {

	private int[] priorityQueue;
	
	public static void main(String[] args) {
		// int[] A = {16,4,10,14,7,9,3,2,8,1};
		int[] A = { 4, 1, 3, 2, 16, 9, 10, 14, 8, 7 };
		MinPriorityQueue min = new MinPriorityQueue(A);
		System.out.println(Arrays.toString(min.priorityQueue()));
		System.out.println(min.minium());
		min.insert(13);
		System.out.println(Arrays.toString(min.priorityQueue()));
		System.out.println(min.head_extract_Min());
		System.out.println(Arrays.toString(min.priorityQueue()));
		System.out.println(Arrays.toString(min.HeapSort(min.priorityQueue)));
	}

	public MinPriorityQueue(int[] A) {
		priorityQueue = A;
		build_min_heap(priorityQueue);
	}

	@Override
	public void insert(int x) {

		int[] A = new int[priorityQueue.length + 1];

		for (int i = 0; i < priorityQueue.length; i++) {
			A[i] = priorityQueue[i];
		}

		A[priorityQueue.length] = x;
		priorityQueue = A;
		build_min_heap(priorityQueue);
	}

	@Override
	public int minium() {
		return priorityQueue[0];
	}

	@Override
	public int head_extract_Min() {

		int min = priorityQueue[0];
		int[] A = new int[priorityQueue.length - 1];

		for (int i = 0; i < A.length; i++) {
			A[i] = priorityQueue[i + 1];
		}

		priorityQueue = A;
		min_heapify(A, 1);

		return min;
	}

	@Override
	public void heap_increase_key(int x, int key) {

		if (key < priorityQueue[x]) {
			throw new RuntimeException("key is smaller than current key");
		}

		priorityQueue[x] = key;
		int parent = parent(x);
		// ���ڵ��ֵ��С�ں��ӽڵ���Լ�x���Ǹ��ڵ�,�ͽ���ѭ��
		while (x > 1 && priorityQueue[parent] > priorityQueue[x]) {

			int temp = priorityQueue[x];
			priorityQueue[x] = priorityQueue[parent];
			priorityQueue[parent] = temp;
			x = parent;
			parent = parent(x);
		}
	}
	
	private int parent(int x){
		
		if(x%2 == 0){
			return (x/2)-1;
		}else{
			return x/2;
		}
	}

	public int[] HeapSort(int[] A) {

		build_min_heap(A);
		int[] C = new int[A.length];

		for (int i = C.length; i > 1; i--) {

			int temp = A[i - 1];
			A[i - 1] = A[0];
			C[i - 1] = A[0];
			A[0] = temp;
			int length = A.length - 1;
			// ÿ�ζ���B�ĳ�������1������,Ȼ�󸳸�A
			int[] B = new int[length];
			for (int k = 0; k < length; k++) {
				B[k] = A[k];
			}
			A = B;
			min_heapify(A, 1);
		}

		C[0] = A[0];

		return C;
	}

	public void build_min_heap(int[] A) {

		for (int i = A.length / 2; i > 0; i--) {
			min_heapify(A, i);
		}
	}

	public void min_heapify(int[] A, int i) {

		int leftNode = 2 * i;// ���ӽڵ�
		int rightNode = 2 * i + 1;// ���ӽڵ�
		int min = Integer.MIN_VALUE;

		if (leftNode <= A.length && A[leftNode - 1] < A[i - 1]) {
			// ���Ӵ���,��������С�ڸ��ڵ�
			min = leftNode;
		} else {
			min = i;
		}

		if (rightNode <= A.length && A[rightNode - 1] < A[min - 1]) {
			// �Һ��Ӵ���,�����Һ���С������
			min = rightNode;
		}

		if (min != i) {

			int temp = A[i - 1];
			A[i - 1] = A[min - 1];
			A[min - 1] = temp;
			min_heapify(A, min);
		}
	}

	public int[] priorityQueue() {
		return priorityQueue;
	}
}
