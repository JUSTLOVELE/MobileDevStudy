package �㷨���İ�.ch01.��ϰ;

import �㷨���İ�.ch01.����.Stack;

/**
 * ��дһ��Stack������,�ӱ�׼�����ж�ȡһ���ı���,��ʹ��ջ�ж����е������Ƿ�������� ���� [()]{}[{()}]Ӧ�ô�ӡtrue
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
		stack.push(String.valueOf(ca[0]));// ��һ����ջ
		/*
		 * �ӵڶ����ַ���ʼ��������ջ���ַ�ƥ�䡣 �ɹ���ջ��Ԫ�ص����� ʧ�����ַ������еĵ�ǰ�ַ�ѹ��ջ�С�
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
