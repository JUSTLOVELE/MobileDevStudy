package 算法第四版.ch04.p01.无向图.练习;

import java.io.File;

import 算法第四版.ch04.p01.无向图.Graph;
import 算法第四版.基础.In;
/**
 * 为Graph添加一个方法hasEdge(int v, int w),如果图含有边v->w,方法返回true,否则返回false
 * @author yangzuliang
 *
 */
public class Ex_4_1_04 {

	public static void main(String[] args) {
		In in = new In(new File(System.getProperty("user.dir") + "\\src\\算法第四版\\ch04\\p01\\无向图\\tinyG.txt"));
		Graph graph = new Graph(in);
		System.out.println(graph.hasEdge(0, 3));
		System.out.println(graph.toString());
	}
}
