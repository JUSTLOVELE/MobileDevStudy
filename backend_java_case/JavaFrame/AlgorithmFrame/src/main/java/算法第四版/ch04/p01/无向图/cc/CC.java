package 算法第四版.ch04.p01.无向图.cc;

import java.io.File;

import 算法第四版.ch04.p01.无向图.Graph;
import 算法第四版.基础.Bag;
import 算法第四版.基础.In;
import 算法第四版.基础.StdOut;

/**
 * 
 * 深度优先搜索的下一个直接应用就是找出一幅图的所有连通分量
 * @author yangzuliang
 *
 */
public class CC {
	
	private boolean[] marked;
	private int[] id;
	private int[] size;
	private int count;

	/**
	 * 预处理构造函数
	 * @param G
	 */
	public CC(Graph G){
		
		marked = new boolean[G.V()];
		id = new int[G.V()];
		size = new int[G.V()];
		
		for(int s=0; s<G.V(); s++){
			
			if(!marked[s]){
				dfs(G, s);
				count++;
			}
		}
	}
	
	private void dfs(Graph G, int v){
		
		marked[v] = true;
		id[v] = count;
		size[count]++;
		
		for(int w:G.adj(v)){
			
			if(!marked[w]){
				dfs(G, w);
			}
		}
	}
	
	/**
	 * v和w连通吗
	 * @param v
	 * @param w
	 * @return
	 */
	public boolean connected(int v, int w){
		return id[v] == id[w];
	}
	
	public int size(int v){
		return size[id[v]];
	}
	
	/**
	 * 连通分量数
	 * @return
	 */
	public int count(){
		return count;
	}
	
	/**
	 * v所在的连通分量的标识符(0-count()-1)
	 * @param v
	 * @return
	 */
	public int id(int v){
		return id[v];
	}
	
	public static void main(String[] args) {
		
		File file = new File(System.getProperty("user.dir") + "\\src\\算法第四版\\ch04\\p01\\无向图\\tinyG.txt");
		Graph G = new Graph(new In(file));
		CC cc = new CC(G);
		int M = cc.count();
		StdOut.println(M + " components");
		Bag<Integer>[] components = new Bag[M];
		
		for(int i=0; i<M; i++){
			components[i] = new Bag<Integer>();
		}
		
		for(int v=0; v<G.V(); v++){
			components[cc.id(v)].add(v);
		}
		
		for(int i=0; i<M; i++){
			for(int v : components[i]){
				StdOut.print(v + " ");
			}
			StdOut.println();
		}
	}
	
	
}
