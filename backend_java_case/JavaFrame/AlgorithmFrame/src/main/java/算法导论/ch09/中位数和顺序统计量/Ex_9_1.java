package �㷨����.ch09.��λ����˳��ͳ����;

import �㷨����.BaseService;

/**
 * ���ֵ����Сֵ
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
	 * 1.�����ֵ����Сֵ
	 * �����������С������ͨ��n-1�αȽ��ҳ���
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
	 * 2.ͬʱ�ҵ����ֵ����Сֵ
	 * ��������һ,�ֱ��ҳ�������С����,�����Ҫn-1�αȽ�,Ҳ�����ܹ�2n-2��
	 * ����ʵ��,����ֻ��Ҫ���3*(n/2)�αȽϾͿ���ͬʱ�ҵ����ֵ����Сֵ��,
	 * ����ķ�����:
	 *  ��¼��֪����Сֵ�����ֵ,�����ǲ����ǽ�ÿһ������Ԫ���뵱ǰ����Сֵ�����ֵ���бȽ�,�������Ĵ�����ÿ��Ԫ����Ҫ2�αȽ�,
	 *  ���Ƕ�����Ԫ�سɶԵĽ��д���,���ȶ�һ������Ԫ���໥���бȽ�,Ȼ��ѽ�С���뵱ǰ��Сֵ�Ƚ�,�ѽϴ���뵱ǰ���ֵ���бȽ�,Ȼ���
	 *  ��С���뵱ǰ��С�Ƚ�,�ϴ���뵱ǰ���ıȽ�,����ÿ����Ԫ����Ҫ3�αȽ�
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
