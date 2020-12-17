package 算法导论.ch09.中位数和顺序统计量;

import 算法导论.BaseService;

/**
 * 最大值和最小值
 * @author Administrator
 *
 */
public class Ex_9_1 extends BaseService {

	
	public static void main(String[] args) {
		
		int[] A = reduceArray(11, 200);
		print(A);
		//int[] B = {1,10,20,30,2,31,12,14,190};
		//print(B);
		minAndmaximin(A);
	}
	
	/**
	 * 1.找最大值或最小值
	 * 不管最大还是最小都可以通过n-1次比较找出来
	 * @param A
	 * @return
	 */
	public static int minimum(int[] A){
		
		int min = A[0];
		
		for(int i=1; i<A.length; i++){
			
			if(min > A[i]){
				
				min = A[i];
			}
		}
		
		return min;
	}
	
	/**
	 * 2.同时找到最大值和最小值
	 * 按照样例一,分别找出最大和最小即可,这各需要n-1次比较,也就是总共2n-2次
	 * 但事实上,我们只需要最多3*(n/2)次比较就可以同时找到最大值和最小值了,
	 * 具体的方法是:
	 *  记录已知的最小值和最大值,但我们并不是将每一个输入元素与当前的最小值和最大值进行比较,这样做的代价是每隔元素需要2次比较,
	 *  而是对输入元素成对的进行处理,首先对一对输入元素相互进行比较,然后把较小的与当前最小值比较,把较大的与当前最大值进行比较,然后把
	 *  较小的与当前最小比较,较大的与当前最大的比较,这样每两个元素需要3次比较
	 * @param A
	 * @return
	 */
	public static void minAndmaximin(int[] A){
		
		//int length = A.length / 2;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for(int i=0; i<A.length; i++){
			
			if(i+1 >= A.length){
				
				if(A[i] > max){
					max = A[i];
				}
				
				if(A[i] < min){
					min = A[i];
				}
				
			}else{
				//System.out.println(A[i] + ";" + A[i+1]);
				if(A[i] > A[i+1]){
					
					if(A[i] > max){
						max = A[i];
					}
					
					if(A[i+1] < min){
						min = A[i+1];
					}
					
				}else{
					
					if(A[i+1] > max){
						max = A[i+1];
					}
					
					if(A[i] < min){
						min = A[i];
					}
				}
			}
			i++;
		}
		
		System.out.println("max = " + max + ";min = " + min);
	}
}
