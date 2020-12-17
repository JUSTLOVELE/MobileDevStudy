package 算法第四版.ch04.p01.无向图.dfs;

import java.io.File;
import java.util.Arrays;
import java.util.Iterator;

import 算法第四版.ch04.p01.无向图.Graph;
import 算法第四版.基础.In;
import 算法第四版.基础.Stack;
/**
 * 使用深度优先搜索得到从给定起点到任意标记顶点的路径所需的时间与路径的长度成正比
 * @author yangzuliang
 *
 */
public class DepthFirstPaths implements Paths {
	
	
	private boolean[] marked;//这个顶点上调用过dfs()了吗
	private int[] edgeTo; //从起点到一个顶点的已知路径上的最后一个顶点
	private final int s;//起点
	
	public DepthFirstPaths(Graph G, int s){
		
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		dfs(G, s);
	}
	
	private void dfs(Graph G, int v){
		
		marked[v] = true;
		
		for(int w : G.adj(v)){
			
			if(!marked[w]){
				
				edgeTo[w] = v;
				dfs(G, w);
			}
		}
	}

	@Override
	public boolean hasPathTo(int v) {
		// TODO Auto-generated method stub
		return marked[v];
	}

	@Override
	public Iterable<Integer> pathTo(int v) {
		// TODO Auto-generated method stub
		if(!hasPathTo(v))
			return null;
		
		Stack<Integer> path = new Stack<Integer>();
		
		for(int x=v; x!=s; x=edgeTo[x]){
			
			path.push(x);
		}
		
		path.push(s);
		
		return path;
	}
	
	/**
	 * 深度优先记录的路径未必是最优路径,是跟读取的数据有关系的
	 * @param args
	 */
	public static void main(String[] args) {

		In in = new In(new File(System.getProperty("user.dir") + "\\src\\算法第四版\\ch04\\p01\\无向图\\tinyG.txt"));
		Graph graph = new Graph(in);
		int node = 5;// 从第几个开始搜索,打印为true的就是被搜索到的
		DepthFirstPaths dfs = new DepthFirstPaths(graph, node);
		Iterable<Integer> it = dfs.pathTo(11);
		
		if(it != null){
			
			Iterator<Integer> t = it.iterator();
			
			while (t.hasNext()) {
				
				System.out.println(t.next());
			}
		}else{
			
			System.out.println("not found");
		}
	}
}
