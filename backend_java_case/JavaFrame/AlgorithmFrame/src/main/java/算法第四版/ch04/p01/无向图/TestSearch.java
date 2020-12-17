package �㷨���İ�.ch04.p01.����ͼ;

import �㷨���İ�.����.In;
import �㷨���İ�.����.StdOut;

public class TestSearch {

	public static void main(String[] args) {
		
		Graph G = new Graph(new In(args[0]));
		int s = Integer.parseInt(args[1]);
		Search search = new Search(G, s);
		
		for(int v=0; v<G.V(); v++){
			
			if(search.marked(v)){
				
				StdOut.print(v + "");
			}
		}
		
		StdOut.println();
		
		if(search.count() != G.V()){
			StdOut.print("Not ");
		}
		StdOut.println("Not connected");
	}
}
