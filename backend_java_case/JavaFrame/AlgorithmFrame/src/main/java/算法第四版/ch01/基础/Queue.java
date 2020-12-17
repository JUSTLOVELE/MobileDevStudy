package 算法第四版.ch01.基础;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class Queue<Item> implements Iterable<Item> {

	private static class Node<Item> {

		Item item;
		Node<Item> next;
	}
	
	private Node<Item> first;
	private Node<Item> last;
	private int N;
	
    public void clear(){
		first = null;
		last = null;
		N = 0;
	}
	
	public boolean isEmpty(){
		
		return first == null;
	}
	
	public int size(){
		
		return N;
	}
	
	public void enqueue(Item item){
		//表尾加元素
		Node<Item> oldlast = last;
		last = new Node<Item>();
		last.item = item;
		last.next = null;
		if(isEmpty()){
			first = last;
		}else{
			oldlast.next = last;
		}
		N++;
	}
	
	public Item dequeue(){
		//删除元素从表头
		Item item = first.item;
		first = first.next;
		if(isEmpty()){
			last = null;
		}
		N--;
		return item;
	}

	@Override
	public Iterator<Item> iterator() {
		
		return new ListIterator<Item>(first);
	}
	
	private class ListIterator<Item> implements Iterator<Item>{

		private Node<Item> current;
		
		public ListIterator(Node<Item> first){
			current = first;
		}
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current != null;
		}

		@Override
		public Item next() {
			
			if(!hasNext()){
				throw new NoSuchElementException();
			}
			Item item = current.item;
			current = current.next;
			return item;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException();
		}
	}
}
