package 算法第四版.ch01.练习;

import 算法第四版.ch01.基础.Stack;

/**
 * 编写一个Stack的用例,从标准输入中读取一个文本流,并使用栈判定其中的括号是否配对完整 例如 [()]{}[{()}]应该打印true
 * 
 * @author Administrator
 * 
 */
public class Parentheses {

	public static void main(String[] args) {

	}

	public static boolean match(String str) {

		Stack<String> stack = new Stack<String>();
		char[] ca = str.toCharArray();
		stack.push(String.valueOf(ca[0]));// 第一个入栈
		/*
		 * 从第二个字符开始，依次与栈中字符匹配。 成功则将栈顶元素弹出。 失败则将字符数组中的当前字符压入栈中。
		 */
		for (int index = 1; index < ca.length; ++index) {

			String c1 = stack.peek();
			String c2 = String.valueOf(ca[index]);
			if (  (c1.equals('(') && c2.equals(')')) || (c1.equals('[') && c2.equals(']')) || (c1.equals("{")) && (c2.equals("}"))   ) {
				stack.pop();
			} else {
				stack.push(c2);
			}
		}

		return stack.isEmpty();
	}

}
