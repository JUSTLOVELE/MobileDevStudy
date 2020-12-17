package com.arithmetic.������Ⱥ͹������;

/**
 * �����������(BFS):�ڽӾ���ʵ��
 * ������ͼ�Ĳ������,
 * �������:
 *   ���ϵ��°���η�����,ÿһ�㵥�����һ��,ÿһ��Ҫ����ʵ�˳��Ϊ������
 * @author yangzuliang
 *
 */
public class Breadth_First_Search_martix {
	
	/**�Ƿ񱻷��ʹ�**/
	public boolean[] visited;
	
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
		//��ʼ�������õĶ���
		Queue<String> queue = new Queue<String>();
		
		for(int i=0; i<graph.numVertexes; i++){
			
			if(!visited[i]){
				
				visited[i] = true;
				System.out.print(graph.vertices[i] + "->");
				//���������
				queue.enqueue(String.valueOf(graph.vertices[i]));
				//������ֵ
				while(!queue.isEmpty()){
					
					String u = queue.dequeue();
					i = graph.findObject(u);
					
					for(int j=0; j<graph.numVertexes; j++){
						//�ж������������뵱ǰ������ڱ���δ���ʹ�
						if(graph.arcs[i][j] == 1 && !visited[j]){
								
							visited[j] = true;
							System.out.print(graph.vertices[j] + " ");
							//��ֵ���
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
