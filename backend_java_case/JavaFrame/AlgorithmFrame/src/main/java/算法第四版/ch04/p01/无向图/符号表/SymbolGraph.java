package �㷨���İ�.ch04.p01.����ͼ.���ű�;

import java.util.Arrays;
import java.util.Iterator;

import �㷨���İ�.ch04.p01.����ͼ.Graph;
import �㷨���İ�.����.In;
import �㷨���İ�.����.ST;

public class SymbolGraph {

	private ST<String, Integer> st; //������,����
	private String[] keys;//����,������
	private Graph G;//ͼ

	/**
	 * ����filenameָ�����ļ�����ͼ, ʹ��delim���ָ����
	 * 
	 * @param filename
	 * @param delim
	 */
	public SymbolGraph(String filename, String delim) {

		st = new ST<String, Integer>();
		In in = new In(filename);//��һ��

		while (in.hasNextLine()) {//��������

			String line = in.readLine();
			String[] a = line.split(delim);

			for (int i = 0; i < a.length; i++) {//Ϊÿ����ͬ���ַ�����һ������

				if (!st.contains(a[i])) {

					st.put(a[i], st.size());
				}
			}
		}

		keys = new String[st.size()];//������ö������ķ���������һ������

		for (String name : st.keys()) {

			keys[st.get(name)] = name;
		}

		G = new Graph(st.size());
		in = new In(filename);//�ڶ���

		while (in.hasNextLine()) {//����ͼ

			String[] a = in.readLine().split(delim);//��ÿһ�еĶ���͸��е�������������
			int v = st.get(a[0]);
			
			for (int i = 1; i < a.length; i++) {

				G.addEdge(v, st.get(a[i]));
			}
		}
	}

	/**
	 * key��һ��������
	 * 
	 * @param key
	 * @return
	 */
	public boolean contains(String key) {
		return st.contains(key);
	}

	/**
	 * key��һ��������
	 * 
	 * @param key
	 * @return
	 */
	public int index(String key) {
		return st.get(key);
	}

	/**
	 * ����v�Ķ�����
	 * 
	 * @param v
	 * @return
	 */
	public String name(int v) {
		return keys[v];
	}

	/**
	 * ���ص�Graph����
	 * 
	 * @return
	 */
	public Graph G() {
		return G;
	}
	
	public static void main(String[] args) {
		
		String filename = System.getProperty("user.dir") + "\\src\\�㷨���İ�\\ch04\\p01\\����ͼ\\routes.txt";
		String delim = "&";
	    SymbolGraph sg = new SymbolGraph(filename, delim);
	    Graph G = sg.G;
	    
	    //�û���������һ�����������õ��ö������ڽڵ���б�
	    for(int w : G.adj(sg.index("PHX"))){
	    	System.out.println(sg.name(w));
	    }
	}
}
