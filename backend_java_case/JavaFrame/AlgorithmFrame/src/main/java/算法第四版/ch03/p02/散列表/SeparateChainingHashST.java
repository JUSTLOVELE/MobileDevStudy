package 算法第四版.ch03.p02.散列表;

import 算法第四版.ch03.p01.符号表.SequentialSearchST;

/**
 * 基于拉链法的散列表(HashMap)
 *   碰撞处理,也就是处理两个或多个键的散列相同的情况,将大小为M的数组中的每个元素指向一条链表,链表中的每个节点都存储了散列值为该元素的索引的键值对
 *这种方法称为拉链法
 *  查找:1.根据散列值找到对应的链表;2.然后沿着链表顺序查找相应的键
 *  
 *  在实现基于拉链法的散列表时,我们的目标是选择适当的数组大小M,既不会因为空链表而浪费大量内存,也不会因为链表太长而在查找上浪费太多时间,
 *而拉链法的一个好处就是这并不是关键性的选择,如果存入的键多于预期,查找所需的时间只会比选择更大的数组稍长;如果少于预期,虽然有些空间浪费
 *但查找会非常快
 *
 *  散列的主要目的是均匀的将键散布开来,因此在计算散列后键的顺序信息就丢失了,因此找最大或最小键 或是某个范围速度都是一样快的
 *  
 *  
 * @author yangzuliang
 *
 * @param <Key>
 * @param <Value>
 */
public class SeparateChainingHashST<Key, Value> {

	private int N;
	private int M;
	private SequentialSearchST<Key, Value>[] st;
	
	public SeparateChainingHashST(){
		this(997);
	}
	
	public SeparateChainingHashST(int M){
		//创建M条链表
		this.M = M;
		st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
		for(int i=0; i<M; i++)
			st[i] = new SequentialSearchST<Key, Value>();
	}
	
	private int hash(Key key){
		return (key.hashCode() & 0x7ffffff)%M;
	}
	
	public Value get(Key key){
		return (Value) st[hash(key)].get(key);
	}
	
	public void put(Key key, Value val){
		st[hash(key)].put(key, val);
	}
	
	public Iterable<Key> keys(){
		return null;
	}
	
	public static void main(String[] args) {
		SeparateChainingHashST<String, String> st = new SeparateChainingHashST<String, String>();
		st.put("test", "value");
		String s = st.get("test");
		System.out.println(s);
	}
}
