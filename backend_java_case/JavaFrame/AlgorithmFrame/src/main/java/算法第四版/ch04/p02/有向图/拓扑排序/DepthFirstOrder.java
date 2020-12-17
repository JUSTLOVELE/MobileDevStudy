package 算法第四版.ch04.p02.有向图.拓扑排序;

import java.io.File;

import 算法第四版.ch04.p02.有向图.Digraph;
import 算法第四版.基础.In;
import 算法第四版.基础.Queue;
import 算法第四版.基础.Stack;

/**
 * 有向图中基于深度优先搜索的顶点排序 基本思想:深度优先搜索正好只会访问每个顶点一次,如果将dfs()的参数顶点保存在一个数据结构中,
 * 遍历这个数据结构实际上就能访问图中的所有顶点,遍历的顺序取决于这个数据结构的性质以及是在递归 调用之前还是之后进行保存
 * 人们感兴趣的是顶点的以下三种排列顺序 1.前序:在递归调用之前将顶点加入队列 2.后序:在递归调用之后将顶点加入队列
 * 3.逆后序:在递归调用之后将顶点压入栈
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
		
		 In in = new In(new File(System.getProperty("user.dir") + "\\src\\算法第四版\\ch04\\p01\\有向图\\cycle.txt"));
		 Digraph di = new Digraph(in);
		 DepthFirstOrder d = new DepthFirstOrder(di);
		 
	}
}
