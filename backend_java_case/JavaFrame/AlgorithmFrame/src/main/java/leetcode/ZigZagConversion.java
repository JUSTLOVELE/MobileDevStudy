package leetcode;

import java.util.Arrays;

import org.junit.Test;

public class ZigZagConversion {

	@Test
	public void work(){
		
		String s = "0123456789";
		int numRows = 3;
		s = convert(s, numRows);
		System.out.println(s);
	}
	
    public String convert(String s, int numRows) {
    	
    	if(s == null || "".equals(s)){
    		return s;
    	}
    	
    	String[] array = new String[numRows];
        int row = 0;
        int delta = 1;
    	Arrays.fill(array, "");
    	for(int i=0; i<s.length(); i++){
    		
    		array[row] += s.charAt(i);
    		row +=delta;
    		
    		if(row >= numRows){
    			row = numRows-2;
    			delta = -1;
    		}
    		
    		if(row <= 0){
    			row = 0;
    			delta = 1;
    		}
    	}
    	
    	StringBuffer sb = new StringBuffer();
    	
    	for(int i=0; i<numRows; i++){
    		sb.append(array[i]);
    	}
    	
    	return sb.toString();
    }
}
