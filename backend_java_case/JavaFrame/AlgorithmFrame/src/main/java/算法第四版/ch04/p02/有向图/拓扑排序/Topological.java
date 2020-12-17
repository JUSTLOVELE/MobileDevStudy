package 算法第四版.ch04.p02.有向图.拓扑排序;

import 算法第四版.ch04.p02.有向图.Digraph;
import 算法第四版.ch04.p02.有向图.DirectedCycle;

/**
 * 拓扑排序
 *   优先级限制下的调度问题等价于计算有向无环图中的所有顶点的拓扑排序
 *   当且仅当有一幅有向图是无环图时它才能进行拓扑排序
 *   我们将学习能够计算任意有向无环图的拓扑排序
 * 
 * 这个类返回一幅有向无环图的拓扑排序(使用深度优先搜索),在包含环时hasorder会返回false
 * 一幅有向无环图的拓扑排序即为所有顶点的逆后序排列
 * 
 *  耗费时间和V+E成正比
 * @author yangzuliang
 *
 */
public class Topological {

	private Iterable<Integer> order;
	
	private int[] rank;
	
	/**
	 * 1.指明任务和优先级条件
	 * 2.不断检测并去除有向图中的所有环,以确保存在可行方案
	 * 3.使用拓扑排序解决调度问题
	 * 类似地,调度方案的任何变动之后都需要再次检查是否存在环,然后再计算新的调度安排
	 * @param G
	 */
	public Topological(Digraph G){
		
		DirectedCycle cyclefinder = new DirectedCycle(G);
		
		if(!cyclefinder.hasCycle()){
			
			DepthFirstOrder dfs = new DepthFirstOrder(G);
			order = dfs.reversePost();
			rank = new int[G.V()];
			int i=0;
			
			for(int v:order){
				rank[v] = i++;
			}
		}
	}
	
   /* public Topological(EdgeWeightedDigraph G) {
        EdgeWeightedDirectedCycle finder = new EdgeWeightedDirectedCycle(G);
        if (!finder.hasCycle()) {
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversePost();
        }
    }*/
	
    private void validateVertex(int v) {
        int V = rank.length;
        if (v < 0 || v >= V)
            throw new IndexOutOfBoundsException("vertex " + v + " is not between 0 and " + (V-1));
    }
    
    public int rank(int v){
    	
    	validateVertex(v);
    	
    	if(hasOrder()){
    		return rank[v];
    	}else{
    		return -1;
    	}
    }
	
	public Iterable<Integer> order(){
		return order;
	}
	
	public boolean hasOrder(){
		return order != null;
	}
}
