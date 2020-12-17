package 算法第四版.ch04.p01.无向图.cc;

import 算法第四版.ch04.p01.无向图.Graph;
import 算法第四版.基础.Stack;

/**
 * G是无环图吗(假设不存在自环或平行边)
 * @author yangzuliang
 *
 */
public class Cycle {

	private boolean[] marked;
	private int[] edgeTo;
	private Stack<Integer> cycle;
	
	public Cycle(Graph G){
		
		if(hasSelfLoop(G)) return;
		if(hasParallelEdges(G)) return;
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		
		for(int v=0; v<G.V(); v++){
			if(!marked[v]){
				dfs(G, -1, v);
			}
		}
	}
	
	private boolean hasSelfLoop(Graph G){
		
		for(int v=0; v<G.V(); v++){
			
			for(int w : G.adj(v)){
				
				if(v == w){
					
					cycle = new Stack<Integer>();
					cycle.push(v);
					cycle.push(v);
					return true;
				}
			}
		}
		
		return false;
	}
	
	private boolean hasParallelEdges(Graph G){
		
		marked = new boolean[G.V()];
		
		for(int v=0; v<G.V(); v++){
			
			for(int w:G.adj(v)){
				
				if(marked[w]){
					
					cycle = new Stack<Integer>();
					cycle.push(v);
					cycle.push(w);
					cycle.push(v);
					return true;
				}
				
				marked[w] = true;
			}
			
			for(int w:G.adj(v)){
				
				marked[w] = false;
			}
		}
		
		return false;
	}
	
	private void dfs(Graph G, int u, int v){
		
		marked[v] = true;
		
		for(int w : G.adj(v)){
			
			if(cycle != null) return;
			
			if(!marked[w]){
				edgeTo[w] = v;
				dfs(G, v, w);
			}else if(w != u){
				
				cycle = new Stack<Integer>();
				for(int x=v; x!=w; x=edgeTo[x]){
					cycle.push(x);
				}
				cycle.push(w);
				cycle.push(v);
			}
		/*	if(!marked[w]){
				dfs(G, v, w);
			}else if(w != u){
				hasCycle = true;
			}*/
		}
	}
	
	public boolean hasCycle(){
		return cycle != null;
	}
	
	public Iterable<Integer> cycle(){
		return cycle;
	}
}
