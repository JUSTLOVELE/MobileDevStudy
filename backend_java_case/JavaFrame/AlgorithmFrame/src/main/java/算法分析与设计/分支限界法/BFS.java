 package 算法分析与设计.分支限界法;

import 数据结构.Graph;
import 数据结构.Graph.ColorEnum;
import 数据结构.Node;
import 算法第四版.ch01.基础.Queue;

 /**
  * 广度优先搜索,按照范围大的来,也就是先扩大一点的范围,没得扩展了,再换下一个
  * @author Administrator
  *
  */
public class BFS {
	
	/**
	 * BFS搜索
	 * @param G
	 * @param s : 第几个节点为源节点
	 */
	public static void BFS_QUERY(Graph G, int s){
		 //将所有的节点都置为白色,白色表示没有到过的点
		 for(int i=0; i<G.vList.size(); i++){
			 G.vList.get(i).color = ColorEnum.WHITE;
		 }
		 //初始化源节点为灰色,灰色表示到过但有可能没有全部搜索完的点
		 Node firstNode = G.vList.get(s-1);
		 firstNode.color = ColorEnum.GRAY;
		 Queue<Node> queue = new Queue<Node>();
		 queue.enqueue(firstNode);
		 System.out.println("从" + firstNode.name + "开始:");
		 while(!queue.isEmpty()){
			 Node u = queue.dequeue();
			 for(Node n : u.list){
				//白色表示没有搜索过
				 if(n.color == ColorEnum.WHITE){
					 n.color = ColorEnum.GRAY;
					 n.pioneer = u;
					 n.d = u.d + 1;
					 System.out.println(n.name);
					 queue.enqueue(n);
				 }
			 }
			 u.color = ColorEnum.BLACK;
		 }
	}

	
	public static void main(String[] args) {
		
		Node n1 = new Node(1, "第一个节点");
		Node n2 = new Node(2, "第二个节点");
		Node n3 = new Node(3, "第三个节点");
		Node n4 = new Node(4, "第四个节点");
		Node n5 = new Node(5, "第五个节点");
		
		n1.list.add(n2);
		n1.list.add(n3);
		n1.list.add(n4);
		
		n2.list.add(n1);
		n2.list.add(n3);
		
		n3.list.add(n1);
		n3.list.add(n2);
		n3.list.add(n4);
		
		n4.list.add(n1);
		n4.list.add(n3);
		n4.list.add(n5);
		
		n5.list.add(n3);
		n5.list.add(n4);
		
		Graph G = new Graph();
		G.vList.add(n1);
		G.vList.add(n2);
		G.vList.add(n3);
		G.vList.add(n4);
		G.vList.add(n5);
		G.V = 5;
		G.E = 7;
		
		BFS_QUERY(G, 1);
	}
}
