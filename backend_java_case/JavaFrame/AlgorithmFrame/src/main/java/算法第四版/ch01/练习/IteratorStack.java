package 算法第四版.ch01.练习;

import java.util.Iterator;

/**
 * 编写一个可迭代的Stack用例,它含有一个静态的copy()方法,
 * 接受一个字符串的栈作为参数并返回该站的一个副本
 * @author yangzuliang
 *
 * @param <Item>
 */
public class IteratorStack<Item> implements Iterable<Item> {
	
	private class Node{
		
		Item item;
		Node next;
	}
	
	private Node first;
	private int N;
	
	/**
	 * 接收一个栈作为参数返回一个栈的副本
	 */
	public static IteratorStack<String> copy(IteratorStack<String> paramStack){
		
		IteratorStack<String> iteratorStack = new IteratorStack<String>();
		
		while(!paramStack.isEmpty()){
			
			iteratorStack.push(paramStack.pop());
		}
		
		return iteratorStack;
	}
	
	public boolean isEmpty(){
		
		return first == null;
	}
	
	public int size(){
		
		return N;
	}
	
	public void push(Item item){
		
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		N++;
	}
	
	public Item peek(){
		
		if(!isEmpty()){
			
			return  first.item;
		}else{
			
			return null;
		}
	}
	
	public Item pop(){
		
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
