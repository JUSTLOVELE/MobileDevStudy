package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * 
 * Given "pwwkew", the answer is "wke", with the length of 3. 
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * 
 * @author yangzuliang
 *
 */
public class LengthOfLongestSubstring {

	@Test
	public void work(){
		
		
		//System.out.println("abcabcbb".indexOf("b", 4));
		
		//String s  = null;
		//s = "dvdf";
		//s = "ckilbkd";
		//s = "abcabcbb";
		//s = "pwwkew";
		
		
		List<String> list = new ArrayList<String>();
		list.add("tmmzuxt");
		list.add("dvdf");
		list.add("ckilbkd");
		list.add("abcabcbb");
		list.add("pwwkew");
		list.add("ggububgvfk");
		
		for(String s : list){
			int a = lengthOfLongestSubstring(s);
			System.out.print(a + " ");
		}
		
		
		//5 3 5 3 3 6
	/*	int a = lengthOfLongestSubstring("abcabcbb");
		System.out.println(a);*/
	}
	
	/**
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstring(String s) {
		
		if(s == null || "".equals(s)){
			return 0;
		}

		char[] c = s.toCharArray();
		int start = 0;
		String str =String.valueOf(c[0]);
		String maxLength = "";

		for(int i=1; i<c.length; i++){
		
			char b = c[i];
			String k = String.valueOf(b);
			
			if(str.contains(k)){
				
				if(str.length() >= maxLength.length()){
					maxLength = str;
				}
				
				start = s.indexOf(k, start) + 1;
				str = s.substring(start, i);
			}
			
			str += k;
		}
		
		if(str.length() > maxLength.length()){
			maxLength = str;
		}
		
		System.out.println(maxLength);
		
		return maxLength.length();
	}
}
