package 算法导论.ch08.线性时间排序;

import java.util.Arrays;

import org.junit.Test;

import 算法导论.BaseService;

/**
 * 之前的算法都是基于比较的:各元素的次序依赖于它们之间的比较,我们把这类排序算法称为比较排序
 * 计数排序(稳定的算法)
 *  基本思想:对每一个输入元素x,确定小于x的元素个数,利用这一信息,就可以直接把x放到它在输出数组中的位置上了
 *例如:如果有17个元素小于x,则x就应该在第18个输出位置上,当有几个元素相同时,这个方案要做出修改,不能把他们放在同一个位置上
 *  总代价是O(k+n)(k是指最大元素)
 *  在实际中,当k=O(n)时,就才用计数排序
 * @author Administrator
 *
 */
public class Counting_Sort extends BaseService {
	
	@Test
	public void counting_SortTest(){
		//int[] A = reduceArray(100, 1000);
	    int[] A = {2,5,3,0,2,3,0,3};
		int[] B = new int[A.length];
		int max = A[0];
		for(int i=1; i<A.length; i++){
			if(A[i]>max){
				max = A[i];
			}
		}
		
		/*for(int i=0; i<A.length; i++){
			System.out.print(A[i] + ",");
		}*/
		//System.out.println("");
		counting_Sort(A, B, max+1);
		System.out.println(Arrays.toString(B));
		/*for(int i=0; i<B.length; i++){
			System.out.println(B[i] + ",");
		}*/
	
	}
	
	/**
	 * @param A:输入数组
	 * @param B:输出数组
	 * @param k:给C提供临时的存储空间(A的最大值+1)
	 * @return
	 */
	public static void counting_Sort(int[] A, int[] B, int k){
		
		Integer[] C = new Integer[k];

		for(int i=0; i<k; i++){
			C[i] = 0;
		}
		//C的下标是A中元素的值,C的值是A中对应C此时值得下标的个数
		for(int i=0; i<A.length; i++){
			int a = A[i];
			C[a]++;
		}
		
		for(int i=1; i<k; i++){
			C[i] = C[i] + C[i-1];
		}
		
		/*for(int i=0; i<k; i++){
			System.out.print(C[i] + ",");
		}*/
		for(int i=(A.length-1); i>=0; i--){
			//找到A[i]是第几小,C[]中的值存放的是B的索引,C的索引是对应的值
			int index = C[A[i]];
			//因为数组从0开始所以要-1,把A中对应的值放到B中对应的位置
			B[index-1] = A[i];
			//对应的位置计数-1
			C[A[i]] = C[A[i]]-1;
		}
	}
}
