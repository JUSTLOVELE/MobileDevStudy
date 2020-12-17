package 算法第四版.ch04.p01.无向图.符号表;

import 算法第四版.ch04.p01.无向图.Graph;
import 算法第四版.ch04.p01.无向图.bfs.BreadthFirstPaths;
import 算法第四版.基础.StdIn;
import 算法第四版.基础.StdOut;

public class DegressOfSeparation {

	public static void main(String[] args) {
		
		String filename = args[0];
		String delimiter = args[1];
		String source = args[2];

		SymbolGraph sg = new SymbolGraph(filename, delimiter);
		Graph G = sg.G();
		if (!sg.contains(source)) {
			System.out.println(source + " not in database.");
			return;
		}

		int s = sg.index(source);
		BreadthFirstPaths bfs = new BreadthFirstPaths(G, s);

		while (!StdIn.isEmpty()) {
			
			String sink = StdIn.readLine();
			if (sg.contains(sink)) {
				int t = sg.index(sink);
				if (bfs.hasPathTo(t)) {
					for (int v : bfs.pathTo(t)) {
						StdOut.println("   " + sg.name(v));
					}
				} else {
					StdOut.println("Not connected");
				}
			} else {
				StdOut.println("   Not in database.");
			}
		}
	}
}
