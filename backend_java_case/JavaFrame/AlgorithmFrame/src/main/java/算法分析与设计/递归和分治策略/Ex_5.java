package 算法分析与设计.递归和分治策略;
/**
 * 整数划分问题
 * n=n1+n2+....+nk
 * n1>=n2>=...>=nk>=1, k>=1
 * 6
 * 5+1
 * 4+2, 4+1+1
 * 3+2, 3+2+1, 3+1+1+1;
 * 2+2+2, 2+2+1+1, 2+1+1+1+1
 * 1+1+1+1+1+1+1
 * @author Administrator
 *
 */
public class Ex_5 {

	public static void main(String[] args) {
		System.out.println(zshf(6,4));
	}
	
	/***
	 * 
	 * @param n
	 * @param m:划分的最大长度
	 * @return
	 */
	public static int zshf(int n, int m){
		
		if(n == 1 || m==1){
			return 1;
		}else if(n<m){
			return zshf(n,n);
		}else if(n == m){
			return 1 + zshf(n, n-1);
		}else{
			return zshf(n, m-1) + zshf(n-m, m);
		}
	}
}
