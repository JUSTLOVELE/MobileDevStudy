package �㷨���������.��̬�滮;
/**
 * ��������������
 *   ����һ������N�������������,�Ӷ������ж���·��,ÿһ��������б�����»�����б������,
 *·��������������֮��Ϊ·���÷�,������С·���÷�
 *              2
 *            6   2
 *          1   8   4
 *        1   5   6   8
 * @author Administrator
 *
 */
public class Ex_2_Triangle {

	
	public static void main(String[] args) {
		method1();
	}
	
	/**
	 * ����1:
	 *   D(X,Y) : X���Y��λ��
	 *---------------
	 *   D(1,1) = a(1,1)
	 *   D(X,Y) = MIN{D(X-1,Y), D(X-1,Y-1)} + a(X,Y)
	 */
	public static void method1(){
		int[] A = {2,6,2,1,8,4,1,5,6,8};
		int n = 4;//�Ĳ�
		int[][] temp = new int[n+1][n+1];//���浽��һ�е���Сֵ
		temp[1][1] = A[0];//��ʼ����һ��λ��
		int index = 0;
		
		for(int i=2; i<=n; i++){//X��
			
			for(int j=1; j<=i; j++){//Y��λ��
				index += 1;
				
				int right = 0;
				if(temp[i-1][j] != 0){
					right = A[index] + temp[i-1][j];
				}else{
					right = Integer.MAX_VALUE;
				}
				
				int left = 0;
				if(temp[i-1][j-1] != 0){
					left = A[index] + temp[i-1][j-1];
				}else{
					left = Integer.MAX_VALUE;
				}
				
				if(right > left){
					temp[i][j] = left;
				}else{
					temp[i][j] = right;
				}
			}
		}
		
		System.out.println(temp[4][1]);
		System.out.println(temp[4][2]);
		System.out.println(temp[4][3]);
		System.out.println(temp[4][4]);
	}
}
