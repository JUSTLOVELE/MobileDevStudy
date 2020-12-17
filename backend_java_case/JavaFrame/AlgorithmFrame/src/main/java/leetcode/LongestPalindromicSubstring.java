package leetcode;

import org.junit.Test;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume
 * that the maximum length of s is 1000.
 * 
 * Input: "babad" Output: "bab" Note: "aba" is also a valid answer.
 * 
 * 回文串是左右对称的
 * 
 * @author yangzuliang
 * 
 */
public class LongestPalindromicSubstring {

	@Test
	public void work() {

		String s = "babad";
		s = longestPalindrome(s);
		System.out.println(s);
	}

	/**
	 * 动态规划 
	 * 
	 * @param s
	 * @return
	 */
	public String longestPalindrome(String s) {
		
		if (s == null || s.length() <= 1)
			return s;

		int len = s.length();
		int maxLen = 1;
		boolean[][] dp = new boolean[len][len];
		String longest = null;
		
		for (int L = 0; L < s.length(); L++) {
			
			for (int i = 0; i < len - L; i++) {
				//只计算对角线后面的
				int j = i + L;
				
				if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) {
					
					dp[i][j] = true;

					if (j - i + 1 > maxLen) {
						
						maxLen = j - i + 1;
						longest = s.substring(i, j + 1);
					}
				}
			}
		}
		
		if(longest != null){
			return longest;
		}else{
			return String.valueOf(s.charAt(0));
		}
	}
}
