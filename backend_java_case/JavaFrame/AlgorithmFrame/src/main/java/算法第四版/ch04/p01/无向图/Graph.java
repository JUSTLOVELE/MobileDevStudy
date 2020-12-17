package 算法第四版.ch04.p01.无向图;

import java.io.File;

import 算法第四版.基础.Bag;
import 算法第四版.基础.In;
import 算法第四版.基础.Stack;

public class Graph {

	private final int V;// 顶点数目
	private int E;// 边的数目
	private Bag<Integer>[] adj;// 邻接表
	
	public static void main(String[] args) {
		In in = new In(new File(System.getProperty("user.dir") + "\\src\\算法第四版\\ch04\\p01\\无向图\\tinyG.txt"));
		Graph graph = new Graph(in);
	}
	
	public Graph(Graph G){
		this(G.V());
		this.E = G.E();
		
		for(int v=0; v<G.V(); v++){
			Stack<Integer> reverse = new Stack<Integer>();
			for(int w:G.adj(v)){
				reverse.push(w);
			}
			
			for(int w:reverse){
				adj[v].add(w);
			}
		}
	}
	
	public boolean hasEdge(int v, int w){
		
		boolean[] marked = new boolean[V()];
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(v);
		marked[v] = true;
		
		while(!stack.isEmpty()){
			
			int t = stack.pop();
			for(int a : adj[t]){
				
				if(a==w){
					return true;
				}
				
				if(!marked[a]){
					stack.push(a);
				}
			}
		}
		
		return false;
	}
	
	public Graph(int V) {
		this.V = V;
		this.E = 0;
		adj = new Bag[V];// 创建邻接表
		for (int v = 0; v < V; v++) {
			adj[v] = new Bag<Integer>();// 初始化所有邻接表为空
		}
	}

	/**
	 * 第一行 读取V 将V传给上面的构造器
	 * 第二性读取E 
	 * @param in
	 */
	public Graph(In in) {
		this(in.readInt());//读取V并将图初始化
		int E = in.readInt();//读取E
		for (int i = 0; i < E; i++) {
			//添加一条边
			int v = in.readInt();
			int w = in.readInt();
			addEdge(v, w);
		}
	}

	public int V() {
		return V;
	}

	public int E() {
		return E;
	}
	
	private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IndexOutOfBoundsException("vertex " + v + " is not between 0 and " + (V-1));
    }

	public void addEdge(int v, int w) {
		validateVertex(v);
		validateVertex(w);
		adj[v].add(w);//将w添加到v的链表中
		adj[w].add(v);//将v添加到w的链表中
		E++;
	}

	public Iterable<Integer> adj(int v) {
		validateVertex(v);
		return adj[v];
	}
	
	/**
	 * 计算所有顶点的最大度数
	 * @return
	 */
	public int maxDegree(){
		int max = 0;
		for(int v=0; v<V(); v++){
			if(degree(v) > max){
				max = degree(v);
			}
		}
		return max;
	}
	
	/**
	 * 计算v的度数
	 * @param v
	 * @return
	 */
	public int degree(int v){
		validateVertex(v);
		int degree = 0;
		for(int w : adj[v]){
			degree++;
		}
		return degree;
	}
	
	public String toString(){
		
		String s = V + " vertices, " + E + "edges\n";
		for(int v=0; v<V; v++){
			s+= v + ": ";
			for(int w : adj[v]){
				s += w + " ";
			}
			s += "\n";
		}
		
		return s;
	}

}
