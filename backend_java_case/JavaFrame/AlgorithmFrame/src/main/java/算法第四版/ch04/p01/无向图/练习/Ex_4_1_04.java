package �㷨���İ�.ch04.p01.����ͼ.��ϰ;

import java.io.File;

import �㷨���İ�.ch04.p01.����ͼ.Graph;
import �㷨���İ�.����.In;
/**
 * ΪGraph���һ������hasEdge(int v, int w),���ͼ���б�v->w,��������true,���򷵻�false
 * @author yangzuliang
 *
 */
public class Ex_4_1_04 {

	public static void main(String[] args) {
		In in = new In(new File(System.getProperty("user.dir") + "\\src\\�㷨���İ�\\ch04\\p01\\����ͼ\\tinyG.txt"));
		Graph graph = new Graph(in);
		System.out.println(graph.hasEdge(0, 3));
		System.out.println(graph.toString());
	}
}
