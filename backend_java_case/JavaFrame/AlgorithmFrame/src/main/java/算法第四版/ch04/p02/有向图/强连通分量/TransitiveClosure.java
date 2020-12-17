package �㷨���İ�.ch04.p02.����ͼ.ǿ��ͨ����;

import java.io.File;

import �㷨���İ�.ch04.p02.����ͼ.Digraph;
import �㷨���İ�.ch04.p02.����ͼ.DirectedDFS;
import �㷨���İ�.����.In;

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
		
		In in = new In(new File(System.getProperty("user.dir") + "\\src\\�㷨���İ�\\ch04\\p01\\����ͼ\\tinyG.txt"));
		Digraph G = new Digraph(in);
		TransitiveClosure tc = new TransitiveClosure(G);
	}
}
