package 算法第四版.ch03.p01.符号表;

import 算法第四版.ch01.基础.Iterable;
import 算法第四版.ch01.基础.Queue;

/**
 * 顺序查找(基于无序链表)
 * @author yangzuliang
 * 
 * 向一个空表插入N个不同的键需要N*N/2次比较
 * 平均比较次数为:(1+2+3+....N)/N = (N+1)/2 ~ N/2
 * 这些分析完全证明了基于链表的实现以及顺序查找是非常低效的
 * @param <Key>
 * @param <Vlaue>
 */
public class SequentialSearchST<Key, Value> {

	private Node first;
	private class Node{
		Key key;
		Value val;
		Node next;
		public Node(Key key, Value val, Node next){
			this.key = key;
			this.val = val;
			this.next = next;
		}
	}
	
	public Value get(Key key){
		
		for(Node x=first; x != null; x = x.next){
			
			if(key.equals(x.key)){
				
				return x.val;
			}
		}
		
		return null;
	}
	
	/**
	 * 不允许出现重复的键,每次插入前都要查找一遍
	 * @param key
	 * @param val
	 */
	public void put(Key key, Value val){
		
		for(Node x= first; x != null; x = x.next){
			
			if(key.equals(x.key)){
				
				x.val = val;
				
				return ;
			}
		}
		
		first = new Node(key, val, first);
	}
	
	public Iterable<Key> keys(){
		
		if(first == null){
			return null;
		}
		
		Queue<Key> q = new Queue<Key>();
		q.enqueue(first.key);
		Node next = first.next;
		
		while(next !=null){
			
			q.enqueue(next.key);
			next = next.next;
		}
		
		return q;
	}
}
