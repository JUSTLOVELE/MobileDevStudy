package 算法第四版.ch04.p01.无向图.bfs;

import 算法第四版.ch04.p01.无向图.Graph;
import 算法第四版.基础.Queue;
import 算法第四版.基础.Stack;
import 算法第四版.基础.StdOut;
/**
 *   对于从s可达的任意顶点v,广度优先搜索都能找到一条从s到v的最短路径(没有其他从s到v的路径所含的边比这条路径更少)
 *   广度优先搜索所需的时间在最坏情况下和V+E成正比
 * @author yangzuliang
 *
 */
public class BreadthFirstPaths {

	private static final int INFINITY = Integer.MAX_VALUE;
	private boolean[] marked;//到达该顶点的最短路径已知吗
	private int[] edgeTo;//到达该顶点的已知路径上的最后一个顶点
	private int[] distTo;//distTo[v] = number of edges shortest s-v path
	//private final int s; //起点
	
	public BreadthFirstPaths(Graph G, int s){
		
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		distTo = new int[G.V()];
		//this.s = s;
		bfs(G, s);
	}
	
	public BreadthFirstPaths(Graph G, Iterable<Integer> source){
		
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		distTo = new int[G.V()];
		//this.s = s;
		for(int v=0; v<G.V(); v++){
			distTo[v] = INFINITY;
		}
		bfs(G, source);
	}
	
	/**
	 * 将起点存入数据结构中,然后重复做下列工作:
	 *   1.取其中的下一个顶点并标记它
	 *   2.将v的所有相邻而又未被标记的顶点加入数据结构
	 * @param G
	 * @param s
	 */
	private void bfs(Graph G, int s){
		
		Queue<Integer> queue = new Queue<Integer>();
		
		for(int v=0; v<G.V(); v++){
			distTo[v] = INFINITY;
		}
		
		distTo[s] = 0;
		marked[s] = true;//标记起点
		queue.enqueue(s);//将它加入队列
		
		while(!queue.isEmpty()){
			
			int v = queue.dequeue();//从队列中删去下一顶点
			
			for(int w:G.adj(v)){
				
				if(!marked[w]){//对于每个未被标记的相邻顶点
					
					edgeTo[w] = v;//保存最短路径的最后一条边
					marked[w] = true;//标记它,因为最短路径已知
					distTo[w] = distTo[v] + 1;
					queue.enqueue(w);//并将它添加到队列中
				}
			}
		}
	}
	
	public void bfs(Graph G, Iterable<Integer> source){
		
		Queue<Integer> q = new Queue<Integer>();
		
		for(int s : source){
			marked[s] = true;
			distTo[s] = 0;
			q.enqueue(s);
		}
		
		while(!q.isEmpty()){
			
			int v = q.dequeue();
			
			for(int w : G.adj(v)){
				
				if(!marked[w]){
					
					edgeTo[w] = v;
					distTo[w] = distTo[v] + 1;
					marked[w] = true;
					q.enqueue(w);
				}
			}
		}
	}
	
	public boolean hasPathTo(int v){
		return marked[v];
	}
	
	public int distTo(int v){
		return distTo[v];
	}
	
	public Iterable<Integer> pathTo(int v){
		
		if(!hasPathTo(v))
			return null;
		
		Stack<Integer> path = new Stack<Integer>();
		int x;
		
		for(x=v; distTo[x]!=0; x=edgeTo[x]){
			
			path.push(x);
		}
		
		path.push(x);
		
		return path;
	}
	
	 // check optimality conditions for single source
    private boolean check(Graph G, int s) {

        // check that the distance of s = 0
        if (distTo[s] != 0) {
            StdOut.println("distance of source " + s + " to itself = " + distTo[s]);
            return false;
        }

        // check that for each edge v-w dist[w] <= dist[v] + 1
        // provided v is reachable from s
        for (int v = 0; v < G.V(); v++) {
            for (int w : G.adj(v)) {
                if (hasPathTo(v) != hasPathTo(w)) {
                    StdOut.println("edge " + v + "-" + w);
                    StdOut.println("hasPathTo(" + v + ") = " + hasPathTo(v));
                    StdOut.println("hasPathTo(" + w + ") = " + hasPathTo(w));
                    return false;
                }
                if (hasPathTo(v) && (distTo[w] > distTo[v] + 1)) {
                    StdOut.println("edge " + v + "-" + w);
                    StdOut.println("distTo[" + v + "] = " + distTo[v]);
                    StdOut.println("distTo[" + w + "] = " + distTo[w]);
                    return false;
                }
            }
        }

        // check that v = edgeTo[w] satisfies distTo[w] = distTo[v] + 1
        // provided v is reachable from s
        for (int w = 0; w < G.V(); w++) {
            if (!hasPathTo(w) || w == s) continue;
            int v = edgeTo[w];
            if (distTo[w] != distTo[v] + 1) {
                StdOut.println("shortest path edge " + v + "-" + w);
                StdOut.println("distTo[" + v + "] = " + distTo[v]);
                StdOut.println("distTo[" + w + "] = " + distTo[w]);
                return false;
            }
        }

        return true;
    }
}
