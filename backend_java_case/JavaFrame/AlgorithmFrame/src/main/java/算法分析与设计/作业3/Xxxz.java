package �㷨���������.��ҵ3;

import java.util.Scanner;

import �㷨����.ch07.��������.Qucik_Sort;

/**
 * ��̬�滮:ѧУѡַ
 * @author Administrator
 *
 */
public class Xxxz {
	
	public static void main(String[] args) {
		xxxz();
	}

	public static void xxxz(){
		
		int[][] g = new int[1000][1000];//i->j���ӽ���һ��ѧУ����Сֵ
		int[][] f = new int[1000][1000];//ǰj�����ӽ���i��ѧУ����Сֵ
		
		/*Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();//N������
		int M = scanner.nextInt();//M��ѧУ
		
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
				for(int k=i-1; k<=j-1; k++){//k��ָ����
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
		
		System.out.println("���" + f[M][N]);
	}
}
