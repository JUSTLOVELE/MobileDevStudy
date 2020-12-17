package 算法第四版.ch04.p02.有向图;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;

import 算法第四版.基础.Bag;
import 算法第四版.基础.In;
import 算法第四版.基础.Stack;

/**
 * 有向图
 * @author yangzuliang
 *
 */
public class Digraph {

	private final int V;
	private int E;
	private Bag<Integer>[] adj;
	private int[] indegree;
	
	public Digraph(int V){
		this.V = V;
		this.E = 0;
		indegree = new int[V];
		adj = new Bag[V];
		for(int v=0; v<V; v++){
			adj[v] = new Bag<Integer>();
		}
	}
	
	public Digraph(Digraph G){
		
		this(G.V());
		this.E = G.E();
		for(int v=0; v<V; v++){
			this.indegree[v] = G.indegree(v);
		}
		
		for(int v=0; v<G.V(); v++){
			Stack<Integer> reverse = new Stack<Integer>();
			for(int w:G.adj[v]){
				reverse.push(w);
			}
			
			for(int w: reverse){
				adj[v].add(w);
			}
		}
	}
	
	public Digraph(In in) {
        try {
            this.V = in.readInt();
            if (V < 0) throw new IllegalArgumentException("Number of vertices in a Digraph must be nonnegative");
            indegree = new int[V];
            adj = (Bag<Integer>[]) new Bag[V];
            for (int v = 0; v < V; v++) {
                adj[v] = new Bag<Integer>();
            }
            int E = in.readInt();
            if (E < 0) throw new IllegalArgumentException("Number of edges in a Digraph must be nonnegative");
            for (int i = 0; i < E; i++) {
                int v = in.readInt();
                int w = in.readInt();
                addEdge(v, w); 
            }
        }
        catch (NoSuchElementException e) {
            throw new InputMismatchException("Invalid input format in Digraph constructor");
        }
    }
	
	public int V(){
		return V;
	}
	
	public int E(){
		return E;
	}
	
	public int outdegree(int v){
		validateVertex(v);
		return adj[v].size();
	}
	
	public int indegree(int v){
		validateVertex(v);
		return indegree[v];
	}
	
	public void addEdge(int v, int w){
		validateVertex(v);
		validateVertex(w);
		adj[v].add(w);
		indegree[w]++;
		E++;
	}
	
	public Iterable<Integer> adj(int v){
		validateVertex(v);
		return adj[v];
	}
	
    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IndexOutOfBoundsException("vertex " + v + " is not between 0 and " + (V-1));
    }
	
	public Digraph reverse(){
		Digraph R = new Digraph(V);
		for(int v=0; v<V; v++){
			for(int w : adj(v)){
				R.addEdge(w, v);
			}
		}
		return R;
	}
}
