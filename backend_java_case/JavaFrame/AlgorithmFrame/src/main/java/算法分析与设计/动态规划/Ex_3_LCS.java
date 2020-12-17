package 算法分析与设计.动态规划;

/**
 * 最长公共子序列
 *  子串:子串是串的一个连续的部分,
 *  子序列:子序列是不改变列的顺序,而从序列中去掉任意的元素而获得新的序列
 * 也就是说,子串中字符的位置必须是连续的,子序列则可以不必连续
 * 设X[1...m], Y[1...n]
 * 定义: c[i][j] = |LCS(X[1...i], Y[1...j])| ; c[i][j]表示(X[1...i], Y[1...j]) 最长公共子序列
 * 显然c[m][n]就是结果
 * 递归式:
 *   i=0或j=0 : c[i][j] = 0;
 *   i,j>0且xi = yj : c[i-1][j-1]+1 //如果是相同的就+1
 *   i,j>0且xi != yj : max(c[i,j-1], c[i-1],j) //值不等不加一找最大的那个值就可以
 * @author Administrator
 *
 */
public class Ex_3_LCS {

	public static void main(String[] args) {
		char[] X = {'A', 'B', 'C', 'B', 'D', 'A', 'B'};
		char[] Y = {'B', 'D', 'C', 'A', 'B', 'A'};
	//	char[] X = {'B', 'C', 'D', 'A', 'F', 'G', 'K'};
	//	char[] Y = {'A', 'C', 'E', 'F', 'N', 'B', 'K'};
		memo(X, Y);
	}
	
	/**
	 * 自顶向下带备忘
	 * @param X
	 * @param Y
	 */
	public static void memo(char[] X, char[] Y){
		
		int m = X.length;
		int n = Y.length;
		int[][] c = new int[m+1][n+1];
		
		for(int i=0; i<=m; i++){
			for(int j=0; j<=n; j++){
				c[i][j] = -1;
			}
		}
		
		for(int i=0; i<=m; i++){
			c[i][0] = 0;
		}
		
		for(int j=0; j<=n; j++){
			c[0][j] = 0;
		}
		
		for(int i=1; i<=m; i++){
			
			for(int j=1; j<=n; j++){
				
				if(c[i][j] == -1){
					
					if(X[i-1] == Y[j-1]){
						c[i][j] = c[i-1][j-1] + 1;
					}else{
						int a = c[i-1][j];
						int b = c[i][j-1];
						
						if(a < b){
							c[i][j] = b;
						}else{
							c[i][j] = a;
						}
					}
				}
			}
		}
		
		System.out.println(c[m][n]);
	}
}
