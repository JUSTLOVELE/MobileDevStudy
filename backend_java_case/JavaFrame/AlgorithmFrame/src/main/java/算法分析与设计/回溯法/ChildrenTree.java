package �㷨���������.���ݷ�;

import java.util.Arrays;

/**
 * �Ӽ���
 * 
 * @author Administrator
 * 
 */
public class ChildrenTree {

	int[] x = {0, 1, 2, 3 };

	public static void main(String[] args) {

		ChildrenTree l = new ChildrenTree();
		l.backTrace(1);
	}

	public void backTrace(int t){
		
		if(t>=x.length){
			System.out.println(Arrays.toString(x));
		}else{
			for(int i=0; i<=1; i++){
				x[t] = i;
				backTrace(t+1);
			}
		}
	}
}
