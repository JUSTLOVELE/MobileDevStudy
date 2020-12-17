package 算法导论.ch06.堆排序;

import java.util.Arrays;

/**
 * 堆的常见应用:优先队列 分为两种:最大优先队列和最小优先队列 以下所有的操作都可以在O(lgn)的时间内完成
 * 
 * @author Administrator
 * 
 */

interface MaxPriorityInterface<Item> {

	void insert(int x);// 把元素x插入S中

	int maxium();// 返回s中具有最大键字的元素

	int head_extract_Max();// 去掉并返回S中具有最大键字的元素

	void increase_key(int x, int k);// 将元素x的关键字增加到k,这里假设k的值不小于x的原关键字值(其实就是替换)
}

public class MaxPriorityQueue implements MaxPriorityInterface {
	
	
	public static void main(String[] args) {
		// int[] A = {16,4,10,14,7,9,3,2,8,1};
		int[] A = { 4, 1, 3, 2, 16, 9, 10, 14, 8, 7 };
		MaxPriorityQueue max = new MaxPriorityQueue(A);
		System.out.println(Arrays.toString(max.priorityQueue()));
		
		System.out.println(max.maxium());
		System.out.println(Arrays.toString(max.priorityQueue()));
		max.insert(12);
		System.out.println(Arrays.toString(max.priorityQueue()));
		max.increase_key(8, 15);
		System.out.println(Arrays.toString(max.priorityQueue()));
		System.out.println(max.head_extract_Max());
		System.out.println(Arrays.toString(max.priorityQueue()));
		System.out.println(Arrays.toString(max.HeapSort()));
	}
	

	private int[] priorityQueue;

	public MaxPriorityQueue(int[] S) {
		 priorityQueue = S;
		 build_max_heap(priorityQueue);
	}

	@Override
	public void insert(int x) {

		int[] A = new int[priorityQueue.length + 1];
		
		for(int i=0; i<priorityQueue.length; i++){
			
			A[i] = priorityQueue[i];
		}
		
		A[priorityQueue.length] = x;
		priorityQueue = A;
		build_max_heap(priorityQueue);
	}

	@Override
	public int maxium() {
		if (priorityQueue != null && priorityQueue.length > 0) {
			return priorityQueue[0];
		} else {
			throw new NullPointerException("priorityQueue is null");
		}
	}

	@Override
	public int head_extract_Max() {

		if (priorityQueue == null || priorityQueue.length < 1) {
			throw new NullPointerException("priorityQueue is null");
		}

		int max = priorityQueue[0];
		int[] A = new int[priorityQueue.length - 1];

		for (int i = 1; i < priorityQueue.length; i++) {
			A[i - 1] = priorityQueue[i];
		}

		priorityQueue = A;
		max_heapify(A, 1);
		return max;
	}

	@Override
	public void increase_key(int x, int key) {
		// TODO Auto-generated method stub
		if (key < priorityQueue[x]) {
			throw new RuntimeException("key is smaller than current key");
		}

		priorityQueue[x] = key;
		int parent = parent(x);
		// 父节点的值是小于孩子节点的以及x不是根节点,就进入循环
		while (x > 1 && priorityQueue[parent] < priorityQueue[x]) {

			System.out.println(priorityQueue[parent] + "," + priorityQueue[x]);
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

	public int[] priorityQueue() {
		return priorityQueue;
	}

	public int[] HeapSort() {
		
		int[] A = priorityQueue.clone();
		build_max_heap(A);
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

			max_heapify(A, 1);
		}

		C[0] = A[0];
		return C;
	}

	public void build_max_heap(int[] A) {

		for (int i = A.length / 2; i > 0; i--) {
			max_heapify(A, i);
		}
	}

	public void max_heapify(int[] A, int i) {

		int l = 2 * i;
		int r = 2 * i + 1;
		int largest = -1;

		if (l <= A.length && A[l - 1] > A[i - 1]) {
			largest = l;
		} else {
			largest = i;
		}

		if (r <= A.length && A[r - 1] > A[largest - 1]) {
			largest = r;
		}

		if (i != largest) {

			int temp = A[i - 1];
			A[i - 1] = A[largest - 1];
			A[largest - 1] = temp;
			max_heapify(A, largest);
		}
	}
}
