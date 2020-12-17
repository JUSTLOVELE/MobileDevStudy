package algorithm.part.I.work_2;

import java.util.Iterator;

/**
 * Corner cases. Throw a java.lang.IllegalArgumentException if the client
 * attempts to add a null item; throw a java.util.NoSuchElementException if the
 * client attempts to remove an item from an empty deque; throw a
 * java.lang.UnsupportedOperationException if the client calls the remove()
 * method in the iterator; throw a java.util.NoSuchElementException if the
 * client calls the next() method in the iterator and there are no more items to
 * return.
 * 
 * Performance requirements. Your deque implementation must support each deque
 * operation (including construction) in constant worst-case time. A deque
 * containing n items must use at most 48n + 192 bytes of memory and use space
 * proportional to the number of items currently in the deque. Additionally,
 * your iterator implementation must support each operation (including
 * construction) in constant worst-case time.
 * 
 * @author 69410
 * 
 * @param <Item>
 */
public class Deque<Item> implements Iterable<Item> {

	private class Node {
		Item item;
		Node pre;
		Node next;
	}

	private Node first, last;
	private int N = 0;

	private class ListIterator implements Iterator<Item> {
		
		private Node current = first;

		public boolean hasNext() {
			return current != null;
		}

		public void remove() {
			throw new java.lang.UnsupportedOperationException();
		}

		public Item next() {
			if (!hasNext())
				throw new java.util.NoSuchElementException();
			Item item = current.item;
			current = current.next;
			return item;
		}
	}

	@Override
	public Iterator<Item> iterator() {

		return new ListIterator();
	}

	/**
	 * remove and return the item from the end
	 * 
	 * @return
	 */
	public Item removeLast() {

		if (isEmpty()) {
			throw new java.util.NoSuchElementException();
		}

		Item item = (Item) last.item;
		Node node = last;
		last = last.pre;
		node = null;
		N--;

		if (isEmpty()) {
			first = null;
		} else {
			last.next = null;
		}

		return item;
	}

	/**
	 * remove and return the item from the front
	 * 
	 * @return
	 */
	public Item removeFirst() {

		if (isEmpty()) {
			throw new java.util.NoSuchElementException();
		}

		Item item = (Item) first.item;
		Node node = first;
		first = first.next;
		node = null;
		N--;

		if (isEmpty()) {
			last = null;
		} else {
			first.pre = null;
		}

		return item;
	}

	/**
	 * add the item to the front
	 * 
	 * @param item
	 */
	public void addFirst(Item item) {

		if (item == null) {
			throw new java.lang.NullPointerException();
		}

		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;

		if (isEmpty()) {
			last = first;
		} else {
			oldfirst.pre = first;
		}

		N++;
	}

	/**
	 * construct an empty deque
	 */
	public Deque() {
		first = null;
		last = null;
		N = 0;
	}

	/**
	 * add the item to the end
	 * 
	 * @param item
	 */
	public void addLast(Item item) {

		if (item == null) {
			throw new java.lang.NullPointerException();
		}

		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.pre = oldlast;

		if (isEmpty()) {
			first = last;
		} else {
			oldlast.next = last;
		}

		N++;
	}

	/**
	 * is the deque empty?
	 * 
	 * @return
	 */
	public boolean isEmpty() {

		if (N == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * return the number of items on the deque
	 * 
	 * @return
	 */
	public int size() {

		return N;
	}

	/**
	 * unit testing (optional)
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Deque<Integer> deque = new Deque<Integer>();
		deque.addFirst(5);
		deque.addFirst(6);
		deque.addFirst(7);
		deque.addFirst(8);
		deque.addFirst(9);
		deque.addLast(4);
		deque.addLast(3);
		deque.addLast(2);
		deque.addLast(1);
		System.out.println(deque.removeFirst());
		System.out.println(deque.removeLast());
		Iterator<Integer> it = deque.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}

	}
}
