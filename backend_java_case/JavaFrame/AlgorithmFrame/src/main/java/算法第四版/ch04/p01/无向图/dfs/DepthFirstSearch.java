package 算法第四版.ch04.p01.无向图.dfs;

import java.io.File;
import java.util.Arrays;

import 算法第四版.ch04.p01.无向图.Graph;
import 算法第四版.基础.In;

/**
 * DFS
 * 要搜索一副图,只需要用一个递归方法来遍历所有顶点,在访问其中的一个顶点时:
 * 1.将 它标记为已访问
 * 2.递归的访问它的所有没有被标记过的邻居顶点
 * 
 * 命题A:深度优先搜索标记与七点连通的所有顶点所需的时间和顶点度数之和成正比
 * 
 *   算法遍历边和访问顶点的顺序与图的表示是有关的,而不只是与图的结构或是算法有关,因为深度优先搜索只会访问和起点连通的顶点,所以追踪算法dfs的轨迹
 *可能会比你想象的长一倍 
 * @author yangzuliang
 *
 */
public class DepthFirstSearch {

	private boolean[] marked;
	private int count;
	
	public static void main(String[] args) {
		
		In in = new In(new File(System.getProperty("user.dir") + "\\src\\算法第四版\\ch04\\p01\\无向图\\tinyG.txt"));
		Graph graph = new Graph(in);
		int node = 11;//从第几个开始搜索,打印为true的就是被搜索到的
		DepthFirstSearch dfs = new DepthFirstSearch(graph, node);
		System.out.println(Arrays.toString(dfs.marked));
		System.out.println(dfs.count);
	}
	
	public DepthFirstSearch(Graph G, int s){
		
		marked = new boolean[G.V()];
		dfs(G, s);
	}
	
	private void dfs(Graph G, int v){
		
		marked[v] = true;
		count++;
		
		for(int w:G.adj(v)){
			
			if(!marked(w)){
				
				dfs(G, w);
			}
		}
	}
	
	public int count(){
		return count;
	}
	
	public boolean marked(int w){
		
		return marked[w];
	}
	
}
