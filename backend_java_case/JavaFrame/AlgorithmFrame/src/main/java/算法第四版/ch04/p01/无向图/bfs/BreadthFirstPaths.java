package �㷨���İ�.ch04.p01.����ͼ.bfs;

import �㷨���İ�.ch04.p01.����ͼ.Graph;
import �㷨���İ�.����.Queue;
import �㷨���İ�.����.Stack;
import �㷨���İ�.����.StdOut;
/**
 *   ���ڴ�s�ɴ�����ⶥ��v,����������������ҵ�һ����s��v�����·��(û��������s��v��·�������ı߱�����·������)
 *   ����������������ʱ���������º�V+E������
 * @author yangzuliang
 *
 */
public class BreadthFirstPaths {

	private static final int INFINITY = Integer.MAX_VALUE;
	private boolean[] marked;//����ö�������·����֪��
	private int[] edgeTo;//����ö������֪·���ϵ����һ������
	private int[] distTo;//distTo[v] = number of edges shortest s-v path
	//private final int s; //���
	
	public BreadthFirstPaths(Graph G, int s){
		
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		distTo = new int[G.V()];
		//this.s = s;
		bfs(G, s);
	}
	
	public BreadthFirstPaths(Graph G, Iterable<Integer> source){
		
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		distTo = new int[G.V()];
		//this.s = s;
		for(int v=0; v<G.V(); v++){
			distTo[v] = INFINITY;
		}
		bfs(G, source);
	}
	
	/**
	 * �����������ݽṹ��,Ȼ���ظ������й���:
	 *   1.ȡ���е���һ�����㲢�����
	 *   2.��v���������ڶ���δ����ǵĶ���������ݽṹ
	 * @param G
	 * @param s
	 */
	private void bfs(Graph G, int s){
		
		Queue<Integer> queue = new Queue<Integer>();
		
		for(int v=0; v<G.V(); v++){
			distTo[v] = INFINITY;
		}
		
		distTo[s] = 0;
		marked[s] = true;//������
		queue.enqueue(s);//�����������
		
		while(!queue.isEmpty()){
			
			int v = queue.dequeue();//�Ӷ�����ɾȥ��һ����
			
			for(int w:G.adj(v)){
				
				if(!marked[w]){//����ÿ��δ����ǵ����ڶ���
					
					edgeTo[w] = v;//�������·�������һ����
					marked[w] = true;//�����,��Ϊ���·����֪
					distTo[w] = distTo[v] + 1;
					queue.enqueue(w);//��������ӵ�������
				}
			}
		}
	}
	
	public void bfs(Graph G, Iterable<Integer> source){
		
		Queue<Integer> q = new Queue<Integer>();
		
		for(int s : source){
			marked[s] = true;
			distTo[s] = 0;
			q.enqueue(s);
		}
		
		while(!q.isEmpty()){
			
			int v = q.dequeue();
			
			for(int w : G.adj(v)){
				
				if(!marked[w]){
					
					edgeTo[w] = v;
					distTo[w] = distTo[v] + 1;
					marked[w] = true;
					q.enqueue(w);
				}
			}
		}
	}
	
	public boolean hasPathTo(int v){
		return marked[v];
	}
	
	public int distTo(int v){
		return distTo[v];
	}
	
	public Iterable<Integer> pathTo(int v){
		
		if(!hasPathTo(v))
			return null;
		
		Stack<Integer> path = new Stack<Integer>();
		int x;
		
		for(x=v; distTo[x]!=0; x=edgeTo[x]){
			
			path.push(x);
		}
		
		path.push(x);
		
		return path;
	}
	
	 // check optimality conditions for single source
    private boolean check(Graph G, int s) {

        // check that the distance of s = 0
        if (distTo[s] != 0) {
            StdOut.println("distance of source " + s + " to itself = " + distTo[s]);
            return false;
        }

        // check that for each edge v-w dist[w] <= dist[v] + 1
        // provided v is reachable from s
        for (int v = 0; v < G.V(); v++) {
            for (int w : G.adj(v)) {
                if (hasPathTo(v) != hasPathTo(w)) {
                    StdOut.println("edge " + v + "-" + w);
                    StdOut.println("hasPathTo(" + v + ") = " + hasPathTo(v));
                    StdOut.println("hasPathTo(" + w + ") = " + hasPathTo(w));
                    return false;
                }
                if (hasPathTo(v) && (distTo[w] > distTo[v] + 1)) {
                    StdOut.println("edge " + v + "-" + w);
                    StdOut.println("distTo[" + v + "] = " + distTo[v]);
                    StdOut.println("distTo[" + w + "] = " + distTo[w]);
                    return false;
                }
            }
        }

        // check that v = edgeTo[w] satisfies distTo[w] = distTo[v] + 1
        // provided v is reachable from s
        for (int w = 0; w < G.V(); w++) {
            if (!hasPathTo(w) || w == s) continue;
            int v = edgeTo[w];
            if (distTo[w] != distTo[v] + 1) {
                StdOut.println("shortest path edge " + v + "-" + w);
                StdOut.println("distTo[" + v + "] = " + distTo[v]);
                StdOut.println("distTo[" + w + "] = " + distTo[w]);
                return false;
            }
        }

        return true;
    }
}
