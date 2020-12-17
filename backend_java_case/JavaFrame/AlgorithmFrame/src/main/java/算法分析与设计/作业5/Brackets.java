package �㷨���������.��ҵ5;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

import org.junit.Test;

/**
 * ����һ���ַ���,ֻ�������ַ�"(",")","?",����"?"��������"("��")",����"(?",�������д "(",��ô"(("�ǲ� ƥ���,�������ַ���S,
 * �������ʱȷ���ж�������д����,ʹ�õõ����ַ���ʱƥ���,���ַ�����,���ٴ���1����ͬ����д�ַ�,�������"((??))",���ǿ��Եõ����ַ���:
 * "((()))","(()())"
 * �����һ��Ϊһ���ַ���S,����Ϊ0~16
 * ���һ������,��ʾƥ�����д������
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
