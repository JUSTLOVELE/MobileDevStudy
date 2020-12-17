package �㷨���İ�.ch04.p01.����ͼ.dfs;

import java.io.File;
import java.util.Arrays;
import java.util.Iterator;

import �㷨���İ�.ch04.p01.����ͼ.Graph;
import �㷨���İ�.����.In;
import �㷨���İ�.����.Stack;
/**
 * ʹ��������������õ��Ӹ�����㵽�����Ƕ����·�������ʱ����·���ĳ��ȳ�����
 * @author yangzuliang
 *
 */
public class DepthFirstPaths implements Paths {
	
	
	private boolean[] marked;//��������ϵ��ù�dfs()����
	private int[] edgeTo; //����㵽һ���������֪·���ϵ����һ������
	private final int s;//���
	
	public DepthFirstPaths(Graph G, int s){
		
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		dfs(G, s);
	}
	
	private void dfs(Graph G, int v){
		
		marked[v] = true;
		
		for(int w : G.adj(v)){
			
			if(!marked[w]){
				
				edgeTo[w] = v;
				dfs(G, w);
			}
		}
	}

	@Override
	public boolean hasPathTo(int v) {
		// TODO Auto-generated method stub
		return marked[v];
	}

	@Override
	public Iterable<Integer> pathTo(int v) {
		// TODO Auto-generated method stub
		if(!hasPathTo(v))
			return null;
		
		Stack<Integer> path = new Stack<Integer>();
		
		for(int x=v; x!=s; x=edgeTo[x]){
			
			path.push(x);
		}
		
		path.push(s);
		
		return path;
	}
	
	/**
	 * ������ȼ�¼��·��δ��������·��,�Ǹ���ȡ�������й�ϵ��
	 * @param args
	 */
	public static void main(String[] args) {

		In in = new In(new File(System.getProperty("user.dir") + "\\src\\�㷨���İ�\\ch04\\p01\\����ͼ\\tinyG.txt"));
		Graph graph = new Graph(in);
		int node = 5;// �ӵڼ�����ʼ����,��ӡΪtrue�ľ��Ǳ���������
		DepthFirstPaths dfs = new DepthFirstPaths(graph, node);
		Iterable<Integer> it = dfs.pathTo(11);
		
		if(it != null){
			
			Iterator<Integer> t = it.iterator();
			
			while (t.hasNext()) {
				
				System.out.println(t.next());
			}
		}else{
			
			System.out.println("not found");
		}
	}
}
