package �㷨���İ�.ch04.p01.����ͼ;

import java.io.File;

import �㷨���İ�.����.Bag;
import �㷨���İ�.����.In;
import �㷨���İ�.����.Stack;

public class Graph {

	private final int V;// ������Ŀ
	private int E;// �ߵ���Ŀ
	private Bag<Integer>[] adj;// �ڽӱ�
	
	public static void main(String[] args) {
		In in = new In(new File(System.getProperty("user.dir") + "\\src\\�㷨���İ�\\ch04\\p01\\����ͼ\\tinyG.txt"));
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
		adj = new Bag[V];// �����ڽӱ�
		for (int v = 0; v < V; v++) {
			adj[v] = new Bag<Integer>();// ��ʼ�������ڽӱ�Ϊ��
		}
	}

	/**
	 * ��һ�� ��ȡV ��V��������Ĺ�����
	 * �ڶ��Զ�ȡE 
	 * @param in
	 */
	public Graph(In in) {
		this(in.readInt());//��ȡV����ͼ��ʼ��
		int E = in.readInt();//��ȡE
		for (int i = 0; i < E; i++) {
			//���һ����
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
		adj[v].add(w);//��w��ӵ�v��������
		adj[w].add(v);//��v��ӵ�w��������
		E++;
	}

	public Iterable<Integer> adj(int v) {
		validateVertex(v);
		return adj[v];
	}
	
	/**
	 * �������ж����������
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
	 * ����v�Ķ���
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
