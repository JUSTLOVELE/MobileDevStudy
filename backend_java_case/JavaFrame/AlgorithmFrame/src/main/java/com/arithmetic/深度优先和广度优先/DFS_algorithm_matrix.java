package com.arithmetic.������Ⱥ͹������;
/**
 * ������������Ǿ������������һ��ͼ������һ���·��ֵĽڵ㣬��������Դ�Ϊ��㻹δ̽�⵽�ıߣ����ش˱�̽����ȥ
 * ������v�����б߶���̽Ѱ�������������ݵ����ֶ���v����ʼ�����Щ�ߡ���һ����һֱ���е�һ���ִ�ԭ��ɴ�����е�Ϊֹ
 * @author yangzuliang
 * ˼��:
 * �ڽӾ����˷��˴����Ŀռ�,ʵ�ʱ��ֻҪ��һ��Ŀռ�����,��Ϊ��ͼ��Ϊ�ڽӾ����,�ô��������������ʵ����ֻҪһ��Ŀռ���㹻����ͼ��ͼ֮�����ϵ��
 *
 */
public class DFS_algorithm_matrix {
	
	private class MGraph {
		/**�����**/
		public Object[] vertices;
		/**�ڽӾ���**/
		public int[][] arcs;
		/**������**/
		public int numVertexes; 
		/**����**/
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
	
	/**�Ƿ񱻷��ʹ�**/
	public boolean[] visited;
	
	/**
	 * �ڽӾ������ȱ���
	 * @param G
	 */
	public void DFSTraverse(MGraph G){
		
		visited = new boolean[G.numVertexes];
		for(int i=0; i<G.numVertexes; i++){
			
			visited[i] = false;//����û�����ʹ�
		}
		
		for(int i=0; i<G.numVertexes; i++){
			
			if(!visited[i]){
				//û���ʹ��ĵ���DFS
				DFS(G, i);
			}
		}
		
	}
	
	/**
	 * �ݹ������ȱ���
	 * @param G
	 * @param i
	 */
	public void DFS(MGraph G, int i){
		//��ӡ����
		System.out.print(G.vertices[i]);
		//���øýڵ��Ѿ����ʹ���
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
