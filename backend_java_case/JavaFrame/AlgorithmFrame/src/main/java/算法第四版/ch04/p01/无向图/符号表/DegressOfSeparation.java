package �㷨���İ�.ch04.p01.����ͼ.���ű�;

import �㷨���İ�.ch04.p01.����ͼ.Graph;
import �㷨���İ�.ch04.p01.����ͼ.bfs.BreadthFirstPaths;
import �㷨���İ�.����.StdIn;
import �㷨���İ�.����.StdOut;

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
