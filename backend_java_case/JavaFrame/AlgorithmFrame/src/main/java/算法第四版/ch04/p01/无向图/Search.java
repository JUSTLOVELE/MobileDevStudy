package �㷨���İ�.ch04.p01.����ͼ;

import java.io.File;

import �㷨���İ�.����.In;

public class Search {
	
	/**
	 * �ҵ������s��ͨ�����ж���
	 * @param G
	 * @param s
	 */
	public Search(Graph G, int s){
		
	}
	
	/**
	 * v��s����ͨ����
	 * @param v
	 * @return
	 */
	public boolean marked(int v){
		return false;
	}
	
	/**
	 * ��s��ͨ�Ķ�������
	 * @return
	 */
	int count(){
		return 0;
	}
	
	public static void main(String[] args) {
		
		In in = new In(new File(System.getProperty("user.dir") + "\\src\\�㷨���İ�\\ch04\\p01\\����ͼ\\tinyG.txt"));
		Graph graph = new Graph(in);
		//Search search = new Search(graph, s);
	}
}
