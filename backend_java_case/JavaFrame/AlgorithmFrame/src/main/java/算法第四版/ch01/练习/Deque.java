package 算法第四版.ch01.练习;

import java.util.Iterator;

/**
 * 提高题 实现一个双向队列和栈或队列类似,但同时支持在两端添加或删除元素
 * 
 * @author yangzuliang
 * 
 * @param <Item>
 */
public class Deque<Item> implements Iterable<Item> {

	private class Node {

		Item item;
		Node nextNode;

		public Node(Item item) {
			this.item = item;
		}
	}

	private int N;

	private Node firstNode;

	private Node endNode;

	/**
	 * 左端是队头: 左端插入
	 * 
	 * @param item
	 */
	public void pushLeft(Item item) {

		Node node = firstNode;
		firstNode = new Node(item);
		firstNode.nextNode = node;
		N++;
	}

	/**
	 * 右端是队尾 右端插入
	 * 
	 * @param item
	 */
	public void pushRight(Item item) {

		if (endNode != null) {

			Node node = new Node(item);
			endNode.nextNode = node;
			N++;

		} else {
			initEndNode(item);
		}
	}

	private void initEndNode(Item item) {

		Node node = firstNode;

		while (node.nextNode != null) {

			node = node.nextNode;
		}

		Node n = new Node(item);
		node.nextNode = n;
		N++;
	}

	/**
	 * 弹出队头
	 * 
	 * @return
	 */
	public Item popLeft() {

		if (firstNode != null) {

			N--;

			return firstNode.item;
		}

		return null;
	}

	/**
	 * 弹出队尾
	 * 
	 * @return
	 */
	public Item popRight() {

		if (firstNode != null) {

			if (endNode == null) {

				Node node = firstNode;

				while (node.nextNode != null) {

					node = node.nextNode;
				}

				endNode = node;
			}
			
			Item result = endNode.item;
			endNode = null;
			N--;
			
			return result;
		}

		return null;
	}

	public boolean isEmpty() {

		return N == 0;
	}

	public int size() {

		return N;
	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {

	}
}
