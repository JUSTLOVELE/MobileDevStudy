package 算法分析与设计.动态规划;


/**
 * 矩阵链相乘
 *    其实这里与“钢管切割”有相似之处，在钢管切割问题中，我们使用一个一维数组来存储最佳收入，另一个一维数组来存储切割的划分处。
        而这里，我们也可以将矩阵链看成一根要分割的“钢管”，只是这里记录的两个数组需要是二维的，因为我们需要记录的不仅是从哪里“断开”，还需要记录"每一段"到哪里截止
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
	 * 矩阵链乘法
	 * @param m
	 * @param left
	 * @param right
	 * @return : 最小计算次数
	 */
	public static int Best_Memo(int[] m, int left, int right){
		
		if(left == right){
			return 0;
		}
		
		int min = Integer.MAX_VALUE;
		int i=0;
		for(i=left; i<right; i++){
			int count = 0;//计算完全加括号的计算次数
			if(memo[left][i] == 0){
				memo[left][i] = Best_Memo(m, left, i);
			}
			count = memo[left][i];
			if(memo[i+1][right] == 0){
				memo[i+1][right] = Best_Memo(m, i+1, right);
			}
			 count += memo[i+1][right];  
		     count += m[left-1] * m[i] * m[right];  
		    //选出最小
			if(count < min){
				min = count;
			}
		}
		
		return min;
	}
	
	/**
	 * 
	 *用于存储最少乘法执行次数和最佳分段方式的结构是两个二维数组m和s，都是从1~n取值。
	 *需要注意的一点是当i=j时，m[i][j]=m[i][i]=0，因为一个矩阵不需要任何乘法
	 *
	 * @param p : 使用一个长度为n+1的一维数组p来记录每个矩阵的规模，其中n为矩阵下标i的范围1~n，例如对于矩阵Ai而言，它的规模应该是p[i-1]到p[i]。由于i是从1到n取值，所以数组p的下标是从0到n
	 * @param n
	 * @param m : m[i][j]记录矩阵链<Ai,Ai+1,...,Aj>的最少乘法执行次数
	 * @param s : s[i][j]则记录 最优质m[i][j]的分割点k
	 */
	public static void Matrix_Chain(int[] p, int n, int[][] m, int[][] s){
		
		//将对角线先赋值为0
		for(int i=1; i<=n; i++){
			m[i][i] = 0;
		}
		
		int l=0; //l为矩阵论的长度
		int i=0, j=0, tmp = 0;
		//l从2开始到n
		for(l=2; l<=n; l++){
			//循环第一个参数，因为l的长度至少为2，所以i和j在这个循环里面肯定不相等
			for(i=1; i<=n-l+1; i++){
				//因为j-i+1=l，所以j=l+i-1
				j = i + l - 1;
				m[i][j] = m[i][i] + m[i + 1][j] + p[i - 1] * p[i] * p[j];
				s[i][j] = i;
				//对于每个特定的i和j的组合，遍历此时所有的合适k值，k大于等于i小于j
				for(int k=i+1; k<j; k++){//这里k不能等于j，因为后面要m[k+1][j]
					
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
