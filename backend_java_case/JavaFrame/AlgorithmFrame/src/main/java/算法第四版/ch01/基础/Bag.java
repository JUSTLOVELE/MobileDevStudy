package 算法第四版.ch01.基础;

import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {
	
	private class Node{
		Item item;
		Node next;
	}
	
	private Node first;
	
	public void add(Item item){
		
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
	}

	@Override
	public Iterator<Item> iterator() {

		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item>{
		
		private Node current = first;
		public boolean hasNext(){
			return current != null;
		}
		public void remove(){
			
		}
		public Item next(){
			Item item = current.item;
			current = current.next;
			return item;
		}
	}

}
