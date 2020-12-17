package �㷨���İ�.ch04.p01.����ͼ.dfs;

import java.io.File;
import java.util.Arrays;

import �㷨���İ�.ch04.p01.����ͼ.Graph;
import �㷨���İ�.����.In;

/**
 * DFS
 * Ҫ����һ��ͼ,ֻ��Ҫ��һ���ݹ鷽�����������ж���,�ڷ������е�һ������ʱ:
 * 1.�� �����Ϊ�ѷ���
 * 2.�ݹ�ķ�����������û�б���ǹ����ھӶ���
 * 
 * ����A:�����������������ߵ���ͨ�����ж��������ʱ��Ͷ������֮�ͳ�����
 * 
 *   �㷨�����ߺͷ��ʶ����˳����ͼ�ı�ʾ���йص�,����ֻ����ͼ�Ľṹ�����㷨�й�,��Ϊ�����������ֻ����ʺ������ͨ�Ķ���,����׷���㷨dfs�Ĺ켣
 *���ܻ��������ĳ�һ�� 
 * @author yangzuliang
 *
 */
public class DepthFirstSearch {

	private boolean[] marked;
	private int count;
	
	public static void main(String[] args) {
		
		In in = new In(new File(System.getProperty("user.dir") + "\\src\\�㷨���İ�\\ch04\\p01\\����ͼ\\tinyG.txt"));
		Graph graph = new Graph(in);
		int node = 11;//�ӵڼ�����ʼ����,��ӡΪtrue�ľ��Ǳ���������
		DepthFirstSearch dfs = new DepthFirstSearch(graph, node);
		System.out.println(Arrays.toString(dfs.marked));
		System.out.println(dfs.count);
	}
	
	public DepthFirstSearch(Graph G, int s){
		
		marked = new boolean[G.V()];
		dfs(G, s);
	}
	
	private void dfs(Graph G, int v){
		
		marked[v] = true;
		count++;
		
		for(int w:G.adj(v)){
			
			if(!marked(w)){
				
				dfs(G, w);
			}
		}
	}
	
	public int count(){
		return count;
	}
	
	public boolean marked(int w){
		
		return marked[w];
	}
	
}
