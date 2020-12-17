package leetcode;

import org.junit.Test;

/**
 * Reverse digits of an integer.
   Example1: x = 123, return 321
   Example2: x = -123, return -321
 * @author yangzuliang
 *
 */
public class ReverseInteger {

	@Test
	public void work(){
		
		int a = -123;
		a = reverse(a);
		System.out.println(a);
	}
    public int reverse(int x) {
    	
    	long sum = 0;
    	
    	while(x!=0){
    		
    		int s = x%10;
    		sum = sum*10 + s;
    		x = x/10;
    	}
    	
    	if(sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE){
    		return 0;
    	}
    	
    	return (int) sum;
    	
    }
}
