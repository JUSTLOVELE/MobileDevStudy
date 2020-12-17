package �㷨���İ�.ch01.��ϰ;

import �㷨���İ�.ch01.����.Stack;

/**
 * ��дһ��������,���������ʽ��������ʽ
 * תΪ������ʽ
 * @author Administrator
 *
 */
public class InfixToPostfix {
	
	public static void main(String[] args) {
		inorderExpress();
	}
	
	/**
	 * ������ʽתΪ������ʽ
	 * (a+b)*(c+d)
	 * 1.�������ǲ�����ʱ,ֱ�����
	 * 2.����(,+,-,/,*ʱѹջ
	 * 3.����) ��ջ
	 * 
	 * (a+b)*c+(d-e)/(f+g)
	 * ab+c*de-fg+/+
	 * 
	 *  (A*B+(C+D))-(E*F*H)
	 *  AB*CD++EFH**-
	 */
	public static void inorderExpress(){
		
		//String s = "(a+b)*(c+d)";
		//String s = "(A*B+(C+D))-(E*F*H)";
		String s = "(a+b)*c+(d-e)/(f+g)";
		char[] cs = s.toCharArray();
		Stack<String> stack = new Stack<String>();
		
		for(char temp : cs){
			
			String c = String.valueOf(temp);
			
			if(c.equals("(")){
				//����(��ջ
				stack.push(c);
			}else if(c.equals("+") || c.equals("-") ){
				
				if(!stack.isEmpty()){
					
					String s1 = stack.peek();
					
					while(s1 != null &&  (s1.equals("/") || s1.equals("*"))){
						
						s1 = stack.pop();
						System.out.print(s1);
						s1 = stack.peek();
					}
				}
				
				stack.push(c);
			
			}else if(c.equals("/") || c.equals("*")){
				
				stack.push(c);
			}else if(c.equals(")")){
				//�������������ջ,֪������������
				String c1 = stack.pop();
				
				while(!c1.equals("(")){
					System.out.print(c1);
					c1 = stack.pop();
				}
			}else {
				
				if(!c.equals("(")){
					System.out.print(c);
				}
			}
		}
		
		while(!stack.isEmpty()){
			System.out.print(stack.pop());
		}
	}
}
