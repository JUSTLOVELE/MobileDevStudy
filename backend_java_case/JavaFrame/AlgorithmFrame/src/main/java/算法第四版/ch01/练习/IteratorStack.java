package �㷨���İ�.ch01.��ϰ;

import java.util.Iterator;

/**
 * ��дһ���ɵ�����Stack����,������һ����̬��copy()����,
 * ����һ���ַ�����ջ��Ϊ���������ظ�վ��һ������
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
	 * ����һ��ջ��Ϊ��������һ��ջ�ĸ���
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
