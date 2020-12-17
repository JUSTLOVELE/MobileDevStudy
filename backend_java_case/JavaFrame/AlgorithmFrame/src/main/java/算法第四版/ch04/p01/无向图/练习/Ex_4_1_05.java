package 算法第四版.ch04.p01.无向图.练习;

import java.io.File;
import java.util.Iterator;

import 算法第四版.ch04.p01.无向图.Graph;
import 算法第四版.ch04.p01.无向图.cc.Cycle;
import 算法第四版.基础.In;

/**
 * 修改Graph,不允许存在平行边和自环
 * 自环:即一条连接一个顶点和其自身的边
 * 平行边:连接同一对顶点的两条边称为平行边
 * @author yangzuliang
 *
 */
public class Ex_4_1_05 {

	public static void main(String[] args) {
		
		In in = new In(new File(System.getProperty("user.dir") + "\\src\\算法第四版\\ch04\\p01\\无向图\\tinyG.txt"));
		Graph graph = new Graph(in);
		Cycle cycle = new Cycle(graph);
		System.out.println(cycle.hasCycle());
		Iterator<Integer> it = cycle.cycle().iterator();
		
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}
