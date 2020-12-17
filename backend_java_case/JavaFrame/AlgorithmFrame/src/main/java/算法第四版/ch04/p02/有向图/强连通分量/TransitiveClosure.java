package 算法第四版.ch04.p02.有向图.强连通分量;

import java.io.File;

import 算法第四版.ch04.p02.有向图.Digraph;
import 算法第四版.ch04.p02.有向图.DirectedDFS;
import 算法第四版.基础.In;

public class TransitiveClosure {

	private DirectedDFS[] tc;
	
	public TransitiveClosure(Digraph G){
		tc = new DirectedDFS[G.V()];
		for(int v=0; v<G.V(); v++){
			tc[v] = new DirectedDFS(G, v);
		}
	}
	
	public boolean reachable(int v, int w){
		return tc[v].marked(w);
	}
	
	public static void main(String[] args) {
		
		In in = new In(new File(System.getProperty("user.dir") + "\\src\\算法第四版\\ch04\\p01\\无向图\\tinyG.txt"));
		Digraph G = new Digraph(in);
		TransitiveClosure tc = new TransitiveClosure(G);
	}
}
