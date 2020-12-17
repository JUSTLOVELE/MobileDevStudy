package 算法第四版.ch01.练习;

/**
 * 提高题：
 * 一个以栈为目标的队列,是一种支持push, pop, enqueue操作的数据类型
 * @author yangzuliang
 *
 */
public class Steque<Item> {
	
	private class Node{
		
		Item itme;
		Node next;
		
		public Node(Item item){
			this.itme = item;
		}
	}
	
	private Node firstNode;
	
	private Node endNode;
	
	private int N = 0;
	
	public void push(Item item){
		
		Node node = firstNode;
		firstNode = new Node(item);
		firstNode.next = node;
		N++;
	}
	
	public void enqueue(Item item){
		
		if(endNode == null){
			
			Node node = firstNode;
			
			while(node.next != null){
				
				node = node.next;
			}
			
			Node n = new Node(item);
			endNode = n;
			node.next = n;
			
		}else{
			Node node = new Node(item);
			endNode.next = node;
			endNode = node;
		}
		
	}
	
	public Item pop(){
		
		Node node = firstNode;
		
		if(node != null){
			
			firstNode = firstNode.next;
			N--;
			
			return node.itme;
		}
		
		return null;
	}
	
	public boolean isEmpty(){
		
		return firstNode == null;
	}
	
	public int size(){
		
		return N;
	}
	
	public static void main(String[] args) {
		
		Steque<Integer> steque = new Steque<Integer>();
		steque.push(1);
		steque.push(2);
		steque.enqueue(6);
		steque.push(3);
		steque.push(4);
		steque.push(5);
		
		while(!steque.isEmpty()){
			
			System.out.println(steque.pop());
		}
	}

}
