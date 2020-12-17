package com.arithmetic.深度优先和广度优先;

/**
 * 广度优先搜索(BFS):邻接矩阵实现
 * 类似于图的层序遍历,
 * 层序遍历:
 *   从上到下按层次访问树,每一层单独输出一行,每一层要求访问的顺序为从左到右
 * @author yangzuliang
 *
 */
public class Breadth_First_Search_martix {
	
	/**是否被访问过**/
	public boolean[] visited;
	
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
		
		public int findObject(Object target){
			
			for(int i=0; i<vertices.length; i++){
				
				if(vertices[i].equals(target)){
					
					return i;
				}
			}
			
			return -1;
		}
	}
	
	public void BFSTraverse(MGraph graph){
		
		visited = new boolean[graph.numVertexes];
		
		for(int i=0; i<graph.numVertexes; i++){
			
			visited[i] = false;
		}
		//初始化辅助用的队列
		Queue<String> queue = new Queue<String>();
		
		for(int i=0; i<graph.numVertexes; i++){
			
			if(!visited[i]){
				
				visited[i] = true;
				System.out.print(graph.vertices[i] + "->");
				//顶点入队列
				queue.enqueue(String.valueOf(graph.vertices[i]));
				//队列有值
				while(!queue.isEmpty()){
					
					String u = queue.dequeue();
					i = graph.findObject(u);
					
					for(int j=0; j<graph.numVertexes; j++){
						//判断其他顶点若与当前顶点存在边且未访问过
						if(graph.arcs[i][j] == 1 && !visited[j]){
								
							visited[j] = true;
							System.out.print(graph.vertices[j] + " ");
							//将值入队
							queue.enqueue(String.valueOf(graph.vertices[j]));
						}
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		Breadth_First_Search_martix.MGraph graph = new Breadth_First_Search_martix().new MGraph(5);
		String[] vertices = { "A", "B", "C", "D", "E"};
		graph.vertices = vertices;
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 4);
		graph.addEdge(3, 4);
		
		Breadth_First_Search_martix breadth_First_Search_martix = new Breadth_First_Search_martix();
		breadth_First_Search_martix.BFSTraverse(graph);
	}

}
