package �㷨���������.��ҵ5;

import java.util.Arrays;
import java.util.Scanner;

import org.junit.Test;

/**
 * ����һ��M*N�ľ���A,����Aij����{0,1}(0<=i<M, 0<=j<N),�����ܷ�Ӿ���A��ȡ��һЩ��,ƴ�ӳ��µľ���U
 * ʹ��ÿһ������ֻ��һ��1?
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
		//��ȻҪ��N�е�1 M<N
		System.out.println(Arrays.toString(A[0]));
		System.out.println(Arrays.toString(A[1]));
	}
}
