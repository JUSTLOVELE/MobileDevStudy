package �㷨���������.��̬�滮;


/**
 * ���������
 *    ��ʵ�����롰�ֹ��и������֮�����ڸֹ��и������У�����ʹ��һ��һά�������洢������룬��һ��һά�������洢�и�Ļ��ִ���
        ���������Ҳ���Խ�����������һ��Ҫ�ָ�ġ��ֹܡ���ֻ�������¼������������Ҫ�Ƕ�ά�ģ���Ϊ������Ҫ��¼�Ĳ����Ǵ�����Ͽ���������Ҫ��¼"ÿһ��"�������ֹ
 * @author Administrator
 *
 */
public class Ex_1_Matrix {
	
	private static int[][] memo = new int[100][100];

	public static void main(String[] args) {
		
		//A1={30x35} ; A2={35x15} ;A3={15x5} ;A4={5x10} ;A5={10x20} ;A6={20x25} ;
		/*int[] m = {30,35,15,5,10,20,25};
		int n = m.length;
		int count = Best_Memo(m, 1, n-1);
		System.out.println(count);*/
		
		int[] p = {30,35,15,5,10,20,25};
		int n = p.length-1;
		int[][] m = new int[p.length][p.length];
		int[][] s = new int[p.length][p.length];
		Matrix_Chain(p,n,m,s);
	}
	
	/**
	 * �������˷�
	 * @param m
	 * @param left
	 * @param right
	 * @return : ��С�������
	 */
	public static int Best_Memo(int[] m, int left, int right){
		
		if(left == right){
			return 0;
		}
		
		int min = Integer.MAX_VALUE;
		int i=0;
		for(i=left; i<right; i++){
			int count = 0;//������ȫ�����ŵļ������
			if(memo[left][i] == 0){
				memo[left][i] = Best_Memo(m, left, i);
			}
			count = memo[left][i];
			if(memo[i+1][right] == 0){
				memo[i+1][right] = Best_Memo(m, i+1, right);
			}
			 count += memo[i+1][right];  
		     count += m[left-1] * m[i] * m[right];  
		    //ѡ����С
			if(count < min){
				min = count;
			}
		}
		
		return min;
	}
	
	/**
	 * 
	 *���ڴ洢���ٳ˷�ִ�д�������ѷֶη�ʽ�Ľṹ��������ά����m��s�����Ǵ�1~nȡֵ��
	 *��Ҫע���һ���ǵ�i=jʱ��m[i][j]=m[i][i]=0����Ϊһ��������Ҫ�κγ˷�
	 *
	 * @param p : ʹ��һ������Ϊn+1��һά����p����¼ÿ������Ĺ�ģ������nΪ�����±�i�ķ�Χ1~n��������ھ���Ai���ԣ����Ĺ�ģӦ����p[i-1]��p[i]������i�Ǵ�1��nȡֵ����������p���±��Ǵ�0��n
	 * @param n
	 * @param m : m[i][j]��¼������<Ai,Ai+1,...,Aj>�����ٳ˷�ִ�д���
	 * @param s : s[i][j]���¼ ������m[i][j]�ķָ��k
	 */
	public static void Matrix_Chain(int[] p, int n, int[][] m, int[][] s){
		
		//���Խ����ȸ�ֵΪ0
		for(int i=1; i<=n; i++){
			m[i][i] = 0;
		}
		
		int l=0; //lΪ�����۵ĳ���
		int i=0, j=0, tmp = 0;
		//l��2��ʼ��n
		for(l=2; l<=n; l++){
			//ѭ����һ����������Ϊl�ĳ�������Ϊ2������i��j�����ѭ������϶������
			for(i=1; i<=n-l+1; i++){
				//��Ϊj-i+1=l������j=l+i-1
				j = i + l - 1;
				m[i][j] = m[i][i] + m[i + 1][j] + p[i - 1] * p[i] * p[j];
				s[i][j] = i;
				//����ÿ���ض���i��j����ϣ�������ʱ���еĺ���kֵ��k���ڵ���iС��j
				for(int k=i+1; k<j; k++){//����k���ܵ���j����Ϊ����Ҫm[k+1][j]
					
					tmp = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];

					if (tmp < m[i][j]) {
						m[i][j] = tmp;
						s[i][j] = k;
					}
				}
			}
		}
		
		print_optimal_parens(s, 1, j);
	}
	
	public static void print_optimal_parens(int[][] s, int i, int j){
		if (i == j) {
			System.out.print("A" + i);
		} else {
			System.out.print("(");
			print_optimal_parens(s, i, s[i][j]);
			print_optimal_parens(s, s[i][j] + 1, j);
			System.out.print(")");
		}
	}
	
	
	
	
	/*public static void matrixCount(int a, int b, int mid){
		
		for(int i=mid; i<b; i++){
			
			matrixLeft(a, i);
			System.out.println("----------------");
			matrixRight(b, i);
			System.out.println("----------------");
		}
	}
	
	public static void matrixRight(int b, int mid){
		if(b == mid){
			return ;
		}
		System.out.println(b + " " + mid);
		matrixRight(b, mid + 1);
		
	}
	
	public static void matrixLeft(int a, int mid){
		
		if(a == mid){
			return ;
		}
		
		System.out.println(a + " " + mid);
		matrixLeft(a + 1, mid);
		
	}*/
	
	/**
	 * A B multiply
	 * @param A
	 * @param B
	 * @param C : result
	 */
	public static void matrixMultiply(int[][] A, int[][] B, int[][] C){
		
		for(int i=0; i<A.length; i++){
			
			for(int k=0; k<B[0].length; k++){
				
				int sum = 0;
				for(int j=0; j<A[i].length; j++){
					/*int a = A[i][j];
					int b = B[j][k];
					System.out.println(a + "*" + b + "=" + (a*b));*/
					sum += A[i][j] * B[j][k] ;
				}
				//System.out.println("------------------------");
				C[i][k] = sum;
				System.out.println(sum);
			}
		}
	}
}
