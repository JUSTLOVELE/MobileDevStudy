package 算法第四版.ch03.p02.练习;

import 算法第四版.ch03.p02.散列表.LinearProbingHashST;

/**
 * 将键E A S Y Q U T I O N依次插入一张初始为空且含有M=5条链表的基于拉链法的散列表中
 * 使用散列函数11k%M将第k个字母散列到某个数组索引上
 * @author yangzuliang
 *
 */
public class Pactice_3_4_1 {

	public static void main(String[] args) {
		
		LinearProbingHashST<String, String> l = new LinearProbingHashST<String, String>(5);
		l.put("E", "E");
		l.put("A", "A");
		l.put("S", "S");
		l.put("Y", "Y");
		l.put("Q", "Q");
		l.put("U", "U");
		l.put("T", "T");
		l.put("I", "I");
		l.put("O", "O");
		l.put("N", "N");
		
		System.out.println(l.get("E"));
	}
}
