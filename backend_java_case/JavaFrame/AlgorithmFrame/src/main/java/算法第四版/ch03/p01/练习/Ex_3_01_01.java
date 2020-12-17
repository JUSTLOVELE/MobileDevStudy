package 算法第四版.ch03.p01.练习;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import 算法第四版.ch01.基础.Queue;
import 算法第四版.ch03.p01.符号表.SequentialSearchST;

/**
 * 编写一段程序,创建一张符号表并建立字母成绩和数值分数对应关系,计算并打印GPA(字母成绩对应的分数的平均值)
 * A+ 4.33
 * A 4.00
 * ...
 * @author yangzuliang
 *
 */
public class Ex_3_01_01 {

	public static void main(String[] args) {
		
		SequentialSearchST<String, Double> searchST = new SequentialSearchST<String, Double>();
		searchST.put("A+", 4.33);
		searchST.put("A", 4.00);
		searchST.put("A-", 3.67);
		searchST.put("B+", 3.33);
		searchST.put("B", 3.00);
		searchST.put("B-", 2.67);
		searchST.put("C+", 2.33);
		searchST.put("C", 2.00);
		searchST.put("C-", 1.67);
		searchST.put("D", 1.00);
		searchST.put("F", 0.00);
		
		Queue<String> q = (Queue<String>) searchST.keys();
		Iterator<String> it = q.iterator();
		List<Double> list = new ArrayList<Double>();
		
		while(it.hasNext()){
			Double d = searchST.get(it.next());
			list.add(d);
		}
		
		Double d = 0.0;
		for(int i=0; i<list.size(); i++){
		    
			d += list.get(i);
		}
		
		System.out.println("GPA = " + d/list.size());
	}
}
