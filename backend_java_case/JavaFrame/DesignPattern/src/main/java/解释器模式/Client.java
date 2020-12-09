package 解释器模式;

import java.util.Stack;

class Context {
}

abstract class Expression {
	public abstract Object interpreter(Context ctx);
}

class TerminalExpression extends Expression {
	public Object interpreter(Context ctx) {
		return null;
	}
}

class NonterminalExpression extends Expression {
	public NonterminalExpression(Expression... expressions) {

	}

	public Object interpreter(Context ctx) {
		return null;
	}
}

public class Client {
	public static void main(String[] args) {
		String expression = "";
		char[] charArray = expression.toCharArray();
		Context ctx = new Context();
		Stack<Expression> stack = new Stack<Expression>();
		for (int i = 0; i < charArray.length; i++) {
			// 进行语法判断，递归调用
		}
		Expression exp = stack.pop();
		exp.interpreter(ctx);
	}
}