package 算法第四版.ch01.基础;

import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {
	
	private class Node{
		
		Item item;
		Node next;
	}
	
	private Node first;
	private int N;
	
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
