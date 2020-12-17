package �㷨���İ�.ch01.����;

import java.util.Iterator;

/**
 * ��̬���������С
 * @author Administrator
 *
 */
public class ResizingArrayStack<Item> implements Iterable<Item> {
	
	
	private Item[] a = (Item[]) new Object[1];//栈元�?
	
	private int N = 0;
	
	public boolean isEmpty(){
		
		return N == 0;
	}
	
	public int size(){
		
		return N;
	}
	
	public void resize(int max){
		
		Item[] temp = (Item[]) new Object[max];
		
		for(int i=0; i<N; i++){
			temp[i] = a[i];
    	}
		
		a = temp;
	}
	
    public void push(Item item){
		
		if(N == a.length){
			resize(2*a.length);
		}
		a[N++] = item;
	}
	
	public Item pop(){
		
		Item item = a[--N];
		//使对象游�?java的垃圾收集策略是回收�?��无法被访问的对象的内�?在我们对pop()的实现中,
		//被弹出的元素的引用仍然存在于数组�?这个元素实际上已经是�?��孤儿�?-它永远也不会再被访问
		//但Java的垃圾收集器没法知道这一�?除非该引用被覆盖,即使用例已经不再�?��这个元素�?
		//数组中的引用仍然可以让它继续存在,这种情况(保存�?��不需要的对应的引�?称为游离
		a[N] = null;
		if(N>0 && N == a.length/4){
			resize(a.length/2);
		}
		
		return item;
	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ReverseArrayIterator();
	}
	
	private class ReverseArrayIterator implements Iterator<Item> {

		private int i = N;
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return i>0;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			return a[--i];
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}

}
