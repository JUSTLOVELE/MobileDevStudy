package 算法第四版.ch01.练习;

import 算法第四版.ch01.基础.Stack;

/**
 * 编写一个过滤器,将算术表达式由中序表达式
 * 转为后序表达式
 * @author Administrator
 *
 */
public class InfixToPostfix {
	
	public static void main(String[] args) {
		inorderExpress();
	}
	
	/**
	 * 中序表达式转为后序表达式
	 * (a+b)*(c+d)
	 * 1.当输入是操作数时,直接输出
	 * 2.遇到(,+,-,/,*时压栈
	 * 3.遇到) 出栈
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
				//遇到(入栈
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
				//遇到右括号则出栈,知道遇到开括号
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
