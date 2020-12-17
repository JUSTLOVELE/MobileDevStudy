package �㷨���İ�.ch01.��ϰ;

import java.util.Iterator;

/**
 * ����� ʵ��һ��˫����к�ջ���������,��ͬʱ֧����������ӻ�ɾ��Ԫ��
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
	 * ����Ƕ�ͷ: ��˲���
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
	 * �Ҷ��Ƕ�β �Ҷ˲���
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
	 * ������ͷ
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
	 * ������β
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
