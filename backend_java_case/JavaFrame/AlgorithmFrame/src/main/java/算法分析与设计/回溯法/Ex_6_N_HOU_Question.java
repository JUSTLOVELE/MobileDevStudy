package 算法分析与设计.回溯法;

import java.util.Arrays;

import org.junit.Test;

/**
 * n后问题
 *  在n*n格的棋盘上防止彼此不受攻击的n个皇后,
 *皇后可以攻击与之处在同一行或同一列或同一斜线上
 *的棋子
 *对于(Xi,Yi),(Xj,Yj)满足:
 *   1.Yi != Yj
 *   2.Xi-Xj = Yi-Yj;
 *   3.Xi+Xj = Yi+Yj; 也就是 |Xi-Yi| != |Xj-Yj|
 *这里讨论4*4的情况
 * @author Administrator
 *
 */
public class Ex_6_N_HOU_Question {
	
	private int[][] N;//棋盘
	private int length;
	private int[] location; //位置

	@Test
	public void init(){
		
		N = new int[4][4];
		length = N.length + 1;
		location = new int[length];
		Arrays.fill(location, -1);
		
		/*for(int i=0; i<length; i++){
			
			backTrace(1);
		}*/
		backTrace(1);
	}
	
	/**
	 *  Yi != Yj
     *  |Xi-Yi| != |Xj-Yj|
	 * @param t
	 */
	public void backTrace(int t){
		
		if(t >= length){
			
			System.out.println(Arrays.toString(location));
		}else{
			
			for(int i=1; i<=4; i++){
				
				location[t] = i;
				
				if(compute(t)){
					
					backTrace(t+1);
				}
			}
		}
	}
	
	public boolean compute(int k){
		
		for(int j=1; j<k; j++){
			if((Math.abs(k-j) == Math.abs(location[j]-location[k])) || location[j]==location[k]){
				return false;
			}
		}
			
        return true;	
 	}
}
