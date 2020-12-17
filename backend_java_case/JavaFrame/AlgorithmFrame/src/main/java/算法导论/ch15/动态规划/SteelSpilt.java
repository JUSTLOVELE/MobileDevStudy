package 算法导论.ch15.动态规划;

import 算法导论.BaseService;

/**
 * 钢条切割问题
 * @author Administrator
 *
 */
public class SteelSpilt extends BaseService{
	
	public static void main(String[] args) {
		//1,5,8,9,10,17,17,20,24,30
		int[] testArray = {0,1,5,8,9,10,17,17,20,24,30};
		int num = 3;
		System.out.println(cut_rod(testArray, num));
		System.out.println(memoized_cut_rod(testArray, num));
		System.out.println(bottom_up_cut_rod(testArray, num));
		int [] p = reduceArray(30, 3000);
		//普通递归调用
	/*	long start = System.currentTimeMillis();
		int a = cut_rod(p, 30);
		System.out.println(a);
		long end = System.currentTimeMillis();
		System.out.println("耗时:" + (end-start));*/
		//自顶向下带备忘录
		/*long start = System.currentTimeMillis();
		int a = memoized_cut_rod(p, 30);
		System.out.println(a);
		long end = System.currentTimeMillis();
		System.out.println("耗时:" + (end-start));*/
	}
	
	/**
	 * 动态规划自底向上
	 * @param p
	 * @param n
	 * @return
	 */
	public static int bottom_up_cut_rod(int[] p, int n){
		
		n++;
        int[] r = new int[n];
        r[0] = 0;
		
        for(int j=0; j<n; j++){
        	
        	int q = -1;
        	
        	for(int i=0; i<=j; i++){
        		
        		int temp = p[i] + r[j-i];
        		
        	    if(q<temp){
        	    	q = temp;
        	    }
        	}
        	
        	r[j] = q;
        }
        
		return r[n-1];
	}
	
	/**
	 * 动态规划
	 *   带备忘录自顶向下法
	 * @param p
	 * @param n
	 * @return
	 */
	public static int memoized_cut_rod(int[] p, int n){
		
		n++;
		int[] r = new int[n];
		
		for(int i=0; i<n; i++){
			
			r[i] = -1;
		}
		
		return memoized_cut_rod_aux(p, n-1, r);
	}
	
	/**
	 * 带备忘录自顶向下法
	 * @param p
	 * @param n
	 * @param r
	 * @return
	 */
	public static int memoized_cut_rod_aux(int[] p, int n, int[] r){
		
		if(r[n] >= 0){
			return r[n];
		}
		
		int q;
		
		if(n == 0){
			
			q = 0;
			
		}else{
			
			q = -1;
			
			for(int i=1; i<=n; i++){
				
				int temp = p[i] + memoized_cut_rod_aux(p, n-i, r);
				if(q<temp){
					q = temp;
				}
			}
		}
		
		r[n] = q;
		
		return q;
	}
	

	/**
	 * 采用自顶向下的递归实现:无动态规划,n到30就不行了
	 * @param p
	 * @param n
	 * @return
	 */
	public static int cut_rod(int[] p, int n){
		
		if(n==0){
			return 0;
		}
		
		int q = -1;
		
		for(int i=1; i<=n; i++){
			int temp = p[i]+cut_rod(p, n-i);
			if(q<temp){
				q = temp;
			}
		}
		
		return q;
	}
}
