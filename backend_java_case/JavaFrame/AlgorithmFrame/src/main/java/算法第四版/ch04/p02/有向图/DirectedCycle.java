package �㷨���İ�.ch04.p02.����ͼ;

import java.io.File;

import �㷨���İ�.����.In;
import �㷨���İ�.����.Stack;

/**
 * �������ͼ���Ƿ��л�
 * onStack[]����ݹ�����ڼ�ջ�ϵ����ж���,�����ҵ�һ����v->w��w��ջ��ʱ,���ҵ���һ���ػ�
 * @author yangzuliang
 *
 */
public class DirectedCycle {

	private boolean[] marked;
	private int[] edgeTo;
	private boolean[] onStack;
	private Stack<Integer> cycle;
	
	public DirectedCycle(Digraph G){
		
		marked = new boolean[G.V()];
		onStack = new boolean[G.V()];
		edgeTo = new int[G.V()];
		
		for(int v=0; v<G.V(); v++){
			if(!marked[v] && cycle == null){
				dfs(G, v);
			}
		}
	}
	
	private void dfs(Digraph G, int v){
		onStack[v] = true;
		marked[v] = true;
		for(int w : G.adj(v)){
			if(cycle != null){
				return;
			}else if(!marked[w]){
				
				edgeTo[w] = v;
				dfs(G, w);
			}else if(onStack[w]){
				
				cycle = new Stack<Integer>();
				
				for(int x=v; x != w; x = edgeTo[x]){
					
					cycle.push(x);
				}
				cycle.push(w);
				cycle.push(v);
				assert check();
			}
		}
		onStack[v] = false;
	}
	
	public boolean hasCycle(){
		return cycle != null;
	}
	
	public Iterable<Integer> cycle(){
		return cycle;
	}
	
	private boolean check(){
		
		if(hasCycle()){
			
			int first = -1, last = -1;
			
			for(int v : cycle()){
				
				if(first == -1) first = v;
				last = v;
			}
			
			if(first != last){
				
				System.out.println("cycle begins with " + first + " and ends with " + first + "");
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		
		In in = new In(new File(System.getProperty("user.dir") + "\\src\\�㷨���İ�\\ch04\\p01\\����ͼ\\cycle.txt"));
		Digraph g = new Digraph(in);
		DirectedCycle d = new DirectedCycle(g);
		
		if(d.hasCycle()){
			for(int v : d.cycle()){
				System.out.print(v + " ");
			}
			System.out.println("\n ------");
		}else{
			System.out.println("no cycle");
		}

	}
}
