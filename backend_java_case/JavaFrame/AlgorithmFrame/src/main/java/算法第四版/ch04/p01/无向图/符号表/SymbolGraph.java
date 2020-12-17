package 算法第四版.ch04.p01.无向图.符号表;

import java.util.Arrays;
import java.util.Iterator;

import 算法第四版.ch04.p01.无向图.Graph;
import 算法第四版.基础.In;
import 算法第四版.基础.ST;

public class SymbolGraph {

	private ST<String, Integer> st; //符号名,索引
	private String[] keys;//索引,符号名
	private Graph G;//图

	/**
	 * 根据filename指定的文件构造图, 使用delim来分割顶点名
	 * 
	 * @param filename
	 * @param delim
	 */
	public SymbolGraph(String filename, String delim) {

		st = new ST<String, Integer>();
		In in = new In(filename);//第一遍

		while (in.hasNextLine()) {//构造索引

			String line = in.readLine();
			String[] a = line.split(delim);

			for (int i = 0; i < a.length; i++) {//为每个不同的字符关联一个索引

				if (!st.contains(a[i])) {

					st.put(a[i], st.size());
				}
			}
		}

		keys = new String[st.size()];//用来获得顶点名的反向索引是一个数组

		for (String name : st.keys()) {

			keys[st.get(name)] = name;
		}

		G = new Graph(st.size());
		in = new In(filename);//第二遍

		while (in.hasNextLine()) {//构造图

			String[] a = in.readLine().split(delim);//将每一行的顶点和该行的其他顶点相连
			int v = st.get(a[0]);
			
			for (int i = 1; i < a.length; i++) {

				G.addEdge(v, st.get(a[i]));
			}
		}
	}

	/**
	 * key是一个顶点吗
	 * 
	 * @param key
	 * @return
	 */
	public boolean contains(String key) {
		return st.contains(key);
	}

	/**
	 * key是一个索引吗
	 * 
	 * @param key
	 * @return
	 */
	public int index(String key) {
		return st.get(key);
	}

	/**
	 * 索引v的顶点名
	 * 
	 * @param v
	 * @return
	 */
	public String name(int v) {
		return keys[v];
	}

	/**
	 * 隐藏的Graph对象
	 * 
	 * @return
	 */
	public Graph G() {
		return G;
	}
	
	public static void main(String[] args) {
		
		String filename = System.getProperty("user.dir") + "\\src\\算法第四版\\ch04\\p01\\无向图\\routes.txt";
		String delim = "&";
	    SymbolGraph sg = new SymbolGraph(filename, delim);
	    Graph G = sg.G;
	    
	    //用户可以输入一个顶点名并得到该顶点相邻节点的列表
	    for(int w : G.adj(sg.index("PHX"))){
	    	System.out.println(sg.name(w));
	    }
	}
}
