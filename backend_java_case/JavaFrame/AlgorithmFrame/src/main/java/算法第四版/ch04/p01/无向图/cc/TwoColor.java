package 算法第四版.ch04.p01.无向图.cc;

import 算法第四版.ch04.p01.无向图.Graph;

/**
 * 能够用两种颜色将图的所有顶点着色,使得任意一条边的两个端点的颜色都不相同吗?
 * 也就是二分图问题
 * @author yangzuliang
 *
 */
public class TwoColor {

	private boolean[] marked;
	private boolean[] color;
	private boolean isTwoColorable =  true;
	
	public TwoColor(Graph G){
		
		marked = new boolean[G.V()];
		color = new boolean[G.V()];
		
		for(int s=0; s<G.V(); s++){
			
			if(!marked[s]){
				
				dfs(G, s);
			}
		}
	}
	
	private void dfs(Graph G, int v){
		
		marked[v] = true;
		
		for(int w: G.adj(v)){
			
			if(!marked[w]){
				color[w] = !color[v];
				dfs(G, w);
			}else if(color[w] == color[v]){
				isTwoColorable = false;
			}
		}
	}
	
	public boolean isBipartite(){
		return isTwoColorable;
	}
}
