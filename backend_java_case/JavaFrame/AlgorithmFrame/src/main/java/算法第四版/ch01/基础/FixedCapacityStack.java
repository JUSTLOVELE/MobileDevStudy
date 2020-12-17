package �㷨���İ�.ch01.����;

public class FixedCapacityStack<Item> {
	
	private Item[] a;
	
	private int N;
	
	public FixedCapacityStack(int cap){
		
		a = (Item[]) new Object[cap];
	}
	
	public boolean isEmpty(){
		
		return N == 0;
	}
	
	public int size(){
		
		return N;
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
	
	private void resize(int max){
		Item[] temp = (Item[]) new Object[max];
		for(int i=0; i<N; i++){
			temp[i] = a[i];
		}
		a = temp;
	}

}
