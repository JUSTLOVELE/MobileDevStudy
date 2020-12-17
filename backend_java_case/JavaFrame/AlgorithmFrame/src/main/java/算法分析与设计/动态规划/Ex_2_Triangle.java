package 算法分析与设计.动态规划;
/**
 * 数字三角形问题
 *   给定一个具有N层的数组三角形,从顶至底有多条路径,每一步可沿左斜线向下或沿右斜线向下,
 *路径锁经过的数字之和为路径得分,请求最小路径得分
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
	 * 方法1:
	 *   D(X,Y) : X层第Y个位置
	 *---------------
	 *   D(1,1) = a(1,1)
	 *   D(X,Y) = MIN{D(X-1,Y), D(X-1,Y-1)} + a(X,Y)
	 */
	public static void method1(){
		int[] A = {2,6,2,1,8,4,1,5,6,8};
		int n = 4;//四层
		int[][] temp = new int[n+1][n+1];//缓存到这一列的最小值
		temp[1][1] = A[0];//初始化第一个位置
		int index = 0;
		
		for(int i=2; i<=n; i++){//X层
			
			for(int j=1; j<=i; j++){//Y个位置
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
