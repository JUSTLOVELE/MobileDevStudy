package �㷨���İ�.ch04.p01.����ͼ.��ϰ;

import java.io.File;
import java.util.Iterator;

import �㷨���İ�.ch04.p01.����ͼ.Graph;
import �㷨���İ�.ch04.p01.����ͼ.cc.Cycle;
import �㷨���İ�.����.In;

/**
 * �޸�Graph,���������ƽ�бߺ��Ի�
 * �Ի�:��һ������һ�������������ı�
 * ƽ�б�:����ͬһ�Զ���������߳�Ϊƽ�б�
 * @author yangzuliang
 *
 */
public class Ex_4_1_05 {

	public static void main(String[] args) {
		
		In in = new In(new File(System.getProperty("user.dir") + "\\src\\�㷨���İ�\\ch04\\p01\\����ͼ\\tinyG.txt"));
		Graph graph = new Graph(in);
		Cycle cycle = new Cycle(graph);
		System.out.println(cycle.hasCycle());
		Iterator<Integer> it = cycle.cycle().iterator();
		
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}
