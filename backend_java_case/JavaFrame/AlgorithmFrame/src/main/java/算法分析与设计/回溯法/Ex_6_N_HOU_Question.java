package �㷨���������.���ݷ�;

import java.util.Arrays;

import org.junit.Test;

/**
 * n������
 *  ��n*n��������Ϸ�ֹ�˴˲��ܹ�����n���ʺ�,
 *�ʺ���Թ�����֮����ͬһ�л�ͬһ�л�ͬһб����
 *������
 *����(Xi,Yi),(Xj,Yj)����:
 *   1.Yi != Yj
 *   2.Xi-Xj = Yi-Yj;
 *   3.Xi+Xj = Yi+Yj; Ҳ���� |Xi-Yi| != |Xj-Yj|
 *��������4*4�����
 * @author Administrator
 *
 */
public class Ex_6_N_HOU_Question {
	
	private int[][] N;//����
	private int length;
	private int[] location; //λ��

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
