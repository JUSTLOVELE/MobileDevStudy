package 算法导论.ch06.堆排序;

import java.util.Arrays;

interface MinPriorityInterface<Item> {

	void insert(int x);// 把元素x插入S中

	int minium();// 返回s中的最小元素

	int head_extract_Min();// 去掉并返回S中具有最小键字的元素

	void heap_increase_key(int x, int k);// 将元素x的关键字增加到k,这里假设k的值不小于x的原关键字值(其实就是替换)
}

/**
 * 堆的常见应用:优先队列(最小) 以下所有的操作都可以在O(lgn)的时间内完成
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
		// 父节点的值是小于孩子节点的以及x不是根节点,就进入循环
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
			// 每次都让B的长度缩短1个距离,然后赋给A
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

		int leftNode = 2 * i;// 左子节点
		int rightNode = 2 * i + 1;// 右子节点
		int min = Integer.MIN_VALUE;

		if (leftNode <= A.length && A[leftNode - 1] < A[i - 1]) {
			// 左孩子存在,并且左孩子小于根节点
			min = leftNode;
		} else {
			min = i;
		}

		if (rightNode <= A.length && A[rightNode - 1] < A[min - 1]) {
			// 右孩子存在,并且右孩子小于左孩子
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
