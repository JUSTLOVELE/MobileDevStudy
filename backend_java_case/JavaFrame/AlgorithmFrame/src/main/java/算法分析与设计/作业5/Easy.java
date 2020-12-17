package 算法分析与设计.作业5;

import java.util.Arrays;
import java.util.Scanner;

import org.junit.Test;

/**
 * 给出一个M*N的矩阵A,其中Aij属于{0,1}(0<=i<M, 0<=j<N),请问能否从矩阵A中取出一些行,拼接成新的矩阵U
 * 使其每一列有且只有一个1?
 * @author yangzuliang
 *
 */
public class Easy {

	@Test
	public void work(){
		
		Scanner scanner = new Scanner(System.in);
		int M = scanner.nextInt();
		int N = scanner.nextInt();
		int[][] A = new int[M][N];
		
		for(int i=0; i<M; i++){
			for(int j=0; j<N; j++){
				A[i][j] = scanner.nextInt();
			}
		}
		//显然要有N列的1 M<N
		System.out.println(Arrays.toString(A[0]));
		System.out.println(Arrays.toString(A[1]));
	}
}
