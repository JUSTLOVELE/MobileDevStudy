package 算法第四版.ch04.p02.有向图;

/**
 * 是否存在一条从s到达给定顶点v的有向路径
 * 在有向图中,深度优先搜索标记由一个集合的顶点可达的所有顶点所需的时间与被标记的所有顶点的出度之和成正比
 * @author yangzuliang
 *
 */
public class DirectedDFS {

	private boolean[] marked;
	private int count;
	
	public DirectedDFS(Digraph G, int s){
		marked = new boolean[G.V()];
		dfs(G, s);
	}
	
	public DirectedDFS(Digraph G, Iterable<Integer> sources){
		marked = new boolean[G.V()];
		for(int s: sources){
			if(!marked[s]){
				dfs(G, s);
			}
		}
	}
	
	public int count(){
		return count;
	}
	
	private void dfs(Digraph G, int v){
		count++;
		marked[v] = true;
		for(int w: G.adj(v)){
			if(!marked[w]){
				dfs(G, w);
			}
		}
	}
	
	public boolean marked(int v){
		return marked[v];
	}
}
