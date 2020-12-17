package �㷨���İ�.ch04.p02.����ͼ.��������;

import java.io.File;

import �㷨���İ�.ch04.p02.����ͼ.Digraph;
import �㷨���İ�.����.In;
import �㷨���İ�.����.Queue;
import �㷨���İ�.����.Stack;

/**
 * ����ͼ�л���������������Ķ������� ����˼��:���������������ֻ�����ÿ������һ��,�����dfs()�Ĳ������㱣����һ�����ݽṹ��,
 * ����������ݽṹʵ���Ͼ��ܷ���ͼ�е����ж���,������˳��ȡ����������ݽṹ�������Լ����ڵݹ� ����֮ǰ����֮����б���
 * ���Ǹ���Ȥ���Ƕ����������������˳�� 1.ǰ��:�ڵݹ����֮ǰ������������ 2.����:�ڵݹ����֮�󽫶���������
 * 3.�����:�ڵݹ����֮�󽫶���ѹ��ջ
 * 
 * @author yangzuliang
 * 
 */
public class DepthFirstOrder {

	private boolean[] marked;
	private int[] pre;
	private int[] post;
	private Queue<Integer> preorder;
	private Queue<Integer> postorder;
	private int preCounter;
	private int postCounter;

	public DepthFirstOrder(Digraph G) {

		pre = new int[G.V()];
		post = new int[G.V()];
		postorder = new Queue<Integer>();
		preorder = new Queue<Integer>();
		marked = new boolean[G.V()];

		for (int v = 0; v < G.V(); v++) {

			if (!marked[v]) {
				dfs(G, v);
			}
		}
		assert check(G);
	}

	private void dfs(Digraph G, int v) {

		marked[v] = true;
		pre[v] = preCounter++;
		preorder.enqueue(v);

		for (int w : G.adj(v)) {

			if (!marked[w]) {

				dfs(G, w);
			}
		}

		postorder.enqueue(v);
		post[v] = postCounter++;
	}

	/*public DepthFirstOrder(EdgeWeightedDigraph G) {
		pre = new int[G.V()];
		post = new int[G.V()];
		postorder = new Queue<Integer>();
		preorder = new Queue<Integer>();
		marked = new boolean[G.V()];
		for (int v = 0; v < G.V(); v++)
			if (!marked[v])
				dfs(G, v);
	}

	private void dfs(EdgeWeightedDigraph G, int v) {
		marked[v] = true;
		pre[v] = preCounter++;
		preorder.enqueue(v);
		for (DirectedEdge e : G.adj(v)) {
			int w = e.to();
			if (!marked[w]) {
				dfs(G, w);
			}
		}
		postorder.enqueue(v);
		post[v] = postCounter++;
	}*/
	
	public int pre(int v){
		return pre[v];
	}
	
	public int post(int v){
		return post[v];
	}
	
	public Iterable<Integer> post(){
		return postorder;
	}
	
	public Iterable<Integer> pre(){
		return preorder;
	}
	
	public Iterable<Integer> reversePost(){
		
		Stack<Integer> reverse = new Stack<Integer>();
		
		for(int v : postorder)
			reverse.push(v);
		
		return reverse;
	}
	
	 private boolean check(Digraph G) {

	        int r = 0;
	        
	        for (int v : post()) {
	        	
	            if (post(v) != r) {
	            	
	               System.out.println("post(v) and post() inconsistent");
	                return false;
	            }
	            r++;
	        }

	        r = 0;
	        
	        for (int v : pre()) {
	        	
	            if (pre(v) != r) {
	            	
	            	System.out.println("pre(v) and pre() inconsistent");
	                return false;
	            }
	            r++;
	        }
	        
	        return true;
	    }
	 
	 public static void main(String[] args) {
		
		 In in = new In(new File(System.getProperty("user.dir") + "\\src\\�㷨���İ�\\ch04\\p01\\����ͼ\\cycle.txt"));
		 Digraph di = new Digraph(in);
		 DepthFirstOrder d = new DepthFirstOrder(di);
		 
	}
}
