package 算法分析与设计.作业3;

import java.util.Scanner;

import 算法导论.ch07.快速排序.Qucik_Sort;

/**
 * 动态规划:学校选址
 * @author Administrator
 *
 */
public class Xxxz {
	
	public static void main(String[] args) {
		xxxz();
	}

	public static void xxxz(){
		
		int[][] g = new int[1000][1000];//i->j村子建立一个学校的最小值
		int[][] f = new int[1000][1000];//前j个村子建立i所学校的最小值
		
		/*Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();//N个村子
		int M = scanner.nextInt();//M个学校
		
		int[] a = new int[N+1];
		for(int i=1; i<=N; i++){
			a[i] = scanner.nextInt();
		}
		Qucik_Sort.quickSort(a, 0, a.length-1);
		*/
		int N = 6;
		int M = 3;
		int a[] = {0,5,6,12,19,20,27};
		
		for(int i=1; i<=N;i++){
			g[i][i] = 0;
			for(int j=i+1; j<=N; j++){
				/*System.out.println(g[i][j-1]);
				System.out.println((i+j)/2);
				System.out.println(a[j]);
				System.out.println(a[(i+j)/2]);
				System.out.println(Math.abs(a[j]-a[(i+j)/2]));*/
				g[i][j] = g[i][j-1] + Math.abs(a[j]-a[(i+j)/2]);
				//System.out.println(g[i][j]);
			}
		}
		
		for(int i=1; i<=N; i++){
			f[1][i] = g[1][i];
		}
		
		for(int i=2; i<=M; i++){
			for(int j=i; j<=N; j++){
				int min = 0x7fffffff/2;
				for(int k=i-1; k<=j-1; k++){//k是指村子
					System.out.println("k=" + k + ";j=" + j + ";i=" + i);
					System.out.println(f[i-1][k]);
					System.out.println(g[k+1][j]);
					System.out.println(f[i-1][k] + g[k+1][j]);
					if(min > f[i-1][k] + g[k+1][j]){
						min = f[i-1][k] + g[k+1][j];
					}
					f[i][j] = min;
				}
			}
		}
		
		System.out.println("结果" + f[M][N]);
	}
}
