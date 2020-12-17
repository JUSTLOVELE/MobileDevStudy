package 算法第四版.ch04.p01.无向图;

import java.io.File;

import 算法第四版.基础.In;

public class Search {
	
	/**
	 * 找到和起点s连通的所有顶点
	 * @param G
	 * @param s
	 */
	public Search(Graph G, int s){
		
	}
	
	/**
	 * v和s是连通的吗
	 * @param v
	 * @return
	 */
	public boolean marked(int v){
		return false;
	}
	
	/**
	 * 与s连通的顶点总数
	 * @return
	 */
	int count(){
		return 0;
	}
	
	public static void main(String[] args) {
		
		In in = new In(new File(System.getProperty("user.dir") + "\\src\\算法第四版\\ch04\\p01\\无向图\\tinyG.txt"));
		Graph graph = new Graph(in);
		//Search search = new Search(graph, s);
	}
}
