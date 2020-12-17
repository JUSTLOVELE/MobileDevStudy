package com.arithmetic.深度优先和广度优先;
/**
 * 深度优先搜索是尽可能深的搜索一个图，对于一个新发现的节点，如果还有以此为起点还未探测到的边，就沿此边探测下去
 * 当顶点v的所有边都被探寻过后，搜索将回溯到发现顶点v的起始点的那些边。这一过程一直进行到一发现从原点可达的所有点为止
 * @author yangzuliang
 * 思考:
 * 邻接矩阵浪费了大量的空间,实际编程只要用一半的空间足以,因为将图化为邻接矩阵后,用代码描述变的连接实际上只要一半的空间就足够描述图跟图之间的联系了
 *
 */
public class DFS_algorithm_matrix {
	
	private class MGraph {
		/**顶点表**/
		public Object[] vertices;
		/**邻接矩阵**/
		public int[][] arcs;
		/**顶点数**/
		public int numVertexes; 
		/**边数**/
		public int numEdges;
		
		public MGraph(int numVertexes){
			this.numVertexes = numVertexes;
			arcs = new int[numVertexes][numVertexes];
		}
		
		public void addEdge(int i, int j){
			
			if(i != j){
				
				arcs[i][j] = 1;
			}
		}
	}
	
	/**是否被访问过**/
	public boolean[] visited;
	
	/**
	 * 邻接矩阵的深度遍历
	 * @param G
	 */
	public void DFSTraverse(MGraph G){
		
		visited = new boolean[G.numVertexes];
		for(int i=0; i<G.numVertexes; i++){
			
			visited[i] = false;//设置没被访问过
		}
		
		for(int i=0; i<G.numVertexes; i++){
			
			if(!visited[i]){
				//没访问过的调用DFS
				DFS(G, i);
			}
		}
		
	}
	
	/**
	 * 递归调用深度遍历
	 * @param G
	 * @param i
	 */
	public void DFS(MGraph G, int i){
		//打印顶点
		System.out.print(G.vertices[i]);
		//设置该节点已经访问过了
		visited[i] = true;
		
		for(int j=0; j<G.numVertexes; j++){
			
			if(G.arcs[i][j] == 1 && !visited[j]){
				
				DFS(G, j);
			}
		}
	}
	
	public static void main(String[] args) {
		
		DFS_algorithm_matrix.MGraph graph = new DFS_algorithm_matrix().new MGraph(5);
		Character[] vertices = { 'A', 'B', 'C', 'D', 'E'};
		graph.vertices = vertices;
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 4);
		graph.addEdge(3, 4);
		
		DFS_algorithm_matrix dfs_algorithm = new DFS_algorithm_matrix();
		dfs_algorithm.DFSTraverse(graph);
	}

}
