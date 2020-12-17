 package �㷨���������.��֧�޽編;

import ���ݽṹ.Graph;
import ���ݽṹ.Graph.ColorEnum;
import ���ݽṹ.Node;
import �㷨���İ�.ch01.����.Queue;

 /**
  * �����������,���շ�Χ�����,Ҳ����������һ��ķ�Χ,û����չ��,�ٻ���һ��
  * @author Administrator
  *
  */
public class BFS {
	
	/**
	 * BFS����
	 * @param G
	 * @param s : �ڼ����ڵ�ΪԴ�ڵ�
	 */
	public static void BFS_QUERY(Graph G, int s){
		 //�����еĽڵ㶼��Ϊ��ɫ,��ɫ��ʾû�е����ĵ�
		 for(int i=0; i<G.vList.size(); i++){
			 G.vList.get(i).color = ColorEnum.WHITE;
		 }
		 //��ʼ��Դ�ڵ�Ϊ��ɫ,��ɫ��ʾ�������п���û��ȫ��������ĵ�
		 Node firstNode = G.vList.get(s-1);
		 firstNode.color = ColorEnum.GRAY;
		 Queue<Node> queue = new Queue<Node>();
		 queue.enqueue(firstNode);
		 System.out.println("��" + firstNode.name + "��ʼ:");
		 while(!queue.isEmpty()){
			 Node u = queue.dequeue();
			 for(Node n : u.list){
				//��ɫ��ʾû��������
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
		
		Node n1 = new Node(1, "��һ���ڵ�");
		Node n2 = new Node(2, "�ڶ����ڵ�");
		Node n3 = new Node(3, "�������ڵ�");
		Node n4 = new Node(4, "���ĸ��ڵ�");
		Node n5 = new Node(5, "������ڵ�");
		
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
