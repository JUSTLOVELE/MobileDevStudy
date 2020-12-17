package 算法第四版.ch04.p02.有向图;

import java.io.File;

import 算法第四版.基础.In;
import 算法第四版.基础.Stack;

/**
 * 检测有向图中是否有环
 * onStack[]保存递归调用期间栈上的所有顶点,当它找到一条边v->w且w在栈中时,就找到了一条回环
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
		
		In in = new In(new File(System.getProperty("user.dir") + "\\src\\算法第四版\\ch04\\p01\\有向图\\cycle.txt"));
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
