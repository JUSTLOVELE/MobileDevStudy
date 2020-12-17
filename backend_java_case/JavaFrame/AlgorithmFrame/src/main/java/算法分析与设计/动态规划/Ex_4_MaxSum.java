package �㷨���������.��̬�滮;

import �㷨����.BaseService;

/**
 * ����Ӷκ�����
 * ������n��������ɵ�����a1,a2...an,������е��Ӷκ͵����ֵ,������������Ϊ������ʱ����������Ӷκ�δ0
 * 
 * @author Administrator
 *
 */
public class Ex_4_MaxSum extends BaseService{

	public static void main(String[] args) {
		int[] A = {-2, 11, -4, 13, -5, -2};
		//�м������
		//int[] A = {2,-10,3,5,7,-2,-1}; 
		//int[] A = {2,-10,-2,-1,3,5,7}; 
		normal(A);
		int sum = divide(A, 0, A.length-1); 
		System.out.println("���η�:���� = "+ sum);
		dynamic(A.length-1, A);
	}
	
	/**
	 * ��̬�滮
	 * @param n
	 * @param A
	 */
	public static void dynamic(int n, int[] A){
		
		int sum = 0;
		int b = 0;
		for(int i=1; i<=n; i++){
			if(b>0){
				b += A[i];
			}else{
				b = A[i];
			}
			if(b>sum){
				sum = b;
			}
		}
		System.out.println("��̬�滮:����=" + sum );
	}
	
	/**
	 * ���η�
	 * @param A
	 * @param left
	 * @param right
	 * @return
	 */
	public static int divide(int[] A, int left, int right){
		
		int sum = 0;
		if(left == right) {
			sum = A[left] > 0 ? A[left]:0;
		}else{
			int center = (left + right)/2;
			int leftSum = divide(A, left, center);
			int rightSum = divide(A, center+1, right);
			int s1 = 0;
			int lefts = 0;
			for(int i=center; i>=left; i--){
				lefts += A[i];
				if(lefts > s1){
					s1 = lefts;
				}
			}
			
			int s2 = 0;
			int rights = 0;
			for(int i=center+1; i<=right; i++){
				rights += A[i];
				if(rights > s2){
					s2 = rights;
				}
			}
			
			sum = s1+s2;
			
			if(sum < leftSum && rightSum < leftSum) {
				sum = leftSum;
			}
			
			if(sum < rightSum && leftSum < rightSum){
				sum = rightSum;
			}
		}
		
		return sum;
	}
	
	/**
	 * ��ͨ�ⷨ
	 * ���Ӷ�: n*n
	 * @param A
	 */
	public static void normal(int[] A){
		
		int sum = 0;
		int start = -1;
		int end = -1;
		
		for(int i=0; i<A.length; i++){
			
			int temp = 0;
			
			for(int j=i; j<A.length; j++){
				
				temp += A[j];
				
				if(temp > sum){
					sum = temp;
					start = i;
					end = j;
				}
			}
		}
		
		System.out.println("��ͨ�ⷨ:����=" + sum + " i=" + start + " j=" + end );
	}
}
