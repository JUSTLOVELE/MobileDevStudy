package �㷨���İ�.ch04.p01.����ͼ.cc;

import java.io.File;

import �㷨���İ�.ch04.p01.����ͼ.Graph;
import �㷨���İ�.����.Bag;
import �㷨���İ�.����.In;
import �㷨���İ�.����.StdOut;

/**
 * 
 * ���������������һ��ֱ��Ӧ�þ����ҳ�һ��ͼ��������ͨ����
 * @author yangzuliang
 *
 */
public class CC {
	
	private boolean[] marked;
	private int[] id;
	private int[] size;
	private int count;

	/**
	 * Ԥ�����캯��
	 * @param G
	 */
	public CC(Graph G){
		
		marked = new boolean[G.V()];
		id = new int[G.V()];
		size = new int[G.V()];
		
		for(int s=0; s<G.V(); s++){
			
			if(!marked[s]){
				dfs(G, s);
				count++;
			}
		}
	}
	
	private void dfs(Graph G, int v){
		
		marked[v] = true;
		id[v] = count;
		size[count]++;
		
		for(int w:G.adj(v)){
			
			if(!marked[w]){
				dfs(G, w);
			}
		}
	}
	
	/**
	 * v��w��ͨ��
	 * @param v
	 * @param w
	 * @return
	 */
	public boolean connected(int v, int w){
		return id[v] == id[w];
	}
	
	public int size(int v){
		return size[id[v]];
	}
	
	/**
	 * ��ͨ������
	 * @return
	 */
	public int count(){
		return count;
	}
	
	/**
	 * v���ڵ���ͨ�����ı�ʶ��(0-count()-1)
	 * @param v
	 * @return
	 */
	public int id(int v){
		return id[v];
	}
	
	public static void main(String[] args) {
		
		File file = new File(System.getProperty("user.dir") + "\\src\\�㷨���İ�\\ch04\\p01\\����ͼ\\tinyG.txt");
		Graph G = new Graph(new In(file));
		CC cc = new CC(G);
		int M = cc.count();
		StdOut.println(M + " components");
		Bag<Integer>[] components = new Bag[M];
		
		for(int i=0; i<M; i++){
			components[i] = new Bag<Integer>();
		}
		
		for(int v=0; v<G.V(); v++){
			components[cc.id(v)].add(v);
		}
		
		for(int i=0; i<M; i++){
			for(int v : components[i]){
				StdOut.print(v + " ");
			}
			StdOut.println();
		}
	}
	
	
}
