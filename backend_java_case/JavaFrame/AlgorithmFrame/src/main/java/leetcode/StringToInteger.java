package leetcode;

import org.junit.Test;

public class StringToInteger {

	@Test
	public void work() {
		// -0012a42
		//String str = "9223372036854775809";
		//String str = "2147483646";
		//String str = "2147483649";
		//String str = "2147483647";
		//String str = "-2147483647";
		//String str = "-2147483648";
		//String str = "-2147483649";
		//String str = "   -115579378e25";
		String str = " b11228552307";
		//String str ="1";
		int a = myAtoi(str);
		System.out.println(a);
	}

	public int myAtoi(String str) {

		str = str.trim();

		if (str == null || "".equals(str)) {
			return 0;
		}
		

		char[] chars = str.toCharArray();
		StringBuffer sb = new StringBuffer();
		
		char zero = chars[0];
		
		char a = 'a';
		
		for(int i=0; i<26; i++){
			
			if(a == zero){
				return 0;
			}
			
			a++;
		}
		
		a = 'A';
		
		for(int i=0; i<26; i++){
			
			if(a == zero){
				return 0;
			}
			
			a++;
		}
		
		if(Character.isDigit(chars[0])){
			sb.append("+");
		}
		
		sb.append(chars[0]);
		
		for (int i = 1; i < chars.length; i++) {

			if (Character.isDigit(chars[i])) {
				sb.append(chars[i]);
			} else {
				break;
			}
		}

		str = sb.toString();

		try {

			if(str.length() > 11){
				
				if (str.startsWith("-")) {
					return Integer.MIN_VALUE;
				}else{
					return Integer.MAX_VALUE;
				}
			}else if(str.length() == 11){

				if (str.startsWith("-")) {

					String pre = str.substring(0, 10);
					String last = str.substring(10, 11);
				    //-2147483648
					Integer p = Integer.valueOf(pre);
				    int k = Integer.valueOf(last);
					
					if(p < -214748364){
						return Integer.MIN_VALUE;
					}
					
					if(p == -214748364){
						
						if(k > 8){
							return Integer.MIN_VALUE;
						}
					}
					

				} else {

					String pre = str.substring(0, 10);
					String last = str.substring(10, 11);
				    //+2147483647
					Integer p = Integer.valueOf(pre);
				    int k = Integer.valueOf(last);
					
					if(p > 214748364){
						return Integer.MAX_VALUE;
					}
					
					if(p == 214748364){
						
						if(k > 7){
							return Integer.MAX_VALUE;
						}
					}
					

				}
			
			}
			
			Long l = Long.valueOf(str);

			if (l > Integer.MAX_VALUE) {
				return Integer.MAX_VALUE;
			}

			if (l < Integer.MIN_VALUE) {
				return Integer.MIN_VALUE;
			}

			return Integer.valueOf(l.toString());

		} catch (Exception e) {
			e.printStackTrace();

			return 0;
		}

	}
}
