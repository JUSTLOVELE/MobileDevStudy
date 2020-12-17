package �㷨���İ�.ch03.p01.���ű�;

import �㷨���İ�.ch01.����.Iterable;
import �㷨���İ�.ch01.����.Queue;

/**
 * ˳�����(������������)
 * @author yangzuliang
 * 
 * ��һ���ձ����N����ͬ�ļ���ҪN*N/2�αȽ�
 * ƽ���Ƚϴ���Ϊ:(1+2+3+....N)/N = (N+1)/2 ~ N/2
 * ��Щ������ȫ֤���˻��������ʵ���Լ�˳������Ƿǳ���Ч��
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
	 * ����������ظ��ļ�,ÿ�β���ǰ��Ҫ����һ��
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
