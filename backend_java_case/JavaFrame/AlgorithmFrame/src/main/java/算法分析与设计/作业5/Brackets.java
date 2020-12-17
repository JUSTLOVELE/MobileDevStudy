package 算法分析与设计.作业5;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

import org.junit.Test;

/**
 * 假设一个字符串,只含三种字符"(",")","?",其中"?"可以填入"("或")",例如"(?",如果你填写 "(",那么"(("是不 匹配的,当给出字符串S,
 * 你的任务时确定有多少种填写方案,使得得到的字符串时匹配的,两种方案中,至少存在1个不同的填写字符,例如对于"((??))",我们可以得到两种方案:
 * "((()))","(()())"
 * 输入第一行为一个字符串S,长度为0~16
 * 输出一个整数,表示匹配的填写方案数
 * @author yangzuliang
 *
 */
public class Brackets {
	
	private static int count = 0;
	
	@Test
	public void work(){
		
		Scanner scanner = new Scanner(System.in);
		//String match = scanner.next();
		String match = "(????)";
		char[] cs = match.toCharArray();
		char[] bs = cs.clone();
		//System.out.println(Arrays.toString(cs));
		backTrace(cs, bs, 0);
		System.out.println(count);
	}
	
	public void backTrace(char[] cs, char[] bs, int t){
		
		if(t>=cs.length){
			
			System.out.println(Arrays.toString(bs));
			Stack s = new Stack();
			
			for(int i=0; i<bs.length; i++){
				
				if(bs[i] == '('){
					s.push(bs[i]);
				}else{
					
					if(!s.isEmpty()){
						s.pop();
					}else{
						s.push('?');
						break;
					}
				}
			}
			
			if(s.isEmpty()){
				count = count + 1;
			}
			
			
		}else{
			
			if(cs[t] == '?'){
				
				for(int i=0; i<=1; i++){
					
					if(i==0){
						bs[t] = '(';
					}else if(i==1){
						bs[t] = ')';
					}
					
					backTrace(cs, bs, t+1);
				}
			}else{
				backTrace(cs, bs, t+1);
			}
		}
	}
}
